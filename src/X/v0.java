package X;

import android.graphics.Typeface;
import de.robv.android.xposed.XC_MethodHook;

class v0 extends XC_MethodHook {

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        int style;
        Typeface typefaceA;
        ThreadLocal threadLocal = w0.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        String str = i1.a().g;
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
                typefaceA = w0.a(str, style);
                if (typefaceA != null) {
                    methodHookParam.args[0] = typefaceA;
                }
            }
            style = ((Integer) objArr[1]).intValue();
            typefaceA = w0.a(str, style);
            if (typefaceA != null) {
                methodHookParam.args[0] = typefaceA;
            }
        } finally {
            w0.d.set(Boolean.FALSE);
        }
    }
}
