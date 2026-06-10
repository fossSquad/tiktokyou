package X;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

class va extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (d7.a().d()) {
            Object obj = hookMethodParam.args[0];
            if (!(obj instanceof Integer)) {
                if (!(obj instanceof ColorStateList) || (colorStateListA = cb.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                hookMethodParam.args[0] = colorStateListA;
                return;
            }
            int iIntValue = ((Integer) obj).intValue();
            int iA = cb.a(iIntValue);
            if (iA != iIntValue) {
                hookMethodParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
