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
    public static final String POLARIZATION_CHANS = "Polarization Chans.";
    public static final String POLARIZATION_MODES = "Polarization Modes";
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
    public static final String ACQ_STATIONS = "Acq. Stations";
    public static final String ACQ_TYPE = "Acq. Types";
    public static final String ACQ_SUBTYPE = "Acq. Subtypes";
    public HashSet<String> chkbEnabled = new HashSet<>();
    public HashMap<String, Object> spinnersMap = new HashMap<>();
    public HashMap<String, Object> combosMap = new HashMap<>();
    public HashMap<String, String> textfieldsMap = new HashMap<>();
    public HashMap<String, ArrayList<String>> valMap = new HashMap<>();

    public HmaGenSettings() {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("NEW");
        strs.add("PLANNED");
        strs.add("AQUIRED");
        strs.add("PRODUCED");
        valMap.put(HmaGenSettings.STATUSES, strs);
        strs = new ArrayList<>();
        strs.add("RAW");
        strs.add("L0");
        strs.add("L1");
        strs.add("L1B");
        strs.add("ORTHO");
        valMap.put(HmaGenSettings.PRODUCT_TYPES, strs);
        strs = new ArrayList<>();
        strs.add("ASCENDING");
        strs.add("DESCENDING");
        strs.add("BOTH");
        valMap.put(HmaGenSettings.ORBIT_DIRS, strs);
        strs = new ArrayList<>();
        strs.add("NOMINAL");
        strs.add("CALIBRATION");
        valMap.put(HmaGenSettings.ACQ_TYPE, strs);
        strs = new ArrayList<>();
        strs.add("LEFT");
        strs.add("RIGHT");
        valMap.put(HmaGenSettings.ANT_LOOK_DIRS, strs);
        strs = new ArrayList<>();
        strs.add("HH");
        strs.add("VV");
        strs.add("HV");
        strs.add("VH");
        valMap.put(HmaGenSettings.POLARIZATION_CHANS, strs);
        valMap.put(HmaGenSettings.POLARIZATION_MODES, new ArrayList<String>());
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
        valMap.put(HmaGenSettings.ACQ_STATIONS, new ArrayList<String>());
        valMap.put(HmaGenSettings.ACQ_SUBTYPE, new ArrayList<String>());
    }
}
