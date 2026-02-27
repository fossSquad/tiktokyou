package X;

import de.robv.android.xposed.XC_MethodHook;

class z0 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r0.a().a) {
            methodHookParam.setResult(r0.a().b().b);
        }
    }
}
