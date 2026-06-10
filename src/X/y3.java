package X;

import com.windukk.hook.HookMethod;

class y3 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d7.a().d) {
            hookMethodParam.setResult(0);
        }
    }
}
