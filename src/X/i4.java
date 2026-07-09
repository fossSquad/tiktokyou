package X;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.commerce.AwemeCommerceStruct;
import com.ss.android.ugc.aweme.feed.model.ACLCommonShare;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeRawAd;
import com.ss.android.ugc.aweme.feed.model.AwemeStatistics;
import com.ss.android.ugc.aweme.feed.model.FeedItemList;
import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class i4 {
    public static volatile String a;
    public static volatile HashSet b;
    public static volatile List c = Collections.EMPTY_LIST;

    public static void a(String str, String str2) {
        try {
            HookBridge.hookAllMethods(Class.forName(str), str2, new w3());
        } catch (Throwable th) {
            th.getMessage();
            int i = g5.a;
        }
    }

    public static void b() {
        a("com.ss.android.ugc.aweme.feed.module.FollowingInterestFeedResponse", "getAwemeList");
        a("com.ss.android.ugc.aweme.relation.model.MaFUserVideoListResponse", "getAwemeList");
        a("com.ss.android.ugc.aweme.footnote.detail.repo.FootNoteFeedItemList", "getItems");
        a("com.ss.android.ugc.aweme.forward.model.ForwardItemList", "getItems");
        a("com.ss.android.ugc.aweme.api.ArtistMusicAwemeResponse", "getAwemeList");
        a("com.ss.android.ugc.aweme.music.model.FanSpotlightPickedVideosResponse", "getAwemeList");
        a("com.ss.android.ugc.aweme.mix.model.MixCandidateVideosResponse", "getMixVideos");
        a("com.ss.android.ugc.aweme.friendstab.api.FriendsFeedResponse", "getAwemeList");
        a("com.ss.android.ugc.aweme.favorites.business.collection.CollectionContentResponse", "items", false);
        a("com.ss.android.ugc.aweme.favorites.business.collection.AllFavoriteContentResponse", "items", false);
        a("com.ss.android.ugc.aweme.upvote.model.RepostListResponse", "repostList", false);
        a("com.ss.android.ugc.aweme.mix.api.response.MixVideosResponse", "mixVideos", false);
        a("com.ss.android.ugc.aweme.mix.model.MixCandidateVideosResponse", "mixVideos", false);
        a("com.ss.android.ugc.nearby.container.model.NearbyRevampResponse", "awemeList", false);
        a("com.ss.android.ugc.aweme.relation.model.FriendsNewPostsItemResponse", "awemeList", false);
        a("com.ss.android.ugc.aweme.relation.model.MaFUserVideoListResponse", "awemeList", false);
        a("com.ss.android.ugc.aweme.models.NowArchiveFeedResponse", "data", false);
        a("com.ss.android.ugc.aweme.api.ArtistMusicAwemeResponse", "awemeList", false);
        a("com.ss.android.ugc.aweme.music.discovery.api.MusicChartVideosV1Response", "videos", false);
        a("com.ss.android.ugc.aweme.explore.data.ExploreTopicAwemeListResponse", "items", false);
        a("com.ss.android.ugc.aweme.music.model.FanSpotlightPickedVideosResponse", "awemeList", false);
        a("com.ss.android.ugc.aweme.videohotswap.model.FullAwemeVideosResponse", "awemes", false);
        a("com.ss.android.ugc.aweme.feed.module.FollowingInterestFeedResponse", "awemeList", false);
        a("com.ss.android.ugc.aweme.footnote.detail.repo.FootNoteFeedItemList", "items", false);
        a("com.ss.android.ugc.aweme.forward.model.ForwardItemList", "items", false);
        a("com.ss.android.ugc.aweme.friendstab.api.FriendsFeedResponse", "friendFeedData", true);
        a("com.ss.android.ugc.aweme.vibefeed.model.VibeFeedItemListResponse", "vibeList", true);
        a("com.ss.android.ugc.aweme.mix.mixdetail.viewmodel.MixVideosViewModel", "com.ss.android.ugc.aweme.mix.api.response.MixVideosResponse", "mixVideos", false);
        a("com.ss.android.ugc.aweme.mix.services.PlaylistPlayNextImpl", "com.ss.android.ugc.aweme.mix.api.response.MixVideosResponse", "mixVideos", false);
        a("com.ss.android.ugc.aweme.mix.videodetail.MixVideoPlayDetailPageFragment", "com.ss.android.ugc.aweme.mix.api.response.MixVideosResponse", "mixVideos", false);
        a("com.ss.android.ugc.nearby.container.vm.NearbyContainerViewModel", "com.ss.android.ugc.nearby.container.model.NearbyRevampResponse", "awemeList", false);
        a("com.ss.android.ugc.nearby.feedcard.vm.NearbyFeedInnerSharedViewModel", "com.ss.android.ugc.nearby.container.model.NearbyRevampResponse", "awemeList", false);
        a("com.ss.android.ugc.aweme.favorites.service.FavoriteServiceImpl", "com.ss.android.ugc.aweme.favorites.business.collection.CollectionContentResponse", "items", false);
        a("com.ss.android.ugc.aweme.favorites.business.monitor.FavoriteApiNetworkPartner", "com.ss.android.ugc.aweme.favorites.business.collection.CollectionContentResponse", "items", false);
        a("com.ss.android.ugc.aweme.favorites.business.monitor.FavoriteApiNetworkPartner", "com.ss.android.ugc.aweme.favorites.business.collection.AllFavoriteContentResponse", "items", false);
        a("com.ss.android.ugc.aweme.viewmodel.MentionFavoriteVideoVM", "com.ss.android.ugc.aweme.favorites.business.collection.AllFavoriteContentResponse", "items", false);
        a("com.ss.android.ugc.aweme.upvote.detail.reposttab.RepostListViewModel", "com.ss.android.ugc.aweme.upvote.model.RepostListResponse", "repostList", false);
        a("com.ss.android.ugc.aweme.nows.archive.viewmodel.NowArchiveFeedListViewModel", "com.ss.android.ugc.aweme.models.NowArchiveFeedResponse", "data", false);
        a("com.ss.android.ugc.aweme.explore.vm.ExploreTopicGeneralFeedListViewModel", "com.ss.android.ugc.aweme.explore.data.ExploreTopicAwemeListResponse", "items", false);
        a("com.ss.android.ugc.aweme.friendstab.service.FriendsFeedServiceImpl", "com.ss.android.ugc.aweme.friendstab.api.FriendsFeedResponse", "friendFeedData", true);
        a("com.ss.android.ugc.aweme.friendstab.ui.FriendsFeedFragmentPanel", "com.ss.android.ugc.aweme.friendstab.api.FriendsFeedResponse", "friendFeedData", true);
        a("com.ss.android.ugc.aweme.friendstab.ui.SocialFriendsFeedFragment", "com.ss.android.ugc.aweme.friendstab.api.FriendsFeedResponse", "friendFeedData", true);
        a("com.ss.android.ugc.aweme.vibefeed.feed.VibeDetailSharedVM", "com.ss.android.ugc.aweme.vibefeed.model.VibeFeedItemListResponse", "vibeList", true);
    }

    public static void c() {
        try {
            HookBridge.hookMethod(q7.b.a(q7.a.a(), String.class), new v3());
        } catch (Throwable th) {
            th.getMessage();
            int i = g5.a;
        }
        try {
            HookBridge.hookMethod(p7.b.a(p7.a.a(), new Class[0]), ReplaceMethod.returnConstant(Boolean.FALSE));
        } catch (Throwable th2) {
            th2.getMessage();
            int i2 = g5.a;
        }
        try {
            HookBridge.hookMethod(Class.forName("com.ss.android.ugc.aweme.feed.model.AwemeExtKt").getMethod("isSharedStoryVisible", Aweme.class), ReplaceMethod.returnConstant(Boolean.TRUE));
        } catch (Throwable th3) {
            th3.getMessage();
            int i3 = g5.a;
        }
    }

    public static void d() {
        try {
            HookBridge.hookAllMethods(FeedItemList.class, "getAwemeList", new z3());
            HookBridge.hookAllMethods(FeedItemList.class, "setItems", new a4());
            HookBridge.hookAllMethods(FeedItemList.class, "getItems", new b4());
            HookBridge.hookAllMethods(FeedItemList.class, "setPreloadAds", new c4());
            HookBridge.hookAllMethods(FeedItemList.class, "getPreloadAds", new d4());
            HookBridge.hookAllMethods(FeedItemList.class, "setHasAd", new e4());
            HookBridge.hookAllMethods(FeedItemList.class, "isHasAd", new f4());
            HookBridge.hookAllMethods(AwemeRawAd.class, "getRollType", new g4());
            h4 h4Var = new h4();
            q3 q3Var = new q3();
            HookBridge.hookAllMethods(AwemeCommerceStruct.class, "getMidRollType", h4Var);
            HookBridge.hookAllMethods(AwemeCommerceStruct.class, "isEnableMidRoll", q3Var);
            String[] strArr = {"getAdInfo", "getAdExtInfo", "getCommercialInfo"};
            for (int i = 0; i < 3; i++) {
                try {
                    HookBridge.hookAllMethods(Aweme.class, strArr[i], new r3());
                } catch (Throwable th) {
                }
            }
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getCode", null), new s3());
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getShowType", null), new t3());
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getTranscode", null), new u3());
            c();
            b();
        } catch (Exception e) {
            e.getMessage();
            int i2 = g5.a;
        }
    }

    public static boolean a() {
        l8 l8VarA = l8.a();
        return l8VarA.c || l8VarA.b || l8VarA.d || l8VarA.h;
    }

    public static void a(String str, String str2, String str3, boolean z) {
        try {
            Class<?> cls = Class.forName(str2);
            Field declaredField = cls.getDeclaredField(str3);
            declaredField.setAccessible(true);
            try {
                Class<?> cls2 = Class.forName(str);
                x3 x3Var = new x3(cls, declaredField, z);
                int i = 0;
                for (Method method : cls2.getDeclaredMethods()) {
                    for (Class<?> cls3 : method.getParameterTypes()) {
                        if (cls3 == cls) {
                            try {
                                HookBridge.hookMethod(method, x3Var);
                                i++;
                                break;
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
                if (i == 0) {
                    int i2 = g5.a;
                }
            } catch (Throwable th2) {
                th2.getMessage();
                int i3 = g5.a;
            }
        } catch (Throwable th3) {
            th3.getMessage();
            int i4 = g5.a;
        }
    }

    public static void a(String str, String str2, boolean z) {
        try {
            Class<?> cls = Class.forName(str);
            Field declaredField = cls.getDeclaredField(str2);
            declaredField.setAccessible(true);
            y3 y3Var = new y3(declaredField, z);
            try {
                HookBridge.hookAllConstructors(cls, y3Var);
            } catch (Throwable th) {
            }
            for (Method method : cls.getDeclaredMethods()) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    String name = method.getName();
                    if (name.equals("toString") || name.equals("hashCode") || name.equals("equals") || name.startsWith("get") || name.startsWith("is") || name.startsWith("set") || name.startsWith("copy") || name.startsWith("component")) {
                        try {
                            HookBridge.hookMethod(method, y3Var);
                        } catch (Throwable th2) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th3.getMessage();
            int i = g5.a;
        }
    }

    public static List b(List list) {
        Aweme aweme;
        if (list.isEmpty()) {
            return list;
        }
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj == null) {
                aweme = null;
            } else {
                Class<?> cls = obj.getClass();
                try {
                    Field declaredField = cls.getDeclaredField("aweme");
                    declaredField.setAccessible(true);
                    Object obj2 = declaredField.get(obj);
                    if (obj2 instanceof Aweme) {
                        aweme = (Aweme) obj2;
                    } else {
                        try {
                            Object objInvoke = cls.getMethod("getAweme", null).invoke(obj, null);
                            if (objInvoke instanceof Aweme) {
                                aweme = (Aweme) objInvoke;
                            } else {
                                aweme = null;
                            }
                        } catch (Throwable th) {
                        }
                    }
                } catch (Throwable th2) {
                }
            }
            if (aweme == null || !a(aweme)) {
                if (arrayList != null) {
                    arrayList.add(obj);
                }
            } else if (arrayList == null) {
                arrayList = new ArrayList(Math.max(0, size - 1));
                for (int i2 = 0; i2 < i; i2++) {
                    arrayList.add(list.get(i2));
                }
            }
        }
        return arrayList != null ? arrayList : list;
    }

    public static boolean a(Aweme aweme) {
        boolean z;
        boolean z2;
        boolean z3;
        ?? r17;
        List list;
        String desc;
        ?? r18;
        ?? r19;
        if (aweme != null) {
            try {
                int awemeType = aweme.getAwemeType();
                if (awemeType == 104 || awemeType == 105) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        boolean zA = g.a(aweme);
        ?? r4 = 0;
        r4 = 0;
        try {
            if (aweme.getLiveId() != 0 || aweme.newLiveRoomData != null || aweme.getRoomFeedCellStruct() != null || ((aweme.getAuthorLive() != null && aweme.getAuthorLive().booleanValue()) || aweme.isLiveReplay() || aweme.getLiveExtraInfoStruct() != null)) {
                z = true;
            } else {
                z = false;
            }
        } catch (Throwable th2) {
        }
        try {
            z2 = aweme.getPhotoModeImageInfo() != null;
        } catch (Throwable th3) {
        }
        try {
            z3 = (!aweme.getIsTikTokStory() && aweme.getUserStory() == null && aweme.getStory() == null) ? false : true;
        } catch (Throwable th4) {
        }
        if ((!zA || !l8.a().c) && ((!z || !l8.a().b) && ((!z2 || !l8.a().d) && (!z3 || !l8.a().h)))) {
            l8 l8VarA = l8.a();
            long j = l8VarA.x;
            long j2 = l8VarA.y;
            long j3 = l8VarA.z;
            if (l8VarA.w == null) {
                l8VarA.w = new LinkedHashSet();
            }
            LinkedHashSet<String> linkedHashSet = l8VarA.w;
            AwemeStatistics statistics = aweme.getStatistics();
            User author = aweme.getAuthor();
            String title = null;
            if (author == null) {
                r17 = 0;
            } else {
                if (author.getFollowStatus() == 0) {
                    String uid = author.getUid();
                    if (TextUtils.isEmpty(uid)) {
                        r17 = 0;
                    } else {
                        String strTrim = a;
                        if (!TextUtils.isEmpty(strTrim)) {
                            r19 = 0;
                        } else {
                            try {
                                k6 k6Var = o6.a;
                                Object obj = o6.a.a(Class.forName("X.0HQS")).get(null);
                                if (obj == null) {
                                    a = null;
                                    r18 = 0;
                                } else {
                                    t6 t6Var = o6.b;
                                    r18 = 0;
                                    try {
                                        Class<?> cls = obj.getClass();
                                        Object objInvoke = t6Var.a(cls, new Class[0]).invoke(obj, null);
                                        if (objInvoke == null) {
                                            a = null;
                                            r4 = cls;
                                            r18 = r18;
                                        } else {
                                            Method methodA = ha.a(objInvoke.getClass(), "isLogin", new Class[0]);
                                            Boolean bool = Boolean.TRUE;
                                            if (!bool.equals(methodA.invoke(objInvoke, null))) {
                                                a = null;
                                                r4 = bool;
                                                r18 = r18;
                                            } else {
                                                String str = "getCurUserId";
                                                Object objInvoke2 = ha.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
                                                if (objInvoke2 instanceof String) {
                                                    strTrim = ((String) objInvoke2).trim();
                                                    if (!strTrim.isEmpty()) {
                                                        a = strTrim;
                                                        r19 = r18;
                                                    }
                                                }
                                                a = null;
                                                r4 = str;
                                                r18 = r18;
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        th.getMessage();
                                        int i = g5.a;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                r18 = r4;
                            }
                            strTrim = null;
                            r19 = r18;
                        }
                        r17 = r19;
                        if (TextUtils.isEmpty(strTrim) || !TextUtils.equals(uid, strTrim)) {
                        }
                    }
                }
                r17 = r19;
                return false;
            }
            if ((statistics == null || ((j == r17 || j <= statistics.getDiggCount()) && (j2 == r17 || j2 <= statistics.getPlayCount()))) && (j3 == r17 || j3 <= aweme.getCreateTime())) {
                if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
                    HashSet hashSet = b;
                    if (hashSet != null && hashSet.equals(linkedHashSet)) {
                        list = c;
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
                        list = arrayList;
                    }
                } else {
                    b = null;
                    c = Collections.EMPTY_LIST;
                    list = c;
                }
                if (!list.isEmpty()) {
                    try {
                        desc = aweme.getDesc();
                    } catch (Throwable th7) {
                        desc = null;
                    }
                    try {
                        title = aweme.getTitle();
                    } catch (Throwable th8) {
                    }
                    if ((desc != null && !desc.isEmpty()) || (title != null && !title.isEmpty())) {
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            Pattern pattern = (Pattern) list.get(i2);
                            if ((desc == null || desc.isEmpty() || !pattern.matcher(desc).find()) && (title == null || title.isEmpty() || !pattern.matcher(title).find())) {
                            }
                        }
                    }
                }
                r17 = r19;
                return false;
            }
        }
        return true;
    }

    public static List a(List list) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                Aweme aweme = (Aweme) list.get(i);
                if (a(aweme)) {
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
