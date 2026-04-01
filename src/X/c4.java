package X;

import android.content.res.ColorStateList;
import de.robv.android.xposed.XC_MethodHook;

class c4 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (t1.a().d()) {
            Object obj = methodHookParam.args[0];
            if (!(obj instanceof Integer)) {
                if (!(obj instanceof ColorStateList) || (colorStateListA = j4.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                methodHookParam.args[0] = colorStateListA;
                return;
            }
            int iIntValue = ((Integer) obj).intValue();
            int iA = j4.a(iIntValue);
            if (iA != iIntValue) {
                methodHookParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
