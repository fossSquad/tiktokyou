package X;

import de.robv.android.xposed.XC_MethodHook;

class h2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (t1.a().a) {
            methodHookParam.setResult(5);
        }
    }
}
