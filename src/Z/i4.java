package Z;

import com.windukk.hook.HookMethod;

class i4 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d5.a().d) {
            hookMethodParam.setResult(Boolean.FALSE);
        }
    }
}
