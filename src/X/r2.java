package X;

import android.content.res.ColorStateList;
import de.robv.android.xposed.XC_MethodHook;

class r2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (r0.a().c()) {
            Object obj = methodHookParam.args[0];
            if (!(obj instanceof Integer)) {
                if (!(obj instanceof ColorStateList) || (colorStateListA = y2.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                methodHookParam.args[0] = colorStateListA;
                return;
            }
            int iIntValue = ((Integer) obj).intValue();
            int iA = y2.a(iIntValue);
            if (iA != iIntValue) {
                methodHookParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
