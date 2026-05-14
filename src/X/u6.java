package X;

import com.windukk.hook.HookMethod;

class u6 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (y3.a().d() && (iA = x6.a((iIntValue = ((Integer) hookMethodParam.args[0]).intValue()))) != iIntValue) {
            hookMethodParam.args[0] = Integer.valueOf(iA);
        }
    }
}
