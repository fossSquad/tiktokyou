package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class q3 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int style;
        Typeface typefaceA;
        ThreadLocal threadLocal = r3.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = y3.a().g;
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
                typefaceA = r3.a(str, style);
                if (typefaceA != null) {
                    hookMethodParam.args[0] = typefaceA;
                }
            }
            style = ((Integer) objArr[1]).intValue();
            typefaceA = r3.a(str, style);
            if (typefaceA != null) {
                hookMethodParam.args[0] = typefaceA;
            }
        } finally {
            r3.d.set(Boolean.FALSE);
        }
    }
}
