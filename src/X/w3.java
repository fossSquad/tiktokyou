package X;

import de.robv.android.xposed.XC_MethodHook;

class w3 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().h) {
            methodHookParam.setResult(Boolean.TRUE);
        }
    }
}
