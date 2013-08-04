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

import freemarker.template.TemplateException;
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
        // envelope
        switch (mf.cbEnvelope.getSelectedIndex()) {
            case 1:
                model.put("envelope", "soap11");
                break;
            case 2:
                model.put("envelope", "soap12");
                break;
            default:
                model.put("envelope", "");
        }
        // precalculate some values
        final Integer orbFrom = (Integer) mf.pProd.spOrbitFrom.getValue();
        final Integer orbDelta = (Integer) mf.pProd.spOrbitTo.getValue() - orbFrom;
        final Integer lstOrbOfs = (Integer) mf.pProd.spLstOrbitOfs.getValue();
        final long startTime = ((Date) mf.pProd.spSensFrom.getValue()).getTime();
        final long stopTime = ((Date) mf.pProd.spSensTo.getValue()).getTime();
        final long timeDelta = stopTime - startTime;
        final long acqStart = ((Date) mf.pProd2.spAcqDateFrom.getValue())
                .getTime();
        final long acqStop = ((Date) mf.pProd2.spAcqDateTo.getValue()).getTime();
        final long acqDelta = acqStop - acqStart;
        final long archStartTime = ((Date) mf.pArch.spArdtFrom.getValue())
                .getTime();
        final long archStopTime = ((Date) mf.pArch.spArdtTo.getValue())
                .getTime();
        final long archDelta = archStopTime - archStartTime;
        final Integer cldCovFrom = (Integer) mf.pProdOpt.spCldCovFrom.getValue();
        final Integer cldCovDelta = (Integer) mf.pProdOpt.spCldCovTo.getValue() - cldCovFrom;
        final Integer snwCovFrom = (Integer) mf.pProdOpt.spCldCovFrom.getValue();
        final Integer snwCovDelta = (Integer) mf.pProdOpt.spCldCovTo.getValue() - snwCovFrom;
        final Integer resFrom = (Integer) mf.pAcq.spResFrom.getValue();
        final Integer resDelta = (Integer) mf.pAcq.spResTo.getValue() - snwCovFrom;
        Integer durationDelta = (Integer) mf.pProd.spDuration.getValue();
        switch (mf.pProd.cbDurationUnit.getSelectedItem().toString()) {
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
            rec.put("prodId", String
                    .format("%s-%d", mf.pProd.tfPrefix.getText(), i));
            genEOProduct(rec, startTime, timeDelta, durationDelta, orbFrom,
                    orbDelta, lstOrbOfs, classification, cldCovFrom, cldCovDelta,
                    snwCovFrom, snwCovDelta);
            if (mf.pAcq.chGenAcqPlat.isSelected()) {
                genEOAcqInfo(rec, resFrom, resDelta);
            }
            if (mf.pArch.chGenArchInfo.isSelected()) {
                genEOArchInfo(rec, archStartTime, archDelta);
            }
            if (mf.pBrws.chGenBrwsInfo.isSelected()) {
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
        double mxH = (double) mf.pProd.spHeight.getValue();
        double mxW = (double) mf.pProd.spWidth.getValue();
        double minLatCen = (double) mf.pProd.spFtMinLat.getValue() + mxH;
        double maxLatCen = (double) mf.pProd.spFtMaxLat.getValue() - mxH;
        double minLonCen = (double) mf.pProd.spFtMinLon.getValue() + mxW;
        double maxLonCen = (double) mf.pProd.spFtMaxLon.getValue() - mxW;
        double cenLat = minLatCen + rng.nextDouble() * (maxLatCen - minLatCen);
        double cenLon = minLonCen + rng.nextDouble() * (maxLonCen - minLonCen);
        double h2 = rng.nextDouble() * mxH / 2.0;
        double w2 = rng.nextDouble() * mxW / 2.0;
        double top = -90.0 + rng.nextDouble() * 180.0;
        double left = -180.0 + rng.nextDouble() * 360.0;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(cenLat + h2)).append(' ').append(String
                .valueOf(cenLon - w2)).append(' ');
        sb.append(String.valueOf(cenLat + h2)).append(' ').append(String
                .valueOf(cenLon + w2)).append(' ');
        sb.append(String.valueOf(cenLat - h2)).append(' ').append(String
                .valueOf(cenLon + w2)).append(' ');
        sb.append(String.valueOf(cenLat - h2)).append(' ').append(String
                .valueOf(cenLon - w2)).append(' ');
        sb.append(String.valueOf(cenLat + h2)).append(' ').append(String
                .valueOf(cenLon - w2));
        rec.put("footprint", sb.toString());
        if (mf.pProd.chCenter.isSelected()) {
            sb.setLength(0);
            sb.append(String.valueOf(cenLat)).append(' ').append(String.valueOf(
                    cenLon));
            rec.put("center", sb.toString());
        }
    }

    private void genEOProduct(Map rec, final long startTime, final long timeDelta, Integer durationDelta, final Integer orbFrom, final Integer orbDelta, final Integer lstOrbOfs, String classification, final Integer cldCovFrom, final Integer cldCovDelta, final Integer snwCovFrom, final Integer snwCovDelta) {
        ArrayList<String> vals = mf.settings.valMap.get(
                HmaGenSettings.PARENT_IDENTIFIERS);
        if (mf.pProd.chParentId.isSelected() && vals != null) {
            genValue("parentId", rec, vals);
        }
        vals = mf.settings.valMap.get(HmaGenSettings.PRODUCT_TYPES);
        if (mf.pProd.chPrdType.isSelected() && vals != null) {
            genValue("prdType", rec, vals);
        }
        vals = mf.settings.valMap.get(HmaGenSettings.STATUSES);
        if (mf.pProd.chStatus.isSelected() && vals != null) {
            genValue("status", rec, vals);
        }
        vals = mf.settings.valMap.get(HmaGenSettings.ORBIT_DIRS);
        if (mf.pProd.chOrbitDir.isSelected() && vals != null) {
            genValue("orbitDir", rec, vals);
        }
        vals = mf.settings.valMap.get(HmaGenSettings.ACQ_TYPE);
        if (mf.pProd2.chAcqType.isSelected() && vals != null) {
            genValue("acqType", rec, vals);
        }
        vals = mf.settings.valMap.get(HmaGenSettings.ACQ_SUBTYPE);
        if (mf.pProd2.chAcqSubtype.isSelected() && vals != null) {
            genValue("acqSubType", rec, vals);
        }
        vals = mf.settings.valMap.get(HmaGenSettings.ACQ_STATIONS);
        if (mf.pProd2.chAcqStation.isSelected() && vals != null) {
            genValue("acqStation", rec, vals);
        }
        vals = mf.settings.valMap.get(HmaGenSettings.POLARIZATION_CHANS);
        if (mf.pProdSar.chPolarzChans.isSelected()) {
            genValue("polarisation", rec, vals);
        }
        vals = mf.settings.valMap.get(HmaGenSettings.POLARIZATION_MODES);
        if (mf.pProdSar.chPolarzModes.isSelected()) {
            genValue("polarisationModes", rec, vals);
        }
        if (mf.pProd.chSensing.isSelected()) {
            long time = startTime + (long) (Math.floor(
                    rng.nextDouble() * timeDelta));
            rec.put("startSensing", df.format(new Date(time)));
            time += rng.nextInt(durationDelta);
            rec.put("stopSensing", df.format(new Date(time)));
        }
        if (mf.pProd.chOrbitNum.isSelected()) {
            Integer orb = orbFrom + rng.nextInt(orbDelta);
            rec.put("orbitNumber", orb.toString());
            if (mf.pProd.chLastOrbitOfs.isSelected()) {
                orb += rng.nextInt(lstOrbOfs);
                rec.put("lastOrbit", orb.toString());
            }
        }
        if (mf.chClassification.isSelected()) {
            rec.put("classif", classification);
        }
        if (mf.pProd.chFootprint.isSelected()) {
            genFootprintAndCenter(rec);
        }
        if (mf.pProdOpt.chCloudCov.isSelected()) {
            Integer cover = cldCovFrom + rng.nextInt(cldCovDelta);
            rec.put("cloudCover", cover.toString());
        }
        if (mf.pProdOpt.chSnowCov.isSelected()) {
            Integer cover = snwCovFrom + rng.nextInt(snwCovDelta);
            rec.put("snowCover", cover.toString());
        }
    }

    private void genEOArchInfo(Map rec, long acqStartTime, long acqDelta) {
        ArrayList<String> vals = mf.settings.valMap.get(
                HmaGenSettings.ARCHIVING_CENTERS);
        genValue("archCenter", rec, vals);
        if (mf.pArch.chArchId.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.ARCHIVING_IDS);
            genValue("archId", rec, vals);
        }
        if (mf.pArch.chArchDate.isSelected()) {
            long time = acqStartTime + (long) (Math.floor(
                    rng.nextDouble() * acqDelta));
            rec.put("archDate", df.format(new Date(time)));
        }
    }

    private void genEOAcqInfo(Map rec, Integer resFrom, Integer resDelta) {
        ArrayList<String> vals = mf.settings.valMap.
                get(HmaGenSettings.PLATFORMS);
        genValue("platName", rec, vals);
        if (mf.pAcq.chSerId.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.SER_IDS);
            genValue("platSer", rec, vals);
        }
        if (mf.pAcq.chSensName.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.SENS_NAMES);
            genValue("sensName", rec, vals);
        }
        if (mf.pAcq.chSensMode.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.SENS_MODES);
            genValue("sensMode", rec, vals);
        }
        if (mf.pAcq.chSensType.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.SENS_TYPES);
            genValue("sensType", rec, vals);
        }
        if (mf.pAcq.chSwthId.isSelected()) {
            vals = mf.settings.valMap.get(HmaGenSettings.SWATH_IDS);
            genValue("swathId", rec, vals);
        }
        if (mf.pAcq.chRes.isSelected()) {
            Integer res = resFrom + rng.nextInt(resDelta);
            rec.put("resolution", res.toString());
        }
    }

    private void genEOBrwsInfo(Map rec) {
        if (mf.pBrws.chQlkUrl.isSelected() && mf.pBrws.chLinkQlkToThmb
                .isSelected()) {
            ArrayList<String> thmbs = mf.settings.valMap.get(
                    HmaGenSettings.THUMB_URLS);
            ArrayList<String> qlks = mf.settings.valMap.get(
                    HmaGenSettings.QLOOK_URLS);
            int max = thmbs.size() > qlks.size() ? thmbs.size() : qlks.size();
            int rnd = rng.nextInt(max);
            rec.put("thmbUrl", thmbs.get(rnd));
            rec.put("qlkUrl", qlks.get(rnd));

        } else {
            ArrayList<String> vals = mf.settings.valMap.get(
                    HmaGenSettings.THUMB_URLS);
            genValue("thmbUrl", rec, vals);
            if (mf.pBrws.chQlkUrl.isSelected()) {
                vals = mf.settings.valMap.get(HmaGenSettings.QLOOK_URLS);
                genValue("qlkUrl", rec, vals);
            }
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
