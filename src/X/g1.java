package X;

import de.robv.android.xposed.XC_MethodHook;

class g1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r0.a().a) {
            methodHookParam.setResult(5);
        }
    }
}
