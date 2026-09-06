package Z;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.FontHooks;

class m5 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
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
            Typeface typeface = (Typeface) hookMethodParam.args[0];
            Typeface typefaceA = FontHooks.a(strE, typeface != null ? typeface.getStyle() : 0);
            if (typefaceA != null) {
                hookMethodParam.args[0] = typefaceA;
            }
        } finally {
            FontHooks.d.set(Boolean.FALSE);
        }
    }
}
