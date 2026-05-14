package X;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

class q6 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (y3.a().d()) {
            Object obj = hookMethodParam.args[0];
            if (!(obj instanceof Integer)) {
                if (!(obj instanceof ColorStateList) || (colorStateListA = x6.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                hookMethodParam.args[0] = colorStateListA;
                return;
            }
            int iIntValue = ((Integer) obj).intValue();
            int iA = x6.a(iIntValue);
            if (iA != iIntValue) {
                hookMethodParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
