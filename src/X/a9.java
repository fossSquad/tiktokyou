package X;

import com.windukk.hook.HookMethod;

class a9 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (Boolean.FALSE.equals(hookMethodParam.getResult())) {
            hookMethodParam.setResult(Boolean.TRUE);
        }
    }
}
