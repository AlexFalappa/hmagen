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
package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import freemarker.template.TemplateException;
import main.HmaGenSettings;

/**
 *
 * @author sasha
 */
public class CalcModelWorker extends SwingWorker<Map, Integer> {

    private final MainFrame mf;
    private final Random rng = new Random();
    private final DateFormat df = new SimpleDateFormat(
            "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
    private Integer nRecs;
    private final File file;

    public CalcModelWorker(MainFrame mf, File outFile) {
        this.mf = mf;
        this.file = outFile;
    }

    @Override
    protected Map doInBackground() throws Exception {
        Map model = new HashMap();
        model.put("numRecs", mf.spNumRecs.getValue().toString());
        List<Map<String, String>> records = new ArrayList<>();
        model.put("records", records);
        // precalculate some values
        final Integer orbFrom = (Integer) mf.spOrbitFrom.getValue();
        final Integer orbDelta = (Integer) mf.spOrbitTo.getValue() - orbFrom;
        final Integer lstOrbOfs = (Integer) mf.spLstOrbitOfs.getValue();
        final long startTime = ((Date) mf.spSensFrom.getValue()).getTime();
        final long stopTime = ((Date) mf.spSensTo.getValue()).getTime();
        final long timeDelta = stopTime - startTime;
        final long acqStartTime = ((Date) mf.spArdtFrom.getValue()).getTime();
        final long acqStopTime = ((Date) mf.spArdtTo.getValue()).getTime();
        final long acqDelta = acqStopTime - acqStartTime;
        final Integer cldCovFrom = (Integer) mf.spCldCovFrom.getValue();
        final Integer cldCovDelta = (Integer) mf.spCldCovTo.getValue() - cldCovFrom;
        final Integer snwCovFrom = (Integer) mf.spCldCovFrom.getValue();
        final Integer snwCovDelta = (Integer) mf.spCldCovTo.getValue() - snwCovFrom;
        final Integer resFrom = (Integer) mf.spResFrom.getValue();
        final Integer resDelta = (Integer) mf.spResTo.getValue() - snwCovFrom;
        Integer durationDelta = (Integer) mf.spDuration.getValue();
        switch (mf.cbDurationUnit.getSelectedItem().toString()) {
            case "minutes":
                durationDelta *= 60000;
                break;
            case "seconds":
                durationDelta *= 1000;
                break;
            default:
            // do nothing for milliseconds
        }
        String classification = "";
        switch (mf.cbClassification.getSelectedItem().toString()) {
            case "Optical":
                classification = "OPT";
                break;
            case "Radar":
                classification = "SAR";
                break;
            case "Atmospheric":
                classification = "ATM";
                break;
        }
        // generate metadata values and fill model
        nRecs = (Integer) mf.spNumRecs.getValue();
        int chnkSize = 1;
        if (nRecs > 20) {
            chnkSize = nRecs / 20;
        }
        for (int i = 1; i <= nRecs && !isCancelled(); i++) {
            Map rec = new HashMap();
            rec.put("prodId", String.format("%s-%d", mf.tfPrefix.getText(), i));
            genEOProduct(rec, startTime, timeDelta, durationDelta, orbFrom,
                    orbDelta, lstOrbOfs, classification, cldCovFrom, cldCovDelta,
                    snwCovFrom, snwCovDelta);
            if (mf.chGenAcqPlat.isSelected()) {
                genEOAcqInfo(rec, resFrom, resDelta);
            }
            if (mf.chGenArchInfo.isSelected()) {
                genEOArchInfo(rec, acqStartTime, acqDelta);
            }
            if (mf.chGenBrwsInfo.isSelected()) {
                genEOBrwsInfo(rec);
            }
            records.add(rec);
            if (i % chnkSize == 0) {
                publish(i);
            }
        }
        publish(nRecs);
        return model;
    }

    @Override
    protected void done() {
        try {
            Map model = get();
            try (Writer out = new BufferedWriter(new FileWriter(file))) {
                mf.template.process(model, out);
            }
        } catch (ExecutionException | InterruptedException | IOException | TemplateException ex) {
            JOptionPane.showMessageDialog(mf, ex.getMessage(), "Exception",
                    JOptionPane.ERROR_MESSAGE);
        }
        mf.bGenerate.setText("Generate");
        mf.pProgress.setValue(0);
        JOptionPane.showMessageDialog(mf,
                "Generated " + nRecs + " products to:\n" + file.
                getAbsolutePath(), "Success", JOptionPane.INFORMATION_MESSAGE);
        mf.cmWorker = null;
    }

    @Override
    protected void process(List<Integer> chunks) {
        for (Integer i : chunks) {
            mf.pProgress.setValue(i);
        }
    }

    private void genFootprintAndCenter(Map rec) {
        double top = -90.0 + rng.nextDouble() * 180.0;
        double left = -180.0 + rng.nextDouble() * 360.0;
        double h = rng.nextDouble() * (double) mf.spHeight.getValue();
        double w = rng.nextDouble() * (double) mf.spWidth.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(left)).append(' ').append(String.valueOf(top)).
                append(' ');
        sb.append(String.valueOf(left + w)).append(' ').append(String.valueOf(
                top)).append(' ');
        sb.append(String.valueOf(left + w)).append(' ').append(String.valueOf(
                top - h)).append(' ');
        sb.append(String.valueOf(left)).append(' ').append(String.valueOf(
                top - h)).append(' ');
        sb.append(String.valueOf(left)).append(' ').append(String.valueOf(top));
        rec.put("footprint", sb.toString());
        if (mf.chCenter.isSelected()) {
            sb.setLength(0);
            sb.append(String.valueOf(left + w / 2)).append(' ').append(String.
                    valueOf(top - h / 2));
            rec.put("center", sb.toString());
        }
    }

