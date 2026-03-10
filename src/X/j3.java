package X;

import android.content.res.ColorStateList;
import de.robv.android.xposed.XC_MethodHook;

class j3 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (i1.a().d()) {
            Object[] objArr = methodHookParam.args;
            if (objArr.length >= 2) {
                Object obj = objArr[1];
                if (!(obj instanceof ColorStateList) || (colorStateListA = d4.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                methodHookParam.args[1] = colorStateListA;
            }
        }
    }
}
