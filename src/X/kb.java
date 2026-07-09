package X;

import com.ss.android.ugc.aweme.discover.model.Banner;
import com.ss.android.ugc.aweme.discover.model.BannerList;
import com.ss.android.ugc.aweme.search.common.model.ContinuousLoadingAwemeList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeedList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.precisead.core.model.SearchPreciseAd;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;

public abstract class kb {
    public static void a() {
        bb bbVar = new bb();
        for (Method method : ContinuousLoadingAwemeList.class.getDeclaredMethods()) {
            HookBridge.hookMethod(method, bbVar);
        }
    }

    public static void b() {
        HookBridge.hookAllMethods(BannerList.class, "getItems", new hb());
        HookBridge.hookAllMethods(Banner.class, "isAd", new ib());
        HookBridge.hookAllMethods(Banner.class, "getAdData", new jb());
    }

    public static void c() {
        HookBridge.hookAllMethods(SearchMixFeed.class, "getAweme", new cb());
        HookBridge.hookAllMethods(SearchMixFeed.class, "getPreciseAd", new db());
        eb ebVar = new eb();
        HookBridge.hookAllMethods(SearchMixFeed.class, "isAweme", ebVar);
        HookBridge.hookAllMethods(SearchMixFeed.class, "isVisualSearchAweme", ebVar);
        HookBridge.hookAllMethods(SearchPreciseAd.class, "getAwemeCards", new fb());
    }

    public static void d() {
        gb gbVar = new gb();
        for (Method method : SearchMixFeedList.class.getDeclaredMethods()) {
            HookBridge.hookMethod(method, gbVar);
        }
    }

    public static void e() {
        if (!l8.a().c) {
            int i = g5.a;
            return;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    kb.a();
                }
            }.run();
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    kb.c();
                }
            }.run();
        } catch (Throwable th2) {
            th2.getMessage();
            int i3 = g5.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    kb.d();
                }
            }.run();
        } catch (Throwable th3) {
            th3.getMessage();
            int i4 = g5.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    kb.b();
                }
            }.run();
        } catch (Throwable th4) {
            th4.getMessage();
            int i5 = g5.a;
        }
        int i6 = g5.a;
    }
}
