package X;

import com.windukk.hook.HookMethod;

class t9 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(Boolean.FALSE);
    }
}
