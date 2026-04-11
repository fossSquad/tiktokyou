package X;

import com.ss.android.ugc.aweme.discover.model.Banner;
import com.ss.android.ugc.aweme.discover.model.BannerList;
import com.ss.android.ugc.aweme.search.common.model.ContinuousLoadingAwemeList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeedList;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.precisead.core.model.SearchPreciseAd;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Method;
import java.util.ArrayList;

public abstract class v3 {
    public static void a() {
        m3 m3Var = new m3();
        for (Method method : ContinuousLoadingAwemeList.class.getDeclaredMethods()) {
            XposedBridge.hookMethod(method, m3Var);
        }
    }

    public static void b() {
        XposedBridge.hookAllMethods(BannerList.class, "getItems", new s3());
        XposedBridge.hookAllMethods(Banner.class, "isAd", new t3());
        XposedBridge.hookAllMethods(Banner.class, "getAdData", new u3());
    }

    public static void c() {
        XposedBridge.hookAllMethods(SearchMixFeed.class, "getAweme", new n3());
        XposedBridge.hookAllMethods(SearchMixFeed.class, "getPreciseAd", new o3());
        p3 p3Var = new p3();
        XposedBridge.hookAllMethods(SearchMixFeed.class, "isAweme", p3Var);
        XposedBridge.hookAllMethods(SearchMixFeed.class, "isVisualSearchAweme", p3Var);
        XposedBridge.hookAllMethods(SearchPreciseAd.class, "getAwemeCards", new q3());
    }

    public static void d() {
        r3 r3Var = new r3();
        for (Method method : SearchMixFeedList.class.getDeclaredMethods()) {
            XposedBridge.hookMethod(method, r3Var);
        }
    }

    public static void e() {
        if (!r2.a().d) {
            ArrayList arrayList = p2.a;
            return;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    v3.a();
                }
            }.run();
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList2 = p2.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    v3.c();
                }
            }.run();
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList3 = p2.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    v3.d();
                }
            }.run();
        } catch (Throwable th3) {
            th3.getMessage();
            ArrayList arrayList4 = p2.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    v3.b();
                }
            }.run();
        } catch (Throwable th4) {
            th4.getMessage();
            ArrayList arrayList5 = p2.a;
        }
        ArrayList arrayList6 = p2.a;
    }
}
