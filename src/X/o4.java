package X;

import com.windukk.hook.HookMethod;

class o4 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().a) {
            hookMethodParam.setResult(y3.a().b().d);
        }
    }
}
