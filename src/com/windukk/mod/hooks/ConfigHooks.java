package com.windukk.mod.hooks;

import android.content.Context;
import com.windukk.hook.HookBridge;
import com.windukk.mod.Main;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class ConfigHooks {
    public static final HashMap a;
    public static boolean b;
    public static final String[] c;
    public static final HashMap d;

    static {
        a = new HashMap();
        b = false;
        c = oa.a;
        HashMap map = new HashMap();
        d = map;
        String strDecrypt = "enable_normal_splash_ad";
        Boolean bool = Boolean.FALSE;
        map.put(strDecrypt, bool);
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
        String strDecrypt2 = "ec_fyp_register_no_limit";
        Boolean bool2 = Boolean.TRUE;
        map.put(strDecrypt2, bool2);
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
        map.put("feed_title_timestamp_trial", "v3");
        map.put("pugc_template_create_options", 1);
        map.put("my_music_ui_style_version", 1);
        map.put("repost_guide_button_opt_group", 1);
        map.put("tt_repost_element_bg_opt", 2);
        map.put("photo_comment_new_anim", 0);
        map.put("comment_enable_live_photo", 1);
        map.put("comment_by_shooting", 1);
        map.put("long_comment_show_all_enable", bool);
        map.put("im_contacts_multi_select_limit", 999);
        map.put("feed_long_press_panel_support_all_type", bool2);
        map.put("long_press_panel_config", bool);
        map.put("share_panel_config", bool);
        map.put("comment_new_long_press_panel", 1);
        map.put("comment_sticker_consumption_spec", 1);
        map.put("feed_progress_extend_ohr_exp", 0);
        map.put("feed_right_area_extend_ohr_exp", 0);
        map.put("feed_right_area_extend_ohr_small_screen_exp", 0);
        map.put("feed_right_area_extend_long_hand_exp", bool);
    }

    public static void a() {
        boolean z;
        int i;
        int i2 = 0;
        boolean z2 = true;
        if (!b) {
            b = true;
            try {
                Context contextA = Main.a();
                if (contextA == null) {
                    String strDecrypt = "Context is null!";
                    Object obj = h6.a;
                    h6.a(4, String.valueOf(strDecrypt), (Throwable) null);
                } else {
                    String string = contextA.getSharedPreferences("ttmod_remote_configs", 0).getString("config_overrides", "{}");
                    HashMap map = a;
                    map.clear();
                    map.putAll(f6.a(string));
                    String str = "Loaded " + map.size() + " config overrides";
                    Object obj2 = h6.a;
                    h6.a(4, String.valueOf(str), (Throwable) null);
                }
            } catch (Exception e) {
                String str2 = "Failed to load overrides: " + e;
                Object obj3 = h6.a;
                h6.a(6, String.valueOf(str2), (Throwable) null);
            }
        }
        try {
            for (Map.Entry entry : d.entrySet()) {
                HashMap map2 = a;
                if (!map2.containsKey(entry.getKey())) {
                    map2.put((String) entry.getKey(), entry.getValue());
                    Objects.toString(entry.getValue());
                }
            }
        } catch (Exception e2) {
            String str3 = "Failed to add auto overrides: " + e2;
            Object obj4 = h6.a;
            h6.a(6, String.valueOf(str3), (Throwable) null);
        }
        HashMap map3 = a;
        if (map3.isEmpty()) {
            return;
        }
        for (Map.Entry entry2 : map3.entrySet()) {
            Objects.toString(entry2.getValue());
            if (entry2.getValue() != null) {
                entry2.getValue().getClass();
            } else {
            }
        }
        String[] strArr = c;
        int length = strArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            String str4 = strArr[i3];
            try {
                Class<?> cls = Class.forName(str4);
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length2 = declaredMethods.length;
                int i5 = i2;
                i = i5;
                while (i5 < length2) {
                    try {
                        Method method = declaredMethods[i5];
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        z = z2;
                        int i6 = 0;
                        while (true) {
                            try {
                                if (i6 >= parameterTypes.length) {
                                    i6 = -1;
                                    break;
                                } else if (parameterTypes[i6] == String.class) {
                                    break;
                                } else {
                                    i6++;
                                }
                            } catch (ClassNotFoundException e3) {
                                String strA = new StringBuilder().append("Class not found: ").append(str4).append(" (skipping)").toString();
                                Object obj5 = h6.a;
                                h6.a(6, String.valueOf(strA), (Throwable) null);
                                i4 += i;
                                i3++;
                                z2 = z;
                                i2 = 0;
                            } catch (Exception e4) {
                                e = e4;
                                String strA2 = new StringBuilder().append("Failed to hook ").append(str4).toString();
                                Object obj6 = h6.a;
                                h6.a(6, String.valueOf(strA2), e);
                                i4 += i;
                                i3++;
                                z2 = z;
                                i2 = 0;
                            }
                        }
                        if (i6 >= 0) {
                            HookBridge.hookMethod(method, new p2(i6, method, str4.substring(str4.lastIndexOf(46) + 1)));
                            i++;
                        }
                        i5++;
                        z2 = z;
                    } catch (ClassNotFoundException e5) {
                        z = z2;
                    } catch (Exception e6) {
                        e = e6;
                        z = z2;
                    }
                }
                z = z2;
                String str5 = "Hooked " + i + " methods in " + str4;
                Object obj7 = h6.a;
                h6.a(4, String.valueOf(str5), (Throwable) null);
            } catch (ClassNotFoundException e7) {
                z = z2;
                i = 0;
            } catch (Exception e8) {
                e = e8;
                z = z2;
                i = 0;
            }
            i4 += i;
            i3++;
            z2 = z;
            i2 = 0;
        }
        String strA3 = new StringBuilder().append("Initialized: ").append(i4).append(" methods hooked, ").append(a.size()).append(" overrides").toString();
        Object obj8 = h6.a;
        h6.a(4, String.valueOf(strA3), (Throwable) null);
    }
}
