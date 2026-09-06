package com.windukk.mod.hooks;

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

public abstract class FeedHooks {
    public static volatile String a;
    public static volatile HashSet b;
    public static volatile List c;

    static {
        c = Collections.EMPTY_LIST;
    }

    public static boolean a() {
        if (d5.a().d || ta.d().c || ta.d().e || ta.d().i) {
            return true;
        }
        ta.d();
        ta.d();
        return false;
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
            HookBridge.hookMethod(w9.b.a(w9.a.a(), String.class), new n4());
        } catch (Throwable th) {
            String strDecrypt = "Panel_download_bar feature-gate hook failed: %s";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
        try {
            HookBridge.hookMethod(v9.b.a(v9.a.a(), new Class[0]), ReplaceMethod.returnConstant(Boolean.FALSE));
        } catch (Throwable th2) {
            String strDecrypt2 = "Share-download account-gate hook failed";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt2), th2);
        }
        try {
            HookBridge.hookMethod(Class.forName("com.ss.android.ugc.aweme.feed.model.AwemeExtKt").getMethod("isSharedStoryVisible", Aweme.class), ReplaceMethod.returnConstant(Boolean.TRUE));
        } catch (Throwable th3) {
            String strDecrypt3 = "isSharedStoryVisible hook failed";
            Object obj3 = h6.a;
            h6.a(6, String.valueOf(strDecrypt3), th3);
        }
    }

    public static void d() {
        try {
            HookBridge.hookAllMethods(FeedItemList.class, "getAwemeList", new r4());
            HookBridge.hookAllMethods(FeedItemList.class, "setItems", new s4());
            HookBridge.hookAllMethods(FeedItemList.class, "getItems", new t4());
            HookBridge.hookAllMethods(FeedItemList.class, "setPreloadAds", new u4());
            HookBridge.hookAllMethods(FeedItemList.class, "getPreloadAds", new v4());
            HookBridge.hookAllMethods(FeedItemList.class, "setHasAd", new w4());
            HookBridge.hookAllMethods(FeedItemList.class, "isHasAd", new x4());
            HookBridge.hookAllMethods(AwemeRawAd.class, "getRollType", new y4());
            z4 z4Var = new z4();
            i4 i4Var = new i4();
            HookBridge.hookAllMethods(AwemeCommerceStruct.class, "getMidRollType", z4Var);
            HookBridge.hookAllMethods(AwemeCommerceStruct.class, "isEnableMidRoll", i4Var);
            String[] strArr = {"getAdInfo", "getAdExtInfo", "getCommercialInfo"};
            for (int i = 0; i < 3; i++) {
                try {
                    HookBridge.hookAllMethods(Aweme.class, strArr[i], new j4());
                } catch (Throwable th) {
                }
            }
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getCode", null), new k4());
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getShowType", null), new l4());
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getTranscode", null), new m4());
            c();
            b();
        } catch (Exception e) {
            String strDecrypt = "Exception during init";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), e);
        }
    }

    public static void a(String str, String str2) {
        try {
            HookBridge.hookAllMethods(Class.forName(str), str2, new o4());
        } catch (Throwable th) {
            String strDecrypt = "hookAwemeListGetter failed";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(String str, String str2, String str3, boolean z) {
        try {
            Class<?> cls = Class.forName(str2);
            Field declaredField = cls.getDeclaredField(str3);
            declaredField.setAccessible(true);
            try {
                Class<?> cls2 = Class.forName(str);
                p4 p4Var = new p4(cls, declaredField, z);
                int i = 0;
                for (Method method : cls2.getDeclaredMethods()) {
                    for (Class<?> cls3 : method.getParameterTypes()) {
                        if (cls3 == cls) {
                            try {
                                HookBridge.hookMethod(method, p4Var);
                                i++;
                                break;
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
                if (i == 0) {
                }
            } catch (Throwable th2) {
                String strDecrypt = "hookResponseConsumer: consumer not found";
                Object obj = h6.a;
                h6.a(6, String.valueOf(strDecrypt), th2);
            }
        } catch (Throwable th3) {
            String strDecrypt2 = "hookResponseConsumer exception";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt2), th3);
        }
    }

    public static void a(String str, String str2, boolean z) {
        try {
            Class<?> cls = Class.forName(str);
            Field declaredField = cls.getDeclaredField(str2);
            declaredField.setAccessible(true);
            q4 q4Var = new q4(declaredField, z);
            try {
                HookBridge.hookAllConstructors(cls, q4Var);
            } catch (Throwable th) {
            }
            for (Method method : cls.getDeclaredMethods()) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    String name = method.getName();
                    if (name.equals("toString") || name.equals("hashCode") || name.equals("equals") || name.startsWith("get") || name.startsWith("is") || name.startsWith("set") || name.startsWith("copy") || name.startsWith("component")) {
                        try {
                            HookBridge.hookMethod(method, q4Var);
                        } catch (Throwable th2) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            String strDecrypt = "SanitizeListField lookup failed";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th3);
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
        boolean z4;
        boolean z5;
        long j;
        String str;
        List list;
        String desc;
        String title;
        String str2;
        Object objInvoke;
        MixStatisStruct mixStatisStruct;
        if (aweme != null) {
            try {
                int awemeType = aweme.getAwemeType();
                if (awemeType == 104 || awemeType == 105) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        boolean zA = a.a(aweme);
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
            if (aweme.getIsTikTokStory() || aweme.getUserStory() != null || aweme.getStory() != null) {
                z3 = true;
            } else {
                z3 = false;
            }
        } catch (Throwable th4) {
        }
        try {
            MixStruct mixInfo = aweme.getMixInfo();
            if (mixInfo == null || TextUtils.isEmpty(mixInfo.mixId)) {
                z4 = false;
            } else {
                if (mixInfo.mixType == 0 && ((mixStatisStruct = mixInfo.statis) == null || (mixStatisStruct.currentEpisode <= 0 && mixStatisStruct.updatedToEpisode <= 0 && mixStatisStruct.hasUpdatedEpisode <= 0 && mixStatisStruct.lastReadEpisode <= 0))) {
                    try {
                        PlayListInfo playlist_info = aweme.getPlaylist_info();
                        if (playlist_info != null && !TextUtils.isEmpty(playlist_info.getMixId())) {
                            z4 = false;
                        }
                    } catch (Throwable th5) {
                    }
                }
                z4 = true;
            }
        } catch (Throwable th6) {
        }
        try {
            z5 = aweme.isPaidContent() || aweme.getMPaidContentInfo() != null;
        } catch (Throwable th7) {
        }
        if ((!zA || !d5.a().d) && ((!z || !d5.a().c) && ((!z2 || !d5.a().e) && (!z3 || !d5.a().i)))) {
            if (z4) {
                ta.a().getClass();
                ta.d();
            }
            if (z5) {
                ta.a().getClass();
                ta.d();
            }
            long j2 = d5.a().w;
            long j3 = ta.d().x;
            long j4 = ta.d().y;
            ua uaVarD = ta.d();
            if (uaVarD.v == null) {
                uaVarD.v = new LinkedHashSet();
            }
            LinkedHashSet<String> linkedHashSet = uaVarD.v;
            AwemeStatistics statistics = aweme.getStatistics();
            User author = aweme.getAuthor();
            if (author == null) {
                j = 0;
            } else {
                if (author.getFollowStatus() == 0) {
                    String uid = author.getUid();
                    if (TextUtils.isEmpty(uid)) {
                        j = 0;
                    } else {
                        String strTrim = a;
                        if (!TextUtils.isEmpty(strTrim)) {
                            j = 0;
                        } else {
                            try {
                                z7 z7Var = g8.a;
                                Class<?> cls = Class.forName("X.03XD");
                                j = 0;
                                try {
                                    p8 p8Var = g8.b;
                                    Method methodA = p8Var.a(cls, new Class[0]);
                                    if (Modifier.isStatic(methodA.getModifiers())) {
                                        objInvoke = methodA.invoke(null, null);
                                        str2 = null;
                                    } else {
                                        Object obj = g8.a.a(cls).get(null);
                                        if (obj == null) {
                                            a = null;
                                        } else {
                                            str2 = null;
                                            objInvoke = p8Var.a(obj.getClass(), new Class[0]).invoke(obj, null);
                                        }
                                        strTrim = null;
                                    }
                                    if (objInvoke == null) {
                                        a = str2;
                                    } else if (!Boolean.TRUE.equals(dd.a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null))) {
                                        a = null;
                                    } else {
                                        Object objInvoke2 = dd.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
                                        if (objInvoke2 instanceof String) {
                                            strTrim = ((String) objInvoke2).trim();
                                            if (!strTrim.isEmpty()) {
                                                a = strTrim;
                                            }
                                        }
                                        a = null;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    String strDecrypt = "Failed to resolve current user uid";
                                    Object obj2 = h6.a;
                                    h6.a(6, String.valueOf(strDecrypt), th);
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                j = 0;
                            }
                            strTrim = null;
                        }
                        if (TextUtils.isEmpty(strTrim) || !TextUtils.equals(uid, strTrim)) {
                        }
                    }
                }
                return false;
            }
            if ((statistics == null || ((j2 == j || j2 <= statistics.getDiggCount()) && (j3 == j || j3 <= statistics.getPlayCount()))) && (j4 == j || j4 <= aweme.getCreateTime())) {
                if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
                    HashSet hashSet = b;
                    if (hashSet != null && hashSet.equals(linkedHashSet)) {
                        list = c;
                        str = null;
                    } else {
                        ArrayList arrayList = new ArrayList(linkedHashSet.size());
                        for (String str3 : linkedHashSet) {
                            if (str3 != null && !str3.isEmpty()) {
                                try {
                                    arrayList.add(Pattern.compile(str3, 66));
                                } catch (PatternSyntaxException e) {
                                    arrayList.add(Pattern.compile(Pattern.quote(str3), 66));
                                }
                            }
                        }
                        c = arrayList;
                        b = new HashSet(linkedHashSet);
                        str = null;
                        list = arrayList;
                    }
                } else {
                    str = null;
                    b = null;
                    c = Collections.EMPTY_LIST;
                    list = c;
                }
                if (!list.isEmpty()) {
                    try {
                        desc = aweme.getDesc();
                    } catch (Throwable th10) {
                        desc = str;
                    }
                    try {
                        title = aweme.getTitle();
                    } catch (Throwable th11) {
                        title = str;
                    }
                    if ((desc != null && !desc.isEmpty()) || (title != null && !title.isEmpty())) {
                        for (int i = 0; i < list.size(); i++) {
                            Pattern pattern = (Pattern) list.get(i);
                            if ((desc == null || desc.isEmpty() || !pattern.matcher(desc).find()) && (title == null || title.isEmpty() || !pattern.matcher(title).find())) {
                            }
                        }
                    }
                }
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
