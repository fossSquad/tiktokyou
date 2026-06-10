package X;

import com.windukk.hook.HookMethod;

class x2 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            if (z2.a(hookMethodParam.thisObject, hookMethodParam.method)) {
                hookMethodParam.setResult((Object) null);
            }
        } catch (Throwable th) {
            th.getMessage();
            int i = p4.a;
        }
    }
}
