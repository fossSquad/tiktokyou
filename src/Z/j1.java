package Z;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BadgeHooks;

class j1 extends HookMethod {
    final  int a;

    public j1(int i) {
        this.a = i;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        CharSequence charSequenceAppend;
        lc lcVarA;
        int i = this.a;
        String[] strArr = BadgeHooks.a;
        Object[] objArr = hookMethodParam.args;
        if (objArr.length > i) {
            Object obj = objArr[i];
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                Object obj2 = hookMethodParam.thisObject;
                if (TextUtils.isEmpty(charSequence) || (lcVarA = BadgeHooks.a(obj2)) == null) {
                    charSequenceAppend = charSequence;
                } else {
                    String string = charSequence.toString();
                    String strA = BadgeHooks.a(lcVarA.a, string);
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
