package Z;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.ThemeHooks;

class lf extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (ta.a().f()) {
            Object[] objArr = hookMethodParam.args;
            if (objArr.length >= 2) {
                Object obj = objArr[1];
                if (!(obj instanceof ColorStateList) || (colorStateListA = ThemeHooks.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                hookMethodParam.args[1] = colorStateListA;
            }
        }
    }
}
