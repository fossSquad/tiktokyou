package X;

import com.windukk.hook.HookMethod;

class f3 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().d) {
            hookMethodParam.setResult(0);
        }
    }
}
