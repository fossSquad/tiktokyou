package X;

import de.robv.android.xposed.XC_MethodHook;

class x1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int iIntValue = ((Integer) methodHookParam.args[0]).intValue();
        int iIntValue2 = ((Integer) methodHookParam.args[1]).intValue() & (-8193);
        methodHookParam.args[0] = Integer.valueOf(iIntValue & (-8193));
        methodHookParam.args[1] = Integer.valueOf(iIntValue2);
    }
}
