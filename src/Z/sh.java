package Z;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

class sh extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (ac.a().g()) {
            Object obj = hookMethodParam.args[0];
            if (!(obj instanceof Integer)) {
                if (!(obj instanceof ColorStateList) || (colorStateListA = zh.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                hookMethodParam.args[0] = colorStateListA;
                return;
            }
            int iIntValue = ((Integer) obj).intValue();
            int iA = zh.a(iIntValue);
            if (iA != iIntValue) {
                hookMethodParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
