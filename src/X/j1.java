package X;

import de.robv.android.xposed.XC_MethodHook;

class j1 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().d) {
            methodHookParam.setResult((Object) null);
        }
    }
}
