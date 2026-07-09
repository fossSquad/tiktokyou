package X;

import com.windukk.hook.HookMethod;

class f3 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            if (h3.a(hookMethodParam.thisObject, hookMethodParam.method)) {
                hookMethodParam.setResult(null);
            }
        } catch (Throwable th) {
            th.getMessage();
            int i = g5.a;
        }
    }
}
