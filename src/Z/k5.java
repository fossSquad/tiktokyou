package Z;

import com.windukk.hook.HookMethod;

class k5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y5.a().d) {
            hookMethodParam.setResult(0);
        }
    }
}
