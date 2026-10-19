package Z;

import android.view.View;
import com.windukk.hook.HookMethod;
import java.util.Map;

class ig extends HookMethod {

    public static void a(Object obj, View view) {
        try {
            kg.b(obj, view);
        } catch (Throwable th) {
            String strDecrypt = "Story share count view failed";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        final View view;
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
                if (view == null) {
                    return;
                }
                kg.b(view);
                final Object obj2 = hookMethodParam.thisObject;
                view.post(new Runnable() {
                    @Override
                    public final void run() {
                        ig.a(obj2, view);
                    }
                });
            }
            view = null;
            if (view == null) {
                return;
            }
            kg.b(view);
            final Object obj3 = hookMethodParam.thisObject;
            view.post(new Runnable() {
                @Override
                public final void run() {
                    ig.a(obj3, view);
                }
            });
        } catch (Throwable th) {
            String strDecrypt = "Story share count scheduling failed";
            Object obj4 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
