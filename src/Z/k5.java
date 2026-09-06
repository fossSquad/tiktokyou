package Z;

import com.windukk.hook.HookMethod;

class k5 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) throws Throwable {
        hookMethodParam.args[0] = Boolean.FALSE;
    }
}
