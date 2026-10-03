package Z;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;
import Z.ThemeHooks;

class hf extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (ta.a().f() && (colorStateListA = ThemeHooks.a((colorStateList = (ColorStateList) hookMethodParam.args[0]))) != colorStateList) {
            hookMethodParam.args[0] = colorStateListA;
        }
    }
}
