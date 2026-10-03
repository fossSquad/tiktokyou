package Z;

import com.windukk.hook.HookMethod;

class w4 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d5.a().d) {
            hookMethodParam.args[0] = Boolean.FALSE;
        }
    }
}
