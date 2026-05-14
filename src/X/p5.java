package X;

import com.windukk.hook.HookMethod;

class p5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            hookMethodParam.setResult(Boolean.FALSE);
        } catch (Throwable th) {
        }
    }
}
