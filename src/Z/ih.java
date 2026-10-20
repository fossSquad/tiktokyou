package Z;

import com.windukk.hook.HookMethod;

class ih extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (ac.a().g() && (iA = zh.a((iIntValue = ((Integer) hookMethodParam.getResult()).intValue()))) != iIntValue) {
            hookMethodParam.setResult(Integer.valueOf(iA));
        }
    }
}
