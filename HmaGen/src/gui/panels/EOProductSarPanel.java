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
public class EOProductSarPanel extends javax.swing.JPanel {

    /**
     * Creates new form EOProductSarPanel
     */
    public EOProductSarPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chPolarzChans = new javax.swing.JCheckBox();
        bPlrzChVals = new javax.swing.JButton();
        chPolarzModes = new javax.swing.JCheckBox();
        bPlrzMdVals = new javax.swing.JButton();
        chMinIncidAng = new javax.swing.JCheckBox();
        chMaxIncidAng = new javax.swing.JCheckBox();
        lMni1 = new javax.swing.JLabel();
        lMni2 = new javax.swing.JLabel();
        spMinIaTo = new javax.swing.JSpinner();
        spMinIaFrom = new javax.swing.JSpinner();
        spMaxIaFrom = new javax.swing.JSpinner();
        spMaxIaTo = new javax.swing.JSpinner();
        lMxi2 = new javax.swing.JLabel();
        lMxi1 = new javax.swing.JLabel();
        chAntLook = new javax.swing.JCheckBox();
        bAntLookVals = new javax.swing.JButton();

        chPolarzChans.setText("Polarization Channels");
        chPolarzChans.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chPolarzChansItemStateChanged(evt);
            }
        });

        bPlrzChVals.setText("Allowed values...");
        bPlrzChVals.setEnabled(false);
        bPlrzChVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPlrzChValsActionPerformed(evt);
            }
        });

        chPolarzModes.setText("Polarization Modes");
        chPolarzModes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chPolarzModesItemStateChanged(evt);
            }
        });

        bPlrzMdVals.setText("Allowed values...");
        bPlrzMdVals.setEnabled(false);
        bPlrzMdVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPlrzMdValsActionPerformed(evt);
            }
        });

        chMinIncidAng.setText("Minimum incidence angle");
        chMinIncidAng.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chMinIncidAngItemStateChanged(evt);
            }
        });

        chMaxIncidAng.setText("Maximum incidence angle");
        chMaxIncidAng.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chMaxIncidAngItemStateChanged(evt);
            }
        });

        lMni1.setText("from");
        lMni1.setEnabled(false);

        lMni2.setText("to");
        lMni2.setEnabled(false);

        spMinIaTo.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(100.0d), null, null, Double.valueOf(5.0d)));
        spMinIaTo.setEnabled(false);

        spMinIaFrom.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(5.0d)));
        spMinIaFrom.setEnabled(false);

        spMaxIaFrom.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(5.0d)));
        spMaxIaFrom.setEnabled(false);

        spMaxIaTo.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(100.0d), null, null, Double.valueOf(5.0d)));
        spMaxIaTo.setEnabled(false);

        lMxi2.setText("to");
        lMxi2.setEnabled(false);

        lMxi1.setText("from");
        lMxi1.setEnabled(false);

        chAntLook.setText("Antenna Look Direction");
        chAntLook.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chAntLookItemStateChanged(evt);
            }
        });

        bAntLookVals.setText("Allowed values...");
        bAntLookVals.setEnabled(false);
        bAntLookVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAntLookValsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chMinIncidAng)
                            .addComponent(chPolarzChans)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(bPlrzChVals))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lMni1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spMinIaFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lMni2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spMinIaTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lMxi1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spMaxIaFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lMxi2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spMaxIaTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(33, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chPolarzModes)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(bPlrzMdVals))
                                    .addComponent(chMaxIncidAng))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(bAntLookVals))
                            .addComponent(chAntLook))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chPolarzModes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bPlrzMdVals))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chPolarzChans)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bPlrzChVals)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chMinIncidAng)
                    .addComponent(chMaxIncidAng))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lMxi1)
                        .addComponent(spMaxIaFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lMxi2)
                        .addComponent(spMaxIaTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lMni1)
                        .addComponent(spMinIaFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lMni2)
                        .addComponent(spMinIaTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chAntLook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAntLookVals)
                .addContainerGap(71, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chPolarzChansItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chPolarzChansItemStateChanged
        bPlrzChVals.setEnabled(chPolarzChans.isSelected());
    }//GEN-LAST:event_chPolarzChansItemStateChanged

    private void bPlrzChValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPlrzChValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.POLARIZATION_CHANS);
    }//GEN-LAST:event_bPlrzChValsActionPerformed

    private void chPolarzModesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chPolarzModesItemStateChanged
        bPlrzMdVals.setEnabled(chPolarzModes.isSelected());
    }//GEN-LAST:event_chPolarzModesItemStateChanged

    private void bPlrzMdValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPlrzMdValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.POLARIZATION_MODES);
    }//GEN-LAST:event_bPlrzMdValsActionPerformed

    private void chMinIncidAngItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chMinIncidAngItemStateChanged
        Utils.widgetsEnable(chMinIncidAng.isSelected(), spMinIaFrom, spMinIaTo, lMni1, lMni2);
    }//GEN-LAST:event_chMinIncidAngItemStateChanged

    private void chMaxIncidAngItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chMaxIncidAngItemStateChanged
        Utils.widgetsEnable(chMaxIncidAng.isSelected(), spMaxIaFrom, spMaxIaTo, lMxi1, lMxi2);
    }//GEN-LAST:event_chMaxIncidAngItemStateChanged

    private void bAntLookValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAntLookValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.ANT_LOOK_DIRS);
    }//GEN-LAST:event_bAntLookValsActionPerformed

    private void chAntLookItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chAntLookItemStateChanged
        bAntLookVals.setEnabled(chAntLook.isSelected());
    }//GEN-LAST:event_chAntLookItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bAntLookVals;
    public javax.swing.JButton bPlrzChVals;
    public javax.swing.JButton bPlrzMdVals;
    public javax.swing.JCheckBox chAntLook;
    public javax.swing.JCheckBox chMaxIncidAng;
    public javax.swing.JCheckBox chMinIncidAng;
    public javax.swing.JCheckBox chPolarzChans;
    public javax.swing.JCheckBox chPolarzModes;
    public javax.swing.JLabel lMni1;
    public javax.swing.JLabel lMni2;
    public javax.swing.JLabel lMxi1;
    public javax.swing.JLabel lMxi2;
    public javax.swing.JSpinner spMaxIaFrom;
    public javax.swing.JSpinner spMaxIaTo;
    public javax.swing.JSpinner spMinIaFrom;
    public javax.swing.JSpinner spMinIaTo;
    // End of variables declaration//GEN-END:variables
}
