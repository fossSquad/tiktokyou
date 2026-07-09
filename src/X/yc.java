package X;

import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

class yc extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (l8.a().d() && (colorStateListA = hd.a((colorStateList = (ColorStateList) hookMethodParam.getResult()))) != colorStateList) {
            hookMethodParam.setResult(colorStateListA);
        }
    }
}
