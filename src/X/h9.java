package X;

import com.windukk.hook.HookMethod;

class h9 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d7.a().d) {
            hookMethodParam.setResult(Boolean.FALSE);
        }
    }
}
