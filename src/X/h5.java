package X;

import de.robv.android.xposed.XC_MethodHook;

class h5 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (r2.a().d() && (iA = k5.a((iIntValue = ((Integer) methodHookParam.args[0]).intValue()))) != iIntValue) {
            methodHookParam.args[0] = Integer.valueOf(iA);
        }
    }
}
