package Z;

import com.windukk.hook.HookMethod;

class n5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        s5.b(hookMethodParam.thisObject);
    }
}
