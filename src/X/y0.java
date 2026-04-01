package X;

import com.ss.android.ugc.aweme.commerce.AwemeCommerceStruct;
import com.ss.android.ugc.aweme.feed.model.ACLCommonShare;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeRawAd;
import com.ss.android.ugc.aweme.feed.model.FeedItemList;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;
import java.util.List;

public abstract class y0 {
    public static void a() {
        try {
            XposedBridge.hookAllMethods(FeedItemList.class, "getAwemeList", new p0());
            XposedBridge.hookAllMethods(FeedItemList.class, "setItems", new q0());
            XposedBridge.hookAllMethods(FeedItemList.class, "getItems", new r0());
            XposedBridge.hookAllMethods(FeedItemList.class, "setPreloadAds", new s0());
            XposedBridge.hookAllMethods(FeedItemList.class, "getPreloadAds", new t0());
            XposedBridge.hookAllMethods(FeedItemList.class, "setHasAd", new u0());
            XposedBridge.hookAllMethods(FeedItemList.class, "isHasAd", new v0());
            XposedBridge.hookAllMethods(AwemeRawAd.class, "getRollType", new w0());
            x0 x0Var = new x0();
            k0 k0Var = new k0();
            XposedBridge.hookAllMethods(AwemeCommerceStruct.class, "getMidRollType", x0Var);
            XposedBridge.hookAllMethods(AwemeCommerceStruct.class, "isEnableMidRoll", k0Var);
            String[] strArr = {"getAdInfo", "getAdExtInfo", "getCommercialInfo"};
            for (int i = 0; i < 3; i++) {
                try {
                    XposedBridge.hookAllMethods(Aweme.class, strArr[i], new l0());
                } catch (Throwable th) {
                }
            }
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getCode", null), new m0());
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getShowType", null), new n0());
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getTranscode", null), new o0());
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = r1.a;
        }
    }

    public static List a(List list) {
        boolean z;
        boolean z2;
        if (list == null || list.isEmpty()) {
            return list;
        }
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Aweme aweme = (Aweme) list.get(i);
            boolean zA = g.a(aweme);
            boolean z3 = true;
            try {
                if (aweme.getLiveId() != 0 || aweme.newLiveRoomData != null || aweme.getRoomFeedCellStruct() != null || ((aweme.getAuthorLive() != null && aweme.getAuthorLive().booleanValue()) || aweme.isLiveReplay() || aweme.getLiveExtraInfoStruct() != null)) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
            }
            try {
                z2 = aweme.getPhotoModeImageInfo() != null;
            } catch (Throwable th2) {
            }
            try {
                if (!aweme.getIsTikTokStory() && aweme.getUserStory() == null && aweme.getStory() == null) {
                    z3 = false;
                }
            } catch (Throwable th3) {
            }
            if ((zA && t1.a().d) || ((z && t1.a().c) || ((z2 && t1.a().e) || (z3 && t1.a().f)))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(Math.max(0, size - 1));
                    for (int i2 = 0; i2 < i; i2++) {
                        arrayList.add((Aweme) list.get(i2));
                    }
                }
            } else if (arrayList != null) {
                arrayList.add(aweme);
            }
        }
        return arrayList != null ? arrayList : list;
    }
}
