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

public abstract class u2 {
    public static void a() {
        l2 l2Var = new l2();
        for (Method method : ContinuousLoadingAwemeList.class.getDeclaredMethods()) {
            XposedBridge.hookMethod(method, l2Var);
        }
    }

    public static void b() {
        XposedBridge.hookAllMethods(BannerList.class, "getItems", new r2());
        XposedBridge.hookAllMethods(Banner.class, "isAd", new s2());
        XposedBridge.hookAllMethods(Banner.class, "getAdData", new t2());
    }

    public static void c() {
        XposedBridge.hookAllMethods(SearchMixFeed.class, "getAweme", new m2());
        XposedBridge.hookAllMethods(SearchMixFeed.class, "getPreciseAd", new n2());
        o2 o2Var = new o2();
        XposedBridge.hookAllMethods(SearchMixFeed.class, "isAweme", o2Var);
        XposedBridge.hookAllMethods(SearchMixFeed.class, "isVisualSearchAweme", o2Var);
        XposedBridge.hookAllMethods(SearchPreciseAd.class, "getAwemeCards", new p2());
    }

    public static void d() {
        q2 q2Var = new q2();
        for (Method method : SearchMixFeedList.class.getDeclaredMethods()) {
            XposedBridge.hookMethod(method, q2Var);
        }
    }

    public static void e() {
        if (!t1.a().d) {
            ArrayList arrayList = r1.a;
            return;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    u2.a();
                }
            }.run();
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList2 = r1.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    u2.c();
                }
            }.run();
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList3 = r1.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    u2.d();
                }
            }.run();
        } catch (Throwable th3) {
            th3.getMessage();
            ArrayList arrayList4 = r1.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    u2.b();
                }
            }.run();
        } catch (Throwable th4) {
            th4.getMessage();
            ArrayList arrayList5 = r1.a;
        }
        ArrayList arrayList6 = r1.a;
    }
}
