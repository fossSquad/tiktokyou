package X;

import android.content.res.ColorStateList;
import de.robv.android.xposed.XC_MethodHook;

class c3 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (i1.a().d() && (colorStateListA = d4.a((colorStateList = (ColorStateList) methodHookParam.args[0]))) != colorStateList) {
            methodHookParam.args[0] = colorStateListA;
        }
    }
}
