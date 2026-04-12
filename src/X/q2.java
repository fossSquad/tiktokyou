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

public class q2 {
    public static final ArrayList a = new ArrayList();
    public static int b = 1775992556;
    public static Context c;
    public static AwemeHostApplication d;

    public static void a(AwemeHostApplication awemeHostApplication, Context context) {
        d = awemeHostApplication;
        c = context;
        AtomicBoolean atomicBoolean = z0.c;
        if (context != null) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (!(defaultUncaughtExceptionHandler instanceof z0) && z0.c.compareAndSet(false, true)) {
                Thread.setDefaultUncaughtExceptionHandler(new z0(context.getApplicationContext(), defaultUncaughtExceptionHandler));
            }
        }
        try {
            XposedBridge.init(context.getClassLoader(), context.getCacheDir() != null ? context.getCacheDir().getAbsolutePath() : null);
        } catch (Throwable th) {
        }
        c();
        b = 1775992556;
        s2.a(context);
        if (p2.c == null) {
            p2.c = new p2();
        }
        try {
            k0.a();
            a();
            try {
                a1 a1Var = new a1();
                XposedBridge.hookMethod(DeviceRegisterManager.class.getMethod("com_ss_android_deviceregister_DeviceRegisterManager_com_ss_android_ugc_aweme_feed_lancet_AppLogLancet_getDeviceId", null), a1Var);
                XposedBridge.hookMethod(DeviceRegisterManager.class.getMethod("com_ss_android_deviceregister_DeviceRegisterManager__getDeviceId$___twin___", null), a1Var);
            } catch (Throwable th2) {
                th2.getMessage();
            }
            y0.a();
            i3.a();
            o5.a();
            x1.a();
            w3.e();
            i1.a();
            x2.a();
            w0.a();
            try {
                Class<?> cls = Class.forName("X.0z6S");
                XposedBridge.hookAllMethods(cls, "LIZ", new l3(cls));
            } catch (Exception e) {
                e.getMessage();
            }
            z3.a();
            try {
                Method method = GoogleAuth.class.getMethod("isAvailable", null);
                Boolean bool = Boolean.FALSE;
                XposedBridge.hookMethod(method, XC_MethodReplacement.returnConstant(bool));
                XposedBridge.hookMethod(GoogleOneTapService.class.getMethod("LIZJ", String.class, WeakReference.class), XC_MethodReplacement.returnConstant(bool));
            } catch (Exception e2) {
            }
            f4.a();
            try {
                XposedBridge.hookAllMethods(InboxSkylightWidgetV2Injector.class, "enable", new j2());
            } catch (Exception e3) {
                e3.getMessage();
            }
            i2.a();
            o2.a();
            Handler handler = m.a;
            Context contextB = b();
            if (contextB != null) {
                m.b(contextB);
                if (s2.a().k) {
                    m.c(contextB);
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
            l5.b();
            b2.a();
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
                q2.e();
            }
        }, "cfg-sync").start();
    }

    public static  void d() {
        try {
            s2.a().getClass();
            Scanner scanner = new Scanner(new URL("http://tiktokyou.yzewe.ru/api/v1/version?first_time=".concat(s2.c() ? "1" : "0")).openStream(), "UTF-8");
            if (Long.parseLong(scanner.useDelimiter("\\A").next().trim().replaceAll("[^0-9]", "")) > b) {
                b4.j = true;
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
                q2.d();
            }
        }).start();
    }
}
