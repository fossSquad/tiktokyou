package X;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;

class c1 extends XC_MethodReplacement {
    public Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        return e1.a;
    }
}
