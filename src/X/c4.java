package X;

import com.windukk.hook.HookMethod;

class c4 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.args[0] = Boolean.FALSE;
    }
}
