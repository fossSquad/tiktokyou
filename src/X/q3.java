package X;

import com.windukk.hook.HookMethod;

class q3 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (l8.a().c) {
            hookMethodParam.setResult(Boolean.FALSE);
        }
    }
}
