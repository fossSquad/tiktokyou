package X;

import com.windukk.hook.HookMethod;

class b4 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str = (String) hookMethodParam.args[0];
        if (str == null || !str.contains("watermark")) {
            return;
        }
        hookMethodParam.args[0] = str.replace("watermark", "origin").replaceAll("q[0-9]{1,3}", "q100").replaceAll("shrink:[0-9]+:[0-9]+", "shrink:0:0");
        int i = v3.a;
    }
}
