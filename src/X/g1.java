package X;

import android.content.Context;
import android.os.Process;
import android.util.TypedValue;
import com.bytedance.lobby.google.GoogleAuth;
import com.bytedance.lobby.google.GoogleOneTapAuth;
import com.ss.android.ugc.aweme.app.host.AwemeHostApplication;
import com.ss.android.ugc.aweme.utils.CommonUtils;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class g1 {
    public static final ArrayList a = new ArrayList();
    public static int b = 1773169259;
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
                g1.e();
            }
        }, "cfg-sync").start();
    }

    public static  void d() {
        try {
            i1.a().getClass();
            Scanner scanner = new Scanner(new URL("http://tiktokyou.yzewe.ru/api/v1/version?first_time=".concat(i1.c() ? "1" : "0")).openStream(), "UTF-8");
            if (Long.parseLong(scanner.useDelimiter("\\A").next().trim().replaceAll("[^0-9]", "")) > b) {
                t2.h = true;
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
        try {
            XposedBridge.init(context.getClassLoader(), context.getCacheDir() != null ? context.getCacheDir().getAbsolutePath() : null);
        } catch (Throwable th) {
        }
        c();
        b = 1773169259;
        if (i1.l == null) {
            i1.l = context.getSharedPreferences("ttmod_settings", 0);
        }
        if (i1.m == null) {
            i1.m = new i1();
        }
        if (f1.c == null) {
            f1.c = new f1();
        }
        try {
            a();
            s.a();
            m2.a();
            g4.a();
            k0.a();
            y.a();
            n1.a();
            q.a();
            try {
                Class<?> cls = Class.forName("X.0tTE");
                XposedBridge.hookAllMethods(cls, "LIZ", new n2(cls));
            } catch (Exception e) {
                e.getMessage();
            }
            r2.a();
            Method method = GoogleAuth.class.getMethod("isAvailable", null);
            Boolean bool = Boolean.FALSE;
            XposedBridge.hookMethod(method, XC_MethodReplacement.returnConstant(bool));
            XposedBridge.hookMethod(GoogleOneTapAuth.class.getMethod("isAvailable", null), XC_MethodReplacement.returnConstant(bool));
            x2.a();
            try {
                XposedBridge.hookAllMethods(Class.forName("com.ss.android.ugc.aweme.inbox.skylight.InboxSkylightWidgetV2Injector"), "enable", new x0());
            } catch (Exception e2) {
                e2.getMessage();
            }
            w0.a();
            e1.a();
            d4.b();
            try {
                XposedBridge.hookMethod(Class.forName("android.app.ApplicationPackageManager").getMethod("getPackageInfo", String.class, Integer.TYPE), new z0());
            } catch (Exception e3) {
                e3.getMessage();
            }
            p0.a();
        } catch (Exception e4) {
            e4.toString();
        }
        CommonUtils.init(context);
        a1.a = true;
        CommonUtils.verifySignatureNative(context);
        a1.a = false;
    }

    public static void a() {
        new Thread(new Runnable() {
            @Override
            public final void run() {
                g1.d();
            }
        }).start();
    }
}
