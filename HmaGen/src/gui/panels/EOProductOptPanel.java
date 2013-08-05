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

/**
 *
 * @author sasha
 */
public class EOProductOptPanel extends javax.swing.JPanel {

    /**
     * Creates new form EOProductOptPanel
     */
    public EOProductOptPanel() {
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

        spCldCovFrom = new javax.swing.JSpinner();
        chCloudCov = new javax.swing.JCheckBox();
        lCc1 = new javax.swing.JLabel();
        spSnwCovFrom = new javax.swing.JSpinner();
        chSnowCov = new javax.swing.JCheckBox();
        spCldCovTo = new javax.swing.JSpinner();
        lCc2 = new javax.swing.JLabel();
        spSnwCovTo = new javax.swing.JSpinner();
        lSc1 = new javax.swing.JLabel();
        lSc2 = new javax.swing.JLabel();
        chIllumElev = new javax.swing.JCheckBox();
        chIllumAzim = new javax.swing.JCheckBox();
        lIe1 = new javax.swing.JLabel();
        spIllElevFrom = new javax.swing.JSpinner();
        lIe2 = new javax.swing.JLabel();
        spIllElevTo = new javax.swing.JSpinner();
        spIllAzimTo = new javax.swing.JSpinner();
        spIllAzimFrom = new javax.swing.JSpinner();
        lIa2 = new javax.swing.JLabel();
        lIa1 = new javax.swing.JLabel();

        spCldCovFrom.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(5)));
        spCldCovFrom.setEnabled(false);

        chCloudCov.setText("Cloud coverage");
        chCloudCov.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chCloudCovItemStateChanged(evt);
            }
        });

        lCc1.setText("from");
        lCc1.setEnabled(false);

        spSnwCovFrom.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(5)));
        spSnwCovFrom.setEnabled(false);

        chSnowCov.setText("Snow coverage");
        chSnowCov.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chSnowCovItemStateChanged(evt);
            }
        });

        spCldCovTo.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(100), Integer.valueOf(0), null, Integer.valueOf(5)));
        spCldCovTo.setEnabled(false);

        lCc2.setText("to");
        lCc2.setEnabled(false);

        spSnwCovTo.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(100), Integer.valueOf(0), null, Integer.valueOf(5)));
        spSnwCovTo.setEnabled(false);

        lSc1.setText("to");
        lSc1.setEnabled(false);

        lSc2.setText("from");
        lSc2.setEnabled(false);

        chIllumElev.setText("Illumination elevation angle");
        chIllumElev.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chIllumElevItemStateChanged(evt);
            }
        });

        chIllumAzim.setText("Illumination azimuth angle");
        chIllumAzim.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chIllumAzimItemStateChanged(evt);
            }
        });

        lIe1.setText("from");
        lIe1.setEnabled(false);

        spIllElevFrom.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(5.0d)));
        spIllElevFrom.setEnabled(false);

        lIe2.setText("to");
        lIe2.setEnabled(false);

        spIllElevTo.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(100.0d), null, null, Double.valueOf(5.0d)));
        spIllElevTo.setEnabled(false);

        spIllAzimTo.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(100.0d), null, null, Double.valueOf(5.0d)));
        spIllAzimTo.setEnabled(false);

        spIllAzimFrom.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(5.0d)));
        spIllAzimFrom.setEnabled(false);

        lIa2.setText("to");
        lIa2.setEnabled(false);

        lIa1.setText("from");
        lIa1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chCloudCov)
                    .addComponent(chIllumElev)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lIe1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spIllElevFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lIe2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spIllElevTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lCc1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spCldCovFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lCc2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spCldCovTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chIllumAzim)
                    .addComponent(chSnowCov)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lIa1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spIllAzimFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lIa2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spIllAzimTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lSc2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spSnwCovFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lSc1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spSnwCovTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chCloudCov)
                    .addComponent(chSnowCov))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lCc1)
                        .addComponent(spCldCovFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lCc2)
                        .addComponent(spCldCovTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lSc2)
                        .addComponent(spSnwCovFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lSc1)
                        .addComponent(spSnwCovTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chIllumElev)
                    .addComponent(chIllumAzim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lIe1)
                        .addComponent(spIllElevFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lIe2)
                        .addComponent(spIllElevTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lIa1)
                        .addComponent(spIllAzimFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lIa2)
                        .addComponent(spIllAzimTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chCloudCovItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chCloudCovItemStateChanged
        Utils.groupEnable(chCloudCov.isSelected(), spCldCovFrom, spCldCovFrom,
                spCldCovTo, lCc1, lCc2);
    }//GEN-LAST:event_chCloudCovItemStateChanged

    private void chSnowCovItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chSnowCovItemStateChanged
        Utils.groupEnable(chSnowCov.isSelected(), spSnwCovFrom, spSnwCovTo,
                lSc1, lSc2);
    }//GEN-LAST:event_chSnowCovItemStateChanged

    private void chIllumElevItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chIllumElevItemStateChanged
        Utils.groupEnable(chIllumElev.isSelected(), spIllElevFrom, spIllElevTo,
                lIe1, lIe2);
    }//GEN-LAST:event_chIllumElevItemStateChanged

    private void chIllumAzimItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chIllumAzimItemStateChanged
        Utils.groupEnable(chIllumAzim.isSelected(), spIllAzimFrom, spIllAzimTo,
                lIa1, lIa2);
    }//GEN-LAST:event_chIllumAzimItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JCheckBox chCloudCov;
    public javax.swing.JCheckBox chIllumAzim;
    public javax.swing.JCheckBox chIllumElev;
    public javax.swing.JCheckBox chSnowCov;
    public javax.swing.JLabel lCc1;
    public javax.swing.JLabel lCc2;
    public javax.swing.JLabel lIa1;
    public javax.swing.JLabel lIa2;
    public javax.swing.JLabel lIe1;
    public javax.swing.JLabel lIe2;
    public javax.swing.JLabel lSc1;
    public javax.swing.JLabel lSc2;
    public javax.swing.JSpinner spCldCovFrom;
    public javax.swing.JSpinner spCldCovTo;
    public javax.swing.JSpinner spIllAzimFrom;
    public javax.swing.JSpinner spIllAzimTo;
    public javax.swing.JSpinner spIllElevFrom;
    public javax.swing.JSpinner spIllElevTo;
    public javax.swing.JSpinner spSnwCovFrom;
    public javax.swing.JSpinner spSnwCovTo;
    // End of variables declaration//GEN-END:variables
}
