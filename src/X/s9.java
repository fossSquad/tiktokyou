package X;

import com.windukk.hook.HookMethod;

class s9 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(Boolean.FALSE);
    }
}
