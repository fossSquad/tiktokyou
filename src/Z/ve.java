package Z;

import android.view.View;
import com.windukk.hook.HookMethod;
import Z.StoryEngagementHooks;
import java.util.Map;

class ve extends HookMethod {

    public static void a(Object obj, View view) {
        try {
            StoryEngagementHooks.b(obj, view);
        } catch (Throwable th) {
            String strDecrypt = "Story share count view failed";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        View view = null;
        try {
            Object[] objArr = hookMethodParam.args;
            Map map = StoryEngagementHooks.a;
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
                StoryEngagementHooks.b(view);
                final Object obj2 = hookMethodParam.thisObject;
                final View viewF1 = view;
                view.post(new Runnable() {
                    @Override
                    public final void run() {
                        ve.a(obj2, viewF1);
                    }
                });
            }
            if (view == null) {
                return;
            }
            StoryEngagementHooks.b(view);
            final Object obj3 = hookMethodParam.thisObject;
            final View viewF3 = view;
            view.post(new Runnable() {
                @Override
                public final void run() {
                    ve.a(obj3, viewF3);
                }
            });
        } catch (Throwable th) {
            String strDecrypt = "Story share count scheduling failed";
            Object obj4 = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
