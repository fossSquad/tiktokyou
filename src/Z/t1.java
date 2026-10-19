package Z;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.windukk.hook.HookMethod;

class t1 extends HookMethod {
    final  int a;

    public t1(int i) {
        this.a = i;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        CharSequence charSequenceAppend;
        ae aeVarA;
        int i = this.a;
        String[] strArr = v1.a;
        Object[] objArr = hookMethodParam.args;
        if (objArr.length > i) {
            Object obj = objArr[i];
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                Object obj2 = hookMethodParam.thisObject;
                if (TextUtils.isEmpty(charSequence) || (aeVarA = v1.a(obj2)) == null) {
                    charSequenceAppend = charSequence;
                } else {
                    String string = charSequence.toString();
                    String strA = v1.a(aeVarA.a, string);
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
