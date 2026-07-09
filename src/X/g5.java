package X;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.util.TypedValue;
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

public class g5 {
    public static int a;
    public static Context b;
    public static AwemeHostApplication c;

    static {
        new ArrayList();
        a = 1783614085;
    }

    public static int a(float f) {
        return (int) TypedValue.applyDimension(1, f, c().getResources().getDisplayMetrics());
    }

    public static void b() {
        try {
            HookBridge.disableHiddenApiRestrictions();
            wb.d();
        } catch (Throwable th) {
        }
    }

    public static Context c() {
        Context context = b;
        return context != null ? context : c.getApplicationContext();
    }

    public static  void d() {
        try {
            l8.a().getClass();
            Scanner scanner = new Scanner(new URL("https://tiktokyou.yzewe.ru/api/v1/version?first_time=".concat(l8.c() ? "1" : "0")).openStream(), "UTF-8");
            if (Long.parseLong(scanner.useDelimiter("\\A").next().trim().replaceAll("[^0-9]", "")) > a) {
                vb.r = true;
                od.a();
            }
            scanner.close();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void a(AwemeHostApplication awemeHostApplication, final Context context) {
        ComponentName componentName;
        c = awemeHostApplication;
        b = context;
        i2.a((ContextWrapper) awemeHostApplication);
        i2.a((Context) awemeHostApplication);
        try {
        } catch (Throwable th) {
        }
        CommonUtils.init(context);
        try {
            HookBridge.disableHiddenApiRestrictions();
            wb.f();
        } catch (Throwable th2) {
        }
        a = 1783614085;
        l8.a(context);
        if (f5.c == null) {
            f5.c = new f5();
        }
        int i = ac.a;
        try {
            ArrayList arrayListA = e5.a(context);
            if (!arrayListA.isEmpty()) {
                String strA = e5.a();
                int size = arrayListA.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        componentName = null;
                        break;
                    }
                    Object obj = arrayListA.get(i2);
                    i2++;
                    d5 d5Var = (d5) obj;
                    if (d5Var.a.equals(strA)) {
                        componentName = d5Var.b;
                        break;
                    }
                }
                if (componentName == null) {
                    strA = "default";
                    int size2 = arrayListA.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        Object obj2 = arrayListA.get(i3);
                        i3++;
                        d5 d5Var2 = (d5) obj2;
                        if (d5Var2.a.equals("default")) {
                            componentName = d5Var2.b;
                            break;
                        }
                    }
                }
                if (componentName != null && context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                    e5.a(context, strA);
                }
            }
        } catch (Throwable th3) {
            th3.getMessage();
        }
        try {
            x.a();
            nd.b();
            h5.a();
            d1.d();
            aa.b();
            d2.a();
            a();
            ConcurrentHashMap concurrentHashMap = d3.a;
            f2.a();
            va.a();
            i4.d();
            v9.a();
            kb.e();
            h3.b();
            n9.c();
            y1.a();
            try {
                t6 t6Var = h7.a;
                HookBridge.hookAllMethods(Class.forName("X.0llu"), h7.a.c[0], new za());
            } catch (Exception e) {
                e.getMessage();
            }
            nb.a();
            z8.a();
            try {
                Method method = GoogleAuth.class.getMethod("isAvailable", null);
                Boolean bool = Boolean.FALSE;
                HookBridge.hookMethod(method, ReplaceMethod.returnConstant(bool));
                HookBridge.hookMethod(m6.a.a(GoogleOneTapService.class, String.class, WeakReference.class), ReplaceMethod.returnConstant(bool));
            } catch (Exception e2) {
            }
            try {
                HookBridge.hookAllMethods(InboxSkylightWidgetV2Injector.class, "enable", new z4());
            } catch (Exception e3) {
                e3.getMessage();
            }
            x4.a();
            Handler handler = z.a;
            Context contextC = c();
            if (contextC != null) {
                z.b(contextC);
                if (l8.a().n) {
                    z.c(contextC);
                    if (z.b.compareAndSet(false, true)) {
                        Handler handler2 = z.a;
                        y yVar = z.e;
                        handler2.removeCallbacks(yVar);
                        handler2.postDelayed(yVar, 300000L);
                    }
                    z.c(contextC, "init");
                } else {
                    z.a(contextC);
                    z.b.set(false);
                    z.a.removeCallbacks(z.e);
                }
            }
            hd.b();
            q4.a();
            n1.a();
            ga.a();
        } catch (Exception e4) {
            e4.toString();
        }
        wb.a(new Runnable() {
            @Override
            public final void run() {
                CommonUtils.verifySignatureNative(context);
            }
        });
    }

    public static void a() {
        new Thread(new Runnable() {
            @Override
            public final void run() {
                g5.d();
            }
        }).start();
    }
}
