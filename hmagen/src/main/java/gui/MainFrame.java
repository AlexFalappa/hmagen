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

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import main.App;
import main.HmaGenSettings;
import main.jetty.HmaCatHandler;
import main.specattrs.SpecAttr;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

/**
 * Main application window.
 *
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public class MainFrame extends javax.swing.JFrame {

    private final Configuration cfg = new Configuration();
    private final XStream xstream = new XStream(new StaxDriver());
    Template templateResults = null;
    Template templateHits = null;
    HmaGenSettings settings = new HmaGenSettings();
    CalcModelWorker cmWorker = null;
    HashMap<String, JCheckBox> chk2vals = new HashMap<>();
    private File lastGenerationDir = null;
    private File lastConfigLoadDir = null;
    private File lastConfigSaveDir = null;
    private final FileNameExtensionFilter hmagenFF = new FileNameExtensionFilter("HmaGen configuration files (*.hmagen)", "hmagen");
    private final FileNameExtensionFilter hmaFF = new FileNameExtensionFilter("HMA GetRecords files (*.xml)", "xml");
    private Server serv;
    private ServerConnector servConn;
    private HmaCatHandler catHandler;
    private TemplateModelCalculator modelCalculator;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        xstream.alias("hmagensettings", HmaGenSettings.class);
        try {
            cfg.setClassForTemplateLoading(MainFrame.class, "templates");
            cfg.setObjectWrapper(new DefaultObjectWrapper());
            templateResults = cfg.getTemplate("getrecords-response.ftl");
            templateHits = cfg.getTemplate("getrecords-hits-response.ftl");
        } catch (IOException ignored) {
        }
        initComponents();
        chk2vals.put(HmaGenSettings.ARCHIVING_CENTERS, pArch.chGenArchInfo);
        chk2vals.put(HmaGenSettings.ARCHIVING_IDS, pArch.chArchId);
        chk2vals.put(HmaGenSettings.PARENT_IDENTIFIERS, pProd.chParentId);
        chk2vals.put(HmaGenSettings.PRODUCT_TYPES, pProd.chPrdType);
        chk2vals.put(HmaGenSettings.STATUSES, pProd.chStatus);
        chk2vals.put(HmaGenSettings.ORBIT_DIRS, pProd.chOrbitDir);
        chk2vals.put(HmaGenSettings.ACQ_STATIONS, pProd2.chAcqStation);
        chk2vals.put(HmaGenSettings.ACQ_TYPE, pProd2.chAcqType);
        chk2vals.put(HmaGenSettings.ACQ_SUBTYPE, pProd2.chAcqSubtype);
        chk2vals.put(HmaGenSettings.POLARIZATION_CHANS, pProdSar.chPolarzChans);
        chk2vals.put(HmaGenSettings.POLARIZATION_MODES, pProdSar.chPolarzModes);
        chk2vals.put(HmaGenSettings.ANT_LOOK_DIRS, pProdSar.chAntLook);
        chk2vals.put(HmaGenSettings.PLATFORMS, pAcq.chGenAcqPlat);
        chk2vals.put(HmaGenSettings.SENS_MODES, pAcq.chSensMode);
        chk2vals.put(HmaGenSettings.SENS_NAMES, pAcq.chSensName);
        chk2vals.put(HmaGenSettings.SENS_TYPES, pAcq.chSensType);
        chk2vals.put(HmaGenSettings.SER_IDS, pAcq.chSerId);
        chk2vals.put(HmaGenSettings.SWATH_IDS, pAcq.chSwthId);
        chk2vals.put(HmaGenSettings.QLOOK_URLS, pBrws.chQlkUrl);
        chk2vals.put(HmaGenSettings.THUMB_URLS, pBrws.chGenBrwsInfo);
        chk2vals.put(HmaGenSettings.SPEC_ATTRS, pSpecAttr.chGenSpecific);
    }

    public void showValsDialog(String title) {
        SetOfValsDialog pid = new SetOfValsDialog(this, title, settings.valMap.get(title));
        pid.setLocationRelativeTo(this);
        pid.setVisible(true);
        settings.valMap.put(title, pid.getValList());
    }

    public void specAttrToSettings(SpecAttr attr) {
        settings.specAttrsList.add(attr);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lRecs = new javax.swing.JLabel();
        spNumRecs = new javax.swing.JSpinner();
        tabPane = new javax.swing.JTabbedPane();
        pProd = new gui.panels.EOProductPanel();
        pProd2 = new gui.panels.EOProductPanel2();
        pProdOpt = new gui.panels.EOProductOptPanel();
        pProdSar = new gui.panels.EOProductSarPanel();
        pAcq = new gui.panels.EOAcqPanel();
        pBrws = new gui.panels.EOBrowsePanel();
        pArch = new gui.panels.EOArchivingPanel();
        pSpecAttr = new gui.panels.EOSpecificAttrsPanel();
        bGenerate = new javax.swing.JButton();
        chClassification = new javax.swing.JCheckBox();
        cbClassification = new javax.swing.JComboBox();
        bSave = new javax.swing.JButton();
        bLoad = new javax.swing.JButton();
        pProgress = new javax.swing.JProgressBar();
        chStripSpace = new javax.swing.JCheckBox();
        lEnvelope = new javax.swing.JLabel();
        cbEnvelope = new javax.swing.JComboBox();
        bServe = new javax.swing.JButton();
        chCollsFromReq = new javax.swing.JCheckBox();
        chRandomize = new javax.swing.JCheckBox();
        lPort = new javax.swing.JLabel();
        txServPort = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HmaGen");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lRecs.setText("records");

        spNumRecs.setModel(new javax.swing.SpinnerNumberModel(5, 1, 999, 10));

        tabPane.addTab("EOProduct (1)", pProd);
        tabPane.addTab("EOProduct (2)", pProd2);
        tabPane.addTab("EOProduct (OPT)", pProdOpt);
        tabPane.addTab("EOProduct (SAR)", pProdSar);
        tabPane.addTab("EOAcquisitionPlat", pAcq);
        tabPane.addTab("EOBrowseInfo", pBrws);
        tabPane.addTab("EOArchivingInfo", pArch);
        tabPane.addTab("Specific Attributes", pSpecAttr);

        bGenerate.setText("Generate ...");
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

        bSave.setText("Save preset ...");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bLoad.setText("Load preset ...");
        bLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadActionPerformed(evt);
            }
        });

        javax.swing.UIDefaults d = new javax.swing.UIDefaults();
        d.put("ProgressBar[Enabled+Indeterminate].foregroundPainter", new IndeterminateRegionPainter());
        pProgress.putClientProperty("Nimbus.Overrides", d);

        chStripSpace.setText("Strip leading whitespace");
        chStripSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chStripSpaceActionPerformed(evt);
            }
        });

        lEnvelope.setText("Envelope");

        cbEnvelope.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "SOAP V1.1", "SOAP v1.2" }));

        bServe.setText("Start server");
        bServe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bServeActionPerformed(evt);
            }
        });

        chCollsFromReq.setText("parent id from request");
        chCollsFromReq.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chCollsFromReqItemStateChanged(evt);
            }
        });

        chRandomize.setText("randomize record number");

        lPort.setText("on port");

        txServPort.setColumns(4);
        txServPort.setText("8080");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bGenerate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spNumRecs, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lRecs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSave))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lEnvelope)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEnvelope, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chStripSpace)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chClassification)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bServe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lPort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txServPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chCollsFromReq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chRandomize))
                    .addComponent(pProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bGenerate, bServe});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bLoad, bSave});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lRecs)
                    .addComponent(spNumRecs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bGenerate)
                    .addComponent(bLoad)
                    .addComponent(bSave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bServe)
                    .addComponent(chCollsFromReq)
                    .addComponent(chRandomize)
                    .addComponent(lPort)
                    .addComponent(txServPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lEnvelope)
                    .addComponent(cbEnvelope, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chStripSpace)
                    .addComponent(cbClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chClassification))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerateActionPerformed
        if (checkAllValid()) {
            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(hmaFF);
            if (lastGenerationDir != null) {
                jfc.setCurrentDirectory(lastGenerationDir);
            }
            if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                if (selectedFile != null) {
                    if (!selectedFile.getName().endsWith(".xml")) {
                        selectedFile = new File(selectedFile.getAbsolutePath() + ".xml");
                    }
                    enableWidgets(false);
                    bServe.setEnabled(false);
                    cmWorker = new CalcModelWorker(this, selectedFile);
                    cmWorker.execute();
                    lastGenerationDir = selectedFile.getParentFile();
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
                selectedFile = new File(selectedFile.getAbsolutePath() + ".hmagen");
            }
            try {
                fillSettings(this.getClass(), this);
                xstream.toXML(settings, new FileWriter(selectedFile));
            } catch (IOException | SecurityException | IllegalAccessException | IllegalArgumentException | XStreamException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Save error!", JOptionPane.ERROR_MESSAGE);
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
            applySettings(pProd2.getClass(), pProd2);
            applySettings(pProdOpt.getClass(), pProdOpt);
            applySettings(pProdSar.getClass(), pProdSar);
            applySettings(pAcq.getClass(), pAcq);
            applySettings(pArch.getClass(), pArch);
            applySettings(pBrws.getClass(), pBrws);
            applySettings(pSpecAttr.getClass(), pSpecAttr);
            pSpecAttr.applySettings(settings.specAttrsList);
            lastConfigLoadDir = jfc.getSelectedFile().getParentFile();
        }
    }//GEN-LAST:event_bLoadActionPerformed

    private void chClassificationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chClassificationItemStateChanged
        cbClassification.setEnabled(chClassification.isSelected());
    }//GEN-LAST:event_chClassificationItemStateChanged

    private void chStripSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chStripSpaceActionPerformed
        try {
            if (chStripSpace.isSelected()) {
                templateResults = cfg.getTemplate("getrecords-response-compact.ftl");
                templateResults = cfg.getTemplate("getrecords-hits-response-compact.ftl");
            } else {
                templateResults = cfg.getTemplate("getrecords-response.ftl");
                templateHits = cfg.getTemplate("getrecords-hits-response.ftl");
            }
        } catch (IOException ex) {
            //ignored
        }
    }//GEN-LAST:event_chStripSpaceActionPerformed

    private void bServeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bServeActionPerformed
        if (serv == null) {
            serv = new Server();
            catHandler = new HmaCatHandler(templateHits, templateResults);
            serv.setHandler(catHandler);
        }
        if (servConn == null) {
            servConn = new ServerConnector(serv);
            serv.setConnectors(new Connector[]{servConn});
        }
        try {
            servConn.setPort(Integer.parseInt(txServPort.getText()));
        } catch (NumberFormatException nfe) {
            txServPort.setText("8080");
            servConn.setPort(8080);
        }
        try {
            if (serv.isStarted()) {
                serv.stop();
                bServe.setText("Start server");
                bGenerate.setEnabled(true);
                enableWidgets(true);
                App.metrics.counter("server.activations").inc();
            } else {
                modelCalculator = new TemplateModelCalculator(this);
                modelCalculator.setRandomize(chRandomize.isSelected());
                catHandler.setTemplateCalculator(modelCalculator);
                catHandler.setCollectionFromRequest(chCollsFromReq.isSelected());
                serv.start();
                bServe.setText("Stop server");
                bGenerate.setEnabled(false);
                enableWidgets(false);
            }
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_bServeActionPerformed

    public void enableWidgets(boolean flag) {
        Utils.widgetsEnable(flag, lRecs, spNumRecs, bGenerate, bLoad, bSave, lEnvelope, cbEnvelope, chStripSpace, chClassification,
                chCollsFromReq, chRandomize, lPort, txServPort);
        cbClassification.setEnabled(flag && chClassification.isSelected());
        for (Component p : tabPane.getComponents()) {
            p.setEnabled(flag);
        }
        tabPane.setEnabled(flag);
        pProgress.setIndeterminate(!flag);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (serv != null && serv.isStarted()) {
            try {
                serv.stop();
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void chCollsFromReqItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chCollsFromReqItemStateChanged
        pProd.setParentIdFromRequest(chCollsFromReq.isSelected());
    }//GEN-LAST:event_chCollsFromReqItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton bGenerate;
    javax.swing.JButton bLoad;
    javax.swing.JButton bSave;
    javax.swing.JButton bServe;
    javax.swing.JComboBox cbClassification;
    javax.swing.JComboBox cbEnvelope;
    javax.swing.JCheckBox chClassification;
    javax.swing.JCheckBox chCollsFromReq;
    javax.swing.JCheckBox chRandomize;
    javax.swing.JCheckBox chStripSpace;
    javax.swing.JLabel lEnvelope;
    javax.swing.JLabel lPort;
    javax.swing.JLabel lRecs;
    gui.panels.EOAcqPanel pAcq;
    gui.panels.EOArchivingPanel pArch;
    gui.panels.EOBrowsePanel pBrws;
    gui.panels.EOProductPanel pProd;
    gui.panels.EOProductPanel2 pProd2;
    gui.panels.EOProductOptPanel pProdOpt;
    gui.panels.EOProductSarPanel pProdSar;
    javax.swing.JProgressBar pProgress;
    gui.panels.EOSpecificAttrsPanel pSpecAttr;
    javax.swing.JSpinner spNumRecs;
    javax.swing.JTabbedPane tabPane;
    javax.swing.JTextField txServPort;
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
                ((JCheckBox) c.getDeclaredField(ch).get(instance)).setSelected(true);
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Load error!", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchFieldException ignored) {
            }
        }
        for (Map.Entry<String, Object> e : settings.combosMap.entrySet()) {
            String cb = e.getKey();
            Object val = e.getValue();
            try {
                ((JComboBox) c.getDeclaredField(cb).get(instance)).setSelectedItem(val);
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Load error!", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchFieldException ignored) {
            }
        }
        for (Map.Entry<String, Object> e : settings.spinnersMap.entrySet()) {
            String sp = e.getKey();
            Object val = e.getValue();
            try {
                ((JSpinner) c.getDeclaredField(sp).get(instance)).setValue(val);
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Load error!", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchFieldException ignored) {
            }
        }
        for (Map.Entry<String, String> e : settings.textfieldsMap.entrySet()) {
            String tf = e.getKey();
            String val = e.getValue();
            try {
                ((JTextField) c.getDeclaredField(tf).get(instance)).setText(val);
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Load error!", JOptionPane.ERROR_MESSAGE);
            } catch (NoSuchFieldException ignored) {
            }
        }
    }

    private boolean checkAllValid() {
        for (String vals : settings.valMap.keySet()) {
            if (chk2vals.get(vals).isSelected() && settings.valMap.get(vals).size() == 0) {
                JOptionPane.showMessageDialog(this, "No " + vals + " values!", "Error!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        Date from = (Date) pProd.spSensFrom.getValue();
        Date to = (Date) pProd.spSensTo.getValue();
        if (pProd.chSensing.isSelected() && from.after(to)) {
            tabPane.setSelectedComponent(pProd);
            JOptionPane.showMessageDialog(this, "Bad sensing time generation interval!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        from = (Date) pProd2.spAcqDateFrom.getValue();
        to = (Date) pProd2.spAcqDateTo.getValue();
        if (pProd2.chAcqDate.isSelected() && from.after(to)) {
            tabPane.setSelectedComponent(pProd2);
            JOptionPane.showMessageDialog(this, "Bad acquisition date generation interval!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        from = (Date) pArch.spArdtFrom.getValue();
        to = (Date) pArch.spArdtTo.getValue();
        if (pArch.chArchDate.isSelected() && from.after(to)) {
            tabPane.setSelectedComponent(pArch);
            JOptionPane.showMessageDialog(this, "Bad archiving date generation interval!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Integer low = (Integer) pProdOpt.spCldCovFrom.getValue();
        Integer high = (Integer) pProdOpt.spCldCovTo.getValue();
        if (pProdOpt.chCloudCov.isSelected() && low > high) {
            tabPane.setSelectedComponent(pProdOpt);
            JOptionPane.showMessageDialog(this, "Bad cloud coverage generation interval!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        low = (Integer) pProdOpt.spSnwCovFrom.getValue();
        high = (Integer) pProdOpt.spSnwCovTo.getValue();
        if (pProdOpt.chSnowCov.isSelected() && low > high) {
            tabPane.setSelectedComponent(pProdOpt);
            JOptionPane.showMessageDialog(this, "Bad snow coverage generation interval!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        low = (Integer) pProd.spOrbitFrom.getValue();
        high = (Integer) pProd.spOrbitTo.getValue();
        if (pProd.chOrbitNum.isSelected() && low > high) {
            tabPane.setSelectedComponent(pProd);
            JOptionPane.showMessageDialog(this, "Bad orbit number generation interval!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        low = (Integer) pAcq.spResFrom.getValue();
        high = (Integer) pAcq.spResTo.getValue();
        if (pAcq.chRes.isSelected() && low > high) {
            tabPane.setSelectedComponent(pAcq);
            JOptionPane.showMessageDialog(this, "Bad sensor resolution generation interval!", "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (pProd.chFootprint.isSelected() && !checkRange(pProd.spFtMinLat, pProd.spFtMaxLat, pProd,
                "Bad latitude range for footprint generation region!")) {
            return false;
        }
        if (pProd.chFootprint.isSelected() && !checkRange(pProd.spFtMinLon, pProd.spFtMaxLon, pProd,
                "Bad longitude range for footprint generation region!")) {
            return false;
        }
        if (pProd2.chAcrIncid.isSelected() && !checkRange(pProd2.spAcrIncidFrom, pProd2.spAcrIncidTo, pProd2,
                "Bad across track incidence angle generation range!")) {
            return false;
        }
        if (pProd2.chAlonIncid.isSelected() && !checkRange(pProd2.spAlonIncidFrom, pProd2.spAlonIncidTo, pProd2,
                "Bad along track incidence angle generation range!")) {
            return false;
        }
        if (pProd2.chWRSLat.isSelected() && !checkRange(pProd2.spWRSLatFrom, pProd2.spWRSLatTo, pProd2, "Bad WRS latitude generation range!")) {
            return false;
        }
        if (pProd2.chWRSLon.isSelected() && !checkRange(pProd2.spWRSLonFrom, pProd2.spWRSLonTo, pProd2,
                "Bad WRS longitude generation range!")) {
            return false;
        }
        if (pProd2.chANX.isSelected() && !checkRange(pProd2.spANXFrom, pProd2.spANXTo, pProd2,
                "Bad ascending node longitude generation range!")) {
            return false;
        }
        if (pProd2.chIncid.isSelected() && !checkRange(pProd2.spIncidAngFrom, pProd2.spIncidAngTo, pProd2,
                "Bad incidence angle generation range!")) {
            return false;
        }
        if (pProdSar.chMinIncidAng.isSelected() && !checkRange(pProdSar.spMinIaFrom, pProdSar.spMinIaTo, pProdSar,
                "Bad minimum incidence angle generation range!")) {
            return false;
        }
        if (pProdSar.chMaxIncidAng.isSelected() && !checkRange(pProdSar.spMaxIaFrom, pProdSar.spMaxIaTo, pProdSar,
                "Bad maximum incidence angle generation range!")) {
            return false;
        }
        if (pProdOpt.chIllumElev.isSelected() && !checkRange(pProdOpt.spIllElevFrom, pProdOpt.spIllElevTo, pProdOpt,
                "Bad illumination elevation angle generation range!")) {
            return false;
        }
        if (pProdOpt.chIllumAzim.isSelected() && !checkRange(pProdOpt.spIllAzimFrom, pProdOpt.spIllAzimTo, pProdOpt,
                "Bad illumination azimuth angle generation range!")) {
            return false;
        }
        return true;
    }

    private boolean checkRange(JSpinner from, JSpinner to, JComponent tab, String errMex) {
        double min = (double) from.getValue();
        double max = (double) to.getValue();
        if (min > max) {
            tabPane.setSelectedComponent(tab);
            JOptionPane.showMessageDialog(this, errMex, "Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
