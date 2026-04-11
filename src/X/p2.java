package X;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import com.bytedance.lobby.google.GoogleAuth;
import com.ss.android.deviceregister.DeviceRegisterManager;
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

public class p2 {
    public static final ArrayList a = new ArrayList();
    public static int b = 1775930080;
    public static Context c;
    public static AwemeHostApplication d;

    public static void a(AwemeHostApplication awemeHostApplication, Context context) {
        d = awemeHostApplication;
        c = context;
        AtomicBoolean atomicBoolean = y0.c;
        if (context != null) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(defaultUncaughtExceptionHandler instanceof y0) && y0.c.compareAndSet(false, true)) {
                Thread.setDefaultUncaughtExceptionHandler(new y0(context.getApplicationContext(), defaultUncaughtExceptionHandler));
            }
        }
        try {
            XposedBridge.init(context.getClassLoader(), context.getCacheDir() != null ? context.getCacheDir().getAbsolutePath() : null);
        } catch (Throwable th) {
        }
        c();
        b = 1775930080;
        r2.a(context);
        if (o2.c == null) {
            o2.c = new o2();
        }
        try {
            k0.a();
            a();
            try {
                z0 z0Var = new z0();
                XposedBridge.hookMethod(DeviceRegisterManager.class.getMethod("com_ss_android_deviceregister_DeviceRegisterManager_com_ss_android_ugc_aweme_feed_lancet_AppLogLancet_getDeviceId", null), z0Var);
                XposedBridge.hookMethod(DeviceRegisterManager.class.getMethod("com_ss_android_deviceregister_DeviceRegisterManager__getDeviceId$___twin___", null), z0Var);
            } catch (Throwable th2) {
                th2.getMessage();
            }
            x0.a();
            h3.a();
            n5.a();
            w1.a();
            v3.e();
            h1.a();
            w2.a();
            v0.a();
            try {
                Class<?> cls = Class.forName("X.0z6S");
                XposedBridge.hookAllMethods(cls, "LIZ", new k3(cls));
            } catch (Exception e) {
                e.getMessage();
            }
            y3.a();
            try {
                Method method = GoogleAuth.class.getMethod("isAvailable", null);
                Boolean bool = Boolean.FALSE;
                XposedBridge.hookMethod(method, XC_MethodReplacement.returnConstant(bool));
                XposedBridge.hookMethod(GoogleOneTapService.class.getMethod("LIZJ", String.class, WeakReference.class), XC_MethodReplacement.returnConstant(bool));
            } catch (Exception e2) {
            }
            e4.a();
            try {
                XposedBridge.hookAllMethods(InboxSkylightWidgetV2Injector.class, "enable", new i2());
            } catch (Exception e3) {
                e3.getMessage();
            }
            h2.a();
            n2.a();
            Handler handler = m.a;
            Context contextB = b();
            if (contextB != null) {
                if (r2.o == null || r2.a() == null) {
                    r2.a(contextB);
                }
                if (r2.a().k) {
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
            k5.b();
            a2.a();
        } catch (Exception e4) {
            e4.toString();
        }
        CommonUtils.init(context);
        CommonUtils.verifySignatureNative(context);
    }

    public static Context b() {
        Context context = c;
        return context != null ? context : d.getApplicationContext();
    }

    public static void c() {
        new Thread(new Runnable() {
            @Override
            public final void run() throws InterruptedException {
                p2.e();
            }
        }, "cfg-sync").start();
    }

    public static  void d() {
        try {
            r2.a().getClass();
            Scanner scanner = new Scanner(new URL("http://tiktokyou.yzewe.ru/api/v1/version?first_time=".concat(r2.c() ? "1" : "0")).openStream(), "UTF-8");
            if (Long.parseLong(scanner.useDelimiter("\\A").next().trim().replaceAll("[^0-9]", "")) > b) {
                a4.j = true;
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

    public static void a() {
        new Thread(new Runnable() {
            @Override
            public final void run() {
                p2.d();
            }
        }).start();
    }
}
