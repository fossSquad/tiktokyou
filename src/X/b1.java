package X;

import de.robv.android.xposed.XC_MethodHook;

class b1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        methodHookParam.args[0] = Boolean.FALSE;
    }
}
