package Z;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.ThemeHooks;

class bg extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (ta.a().f()) {
            Object obj = hookMethodParam.args[0];
            if (!(obj instanceof Integer)) {
                if (!(obj instanceof ColorStateList) || (colorStateListA = ThemeHooks.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                hookMethodParam.args[0] = colorStateListA;
                return;
            }
            int iIntValue = ((Integer) obj).intValue();
            int iA = ThemeHooks.a(iIntValue);
            if (iA != iIntValue) {
                hookMethodParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
