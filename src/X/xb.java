package X;

import com.windukk.hook.HookMethod;

class xb extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(Boolean.FALSE);
    }
}
