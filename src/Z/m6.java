package Z;

import android.graphics.Typeface;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.MandatoryLoginHooks;

public class m6 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int style;
        Typeface typefaceA;
        ThreadLocal threadLocal = MandatoryLoginHooks.d;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        ac.a().getClass();
        String strF = ac.f();
        if ("default".equals(strF)) {
            return;
        }
        threadLocal.set(Boolean.TRUE);
        try {
            Object[] objArr = hookMethodParam.args;
            Typeface typeface = (Typeface) objArr[0];
            if (objArr.length < 2) {
                if (typeface != null) {
                    style = typeface.getStyle();
                } else {
                    style = 0;
                }
                typefaceA = MandatoryLoginHooks.a(style, strF);
                if (typefaceA != null) {
                    hookMethodParam.args[0] = typefaceA;
                }
            }
            style = ((Integer) objArr[1]).intValue();
            typefaceA = MandatoryLoginHooks.a(style, strF);
            if (typefaceA != null) {
                hookMethodParam.args[0] = typefaceA;
            }
        } finally {
            MandatoryLoginHooks.d.set(Boolean.FALSE);
        }
    }
}
