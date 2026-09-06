package Z;

import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.ThemeHooks;

class mf extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (ta.a().f()) {
            Object[] objArr = hookMethodParam.args;
            if (objArr.length >= 2) {
                Object obj = objArr[1];
                if (!(obj instanceof Integer) || (iA = ThemeHooks.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                    return;
                }
                hookMethodParam.args[1] = Integer.valueOf(iA);
            }
        }
    }
}
