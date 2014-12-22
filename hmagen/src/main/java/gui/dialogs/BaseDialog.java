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
package gui.dialogs;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import main.specattrs.SpecAttr;

/**
 * Base class for specific attributes dialogs.
 *
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public abstract class BaseDialog extends JDialog {

    protected int option = JOptionPane.CANCEL_OPTION;

    public BaseDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    public int getOption() {
        return option;
    }

    public abstract SpecAttr getAttr();

    protected void doOk() {
        option = JOptionPane.OK_OPTION;
        setVisible(false);
    }

    protected void doCancel() {
        setVisible(false);
    }
}
