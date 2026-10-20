package Z;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.commerce.AwemeCommerceStruct;
import com.ss.android.ugc.aweme.feed.model.ACLCommonShare;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeRawAd;
import com.ss.android.ugc.aweme.feed.model.AwemeStatistics;
import com.ss.android.ugc.aweme.feed.model.FeedItemList;
import com.ss.android.ugc.aweme.feed.model.MixStatisStruct;
import com.ss.android.ugc.aweme.feed.model.MixStruct;
import com.ss.android.ugc.aweme.feed.model.PlayListInfo;
import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;
import com.windukk.mod.hooks.FeedHooks;
import com.windukk.mod.hooks.FlagSecureHooks;
import com.windukk.mod.hooks.FontHooks;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class m5 {
    public static volatile String a;
    public static volatile HashSet b;
    public static volatile List c;

    static {
        c = Collections.EMPTY_LIST;
    }

    public static void a() {
        try {
            HookBridge.hookMethod(db.b.a(db.a.a(), String.class), new c5());
        } catch (Throwable th) {
            String strDecrypt = "Panel_download_bar feature-gate hook failed: %s";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
        try {
            HookBridge.hookMethod(cb.b.a(cb.a.a(), new Class[0]), ReplaceMethod.returnConstant(Boolean.FALSE));
        } catch (Throwable th2) {
            String strDecrypt2 = "Share-download account-gate hook failed";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt2), th2);
        }
        try {
            HookBridge.hookMethod(Class.forName("com.ss.android.ugc.aweme.feed.model.AwemeExtKt").getMethod("isSharedStoryVisible", Aweme.class), ReplaceMethod.returnConstant(Boolean.TRUE));
        } catch (Throwable th3) {
            String strDecrypt3 = "isSharedStoryVisible hook failed";
            Object obj3 = g7.a;
            g7.a(6, String.valueOf(strDecrypt3), th3);
        }
    }

    public static void b() {
        try {
            HookBridge.hookAllMethods(FeedItemList.class, "getAwemeList", new d5());
            HookBridge.hookAllMethods(FeedItemList.class, "setItems", new e5());
            HookBridge.hookAllMethods(FeedItemList.class, "getItems", new f5());
            HookBridge.hookAllMethods(FeedItemList.class, "setPreloadAds", new g5());
            HookBridge.hookAllMethods(FeedItemList.class, "getPreloadAds", new h5());
            HookBridge.hookAllMethods(FeedItemList.class, "setHasAd", new i5());
            HookBridge.hookAllMethods(FeedItemList.class, "isHasAd", new j5());
            HookBridge.hookAllMethods(AwemeRawAd.class, "getRollType", new k5());
            FlagSecureHooks l5Var = new FlagSecureHooks();
            x4 x4Var = new x4();
            HookBridge.hookAllMethods(AwemeCommerceStruct.class, "getMidRollType", l5Var);
            HookBridge.hookAllMethods(AwemeCommerceStruct.class, "isEnableMidRoll", x4Var);
            String[] strArr = {"getAdInfo", "getAdExtInfo", "getCommercialInfo"};
            for (int i = 0; i < 3; i++) {
                try {
                    HookBridge.hookAllMethods(Aweme.class, strArr[i], new y4());
                } catch (Throwable th) {
                }
            }
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getCode", null), new z4());
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getShowType", null), new FeedHooks());
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getTranscode", null), new b5());
            a();
            FontHooks.a();
        } catch (Exception e) {
            String strDecrypt = "Exception during init";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), e);
        }
    }

    public static boolean a(Aweme aweme, boolean z) {
        Throwable thU = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        long j;
        String title;
        List list;
        String desc;
        String str = null;
        Object objInvoke = null;
        MixStatisStruct mixStatisStruct;
        if (aweme == null) {
            return false;
        }
        if (Z.a.a(aweme) && y5.a().d) {
            return true;
        }
        if (!z) {
            return false;
        }
        try {
            int awemeType = aweme.getAwemeType();
            if (awemeType == 104 || awemeType == 105) {
                return true;
            }
        } catch (Throwable th) {
        }
        try {
            if (aweme.getLiveId() != 0 || aweme.newLiveRoomData != null || aweme.getRoomFeedCellStruct() != null || ((aweme.getAuthorLive() != null && aweme.getAuthorLive().booleanValue()) || aweme.isLiveReplay() || aweme.getLiveExtraInfoStruct() != null)) {
                z2 = true;
            } else {
                z2 = false;
            }
        } catch (Throwable th2) {
        }
        try {
            z3 = aweme.getPhotoModeImageInfo() != null;
        } catch (Throwable th3) {
        }
        try {
            if (aweme.getIsTikTokStory() || aweme.getUserStory() != null || aweme.getStory() != null) {
                z4 = true;
            } else {
                z4 = false;
            }
        } catch (Throwable th4) {
        }
        try {
            MixStruct mixInfo = aweme.getMixInfo();
            if (mixInfo == null || TextUtils.isEmpty(mixInfo.mixId)) {
                z5 = false;
            } else {
                if (mixInfo.mixType == 0 && ((mixStatisStruct = mixInfo.statis) == null || (mixStatisStruct.currentEpisode <= 0 && mixStatisStruct.updatedToEpisode <= 0 && mixStatisStruct.hasUpdatedEpisode <= 0 && mixStatisStruct.lastReadEpisode <= 0))) {
                    try {
                        PlayListInfo playlist_info = aweme.getPlaylist_info();
                        if (playlist_info != null && !TextUtils.isEmpty(playlist_info.getMixId())) {
                            z5 = false;
                        }
                    } catch (Throwable th5) {
                    }
                }
                z5 = true;
            }
        } catch (Throwable th6) {
        }
        try {
            z6 = aweme.isPaidContent() || aweme.getMPaidContentInfo() != null;
        } catch (Throwable th7) {
        }
        if ((!z2 || !y5.a().c) && ((!z3 || !y5.a().e) && (!z4 || !y5.a().j))) {
            if (z5) {
                ac.a().getClass();
            }
            if (z6) {
                ac.a().getClass();
                ac.e();
            }
            long j2 = y5.a().B;
            long j3 = ac.e().C;
            long j4 = ac.e().D;
            bc bcVarE = ac.e();
            if (bcVarE.A == null) {
                bcVarE.A = new LinkedHashSet();
            }
            LinkedHashSet<String> linkedHashSet = bcVarE.A;
            AwemeStatistics statistics = aweme.getStatistics();
            User author = aweme.getAuthor();
            if (author == null) {
                j = 0;
            } else {
                if (author.getFollowStatus() != 0) {
                    return false;
                }
                String uid = author.getUid();
                if (TextUtils.isEmpty(uid)) {
                    j = 0;
                } else {
                    String strTrim = a;
                    if (!TextUtils.isEmpty(strTrim)) {
                        j = 0;
                    } else {
                        try {
                            e9 e9Var = l9.a;
                            Class<?> cls = Class.forName("X.03Rm");
                            j = 0;
                            try {
                                v9 v9Var = l9.b;
                                Method methodA = v9Var.a(cls, new Class[0]);
                                if (Modifier.isStatic(methodA.getModifiers())) {
                                    objInvoke = methodA.invoke(null, null);
                                    str = null;
                                } else {
                                    Object obj = l9.a.a(cls).get(null);
                                    if (obj == null) {
                                        a = null;
                                    } else {
                                        str = null;
                                        objInvoke = v9Var.a(obj.getClass(), new Class[0]).invoke(obj, null);
                                    }
                                    strTrim = null;
                                }
                                if (objInvoke == null) {
                                    a = str;
                                } else if (!Boolean.TRUE.equals(se.a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null))) {
                                    a = null;
                                } else {
                                    Object objInvoke2 = se.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
                                    if (objInvoke2 instanceof String) {
                                        strTrim = ((String) objInvoke2).trim();
                                        if (!strTrim.isEmpty()) {
                                            a = strTrim;
                                        }
                                    }
                                    a = null;
                                }
                            } catch (Throwable th8) {
                                thU = th8;
                                String strDecrypt = "Failed to resolve current user uid";
                                Object obj2 = g7.a;
                                g7.a(6, String.valueOf(strDecrypt), thU);
                            }
                        } catch (Throwable th9) {
                            thU = th9;
                            j = 0;
                        }
                        strTrim = null;
                    }
                    if (!TextUtils.isEmpty(strTrim) && TextUtils.equals(uid, strTrim)) {
                        return false;
                    }
                }
            }
            if ((statistics == null || ((j2 == j || j2 <= statistics.getDiggCount()) && (j3 == j || j3 <= statistics.getPlayCount()))) && (j4 == j || j4 <= aweme.getCreateTime())) {
                if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
                    HashSet hashSet = b;
                    if (hashSet != null && hashSet.equals(linkedHashSet)) {
                        list = c;
                        title = null;
                    } else {
                        ArrayList arrayList = new ArrayList(linkedHashSet.size());
                        for (String str2 : linkedHashSet) {
                            if (str2 != null && !str2.isEmpty()) {
                                try {
                                    arrayList.add(Pattern.compile(str2, 66));
                                } catch (PatternSyntaxException e) {
                                    arrayList.add(Pattern.compile(Pattern.quote(str2), 66));
                                }
                            }
                        }
                        c = arrayList;
                        b = new HashSet(linkedHashSet);
                        title = null;
                        list = arrayList;
                    }
                } else {
                    title = null;
                    b = null;
                    c = Collections.EMPTY_LIST;
                    list = c;
                }
                if (list.isEmpty()) {
                    return false;
                }
                try {
                    desc = aweme.getDesc();
                } catch (Throwable th10) {
                    desc = title;
                }
                try {
                    title = aweme.getTitle();
                } catch (Throwable th11) {
                }
                if ((desc == null || desc.isEmpty()) && (title == null || title.isEmpty())) {
                    return false;
                }
                for (int i = 0; i < list.size(); i++) {
                    Pattern pattern = (Pattern) list.get(i);
                    if ((desc == null || desc.isEmpty() || !pattern.matcher(desc).find()) && (title == null || title.isEmpty() || !pattern.matcher(title).find())) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static List a(List list, boolean z) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                Aweme aweme = (Aweme) list.get(i);
                if (a(aweme, z)) {
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
            if (arrayList != null) {
                return arrayList;
            }
        }
        return list;
    }
}
