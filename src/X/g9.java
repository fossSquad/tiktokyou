package X;

import com.windukk.hook.HookMethod;

class g9 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str = (String) hookMethodParam.args[0];
        if (n9.a(str)) {
            hookMethodParam.args[0] = str.replace("watermark", "origin").replace("water_mark", "origin").replaceAll("q[0-9]{1,3}", "q100").replaceAll("shrink:[0-9]+:[0-9]+", "shrink:0:0");
            int i = g5.a;
        }
    }
}
