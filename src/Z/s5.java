package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.BaseFeedPageParams;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class s5 {
    public static final Map a;
    public static Field b;
    public static Field c;

    static {
        a = Collections.synchronizedMap(new WeakHashMap());
    }

    public static void a() {
        try {
            w7 w7Var = y8.a;
            Class<?> cls = Class.forName("X.07mj");
            b = y8.c.a(cls);
            c = y8.d.a(cls);
        } catch (Throwable th) {
            String strDecrypt = "FeedPagerHooks field lookup failed";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
        a(y8.a);
        a(z8.a);
        a(y8.b, true);
        a(c9.a, false);
        a(d9.a, false);
        b(c9.b, false);
        b(d9.b, false);
        b(c9.c, false);
        b(d9.c, false);
        b(b9.a);
        b(b9.b);
        b(a9.a);
        b(a9.b);
        a(b9.c);
        a(a9.c);
        b(b9.d, true);
        b(b9.e, true);
        b(a9.d, true);
        b(a9.e, true);
    }

    public static void b(v9 v9Var) {
        try {
            HookBridge.hookMethod(v9Var.a(Class.forName(v9Var.a.b), List.class), new p5());
            String str = "FeedPagerHooks hooked " + v9Var;
            Object obj = g7.a;
            g7.a(4, String.valueOf(str), (Throwable) null);
        } catch (Throwable th) {
            String str2 = "FeedPagerHooks bulk hook failed for " + v9Var;
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(str2), th);
        }
    }

    public static void b(v9 v9Var, boolean z) {
        try {
            HookBridge.hookMethod(v9Var.a(Class.forName(v9Var.a.b), Integer.TYPE, Aweme.class), new r5(z));
            String str = "FeedPagerHooks hooked " + v9Var;
            Object obj = g7.a;
            g7.a(4, String.valueOf(str), (Throwable) null);
        } catch (Throwable th) {
            String str2 = "FeedPagerHooks item hook failed for " + v9Var;
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(str2), th);
        }
    }

    public static void a(v9 v9Var, boolean z) {
        try {
            HookBridge.hookMethod(v9Var.a(Class.forName(v9Var.a.b), List.class), new o5(z));
            String str = "FeedPagerHooks hooked " + v9Var;
            Object obj = g7.a;
            g7.a(4, String.valueOf(str), (Throwable) null);
        } catch (Throwable th) {
            String str2 = "FeedPagerHooks bulk hook failed for " + v9Var;
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(str2), th);
        }
    }

    public static void b(Object obj) {
        Field field;
        if (obj == null || (field = c) == null) {
            return;
        }
        try {
            Object obj2 = field.get(obj);
            if (obj2 == null) {
                return;
            }
            a.put(obj2, Boolean.valueOf(a(obj)));
        } catch (Throwable th) {
            String strDecrypt = "FeedPagerHooks remember adapter failed";
            Object obj3 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(v9 v9Var) {
        try {
            HookBridge.hookMethod(v9Var.a(Class.forName(v9Var.a.b), Integer.TYPE, List.class), new q5());
            String str = "FeedPagerHooks hooked " + v9Var;
            Object obj = g7.a;
            g7.a(4, String.valueOf(str), (Throwable) null);
        } catch (Throwable th) {
            String str2 = "FeedPagerHooks bulk hook failed for " + v9Var;
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(str2), th);
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        if ("X.07ob".equals(obj.getClass().getName())) {
            return true;
        }
        Field field = b;
        if (field == null) {
            return false;
        }
        try {
            Object obj2 = field.get(obj);
            String eventType = null;
            if (obj2 != null) {
                if (obj2 instanceof BaseFeedPageParams) {
                    eventType = ((BaseFeedPageParams) obj2).getEventType();
                } else {
                    try {
                        Object objInvoke = obj2.getClass().getMethod("getEventType", null).invoke(obj2, null);
                        if (objInvoke instanceof String) {
                            eventType = (String) objInvoke;
                        }
                    } catch (Throwable th) {
                    }
                }
            }
            return "homepage_hot".equals(eventType) || "homepage_follow".equals(eventType) || "homepage_friends".equals(eventType);
        } catch (Throwable th2) {
            return false;
        }
    }

    public static void a(w7 w7Var) {
        try {
            HookBridge.hookAllConstructors(Class.forName(w7Var.b), new n5());
            String str = "FeedPagerHooks hooked constructors " + w7Var;
            Object obj = g7.a;
            g7.a(4, String.valueOf(str), (Throwable) null);
        } catch (Throwable th) {
            String str2 = "FeedPagerHooks constructor hook failed for " + w7Var;
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(str2), th);
        }
    }
}
