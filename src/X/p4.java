package X;

import com.windukk.hook.HookMethod;

class p4 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.args[0] = Boolean.FALSE;
    }
}
