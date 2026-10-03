package Z;

import com.windukk.hook.HookMethod;

class j5 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.args[0] = Integer.valueOf(((Integer) hookMethodParam.args[0]).intValue() & (-8193));
    }
}
