package X;

import com.windukk.hook.HookMethod;

class o4 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.args[0] = Integer.valueOf(((Integer) hookMethodParam.args[0]).intValue() & (-8193));
    }
}
