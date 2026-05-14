package X;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;

class h0 extends HookMethod {
    final  int a;

    public h0(int i) {
        this.a = i;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        CharSequence charSequenceAppend;
        q0 q0VarC;
        int i = this.a;
        ConcurrentHashMap concurrentHashMap = t0.a;
        Object[] objArr = hookMethodParam.args;
        if (objArr.length > i) {
            Object obj = objArr[i];
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                Object obj2 = hookMethodParam.thisObject;
                if (TextUtils.isEmpty(charSequence) || (q0VarC = t0.c(obj2)) == null) {
                    charSequenceAppend = charSequence;
                } else {
                    String string = charSequence.toString();
                    String strA = t0.a(q0VarC.a, string);
                    if (TextUtils.equals(strA, string)) {
                        charSequenceAppend = charSequence;
                    } else {
                        charSequenceAppend = new SpannableStringBuilder(charSequence).append((CharSequence) strA.substring(string.length()));
                    }
                }
                if (charSequenceAppend != charSequence) {
                    hookMethodParam.args[i] = charSequenceAppend;
                }
            }
        }
    }
}
