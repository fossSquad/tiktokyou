package X;

import de.robv.android.xposed.XC_MethodHook;

class b5 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (s2.a().d() && (iA = l5.a((iIntValue = ((Integer) methodHookParam.args[0]).intValue()))) != iIntValue) {
            methodHookParam.args[0] = Integer.valueOf(iA);
        }
    }
}
