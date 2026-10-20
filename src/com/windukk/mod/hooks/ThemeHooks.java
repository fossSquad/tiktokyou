package com.windukk.mod.hooks;
import Z.*;


import android.view.View;
import com.windukk.hook.HookMethod;
import java.util.Map;

public class ThemeHooks extends HookMethod {

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
        try {
            Object[] objArr = hookMethodParam.args;
            Map map = kg.a;
            View view = null;
            if (objArr != null) {
                for (Object obj : objArr) {
                    if (obj instanceof View) {
                        view = (View) obj;
                        break;
                    }
                }
            }
            if (view == null) {
                return;
            }
            kg.b(view);
            final Object obj2 = hookMethodParam.thisObject;
            final View viewF = view;
            viewF.post(new Runnable() {
                @Override
                public final void run() {
                    ThemeHooks.a(obj2, viewF);
                }
            });
        } catch (Throwable th) {
            String strDecrypt = "Story share count scheduling failed";
            Object obj4 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
