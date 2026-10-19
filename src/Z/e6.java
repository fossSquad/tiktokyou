package Z;

import com.windukk.hook.HookMethod;

class e6 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) throws Throwable {
        hookMethodParam.args[0] = Integer.valueOf(((Integer) hookMethodParam.args[0]).intValue() & (-8193));
    }
}
