package X;

import com.windukk.hook.HookMethod;

class l4 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().a) {
            hookMethodParam.setResult(Boolean.TRUE);
        }
    }
}
