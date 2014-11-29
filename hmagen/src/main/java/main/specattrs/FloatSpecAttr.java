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

import java.util.Random;

/**
 * HMA specific attribute of Float datatype.
 * <p>
 * @author Alessandro Falappa <alex.falappa@gmail.com>
 */
public class FloatSpecAttr implements SpecAttr {

    String attrName;
    Float attrValue1;
    Float attrValue2;

    public FloatSpecAttr(String attrName, Float value1, Float value2) {
        if (value1 > value2)
            throw new IllegalArgumentException("value 2 must be grater than value1");
        this.attrName = attrName;
        this.attrValue1 = value1;
        this.attrValue2 = value2;
    }

    public String getName() {
        return attrName;
    }

    @Override
    public Object getRandValue(Random rgen) {
        if (attrValue1.compareTo(attrValue2) == 0)
            return attrValue1;
        else
            return attrValue1 + rgen.nextFloat() * (attrValue2 - attrValue1);
    }

    @Override
    public String toString() {
        return String.format("%s from %f to %f", attrName, attrValue1, attrValue2);
    }

}
