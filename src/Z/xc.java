package Z;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import com.windukk.hook.HookMethod;
import java.util.Map;

class xc extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj;
        int[] iArr = cd.a;
        if (ta.a() == null || !ta.d().s) {
            return;
        }
        Object obj2 = hookMethodParam.thisObject;
        if (obj2 instanceof TextView) {
            TextView textView = (TextView) obj2;
            Object[] objArr = hookMethodParam.args;
            if (objArr.length != 0) {
                Object obj3 = objArr[0];
                if (obj3 instanceof CharSequence) {
                    CharSequence charSequence = (CharSequence) obj3;
                    if (TextUtils.isEmpty(charSequence)) {
                        obj = charSequence;
                    } else {
                        if (charSequence instanceof Spanned) {
                            Spanned spanned = (Spanned) charSequence;
                            if (((bd[]) spanned.getSpans(0, spanned.length(), bd.class)).length > 0) {
                                obj = charSequence;
                            }
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
                        spannableStringBuilder.setSpan(new bd(), 0, spannableStringBuilder.length(), 33);
                        obj = spannableStringBuilder;
                    }
                    if (obj != charSequence) {
                        hookMethodParam.args[0] = obj;
                    }
                    Map map = cd.b;
                    if (map.containsKey(textView)) {
                        return;
                    }
                    map.put(textView, Boolean.TRUE);
                    textView.post(new zc(textView));
                }
            }
        }
    }
}
