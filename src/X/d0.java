package X;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;

class d0 extends XC_MethodReplacement {
    public Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        return 3;
    }
}
