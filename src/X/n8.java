package X;

import com.windukk.hook.HookMethod;

class n8 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d7.a().a) {
            hookMethodParam.setResult(Boolean.TRUE);
        }
    }
}
