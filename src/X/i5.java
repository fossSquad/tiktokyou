package X;

import android.content.res.ColorStateList;
import de.robv.android.xposed.XC_MethodHook;

class i5 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (r2.a().d() && (colorStateListA = k5.a((colorStateList = (ColorStateList) methodHookParam.args[0]))) != colorStateList) {
            methodHookParam.args[0] = colorStateListA;
        }
    }
}
