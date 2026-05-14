package X;

import com.ss.android.ugc.aweme.discover.model.Banner;
import com.ss.android.ugc.aweme.discover.model.BannerList;
import com.ss.android.ugc.aweme.search.common.model.ContinuousLoadingAwemeList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeedList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.precisead.core.model.SearchPreciseAd;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;

public abstract class g5 {
    public static void a() {
        x4 x4Var = new x4();
        for (Method method : ContinuousLoadingAwemeList.class.getDeclaredMethods()) {
            HookBridge.hookMethod(method, x4Var);
        }
    }

    public static void b() {
        HookBridge.hookAllMethods(BannerList.class, "getItems", new d5());
        HookBridge.hookAllMethods(Banner.class, "isAd", new e5());
        HookBridge.hookAllMethods(Banner.class, "getAdData", new f5());
    }

    public static void c() {
        HookBridge.hookAllMethods(SearchMixFeed.class, "getAweme", new y4());
        HookBridge.hookAllMethods(SearchMixFeed.class, "getPreciseAd", new z4());
        a5 a5Var = new a5();
        HookBridge.hookAllMethods(SearchMixFeed.class, "isAweme", a5Var);
        HookBridge.hookAllMethods(SearchMixFeed.class, "isVisualSearchAweme", a5Var);
        HookBridge.hookAllMethods(SearchPreciseAd.class, "getAwemeCards", new b5());
    }

    public static void d() {
        c5 c5Var = new c5();
        for (Method method : SearchMixFeedList.class.getDeclaredMethods()) {
            HookBridge.hookMethod(method, c5Var);
        }
    }

    public static void e() {
        if (!y3.a().d) {
            int i = v3.a;
            return;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    g5.a();
                }
            }.run();
        } catch (Throwable th) {
            th.getMessage();
            int i2 = v3.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    g5.c();
                }
            }.run();
        } catch (Throwable th2) {
            th2.getMessage();
            int i3 = v3.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    g5.d();
                }
            }.run();
        } catch (Throwable th3) {
            th3.getMessage();
            int i4 = v3.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    g5.b();
                }
            }.run();
        } catch (Throwable th4) {
            th4.getMessage();
            int i5 = v3.a;
        }
        int i6 = v3.a;
    }
}
