/*
 * Copyright 2014 Alessandro Falappa.
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
package gui;

import freemarker.template.TemplateException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import main.App;

/**
 * Worker thread for actual metadata generation.
 * <p>
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public class CalcModelWorker extends SwingWorker<Map, Integer> {

    private final MainFrame mf;
    private final File file;
    private final TemplateModelCalculator modelCalculator;

    public CalcModelWorker(MainFrame mf, File outFile) {
        this.mf = mf;
        this.file = outFile;
        this.modelCalculator = new TemplateModelCalculator(mf);
    }

    @Override
    protected Map doInBackground() throws Exception {
        return modelCalculator.calcModel();
    }

    @Override
    protected void done() {
        try {
            Map model = get();
            try (Writer out = new BufferedWriter(new FileWriter(file))) {
                mf.templateResults.process(model, out);
                final int nRecs = ((List) model.get("records")).size();
                App.metrics.counter("generator.totalRecs").inc(nRecs);
                JOptionPane.showMessageDialog(mf, String.format("Generated %s products to:\n%s", nRecs, file.getAbsolutePath()), "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ExecutionException | InterruptedException | IOException | TemplateException ex) {
            JOptionPane.showMessageDialog(mf, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        } finally {
            mf.enableWidgets(true);
            mf.bServe.setEnabled(true);
        }
    }
}
