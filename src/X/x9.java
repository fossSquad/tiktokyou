package X;

import com.windukk.hook.HookMethod;

class x9 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (d7.a().d() && (iA = cb.a((iIntValue = ((Integer) hookMethodParam.args[0]).intValue()))) != iIntValue) {
            hookMethodParam.args[0] = Integer.valueOf(iA);
        }
    }
}
