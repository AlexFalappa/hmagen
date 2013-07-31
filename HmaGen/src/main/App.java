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
package main;

import gui.MainFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Application entry point.
 * <p/>
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public class App {

    public static MainFrame mf = null;

    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            //ignored
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mf = new MainFrame();
                mf.setLocationRelativeTo(null);
                mf.setVisible(true);
            }
        });
    }
}
