package Z;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;
import Z.ThemeHooks;

class zf extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (ta.a().f() && (colorStateListA = ThemeHooks.a((colorStateList = (ColorStateList) hookMethodParam.getResult()))) != colorStateList) {
            hookMethodParam.setResult(colorStateListA);
        }
    }
}
