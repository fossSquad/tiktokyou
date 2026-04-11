package X;

import android.content.res.ColorStateList;
import de.robv.android.xposed.XC_MethodHook;

class w4 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (r2.a().d() && (colorStateListA = k5.a((colorStateList = (ColorStateList) methodHookParam.getResult()))) != colorStateList) {
            methodHookParam.setResult(colorStateListA);
        }
    }
}
