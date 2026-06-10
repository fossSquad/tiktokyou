package X;

import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class u2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        if (result instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) result;
            ConcurrentHashMap concurrentHashMap = v2.a;
            v2.a(jSONObject.names(), "AppLog.header.keys");
            v2.a("AppLog.header", jSONObject.toString());
            if (jSONObject.has("openudid")) {
                v2.a(jSONObject.opt("openudid"), "header.".concat("openudid"));
            }
            if (jSONObject.has("clientudid")) {
                v2.a(jSONObject.opt("clientudid"), "header.".concat("clientudid"));
            }
            if (jSONObject.has("cdid")) {
                v2.a(jSONObject.opt("cdid"), "header.".concat("cdid"));
            }
            if (jSONObject.has("google_aid")) {
                v2.a(jSONObject.opt("google_aid"), "header.".concat("google_aid"));
            }
            if (jSONObject.has("gaid_limited")) {
                v2.a(jSONObject.opt("gaid_limited"), "header.".concat("gaid_limited"));
            }
            if (jSONObject.has("sig_hash")) {
                v2.a(jSONObject.opt("sig_hash"), "header.".concat("sig_hash"));
            }
            if (jSONObject.has("apk_first_install_time")) {
                v2.a(jSONObject.opt("apk_first_install_time"), "header.".concat("apk_first_install_time"));
            }
            if (jSONObject.has("device_id")) {
                v2.a(jSONObject.opt("device_id"), "header.".concat("device_id"));
            }
            if (jSONObject.has("install_id")) {
                v2.a(jSONObject.opt("install_id"), "header.".concat("install_id"));
            }
            if (jSONObject.has("device_model")) {
                v2.a(jSONObject.opt("device_model"), "header.".concat("device_model"));
            }
            if (jSONObject.has("device_brand")) {
                v2.a(jSONObject.opt("device_brand"), "header.".concat("device_brand"));
            }
            if (jSONObject.has("device_manufacturer")) {
                v2.a(jSONObject.opt("device_manufacturer"), "header.".concat("device_manufacturer"));
            }
            if (jSONObject.has("os_version")) {
                v2.a(jSONObject.opt("os_version"), "header.".concat("os_version"));
            }
            if (jSONObject.has("os_api")) {
                v2.a(jSONObject.opt("os_api"), "header.".concat("os_api"));
            }
            if (jSONObject.has("rom")) {
                v2.a(jSONObject.opt("rom"), "header.".concat("rom"));
            }
            if (jSONObject.has("rom_version")) {
                v2.a(jSONObject.opt("rom_version"), "header.".concat("rom_version"));
            }
            if (jSONObject.has("release_build")) {
                v2.a(jSONObject.opt("release_build"), "header.".concat("release_build"));
            }
            if (jSONObject.has("git_hash")) {
                v2.a(jSONObject.opt("git_hash"), "header.".concat("git_hash"));
            }
            if (jSONObject.has("region")) {
                v2.a(jSONObject.opt("region"), "header.".concat("region"));
            }
            if (jSONObject.has("sys_region")) {
                v2.a(jSONObject.opt("sys_region"), "header.".concat("sys_region"));
            }
            if (jSONObject.has("sim_region")) {
                v2.a(jSONObject.opt("sim_region"), "header.".concat("sim_region"));
            }
            if (jSONObject.has("carrier_region")) {
                v2.a(jSONObject.opt("carrier_region"), "header.".concat("carrier_region"));
            }
            if (jSONObject.has("mcc_mnc")) {
                v2.a(jSONObject.opt("mcc_mnc"), "header.".concat("mcc_mnc"));
            }
            if (jSONObject.has("carrier")) {
                v2.a(jSONObject.opt("carrier"), "header.".concat("carrier"));
            }
            if (jSONObject.has("tz_name")) {
                v2.a(jSONObject.opt("tz_name"), "header.".concat("tz_name"));
            }
            if (jSONObject.has("tz_offset")) {
                v2.a(jSONObject.opt("tz_offset"), "header.".concat("tz_offset"));
            }
            if (jSONObject.has("timezone")) {
                v2.a(jSONObject.opt("timezone"), "header.".concat("timezone"));
            }
            if (jSONObject.has("timezone_name")) {
                v2.a(jSONObject.opt("timezone_name"), "header.".concat("timezone_name"));
            }
            if (jSONObject.has("timezone_offset")) {
                v2.a(jSONObject.opt("timezone_offset"), "header.".concat("timezone_offset"));
            }
        }
    }
}
