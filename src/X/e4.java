package X;

import com.bytedance.ies.ugc.aweme.commercialize.splash.core.SplashAdServiceImpl;
import com.bytedance.ies.ugc.aweme.commercialize.splash.show.NormalSplashAdActivity;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class e4 {
    public static void a() {
        if (!r2.a().d) {
            ArrayList arrayList = p2.a;
            return;
        }
        try {
            for (Method method : SplashAdServiceImpl.class.getDeclaredMethods()) {
                if (method.getReturnType() == Boolean.TYPE) {
                    XposedBridge.hookMethod(method, new b4());
                }
            }
            ArrayList arrayList2 = p2.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList3 = p2.a;
        }
        try {
            XposedBridge.hookAllMethods(NormalSplashAdActivity.class, "onCreate", new c4());
        } catch (Exception e2) {
            e2.getMessage();
            ArrayList arrayList4 = p2.a;
        }
        try {
            for (Method method2 : Class.forName("X.0ZeN").getDeclaredMethods()) {
                if (method2.getReturnType() == Boolean.TYPE) {
                    XposedBridge.hookMethod(method2, new d4());
                }
            }
            ArrayList arrayList5 = p2.a;
        } catch (Exception e3) {
            e3.getMessage();
            ArrayList arrayList6 = p2.a;
        }
    }
}
