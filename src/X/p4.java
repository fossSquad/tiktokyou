package X;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import com.bytedance.lobby.google.GoogleAuth;
import com.ss.android.ugc.aweme.account.login.googleonetap.GoogleOneTapService;
import com.ss.android.ugc.aweme.app.host.AwemeHostApplication;
import com.ss.android.ugc.aweme.inbox.skylight.InboxSkylightWidgetV2Injector;
import com.ss.android.ugc.aweme.utils.CommonUtils;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class p4 {
    public static int a;
    public static Context b;
    public static AwemeHostApplication c;

    static {
        new ArrayList();
        a = 1781113276;
    }

    public static void a(AwemeHostApplication awemeHostApplication, final Context context) {
        c = awemeHostApplication;
        b = context;
        a2.a((ContextWrapper) awemeHostApplication);
        a2.a((Context) awemeHostApplication);
        try {
        } catch (Throwable th) {
        }
        CommonUtils.init(context);
        try {
            HookBridge.disableHiddenApiRestrictions();
            r9.f();
        } catch (Throwable th2) {
        }
        a = 1781113276;
        d7.a(context);
        if (o4.c == null) {
            o4.c = new o4();
        }
        int i = v9.a;
        try {
            w.a();
            ib.b();
            q4.a();
            a1.d();
            a();
            ConcurrentHashMap concurrentHashMap = v2.a;
            x1.a();
            u8.a();
            z3.c();
            y7.a();
            j9.e();
            z2.b();
            q7.b();
            v1.a();
            try {
                x5 x5Var = g6.a;
                HookBridge.hookAllMethods(Class.forName("X.0Wji"), g6.a.c[0], new y8());
            } catch (Exception e) {
                e.getMessage();
            }
            m9.a();
            try {
                Method method = GoogleAuth.class.getMethod("isAvailable", null);
                Boolean bool = Boolean.FALSE;
                HookBridge.hookMethod(method, ReplaceMethod.returnConstant(bool));
                HookBridge.hookMethod(r5.a.a(GoogleOneTapService.class, String.class, WeakReference.class), ReplaceMethod.returnConstant(bool));
            } catch (Exception e2) {
            }
            try {
                HookBridge.hookAllMethods(InboxSkylightWidgetV2Injector.class, "enable", new l4());
            } catch (Exception e3) {
                e3.getMessage();
            }
            k4.a();
            Handler handler = y.a;
            Context contextC = c();
            if (contextC != null) {
                y.b(contextC);
                if (d7.a().m) {
                    y.c(contextC);
                    if (y.b.compareAndSet(false, true)) {
                        Handler handler2 = y.a;
                        x xVar = y.e;
                        handler2.removeCallbacks(xVar);
                        handler2.postDelayed(xVar, 300000L);
                    }
                    y.c(contextC, "init");
                } else {
                    y.a(contextC);
                    y.b.set(false);
                    y.a.removeCallbacks(y.e);
                }
            }
            cb.b();
            d4.a();
            k1.a();
            f8.a();
        } catch (Exception e4) {
            e4.toString();
        }
        r9.a(new Runnable() {
            @Override
            public final void run() {
                CommonUtils.verifySignatureNative(context);
            }
        });
    }

    public static void b() {
        try {
            HookBridge.disableHiddenApiRestrictions();
            r9.d();
        } catch (Throwable th) {
        }
    }

    public static Context c() {
        Context context = b;
        return context != null ? context : c.getApplicationContext();
    }

    public static  void d() {
        try {
            d7.a().getClass();
            Scanner scanner = new Scanner(new URL("https://tiktokyou.yzewe.ru/api/v1/version?first_time=".concat(d7.c() ? "1" : "0")).openStream(), "UTF-8");
            if (Long.parseLong(scanner.useDelimiter("\\A").next().trim().replaceAll("[^0-9]", "")) > a) {
                q9.l = true;
            }
            scanner.close();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void a() {
        new Thread(new Runnable() {
            @Override
            public final void run() {
                p4.d();
            }
        }).start();
    }
}
