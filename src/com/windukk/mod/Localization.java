package com.windukk.mod;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Localization {
    private static Localization instance;
    private final Map<String, String> stringsRu = new HashMap();
    private final Map<String, String> stringsEn = new HashMap();

    private Localization() {
        this.stringsRu.put("region_usa", "США");
        this.stringsRu.put("region_poland", "Польша");
        this.stringsRu.put("region_kazakhstan", "Казахстан");
        this.stringsRu.put("region_belarus", "Беларусь");
        this.stringsRu.put("region_egypt", "Египет");
        this.stringsRu.put("region_finland", "Финляндия");
        this.stringsRu.put("settings_title", "Настройки мода");
        this.stringsRu.put("section_region", "Регион");
        this.stringsRu.put("section_feed", "Лента рекомендаций");
        this.stringsRu.put("section_other", "Другое");
        this.stringsRu.put("section_about", "О приложении");
        this.stringsRu.put("hide_lives", "Убрать трансляции");
        this.stringsRu.put("hide_ads", "Убрать рекламу");
        this.stringsRu.put("hide_photos", "Убрать фотографии");
        this.stringsRu.put("telegram_channel", "Telegram канал");
        this.stringsRu.put("mod_version", String.format("Версия 1.0.1 (%s)", Integer.valueOf(Main.versionCode)));
        this.stringsRu.put("privacy_information", "Правовая информация");
        this.stringsRu.put("privacy_information_legal", "Используя приложение,\nвы принимаете все условия");
        this.stringsRu.put("system_colors", "Системные цвета");
        this.stringsRu.put("bulletin_title", "Почти готово");
        this.stringsRu.put("bulletin_subtitle", "Перезапустите для применения");
        this.stringsRu.put("bulletin_button", "Применить");
        this.stringsEn.put("region_usa", "USA");
        this.stringsEn.put("region_poland", "Poland");
        this.stringsEn.put("region_kazakhstan", "Kazakhstan");
        this.stringsEn.put("region_belarus", "Belarus");
        this.stringsEn.put("region_egypt", "Egypt");
        this.stringsEn.put("region_finland", "Finland");
        this.stringsEn.put("settings_title", "Mod Settings");
        this.stringsEn.put("section_region", "Region");
        this.stringsEn.put("section_feed", "Feed");
        this.stringsEn.put("section_other", "Other");
        this.stringsEn.put("section_about", "About");
        this.stringsEn.put("hide_lives", "Hide livestreams");
        this.stringsEn.put("hide_ads", "Hide ads");
        this.stringsEn.put("hide_photos", "Hide photos");
        this.stringsEn.put("telegram_channel", "Telegram channel");
        this.stringsEn.put("mod_version", String.format("Version 1.0.1 (%s)", Integer.valueOf(Main.versionCode)));
        this.stringsEn.put("privacy_information", "Privacy information");
        this.stringsEn.put("privacy_information_legal", "By using the application,\nyou accept all terms and conditions");
        this.stringsEn.put("system_colors", "System colors");
        this.stringsEn.put("bulletin_title", "Almost done");
        this.stringsEn.put("bulletin_subtitle", "Restart to apply changes");
        this.stringsEn.put("bulletin_button", "Apply");
    }

    public static void init() {
        if (instance == null) {
            instance = new Localization();
        }
    }

    public static Localization get() {
        if (instance == null) {
            init();
        }
        return instance;
    }

    private boolean isRussian() {
        String language = Locale.getDefault().getLanguage();
        return "ru".equals(language);
    }

    public String getString(String key) {
        Map<String, String> strings = isRussian() ? this.stringsRu : this.stringsEn;
        return strings.getOrDefault(key, key);
    }

    public String getRegionName(String regionId) {
        return getString(regionId);
    }
}
