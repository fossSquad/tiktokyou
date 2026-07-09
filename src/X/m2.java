package X;

import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;

class m2 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        boolean z = true;
        if (objArr.length >= 1) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                String str = (String) obj;
                ConcurrentHashMap concurrentHashMap = d3.a;
                if (str.length() > 12000) {
                    return;
                }
                boolean z2 = str.contains("\"device_id\"") || str.contains("\"device_id_str\"") || str.contains("\"did\"");
                boolean z3 = str.contains("\"install_id\"") || str.contains("\"install_id_str\"") || str.contains("\"iid\"");
                if (!str.contains("\"openudid\"") && !str.contains("\"clientudid\"") && !str.contains("\"cliend_udid\"")) {
                    z = false;
                }
                if ((str.contains("\"server_time\"") && z2 && z3) || ((z && z2) || str.contains("\"install_info\""))) {
                    d3.a("JSONObject.ctor", str);
                }
            }
        }
    }
}
