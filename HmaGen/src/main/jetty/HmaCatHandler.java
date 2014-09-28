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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 *
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public class HmaCatHandler extends AbstractHandler {

    private final Template template;
    private TemplateModelCalculator tmc;

    public HmaCatHandler(Template template) {
        this.template = template;
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
                response.setContentType("application/xml");
                response.setStatus(HttpServletResponse.SC_OK);
                template.process(tmc.calcModel(), response.getWriter());
            }
        } catch (TemplateException ex) {
            throw new ServletException(ex);
        }
    }

}
