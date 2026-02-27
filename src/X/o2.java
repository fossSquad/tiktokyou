package X;

import de.robv.android.xposed.XC_MethodHook;

class o2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (r0.a().c() && (iA = y2.a((iIntValue = ((Integer) methodHookParam.args[0]).intValue()))) != iIntValue) {
            methodHookParam.args[0] = Integer.valueOf(iA);
        }
    }
}
