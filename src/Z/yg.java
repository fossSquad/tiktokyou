package Z;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

class yg extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (ac.a().g() && (colorStateListA = zh.a((colorStateList = (ColorStateList) hookMethodParam.args[0]))) != colorStateList) {
            hookMethodParam.args[0] = colorStateListA;
        }
    }
}
