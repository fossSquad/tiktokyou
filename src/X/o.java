package X;

import android.content.Context;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class o {
    public static final HashMap a = new HashMap();
    public static boolean b = false;
    public static final String[] c = {"X.0C36", "X.0C37", "X.0C38", "X.0C39", "X.0C3A", "X.0C3B", "X.0C3C", "X.0C3D", "X.0C3E", "X.0C3I", "X.0C3J", "X.0C3K"};
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
        map.put("background_play_enable", 1);
        map.put("fyp_auto_scroll", 1);
        map.put("ec_fyp_register_no_limit", Boolean.TRUE);
        map.put("ec_ug_native_prefetch_main_page_region", "region_cis");
        map.put("ec_live_check_region_when_provide_slot", bool);
    }

    public static void a() {
        if (!b) {
            b = true;
            try {
                Context contextB = q0.b();
                if (contextB != null) {
                    String string = contextB.getSharedPreferences("ttmod_remote_configs", 0).getString("config_overrides", "{}");
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
                                    ArrayList arrayList = q0.a;
                                }
                            }
                        }
                    }
                    a.size();
                    ArrayList arrayList2 = q0.a;
                }
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList3 = q0.a;
                e.printStackTrace();
            }
        }
        try {
            for (Map.Entry entry : d.entrySet()) {
                HashMap map = a;
                if (!map.containsKey(entry.getKey())) {
                    map.put((String) entry.getKey(), entry.getValue());
                    Objects.toString(entry.getValue());
                    ArrayList arrayList4 = q0.a;
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
            ArrayList arrayList5 = q0.a;
        }
        HashMap map2 = a;
        if (map2.isEmpty()) {
            ArrayList arrayList6 = q0.a;
            return;
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            Objects.toString(entry2.getValue());
            if (entry2.getValue() != null) {
                entry2.getValue().getClass();
            }
            ArrayList arrayList7 = q0.a;
        }
        for (String str2 : c) {
            try {
                Class<?> cls = Class.forName(str2);
                ArrayList arrayList8 = q0.a;
                for (Method method : cls.getDeclaredMethods()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    int i = 0;
                    while (true) {
                        if (i >= parameterTypes.length) {
                            i = -1;
                            break;
                        } else if (parameterTypes[i] == String.class) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i >= 0) {
                        XposedBridge.hookMethod(method, new n(i, method, str2.substring(str2.lastIndexOf(46) + 1)));
                    }
                }
                ArrayList arrayList9 = q0.a;
            } catch (ClassNotFoundException e3) {
                ArrayList arrayList10 = q0.a;
            } catch (Exception e4) {
                e4.getMessage();
                ArrayList arrayList11 = q0.a;
            }
        }
        a.size();
        ArrayList arrayList12 = q0.a;
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
