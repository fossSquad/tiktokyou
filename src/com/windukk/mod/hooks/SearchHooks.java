package com.windukk.mod.hooks;

import com.ss.android.ugc.aweme.discover.model.Banner;
import com.ss.android.ugc.aweme.discover.model.BannerList;
import com.ss.android.ugc.aweme.search.common.model.ContinuousLoadingAwemeList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeedList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.precisead.core.model.SearchPreciseAd;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;

public abstract class SearchHooks {
    static {
    }

    public static void a() {
        pd pdVar = new pd();
        for (Method method : ContinuousLoadingAwemeList.class.getDeclaredMethods()) {
            HookBridge.hookMethod(method, pdVar);
        }
    }

    public static void b() {
        HookBridge.hookAllMethods(BannerList.class, "getItems", new vd());
        HookBridge.hookAllMethods(Banner.class, "isAd", new wd());
        HookBridge.hookAllMethods(Banner.class, "getAdData", new xd());
    }

    public static void c() {
        HookBridge.hookAllMethods(SearchMixFeed.class, "getAweme", new qd());
        HookBridge.hookAllMethods(SearchMixFeed.class, "getPreciseAd", new rd());
        sd sdVar = new sd();
        HookBridge.hookAllMethods(SearchMixFeed.class, "isAweme", sdVar);
        HookBridge.hookAllMethods(SearchMixFeed.class, "isVisualSearchAweme", sdVar);
        HookBridge.hookAllMethods(SearchPreciseAd.class, "getAwemeCards", new td());
    }

    public static void d() {
        ud udVar = new ud();
        for (Method method : SearchMixFeedList.class.getDeclaredMethods()) {
            HookBridge.hookMethod(method, udVar);
        }
    }

    public static void e() {
        if (!d5.a().d) {
            return;
        }
        a(new Runnable() {
            @Override
            public final void run() {
                SearchHooks.a();
            }
        });
        a(new Runnable() {
            @Override
            public final void run() {
                SearchHooks.c();
            }
        });
        a(new Runnable() {
            @Override
            public final void run() {
                SearchHooks.d();
            }
        });
        a(new Runnable() {
            @Override
            public final void run() {
                SearchHooks.b();
            }
        });
    }

    public static void a(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
