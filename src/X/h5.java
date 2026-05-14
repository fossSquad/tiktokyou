package X;

import com.windukk.hook.HookMethod;

class h5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().h) {
            hookMethodParam.setResult(Boolean.TRUE);
        }
    }
}
