package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class b2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = h2.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = r2.a().g;
        if ("default".equals(str)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Typeface typeface = (Typeface) methodHookParam.args[0];
            Typeface typefaceA = h2.a(str, typeface != null ? typeface.getStyle() : 0);
            if (typefaceA != null) {
                methodHookParam.args[0] = typefaceA;
            }
        } finally {
            h2.d.set(Boolean.FALSE);
        }
    }
}
