package Z;

import com.windukk.hook.HookMethod;

class x4 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y5.a().d) {
            hookMethodParam.setResult(Boolean.FALSE);
        }
    }
}
