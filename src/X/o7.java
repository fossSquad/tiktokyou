package X;

import com.windukk.hook.HookMethod;

class o7 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (Boolean.FALSE.equals(hookMethodParam.getResult())) {
            hookMethodParam.setResult(Boolean.TRUE);
        }
    }
}
