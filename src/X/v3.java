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

public class v3 {
    public static int a;
    public static Context b;
    public static AwemeHostApplication c;

    static {
        new ArrayList();
        a = 1778750405;
    }

    public static void a(AwemeHostApplication awemeHostApplication, final Context context) {
        c = awemeHostApplication;
        b = context;
        m1.a((ContextWrapper) awemeHostApplication);
        m1.a((Context) awemeHostApplication);
        try {
        } catch (Throwable th) {
        }
        CommonUtils.init(context);
        try {
            HookBridge.disableHiddenApiRestrictions();
            m5.e();
        } catch (Throwable th2) {
        }
        a = 1778750405;
        y3.a(context);
        if (u3.c == null) {
            u3.c = new u3();
        }
        int i = r5.a;
        try {
            w3.a();
            t0.d();
            a();
            try {
                h2.a();
            } catch (Throwable th3) {
                th3.getMessage();
            }
            j1.a();
            s4.a();
            a7.a();
            g3.c();
            g5.e();
            o2.a();
            d4.a();
            h1.a();
            try {
                HookBridge.hookAllMethods(Class.forName("X.15dF"), "LIZ", new v4());
            } catch (Exception e) {
                e.getMessage();
            }
            j5.a();
            try {
                Method method = GoogleAuth.class.getMethod("isAvailable", null);
                Boolean bool = Boolean.FALSE;
                HookBridge.hookMethod(method, ReplaceMethod.returnConstant(bool));
                HookBridge.hookMethod(GoogleOneTapService.class.getMethod("LIZJ", String.class, WeakReference.class), ReplaceMethod.returnConstant(bool));
            } catch (Exception e2) {
            }
            q5.a();
            try {
                HookBridge.hookAllMethods(InboxSkylightWidgetV2Injector.class, "enable", new s3());
            } catch (Exception e3) {
                e3.getMessage();
            }
            r3.a();
            Handler handler = m.a;
            Context contextC = c();
            if (contextC != null) {
                m.b(contextC);
                if (y3.a().k) {
                    m.c(contextC);
                    if (m.b.compareAndSet(false, true)) {
                        Handler handler2 = m.a;
                        h hVar = m.d;
                        handler2.removeCallbacks(hVar);
                        handler2.postDelayed(hVar, 300000L);
                    }
                    m.d(contextC, "init");
                } else {
                    m.a(contextC);
                    m.b.set(false);
                    m.a.removeCallbacks(m.d);
                }
            }
            x6.b();
            k3.a();
            x0.a();
        } catch (Exception e4) {
            e4.toString();
        }
        m5.a(new Runnable() {
            @Override
            public final void run() {
                CommonUtils.verifySignatureNative(context);
            }
        });
    }

    public static void b() {
        try {
            HookBridge.disableHiddenApiRestrictions();
            m5.c();
        } catch (Throwable th) {
        }
    }

    public static Context c() {
        Context context = b;
        return context != null ? context : c.getApplicationContext();
    }

    public static  void d() {
        try {
            y3.a().getClass();
            Scanner scanner = new Scanner(new URL("http://tiktokyou.yzewe.ru/api/v1/version?first_time=".concat(y3.c() ? "1" : "0")).openStream(), "UTF-8");
            if (Long.parseLong(scanner.useDelimiter("\\A").next().trim().replaceAll("[^0-9]", "")) > a) {
                l5.j = true;
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
                v3.d();
            }
        }).start();
    }
}
