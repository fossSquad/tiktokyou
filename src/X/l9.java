package X;

import com.windukk.hook.HookMethod;

class l9 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        n9.b(hookMethodParam.getResult());
    }
}
