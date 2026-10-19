package Z;

import com.windukk.hook.HookMethod;

class pf extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (ac.a() == null || !ac.e().p) {
            return;
        }
        hookMethodParam.setResult(Boolean.TRUE);
    }
}
