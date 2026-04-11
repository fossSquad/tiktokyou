package X;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;

class i2 extends XC_MethodReplacement {
    public Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        return r2.a().f ? Boolean.FALSE : Boolean.TRUE;
    }
}
