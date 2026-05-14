package X;

import com.windukk.hook.HookMethod;

class r4 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().a) {
            hookMethodParam.setResult(y3.a().b().e);
        }
    }
}
