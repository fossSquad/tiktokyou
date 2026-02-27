package X;

import de.robv.android.xposed.XC_MethodHook;

class l1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r0.a().h) {
            int iIntValue = ((Integer) methodHookParam.args[0]).intValue();
            if (iIntValue == 3 || iIntValue == 4) {
                methodHookParam.args[0] = 0;
            }
        }
    }
}
