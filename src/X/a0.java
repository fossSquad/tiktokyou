package X;

import android.widget.TextView;
import de.robv.android.xposed.XC_MethodHook;

class a0 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        CharSequence charSequence;
        CharSequence charSequenceA;
        Object[] objArr = methodHookParam.args;
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if ((obj instanceof CharSequence) && (charSequenceA = k0.a((TextView) methodHookParam.thisObject, (charSequence = (CharSequence) obj))) != charSequence) {
                methodHookParam.args[0] = charSequenceA;
            }
        }
    }
}
