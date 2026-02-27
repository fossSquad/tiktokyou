package X;

import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class s1 {
    public static void a() {
        if (!r0.a().d) {
            ArrayList arrayList = q0.a;
            return;
        }
        try {
            for (Method method : Class.forName("com.bytedance.ies.ugc.aweme.commercialize.splash.core.SplashAdServiceImpl").getDeclaredMethods()) {
                if (method.getReturnType() == Boolean.TYPE) {
                    XposedBridge.hookMethod(method, new p1());
                }
            }
            ArrayList arrayList2 = q0.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList3 = q0.a;
        }
        try {
            XposedBridge.hookAllMethods(Class.forName("com.bytedance.ies.ugc.aweme.commercialize.splash.show.NormalSplashAdActivity"), "onCreate", new q1());
        } catch (Exception e2) {
            e2.getMessage();
            ArrayList arrayList4 = q0.a;
        }
        try {
            for (Method method2 : Class.forName("X.0Wn1").getDeclaredMethods()) {
                if (method2.getReturnType() == Boolean.TYPE) {
                    XposedBridge.hookMethod(method2, new r1());
                }
            }
            ArrayList arrayList5 = q0.a;
        } catch (Exception e3) {
            e3.getMessage();
            ArrayList arrayList6 = q0.a;
        }
    }
}
