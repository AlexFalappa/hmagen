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
package gui.panels;

import gui.Utils;
import main.App;
import main.HmaGenSettings;

/**
 * Panel for EOBrowseInformation extrinsic object attributes.
 * <p>
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public class EOBrowsePanel extends javax.swing.JPanel {

    /**
     * Creates new form EOBrowsePanel
     */
    public EOBrowsePanel() {
        initComponents();
    }

    @Override
    public void setEnabled(boolean flag) {
        chGenBrwsInfo.setEnabled(flag);
        chLinkQlkToThmb.setEnabled(flag && chQlkUrl.isSelected());
        chQlkUrl.setEnabled(flag && chGenBrwsInfo.isSelected());
        bQlkUrlsVals.setEnabled(flag && chQlkUrl.isSelected());
        bThmbUrlsVals.setEnabled(flag && chGenBrwsInfo.isSelected());
        lBr1.setEnabled(flag && chGenBrwsInfo.isSelected());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chGenBrwsInfo = new javax.swing.JCheckBox();
        lBr1 = new javax.swing.JLabel();
        chQlkUrl = new javax.swing.JCheckBox();
        bThmbUrlsVals = new javax.swing.JButton();
        bQlkUrlsVals = new javax.swing.JButton();
        chLinkQlkToThmb = new javax.swing.JCheckBox();

        chGenBrwsInfo.setText("Generate");
        chGenBrwsInfo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chGenBrwsInfoItemStateChanged(evt);
            }
        });

        lBr1.setText("Thumbnail URL");
        lBr1.setEnabled(false);

        chQlkUrl.setText("Quicklook URL");
        chQlkUrl.setEnabled(false);
        chQlkUrl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chQlkUrlItemStateChanged(evt);
            }
        });

        bThmbUrlsVals.setText("Allowed values...");
        bThmbUrlsVals.setEnabled(false);
        bThmbUrlsVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThmbUrlsValsActionPerformed(evt);
            }
        });

        bQlkUrlsVals.setText("Allowed values...");
        bQlkUrlsVals.setEnabled(false);
        bQlkUrlsVals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bQlkUrlsValsActionPerformed(evt);
            }
        });

        chLinkQlkToThmb.setText("Link with thumbnails");
        chLinkQlkToThmb.setEnabled(false);

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
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(bThmbUrlsVals))
                            .addComponent(lBr1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(bQlkUrlsVals))
                                    .addComponent(chQlkUrl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chLinkQlkToThmb))))
                    .addComponent(chGenBrwsInfo))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chGenBrwsInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lBr1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bThmbUrlsVals)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chQlkUrl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bQlkUrlsVals)
                    .addComponent(chLinkQlkToThmb))
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chGenBrwsInfoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chGenBrwsInfoItemStateChanged
        Utils.widgetsEnable(chGenBrwsInfo.isSelected(), lBr1, bThmbUrlsVals, chQlkUrl);
        chQlkUrlItemStateChanged(evt);
    }//GEN-LAST:event_chGenBrwsInfoItemStateChanged

    private void chQlkUrlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chQlkUrlItemStateChanged
        boolean flag = chGenBrwsInfo.isSelected() && chQlkUrl.isSelected();
        bQlkUrlsVals.setEnabled(flag);
        chLinkQlkToThmb.setEnabled(flag);
    }//GEN-LAST:event_chQlkUrlItemStateChanged

    private void bThmbUrlsValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThmbUrlsValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.THUMB_URLS);
    }//GEN-LAST:event_bThmbUrlsValsActionPerformed

    private void bQlkUrlsValsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bQlkUrlsValsActionPerformed
        App.mf.showValsDialog(HmaGenSettings.QLOOK_URLS);
    }//GEN-LAST:event_bQlkUrlsValsActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bQlkUrlsVals;
    public javax.swing.JButton bThmbUrlsVals;
    public javax.swing.JCheckBox chGenBrwsInfo;
    public javax.swing.JCheckBox chLinkQlkToThmb;
    public javax.swing.JCheckBox chQlkUrl;
    public javax.swing.JLabel lBr1;
    // End of variables declaration//GEN-END:variables
}
