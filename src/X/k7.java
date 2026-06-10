package X;

import com.windukk.hook.HookMethod;

class k7 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str = (String) hookMethodParam.args[0];
        if (q7.a(str)) {
            hookMethodParam.args[0] = str.replace("watermark", "origin").replace("water_mark", "origin").replaceAll("q[0-9]{1,3}", "q100").replaceAll("shrink:[0-9]+:[0-9]+", "shrink:0:0");
            int i = p4.a;
        }
    }
}
