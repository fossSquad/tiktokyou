package X;

import de.robv.android.xposed.XC_MethodHook;

class p2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (i1.a().h) {
            methodHookParam.setResult(Boolean.TRUE);
        }
    }
}
