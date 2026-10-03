package Z;

import Z.a9;
import Z.b9;
import Z.ec;
import Z.fc;
import Z.gc;
import Z.h6;
import Z.hc;
import Z.ic;
import Z.k9;

import Z.dc;
import Z.p8;
import Z.w6;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.feed.platform.panel.speed.TabletPlaybackSpeedComponent;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class EdgeSpeedupHooks {
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
    public static final dc l;

    static {
        f = 1.0f;
        i = 1.0f;
        k = new Handler(Looper.getMainLooper());
        l = new dc();
    }

    public static void a() {
        try {
            p8 p8Var = a9.a;
            a = Class.forName("X.08Fw");
            p8 p8Var2 = a9.a;
            b = p8Var2.a(a, Float.TYPE, Aweme.class, String.class, String.class);
            c = a9.b.a(a, Aweme.class);
            d = a9.e.a(a);
            e = a9.f.a(a);
            HookBridge.hookAllMethods(a, p8Var2.c[0], new ec());
            fc fcVar = new fc();
            for (String str : (String[]) a9.c.c.clone()) {
                HookBridge.hookAllMethods(a, str, fcVar);
            }
            HookBridge.hookAllMethods(a, a9.d.c[0], new gc());
            HookBridge.hookAllMethods(TabletPlaybackSpeedComponent.class, ga.a.c[0], new hc());
            a(b9.a, b9.b);
            a(k9.a, k9.b);
        } catch (Throwable th) {
            String strDecrypt = "Init failed";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
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
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(Object obj, float f2) {
        dc dcVar = l;
        dcVar.set(Boolean.TRUE);
        try {
            obj.getClass().getMethod("setSpeed", Float.TYPE).invoke(obj, Float.valueOf(f2));
            dcVar.set(Boolean.FALSE);
        } catch (Throwable th) {
            try {
                String strDecrypt = "Controller apply failed";
                Object obj2 = h6.a;
                h6.a(6, String.valueOf(strDecrypt), th);
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

    public static void a(w6 w6Var, p8 p8Var) {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = EdgeSpeedupHooks.class.getClassLoader();
            }
            Class<?> cls = Class.forName(w6Var.b, false, contextClassLoader);
            for (String str : (String[]) p8Var.c.clone()) {
                try {
                    HookBridge.hookAllMethods(cls, str, new ic(str));
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
            String strDecrypt = "Controller skipped";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th2);
        }
    }
}
