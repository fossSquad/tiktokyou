package Z;

import com.windukk.hook.HookMethod;

class nf extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y5.a().d) {
            hookMethodParam.setResult((Object) null);
        }
    }
}
