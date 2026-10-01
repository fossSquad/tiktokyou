package Z;

import com.windukk.hook.HookMethod;
import Z.ThemeHooks;

class fg extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (ta.a().f() && (iA = ThemeHooks.a((iIntValue = ((Integer) hookMethodParam.args[0]).intValue()))) != iIntValue) {
            hookMethodParam.args[0] = Integer.valueOf(iA);
        }
    }
}
