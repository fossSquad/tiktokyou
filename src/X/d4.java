package X;

import de.robv.android.xposed.XC_MethodHook;

class d4 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        try {
            methodHookParam.setResult(Boolean.FALSE);
        } catch (Throwable th) {
        }
    }
}
