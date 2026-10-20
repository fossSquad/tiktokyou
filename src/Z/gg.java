package Z;

import android.view.View;
import com.windukk.hook.HookMethod;
import java.util.Map;

class gg extends HookMethod {

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        View view;
        try {
            Object[] objArr = hookMethodParam.args;
            Map map = kg.a;
            if (objArr != null) {
                int length = objArr.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        Object obj = objArr[i];
                        if (obj instanceof View) {
                            view = (View) obj;
                            break;
                        }
                        i++;
                    }
                }
                if (view != null) {
                    kg.a(hookMethodParam.thisObject, view);
                }
            }
            view = null;
            if (view != null) {
                kg.a(hookMethodParam.thisObject, view);
            }
        } catch (Throwable th) {
            String strDecrypt = "Story digg count view failed";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
