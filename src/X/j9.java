package X;

import com.ss.android.ugc.aweme.discover.model.Banner;
import com.ss.android.ugc.aweme.discover.model.BannerList;
import com.ss.android.ugc.aweme.search.common.model.ContinuousLoadingAwemeList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeedList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.precisead.core.model.SearchPreciseAd;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;

public abstract class j9 {
    public static void a() {
        a9 a9Var = new a9();
        for (Method method : ContinuousLoadingAwemeList.class.getDeclaredMethods()) {
            HookBridge.hookMethod(method, a9Var);
        }
    }

    public static void b() {
        HookBridge.hookAllMethods(BannerList.class, "getItems", new g9());
        HookBridge.hookAllMethods(Banner.class, "isAd", new h9());
        HookBridge.hookAllMethods(Banner.class, "getAdData", new i9());
    }

    public static void c() {
        HookBridge.hookAllMethods(SearchMixFeed.class, "getAweme", new b9());
        HookBridge.hookAllMethods(SearchMixFeed.class, "getPreciseAd", new c9());
        d9 d9Var = new d9();
        HookBridge.hookAllMethods(SearchMixFeed.class, "isAweme", d9Var);
        HookBridge.hookAllMethods(SearchMixFeed.class, "isVisualSearchAweme", d9Var);
        HookBridge.hookAllMethods(SearchPreciseAd.class, "getAwemeCards", new e9());
    }

    public static void d() {
        f9 f9Var = new f9();
        for (Method method : SearchMixFeedList.class.getDeclaredMethods()) {
            HookBridge.hookMethod(method, f9Var);
        }
    }

    public static void e() {
        if (!d7.a().d) {
            int i = p4.a;
            return;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    j9.a();
                }
            }.run();
        } catch (Throwable th) {
            th.getMessage();
            int i2 = p4.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    j9.c();
                }
            }.run();
        } catch (Throwable th2) {
            th2.getMessage();
            int i3 = p4.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    j9.d();
                }
            }.run();
        } catch (Throwable th3) {
            th3.getMessage();
            int i4 = p4.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    j9.b();
                }
            }.run();
        } catch (Throwable th4) {
            th4.getMessage();
            int i5 = p4.a;
        }
        int i6 = p4.a;
    }
}
