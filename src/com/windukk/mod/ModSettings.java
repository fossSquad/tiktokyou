package com.windukk.mod;

import android.content.Context;
import android.content.SharedPreferences;

public class ModSettings {
    private static final String KEY_HIDE_ADS = "hide_ads";
    private static final String KEY_HIDE_LIVES = "hide_lives";
    private static final String KEY_HIDE_PHOTOS = "hide_photos";
    private static final String KEY_REGION_SPOOF_ENABLED = "region_spoof_enabled";
    private static final String KEY_SELECTED_REGION = "selected_region";
    private static final String KEY_SYSTEM_COLORS = "system_colors";
    private static final String PREFS_NAME = "ttmod_settings";
    private static ModSettings instance;
    private static SharedPreferences prefs;
    private boolean hideAdsEnabled;
    private boolean hideLivesEnabled;
    private boolean hidePhotosEnabled;
    private boolean regionSpoofEnabled;
    private int selectedRegion;
    private boolean systemColorsEnabled;

    private ModSettings() {
        loadAll();
    }

    public static void init(Context context) {
        if (prefs == null) {
            prefs = context.getSharedPreferences(PREFS_NAME, 0);
        }
        if (instance == null) {
            instance = new ModSettings();
        }
    }

    public static ModSettings get() {
        return instance;
    }

    private void loadAll() {
        this.regionSpoofEnabled = prefs.getBoolean(KEY_REGION_SPOOF_ENABLED, true);
        this.selectedRegion = prefs.getInt(KEY_SELECTED_REGION, 0);
        this.hideLivesEnabled = prefs.getBoolean(KEY_HIDE_LIVES, false);
        this.hideAdsEnabled = prefs.getBoolean(KEY_HIDE_ADS, false);
        this.hidePhotosEnabled = prefs.getBoolean(KEY_HIDE_PHOTOS, false);
        this.systemColorsEnabled = prefs.getBoolean(KEY_SYSTEM_COLORS, false);
    }

    public boolean isRegionSpoofEnabled() {
        return this.regionSpoofEnabled;
    }

    public void setRegionSpoofEnabled(boolean enabled) {
        this.regionSpoofEnabled = enabled;
        prefs.edit().putBoolean(KEY_REGION_SPOOF_ENABLED, enabled).apply();
    }

    public int getSelectedRegion() {
        return this.selectedRegion;
    }

    public void setSelectedRegion(int regionIndex) {
        this.selectedRegion = regionIndex;
        prefs.edit().putInt(KEY_SELECTED_REGION, regionIndex).apply();
    }

    public RegionData.Region getCurrentRegion() {
        if (this.selectedRegion >= 0 && this.selectedRegion < RegionData.REGIONS.length) {
            return RegionData.REGIONS[this.selectedRegion];
        }
        return RegionData.REGIONS[0];
    }

    public boolean isHideLivesEnabled() {
        return this.hideLivesEnabled;
    }

    public void setHideLivesEnabled(boolean enabled) {
        this.hideLivesEnabled = enabled;
        prefs.edit().putBoolean(KEY_HIDE_LIVES, enabled).apply();
    }

    public boolean isHideAdsEnabled() {
        return this.hideAdsEnabled;
    }

    public void setHideAdsEnabled(boolean enabled) {
        this.hideAdsEnabled = enabled;
        prefs.edit().putBoolean(KEY_HIDE_ADS, enabled).apply();
    }

    public boolean isHidePhotosEnabled() {
        return this.hidePhotosEnabled;
    }

    public void setHidePhotosEnabled(boolean enabled) {
        this.hidePhotosEnabled = enabled;
        prefs.edit().putBoolean(KEY_HIDE_PHOTOS, enabled).apply();
    }

    public boolean isSystemColorsEnabled() {
        return this.systemColorsEnabled;
    }

    public void setSystemColorsEnabled(boolean enabled) {
        this.systemColorsEnabled = enabled;
        prefs.edit().putBoolean(KEY_SYSTEM_COLORS, enabled).apply();
    }
}
