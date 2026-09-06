package Z;

import android.widget.TextView;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BadgeHooks;

class x0 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        CharSequence charSequence;
        CharSequence charSequenceA;
        Object[] objArr = hookMethodParam.args;
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if ((obj instanceof CharSequence) && (charSequenceA = BadgeHooks.a((TextView) hookMethodParam.thisObject, (charSequence = (CharSequence) obj))) != charSequence) {
                hookMethodParam.args[0] = charSequenceA;
            }
        }
    }
}
