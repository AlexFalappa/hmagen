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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Settings data object.
 * <p/>
 * @author sasha
 */
public class HmaGenSettings {

    public static final String STATUSES = "Statuses";
    public static final String PRODUCT_TYPES = "Product Types";
    public static final String PARENT_IDENTIFIERS = "Parent Ids.";
    public static final String POLARIZATION_CHANS = "PolarizationChannels";
    public static final String POLARIZATION_MODES = "PolarizationModes";
    public static final String ARCHIVING_CENTERS = "Archiving Centers";
    public static final String ARCHIVING_IDS = "Archiving Ids";
    public static final String THUMB_URLS = "Thumbnail Urls";
    public static final String QLOOK_URLS = "Quicklook Urls";
    public static final String PLATFORMS = "Platform Names";
    public static final String SENS_MODES = "Sensor Modes";
    public static final String SENS_TYPES = "Sensor Types";
    public static final String SENS_NAMES = "Sensor Names";
    public static final String SER_IDS = "Plat. Serial Ids.";
    public static final String SWATH_IDS = "Swath Ids.";
    public static final String ANT_LOOK_DIRS = "Ant. Look Dirs.";
    public static final String ORBIT_DIRS = "Orbit Dirs.";
    public HashSet<String> chkbEnabled = new HashSet<>();
    public HashMap<String, Object> spinnersMap = new HashMap<>();
    public HashMap<String, Object> combosMap = new HashMap<>();
    public HashMap<String, String> textfieldsMap = new HashMap<>();
    public HashMap<String, ArrayList<String>> valMap = new HashMap<>();

    public HmaGenSettings() {
        ArrayList<String> statuses = new ArrayList<>();
        statuses.add("NEW");
        statuses.add("PLANNED");
        statuses.add("AQUIRED");
        statuses.add("PRODUCED");
        valMap.put(HmaGenSettings.STATUSES, statuses);
        ArrayList<String> prdTypes = new ArrayList<>();
        prdTypes.add("RAW");
        prdTypes.add("L0");
        prdTypes.add("L1");
        prdTypes.add("L1B");
        prdTypes.add("ORTHO");
        valMap.put(HmaGenSettings.PRODUCT_TYPES, prdTypes);
        ArrayList<String> polarizations = new ArrayList<>();
        polarizations.add("HH");
        polarizations.add("VV");
        polarizations.add("HV");
        polarizations.add("VH");
        valMap.put(HmaGenSettings.POLARIZATION_CHANS, polarizations);
        valMap.put(HmaGenSettings.ARCHIVING_CENTERS, new ArrayList<String>());
        valMap.put(HmaGenSettings.ARCHIVING_IDS, new ArrayList<String>());
        valMap.put(HmaGenSettings.PARENT_IDENTIFIERS, new ArrayList<String>());
        valMap.put(HmaGenSettings.THUMB_URLS, new ArrayList<String>());
        valMap.put(HmaGenSettings.QLOOK_URLS, new ArrayList<String>());
        valMap.put(HmaGenSettings.PLATFORMS, new ArrayList<String>());
        valMap.put(HmaGenSettings.SENS_MODES, new ArrayList<String>());
        valMap.put(HmaGenSettings.SENS_TYPES, new ArrayList<String>());
        valMap.put(HmaGenSettings.SENS_NAMES, new ArrayList<String>());
        valMap.put(HmaGenSettings.SER_IDS, new ArrayList<String>());
        valMap.put(HmaGenSettings.SWATH_IDS, new ArrayList<String>());
    }
}
