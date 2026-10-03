package Z;

import com.windukk.hook.HookMethod;

class zd extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (ta.a() == null || !ta.d().k) {
            return;
        }
        hookMethodParam.setResult(Boolean.TRUE);
    }
}
