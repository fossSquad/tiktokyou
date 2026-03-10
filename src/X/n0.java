package X;

import de.robv.android.xposed.XC_MethodHook;

class n0 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        methodHookParam.args[0] = Integer.valueOf(((Integer) methodHookParam.args[0]).intValue() & (-8193));
    }
}
