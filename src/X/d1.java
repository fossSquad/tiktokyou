package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class d1 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = j1.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = t1.a().g;
        if ("default".equals(str)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Typeface typeface = (Typeface) methodHookParam.args[0];
            Typeface typefaceA = j1.a(str, typeface != null ? typeface.getStyle() : 0);
            if (typefaceA != null) {
                methodHookParam.args[0] = typefaceA;
            }
        } finally {
            j1.d.set(Boolean.FALSE);
        }
    }
}
