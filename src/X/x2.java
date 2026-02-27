package X;

import de.robv.android.xposed.XC_MethodHook;

class x2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (r0.a().c()) {
            Object obj = methodHookParam.args[0];
            if (!(obj instanceof Integer) || (iA = y2.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                return;
            }
            methodHookParam.args[0] = Integer.valueOf(iA);
        }
    }
}
