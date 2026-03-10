package X;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;

class b1 extends XC_MethodReplacement {
    public Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        return e1.b;
    }
}
