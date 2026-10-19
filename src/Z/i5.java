package Z;

import com.windukk.hook.HookMethod;

class i5 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y5.a().d) {
            hookMethodParam.args[0] = Boolean.FALSE;
        }
    }
}
