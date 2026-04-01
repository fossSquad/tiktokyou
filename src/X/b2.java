package X;

import de.robv.android.xposed.XC_MethodHook;

class b2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (t1.a().a) {
            methodHookParam.setResult(t1.a().b().b);
        }
    }
}
