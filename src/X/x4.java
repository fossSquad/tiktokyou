package X;

import android.content.res.ColorStateList;
import de.robv.android.xposed.XC_MethodHook;

class x4 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (s2.a().d() && (colorStateListA = l5.a((colorStateList = (ColorStateList) methodHookParam.getResult()))) != colorStateList) {
            methodHookParam.setResult(colorStateListA);
        }
    }
}
