package X;

import de.robv.android.xposed.XC_MethodHook;

class d2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (r0.a().c() && (iA = y2.a((iIntValue = ((Integer) methodHookParam.getResult()).intValue()))) != iIntValue) {
            methodHookParam.setResult(Integer.valueOf(iA));
        }
    }
}
