package X;

import com.windukk.hook.HookMethod;

class bb extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (d7.a().d()) {
            Object obj = hookMethodParam.args[0];
            if (!(obj instanceof Integer) || (iA = cb.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                return;
            }
            hookMethodParam.args[0] = Integer.valueOf(iA);
        }
    }
}
