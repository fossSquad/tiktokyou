package X;

import de.robv.android.xposed.XC_MethodHook;

class t2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (t1.a().d) {
            methodHookParam.setResult((Object) null);
        }
    }
}
