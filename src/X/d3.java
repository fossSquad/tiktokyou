package X;

import de.robv.android.xposed.XC_MethodHook;

class d3 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (s2.a().a) {
            methodHookParam.setResult(s2.a().b().d);
        }
    }
}
