package com.windukk.mod;

public class RegionData {
    public static final Region[] REGIONS = {new Region(0, "region_usa", "USA", "us", "310260", "T-Mobile"), new Region(1, "region_poland", "Poland", "pl", "26001", "Plus"), new Region(2, "region_kazakhstan", "Kazakhstan", "kz", "40101", "Beeline KZ"), new Region(3, "region_belarus", "Belarus", "by", "25701", "velcom"), new Region(4, "region_egypt", "Egypt", "eg", "60201", "Vodafone EG"), new Region(5, "region_finland", "Finland", "fi", "24491", "Elisa")};

    public static class Region {
        public final String countryIso;
        public final int id;
        public final String name;
        public final String operatorCode;
        public final String operatorName;
        public final String stringId;

        public Region(int id, String stringId, String name, String countryIso, String operatorCode, String operatorName) {
            this.id = id;
            this.stringId = stringId;
            this.name = name;
            this.countryIso = countryIso;
            this.operatorCode = operatorCode;
            this.operatorName = operatorName;
        }

        public String getLocalizedName() {
            return Localization.get().getRegionName(this.stringId);
        }
    }

    public static String[] getRegionNames() {
        String[] names = new String[REGIONS.length];
        for (int i = 0; i < REGIONS.length; i++) {
            names[i] = REGIONS[i].name;
        }
        return names;
    }
}
