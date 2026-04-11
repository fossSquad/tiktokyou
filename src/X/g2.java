package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class g2 extends XC_MethodHook {

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int style;
        Typeface typefaceA;
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
            Object[] objArr = methodHookParam.args;
            Typeface typeface = (Typeface) objArr[0];
            if (objArr.length < 2) {
                if (typeface != null) {
                    style = typeface.getStyle();
                } else {
                    style = 0;
                }
                typefaceA = h2.a(str, style);
                if (typefaceA != null) {
                    methodHookParam.args[0] = typefaceA;
                }
            }
            style = ((Integer) objArr[1]).intValue();
            typefaceA = h2.a(str, style);
            if (typefaceA != null) {
                methodHookParam.args[0] = typefaceA;
            }
        } finally {
            h2.d.set(Boolean.FALSE);
        }
    }
}
