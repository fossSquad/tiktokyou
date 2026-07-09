package X;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;

class b1 extends HookMethod {
    final  int a;

    public b1(int i) {
        this.a = i;
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        CharSequence charSequenceAppend;
        w9 w9VarA;
        int i = this.a;
        ConcurrentHashMap concurrentHashMap = d1.a;
        Object[] objArr = hookMethodParam.args;
        if (objArr.length > i) {
            Object obj = objArr[i];
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                Object obj2 = hookMethodParam.thisObject;
                if (TextUtils.isEmpty(charSequence) || (w9VarA = d1.a(obj2)) == null) {
                    charSequenceAppend = charSequence;
                } else {
                    String string = charSequence.toString();
                    String strA = d1.a(w9VarA.a, string);
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
