package X;

import com.windukk.hook.HookMethod;

class x3 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d7.a().d) {
            hookMethodParam.setResult(0);
        }
    }
}
