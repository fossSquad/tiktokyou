package X;

import de.robv.android.xposed.XC_MethodHook;

class x3 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().h) {
            int iIntValue = ((Integer) methodHookParam.args[0]).intValue();
            if (iIntValue == 3 || iIntValue == 4) {
                methodHookParam.args[0] = 0;
            }
        }
    }
}
