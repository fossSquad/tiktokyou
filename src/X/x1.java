package X;

import com.ss.android.ugc.aweme.commerce.AwemeCommerceStruct;
import com.ss.android.ugc.aweme.feed.model.ACLCommonShare;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeRawAd;
import com.ss.android.ugc.aweme.feed.model.FeedItemList;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;
import java.util.List;

public abstract class x1 {

    public static void a() {
        try {
            XposedBridge.hookAllMethods(FeedItemList.class, "getAwemeList", new o1());
            XposedBridge.hookAllMethods(FeedItemList.class, "setItems", new p1());
            XposedBridge.hookAllMethods(FeedItemList.class, "getItems", new q1());
            XposedBridge.hookAllMethods(FeedItemList.class, "setPreloadAds", new r1());
            XposedBridge.hookAllMethods(FeedItemList.class, "getPreloadAds", new s1());
            XposedBridge.hookAllMethods(FeedItemList.class, "setHasAd", new t1());
            XposedBridge.hookAllMethods(FeedItemList.class, "isHasAd", new u1());
            XposedBridge.hookAllMethods(AwemeRawAd.class, "getRollType", new v1());
            w1 w1Var = new w1();
            j1 j1Var = new j1();
            XposedBridge.hookAllMethods(AwemeCommerceStruct.class, "getMidRollType", w1Var);
            XposedBridge.hookAllMethods(AwemeCommerceStruct.class, "isEnableMidRoll", j1Var);
            String[] strArr = {"getAdInfo", "getAdExtInfo", "getCommercialInfo"};
            for (int i = 0; i < 3; i++) {
                try {
                    XposedBridge.hookAllMethods(Aweme.class, strArr[i], new k1());
                } catch (Throwable th) {
                }
            }
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getCode", null), new l1());
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getShowType", null), new m1());
            XposedBridge.hookMethod(ACLCommonShare.class.getMethod("getTranscode", null), new n1());
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = q2.a;
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
            if ((zA && s2.a().d) || ((z && s2.a().c) || ((z2 && s2.a().e) || (z3 && s2.a().f)))) {
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
