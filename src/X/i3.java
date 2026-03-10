package X;

import de.robv.android.xposed.XC_MethodHook;

class i3 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue;
        int iA;
        if (i1.a().d() && (iA = d4.a((iIntValue = ((Integer) methodHookParam.getResult()).intValue()))) != iIntValue) {
            methodHookParam.setResult(Integer.valueOf(iA));
        }
    }
}
