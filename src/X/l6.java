package X;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

class l6 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (y3.a().d() && (colorStateListA = x6.a((colorStateList = (ColorStateList) hookMethodParam.getResult()))) != colorStateList) {
            hookMethodParam.setResult(colorStateListA);
        }
    }
}
