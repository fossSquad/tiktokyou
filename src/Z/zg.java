package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookBridge;
import java.util.List;

public abstract class zg {
    public static final  int a = 0;

    static {
    }

    public static void a() {
        a(com.windukk.mod.b.a);
        a(com.windukk.mod.c.a);
        a(com.windukk.mod.d.a);
        b(com.windukk.mod.c.b);
        b(com.windukk.mod.d.b);
        b(com.windukk.mod.c.c);
        b(com.windukk.mod.d.c);
    }

    public static void b(p8 p8Var) {
        try {
            HookBridge.hookMethod(p8Var.a(Class.forName(p8Var.a.b), Integer.TYPE, Aweme.class), new yg());
            String str = "FeedPagerHooks hooked " + p8Var;
            Object obj = h6.a;
            h6.a(4, String.valueOf(str), (Throwable) null);
        } catch (Throwable th) {
            String str2 = "FeedPagerHooks item hook failed for " + p8Var;
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(str2), th);
        }
    }

    public static void a(p8 p8Var) {
        try {
            HookBridge.hookMethod(p8Var.a(Class.forName(p8Var.a.b), List.class), new xg());
            String str = "FeedPagerHooks hooked " + p8Var;
            Object obj = h6.a;
            h6.a(4, String.valueOf(str), (Throwable) null);
        } catch (Throwable th) {
            String str2 = "FeedPagerHooks bulk hook failed for " + p8Var;
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(str2), th);
        }
    }
}
