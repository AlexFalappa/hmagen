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
package main.specattrs;

import java.util.ArrayList;
import java.util.Random;

/**
 * HMA specific attribute of String datatype.
 * <p>
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public class StringSpecAttr implements SpecAttr {

    String attrName;
    ArrayList<String> attrValues;

    public StringSpecAttr(String attrName, ArrayList<String> attrValues) {
        this.attrName = attrName;
        this.attrValues = attrValues;
    }

    public String getName() {
        return attrName;
    }

    @Override
    public Object getRandValue(Random rgen) {
        return attrValues.get(rgen.nextInt(attrValues.size()));
    }

    @Override
    public String toString() {
        return String.format("%s with values %s", attrName, attrValues.toString());
    }

}
