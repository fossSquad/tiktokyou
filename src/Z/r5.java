package Z;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;
import Z.FontHooks;

class r5 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int style;
        Typeface typefaceA;
        ThreadLocal threadLocal = FontHooks.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        ta.a().getClass();
        String strE = ta.e();
        if ("default".equals(strE)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Object[] objArr = hookMethodParam.args;
            Typeface typeface = (Typeface) objArr[0];
            if (objArr.length < 2) {
                if (typeface != null) {
                    style = typeface.getStyle();
                } else {
                    style = 0;
                }
                typefaceA = FontHooks.a(style, strE);
                if (typefaceA != null) {
                    hookMethodParam.args[0] = typefaceA;
                }
            }
            style = ((Integer) objArr[1]).intValue();
            typefaceA = FontHooks.a(style, strE);
            if (typefaceA != null) {
                hookMethodParam.args[0] = typefaceA;
            }
        } finally {
            FontHooks.d.set(Boolean.FALSE);
        }
    }
}
