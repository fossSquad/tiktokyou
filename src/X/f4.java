package X;

import com.bytedance.ies.ugc.aweme.commercialize.splash.core.SplashAdServiceImpl;
import com.bytedance.ies.ugc.aweme.commercialize.splash.show.NormalSplashAdActivity;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class f4 {
    public static void a() {
        if (!s2.a().d) {
            ArrayList arrayList = q2.a;
            return;
        }
        try {
            for (Method method : SplashAdServiceImpl.class.getDeclaredMethods()) {
                if (method.getReturnType() == Boolean.TYPE) {
                    XposedBridge.hookMethod(method, new c4());
                }
            }
            ArrayList arrayList2 = q2.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList3 = q2.a;
        }
        try {
            XposedBridge.hookAllMethods(NormalSplashAdActivity.class, "onCreate", new d4());
        } catch (Exception e2) {
            e2.getMessage();
            ArrayList arrayList4 = q2.a;
        }
        try {
            for (Method method2 : Class.forName("X.0ZeN").getDeclaredMethods()) {
                if (method2.getReturnType() == Boolean.TYPE) {
                    XposedBridge.hookMethod(method2, new e4());
                }
            }
            ArrayList arrayList5 = q2.a;
        } catch (Exception e3) {
            e3.getMessage();
            ArrayList arrayList6 = q2.a;
        }
    }
}
