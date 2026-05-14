package X;

import com.windukk.hook.HookMethod;

class z1 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if ("android_id".equals(hookMethodParam.args[1])) {
            hookMethodParam.setResult(h2.b);
        }
    }
}
