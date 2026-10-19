package Z;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.feed.platform.panel.speed.TabletPlaybackSpeedComponent;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class yd {
    public static Class a;
    public static Method b;
    public static Method c;
    public static Field d;
    public static Field e;
    public static volatile float f;
    public static volatile long g;
    public static volatile String h;
    public static volatile float i;
    public static volatile long j;
    public static final Handler k;
    public static final rd l;

    static {
        f = 1.0f;
        i = 1.0f;
        k = new Handler(Looper.getMainLooper());
        l = new rd();
    }

    public static void a() {
        try {
            v9 v9Var = ha.a;
            a = Class.forName("X.08HI");
            v9 v9Var2 = ha.a;
            b = v9Var2.a(a, Float.TYPE, Aweme.class, String.class, String.class);
            c = ha.b.a(a, Aweme.class);
            d = ha.e.a(a);
            e = ha.f.a(a);
            HookBridge.hookAllMethods(a, v9Var2.c[0], new sd());
            td tdVar = new td();
            for (String str : (String[]) ha.c.c.clone()) {
                HookBridge.hookAllMethods(a, str, tdVar);
            }
            HookBridge.hookAllMethods(a, ha.d.c[0], new ud());
            HookBridge.hookAllMethods(TabletPlaybackSpeedComponent.class, ob.a.c[0], new vd());
            a(ia.a, ia.b);
            a(ra.a, ra.b);
        } catch (Throwable th) {
            String strDecrypt = "Init failed";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void b(Aweme aweme) {
        String aid;
        if (aweme == null) {
            aid = null;
        } else {
            try {
                aid = aweme.getAid();
            } catch (Throwable th) {
                aid = null;
            }
        }
        String str = h;
        if (str != null) {
            if (aid == null || !str.equals(aid)) {
                if (h != null || j != 0) {
                    h = null;
                    i = 1.0f;
                    j = 0L;
                }
                float f2 = f;
                b(f2);
            }
        }
    }

    public static void b(float f2) {
        try {
            if (a(f2)) {
                d.setBoolean(null, false);
                e.setFloat(null, 1.0f);
            } else {
                d.setBoolean(null, true);
                e.setFloat(null, f2);
            }
        } catch (Throwable th) {
            String strDecrypt = "Native persist sync failed: %s";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(Object obj, float f2) {
        rd rdVar = l;
        rdVar.set(Boolean.TRUE);
        try {
            ia.c.a(obj.getClass(), Float.TYPE).invoke(obj, Float.valueOf(f2));
            rdVar.set(Boolean.FALSE);
        } catch (Throwable th) {
            try {
                String strDecrypt = "Controller apply failed";
                Object obj2 = g7.a;
                g7.a(6, String.valueOf(strDecrypt), th);
            } finally {
                l.set(Boolean.FALSE);
            }
        }
    }

    public static boolean a(Aweme aweme) {
        if (aweme == null) {
            return false;
        }
        try {
            Object objInvoke = c.invoke(null, aweme);
            return (objInvoke instanceof Boolean) && ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(float f2) {
        return Math.abs(f2 - 1.0f) < 0.001f;
    }

    public static boolean a(String str) {
        if ("swipe_up_lock_persist".equals(str)) {
            return true;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if ("com.ss.android.ugc.aweme.feed.longvideo.edgespeedup.EdgeSpeedupAssem".equals(stackTraceElement.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static void a(w7 w7Var, v9 v9Var) {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = yd.class.getClassLoader();
            }
            Class<?> cls = Class.forName(w7Var.b, false, contextClassLoader);
            for (String str : (String[]) v9Var.c.clone()) {
                try {
                    HookBridge.hookAllMethods(cls, str, new wd(str));
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
            String strDecrypt = "Controller skipped";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th2);
        }
    }
}
