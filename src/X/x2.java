package X;

import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class x2 {
    public static void a() {
        if (!i1.a().d) {
            ArrayList arrayList = g1.a;
            return;
        }
        try {
            for (Method method : Class.forName("com.bytedance.ies.ugc.aweme.commercialize.splash.core.SplashAdServiceImpl").getDeclaredMethods()) {
                if (method.getReturnType() == Boolean.TYPE) {
                    XposedBridge.hookMethod(method, new u2());
                }
            }
            ArrayList arrayList2 = g1.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList3 = g1.a;
        }
        try {
            XposedBridge.hookAllMethods(Class.forName("com.bytedance.ies.ugc.aweme.commercialize.splash.show.NormalSplashAdActivity"), "onCreate", new v2());
        } catch (Exception e2) {
            e2.getMessage();
            ArrayList arrayList4 = g1.a;
        }
        try {
            for (Method method2 : Class.forName("X.0Wn1").getDeclaredMethods()) {
                if (method2.getReturnType() == Boolean.TYPE) {
                    XposedBridge.hookMethod(method2, new w2());
                }
            }
            ArrayList arrayList5 = g1.a;
        } catch (Exception e3) {
            e3.getMessage();
            ArrayList arrayList6 = g1.a;
        }
    }
}
