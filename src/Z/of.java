package Z;

import com.ss.android.ugc.aweme.discover.model.Banner;
import com.ss.android.ugc.aweme.discover.model.BannerList;
import com.ss.android.ugc.aweme.search.common.model.ContinuousLoadingAwemeList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeedList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.precisead.core.model.SearchPreciseAd;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;

public abstract class of {
    static {
    }

    public static void a() {
        ef efVar = new ef();
        for (Method method : ContinuousLoadingAwemeList.class.getDeclaredMethods()) {
            HookBridge.hookMethod(method, efVar);
        }
    }

    public static void b() {
        HookBridge.hookAllMethods(BannerList.class, "getItems", new lf());
        HookBridge.hookAllMethods(Banner.class, "isAd", new mf());
        HookBridge.hookAllMethods(Banner.class, "getAdData", new nf());
    }

    public static void c() {
        HookBridge.hookAllMethods(SearchMixFeed.class, "getAweme", new ff());
        HookBridge.hookAllMethods(SearchMixFeed.class, "getPreciseAd", new gf());
        hf hfVar = new hf();
        HookBridge.hookAllMethods(SearchMixFeed.class, "isAweme", hfVar);
        HookBridge.hookAllMethods(SearchMixFeed.class, "isVisualSearchAweme", hfVar);
        HookBridge.hookAllMethods(SearchPreciseAd.class, "getAwemeCards", new jf());
    }

    public static void d() {
        kf kfVar = new kf();
        for (Method method : SearchMixFeedList.class.getDeclaredMethods()) {
            HookBridge.hookMethod(method, kfVar);
        }
    }

    public static void e() {
        if (!y5.a().d) {
            return;
        }
        a(new Runnable() {
            @Override
            public final void run() {
                of.a();
            }
        });
        a(new Runnable() {
            @Override
            public final void run() {
                of.c();
            }
        });
        a(new Runnable() {
            @Override
            public final void run() {
                of.d();
            }
        });
        a(new Runnable() {
            @Override
            public final void run() {
                of.b();
            }
        });
    }

    public static void a(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