    private void genEOProduct(Map rec, final long startTime, final long timeDelta, Integer durationDelta, final Integer orbFrom, final Integer orbDelta, final Integer lstOrbOfs, String classification, final Integer cldCovFrom, final Integer cldCovDelta, final Integer snwCovFrom, final Integer snwCovDelta) {
        ArrayList<String> vals = mf.settings.valMap.get(
                HmaGenSettings.PARENT_IDENTIFIERS);
        if (mf.chParentId.isSelected() && vals != null) {
            genValue("parentId", rec, vals);
        }
        vals = mf.settings.valMap.get(HmaGenSettings.PRODUCT_TYPES);
        if (mf.chPrdType.isSelected() && vals != null) {
            genValue("prdType", rec, vals);
        }
        vals = mf.settings.valMap.get(HmaGenSettings.STATUSES);
        if (mf.chStatus.isSelected() && vals != null) {
            genValue("status", rec, vals);
        }
        vals = mf.settings.valMap.get(HmaGenSettings.POLARIZATIONS);
        if (mf.chPolarztn.isSelected()) {
            genValue("polarisation", rec, vals);
        }
        if (mf.chSensing.isSelected()) {
            long time = startTime + (long) (Math.floor(
                    rng.nextDouble() * timeDelta));
            rec.put("startSensing", df.format(new Date(time)));
            time += rng.nextInt(durationDelta);
            rec.put("stopSensing", df.format(new Date(time)));
        }
        if (mf.chOrbitNum.isSelected()) {
            Integer orb = orbFrom + rng.nextInt(orbDelta);
            rec.put("orbitNumber", orb.toString());
            if (mf.chLastOrbitOfs.isSelected()) {
                orb += rng.nextInt(lstOrbOfs);
                rec.put("lastOrbit", orb.toString());
            }
        }
        if (mf.chClassification.isSelected()) {
            rec.put("classif", classification);
        }
        if (mf.chFootprint.isSelected()) {
            genFootprintAndCenter(rec);
        }
        if (mf.chCloudCov.isSelected()) {
            Integer cover = cldCovFrom + rng.nextInt(cldCovDelta);
            rec.put("cloudCover", cover.toString());
        }
        if (mf.chSnowCov.isSelected()) {
            Integer cover = snwCovFrom + rng.nextInt(snwCovDelta);
            rec.put("snowCover", cover.toString());
        }
    }

    private void genEOArchInfo(Map rec, long acqStartTime, long acqDelta) {
        ArrayList<String> vals = mf.settings.valMap.get(
                HmaGenSettings.ARCHIVING_CENTERS);
        genValue("archCenter", rec, vals);
        if (mf.chArchId.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.ARCHIVING_IDS);
            genValue("archId", rec, vals);
        }
        if (mf.chArchDate.isSelected()) {
            long time = acqStartTime + (long) (Math.floor(
                    rng.nextDouble() * acqDelta));
            rec.put("archDate", df.format(new Date(time)));
        }
    }

    private void genEOAcqInfo(Map rec, Integer resFrom, Integer resDelta) {
        ArrayList<String> vals = mf.settings.valMap.
                get(HmaGenSettings.PLATFORMS);
        genValue("platName", rec, vals);
        if (mf.chSerId.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.SER_IDS);
            genValue("platSer", rec, vals);
        }
        if (mf.chSensName.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.SENS_NAMES);
            genValue("sensName", rec, vals);
        }
        if (mf.chSensMode.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.SENS_MODES);
            genValue("sensMode", rec, vals);
        }
        if (mf.chSensType.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.SENS_TYPES);
            genValue("sensType", rec, vals);
        }
        if (mf.chSwthId.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.SWATH_IDS);
            genValue("swathId", rec, vals);
        }
        if (mf.chRes.isSelected()) {
            Integer res = resFrom + rng.nextInt(resDelta);
            rec.put("resolution", res.toString());
        }
    }

    private void genEOBrwsInfo(Map rec) {
        ArrayList<String> vals = mf.settings.valMap.get(
                HmaGenSettings.THUMB_URLS);
        genValue("thmbUrl", rec, vals);
        if (mf.chQlkUrl.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.QLOOK_URLS);
            genValue("qlkUrl", rec, vals);
        }
    }

    private void genValue(String key, Map rec, ArrayList<String> vals) {
        if (vals.size() > 1) {
            rec.put(key, vals.get(rng.nextInt(vals.size())));
        } else {
            rec.put(key, vals.get(0));
        }
    }
}
