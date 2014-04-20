/*
 * Copyright 2014 sasha.
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
import gui.dialogs.BaseDialog;
import gui.dialogs.FloatAttrsDialog;
import gui.dialogs.IntAttrsDialog;
import gui.dialogs.StringAttrsDialog;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import main.App;
import main.specattrs.SpecAttr;

/**
 * Panel for EOProduct vendor specific attributes.
 * <p>
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public class EOSpecificAttrsPanel extends javax.swing.JPanel {

    public DefaultListModel<SpecAttr> dlmAttrs;

    /**
     * Creates new form EOSpecificAttrsPanel
     */
    public EOSpecificAttrsPanel() {
        dlmAttrs = new DefaultListModel<>();
        initComponents();
    }

    public void applySettings(ArrayList<SpecAttr> specAttrsList) {
        dlmAttrs = Utils.listAsListModel(specAttrsList);
        lAttrs.setModel(dlmAttrs);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chGenSpecific = new javax.swing.JCheckBox();
        bAddString = new javax.swing.JButton();
        bAddInt = new javax.swing.JButton();
        bAddFloat = new javax.swing.JButton();
        bDel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lAttrs = new javax.swing.JList();

        chGenSpecific.setText("Generate");
        chGenSpecific.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chGenSpecificItemStateChanged(evt);
            }
        });

        bAddString.setText("+ String");
        bAddString.setEnabled(false);
        bAddString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddStringActionPerformed(evt);
            }
        });

        bAddInt.setText("+ Int");
        bAddInt.setEnabled(false);
        bAddInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddIntActionPerformed(evt);
            }
        });

        bAddFloat.setText("+ Float");
        bAddFloat.setEnabled(false);
        bAddFloat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddFloatActionPerformed(evt);
            }
        });

        bDel.setText("-");
        bDel.setEnabled(false);
        bDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDelActionPerformed(evt);
            }
        });

        lAttrs.setModel(dlmAttrs);
        lAttrs.setEnabled(false);
        lAttrs.setVisibleRowCount(6);
        jScrollPane2.setViewportView(lAttrs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bAddString)
                                    .addComponent(bDel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(bAddFloat, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(bAddInt, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(chGenSpecific))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bAddFloat, bAddInt, bAddString, bDel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chGenSpecific)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAddString)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAddInt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAddFloat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bDel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bAddStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddStringActionPerformed
        StringAttrsDialog d = new StringAttrsDialog(App.mf, true);
        askAndAddAttr(d);
    }//GEN-LAST:event_bAddStringActionPerformed

    private void bDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDelActionPerformed
        if (lAttrs.getSelectedIndex() >= 0)
            dlmAttrs.removeElementAt(lAttrs.getSelectedIndex());
    }//GEN-LAST:event_bDelActionPerformed

    private void bAddFloatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddFloatActionPerformed
        FloatAttrsDialog d = new FloatAttrsDialog(App.mf, true);
        askAndAddAttr(d);
    }//GEN-LAST:event_bAddFloatActionPerformed

    private void bAddIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddIntActionPerformed
        IntAttrsDialog d = new IntAttrsDialog(App.mf, true);
        askAndAddAttr(d);
    }//GEN-LAST:event_bAddIntActionPerformed

    private void chGenSpecificItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chGenSpecificItemStateChanged
        Utils.widgetsEnable(chGenSpecific.isSelected(), lAttrs, bAddString, bAddInt, bAddFloat,
                bDel);
    }//GEN-LAST:event_chGenSpecificItemStateChanged

    private void askAndAddAttr(BaseDialog d) {
        d.setLocationRelativeTo(this);
        d.setVisible(true);
        if (d.getOption() == JOptionPane.OK_OPTION) {
            final SpecAttr attribute = d.getAttr();
            dlmAttrs.addElement(attribute);
            App.mf.specAttrToSettings(attribute);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bAddFloat;
    public javax.swing.JButton bAddInt;
    public javax.swing.JButton bAddString;
    public javax.swing.JButton bDel;
    public javax.swing.JCheckBox chGenSpecific;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JList lAttrs;
    // End of variables declaration//GEN-END:variables
}
