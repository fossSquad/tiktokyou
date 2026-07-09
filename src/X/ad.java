package X;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

class ad extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (l8.a().d()) {
            Object obj = hookMethodParam.args[0];
            if (!(obj instanceof Integer)) {
                if (!(obj instanceof ColorStateList) || (colorStateListA = hd.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                hookMethodParam.args[0] = colorStateListA;
                return;
            }
            int iIntValue = ((Integer) obj).intValue();
            int iA = hd.a(iIntValue);
            if (iA != iIntValue) {
                hookMethodParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
