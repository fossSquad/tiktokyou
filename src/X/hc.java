package X;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

class hc extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (l8.a().d() && (colorStateListA = hd.a((colorStateList = (ColorStateList) hookMethodParam.args[0]))) != colorStateList) {
            hookMethodParam.args[0] = colorStateListA;
        }
    }
}
