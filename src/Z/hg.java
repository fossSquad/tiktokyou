package Z;

import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.ThemeHooks;

class hg extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (ta.a().f()) {
            Object obj = hookMethodParam.args[0];
            if (!(obj instanceof Integer) || (iA = ThemeHooks.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                return;
            }
            hookMethodParam.args[0] = Integer.valueOf(iA);
        }
    }
}
