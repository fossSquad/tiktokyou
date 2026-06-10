package X;

import com.windukk.hook.HookMethod;

class ja extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (d7.a().d() && (iA = cb.a((iIntValue = ((Integer) hookMethodParam.getResult()).intValue()))) != iIntValue) {
            hookMethodParam.setResult(Integer.valueOf(iA));
        }
    }
}
