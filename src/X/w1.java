package X;

import com.ss.android.ugc.aweme.commerce.AwemeCommerceStruct;
import com.ss.android.ugc.aweme.feed.model.ACLCommonShare;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeRawAd;
import com.ss.android.ugc.aweme.feed.model.FeedItemList;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;
import java.util.List;

public abstract class w1 {
    public static void a() {
        try {
            XposedBridge.hookAllMethods(FeedItemList.class, "getAwemeList", new n1());
            XposedBridge.hookAllMethods(FeedItemList.class, "setItems", new o1());
            XposedBridge.hookAllMethods(FeedItemList.class, "getItems", new p1());
            XposedBridge.hookAllMethods(FeedItemList.class, "setPreloadAds", new q1());
            XposedBridge.hookAllMethods(FeedItemList.class, "getPreloadAds", new r1());
            XposedBridge.hookAllMethods(FeedItemList.class, "setHasAd", new s1());
            XposedBridge.hookAllMethods(FeedItemList.class, "isHasAd", new t1());
            XposedBridge.hookAllMethods(AwemeRawAd.class, "getRollType", new u1());
            v1 v1Var = new v1();
            i1 i1Var = new i1();
            XposedBridge.hookAllMethods(AwemeCommerceStruct.class, "getMidRollType", v1Var);
            XposedBridge.hookAllMethods(AwemeCommerceStruct.class, "isEnableMidRoll", i1Var);
            String[] strArr = {"getAdInfo", "getAdExtInfo", "getCommercialInfo"};
            for (int i = 0; i < 3; i++) {
                try {
                    XposedBridge.hookAllMethods(Aweme.class, strArr[i], new j1());
                } catch (Throwable th) {
                }
            }
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getCode", null), new k1());
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getShowType", null), new l1());
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getTranscode", null), new m1());
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = p2.a;
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
            if ((zA && r2.a().d) || ((z && r2.a().c) || ((z2 && r2.a().e) || (z3 && r2.a().f)))) {
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
