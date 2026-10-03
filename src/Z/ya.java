package Z;

import com.windukk.hook.HookMethod;

class ya extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        bb.a(false, hookMethodParam);
    }
}
