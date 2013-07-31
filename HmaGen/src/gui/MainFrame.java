/*
 * Copyright 2013 sasha.
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

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import main.HmaGenSettings;

/**
 * Main application window.
 * <p/>
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public class MainFrame extends javax.swing.JFrame {

    private final Configuration cfg = new Configuration();
    private XStream xstream = new XStream(new StaxDriver());
    Template template = null;
    HmaGenSettings settings = new HmaGenSettings();
    CalcModelWorker cmWorker = null;
    HashMap<String, JCheckBox> chk2vals = new HashMap<>();
    private File lastGenerationDir = null;
    private File lastConfigLoadDir = null;
    private File lastConfigSaveDir = null;
    private final FileNameExtensionFilter hmagenFF = new FileNameExtensionFilter(
            "HmaGen configuration files (*.hmagen)", "hmagen");
    private final FileNameExtensionFilter hmaFF = new FileNameExtensionFilter(
            "HMA GetRecords files (*.xml)", "xml");

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        xstream.alias("hmagensettings", HmaGenSettings.class);
        try {
            cfg.setDirectoryForTemplateLoading(
                    new File(getClass().getResource("templates").toURI()));
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            template = cfg.getTemplate("getrecords-response.ftl");
        } catch (IOException | URISyntaxException ex) {
        }
        initComponents();
        chk2vals.put(HmaGenSettings.ARCHIVING_CENTERS, pArch.chGenArchInfo);
        chk2vals.put(HmaGenSettings.ARCHIVING_IDS, pArch.chArchId);
        chk2vals.put(HmaGenSettings.PARENT_IDENTIFIERS, pProd.chParentId);
        chk2vals.put(HmaGenSettings.PLATFORMS, pAcq.chGenAcqPlat);
        chk2vals.put(HmaGenSettings.POLARIZATIONS, pProdSar.chPolarztn);
        chk2vals.put(HmaGenSettings.PRODUCT_TYPES, pProd.chPrdType);
        chk2vals.put(HmaGenSettings.QLOOK_URLS, pBrws.chQlkUrl);
        chk2vals.put(HmaGenSettings.SENS_MODES, pAcq.chSensMode);
        chk2vals.put(HmaGenSettings.SENS_NAMES, pAcq.chSensName);
        chk2vals.put(HmaGenSettings.SENS_TYPES, pAcq.chSensType);
        chk2vals.put(HmaGenSettings.SER_IDS, pAcq.chSerId);
        chk2vals.put(HmaGenSettings.STATUSES, pProd.chStatus);
        chk2vals.put(HmaGenSettings.SWATH_IDS, pAcq.chSwthId);
        chk2vals.put(HmaGenSettings.THUMB_URLS, pBrws.chGenBrwsInfo);
    }

    public void showValsDialog(String title) {
        SetOfValsDialog pid = new SetOfValsDialog(this, title, settings.valMap
                .get(title));
        pid.setLocationRelativeTo(this);
        pid.setVisible(true);
        settings.valMap.put(title, pid.getValList());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        spNumRecs = new javax.swing.JSpinner();
        tabPane = new javax.swing.JTabbedPane();
        pProd = new gui.panels.EOProductPanel();
        pProdOpt = new gui.panels.EOProductOptPanel();
        pProdSar = new gui.panels.EOProductSarPanel();
        pAcq = new gui.panels.EOAcqPanel();
        pBrws = new gui.panels.EOBrowsePanel();
        pArch = new gui.panels.EOArchivingPanel();
        bGenerate = new javax.swing.JButton();
        chClassification = new javax.swing.JCheckBox();
        cbClassification = new javax.swing.JComboBox();
        bSave = new javax.swing.JButton();
        bLoad = new javax.swing.JButton();
        pProgress = new javax.swing.JProgressBar();
        jSeparator1 = new javax.swing.JSeparator();
        chStripSpace = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        cbEnvelope = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HmaGen");

        jLabel1.setText("records");

        spNumRecs.setModel(new javax.swing.SpinnerNumberModel(5, 1, 9999, 1));

        tabPane.addTab("EOProduct", pProd);
        tabPane.addTab("EOProduct (OPT)", pProdOpt);
        tabPane.addTab("EOProduct (SAR)", pProdSar);
        tabPane.addTab("EOAcquisitionPlat", pAcq);
        tabPane.addTab("EOBrowseInfo", pBrws);
        tabPane.addTab("EOArchivingInfo", pArch);

        bGenerate.setText("Generate...");
        bGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerateActionPerformed(evt);
            }
        });

        chClassification.setText("Add classification");
        chClassification.setName("chClassification"); // NOI18N
        chClassification.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chClassificationItemStateChanged(evt);
            }
        });

        cbClassification.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Optical", "Radar", "Atmospheric" }));
        cbClassification.setEnabled(false);

        bSave.setText("Save..");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bLoad.setText("Load...");
        bLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadActionPerformed(evt);
            }
        });

        pProgress.setEnabled(false);

        chStripSpace.setText("Strip leading whitespace");
        chStripSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chStripSpaceActionPerformed(evt);
            }
        });

        jLabel2.setText("Envelope");

        cbEnvelope.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "SOAP V1.1", "SOAP v1.2" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bGenerate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spNumRecs, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(pProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSave))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEnvelope, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chStripSpace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chClassification)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(spNumRecs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bGenerate)
                        .addComponent(bSave)
                        .addComponent(bLoad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbEnvelope, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chStripSpace)
                    .addComponent(cbClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chClassification))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerateActionPerformed
        if (cmWorker != null) {
            cmWorker.cancel(false);
        } else {
            if (checkAllValid()) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileFilter(hmaFF);
                if (lastGenerationDir != null)
                    jfc.setCurrentDirectory(lastGenerationDir);
                if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    if (!selectedFile.getName().endsWith(".xml")) {
                        selectedFile = new File(
                                selectedFile.getAbsolutePath() + ".xml");
                    }
                    if (selectedFile != null) {
                        cmWorker = new CalcModelWorker(this, selectedFile);
                        bGenerate.setText("Cancel");
                        pProgress.setMaximum((int) spNumRecs.getValue());
                        cmWorker.execute();
                        lastGenerationDir = selectedFile.getParentFile();
                    }
                }
            }
        }
    }//GEN-LAST:event_bGenerateActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(hmagenFF);
        if (lastConfigSaveDir != null) {
            jfc.setCurrentDirectory(lastConfigSaveDir);
        }
        if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            if (!selectedFile.getName().endsWith(".hmagen")) {
                selectedFile = new File(
                        selectedFile.getAbsolutePath() + ".hmagen");
            }
            try {
                fillSettings(this.getClass(), this);
                xstream.toXML(settings, new FileWriter(selectedFile));
            } catch (IOException | SecurityException | IllegalAccessException | IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Save error!", JOptionPane.ERROR_MESSAGE);
            }
            lastConfigSaveDir = jfc.getSelectedFile().getParentFile();
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void bLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(hmagenFF);
        if (lastConfigLoadDir != null) {
            jfc.setCurrentDirectory(lastConfigLoadDir);
        }
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            settings = (HmaGenSettings) xstream.fromXML(jfc.getSelectedFile());
            applySettings(this.getClass(), this);
            applySettings(pProd.getClass(), pProd);
            applySettings(pProdOpt.getClass(), pProdOpt);
            applySettings(pProdSar.getClass(), pProdSar);
            applySettings(pAcq.getClass(), pAcq);
            applySettings(pArch.getClass(), pArch);
            lastConfigLoadDir = jfc.getSelectedFile().getParentFile();
        }
    }//GEN-LAST:event_bLoadActionPerformed

    private void chClassificationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chClassificationItemStateChanged
        cbClassification.setEnabled(chClassification.isSelected());
    }//GEN-LAST:event_chClassificationItemStateChanged

    private void chStripSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chStripSpaceActionPerformed
        try {
            if (chStripSpace.isSelected()) {
                template = cfg.getTemplate("getrecords-response-compact.ftl");
            } else {
                template = cfg.getTemplate("getrecords-response.ftl");
            }
        } catch (IOException ex) {
            //ignored
        }
    }//GEN-LAST:event_chStripSpaceActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton bGenerate;
    javax.swing.JButton bLoad;
    javax.swing.JButton bSave;
    javax.swing.JComboBox cbClassification;
    javax.swing.JComboBox cbEnvelope;
    javax.swing.JCheckBox chClassification;
    javax.swing.JCheckBox chStripSpace;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JSeparator jSeparator1;
    gui.panels.EOAcqPanel pAcq;
    gui.panels.EOArchivingPanel pArch;
    gui.panels.EOBrowsePanel pBrws;
    gui.panels.EOProductPanel pProd;
    gui.panels.EOProductOptPanel pProdOpt;
    gui.panels.EOProductSarPanel pProdSar;
    javax.swing.JProgressBar pProgress;
    javax.swing.JSpinner spNumRecs;
    javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables

    private void fillSettings(Class c, Object instance) throws SecurityException, IllegalAccessException, IllegalArgumentException {
        for (Field f : c.getDeclaredFields()) {
            final String fName = f.getName();
            if (f.getType().equals(JCheckBox.class)) {
                JCheckBox ch = (JCheckBox) f.get(instance);
                if (ch.isSelected()) {
                    settings.chkbEnabled.add(fName);
                }
            } else if (f.getType().equals(JSpinner.class)) {
                JSpinner sp = (JSpinner) f.get(instance);
                settings.spinnersMap.put(fName, sp.getValue());
            } else if (f.getType().equals(JComboBox.class)) {
                JComboBox cb = (JComboBox) f.get(instance);
                settings.combosMap.put(fName, cb.getSelectedItem());
            } else if (f.getType().equals(JTextField.class)) {
                JTextField tf = (JTextField) f.get(instance);
                settings.textfieldsMap.put(fName, tf.getText());
            } else if (f.getType().getSuperclass().equals(JPanel.class)) {
                final Object inst = f.get(instance);
                fillSettings(inst.getClass(), inst);
            }
        }
    }

    private void applySettings(Class c, Object instance) {
        for (String ch : settings.chkbEnabled) {
            try {
                ((JCheckBox) c.getDeclaredField(ch).get(instance)).setSelected(
                        true);
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Load error!", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchFieldException ignored) {
            }
        }
        for (Map.Entry<String, Object> e : settings.combosMap.entrySet()) {
            String cb = e.getKey();
            Object val = e.getValue();
            try {
                ((JComboBox) c.getDeclaredField(cb).get(instance))
                        .setSelectedItem(val);
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Load error!", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchFieldException ignored) {
            }
        }
        for (Map.Entry<String, Object> e : settings.spinnersMap.entrySet()) {
            String sp = e.getKey();
            Object val = e.getValue();
            try {
                ((JSpinner) c.getDeclaredField(sp).get(instance)).setValue(val);
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Load error!", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchFieldException ignored) {
            }
        }
        for (Map.Entry<String, String> e : settings.textfieldsMap.entrySet()) {
            String tf = e.getKey();
            String val = e.getValue();
            try {
                ((JTextField) c.getDeclaredField(tf).get(instance)).setText(val);
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Load error!", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchFieldException ignored) {
            }
        }
    }

    private boolean checkAllValid() {
        for (String vals : settings.valMap.keySet()) {
            if (chk2vals.get(vals).isSelected() && settings.valMap.get(vals)
                    .size() == 0) {
                JOptionPane.showMessageDialog(this, "No " + vals + " values!",
                        "Error!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        Date from = (Date) pProd.spSensFrom.getValue();
        Date to = (Date) pProd.spSensTo.getValue();
        if (from.after(to)) {
            tabPane.setSelectedComponent(pProd);
            JOptionPane.showMessageDialog(this,
                    "Bad sensing time generation interval!", "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        from = (Date) pArch.spArdtFrom.getValue();
        to = (Date) pArch.spArdtTo.getValue();
        if (from.after(to)) {
            tabPane.setSelectedComponent(pArch);
            JOptionPane.showMessageDialog(this,
                    "Bad archiving date generation interval!", "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Integer low = (Integer) pProdOpt.spCldCovFrom.getValue();
        Integer high = (Integer) pProdOpt.spCldCovTo.getValue();
        if (low > high) {
            tabPane.setSelectedComponent(pProd);
            JOptionPane.showMessageDialog(this,
                    "Bad cloud coverage generation interval!", "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        low = (Integer) pProd.spOrbitFrom.getValue();
        high = (Integer) pProd.spOrbitTo.getValue();
        if (low > high) {
            tabPane.setSelectedComponent(pProd);
            JOptionPane.showMessageDialog(this,
                    "Bad orbit number generation interval!", "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        low = (Integer) pAcq.spResFrom.getValue();
        high = (Integer) pAcq.spResTo.getValue();
        if (low > high) {
            tabPane.setSelectedComponent(pAcq);
            JOptionPane.showMessageDialog(this,
                    "Bad sensor resolution generation interval!", "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        low = (Integer) pProdOpt.spSnwCovFrom.getValue();
        high = (Integer) pProdOpt.spSnwCovTo.getValue();
        if (low > high) {
            tabPane.setSelectedComponent(pProd);
            JOptionPane.showMessageDialog(this,
                    "Bad snow coverage generation interval!", "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        double min = (double) pProd.spFtMinLat.getValue();
        double max = (double) pProd.spFtMaxLat.getValue();
        if (min > max) {
            tabPane.setSelectedComponent(pProd);
            JOptionPane.showMessageDialog(this,
                    "Bad latitude range for footprint generation region!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        min = (double) pProd.spFtMinLon.getValue();
        max = (double) pProd.spFtMaxLon.getValue();
        if (min > max) {
            tabPane.setSelectedComponent(pProd);
            JOptionPane.showMessageDialog(this,
                    "Bad longitude range for footprint generation region!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
