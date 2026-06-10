package X;

import android.content.Context;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class x1 {
    public static final HashMap a = new HashMap();
    public static boolean b = false;
    public static final String[] c = c7.a;
    public static final HashMap d;

    static {
        HashMap map = new HashMap();
        d = map;
        Boolean bool = Boolean.FALSE;
        map.put("enable_normal_splash_ad", bool);
        map.put("enable_normal_splash_ad_ab", bool);
        map.put("splash_ad_enable", bool);
        map.put("enable_live_splash", bool);
        map.put("aweme_splash_first_launch_enabled", bool);
        map.put("enable_splash_show_count_for_empty", bool);
        map.put("is_enable_splash_first_show_retrieval", bool);
        map.put("splash_show", bool);
        map.put("enable_splash_valid_time_check", bool);
        map.put("enable_feed_ad", bool);
        map.put("feed_ad_enable", bool);
        map.put("aweme_ad_enable", bool);
        map.put("enable_aweme_ad", bool);
        map.put("enable_video_ad", bool);
        map.put("enable_post_roll_ad", bool);
        map.put("enable_mid_roll_ad", bool);
        map.put("enable_pre_roll_ad", bool);
        map.put("enable_ad_banner", bool);
        map.put("ad_banner_enable", bool);
        map.put("enable_in_feed_ad", bool);
        map.put("enable_ecommerce_card", bool);
        map.put("enable_commerce_anchor", bool);
        map.put("enable_shopping_anchor", bool);
        map.put("enable_product_anchor", bool);
        map.put("enable_live_commerce", bool);
        map.put("commerce_enable", bool);
        map.put("background_play_enable", 1);
        map.put("fyp_auto_scroll", 1);
        Boolean bool2 = Boolean.TRUE;
        map.put("ec_fyp_register_no_limit", bool2);
        map.put("ec_live_check_region_when_provide_slot", bool);
        map.put("dm_customize_message_bubble", 1);
        map.put("add_comments_to_favorites", 3);
        map.put("audio_comment_publish", 1);
        map.put("comment_sort_opt_style", 1);
        map.put("auchor_with_new_sort", 1);
        map.put("tux_profile_icon_update", 1);
        map.put("enable_inbox_activity_classification", 0);
        map.put("inbox_request_filter_icon_exp", 0);
        map.put("inbox_filter_unread_count_opt", 0);
        map.put("inbox_bb_archive_enable", 1);
        map.put("inbox_bb_archive_rollback", 1);
        map.put("creator_inbox_follower_activity_merge", 1);
        map.put("new_bottom_tab_icon2", 2);
        map.put("long_press_profile_aweme_gesture_exp", 3);
        map.put("photo_comment_new_anim", 1);
        map.put("tux_dialog_style_upgrade", 1);
        map.put("comment_hate_opt", 1);
        map.put("tt_comment_hate_animation_opt", 2);
        map.put("enable_favorite_long_click", 2);
        map.put("creator_inbox_dm_tab", 1);
        map.put("creator_inbox_dm_tab_name", 1);
        map.put("creator_inbox_experiment", 1);
        map.put("professional_creator_inbox", 1);
        map.put("long_press_speed_up_lock", 120);
        map.put("long_press_speed_up_enable", bool2);
        map.put("small_tablet_landscape_support", 1);
        map.put("tablets_tux_sheet_modal_style", bool2);
        map.put("tablets_bottom_nav_icons_v2", 2);
        map.put("tablet_fyp_auto_scroll", 0);
        map.put("tablet_enable_landscape_profile", bool2);
        map.put("repost_text_max_length", 99999);
        map.put("long_press_quick_comment", 1);
        map.put("feed_right_use_large_icon_exp", 2);
        map.put("pugc_template_create_options", 1);
        map.put("my_music_ui_style_version", 1);
        map.put("repost_guide_button_opt_group", 1);
        map.put("tt_repost_element_bg_opt", 2);
    }

    public static void a() {
        if (!b) {
            b = true;
            try {
                Context contextC = p4.c();
                if (contextC != null) {
                    String string = contextC.getSharedPreferences("ttmod_remote_configs", 0).getString("config_overrides", "{}");
                    a.clear();
                    if (string.length() > 2) {
                        for (String str : string.substring(1, string.length() - 1).split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")) {
                            int iIndexOf = str.indexOf(58);
                            if (iIndexOf > 0) {
                                String strTrim = str.substring(0, iIndexOf).trim();
                                String strTrim2 = str.substring(iIndexOf + 1).trim();
                                if (strTrim.startsWith("\"") && strTrim.endsWith("\"")) {
                                    strTrim = strTrim.substring(1, strTrim.length() - 1);
                                }
                                Object objA = a(strTrim2);
                                if (objA != null) {
                                    a.put(strTrim, objA);
                                    objA.toString();
                                    int i = p4.a;
                                }
                            }
                        }
                    }
                    a.size();
                    int i2 = p4.a;
                }
            } catch (Exception e) {
                e.getMessage();
                int i3 = p4.a;
                e.printStackTrace();
            }
        }
        try {
            for (Map.Entry entry : d.entrySet()) {
                HashMap map = a;
                if (!map.containsKey(entry.getKey())) {
                    map.put((String) entry.getKey(), entry.getValue());
                    Objects.toString(entry.getValue());
                    int i4 = p4.a;
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
            int i5 = p4.a;
        }
        HashMap map2 = a;
        if (map2.isEmpty()) {
            int i6 = p4.a;
            return;
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            Objects.toString(entry2.getValue());
            if (entry2.getValue() != null) {
                entry2.getValue().getClass();
            }
            int i7 = p4.a;
        }
        for (String str2 : c) {
            try {
                Class<?> cls = Class.forName(str2);
                int i8 = p4.a;
                for (Method method : cls.getDeclaredMethods()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= parameterTypes.length) {
                            i9 = -1;
                            break;
                        } else if (parameterTypes[i9] == String.class) {
                            break;
                        } else {
                            i9++;
                        }
                    }
                    if (i9 >= 0) {
                        HookBridge.hookMethod(method, new w1(i9, method, str2.substring(str2.lastIndexOf(46) + 1)));
                    }
                }
                int i10 = p4.a;
            } catch (ClassNotFoundException e3) {
                int i11 = p4.a;
            } catch (Exception e4) {
                e4.getMessage();
                int i12 = p4.a;
            }
        }
        a.size();
        int i13 = p4.a;
    }

    public static Object a(String str) {
        String strTrim = str.trim();
        if (strTrim.equals("true")) {
            return Boolean.TRUE;
        }
        if (strTrim.equals("false")) {
            return Boolean.FALSE;
        }
        if (strTrim.equals("null")) {
            return null;
        }
        if (strTrim.startsWith("\"") && strTrim.endsWith("\"")) {
            return strTrim.substring(1, strTrim.length() - 1);
        }
        try {
            if (strTrim.contains(".")) {
                return Double.valueOf(Double.parseDouble(strTrim));
            }
            long j = Long.parseLong(strTrim);
            if (j >= -2147483648L && j <= 2147483647L) {
                return Integer.valueOf((int) j);
            }
            return Long.valueOf(j);
        } catch (NumberFormatException e) {
            return strTrim;
        }
    }
}
