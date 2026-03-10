package X;

import de.robv.android.xposed.XC_MethodHook;

class f2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (i1.a().a) {
            methodHookParam.setResult(i1.a().b().c);
        }
    }
}
