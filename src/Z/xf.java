package Z;

import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.ThemeHooks;

class xf extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (ta.a().f() && (iA = ThemeHooks.a((iIntValue = ((Integer) hookMethodParam.getResult()).intValue()))) != iIntValue) {
            hookMethodParam.setResult(Integer.valueOf(iA));
        }
    }
}
