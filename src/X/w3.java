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

public abstract class w3 {
    public static void a() {
        n3 n3Var = new n3();
        for (Method method : ContinuousLoadingAwemeList.class.getDeclaredMethods()) {
            XposedBridge.hookMethod(method, n3Var);
        }
    }

    public static void b() {
        XposedBridge.hookAllMethods(BannerList.class, "getItems", new t3());
        XposedBridge.hookAllMethods(Banner.class, "isAd", new u3());
        XposedBridge.hookAllMethods(Banner.class, "getAdData", new v3());
    }

    public static void c() {
        XposedBridge.hookAllMethods(SearchMixFeed.class, "getAweme", new o3());
        XposedBridge.hookAllMethods(SearchMixFeed.class, "getPreciseAd", new p3());
        q3 q3Var = new q3();
        XposedBridge.hookAllMethods(SearchMixFeed.class, "isAweme", q3Var);
        XposedBridge.hookAllMethods(SearchMixFeed.class, "isVisualSearchAweme", q3Var);
        XposedBridge.hookAllMethods(SearchPreciseAd.class, "getAwemeCards", new r3());
    }

    public static void d() {
        s3 s3Var = new s3();
        for (Method method : SearchMixFeedList.class.getDeclaredMethods()) {
            XposedBridge.hookMethod(method, s3Var);
        }
    }

    public static void e() {
        if (!s2.a().d) {
            ArrayList arrayList = q2.a;
            return;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    w3.a();
                }
            }.run();
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList2 = q2.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    w3.c();
                }
            }.run();
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList3 = q2.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    w3.d();
                }
            }.run();
        } catch (Throwable th3) {
            th3.getMessage();
            ArrayList arrayList4 = q2.a;
        }
        try {
            new Runnable() {
                @Override
                public final void run() {
                    w3.b();
                }
            }.run();
        } catch (Throwable th4) {
            th4.getMessage();
            ArrayList arrayList5 = q2.a;
        }
        ArrayList arrayList6 = q2.a;
    }
}
