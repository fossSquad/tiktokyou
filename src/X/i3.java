package X;

import com.windukk.hook.HookMethod;

class i3 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.args[0] = Integer.valueOf(((Integer) hookMethodParam.args[0]).intValue() & (-8193));
    }
}
