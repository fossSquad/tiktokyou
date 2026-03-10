package X;

import com.ss.android.ugc.aweme.commerce.AwemeCommerceStruct;
import com.ss.android.ugc.aweme.feed.model.ACLCommonShare;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeRawAd;
import com.ss.android.ugc.aweme.feed.model.FeedItemList;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class k0 {
    public static void a() {
        try {
            XposedBridge.hookAllMethods(FeedItemList.class, "getAwemeList", new b0());
            XposedBridge.hookAllMethods(FeedItemList.class, "setItems", new c0());
            XposedBridge.hookAllMethods(FeedItemList.class, "getItems", new d0());
            XposedBridge.hookAllMethods(FeedItemList.class, "setPreloadAds", new e0());
            XposedBridge.hookAllMethods(AwemeRawAd.class, "getRollType", new f0());
            g0 g0Var = new g0();
            h0 h0Var = new h0();
            XposedBridge.hookAllMethods(AwemeCommerceStruct.class, "getMidRollType", g0Var);
            XposedBridge.hookAllMethods(AwemeCommerceStruct.class, "isEnableMidRoll", h0Var);
            String[] strArr = {"getAdInfo", "getAdExtInfo", "getCommercialInfo"};
            for (int i = 0; i < 3; i++) {
                try {
                    XposedBridge.hookAllMethods(Aweme.class, strArr[i], new i0());
                } catch (Throwable th) {
                }
            }
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getCode", null), new j0());
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getShowType", null), new z());
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getTranscode", null), new a0());
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = g1.a;
        }
    }

    public static boolean a(Aweme aweme) {
        boolean zIsAd;
        boolean z;
        boolean z2;
        boolean z3;
        try {
            zIsAd = aweme.isAd();
            if (aweme.isSoftAd()) {
                zIsAd = true;
            }
        } catch (Throwable th) {
            zIsAd = false;
        }
        try {
            if (aweme.getLiveId() != 0 || aweme.newLiveRoomData != null || aweme.getRoomFeedCellStruct() != null || ((aweme.getAuthorLive() != null && aweme.getAuthorLive().booleanValue()) || aweme.isLiveReplay() || aweme.getLiveExtraInfoStruct() != null)) {
                z = true;
            } else {
                z = false;
            }
        } catch (Throwable th2) {
        }
        try {
            z2 = aweme.isPhotoSwap() || aweme.getPhotoModeImageInfo() != null;
        } catch (Throwable th3) {
        }
        try {
            z3 = aweme.getIsTikTokStory() || aweme.getUserStory() != null || aweme.getStory() != null || aweme.isStoryFakeAweme();
        } catch (Throwable th4) {
        }
        if (zIsAd && i1.a().d) {
            return true;
        }
        if (z && i1.a().c) {
            return true;
        }
        if (z2 && i1.a().e) {
            return true;
        }
        return z3 && i1.a().f;
    }
}
