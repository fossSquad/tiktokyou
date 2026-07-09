package X;

import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class c3 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        if (result instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) result;
            ConcurrentHashMap concurrentHashMap = d3.a;
            d3.a(jSONObject.names(), "AppLog.header.keys");
            d3.a("AppLog.header", jSONObject.toString());
            if (jSONObject.has("openudid")) {
                d3.a(jSONObject.opt("openudid"), "header.".concat("openudid"));
            }
            if (jSONObject.has("clientudid")) {
                d3.a(jSONObject.opt("clientudid"), "header.".concat("clientudid"));
            }
            if (jSONObject.has("cdid")) {
                d3.a(jSONObject.opt("cdid"), "header.".concat("cdid"));
            }
            if (jSONObject.has("google_aid")) {
                d3.a(jSONObject.opt("google_aid"), "header.".concat("google_aid"));
            }
            if (jSONObject.has("gaid_limited")) {
                d3.a(jSONObject.opt("gaid_limited"), "header.".concat("gaid_limited"));
            }
            if (jSONObject.has("sig_hash")) {
                d3.a(jSONObject.opt("sig_hash"), "header.".concat("sig_hash"));
            }
            if (jSONObject.has("apk_first_install_time")) {
                d3.a(jSONObject.opt("apk_first_install_time"), "header.".concat("apk_first_install_time"));
            }
            if (jSONObject.has("device_id")) {
                d3.a(jSONObject.opt("device_id"), "header.".concat("device_id"));
            }
            if (jSONObject.has("install_id")) {
                d3.a(jSONObject.opt("install_id"), "header.".concat("install_id"));
            }
            if (jSONObject.has("device_model")) {
                d3.a(jSONObject.opt("device_model"), "header.".concat("device_model"));
            }
            if (jSONObject.has("device_brand")) {
                d3.a(jSONObject.opt("device_brand"), "header.".concat("device_brand"));
            }
            if (jSONObject.has("device_manufacturer")) {
                d3.a(jSONObject.opt("device_manufacturer"), "header.".concat("device_manufacturer"));
            }
            if (jSONObject.has("os_version")) {
                d3.a(jSONObject.opt("os_version"), "header.".concat("os_version"));
            }
            if (jSONObject.has("os_api")) {
                d3.a(jSONObject.opt("os_api"), "header.".concat("os_api"));
            }
            if (jSONObject.has("rom")) {
                d3.a(jSONObject.opt("rom"), "header.".concat("rom"));
            }
            if (jSONObject.has("rom_version")) {
                d3.a(jSONObject.opt("rom_version"), "header.".concat("rom_version"));
            }
            if (jSONObject.has("release_build")) {
                d3.a(jSONObject.opt("release_build"), "header.".concat("release_build"));
            }
            if (jSONObject.has("git_hash")) {
                d3.a(jSONObject.opt("git_hash"), "header.".concat("git_hash"));
            }
            if (jSONObject.has("region")) {
                d3.a(jSONObject.opt("region"), "header.".concat("region"));
            }
            if (jSONObject.has("sys_region")) {
                d3.a(jSONObject.opt("sys_region"), "header.".concat("sys_region"));
            }
            if (jSONObject.has("sim_region")) {
                d3.a(jSONObject.opt("sim_region"), "header.".concat("sim_region"));
            }
            if (jSONObject.has("carrier_region")) {
                d3.a(jSONObject.opt("carrier_region"), "header.".concat("carrier_region"));
            }
            if (jSONObject.has("mcc_mnc")) {
                d3.a(jSONObject.opt("mcc_mnc"), "header.".concat("mcc_mnc"));
            }
            if (jSONObject.has("carrier")) {
                d3.a(jSONObject.opt("carrier"), "header.".concat("carrier"));
            }
            if (jSONObject.has("tz_name")) {
                d3.a(jSONObject.opt("tz_name"), "header.".concat("tz_name"));
            }
            if (jSONObject.has("tz_offset")) {
                d3.a(jSONObject.opt("tz_offset"), "header.".concat("tz_offset"));
            }
            if (jSONObject.has("timezone")) {
                d3.a(jSONObject.opt("timezone"), "header.".concat("timezone"));
            }
            if (jSONObject.has("timezone_name")) {
                d3.a(jSONObject.opt("timezone_name"), "header.".concat("timezone_name"));
            }
            if (jSONObject.has("timezone_offset")) {
                d3.a(jSONObject.opt("timezone_offset"), "header.".concat("timezone_offset"));
            }
        }
    }
}
