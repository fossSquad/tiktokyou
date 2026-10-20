package Z;

import com.windukk.hook.HookMethod;

class mc extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        pc.a(false, hookMethodParam);
    }
}
