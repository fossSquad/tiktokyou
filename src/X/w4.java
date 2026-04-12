package X;

import de.robv.android.xposed.XC_MethodHook;

class w4 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (s2.a().d() && (iA = l5.a((iIntValue = ((Integer) methodHookParam.getResult()).intValue()))) != iIntValue) {
            methodHookParam.setResult(Integer.valueOf(iA));
        }
    }
}
