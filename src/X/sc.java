package X;

import com.windukk.hook.HookMethod;

class sc extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (l8.a().d() && (iA = hd.a((iIntValue = ((Integer) hookMethodParam.getResult()).intValue()))) != iIntValue) {
            hookMethodParam.setResult(Integer.valueOf(iA));
        }
    }
}
