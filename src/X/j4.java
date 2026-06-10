package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class j4 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int style;
        Typeface typefaceA;
        ThreadLocal threadLocal = k4.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = d7.a().h;
        if ("default".equals(str)) {
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
                typefaceA = k4.a(str, style);
                if (typefaceA != null) {
                    hookMethodParam.args[0] = typefaceA;
                }
            }
            style = ((Integer) objArr[1]).intValue();
            typefaceA = k4.a(str, style);
            if (typefaceA != null) {
                hookMethodParam.args[0] = typefaceA;
            }
        } finally {
            k4.d.set(Boolean.FALSE);
        }
    }
}
