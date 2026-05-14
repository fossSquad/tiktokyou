package X;

import com.windukk.hook.HookMethod;

class i6 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (y3.a().d() && (iA = x6.a((iIntValue = ((Integer) hookMethodParam.getResult()).intValue()))) != iIntValue) {
            hookMethodParam.setResult(Integer.valueOf(iA));
        }
    }
}
