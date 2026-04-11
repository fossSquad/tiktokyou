package X;

import de.robv.android.xposed.XC_MethodHook;

class j5 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (r2.a().d()) {
            Object obj = methodHookParam.args[0];
            if (!(obj instanceof Integer) || (iA = k5.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                return;
            }
            methodHookParam.args[0] = Integer.valueOf(iA);
        }
    }
}
