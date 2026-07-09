package X;

import com.windukk.hook.HookMethod;

class cc extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (l8.a().d() && (iA = hd.a((iIntValue = ((Integer) hookMethodParam.args[0]).intValue()))) != iIntValue) {
            hookMethodParam.args[0] = Integer.valueOf(iA);
        }
    }
}
