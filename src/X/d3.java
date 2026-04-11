package X;

import de.robv.android.xposed.XC_MethodHook;

class d3 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().a) {
            methodHookParam.setResult(r2.a().b().d);
        }
    }
}
