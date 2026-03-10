package X;

import de.robv.android.xposed.XC_MethodHook;

class i0 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (i1.a().d) {
            methodHookParam.setResult((Object) null);
        }
    }
}
