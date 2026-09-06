package Z;

import com.windukk.hook.HookMethod;

class xa extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        bb.a(true, hookMethodParam);
    }
}
