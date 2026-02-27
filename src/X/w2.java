package X;

import android.content.res.ColorStateList;
import de.robv.android.xposed.XC_MethodHook;

class w2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (r0.a().c() && (colorStateListA = y2.a((colorStateList = (ColorStateList) methodHookParam.args[0]))) != colorStateList) {
            methodHookParam.args[0] = colorStateListA;
        }
    }
}
