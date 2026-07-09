package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class u4 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
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
            Typeface typefaceA = x4.a(str, ((Integer) hookMethodParam.args[1]).intValue());
            if (typefaceA != null) {
                hookMethodParam.setResult(typefaceA);
            }
        } finally {
            x4.d.set(Boolean.FALSE);
        }
    }
}
