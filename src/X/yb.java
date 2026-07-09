package X;

import com.windukk.hook.HookMethod;

class yb extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(Boolean.FALSE);
    }
}
