package X;

import com.bytedance.ies.ugc.aweme.commercialize.splash.core.SplashAdServiceImpl;
import com.bytedance.ies.ugc.aweme.commercialize.splash.show.NormalSplashAdActivity;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;

public abstract class q5 {
    public static void a() {
        if (!y3.a().d) {
            int i = v3.a;
            return;
        }
        try {
            for (Method method : SplashAdServiceImpl.class.getDeclaredMethods()) {
                if (method.getReturnType() == Boolean.TYPE) {
                    HookBridge.hookMethod(method, new n5());
                }
            }
            int i2 = v3.a;
        } catch (Exception e) {
            e.getMessage();
            int i3 = v3.a;
        }
        try {
            HookBridge.hookAllMethods(NormalSplashAdActivity.class, "onCreate", new o5());
        } catch (Exception e2) {
            e2.getMessage();
            int i4 = v3.a;
        }
        try {
            for (Method method2 : Class.forName("X.0ZvJ").getDeclaredMethods()) {
                if (method2.getReturnType() == Boolean.TYPE) {
                    HookBridge.hookMethod(method2, new p5());
                }
            }
            int i5 = v3.a;
        } catch (Exception e3) {
            e3.getMessage();
            int i6 = v3.a;
        }
    }
}
