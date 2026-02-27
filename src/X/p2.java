package X;

import android.content.res.ColorStateList;
import de.robv.android.xposed.XC_MethodHook;

class p2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (r0.a().c() && (colorStateListA = y2.a((colorStateList = (ColorStateList) methodHookParam.getResult()))) != colorStateList) {
            methodHookParam.setResult(colorStateListA);
        }
    }
}
