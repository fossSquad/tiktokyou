package X;

import com.windukk.hook.HookMethod;

class j3 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d7.a().d) {
            hookMethodParam.setResult((Object) null);
        }
    }
}
