package X;

import de.robv.android.xposed.XC_MethodHook;

class q1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (i1.a().a) {
            methodHookParam.setResult(Integer.valueOf(Integer.parseInt(i1.a().b().c.substring(0, 3))));
        }
    }
}
