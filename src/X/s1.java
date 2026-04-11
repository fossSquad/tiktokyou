package X;

import de.robv.android.xposed.XC_MethodHook;

class s1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().d) {
            methodHookParam.args[0] = Boolean.FALSE;
        }
    }
}
