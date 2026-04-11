package X;

import de.robv.android.xposed.XC_MethodHook;

class v1 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().d) {
            methodHookParam.setResult(0);
        }
    }
}
