package X;

import de.robv.android.xposed.XC_MethodHook;

class r4 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (r2.a().d() && (iA = k5.a((iIntValue = ((Integer) methodHookParam.getResult()).intValue()))) != iIntValue) {
            methodHookParam.setResult(Integer.valueOf(iA));
        }
    }
}
