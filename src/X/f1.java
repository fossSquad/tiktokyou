package X;

import java.util.HashMap;
import java.util.Locale;

public final class f1 {
    public static f1 c;
    public final HashMap a;
    public final HashMap b;

    public f1() {
        HashMap map = new HashMap();
        this.a = map;
        HashMap map2 = new HashMap();
        this.b = map2;
        map.put("region_spoof", "Подмена региона");
        map.put("region_usa", "США");
        map.put("region_poland", "Польша");
        map.put("region_kazakhstan", "Казахстан");
        map.put("region_belarus", "Беларусь");
        map.put("region_egypt", "Египет");
        map.put("region_finland", "Финляндия");
        map.put("settings_title", "Настройки мода");
        map.put("section_region", "Регион");
        map.put("section_feed", "Лента рекомендаций и профили");
        map.put("section_other", "Другое");
        map.put("section_about", "О приложении");
        map.put("hide_lives", "Убрать трансляции");
        map.put("hide_ads", "Убрать рекламу");
        map.put("hide_photos", "Убрать фотографии");
        map.put("hide_stories", "Убрать истории");
        map.put("anti_burnout", "Антивыгорание");
        map.put("force_progress_bar", "Перемотка везде");
        map.put("mod_update", "Доступно обновление");
        map.put("mod_update_download", "Скачать");
        map.put("telegram_channel", "Telegram канал");
        map.put("mod_version", "Версия v1.3 (" + g1.b + ")");
        map.put("privacy_information", "Правовая информация");
        map.put("privacy_information_legal", "Используя приложение,\nвы принимаете все условия");
        map.put("section_colors", "Цвета");
        map.put("custom_colors", "Свои цвета");
        map.put("custom_colors_desc", "Акцентный цвет приложения будет изменен на выбранный");
        map.put("section_font", "Шрифт");
        map.put("font_default", "По умолчанию");
        map.put("font_system", "Системный");
        map.put("font_pick_file", "Свой");
        map.put("bulletin_title", "Почти готово");
        map.put("bulletin_subtitle", "Перезапустите для применения");
        map.put("bulletin_button", "Применить");
        map2.put("region_spoof", "Region spoofing");
        map2.put("region_usa", "USA");
        map2.put("region_poland", "Poland");
        map2.put("region_kazakhstan", "Kazakhstan");
        map2.put("region_belarus", "Belarus");
        map2.put("region_egypt", "Egypt");
        map2.put("region_finland", "Finland");
        map2.put("settings_title", "Mod Settings");
        map2.put("section_region", "Region");
        map2.put("section_feed", "Feed and profiles");
        map2.put("section_other", "Other");
        map2.put("section_about", "About");
        map2.put("hide_lives", "Hide livestreams");
        map2.put("hide_ads", "Hide ads");
        map2.put("hide_photos", "Hide photos");
        map2.put("hide_stories", "Hide stories");
        map2.put("anti_burnout", "Anti-burnout");
        map2.put("force_progress_bar", "Rewind everywhere");
        map2.put("mod_update", "Update available");
        map2.put("mod_update_download", "Download");
        map2.put("telegram_channel", "Telegram channel");
        map2.put("mod_version", "Version v1.3 (" + g1.b + ")");
        map2.put("privacy_information", "Privacy information");
        map2.put("privacy_information_legal", "By using the application,\nyou accept all terms and conditions");
        map2.put("section_colors", "Colors");
        map2.put("custom_colors", "Custom colors");
        map2.put("custom_colors_desc", "The app accent color will be changed to the selected one");
        map2.put("section_font", "Font");
        map2.put("font_default", "Default");
        map2.put("font_system", "System");
        map2.put("font_pick_file", "Custom");
        map2.put("bulletin_title", "Almost done");
        map2.put("bulletin_subtitle", "Restart to apply changes");
        map2.put("bulletin_button", "Apply");
    }

    public static f1 a() {
        f1 f1Var = c;
        if (f1Var == null && f1Var == null) {
            c = new f1();
        }
        return c;
    }

    public final String a(String str) {
        return (String) ("ru".equals(Locale.getDefault().getLanguage()) ? this.a : this.b).getOrDefault(str, str);
    }
}
