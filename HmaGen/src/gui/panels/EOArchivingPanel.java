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
 * Panel for EOArchiving extrinsic object attributes.
 * <p>
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public class EOArchivingPanel extends javax.swing.JPanel {

    /**
     * Creates new form EOArchivingPanel
     */
    public EOArchivingPanel() {
        initComponents();
    }

    @Override
    public void setEnabled(boolean flag) {
        chGenArchInfo.setEnabled(flag);
        chArchDate.setEnabled(flag && chGenArchInfo.isSelected());
        chArchId.setEnabled(flag && chGenArchInfo.isSelected());
        bArCntVals.setEnabled(flag && chGenArchInfo.isSelected());
        bArchIdVals.setEnabled(flag && chArchId.isSelected());
        spArdtFrom.setEnabled(flag && chArchDate.isSelected());
        spArdtTo.setEnabled(flag && chArchDate.isSelected());
        lAr1.setEnabled(flag && chGenArchInfo.isSelected());
        lAd1.setEnabled(flag && chArchDate.isSelected());
        lAd2.setEnabled(flag && chArchDate.isSelected());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bArchIdVals = new javax.swing.JButton();
        chArchId = new javax.swing.JCheckBox();
        chArchDate = new javax.swing.JCheckBox();
        chGenArchInfo = new javax.swing.JCheckBox();
        lAr1 = new javax.swing.JLabel();
        bArCntVals = new javax.swing.JButton();
        lAd2 = new javax.swing.JLabel();
        spArdtFrom = new javax.swing.JSpinner();
        spArdtTo = new javax.swing.JSpinner();
        lAd1 = new javax.swing.JLabel();

        bArchIdVals.setText("Allowed values...");
        bArchIdVals.setEnabled(false);
        bArchIdVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bArchIdValsActionPerformed(evt);
            }
        });

        chArchId.setText("Archiving identifier");
        chArchId.setEnabled(false);
        chArchId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chArchIdItemStateChanged(evt);
            }
        });

        chArchDate.setText("Archiving date");
        chArchDate.setEnabled(false);
        chArchDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chArchDateItemStateChanged(evt);
            }
        });

        chGenArchInfo.setText("Generate");
        chGenArchInfo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chGenArchInfoItemStateChanged(evt);
            }
        });

        lAr1.setText("Archiving Center");
        lAr1.setEnabled(false);

        bArCntVals.setText("Allowed values...");
        bArCntVals.setEnabled(false);
        bArCntVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bArCntValsActionPerformed(evt);
            }
        });

        lAd2.setText("to");
        lAd2.setEnabled(false);

        spArdtFrom.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.SECOND));
        spArdtFrom.setEditor(new javax.swing.JSpinner.DateEditor(spArdtFrom, "yyyy-MM-dd HH:mm:ss"));
        spArdtFrom.setEnabled(false);

        spArdtTo.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.SECOND));
        spArdtTo.setEditor(new javax.swing.JSpinner.DateEditor(spArdtTo, "yyyy-MM-dd HH:mm:ss"));
        spArdtTo.setEnabled(false);

        lAd1.setText("from");
        lAd1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chArchDate)
                            .addComponent(lAr1)
                            .addComponent(chArchId)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lAd1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spArdtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lAd2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spArdtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(bArCntVals)
                                        .addComponent(bArchIdVals))))))
                    .addComponent(chGenArchInfo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chGenArchInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lAr1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bArCntVals)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chArchId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bArchIdVals)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chArchDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lAd1)
                    .addComponent(spArdtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lAd2)
                    .addComponent(spArdtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bArchIdValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bArchIdValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.ARCHIVING_IDS);
    }//GEN-LAST:event_bArchIdValsActionPerformed

    private void chArchIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chArchIdItemStateChanged
        bArchIdVals.setEnabled(chGenArchInfo.isSelected() && chArchId
                .isSelected());
    }//GEN-LAST:event_chArchIdItemStateChanged

    private void chArchDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chArchDateItemStateChanged
        boolean flag = chGenArchInfo.isSelected() && chArchDate.isSelected();
        Utils.widgetsEnable(flag, spArdtFrom, spArdtTo, lAd1, lAd2);
    }//GEN-LAST:event_chArchDateItemStateChanged

    private void chGenArchInfoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chGenArchInfoItemStateChanged
        Utils.widgetsEnable(chGenArchInfo.isSelected(), lAr1, bArCntVals,
                chArchDate, chArchId);
        chArchDateItemStateChanged(evt);
        chArchIdItemStateChanged(evt);
    }//GEN-LAST:event_chGenArchInfoItemStateChanged

    private void bArCntValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bArCntValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.ARCHIVING_CENTERS);
    }//GEN-LAST:event_bArCntValsActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bArCntVals;
    public javax.swing.JButton bArchIdVals;
    public javax.swing.JCheckBox chArchDate;
    public javax.swing.JCheckBox chArchId;
    public javax.swing.JCheckBox chGenArchInfo;
    public javax.swing.JLabel lAd1;
    public javax.swing.JLabel lAd2;
    public javax.swing.JLabel lAr1;
    public javax.swing.JSpinner spArdtFrom;
    public javax.swing.JSpinner spArdtTo;
    // End of variables declaration//GEN-END:variables
}
