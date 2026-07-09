package X;

import com.windukk.hook.HookMethod;

class gd extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (l8.a().d()) {
            Object obj = hookMethodParam.args[0];
            if (!(obj instanceof Integer) || (iA = hd.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                return;
            }
            hookMethodParam.args[0] = Integer.valueOf(iA);
        }
    }
}
