package Z;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.FontHooks;

class p5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
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
            Typeface typefaceA = FontHooks.a(strE, ((Integer) hookMethodParam.args[1]).intValue());
            if (typefaceA != null) {
                hookMethodParam.setResult(typefaceA);
            }
        } finally {
            FontHooks.d.set(Boolean.FALSE);
        }
    }
}
