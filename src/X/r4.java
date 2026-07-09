package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class r4 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = x4.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = l8.a().i;
        if ("default".equals(str)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Typeface typeface = (Typeface) hookMethodParam.args[0];
            Typeface typefaceA = x4.a(str, typeface != null ? typeface.getStyle() : 0);
            if (typefaceA != null) {
                hookMethodParam.args[0] = typefaceA;
            }
        } finally {
            x4.d.set(Boolean.FALSE);
        }
    }
}
