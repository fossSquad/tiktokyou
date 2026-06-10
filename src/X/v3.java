package X;

import com.windukk.hook.HookMethod;

class v3 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d7.a().d) {
            hookMethodParam.args[0] = Boolean.FALSE;
        }
    }
}
