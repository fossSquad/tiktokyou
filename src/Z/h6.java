package Z;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.MandatoryLoginHooks;

public class h6 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = MandatoryLoginHooks.d;
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
            Typeface typefaceA = MandatoryLoginHooks.a(typeface != null ? typeface.getStyle() : 0, strF);
            if (typefaceA != null) {
                hookMethodParam.args[0] = typefaceA;
            }
        } finally {
            MandatoryLoginHooks.d.set(Boolean.FALSE);
        }
    }
}
