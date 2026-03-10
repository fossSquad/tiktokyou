package X;

import de.robv.android.xposed.XC_MethodHook;

class x1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (i1.a().a) {
            methodHookParam.setResult("02:00:00:00:00:00");
        }
    }
}
