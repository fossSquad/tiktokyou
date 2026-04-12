package X;

import de.robv.android.xposed.XC_MethodHook;

class k1 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (s2.a().d) {
            methodHookParam.setResult((Object) null);
        }
    }
}
