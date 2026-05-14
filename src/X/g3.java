package X;

import com.ss.android.ugc.aweme.commerce.AwemeCommerceStruct;
import com.ss.android.ugc.aweme.feed.model.ACLCommonShare;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeRawAd;
import com.ss.android.ugc.aweme.feed.model.FeedItemList;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public abstract class g3 {
    public static void a(String str, String str2) {
        try {
            HookBridge.hookAllMethods(Class.forName(str), str2, new u2());
        } catch (Throwable th) {
            th.getMessage();
            int i = v3.a;
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
            HookBridge.hookAllMethods(FeedItemList.class, "getAwemeList", new x2());
            HookBridge.hookAllMethods(FeedItemList.class, "setItems", new y2());
            HookBridge.hookAllMethods(FeedItemList.class, "getItems", new z2());
            HookBridge.hookAllMethods(FeedItemList.class, "setPreloadAds", new a3());
            HookBridge.hookAllMethods(FeedItemList.class, "getPreloadAds", new b3());
            HookBridge.hookAllMethods(FeedItemList.class, "setHasAd", new c3());
            HookBridge.hookAllMethods(FeedItemList.class, "isHasAd", new d3());
            HookBridge.hookAllMethods(AwemeRawAd.class, "getRollType", new e3());
            f3 f3Var = new f3();
            p2 p2Var = new p2();
            HookBridge.hookAllMethods(AwemeCommerceStruct.class, "getMidRollType", f3Var);
            HookBridge.hookAllMethods(AwemeCommerceStruct.class, "isEnableMidRoll", p2Var);
            String[] strArr = {"getAdInfo", "getAdExtInfo", "getCommercialInfo"};
            for (int i = 0; i < 3; i++) {
                try {
                    HookBridge.hookAllMethods(Aweme.class, strArr[i], new q2());
                } catch (Throwable th) {
                }
            }
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getCode", null), new r2());
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getShowType", null), new s2());
            HookBridge.hookMethod(ACLCommonShare.class.getMethod("getTranscode", null), new t2());
            b();
        } catch (Exception e) {
            e.getMessage();
            int i2 = v3.a;
        }
    }

    public static boolean a() {
        y3 y3VarA = y3.a();
        return y3VarA.d || y3VarA.c || y3VarA.e || y3VarA.f;
    }

    public static void a(String str, String str2, String str3, boolean z) {
        try {
            Class<?> cls = Class.forName(str2);
            Field declaredField = cls.getDeclaredField(str3);
            declaredField.setAccessible(true);
            try {
                Class<?> cls2 = Class.forName(str);
                v2 v2Var = new v2(cls, declaredField, z);
                int i = 0;
                for (Method method : cls2.getDeclaredMethods()) {
                    for (Class<?> cls3 : method.getParameterTypes()) {
                        if (cls3 == cls) {
                            try {
                                HookBridge.hookMethod(method, v2Var);
                                i++;
                                break;
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
                if (i == 0) {
                    int i2 = v3.a;
                }
            } catch (Throwable th2) {
                th2.getMessage();
                int i3 = v3.a;
            }
        } catch (Throwable th3) {
            th3.getMessage();
            int i4 = v3.a;
        }
    }

    public static void a(String str, String str2, boolean z) {
        try {
            Class<?> cls = Class.forName(str);
            Field declaredField = cls.getDeclaredField(str2);
            declaredField.setAccessible(true);
            w2 w2Var = new w2(declaredField, z);
            try {
                HookBridge.hookAllConstructors(cls, w2Var);
            } catch (Throwable th) {
            }
            for (Method method : cls.getDeclaredMethods()) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    String name = method.getName();
                    if (name.equals("toString") || name.equals("hashCode") || name.equals("equals") || name.startsWith("get") || name.startsWith("is") || name.startsWith("set") || name.startsWith("copy") || name.startsWith("component")) {
                        try {
                            HookBridge.hookMethod(method, w2Var);
                        } catch (Throwable th2) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th3.getMessage();
            int i = v3.a;
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
        boolean zA = g.a(aweme);
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
            z3 = (!aweme.getIsTikTokStory() && aweme.getUserStory() == null && aweme.getStory() == null) ? false : true;
        } catch (Throwable th3) {
        }
        if (zA && y3.a().d) {
            return true;
        }
        if (z && y3.a().c) {
            return true;
        }
        if (z2 && y3.a().e) {
            return true;
        }
        return z3 && y3.a().f;
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
