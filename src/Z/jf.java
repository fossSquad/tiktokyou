package Z;

import com.windukk.hook.HookMethod;
import Z.ThemeHooks;

class jf extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (ta.a().f()) {
            Object[] objArr = hookMethodParam.args;
            if (objArr.length > 0) {
                Object obj = objArr[0];
                if (!(obj instanceof Integer) || (iA = ThemeHooks.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                    return;
                }
                hookMethodParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
