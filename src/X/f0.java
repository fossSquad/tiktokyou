package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class f0 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
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
            Typeface typeface = (Typeface) methodHookParam.args[0];
            Typeface typefaceA = m0.a(str, typeface != null ? typeface.getStyle() : 0);
            if (typefaceA != null) {
                methodHookParam.args[0] = typefaceA;
            }
        } finally {
            m0.d.set(Boolean.FALSE);
        }
    }
}
