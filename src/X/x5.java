package X;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

class x5 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (y3.a().d() && (colorStateListA = x6.a((colorStateList = (ColorStateList) hookMethodParam.args[0]))) != colorStateList) {
            hookMethodParam.args[0] = colorStateListA;
        }
    }
}
