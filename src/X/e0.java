package X;

import com.ss.android.ugc.aweme.feed.model.ACLCommonShare;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.FeedItemList;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class e0 {
    public static void a() {
        try {
            XposedBridge.hookAllMethods(FeedItemList.class, "getAwemeList", new x());
            XposedBridge.hookAllMethods(FeedItemList.class, "setItems", new y());
            XposedBridge.hookAllMethods(FeedItemList.class, "setPreloadAds", new z());
            XposedBridge.hookAllMethods(FeedItemList.class, "getItems", new a0());
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getCode", null), new b0());
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getShowType", null), new c0());
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getTranscode", null), new d0());
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = q0.a;
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
            if (aweme.getAwemeRawAd() != null) {
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
        if (zIsAd && r0.a().d) {
            return true;
        }
        if (z && r0.a().c) {
            return true;
        }
        if (z2 && r0.a().e) {
            return true;
        }
        return z3 && r0.a().f;
    }
}
