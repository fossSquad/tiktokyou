package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class e4 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
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
            Typeface typeface = (Typeface) hookMethodParam.args[0];
            Typeface typefaceA = k4.a(str, typeface != null ? typeface.getStyle() : 0);
            if (typefaceA != null) {
                hookMethodParam.args[0] = typefaceA;
            }
        } finally {
            k4.d.set(Boolean.FALSE);
        }
    }
}
