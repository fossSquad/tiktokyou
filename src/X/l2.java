package X;

import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class l2 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length >= 2) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                String str = (String) obj;
                Object obj2 = objArr[1];
                if ("header".equals(str) && (obj2 instanceof JSONObject)) {
                    JSONObject jSONObject = (JSONObject) obj2;
                    ConcurrentHashMap concurrentHashMap = d3.a;
                    d3.a(jSONObject.names(), "JSONObject.put.header.keys");
                    d3.a("JSONObject.put.header", jSONObject.toString());
                    return;
                }
                if (d3.c(str)) {
                    if (!(obj2 instanceof JSONObject)) {
                        d3.a(obj2, "JSONObject.put.".concat(str));
                        return;
                    }
                    JSONObject jSONObject2 = (JSONObject) obj2;
                    String strConcat = "JSONObject.put.".concat(str);
                    d3.a(jSONObject2.names(), strConcat + ".keys");
                    d3.a(strConcat, jSONObject2.toString());
                }
            }
        }
    }
}
