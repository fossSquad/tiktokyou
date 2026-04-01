package X;

import com.bytedance.ies.ugc.aweme.commercialize.splash.core.SplashAdServiceImpl;
import com.bytedance.ies.ugc.aweme.commercialize.splash.show.NormalSplashAdActivity;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class d3 {
    public static void a() {
        if (!t1.a().d) {
            ArrayList arrayList = r1.a;
            return;
        }
        try {
            for (Method method : SplashAdServiceImpl.class.getDeclaredMethods()) {
                if (method.getReturnType() == Boolean.TYPE) {
                    XposedBridge.hookMethod(method, new a3());
                }
            }
            ArrayList arrayList2 = r1.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList3 = r1.a;
        }
        try {
            XposedBridge.hookAllMethods(NormalSplashAdActivity.class, "onCreate", new b3());
        } catch (Exception e2) {
            e2.getMessage();
            ArrayList arrayList4 = r1.a;
        }
        try {
            for (Method method2 : Class.forName("X.0bOI").getDeclaredMethods()) {
                if (method2.getReturnType() == Boolean.TYPE) {
                    XposedBridge.hookMethod(method2, new c3());
                }
            }
            ArrayList arrayList5 = r1.a;
        } catch (Exception e3) {
            e3.getMessage();
            ArrayList arrayList6 = r1.a;
        }
    }
}
