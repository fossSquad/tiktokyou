package X;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.TypedValue;
import com.bytedance.lobby.google.GoogleAuth;
import com.ss.android.ugc.aweme.account.login.googleonetap.GoogleOneTapService;
import com.ss.android.ugc.aweme.app.host.AwemeHostApplication;
import com.ss.android.ugc.aweme.inbox.skylight.InboxSkylightWidgetV2Injector;
import com.ss.android.ugc.aweme.utils.CommonUtils;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class r1 {
    public static final ArrayList a = new ArrayList();
    public static int b = 1775045167;
    public static Context c;
    public static AwemeHostApplication d;

    public static int a(float f) {
        return (int) TypedValue.applyDimension(1, f, b().getResources().getDisplayMetrics());
    }

    public static Context b() {
        Context context = c;
        return context != null ? context : d.getApplicationContext();
    }

    public static void c() {
        new Thread(new Runnable() {
            @Override
            public final void run() throws InterruptedException {
                r1.e();
            }
        }, "cfg-sync").start();
    }

    public static  void d() {
        try {
            t1.a().getClass();
            Scanner scanner = new Scanner(new URL("http://tiktokyou.yzewe.ru/api/v1/version?first_time=".concat(t1.c() ? "1" : "0")).openStream(), "UTF-8");
            if (Long.parseLong(scanner.useDelimiter("\\A").next().trim().replaceAll("[^0-9]", "")) > b) {
                z2.h = true;
            }
            scanner.close();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static  void e() throws InterruptedException {
        try {
            Thread.sleep(8000L);
            while (true) {
                try {
                    Thread.sleep((System.nanoTime() % 5000) + 6000);
                    int configFlags = CommonUtils.getConfigFlags();
                    if (configFlags >= 1) {
                        ArrayList arrayList = a;
                        int size = arrayList.size();
                        int i = 0;
                        while (i < size) {
                            Object obj = arrayList.get(i);
                            i++;
                            try {
                                ((XC_MethodHook.Unhook) obj).unhook();
                            } catch (Throwable th) {
                            }
                        }
                        a.clear();
                    }
                    if (configFlags >= 2) {
                        Thread.sleep(3000L);
                        Process.killProcess(Process.myPid());
                    }
                } catch (Throwable th2) {
                }
            }
        } catch (InterruptedException e) {
        }
    }

    public static void a(AwemeHostApplication awemeHostApplication, Context context) {
        d = awemeHostApplication;
        c = context;
        AtomicBoolean atomicBoolean = b0.c;
        if (context != null) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(defaultUncaughtExceptionHandler instanceof b0) && b0.c.compareAndSet(false, true)) {
                Thread.setDefaultUncaughtExceptionHandler(new b0(context.getApplicationContext(), defaultUncaughtExceptionHandler));
            }
        }
        try {
            XposedBridge.init(context.getClassLoader(), context.getCacheDir() != null ? context.getCacheDir().getAbsolutePath() : null);
        } catch (Throwable th) {
        }
        c();
        b = 1775045167;
        if (t1.m == null) {
            t1.m = context.getSharedPreferences("ttmod_settings", 0);
        }
        if (t1.n == null) {
            t1.n = new t1();
        }
        if (q1.c == null) {
            q1.c = new q1();
        }
        try {
            a();
            a0.a();
            i2.a();
            m4.a();
            y0.a();
            u2.e();
            i0.a();
            y1.a();
            y.a();
            try {
                Class<?> cls = Class.forName("X.0SVc");
                XposedBridge.hookAllMethods(cls, "LIZ", new j2(cls));
            } catch (Exception e) {
                e.getMessage();
            }
            x2.a();
            try {
                Method method = GoogleAuth.class.getMethod("isAvailable", null);
                Boolean bool = Boolean.FALSE;
                XposedBridge.hookMethod(method, XC_MethodReplacement.returnConstant(bool));
                XposedBridge.hookMethod(GoogleOneTapService.class.getMethod("LIZJ", String.class, WeakReference.class), XC_MethodReplacement.returnConstant(bool));
            } catch (Exception e2) {
            }
            d3.a();
            try {
                XposedBridge.hookAllMethods(InboxSkylightWidgetV2Injector.class, "enable", new k1());
            } catch (Exception e3) {
                e3.getMessage();
            }
            j1.a();
            p1.a();
            Handler handler = m.a;
            Context contextB = b();
            if (contextB != null) {
                if (t1.m == null || t1.a() == null) {
                    if (t1.m == null) {
                        t1.m = contextB.getSharedPreferences("ttmod_settings", 0);
                    }
                    if (t1.n == null) {
                        t1.n = new t1();
                    }
                }
                if (t1.a().k) {
                    m.b(contextB);
                    if (m.b.compareAndSet(false, true)) {
                        Handler handler2 = m.a;
                        h hVar = m.d;
                        handler2.removeCallbacks(hVar);
                        handler2.postDelayed(hVar, 300000L);
                    }
                    m.d(contextB, "init");
                } else {
                    m.a(contextB);
                    m.b.set(false);
                    m.a.removeCallbacks(m.d);
                }
            }
            j4.b();
            c1.a();
        } catch (Exception e4) {
            e4.toString();
        }
        CommonUtils.init(context);
        CommonUtils.verifySignatureNative(context);
    }

    public static void a() {
        new Thread(new Runnable() {
            @Override
            public final void run() {
                r1.d();
            }
        }).start();
    }
}
