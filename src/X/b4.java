package X;

import com.windukk.hook.HookMethod;

class b4 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.args[0] = Integer.valueOf(((Integer) hookMethodParam.args[0]).intValue() & (-8193));
    }
}
