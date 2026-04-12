package X;

import de.robv.android.xposed.XC_MethodHook;

class t1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (s2.a().d) {
            methodHookParam.args[0] = Boolean.FALSE;
        }
    }
}
