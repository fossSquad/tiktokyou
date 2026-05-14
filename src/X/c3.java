package X;

import com.windukk.hook.HookMethod;

class c3 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().d) {
            hookMethodParam.args[0] = Boolean.FALSE;
        }
    }
}
