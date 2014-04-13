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

import gui.Utils;
import main.App;
import main.HmaGenSettings;

/**
 *
 * @author sasha
 */
public class EOProductPanel2 extends javax.swing.JPanel {

    /**
     * Creates new form EOProductPanel
     */
    public EOProductPanel2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lAd2 = new javax.swing.JLabel();
        spAcqDateFrom = new javax.swing.JSpinner();
        spAcqDateTo = new javax.swing.JSpinner();
        chAcqSubtype = new javax.swing.JCheckBox();
        bAcqSubtypeVals = new javax.swing.JButton();
        chAcqStation = new javax.swing.JCheckBox();
        bAcqStatnVals = new javax.swing.JButton();
        chAcqDate = new javax.swing.JCheckBox();
        lAd1 = new javax.swing.JLabel();
        spAcrIncidFrom = new javax.swing.JSpinner();
        spAcrIncidTo = new javax.swing.JSpinner();
        lAti2 = new javax.swing.JLabel();
        chAcrIncid = new javax.swing.JCheckBox();
        lAti1 = new javax.swing.JLabel();
        chAcqType = new javax.swing.JCheckBox();
        bAcqTypeVals = new javax.swing.JButton();
        chAlonIncid = new javax.swing.JCheckBox();
        lAlti2 = new javax.swing.JLabel();
        lAlti1 = new javax.swing.JLabel();
        spAlonIncidFrom = new javax.swing.JSpinner();
        spAlonIncidTo = new javax.swing.JSpinner();
        chWRSLon = new javax.swing.JCheckBox();
        chWRSLat = new javax.swing.JCheckBox();
        lWla2 = new javax.swing.JLabel();
        lWlo2 = new javax.swing.JLabel();
        lWlo1 = new javax.swing.JLabel();
        spWRSLonFrom = new javax.swing.JSpinner();
        spWRSLonTo = new javax.swing.JSpinner();
        spWRSLatFrom = new javax.swing.JSpinner();
        spWRSLatTo = new javax.swing.JSpinner();
        lWla1 = new javax.swing.JLabel();
        chANX = new javax.swing.JCheckBox();
        lNX2 = new javax.swing.JLabel();
        lNX1 = new javax.swing.JLabel();
        spANXFrom = new javax.swing.JSpinner();
        spANXTo = new javax.swing.JSpinner();
        chIncid = new javax.swing.JCheckBox();
        lIa2 = new javax.swing.JLabel();
        lIa1 = new javax.swing.JLabel();
        spIncidAngFrom = new javax.swing.JSpinner();
        spIncidAngTo = new javax.swing.JSpinner();

        lAd2.setText("to");
        lAd2.setEnabled(false);

