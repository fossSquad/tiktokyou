package X;

import com.windukk.hook.HookMethod;

class r6 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (y3.a().d()) {
            Object obj = hookMethodParam.args[0];
            if (!(obj instanceof Integer) || (iA = x6.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                return;
            }
            hookMethodParam.args[0] = Integer.valueOf(iA);
        }
    }
}
