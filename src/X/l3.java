package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class l3 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
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
            Typeface typeface = (Typeface) hookMethodParam.args[0];
            Typeface typefaceA = r3.a(str, typeface != null ? typeface.getStyle() : 0);
            if (typefaceA != null) {
                hookMethodParam.args[0] = typefaceA;
            }
        } finally {
            r3.d.set(Boolean.FALSE);
        }
    }
}
