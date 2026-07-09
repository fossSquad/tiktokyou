package X;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.feed.platform.panel.speed.TabletPlaybackSpeedComponent;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class v9 {
    public static Class a = null;
    public static Method b = null;
    public static Method c = null;
    public static Field d = null;
    public static Field e = null;
    public static volatile float f = 1.0f;
    public static volatile long g = 0;
    public static volatile String h = null;
    public static volatile float i = 1.0f;
    public static volatile long j;
    public static final Handler k = new Handler(Looper.getMainLooper());
    public static final o9 l = new o9();

    public static void a() {
        try {
            t6 t6Var = z6.a;
            a = Class.forName("X.0RJj");
            t6 t6Var2 = z6.a;
            b = t6Var2.a(a, Float.TYPE, Aweme.class, String.class, String.class);
            c = z6.b.a(a, Aweme.class);
            d = z6.e.a(a);
            e = z6.f.a(a);
            HookBridge.hookAllMethods(a, t6Var2.c[0], new p9());
            q9 q9Var = new q9();
            for (String str : (String[]) z6.c.c.clone()) {
                HookBridge.hookAllMethods(a, str, q9Var);
            }
            HookBridge.hookAllMethods(a, z6.d.c[0], new r9());
            HookBridge.hookAllMethods(TabletPlaybackSpeedComponent.class, w7.a.c[0], new s9());
            a(a7.a, a7.b);
            a(g7.a, g7.b);
            int i2 = g5.a;
        } catch (Throwable th) {
            int i3 = g5.a;
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
                    int i2 = g5.a;
                }
                b(f);
            }
        }
    }

    public static void b(float f2) {
        try {
            if (a(f2)) {
                d.setBoolean(null, false);
                e.setFloat(null, 1.0f);
                int i2 = g5.a;
            } else {
                d.setBoolean(null, true);
                e.setFloat(null, f2);
                int i3 = g5.a;
            }
        } catch (Throwable th) {
            int i4 = g5.a;
        }
    }

    public static void a(Object obj, float f2) {
        o9 o9Var = l;
        o9Var.set(Boolean.TRUE);
        try {
            obj.getClass().getMethod("setSpeed", Float.TYPE).invoke(obj, Float.valueOf(f2));
            int i2 = g5.a;
            o9Var.set(Boolean.FALSE);
        } catch (Throwable th) {
            try {
                int i3 = g5.a;
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

    public static void a(o5 o5Var, t6 t6Var) {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = v9.class.getClassLoader();
            }
            Class<?> cls = Class.forName(o5Var.b, false, contextClassLoader);
            for (String str : (String[]) t6Var.c.clone()) {
                try {
                    HookBridge.hookAllMethods(cls, str, new t9(str));
                } catch (Throwable th) {
                }
            }
            int i2 = g5.a;
        } catch (Throwable th2) {
            th2.getMessage();
            int i3 = g5.a;
        }
    }
}
