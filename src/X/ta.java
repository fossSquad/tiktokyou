package X;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

class ta extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (d7.a().d() && (colorStateListA = cb.a((colorStateList = (ColorStateList) hookMethodParam.getResult()))) != colorStateList) {
            hookMethodParam.setResult(colorStateListA);
        }
    }
}
