package X;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.feed.platform.panel.speed.TabletPlaybackSpeedComponent;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class y7 {
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
    public static final r7 l = new r7();

    public static void a() {
        try {
            x5 x5Var = y5.a;
            a = Class.forName("X.0L4K");
            x5 x5Var2 = y5.a;
            b = x5Var2.a(a, Float.TYPE, Aweme.class, String.class, String.class);
            c = y5.b.a(a, Aweme.class);
            d = y5.e.a(a);
            e = y5.f.a(a);
            HookBridge.hookAllMethods(a, x5Var2.c[0], new s7());
            t7 t7Var = new t7();
            for (String str : (String[]) y5.c.c.clone()) {
                HookBridge.hookAllMethods(a, str, t7Var);
            }
            HookBridge.hookAllMethods(a, y5.d.c[0], new u7());
            HookBridge.hookAllMethods(TabletPlaybackSpeedComponent.class, t6.a.c[0], new v7());
            a(z5.a, z5.b);
            a(f6.a, f6.b);
            int i2 = p4.a;
        } catch (Throwable th) {
            int i3 = p4.a;
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
                    int i2 = p4.a;
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
                int i2 = p4.a;
            } else {
                d.setBoolean(null, true);
                e.setFloat(null, f2);
                int i3 = p4.a;
            }
        } catch (Throwable th) {
            int i4 = p4.a;
        }
    }

    public static void a(Object obj, float f2) {
        r7 r7Var = l;
        r7Var.set(Boolean.TRUE);
        try {
            obj.getClass().getMethod("setSpeed", Float.TYPE).invoke(obj, Float.valueOf(f2));
            int i2 = p4.a;
            r7Var.set(Boolean.FALSE);
        } catch (Throwable th) {
            try {
                int i3 = p4.a;
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

    public static void a(x4 x4Var, x5 x5Var) {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = y7.class.getClassLoader();
            }
            Class<?> cls = Class.forName(x4Var.b, false, contextClassLoader);
            for (String str : (String[]) x5Var.c.clone()) {
                try {
                    HookBridge.hookAllMethods(cls, str, new w7(str));
                } catch (Throwable th) {
                }
            }
            int i2 = p4.a;
        } catch (Throwable th2) {
            th2.getMessage();
            int i3 = p4.a;
        }
    }
}
