package X;

import android.widget.TextView;
import com.windukk.hook.HookMethod;

class o0 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        CharSequence charSequence;
        CharSequence charSequenceA;
        Object[] objArr = hookMethodParam.args;
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if ((obj instanceof CharSequence) && (charSequenceA = d1.a((TextView) hookMethodParam.thisObject, (charSequence = (CharSequence) obj))) != charSequence) {
                hookMethodParam.args[0] = charSequenceA;
            }
        }
    }
}
