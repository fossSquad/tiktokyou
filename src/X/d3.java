package X;

import android.content.SharedPreferences;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public abstract class d3 {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;

    static {
        SharedPreferences sharedPreferences = l8.B;
        String string = sharedPreferences.getString("adevid_saved", null);
        if (string == null) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            while (sb.length() < 16) {
                sb.append(Integer.toHexString(random.nextInt()));
            }
            String strSubstring = sb.toString().substring(0, 16);
            b = strSubstring;
            sharedPreferences.edit().putString("adevid_saved", strSubstring).apply();
        } else {
            b = string;
        }
        String string2 = sharedPreferences.getString("googleaid_saved", null);
        if (string2 == null) {
            String string3 = UUID.randomUUID().toString();
            c = string3;
            sharedPreferences.edit().putString("googleaid_saved", string3).apply();
        } else {
            c = string2;
        }
        String string4 = sharedPreferences.getString("clientudid_preferenced", null);
        if (string4 == null) {
            String string5 = UUID.randomUUID().toString();
            d = string5;
            sharedPreferences.edit().putString("clientudid_preferenced", string5).apply();
        } else {
            d = string4;
        }
        String string6 = sharedPreferences.getString("cdid_preferenced", null);
        if (string6 != null) {
            e = string6;
            return;
        }
        String string7 = UUID.randomUUID().toString();
        e = string7;
        sharedPreferences.edit().putString("cdid_preferenced", string7).apply();
    }

    public static String a(l8 l8Var, String str) {
        String str2;
        String string = l8Var.v;
        if (string == null) {
            string = l8.B.getString("random_android_id", null);
        }
        if (d(string)) {
            return string.toLowerCase(Locale.US);
        }
        String lowerCase = d(str) ? str.toLowerCase(Locale.US) : null;
        for (int i = 0; i < 8; i++) {
            str2 = String.format(Locale.US, "%016x", Long.valueOf(ThreadLocalRandom.current().nextLong()));
            if (!str2.equals(lowerCase)) {
                l8Var.v = str2;
                l8.B.edit().putString("random_android_id", str2).apply();
                return str2;
            }
        }
        if (lowerCase == null) {
            str2 = "0000000000000001";
        } else {
            char[] charArray = lowerCase.toCharArray();
            charArray[charArray.length - 1] = charArray[charArray.length + (-1)] == 'f' ? '0' : 'f';
            str2 = new String(charArray);
        }
        l8Var.v = str2;
        l8.B.edit().putString("random_android_id", str2).apply();
        return str2;
    }

    public static java.lang.String b(X.l8 r8, java.lang.String r9) {
        /*
            java.lang.String r0 = r8.u
            java.lang.String r1 = "spoofed_device_id"
            if (r0 == 0) goto L7
            goto Le
        L7:
            android.content.SharedPreferences r0 = X.l8.B
            r2 = 0
            java.lang.String r0 = r0.getString(r1, r2)
        Le:
            boolean r2 = b(r0)
            r3 = 0
            if (r2 == 0) goto L39
            boolean r2 = r0.equals(r9)
            if (r2 != 0) goto L38
            boolean r2 = b(r0)
            if (r2 == 0) goto L39
            boolean r2 = b(r9)
            if (r2 != 0) goto L28
            goto L39
        L28:
            r2 = 13
            boolean r2 = r0.regionMatches(r3, r9, r3, r2)
            r4 = 12
            boolean r4 = r0.regionMatches(r3, r9, r3, r4)
            if (r2 != 0) goto L38
            if (r4 == 0) goto L39
        L38:
            return r0
        L39:
            boolean r2 = b(r9)
            if (r2 != 0) goto L40
            return r0
        L40:
            boolean r0 = b(r9)
            if (r0 != 0) goto L49
            java.lang.String r9 = "0000000000000000001"
            goto L9f
        L49:
            r0 = r3
        L4a:
            r2 = 8
            if (r0 >= r2) goto L85
            java.util.concurrent.ThreadLocalRandom r4 = java.util.concurrent.ThreadLocalRandom.current()
            r5 = 6
            int r2 = r4.nextInt(r5, r2)
            int r4 = 19 - r2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r6 = 19
            r5.<init>(r6)
            r5.append(r9, r3, r4)
            r4 = r3
        L64:
            if (r4 >= r2) goto L76
            java.util.concurrent.ThreadLocalRandom r6 = java.util.concurrent.ThreadLocalRandom.current()
            r7 = 10
            int r6 = r6.nextInt(r7)
            r5.append(r6)
            int r4 = r4 + 1
            goto L64
        L76:
            java.lang.String r2 = r5.toString()
            boolean r4 = r2.equals(r9)
            if (r4 != 0) goto L82
            r9 = r2
            goto L9f
        L82:
            int r0 = r0 + 1
            goto L4a
        L85:
            char[] r9 = r9.toCharArray()
            int r0 = r9.length
            int r0 = r0 + (-1)
            int r2 = r9.length
            int r2 = r2 + (-1)
            char r2 = r9[r2]
            r3 = 57
            if (r2 != r3) goto L97
            r3 = 48
        L97:
            r9[r0] = r3
            java.lang.String r0 = new java.lang.String
            r0.<init>(r9)
            r9 = r0
        L9f:
            r8.u = r9
            android.content.SharedPreferences r8 = X.l8.B
            android.content.SharedPreferences$Editor r8 = r8.edit()
            android.content.SharedPreferences$Editor r8 = r8.putString(r1, r9)
            r8.apply()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: X.d3.b(X.l8, java.lang.String):java.lang.String");
    }

    public static boolean c(String str) {
        return a(str) || "did".equals(str) || "iid".equals(str) || "device_id_str".equals(str) || "install_id_str".equals(str) || "device_id".equals(str) || "install_id".equals(str) || "header".equals(str) || "magic_tag".equals(str) || "_gen_time".equals(str) || "req_id".equals(str) || "clientudid".equals(str) || "openudid".equals(str) || "cdid".equals(str) || "google_aid".equals(str) || "gaid_limited".equals(str) || "sig_hash".equals(str) || "apk_first_install_time".equals(str) || "package".equals(str) || "app_version".equals(str) || "app_version_minor".equals(str) || "version_code".equals(str) || "update_version_code".equals(str) || "manifest_version_code".equals(str) || "app_name".equals(str) || "channel".equals(str) || "tweaked_channel".equals(str) || "display_name".equals(str) || "aid".equals(str) || "release_build".equals(str) || "git_hash".equals(str) || "sdk_version".equals(str) || "sdk_version_code".equals(str) || "sdk_target_version".equals(str) || "sdk_flavor".equals(str) || "device_platform".equals(str) || "device_model".equals(str) || "device_type".equals(str) || "device_brand".equals(str) || "device_manufacturer".equals(str) || "cpu_abi".equals(str) || "os".equals(str) || "os_version".equals(str) || "os_api".equals(str) || "rom".equals(str) || "rom_version".equals(str) || "density_dpi".equals(str) || "display_density".equals(str) || "display_density_v2".equals(str) || "resolution".equals(str) || "resolution_v2".equals(str) || "access".equals(str) || "ac".equals(str) || "ac2".equals(str) || "language".equals(str) || "locale".equals(str) || "region".equals(str) || "sys_region".equals(str) || "sim_region".equals(str) || "carrier_region".equals(str) || "carrier_region_v2".equals(str) || "mcc_mnc".equals(str) || "carrier".equals(str) || "tz_name".equals(str) || "tz_offset".equals(str) || "timezone".equals(str) || "timezone_name".equals(str) || "timezone_offset".equals(str) || "is_system_app".equals(str) || "guest_mode".equals(str) || "not_request_sender".equals(str) || "custom".equals(str) || "ram_size".equals(str) || "dark_mode_setting_value".equals(str) || "is_flip".equals(str) || "is_foldable".equals(str) || "screen_height_dp".equals(str) || "screen_width_dp".equals(str) || "filter_warn".equals(str) || "priority_region".equals(str) || "user_period".equals(str) || "is_kids_mode".equals(str) || "web_ua".equals(str) || "user_mode".equals(str);
    }

    public static boolean d(String str) {
        if (str == null || str.length() != 16) {
            return false;
        }
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= str.length()) {
                return true;
            }
            char cCharAt = str.charAt(i);
            boolean z2 = cCharAt >= '0' && cCharAt <= '9';
            if ((cCharAt < 'a' || cCharAt > 'f') && (cCharAt < 'A' || cCharAt > 'F')) {
                z = false;
            }
            if (!z2 && !z) {
                return false;
            }
            i++;
        }
    }

    public static boolean a(String str) {
        return "device_id".equals(str) || "install_id".equals(str) || "bd_did".equals(str) || "device_token".equals(str) || "install_info".equals(str) || "openudid".equals(str) || "clientudid".equals(str) || "cliend_udid".equals(str) || "cdid".equals(str) || "google_aid".equals(str) || "gaid_limited".equals(str) || "ssid".equals(str);
    }

    public static void a(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        if (str2.length() <= 1800) {
            a((Object) str2, str);
            return;
        }
        int length = (str2.length() + 1799) / 1800;
        int i = 0;
        while (i < length) {
            int i2 = i * 1800;
            i++;
            a((Object) str2.substring(i2, Math.min(str2.length(), i2 + 1800)), str + "[" + i + "/" + length + "]");
        }
    }

    public static boolean b(String str) {
        if (str == null || str.length() != 19) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (strValueOf.isEmpty() || strValueOf.equals((String) a.put(str, strValueOf))) {
            return;
        }
        int i = g5.a;
    }
}
