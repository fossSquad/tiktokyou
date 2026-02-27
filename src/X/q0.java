package X;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.util.TypedValue;
import com.bytedance.lobby.google.GoogleAuth;
import com.bytedance.lobby.google.GoogleOneTapAuth;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.ugc.aweme.app.host.AwemeHostApplication;
import com.ss.android.ugc.aweme.main.MainActivity;
import com.ss.android.ugc.aweme.utils.CommonUtils;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class q0 {
    public static final ArrayList a = new ArrayList();
    public static int b = 0;
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
                q0.e();
            }
        }, "cfg-sync").start();
    }

    public static  void d() {
        try {
            Scanner scanner = new Scanner(new URL("http://tiktokyou.yzewe.ru/api/v1/version").openStream(), "UTF-8");
            if (Long.parseLong(scanner.useDelimiter("\\A").next().trim().replaceAll("[^0-9]", "")) > b) {
                o1.h = true;
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
        try {
            b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            b = 0;
        }
        if (r0.k == null) {
            r0.k = context.getSharedPreferences("ttmod_settings", 0);
        }
        if (r0.l == null) {
            r0.l = new r0();
        }
        if (p0.c == null) {
            p0.c = new p0();
        }
        try {
            a();
            XposedBridge.hookAllMethods(MainActivity.class, "onCreate", new c3());
            o.a();
            h1.a();
            b3.a();
            e0.a();
            w.a();
            w0.a();
            m.a();
            try {
                Class<?> cls = Class.forName("X.0tTE");
                XposedBridge.hookAllMethods(cls, "LIZ", new i1(cls));
            } catch (Exception e2) {
                e2.getMessage();
            }
            m1.a();
            Method method = GoogleAuth.class.getMethod("isAvailable", null);
            Boolean bool = Boolean.FALSE;
            XposedBridge.hookMethod(method, XC_MethodReplacement.returnConstant(bool));
            XposedBridge.hookMethod(GoogleOneTapAuth.class.getMethod("isAvailable", null), XC_MethodReplacement.returnConstant(bool));
            s1.a();
            try {
                XposedBridge.hookMethod(DeviceRegisterManager.class.getMethod("getDeviceId", null), new p());
            } catch (Throwable th2) {
                th2.getMessage();
            }
            try {
                XposedBridge.hookAllMethods(Class.forName("com.ss.android.ugc.aweme.inbox.skylight.InboxSkylightWidgetV2Injector"), "enable", new n0());
            } catch (Exception e3) {
                e3.getMessage();
            }
            m0.a();
            y2.b();
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
                q0.d();
            }
        }).start();
    }
}
