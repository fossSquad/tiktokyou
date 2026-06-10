package X;

import com.windukk.hook.HookMethod;

class t8 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d7.a().a) {
            hookMethodParam.setResult(d7.a().b().e);
        }
    }
}
