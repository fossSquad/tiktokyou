package Z;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class h6 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = n6.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        ac.a().getClass();
        String strF = ac.f();
        if ("default".equals(strF)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Typeface typeface = (Typeface) hookMethodParam.args[0];
            Typeface typefaceA = n6.a(typeface != null ? typeface.getStyle() : 0, strF);
            if (typefaceA != null) {
                hookMethodParam.args[0] = typefaceA;
            }
        } finally {
            n6.d.set(Boolean.FALSE);
        }
    }
}
