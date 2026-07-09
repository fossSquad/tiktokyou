package X;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

class nc extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (l8.a().d()) {
            Object[] objArr = hookMethodParam.args;
            if (objArr.length >= 2) {
                Object obj = objArr[1];
                if (!(obj instanceof ColorStateList) || (colorStateListA = hd.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                hookMethodParam.args[1] = colorStateListA;
            }
        }
    }
}
