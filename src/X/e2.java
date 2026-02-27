package X;

import android.content.res.ColorStateList;
import de.robv.android.xposed.XC_MethodHook;

class e2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (r0.a().c()) {
            Object[] objArr = methodHookParam.args;
            if (objArr.length >= 2) {
                Object obj = objArr[1];
                if (!(obj instanceof ColorStateList) || (colorStateListA = y2.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                methodHookParam.args[1] = colorStateListA;
            }
        }
    }
}
