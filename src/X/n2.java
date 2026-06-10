package X;

import com.windukk.hook.HookMethod;

class n2 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if ("android_id".equals(hookMethodParam.args[1])) {
            hookMethodParam.setResult(v2.b);
        }
    }
}
