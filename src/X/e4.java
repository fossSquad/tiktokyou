package X;

import com.windukk.hook.HookMethod;

class e4 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (l8.a().c) {
            hookMethodParam.args[0] = Boolean.FALSE;
        }
    }
}
