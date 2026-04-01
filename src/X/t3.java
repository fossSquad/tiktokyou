package X;

import android.content.res.ColorStateList;
import de.robv.android.xposed.XC_MethodHook;

class t3 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (t1.a().d() && (colorStateListA = j4.a((colorStateList = (ColorStateList) methodHookParam.getResult()))) != colorStateList) {
            methodHookParam.setResult(colorStateListA);
        }
    }
}
