package X;

import de.robv.android.xposed.XC_MethodHook;

class v2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (t1.a().h) {
            methodHookParam.setResult(Boolean.TRUE);
        }
    }
}
