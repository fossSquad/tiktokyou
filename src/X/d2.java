package X;

import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class d2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length >= 2) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                String str = (String) obj;
                Object obj2 = objArr[1];
                if ("header".equals(str) && (obj2 instanceof JSONObject)) {
                    JSONObject jSONObject = (JSONObject) obj2;
                    ConcurrentHashMap concurrentHashMap = v2.a;
                    v2.a(jSONObject.names(), "JSONObject.put.header.keys");
                    v2.a("JSONObject.put.header", jSONObject.toString());
                    return;
                }
                if (v2.c(str)) {
                    if (!(obj2 instanceof JSONObject)) {
                        v2.a(obj2, "JSONObject.put.".concat(str));
                        return;
                    }
                    JSONObject jSONObject2 = (JSONObject) obj2;
                    String strConcat = "JSONObject.put.".concat(str);
                    v2.a(jSONObject2.names(), strConcat + ".keys");
                    v2.a(strConcat, jSONObject2.toString());
                }
            }
        }
    }
}
