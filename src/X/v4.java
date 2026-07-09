package X;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;

class v4 extends HookMethod {
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
            int i = 1;
            int iIntValue = ((Integer) hookMethodParam.args[1]).intValue();
            boolean zBooleanValue = ((Boolean) hookMethodParam.args[2]).booleanValue();
            if (iIntValue >= 600 && zBooleanValue) {
                i = 3;
            } else if (iIntValue < 600) {
                i = zBooleanValue ? 2 : 0;
            }
            Typeface typefaceA = x4.a(str, i);
            if (typefaceA != null) {
                hookMethodParam.setResult(typefaceA);
            }
        } finally {
            x4.d.set(Boolean.FALSE);
        }
    }
}
