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
package gui.panels;

import main.App;
import main.HmaGenSettings;

/**
 *
 * @author sasha
 */
public class EOProductPanel extends javax.swing.JPanel {

    /**
     * Creates new form EOProductPanel
     */
    public EOProductPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spHeight = new javax.swing.JSpinner();
        chCenter = new javax.swing.JCheckBox();
        spWidth = new javax.swing.JSpinner();
        lF2 = new javax.swing.JLabel();
        lSt3 = new javax.swing.JLabel();
        spSensFrom = new javax.swing.JSpinner();
        spSensTo = new javax.swing.JSpinner();
        chPrdType = new javax.swing.JCheckBox();
        bPrdTypeVals = new javax.swing.JButton();
        chStatus = new javax.swing.JCheckBox();
        bStatusVals = new javax.swing.JButton();
        chLastOrbitOfs = new javax.swing.JCheckBox();
        lOf1 = new javax.swing.JLabel();
        spLstOrbitOfs = new javax.swing.JSpinner();
        chSensing = new javax.swing.JCheckBox();
        lF1 = new javax.swing.JLabel();
        chFootprint = new javax.swing.JCheckBox();
        lSt1 = new javax.swing.JLabel();
        lF5 = new javax.swing.JLabel();
        spOrbitFrom = new javax.swing.JSpinner();
        spOrbitTo = new javax.swing.JSpinner();
        spFtMaxLon = new javax.swing.JSpinner();
        lOn2 = new javax.swing.JLabel();
        chOrbitNum = new javax.swing.JCheckBox();
        lOn1 = new javax.swing.JLabel();
        chParentId = new javax.swing.JCheckBox();
        bParentIdVals = new javax.swing.JButton();
        spDuration = new javax.swing.JSpinner();
        cbDurationUnit = new javax.swing.JComboBox();
        tfPrefix = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lF3 = new javax.swing.JLabel();
        lSt2 = new javax.swing.JLabel();
        lF4 = new javax.swing.JLabel();
        spFtMaxLat = new javax.swing.JSpinner();
        spFtMinLon = new javax.swing.JSpinner();
        lF6 = new javax.swing.JLabel();
        spFtMinLat = new javax.swing.JSpinner();
        chOrbitDir = new javax.swing.JCheckBox();
        bOrbDirVals = new javax.swing.JButton();

