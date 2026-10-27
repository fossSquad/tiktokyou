package Z;

import com.ss.android.ugc.gamora.recorder.frontflash.config.StudioSelfieFillLightConfig;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b3 {
    public static final HashMap a;
    public static final ConcurrentHashMap b;
    public static final String[] c;
    public static final ConcurrentHashMap d;
    public static final ConcurrentHashMap e;
    public static final ConcurrentHashMap f;
    public static final ConcurrentHashMap g;
    public static final HashMap h;

    static {
        a = new HashMap();
        b = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new ConcurrentHashMap();
        c = wb.a;
        HashMap map = new HashMap();
        h = map;
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
        map.put("comment_sort_opt_style", 2);
        map.put("anchor_with_new_sort", 1);
        map.put("tux_profile_icon_update", 1);
        map.put("enable_inbox_activity_classification", 0);
        map.put("inbox_request_filter_icon_exp", 0);
        map.put("inbox_filter_unread_count_opt", 0);
        map.put("inbox_bb_archive_enable", 1);
        map.put("inbox_bb_archive_rollback", 1);
        map.put("creator_inbox_follower_activity_merge", 0);
        map.put("inbox_follower_activity_merge_version", 0);
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
        map.put("feed_right_use_large_icon_exp", 0);
        map.put("feed_title_timestamp_trial", "v3");
        map.put("pugc_template_create_options", 1);
        map.put("my_music_ui_style_version", 1);
        map.put("repost_guide_button_opt_group", 1);
        map.put("tt_repost_element_bg_opt", 2);
        map.put("repost_support_reply", 1);
        map.put("repost_support_digg", 1);
        map.put("tt_comment_repost_interaction", 1);
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
        map.put("profile_bg_in_allow_list", 1);
        map.put("profile_left_align", 1);
        map.put("profile_left_align_ab_group", 11);
        map.put("profile_left_align_avatar_opt", bool2);
        map.put("profile_left_align_avatar_at_right_opt", bool2);
        map.put("profile_left_align_avatar_and_info_merge", 1);
        map.put("profile_left_align_right_avatar_nickname_opt_v2", bool2);
        map.put("enable_profile_left_align_second_line_two_lines_show", bool2);
        map.put("profile_left_align_relation_info_font_size_opt", bool2);
        map.put("profile_left_align_right_avatar_large_font_opt", bool2);
        map.put("profile_left_align_small_avatar", 0);
        map.put("profile_left_align_bio_style_opt", bool2);
        map.put("profile_left_align_cta_style_opt", bool2);
        map.put("profile_left_align_advance_feature_style_opt", bool2);
        map.put("profile_left_align_right_avatar_nickname_wordbreak_opt", bool2);
        map.put("profile_left_align_pronouns", 1);
        map.put("profile_left_align_recommend_card", 1);
        map.put("profile_left_align_show_avatar_frame_opt", bool2);
        map.put("profile_bg_enable_consumption_group", 3);
        map.put("studio_selfie_fill_light_config", new StudioSelfieFillLightConfig(true, true, true, true, false, false));
        map.put("feed_support_3x_speed", bool2);
        map.put("enable_self_repost", 1);
        map.put("switch_account_gesture", 1);
        map.put("enable_pip_feed", 1);
        map.put("profile_bind_lemon8_exp", 1);
        map.put("offline_mode_enable", 1);
        map.put("pro_inbox_enable_read_all_in_multiselect_mode", 1);
        map.put("feed_alpha_overlapping_rendering_opt", 0);
        map.put("tt_im_new_emoji", 2);
        map.put("tt_cmt_new_emoji", 2);
        map.put("tt_repost_new_emoji", 3);
        map.put("studio_publish_limit_hashtag_switch", bool);
        map.put("studio_publish_hashtag_max_limit", 999);
        map.put("camera_teleprompter_mode", 1);
        map.put("comment_multi_photo_group", 2);
        map.put("tt_repost_comment_tag_opt", bool2);
        map.put("enable_non_personalized_search", 1);
        map.put("feed_component_corner_radius_style", 1);
        map.put("search_card_add_time_to_cover", 1);
        map.put("show_suggest_search_words", 1);
        map.put("search_middle_page_font_style", 1);
        map.put("studio_album_navigation_button_style", 3);
        map.put("studio_ai_alive_shoot_entrance", bool2);
        map.put("studio_main_camera_ai_alive", 1);
        map.put("studio_location_text_change", bool2);
        map.put("studio_change_shoot_btn_icon", bool2);
        map.put("studio_editor_pro_add_anim_sub_menu_in_effect", bool2);
        map.put("nearby_tab_rename_enable", bool2);
        map.put("video_capture_green_screen_standalone", bool);
        map.put("ct_ai_caption", 1);
        map.put("show_filter_anchor", 1);
        map.put("tiktok_live_inbox_2_following_guide_type", 1);
        map.put("favorite_new_feature_reverse_202606", bool2);
        map.put("danmaku_exp", 1);
        map.put("comment_close_button_new_style", 1);
        map.put("comment_close_button_move_up", 1);
        map.put("comment_cell_spacing_align", 1);
        map.put("multi_tab_comment_title_resize", 1);
        map.put("feed_component_layout_optimize_desc_font", bool2);
        map.put("feed_component_layout_optimize_component_font", bool2);
    }

    public static void a() {
        int i;
        char c2;
        try {
            for (Map.Entry entry : ((Map<?, ?>) h).entrySet()) {
                HashMap map = a;
                if (!map.containsKey(entry.getKey())) {
                    map.put((String) entry.getKey(), entry.getValue());
                    Objects.toString(entry.getValue());
                }
            }
        } catch (Exception e2) {
            String str = "Failed to add auto overrides: " + e2;
            Object obj = g7.a;
            g7.a(6, String.valueOf(str), (Throwable) null);
        }
        HashMap map2 = a;
        if (map2.isEmpty() && b.isEmpty()) {
            return;
        }
        for (Map.Entry entry2 : ((Map<?, ?>) map2).entrySet()) {
            Objects.toString(entry2.getValue());
            if (entry2.getValue() != null) {
                entry2.getValue().getClass();
            } else {
            }
        }
        int i2 = 0;
        for (String str2 : c) {
            try {
                Class<?> cls = Class.forName(str2);
                i = 0;
                for (Method method : cls.getDeclaredMethods()) {
                    try {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= parameterTypes.length) {
                                i3 = -1;
                                break;
                            } else if (parameterTypes[i3] == String.class) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (i3 >= 0) {
                            HookBridge.hookMethod(method, new a3(i3, method, str2.substring(str2.lastIndexOf(46) + 1)));
                            i++;
                        }
                    } catch (Exception e4) {
                        String strA2 = "Failed to hook " + str2;
                        Object obj3 = g7.a;
                        c2 = 6;
                        g7.a(6, String.valueOf(strA2), e4);
                        i2 += i;
                    }
                }
                String str3 = "Hooked " + i + " methods in " + str2;
                Object obj4 = g7.a;
                g7.a(4, String.valueOf(str3), (Throwable) null);
                c2 = 6;
            } catch (ClassNotFoundException e5) {
                i = 0;
            } catch (Exception e6) {
                i = 0;
            }
            i2 += i;
        }
        String strA3 = "Initialized: " + i2 + " methods hooked, " + a.size() + " overrides";
        Object obj5 = g7.a;
        g7.a(4, String.valueOf(strA3), (Throwable) null);
    }

    public static Class a(String str, Object[] objArr, Object obj, Class cls) {
        if (objArr != null) {
            for (Object obj2 : objArr) {
                if (obj2 instanceof Class) {
                    return (Class) obj2;
                }
            }
        }
        if (obj != null) {
            return obj.getClass();
        }
        Object objA = a(objArr, cls);
        if (objA != null) {
            return objA.getClass();
        }
        return (cls == null || cls == Object.class) ? (Class) e.get(str) : cls;
    }

    public static Object a(Object[] objArr, Class cls) {
        Class<?> cls2;
        if (objArr != null && cls != null) {
            for (int length = objArr.length - 1; length >= 0; length--) {
                Object obj = objArr[length];
                if (obj != null && (cls2 = obj.getClass()) != String.class && cls2 != Class.class && cls2 != Boolean.class && !Number.class.isAssignableFrom(cls2) && (cls == Object.class || cls.isInstance(obj))) {
                    return obj;
                }
            }
        }
        return null;
    }
}
