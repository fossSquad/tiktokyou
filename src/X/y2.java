package X;

import de.robv.android.xposed.XC_MethodHook;

class y2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (i1.a().d() && (iA = d4.a((iIntValue = ((Integer) methodHookParam.args[0]).intValue()))) != iIntValue) {
            methodHookParam.args[0] = Integer.valueOf(iA);
        }
    }
}