        spAcqDateFrom.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.SECOND));
        spAcqDateFrom.setEditor(new javax.swing.JSpinner.DateEditor(spAcqDateFrom, "yyyy-MM-dd HH:mm:ss"));
        spAcqDateFrom.setEnabled(false);

        spAcqDateTo.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.SECOND));
        spAcqDateTo.setEditor(new javax.swing.JSpinner.DateEditor(spAcqDateTo, "yyyy-MM-dd HH:mm:ss"));
        spAcqDateTo.setEnabled(false);

        chAcqSubtype.setText("Acquisition subtype");
        chAcqSubtype.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chAcqSubtypeItemStateChanged(evt);
            }
        });

        bAcqSubtypeVals.setText("Allowed values...");
        bAcqSubtypeVals.setEnabled(false);
        bAcqSubtypeVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAcqSubtypeValsActionPerformed(evt);
            }
        });

        chAcqStation.setText("Acquisition station");
        chAcqStation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chAcqStationItemStateChanged(evt);
            }
        });

        bAcqStatnVals.setText("Allowed values...");
        bAcqStatnVals.setEnabled(false);
        bAcqStatnVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAcqStatnValsActionPerformed(evt);
            }
        });

        chAcqDate.setText("Acquisition date");
        chAcqDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chAcqDateItemStateChanged(evt);
            }
        });

        lAd1.setText("from");
        lAd1.setEnabled(false);

        spAcrIncidFrom.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(5.0d)));
        spAcrIncidFrom.setEnabled(false);

        spAcrIncidTo.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(100.0d), null, null, Double.valueOf(5.0d)));
        spAcrIncidTo.setEnabled(false);

        lAti2.setText("to");
        lAti2.setEnabled(false);

        chAcrIncid.setText("Across track incidence angle");
        chAcrIncid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chAcrIncidItemStateChanged(evt);
            }
        });

        lAti1.setText("from");
        lAti1.setEnabled(false);

        chAcqType.setText("Acquisition type");
        chAcqType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chAcqTypeItemStateChanged(evt);
            }
        });

        bAcqTypeVals.setText("Allowed values...");
        bAcqTypeVals.setEnabled(false);
        bAcqTypeVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAcqTypeValsActionPerformed(evt);
            }
        });

        chAlonIncid.setText("Along track incidence angle");
        chAlonIncid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chAlonIncidItemStateChanged(evt);
            }
        });

        lAlti2.setText("to");
        lAlti2.setEnabled(false);

        lAlti1.setText("from");
        lAlti1.setEnabled(false);

        spAlonIncidFrom.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(5.0d)));
        spAlonIncidFrom.setEnabled(false);

        spAlonIncidTo.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(100.0d), null, null, Double.valueOf(5.0d)));
        spAlonIncidTo.setEnabled(false);

        chWRSLon.setText("WRS longitude (frame)");
        chWRSLon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chWRSLonItemStateChanged(evt);
            }
        });

        chWRSLat.setText("WRS latitude (track)");
        chWRSLat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chWRSLatItemStateChanged(evt);
            }
        });

        lWla2.setText("to");
        lWla2.setEnabled(false);

        lWlo2.setText("to");
        lWlo2.setEnabled(false);

        lWlo1.setText("from");
        lWlo1.setEnabled(false);

        spWRSLonFrom.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(5.0d)));
        spWRSLonFrom.setEnabled(false);

        spWRSLonTo.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(100.0d), null, null, Double.valueOf(5.0d)));
        spWRSLonTo.setEnabled(false);

        spWRSLatFrom.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(5.0d)));
        spWRSLatFrom.setEnabled(false);

        spWRSLatTo.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(100.0d), null, null, Double.valueOf(5.0d)));
        spWRSLatTo.setEnabled(false);

        lWla1.setText("from");
        lWla1.setEnabled(false);

        chANX.setText("Ascending node longitude");
        chANX.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chANXItemStateChanged(evt);
            }
        });

        lNX2.setText("to");
        lNX2.setEnabled(false);

        lNX1.setText("from");
        lNX1.setEnabled(false);

        spANXFrom.setModel(new javax.swing.SpinnerNumberModel(-180.0d, -180.0d, 180.0d, 2.0d));
        spANXFrom.setEnabled(false);

        spANXTo.setModel(new javax.swing.SpinnerNumberModel(180.0d, -180.0d, 180.0d, 5.0d));
        spANXTo.setEnabled(false);

        chIncid.setText("Incidence angle");
        chIncid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chIncidItemStateChanged(evt);
            }
        });

        lIa2.setText("to");
        lIa2.setEnabled(false);

        lIa1.setText("from");
        lIa1.setEnabled(false);

        spIncidAngFrom.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(5.0d)));
        spIncidAngFrom.setEnabled(false);

        spIncidAngTo.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(100.0d), null, null, Double.valueOf(5.0d)));
        spIncidAngTo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chAcqDate)
                    .addComponent(chAcqType)
                    .addComponent(chAcrIncid)
                    .addComponent(chWRSLat)
                    .addComponent(chANX)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lAd1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spAcqDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lAd2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spAcqDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bAcqTypeVals)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chAcqSubtype)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(bAcqSubtypeVals)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chAcqStation)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(bAcqStatnVals))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lAti1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spAcrIncidFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lAti2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spAcrIncidTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chAlonIncid)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(lAlti1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spAlonIncidFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lAlti2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spAlonIncidTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lWla1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spWRSLatFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lWla2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spWRSLatTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chWRSLon)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(lWlo1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spWRSLonFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lWlo2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spWRSLonTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lNX1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spANXFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lNX2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spANXTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chIncid)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(lIa1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spIncidAngFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lIa2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spIncidAngTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chAcqType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAcqTypeVals))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chAcqSubtype)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAcqSubtypeVals))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chAcqStation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAcqStatnVals)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chAcqDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lAd1)
                            .addComponent(spAcqDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lAd2)
                            .addComponent(spAcqDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chAcrIncid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lAti1)
                                    .addComponent(spAcrIncidFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lAti2)
                                    .addComponent(spAcrIncidTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chAlonIncid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lAlti1)
                                    .addComponent(spAlonIncidFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lAlti2)
                                    .addComponent(spAlonIncidTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chWRSLat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lWla1)
                                    .addComponent(spWRSLatFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lWla2)
                                    .addComponent(spWRSLatTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chWRSLon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lWlo1)
                                    .addComponent(spWRSLonFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lWlo2)
                                    .addComponent(spWRSLonTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chANX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNX1)
                            .addComponent(spANXFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lNX2)
                            .addComponent(spANXTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chIncid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lIa1)
                            .addComponent(spIncidAngFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lIa2)
                            .addComponent(spIncidAngTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chAcqSubtypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chAcqSubtypeItemStateChanged
        bAcqSubtypeVals.setEnabled(chAcqSubtype.isSelected());
    }//GEN-LAST:event_chAcqSubtypeItemStateChanged

    private void bAcqSubtypeValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAcqSubtypeValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.ACQ_SUBTYPE);
    }//GEN-LAST:event_bAcqSubtypeValsActionPerformed

    private void chAcqStationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chAcqStationItemStateChanged
        bAcqStatnVals.setEnabled(chAcqStation.isSelected());
    }//GEN-LAST:event_chAcqStationItemStateChanged

    private void bAcqStatnValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAcqStatnValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.ACQ_STATIONS);
    }//GEN-LAST:event_bAcqStatnValsActionPerformed

    private void chAcqDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chAcqDateItemStateChanged
        Utils.widgetsEnable(chAcqDate.isSelected(), spAcqDateFrom, spAcqDateTo,
                lAd1, lAd2);
    }//GEN-LAST:event_chAcqDateItemStateChanged

    private void chAcrIncidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chAcrIncidItemStateChanged
        Utils.widgetsEnable(chAcrIncid.isSelected(), spAcrIncidFrom, spAcrIncidTo,
                lAti1, lAti2);
    }//GEN-LAST:event_chAcrIncidItemStateChanged

    private void chAcqTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chAcqTypeItemStateChanged
        bAcqTypeVals.setEnabled(chAcqType.isSelected());
    }//GEN-LAST:event_chAcqTypeItemStateChanged

    private void bAcqTypeValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAcqTypeValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.ACQ_TYPE);
    }//GEN-LAST:event_bAcqTypeValsActionPerformed

    private void chAlonIncidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chAlonIncidItemStateChanged
        Utils.widgetsEnable(chAlonIncid.isSelected(), lAlti1, lAlti2,
                spAlonIncidFrom, spAlonIncidTo);
    }//GEN-LAST:event_chAlonIncidItemStateChanged

    private void chWRSLonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chWRSLonItemStateChanged
        Utils.widgetsEnable(chWRSLon.isSelected(), lWlo1, lWlo2, spWRSLonFrom,
                spWRSLonTo);
    }//GEN-LAST:event_chWRSLonItemStateChanged

    private void chWRSLatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chWRSLatItemStateChanged
        Utils.widgetsEnable(chWRSLat.isSelected(), lWla1, lWla2, spWRSLatFrom,
                spWRSLatTo);
    }//GEN-LAST:event_chWRSLatItemStateChanged

    private void chANXItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chANXItemStateChanged
        Utils.widgetsEnable(chANX.isSelected(), lNX1, lNX2, spANXFrom, spANXTo);
    }//GEN-LAST:event_chANXItemStateChanged

    private void chIncidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chIncidItemStateChanged
        Utils.widgetsEnable(chIncid.isSelected(), lIa1, lIa2, spIncidAngFrom,
                spIncidAngTo);
    }//GEN-LAST:event_chIncidItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bAcqStatnVals;
    public javax.swing.JButton bAcqSubtypeVals;
    public javax.swing.JButton bAcqTypeVals;
    public javax.swing.JCheckBox chANX;
    public javax.swing.JCheckBox chAcqDate;
    public javax.swing.JCheckBox chAcqStation;
    public javax.swing.JCheckBox chAcqSubtype;
    public javax.swing.JCheckBox chAcqType;
    public javax.swing.JCheckBox chAcrIncid;
    public javax.swing.JCheckBox chAlonIncid;
    public javax.swing.JCheckBox chIncid;
    public javax.swing.JCheckBox chWRSLat;
    public javax.swing.JCheckBox chWRSLon;
    public javax.swing.JLabel lAd1;
    public javax.swing.JLabel lAd2;
    public javax.swing.JLabel lAlti1;
    public javax.swing.JLabel lAlti2;
    public javax.swing.JLabel lAti1;
    public javax.swing.JLabel lAti2;
    public javax.swing.JLabel lIa1;
    public javax.swing.JLabel lIa2;
    public javax.swing.JLabel lNX1;
    public javax.swing.JLabel lNX2;
    public javax.swing.JLabel lWla1;
    public javax.swing.JLabel lWla2;
    public javax.swing.JLabel lWlo1;
    public javax.swing.JLabel lWlo2;
    public javax.swing.JSpinner spANXFrom;
    public javax.swing.JSpinner spANXTo;
    public javax.swing.JSpinner spAcqDateFrom;
    public javax.swing.JSpinner spAcqDateTo;
    public javax.swing.JSpinner spAcrIncidFrom;
    public javax.swing.JSpinner spAcrIncidTo;
    public javax.swing.JSpinner spAlonIncidFrom;
    public javax.swing.JSpinner spAlonIncidTo;
    public javax.swing.JSpinner spIncidAngFrom;
    public javax.swing.JSpinner spIncidAngTo;
    public javax.swing.JSpinner spWRSLatFrom;
    public javax.swing.JSpinner spWRSLatTo;
    public javax.swing.JSpinner spWRSLonFrom;
    public javax.swing.JSpinner spWRSLonTo;
    // End of variables declaration//GEN-END:variables
}
