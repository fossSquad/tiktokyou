package Z;

import com.windukk.hook.HookMethod;

class lc extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        pc.a(true, hookMethodParam);
    }
}
