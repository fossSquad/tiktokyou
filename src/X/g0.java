package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class g0 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = m0.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = r0.a().g;
        if ("default".equals(str)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Typeface typefaceA = m0.a(str);
            if (typefaceA != null) {
                methodHookParam.setResult(typefaceA);
            }
        } finally {
            m0.d.set(Boolean.FALSE);
        }
    }
}