        spHeight.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0E-4d, 90.0d, 0.01d));
        spHeight.setEditor(new javax.swing.JSpinner.NumberEditor(spHeight, "##.######"));
        spHeight.setEnabled(false);

        chCenter.setText("Calc. product center");
        chCenter.setEnabled(false);

        spWidth.setModel(new javax.swing.SpinnerNumberModel(2.0d, 1.0E-4d, 90.0d, 0.01d));
        spWidth.setEditor(new javax.swing.JSpinner.NumberEditor(spWidth, "##.######"));
        spWidth.setEnabled(false);

        lF2.setText("max height");
        lF2.setEnabled(false);

        lSt3.setText("to");
        lSt3.setEnabled(false);

        spSensFrom.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.SECOND));
        spSensFrom.setEditor(new javax.swing.JSpinner.DateEditor(spSensFrom, "yyyy-MM-dd HH:mm:ss"));
        spSensFrom.setEnabled(false);

        spSensTo.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.SECOND));
        spSensTo.setEditor(new javax.swing.JSpinner.DateEditor(spSensTo, "yyyy-MM-dd HH:mm:ss"));
        spSensTo.setEnabled(false);

        chPrdType.setText("Product Type");
        chPrdType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chPrdTypeItemStateChanged(evt);
            }
        });

        bPrdTypeVals.setText("Allowed values...");
        bPrdTypeVals.setEnabled(false);
        bPrdTypeVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPrdTypeValsActionPerformed(evt);
            }
        });

        chStatus.setText("Status");
        chStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chStatusItemStateChanged(evt);
            }
        });

        bStatusVals.setText("Allowed values...");
        bStatusVals.setEnabled(false);
        bStatusVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStatusValsActionPerformed(evt);
            }
        });

        chLastOrbitOfs.setText("Last orbit number");
        chLastOrbitOfs.setEnabled(false);
        chLastOrbitOfs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chLastOrbitOfsItemStateChanged(evt);
            }
        });

        lOf1.setText("max offset");
        lOf1.setEnabled(false);

        spLstOrbitOfs.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(3), Integer.valueOf(0), null, Integer.valueOf(5)));
        spLstOrbitOfs.setEnabled(false);

        chSensing.setText("Sensing times");
        chSensing.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chSensingItemStateChanged(evt);
            }
        });

        lF1.setText("max width");
        lF1.setEnabled(false);

        chFootprint.setText("Footprint");
        chFootprint.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chFootprintItemStateChanged(evt);
            }
        });

        lSt1.setText("from");
        lSt1.setEnabled(false);

        lF5.setText("min lon");
        lF5.setEnabled(false);

        spOrbitFrom.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(5)));
        spOrbitFrom.setEnabled(false);

        spOrbitTo.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(100), Integer.valueOf(0), null, Integer.valueOf(5)));
        spOrbitTo.setEnabled(false);

        spFtMaxLon.setModel(new javax.swing.SpinnerNumberModel(180.0d, -180.0d, 180.0d, 0.01d));
        spFtMaxLon.setEditor(new javax.swing.JSpinner.NumberEditor(spFtMaxLon, "##.######"));
        spFtMaxLon.setEnabled(false);

        lOn2.setText("to");
        lOn2.setEnabled(false);

        chOrbitNum.setText("Orbit number");
        chOrbitNum.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chOrbitNumItemStateChanged(evt);
            }
        });

        lOn1.setText("from");
        lOn1.setEnabled(false);

        chParentId.setText("Parent identifier");
        chParentId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chParentIdItemStateChanged(evt);
            }
        });

        bParentIdVals.setText("Allowed values...");
        bParentIdVals.setEnabled(false);
        bParentIdVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bParentIdValsActionPerformed(evt);
            }
        });

        spDuration.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(0), null, Integer.valueOf(1)));
        spDuration.setEnabled(false);

        cbDurationUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "milliseconds", "seconds", "minutes" }));
        cbDurationUnit.setSelectedIndex(1);
        cbDurationUnit.setEnabled(false);

        tfPrefix.setColumns(30);
        tfPrefix.setText("prod");

        jLabel8.setText("Product identifier Prefix");

        lF3.setText("within min lat");
        lF3.setEnabled(false);

        lSt2.setText("max duration");
        lSt2.setEnabled(false);

        lF4.setText("max lat");
        lF4.setEnabled(false);

        spFtMaxLat.setModel(new javax.swing.SpinnerNumberModel(90.0d, -90.0d, 90.0d, 0.01d));
        spFtMaxLat.setEditor(new javax.swing.JSpinner.NumberEditor(spFtMaxLat, "##.######"));
        spFtMaxLat.setEnabled(false);

        spFtMinLon.setModel(new javax.swing.SpinnerNumberModel(-180.0d, -180.0d, 180.0d, 0.01d));
        spFtMinLon.setEditor(new javax.swing.JSpinner.NumberEditor(spFtMinLon, "##.######"));
        spFtMinLon.setEnabled(false);

        lF6.setText("max lon");
        lF6.setEnabled(false);

        spFtMinLat.setModel(new javax.swing.SpinnerNumberModel(-90.0d, -90.0d, 90.0d, 0.01d));
        spFtMinLat.setEditor(new javax.swing.JSpinner.NumberEditor(spFtMinLat, "##.######"));
        spFtMinLat.setEnabled(false);

        chOrbitDir.setText("Orbit direction");
        chOrbitDir.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chOrbitDirItemStateChanged(evt);
            }
        });

        bOrbDirVals.setText("Allowed values...");
        bOrbDirVals.setEnabled(false);
        bOrbDirVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrbDirValsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chSensing)
                            .addComponent(chParentId)
                            .addComponent(chOrbitNum)
                            .addComponent(chFootprint)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lSt2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbDurationUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lSt1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spSensFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lSt3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spSensTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bParentIdVals)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chPrdType)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(bPrdTypeVals)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chStatus)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(bStatusVals))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lOn1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spOrbitFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lOn2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spOrbitTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chLastOrbitOfs)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(lOf1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spLstOrbitOfs, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(bOrbDirVals))
                                            .addComponent(chOrbitDir)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lF1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lF2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chCenter))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lF3)
                                            .addComponent(lF5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spFtMinLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spFtMinLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lF4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lF6, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spFtMaxLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spFtMaxLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chParentId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bParentIdVals))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chPrdType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bPrdTypeVals))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bStatusVals)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chSensing)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSt1)
                    .addComponent(spSensFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSt3)
                    .addComponent(spSensTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lSt2)
                    .addComponent(spDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDurationUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chOrbitNum)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chLastOrbitOfs)
                        .addComponent(chOrbitDir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lOn1)
                    .addComponent(spOrbitFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lOn2)
                    .addComponent(spOrbitTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lOf1)
                    .addComponent(spLstOrbitOfs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bOrbDirVals))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chFootprint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lF1)
                    .addComponent(spWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lF2)
                    .addComponent(spHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chCenter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lF3)
                    .addComponent(spFtMinLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lF4)
                    .addComponent(spFtMaxLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spFtMinLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lF6)
                    .addComponent(spFtMaxLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lF5))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chPrdTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chPrdTypeItemStateChanged
        bPrdTypeVals.setEnabled(chPrdType.isSelected());
    }//GEN-LAST:event_chPrdTypeItemStateChanged

    private void bPrdTypeValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPrdTypeValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.PRODUCT_TYPES);
    }//GEN-LAST:event_bPrdTypeValsActionPerformed

    private void chStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chStatusItemStateChanged
        bStatusVals.setEnabled(chStatus.isSelected());
    }//GEN-LAST:event_chStatusItemStateChanged

    private void bStatusValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStatusValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.STATUSES);
    }//GEN-LAST:event_bStatusValsActionPerformed

    private void chLastOrbitOfsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chLastOrbitOfsItemStateChanged
        spLstOrbitOfs.setEnabled(chLastOrbitOfs.isSelected());
        lOf1.setEnabled(chLastOrbitOfs.isSelected());
    }//GEN-LAST:event_chLastOrbitOfsItemStateChanged

    private void chSensingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chSensingItemStateChanged
        spSensFrom.setEnabled(chSensing.isSelected());
        spSensTo.setEnabled(chSensing.isSelected());
        spDuration.setEnabled(chSensing.isSelected());
        cbDurationUnit.setEnabled(chSensing.isSelected());
        lSt1.setEnabled(chSensing.isSelected());
        lSt2.setEnabled(chSensing.isSelected());
        lSt3.setEnabled(chSensing.isSelected());
    }//GEN-LAST:event_chSensingItemStateChanged

    private void chFootprintItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chFootprintItemStateChanged
        spWidth.setEnabled(chFootprint.isSelected());
        spHeight.setEnabled(chFootprint.isSelected());
        spFtMinLat.setEnabled(chFootprint.isSelected());
        spFtMaxLat.setEnabled(chFootprint.isSelected());
        spFtMinLon.setEnabled(chFootprint.isSelected());
        spFtMaxLon.setEnabled(chFootprint.isSelected());
        chCenter.setEnabled(chFootprint.isSelected());
        lF1.setEnabled(chFootprint.isSelected());
        lF2.setEnabled(chFootprint.isSelected());
        lF3.setEnabled(chFootprint.isSelected());
        lF4.setEnabled(chFootprint.isSelected());
        lF5.setEnabled(chFootprint.isSelected());
        lF6.setEnabled(chFootprint.isSelected());
    }//GEN-LAST:event_chFootprintItemStateChanged

    private void chOrbitNumItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chOrbitNumItemStateChanged
        spOrbitFrom.setEnabled(chOrbitNum.isSelected());
        spOrbitTo.setEnabled(chOrbitNum.isSelected());
        lOn1.setEnabled(chOrbitNum.isSelected());
        lOn2.setEnabled(chOrbitNum.isSelected());
        chLastOrbitOfs.setEnabled(chOrbitNum.isSelected());
        spLstOrbitOfs.setEnabled(chOrbitNum.isSelected() && chLastOrbitOfs
                .isSelected());
        lOf1.setEnabled(chOrbitNum.isSelected() && chLastOrbitOfs.isSelected());
    }//GEN-LAST:event_chOrbitNumItemStateChanged

    private void chParentIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chParentIdItemStateChanged
        bParentIdVals.setEnabled(chParentId.isSelected());
    }//GEN-LAST:event_chParentIdItemStateChanged

    private void bParentIdValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bParentIdValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.PARENT_IDENTIFIERS);
    }//GEN-LAST:event_bParentIdValsActionPerformed

    private void bOrbDirValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrbDirValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.ORBIT_DIRS);
    }//GEN-LAST:event_bOrbDirValsActionPerformed

    private void chOrbitDirItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chOrbitDirItemStateChanged
        bOrbDirVals.setEnabled(chOrbitDir.isSelected());
    }//GEN-LAST:event_chOrbitDirItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bOrbDirVals;
    public javax.swing.JButton bParentIdVals;
    public javax.swing.JButton bPrdTypeVals;
    public javax.swing.JButton bStatusVals;
    public javax.swing.JComboBox cbDurationUnit;
    public javax.swing.JCheckBox chCenter;
    public javax.swing.JCheckBox chFootprint;
    public javax.swing.JCheckBox chLastOrbitOfs;
    public javax.swing.JCheckBox chOrbitDir;
    public javax.swing.JCheckBox chOrbitNum;
    public javax.swing.JCheckBox chParentId;
    public javax.swing.JCheckBox chPrdType;
    public javax.swing.JCheckBox chSensing;
    public javax.swing.JCheckBox chStatus;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel lF1;
    public javax.swing.JLabel lF2;
    public javax.swing.JLabel lF3;
    public javax.swing.JLabel lF4;
    public javax.swing.JLabel lF5;
    public javax.swing.JLabel lF6;
    public javax.swing.JLabel lOf1;
    public javax.swing.JLabel lOn1;
    public javax.swing.JLabel lOn2;
    public javax.swing.JLabel lSt1;
    public javax.swing.JLabel lSt2;
    public javax.swing.JLabel lSt3;
    public javax.swing.JSpinner spDuration;
    public javax.swing.JSpinner spFtMaxLat;
    public javax.swing.JSpinner spFtMaxLon;
    public javax.swing.JSpinner spFtMinLat;
    public javax.swing.JSpinner spFtMinLon;
    public javax.swing.JSpinner spHeight;
    public javax.swing.JSpinner spLstOrbitOfs;
    public javax.swing.JSpinner spOrbitFrom;
    public javax.swing.JSpinner spOrbitTo;
    public javax.swing.JSpinner spSensFrom;
    public javax.swing.JSpinner spSensTo;
    public javax.swing.JSpinner spWidth;
    public javax.swing.JTextField tfPrefix;
    // End of variables declaration//GEN-END:variables
}
