/*
 * Copyright 2014 Alessandro Falappa <alex.falappa@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package main.jetty;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import gui.TemplateModelCalculator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import main.App;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 *
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public class HmaCatHandler extends AbstractHandler {

    private final Template templateResults;
    private final Template templateHits;
    private TemplateModelCalculator tmc;
    private boolean collsFromReq = false;
    private boolean reqIsHits = false;
    private final ArrayList<String> reqColls = new ArrayList<>();
    private final XMLInputFactory fct;

    public HmaCatHandler(Template templateHits, Template templateResults) {
        this.templateResults = templateResults;
        this.templateHits = templateHits;
        // prepare the StAX factory
        fct = XMLInputFactory.newFactory();
        fct.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);
    }

    public void setTemplateCalculator(TemplateModelCalculator tmc) {
        this.tmc = tmc;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        baseRequest.setHandled(true);
        try {
            if (tmc == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            } else {
                try {
                    analyzeReq(request);
                } catch (XMLStreamException ex) {
                    throw new ServletException(ex.getMessage());
                }
                if (collsFromReq && !reqColls.isEmpty()) {
                    tmc.setCollectionFromRequest(reqColls);
                } else {
                    tmc.setCollectionFromRequest(null);
                }
                response.setContentType("application/xml");
                final Map model = tmc.calcModel();
                final int nRecs = ((List) model.get("records")).size();
                System.out.printf("Records %d%n", nRecs);
                App.metrics.counter("server.totalRecs").inc(nRecs);
                if (reqIsHits) {
                    templateHits.process(model, response.getWriter());
                } else {
                    templateResults.process(model, response.getWriter());
                }
                response.setStatus(HttpServletResponse.SC_OK);
            }
        } catch (TemplateException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    public void setCollectionFromRequest(boolean flag) {
        collsFromReq = flag;
    }

    private void analyzeReq(HttpServletRequest request) throws XMLStreamException, IOException {
        reqColls.clear();
        XMLEventReader xrd = fct.createXMLEventReader(request.getReader());
        while (xrd.hasNext()) {
            XMLEvent xev = xrd.nextEvent();
            while (!xev.isStartElement()) {
                if (!xrd.hasNext()) {
                    break;
                }
                xev = xrd.nextEvent();
            }
            if (!xrd.hasNext()) {
                break;
            }
            final StartElement element = xev.asStartElement();
            String tagName = element.getName().getLocalPart();
            if (tagName.contains("GetRecords")) {
                reqIsHits = element.getAttributeByName(new QName("resultType")).getValue().equalsIgnoreCase("hits");
                if (reqIsHits) {
                    System.out.println("HITS ");
                } else {
                    System.out.println("RESULTS ");
                }
            } else if (tagName.contains("PropertyName")) {
                if (xrd.getElementText().contains("parentIdentifier")) {
                    xev = xrd.nextEvent();
                    while (!xev.isStartElement()) {
                        xev = xrd.nextEvent();
                    }
                    reqColls.add(xrd.getElementText());
                }
            }
        }
        System.out.print("collections ");
        System.out.println(reqColls);
        xrd.close();
    }

}
