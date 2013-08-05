/*
 * Copyright 2013 Alessandro Falappa.
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

import javax.swing.JComponent;

/**
 * Class of static utility methods for GUI classes.
 * <p/>
 * @author Alessandro Falappa
 */
public class Utils {

    /**
     * Private constructor to prevent instantiation.
     */
    private Utils() {
    }

    /**
     * Enable/disable a group of JComponents.
     * <p/>
     * @param flag  the enable/disable flag
     * @param comps the components as variable arguments
     */
    public static void groupEnable(boolean flag, JComponent... comps) {
        for (JComponent cmp : comps) {
            cmp.setEnabled(flag);
        }
    }
}
