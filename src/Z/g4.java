package Z;

import android.net.Uri;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Video;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Triple;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.PropertyReference1Impl;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.sequences.SequencesKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonElementKt;
import ni.shikatu.kotlinx.serialization.json.JsonNull;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;

public final class g4 {
    public static final g4 a = new g4();

    public static final String a(b3 b3Var) {
        int i;
        int i2;
        String strA;
        ArrayList arrayList = new ArrayList();
        int i3 = b3Var.h;
        if (i3 > 0) {
            if (i3 >= 1000000) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                strA = String.format(Locale.US, "%.1f Mbps", Arrays.copyOf(new Object[]{Float.valueOf(i3 / 1000000.0f)}, 1));
            } else {
                strA = new StringBuilder().append(Math.max(1, i3 / 1000)).append(" Kbps").toString();
            }
            arrayList.add(strA);
        }
        long j = b3Var.g;
        if (j > 0) {
            arrayList.add(a(j));
        }
        if (!b3Var.b() && (i = b3Var.j) > 0 && (i2 = b3Var.k) > 0) {
            arrayList.add(i + "×" + i2);
        }
        if (b3Var.c()) {
            arrayList.add("video + audio");
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " • ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return strJoinToString$default.length() == 0 ? b3Var.b : strJoinToString$default;
    }

    public static final String b(UrlModel urlModel) {
        Object obj;
        if (urlModel == null) {
            return "null";
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = RCompat.m6constructorimpl(urlModel.urlList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        List list = (List) obj;
        String str = urlModel.urlKey;
        return new StringBuilder().append("key=").append(str).append(",uri=").append(urlModel.uri).append(",urls=").append(list != null ? list.size() : 0).toString();
    }

    public static final String c(b3 b3Var) {
        return a(b3Var.a);
    }

    public static boolean d(UrlModel urlModel) {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append(urlModel.urlKey).append(' ').append(urlModel.uri);
        try {
            Result.Companion companion = Result.Companion;
            obj = RCompat.m6constructorimpl(urlModel.urlList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        List listEmptyList = (List) obj;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Iterator it = CollectionsKt.take(listEmptyList, 3).iterator();
        while (it.hasNext()) {
            sb.append(' ').append((String) it.next());
        }
        String lowerCase = sb.toString().toLowerCase(Locale.US);
        List listListOf = CollectionsKt.listOf(new String[]{"mime_type=audio", "mime_type%3daudio", "audio_mpeg", "audio_mp4", "/audio/"});
        if ((listListOf instanceof Collection) && listListOf.isEmpty()) {
            return false;
        }
        Iterator it2 = listListOf.iterator();
        while (it2.hasNext()) {
            if (StringsKt.contains$default(lowerCase, (CharSequence) it2.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public static UrlModel e(Object obj, String str) throws NoWhenBranchMatchedException {
        JsonObject jsonObject;
        UrlModel urlModelB;
        JsonElement jsonArrayA = f6.a(obj);
        Long lValueOf = null;
        if (jsonArrayA == null) {
            return null;
        }
        if (jsonArrayA instanceof JsonObject) {
            jsonObject = (JsonObject) (JsonElement) jsonArrayA;
        } else {
            if (jsonArrayA instanceof JsonArray) {
                List listCreateListBuilder = CollectionsKt.createListBuilder();
                a((JsonElement) jsonArrayA, listCreateListBuilder);
                return b(str, CollectionsKt.build(listCreateListBuilder));
            }
            jsonObject = null;
        }
        if (jsonObject == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Iterator it = CollectionsKt.listOf(new String[]{"main_url", "backup_url", "backup_url_1", "backup_url_2", "backup_url_3", "fallback_url", "url", "download_url", "play_url"}).iterator();
        while (it.hasNext()) {
            a((JsonElement) jsonObject.get((String) it.next()), arrayList);
        }
        Iterator it2 = CollectionsKt.listOf(new String[]{"url_list", "url_list_dash", "backup_url_list"}).iterator();
        while (it2.hasNext()) {
            a((JsonElement) jsonObject.get((String) it2.next()), arrayList);
        }
        Iterator it3 = CollectionsKt.listOf(new String[]{"play_addr", "download_addr", "url_model"}).iterator();
        while (it3.hasNext()) {
            a((JsonElement) jsonObject.get((String) it3.next()), arrayList);
        }
        if (arrayList.isEmpty() || (urlModelB = b(b(c(jsonObject, "url_key"), c(jsonObject, "uri"), c(jsonObject, "file_id"), str), arrayList)) == null) {
            return null;
        }
        urlModelB.uri = b(c(jsonObject, "uri"), c(jsonObject, "file_id"), str);
        long[] jArr = {b(jsonObject, "data_size"), b(jsonObject, "size"), b(jsonObject, "file_size")};
        while (true) {
            if (i >= 3) {
                break;
            }
            long j = jArr[i];
            if (j > 0) {
                lValueOf = Long.valueOf(j);
                break;
            }
            i++;
        }
        urlModelB.size = lValueOf != null ? lValueOf.longValue() : 0L;
        urlModelB.width = a(a(jsonObject, "width"), a(jsonObject, "vwidth"), a(jsonObject, "video_width"));
        urlModelB.height = a(a(jsonObject, "height"), a(jsonObject, "vheight"), a(jsonObject, "video_height"));
        return urlModelB;
    }

    public static int f(UrlModel urlModel) {
        return a(urlModel, "getWidth");
    }

    public static String c(UrlModel urlModel) {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append(urlModel != null ? urlModel.urlKey : null).append(' ').append(urlModel != null ? urlModel.uri : null);
        try {
            Result.Companion companion = Result.Companion;
            obj = RCompat.m6constructorimpl(urlModel != null ? urlModel.urlList : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        List listEmptyList = (List) obj;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Iterator it = CollectionsKt.take(listEmptyList, 2).iterator();
        while (it.hasNext()) {
            sb.append(' ').append((String) it.next());
        }
        String lowerCase = sb.toString().toLowerCase(Locale.US);
        if (StringsKt.contains$default(lowerCase, "bytevc2", false, 2, (Object) null)) {
            return "bytevc2";
        }
        if (!StringsKt.contains$default(lowerCase, "h264", false, 2, (Object) null) && !StringsKt.contains$default(lowerCase, "avc", false, 2, (Object) null)) {
            if (!StringsKt.contains$default(lowerCase, "bytevc1", false, 2, (Object) null) && !StringsKt.contains$default(lowerCase, "h265", false, 2, (Object) null) && !StringsKt.contains$default(lowerCase, "hevc", false, 2, (Object) null)) {
                if (!StringsKt.contains$default(lowerCase, "aac", false, 2, (Object) null) && !StringsKt.contains$default(lowerCase, "m4a", false, 2, (Object) null)) {
                    if (StringsKt.contains$default(lowerCase, "mp3", false, 2, (Object) null)) {
                        return "mp3";
                    }
                    return null;
                }
                return "aac";
            }
            return "hevc";
        }
        return "avc";
    }

    public final b3 a(Video video, JsonElement jsonElement, String str) throws NoWhenBranchMatchedException {
        sg sgVarA;
        UrlModel urlModelE = e(jsonElement, str);
        if (urlModelE == null) {
            return null;
        }
        if (StringsKt.equals(str, "suffix_scene", true)) {
            sgVarA = sg.b;
        } else {
            sgVarA = a(new String[] {str, urlModelE.urlKey, urlModelE.uri});
        }
        return a(video, urlModelE, new StringBuilder().append("video.miscDownloadAddrs[").append(str).append("]").toString(), d4.e, sgVarA, lb.b, 860, str);
    }

    public final ArrayList b(Video video) {
        Video video2 = video;
        String str = "aes";
        char c = 1;
        int i = 3;
        List<Triple> listListOf = CollectionsKt.listOf(new Triple[]{new Triple(video2, "getRawBitRate", "video.rawBitRate"), new Triple(video2, "getBitRate", "video.bitRate"), new Triple(d(video2, "getPlayAddr"), "getRawBitRate", "playAddr.rawBitRate"), new Triple(d(video2, "getPlayAddr"), "getBitRate", "playAddr.bitRate"), new Triple(d(video2, "getPlayAddrH264"), "getRawBitRate", "playAddrH264.rawBitRate"), new Triple(d(video2, "getPlayAddrBytevc1"), "getRawBitRate", "playAddrBytevc1.rawBitRate"), new Triple(d(video2, "getProperPlayAddr"), "getRawBitRate", "properPlayAddr.rawBitRate"), new Triple(d(video2, "getPlayAddr3DFallback"), "getRawBitRate", "playAddr3DFallback.rawBitRate"), new Triple(d(video2, "getUIAlikeDownloadAddr"), "getRawBitRate", "uiAlikeDownloadAddr.rawBitRate")});
        ArrayList arrayList = new ArrayList();
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        for (Triple triple : listListOf) {
            Serializable serializable = (Serializable) triple.component1();
            String str2 = (String) triple.component2();
            String str3 = (String) triple.component3();
            List listA = dd.a(serializable, str2);
            if (listA != null) {
                AtomicLong atomicLong = c4.a;
                c4.a(str3, Integer.valueOf(listA.size()));
                for (Object obj : listA) {
                    if (obj == null) {
                        video2 = video;
                        c = c;
                    } else if (setNewSetFromMap.add(obj)) {
                        Object objB = dd.b(obj, "isDash");
                        Boolean bool = objB instanceof Boolean ? (Boolean) objB : null;
                        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                        UrlModel urlModelD = d(obj, "getPlayAddr");
                        if (urlModelD != null) {
                            String strC = c(obj, "getGearName");
                            if (zBooleanValue) {
                                a(str3 + "[" + strC + "]", urlModelD, "dash_deferred");
                            } else {
                                int iA = a(obj, "getBitRate");
                                int iA2 = a(obj, "getQualityType");
                                int iA3 = a(a(obj, "getVideoWidth"), f(urlModelD));
                                char c2 = c;
                                int iA4 = a(a(obj, "getVideoHeight"), e(urlModelD));
                                String str4 = str3 + "[" + strC + "]";
                                ArrayList arrayList2 = arrayList;
                                d4 d4Var = d4.f;
                                String str5 = urlModelD.urlKey;
                                String str6 = urlModelD.uri;
                                String[] strArr = new String[i];
                                strArr[0] = strC;
                                strArr[c2] = str5;
                                strArr[2] = str6;
                                sg sgVarA = a(strArr);
                                lb lbVar = lb.c;
                                String str7 = str3;
                                jg jgVar = jg.a;
                                String strC2 = c(obj, "getCodecType");
                                if (strC2 == null && (strC2 = c(obj, "getEncodedType")) == null) {
                                    strC2 = c(urlModelD);
                                }
                                String str8 = str;
                                Set set = setNewSetFromMap;
                                b3 b3VarA = a(this, video2, urlModelD, str4, d4Var, sgVarA, lbVar, jgVar, iA, iA2, iA3, iA4, strC, strC2, c(obj, "getFormat"), 700, null, null, null, 491520);
                                if (b3VarA == null) {
                                    video2 = video;
                                    arrayList = arrayList2;
                                    c = c2;
                                    str3 = str7;
                                    setNewSetFromMap = set;
                                    str = str8;
                                    i = 3;
                                } else {
                                    if (!b3VarA.d()) {
                                        arrayList2.add(b3VarA);
                                    }
                                    video2 = video;
                                    arrayList = arrayList2;
                                    c = c2;
                                    str3 = str7;
                                    setNewSetFromMap = set;
                                    str = str8;
                                    i = 3;
                                }
                            }
                        }
                    }
                }
                video2 = video;
                c = c;
            }
        }
        return arrayList;
    }

    public final ArrayList a(Video video) {
        UrlModel urlModelD;
        String strC;
        ArrayList arrayList;
        Object obj;
        Object next;
        UrlModel urlModelA;
        ArrayList arrayList2;
        int r28 = 0;
        String str;
        boolean z;
        Object obj2 = null;
        int r29 = 0;
        Throwable th;
        List listEmptyList;
        a3 a3VarA;
        ArrayList arrayList3;
        Object obj3;
        Object next2;
        String str2;
        List list = null;
        List listEmptyList2 = null;
        ArrayList arrayList4 = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String str3 = "aes";
        a(linkedHashSet, dd.b(video, "getVideoModelStr"), "video.videoModelStr");
        a(linkedHashSet, dd.b(video, "getVideoModelMap"), "video.videoModelMap");
        a(linkedHashSet, dd.b(video, "getVideoModelObject"), "video.videoModelObject");
        boolean z2 = false;
        int i = 1;
        char c = 3;
        for (Pair pair : CollectionsKt.listOf(new Pair[]{TuplesKt.to("playAddr", d(video, "getPlayAddr")), TuplesKt.to("playAddrH264", d(video, "getPlayAddrH264")), TuplesKt.to("playAddrBytevc1", d(video, "getPlayAddrBytevc1")), TuplesKt.to("properPlayAddr", d(video, "getProperPlayAddr")), TuplesKt.to("playAddr3DFallback", d(video, "getPlayAddr3DFallback"))})) {
            String str4 = (String) pair.component1();
            UrlModel urlModel = (UrlModel) pair.component2();
            a(linkedHashSet, dd.b(urlModel, "getDashVideoModelStr"), new StringBuilder().append(str4).append(".dashVideoModelStr").toString());
            a(linkedHashSet, dd.b(urlModel, "getDashVideoModelMap"), new StringBuilder().append(str4).append(".dashVideoModelMap").toString());
        }
        AtomicLong atomicLong = c4.a;
        Integer numValueOf = Integer.valueOf(linkedHashSet.size());
        Object objB = dd.b(video, "hasDashBitrate");
        Object objB2 = dd.b(video, "hasVideoModel");
        Object objB3 = dd.b(video, "getVideoModelObject");
        c4.a(numValueOf, objB, objB2, objB3 != null ? objB3.getClass().getName() : null);
        for (Object obj4 : linkedHashSet) {
            String str5 = (String) obj4;
            try {
                Result.Companion companion = Result.Companion;
                JsonObject jsonObjectB = (JsonObject) f6.b(str5);
                JsonObject jsonObject = jsonObjectB instanceof JsonObject ? jsonObjectB : null;
                try {
                    if (jsonObject == null) {
                        listEmptyList2 = CollectionsKt.emptyList();
                    } else {
                        String[] strArr = new String[i];
                        strArr[z2 ? 1 : 0] = "dynamic_video";
                        Object obj5 = jsonObject.get(strArr[z2 ? 1 : 0]);
                        JsonObject jsonObject2 = obj5 instanceof JsonObject ? (JsonObject) obj5 : null;
                        if (jsonObject2 == null) {
                            jsonObject2 = null;
                        }
                        if (jsonObject2 == null) {
                            jsonObject2 = jsonObject;
                        }
                        String[] strArr2 = new String[i];
                        strArr2[z2 ? 1 : 0] = "dynamic_video_list";
                        Object obj6 = jsonObject2.get(strArr2[z2 ? 1 : 0]);
                        JsonArray jsonArray = obj6 instanceof JsonArray ? (JsonArray) obj6 : null;
                        JsonArray jsonArray2 = jsonArray == null ? null : jsonArray;
                        if (jsonArray2 == null) {
                            AtomicLong atomicLong2 = c4.a;
                            c4.a(CollectionsKt.take(jsonObject.keySet(), 12));
                            listEmptyList2 = CollectionsKt.emptyList();
                        } else {
                            String[] strArr3 = new String[i];
                            strArr3[z2 ? 1 : 0] = "dynamic_audio_list";
                            Object obj7 = jsonObject2.get(strArr3[z2 ? 1 : 0]);
                            JsonArray jsonArray3 = obj7 instanceof JsonArray ? (JsonArray) obj7 : null;
                            if (jsonArray3 == null) {
                                jsonArray3 = null;
                            }
                            if (jsonArray3 == null) {
                                jsonArray3 = new JsonArray(CollectionsKt.emptyList());
                            }
                            AtomicLong atomicLong3 = c4.a;
                            c4.a(Integer.valueOf(jsonArray2.size()), Integer.valueOf(jsonArray3.size()));
                            ArrayList arrayList5 = new ArrayList();
                            for (JsonObject jsonObject3 : (Iterable<JsonObject>) (Iterable) jsonArray3) {
                                a3 a3VarA2 = a(jsonObject3 instanceof JsonObject ? jsonObject3 : null, (i != 0));
                                if (a3VarA2 != null) {
                                    arrayList5.add(a3VarA2);
                                }
                            }
                            ArrayList arrayList6 = new ArrayList();
                            int size = arrayList5.size();
                            int i2 = z2 ? 1 : 0;
                            int r2 = i;
                            while (i2 < size) {
                                try {
                                    int i3 = i2 + 1;
                                    a3 a3Var = (a3) arrayList5.get(i2);
                                    UrlModel urlModel2 = a3Var.a;
                                    String strDecrypt = "video.videoModel.audio";
                                    ArrayList arrayList7 = arrayList5;
                                    d4 d4Var = d4.j;
                                    int i4 = size;
                                    sg sgVar = sg.a;
                                    lb lbVar = lb.d;
                                    jg jgVar = jg.b;
                                    boolean z3 = z2;
                                    try {
                                        int i5 = a3Var.e;
                                        try {
                                            String strDecrypt2 = "video_audio";
                                            String str6 = a3Var.c;
                                            String str7 = a3Var.d;
                                            r28 = 1;
                                            arrayList2 = arrayList4;
                                            z = z3;
                                            str2 = str3;
                                            try {
                                                b3 b3VarA = a(this, video, urlModel2, strDecrypt, d4Var, sgVar, lbVar, jgVar, i5, 0, 0, 0, strDecrypt2, str6, str7, 140, null, null, null, 229376);
                                                if (b3VarA != null) {
                                                    arrayList6.add(b3VarA);
                                                }
                                                z2 = z;
                                                i2 = i3;
                                                arrayList5 = arrayList7;
                                                size = i4;
                                                r2 = 1;
                                                arrayList4 = arrayList2;
                                                str3 = str2;
                                                c = 3;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                str = str2;
                                                Result.Companion companion2 = Result.Companion;
                                                obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
                                                r29 = r28;
                                                th = RCompat.m9exceptionOrNullimpl(obj2);
                                                if (th != null) {
                                                    AtomicLong atomicLong4 = c4.a;
                                                    c4.a(th.getClass().getSimpleName());
                                                }
                                                listEmptyList = CollectionsKt.emptyList();
                                                if (RCompat.m12isFailureimpl(obj2)) {
                                                    obj2 = listEmptyList;
                                                }
                                                ArrayList arrayList8 = arrayList2;
                                                CollectionsKt.addAll(arrayList8, (List) obj2);
                                                z2 = z;
                                                arrayList4 = arrayList8;
                                                str3 = str;
                                                i = r29;
                                                c = 3;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            arrayList2 = arrayList4;
                                            str2 = str3;
                                            z = z3;
                                            r28 = 1;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        arrayList2 = arrayList4;
                                        r28 = r2;
                                        str2 = str3;
                                        z = z3;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    arrayList2 = arrayList4;
                                    r28 = r2;
                                    str2 = str3;
                                    z = z2;
                                }
                            }
                            arrayList2 = arrayList4;
                            int r210 = r2;
                            String str8 = str3;
                            ArrayList arrayList9 = arrayList5;
                            z = z2;
                            for (JsonElement jsonElement : jsonArray2) {
                                JsonObject jsonObject4 = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
                                if (jsonObject4 != null && (a3VarA = a(jsonObject4, z)) != null) {
                                    str = str8;
                                    try {
                                        String strC2 = c(jsonObject4, "audio_file_id");
                                        if (strC2 == null || StringsKt.isBlank(strC2)) {
                                            strC2 = null;
                                        }
                                        int size2 = arrayList9.size();
                                        int i6 = z ? 1 : 0;
                                        while (true) {
                                            if (i6 >= size2) {
                                                arrayList3 = arrayList9;
                                                obj3 = null;
                                                break;
                                            }
                                            arrayList3 = arrayList9;
                                            obj3 = arrayList3.get(i6);
                                            i6++;
                                            a3 a3Var2 = (a3) obj3;
                                            if (strC2 != null && Intrinsics.areEqual(a3Var2.b, strC2)) {
                                                break;
                                            }
                                            arrayList9 = arrayList3;
                                        }
                                        a3 a3Var3 = (a3) obj3;
                                        if (a3Var3 == null) {
                                            Iterator it = arrayList3.iterator();
                                            if (it.hasNext()) {
                                                next2 = it.next();
                                                if (it.hasNext()) {
                                                    int i7 = ((a3) next2).e;
                                                    do {
                                                        Object next3 = it.next();
                                                        int i8 = ((a3) next3).e;
                                                        if (i7 < i8) {
                                                            next2 = next3;
                                                            i7 = i8;
                                                        }
                                                    } while (it.hasNext());
                                                }
                                            } else {
                                                next2 = null;
                                            }
                                            a3Var3 = (a3) next2;
                                            if (a3Var3 == null) {
                                                str8 = str;
                                                arrayList9 = arrayList3;
                                            }
                                        }
                                        b3 b3VarA2 = a(video, a3VarA, a3Var3, jsonObject4);
                                        if (b3VarA2 != null) {
                                            arrayList6.add(b3VarA2);
                                        }
                                        str8 = str;
                                        arrayList9 = arrayList3;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        r28 = r210;
                                        Result.Companion companion3 = Result.Companion;
                                        obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
                                        r29 = r28;
                                        th = RCompat.m9exceptionOrNullimpl(obj2);
                                        if (th != null) {
                                            AtomicLong atomicLong5 = c4.a;
                                            c4.a(th.getClass().getSimpleName());
                                        }
                                        listEmptyList = CollectionsKt.emptyList();
                                        if (RCompat.m12isFailureimpl(obj2)) {
                                            obj2 = listEmptyList;
                                        }
                                        ArrayList arrayList10 = arrayList2;
                                        CollectionsKt.addAll(arrayList10, (List) obj2);
                                        z2 = z;
                                        arrayList4 = arrayList10;
                                        str3 = str;
                                        i = r29;
                                        c = 3;
                                    }
                                }
                            }
                            str = str8;
                            list = arrayList6;
                            r28 = r210;
                            obj2 = RCompat.m6constructorimpl(list);
                            r29 = r28;
                            th = RCompat.m9exceptionOrNullimpl(obj2);
                            if (th != null) {
                                AtomicLong atomicLong6 = c4.a;
                                c4.a(th.getClass().getSimpleName());
                            }
                            listEmptyList = CollectionsKt.emptyList();
                            if (RCompat.m12isFailureimpl(obj2)) {
                                obj2 = listEmptyList;
                            }
                            ArrayList arrayList11 = arrayList2;
                            CollectionsKt.addAll(arrayList11, (List) obj2);
                            z2 = z;
                            arrayList4 = arrayList11;
                            str3 = str;
                            i = r29;
                            c = 3;
                        }
                    }
                    obj2 = RCompat.m6constructorimpl(list);
                    r29 = r28;
                } catch (Throwable th7) {
                    th = th7;
                    Result.Companion companion4 = Result.Companion;
                    obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
                    r29 = r28;
                }
                arrayList2 = arrayList4;
                r28 = i;
                str = str3;
                z = z2;
                list = listEmptyList2;
            } catch (Throwable th8) {
                th = th8;
                arrayList2 = arrayList4;
                r28 = i;
                str = str3;
                z = z2;
            }
            th = RCompat.m9exceptionOrNullimpl(obj2);
            if (th != null) {
                AtomicLong atomicLong7 = c4.a;
                c4.a(th.getClass().getSimpleName());
            }
            listEmptyList = CollectionsKt.emptyList();
            if (RCompat.m12isFailureimpl(obj2)) {
                obj2 = listEmptyList;
            }
            ArrayList arrayList12 = arrayList2;
            CollectionsKt.addAll(arrayList12, (List) obj2);
            z2 = z;
            arrayList4 = arrayList12;
            str3 = str;
            i = r29;
            c = 3;
        }
        int r211 = i;
        String str9 = str3;
        ArrayList arrayList13 = arrayList4;
        boolean z4 = z2;
        UrlModel urlModelD2 = d(video, "getPlayAddr");
        UrlModel urlModelD3 = d(video, "getPlayAddrH264");
        UrlModel urlModelD4 = d(video, "getPlayAddrBytevc1");
        UrlModel[] urlModelArr = new UrlModel[3];
        urlModelArr[z4 ? 1 : 0] = urlModelD2;
        urlModelArr[r211] = urlModelD3;
        urlModelArr[2] = urlModelD4;
        List listListOf = CollectionsKt.listOf(urlModelArr);
        ArrayList arrayList14 = new ArrayList();
        Iterator it2 = listListOf.iterator();
        while (it2.hasNext()) {
            UrlModel urlModel3 = (UrlModel) it2.next();
            List listA = dd.a(urlModel3, "getAudioBitrate");
            if (listA == null) {
                listA = CollectionsKt.emptyList();
            }
            ArrayList arrayList15 = new ArrayList();
            Iterator it3 = listA.iterator();
            while (it3.hasNext()) {
                Object objB4 = dd.b(it3.next(), "getAudioMeta");
                a3 a3Var4 = (objB4 == null || (urlModelA = a(objB4)) == null) ? null : new a3(urlModelA, c(objB4, "getFileId"), c(objB4, "getCodecType"), c(objB4, "getFormat"), (int) RangesKt.coerceAtMost(b(objB4, "getBitrate"), 2147483647L));
                if (a3Var4 != null) {
                    arrayList15.add(a3Var4);
                }
            }
            it2 = it2;
            z4 = z4;
            arrayList13 = arrayList13;
            if (!arrayList15.isEmpty()) {
                int size3 = arrayList15.size();
                int i9 = z4 ? 1 : 0;
                while (i9 < size3) {
                    Object obj8 = arrayList15.get(i9);
                    int i10 = i9 + 1;
                    a3 a3Var5 = (a3) obj8;
                    ArrayList arrayList16 = arrayList14;
                    UrlModel urlModel4 = urlModel3;
                    ArrayList arrayList17 = arrayList15;
                    int i11 = size3;
                    String str10 = str9;
                    b3 b3VarA3 = a(a, video, a3Var5.a, "video.audioBitrate.dash", d4.j, sg.a, lb.d, jg.b, a3Var5.e, 0, 0, 0, "video_audio", a3Var5.c, a3Var5.d, 130, null, null, null, 229376);
                    if (b3VarA3 != null) {
                        arrayList16.add(b3VarA3);
                    }
                    arrayList14 = arrayList16;
                    str9 = str10;
                    size3 = i11;
                    i9 = i10;
                    arrayList15 = arrayList17;
                    urlModel3 = urlModel4;
                }
                ArrayList arrayList18 = arrayList14;
                String str11 = str9;
                ArrayList arrayList19 = arrayList15;
                List listA2 = dd.a(urlModel3, "getRawBitRate");
                if (listA2 == null) {
                    arrayList14 = arrayList18;
                    str9 = str11;
                } else {
                    for (Object obj9 : listA2) {
                        Object objB5 = dd.b(obj9, "isDash");
                        Boolean bool = objB5 instanceof Boolean ? (Boolean) objB5 : null;
                        if ((bool != null ? bool.booleanValue() : z4) && (urlModelD = d(obj9, "getPlayAddr")) != null) {
                            String strC3 = c(obj9, "getUrlKey");
                            if (strC3 == null) {
                                strC3 = urlModelD.urlKey;
                            }
                            String str12 = strC3;
                            String strC4 = c(obj9, "getCodecType");
                            if (strC4 == null) {
                                String strC5 = c(obj9, "getEncodedType");
                                strC = strC5 == null ? c(urlModelD) : strC5;
                            } else {
                                strC = strC4;
                            }
                            a3 a3Var6 = new a3(urlModelD, str12, strC, c(obj9, "getFormat"), a(obj9, "getBitRate"));
                            String strC6 = c(obj9, "getAudioFileId");
                            int size4 = arrayList19.size();
                            int i12 = z4 ? 1 : 0;
                            while (true) {
                                if (i12 >= size4) {
                                    arrayList = arrayList19;
                                    obj = null;
                                    break;
                                }
                                arrayList = arrayList19;
                                obj = arrayList.get(i12);
                                i12++;
                                a3 a3Var7 = (a3) obj;
                                if (strC6 != null && Intrinsics.areEqual(a3Var7.b, strC6)) {
                                    break;
                                }
                                arrayList19 = arrayList;
                            }
                            a3 a3Var8 = (a3) obj;
                            if (a3Var8 == null) {
                                Iterator it4 = arrayList.iterator();
                                if (it4.hasNext()) {
                                    next = it4.next();
                                    if (it4.hasNext()) {
                                        int i13 = ((a3) next).e;
                                        do {
                                            Object next4 = it4.next();
                                            int i14 = ((a3) next4).e;
                                            if (i13 < i14) {
                                                next = next4;
                                                i13 = i14;
                                            }
                                        } while (it4.hasNext());
                                    }
                                } else {
                                    next = null;
                                }
                                a3Var8 = (a3) next;
                                if (a3Var8 == null) {
                                    arrayList19 = arrayList;
                                }
                            }
                            int iA = a(a(obj9, "getVideoWidth"), f(urlModelD));
                            int iA2 = a(a(obj9, "getVideoHeight"), e(urlModelD));
                            String strC7 = c(obj9, "getGearName");
                            String string = new StringBuilder().append("video.dashBitrate[").append(strC7).append("]").toString();
                            d4 d4Var2 = d4.i;
                            String str13 = urlModelD.urlKey;
                            String str14 = urlModelD.uri;
                            String[] strArr4 = new String[3];
                            strArr4[z4 ? 1 : 0] = strC7;
                            strArr4[r211] = str13;
                            strArr4[2] = str14;
                            arrayList19 = arrayList;
                            b3 b3VarA4 = a(this, video, urlModelD, string, d4Var2, a(strArr4), a(strC7, (String) null, (String) null) ? lb.a : lb.d, jg.c, a3Var6.e, a(obj9, "getQualityType"), iA, iA2, strC7, a3Var6.c, a3Var6.d, 800, null, null, new z2(a3Var6, a3Var8), 360448);
                            if (b3VarA4 != null) {
                                if (b3VarA4.d()) {
                                    b3VarA4 = null;
                                }
                                if (b3VarA4 != null) {
                                    arrayList18.add(b3VarA4);
                                }
                            }
                        }
                    }
                    arrayList14 = arrayList18;
                    str9 = str11;
                }
            }
        }
        CollectionsKt.addAll(arrayList13, arrayList14);
        return arrayList13;
    }

    public static String c(Object obj, String str) {
        Object objB = dd.b(obj, str);
        String str2 = objB instanceof String ? (String) objB : null;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return null;
        }
        return str2;
    }

    public static String c(JsonObject jsonObject, String str) {
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonObject.get(str);
        if (jsonPrimitive == null || Intrinsics.areEqual(jsonPrimitive, JsonNull.INSTANCE)) {
            return null;
        }
        return jsonPrimitive instanceof JsonPrimitive ? JsonElementKt.getContentOrNull(jsonPrimitive) : jsonPrimitive.toString();
    }

    public static final boolean b(b3 b3Var) {
        return !b3Var.b() && b3Var.d();
    }

    public static final int b(b3 b3Var, b3 b3Var2) {
        return a(b3Var2, b3Var);
    }

    public static final int b(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public static long b(Object obj, String str) {
        Object objB = dd.b(obj, str);
        Number number = objB instanceof Number ? (Number) objB : null;
        if (number != null) {
            return number.longValue();
        }
        return 0L;
    }

    public static long b(JsonObject jsonObject, String str) {
        Object obj = jsonObject.get(str);
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        if (jsonPrimitive == null) {
            return 0L;
        }
        Long longOrNull = JsonElementKt.getLongOrNull(jsonPrimitive);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        Double doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive);
        Long lValueOf = doubleOrNull != null ? Long.valueOf((long) doubleOrNull.doubleValue()) : null;
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        return 0L;
    }

    public static UrlModel b(String str, List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (a((String) obj)) {
                arrayList.add(obj);
            }
        }
        List listDistinct = CollectionsKt.distinct(arrayList);
        if (listDistinct.isEmpty()) {
            return null;
        }
        UrlModel urlModel = new UrlModel();
        urlModel.urlList = new ArrayList(listDistinct);
        urlModel.uri = str;
        urlModel.urlKey = str;
        return urlModel;
    }

    public static UrlModel d(Object obj, String str) {
        Object objB = dd.b(obj, str);
        return (UrlModel) (UrlModel.class.isInstance(objB) ? UrlModel.class.cast(objB) : null);
    }

    public static String b(String... strArr) {
        for (String str : strArr) {
            if (str != null && !StringsKt.isBlank(str)) {
                return str;
            }
        }
        return null;
    }

    public static int e(UrlModel urlModel) {
        return a(urlModel, "getHeight");
    }

    public static void a(LinkedHashSet linkedHashSet, Object obj, String str) {
        String string;
        if (obj instanceof String) {
            string = (String) (!StringsKt.isBlank((String) obj) ? obj : null);
        } else {
            JsonElement jsonElementA = f6.a(obj);
            if (jsonElementA == null) {
                string = null;
            } else {
                if (!(jsonElementA instanceof JsonObject) && !(jsonElementA instanceof JsonArray)) {
                    jsonElementA = null;
                }
                if (jsonElementA != null) {
                    string = jsonElementA.toString();
                } else {
                    string = null;
                }
            }
        }
        AtomicLong atomicLong = c4.a;
        c4.a(str, Boolean.valueOf(obj != null), obj != null ? obj.getClass().getName() : null, Integer.valueOf(string != null ? string.length() : 0));
        if (string == null || StringsKt.isBlank(string)) {
            return;
        }
        linkedHashSet.add(string);
    }

    public final b3 a(Video video, a3 a3Var, a3 a3Var2, JsonObject jsonObject) {
        String strC = c(jsonObject, "gear_name");
        if (strC == null || StringsKt.isBlank(strC)) {
            strC = null;
        }
        String strC2 = c(jsonObject, "definition");
        if (strC2 == null || StringsKt.isBlank(strC2)) {
            strC2 = null;
        }
        String strC3 = c(jsonObject, "quality");
        if (strC3 == null || StringsKt.isBlank(strC3)) {
            strC3 = null;
        }
        String strC4 = c(jsonObject, "logo_type");
        b3 b3VarA = a(this, video, a3Var.a, new StringBuilder().append("video.videoModel[").append(strC).append("]").toString(), d4.i, a(new String[] {strC4, strC, strC2}), a(strC, strC2, strC3) ? lb.a : lb.d, jg.c, a3Var.e, a(jsonObject, "quality"), a(a(jsonObject, "vwidth"), a(jsonObject, "width"), f(a3Var.a)), a(a(jsonObject, "vheight"), a(jsonObject, "height"), e(a3Var.a)), strC, a3Var.c, a3Var.d, 820, null, strC4, new z2(a3Var, a3Var2), 294912);
        if (b3VarA == null || b3VarA.d()) {
            return null;
        }
        return b3VarA;
    }

    public static a3 a(JsonObject jsonObject, boolean z) {
        UrlModel urlModelE;
        String str;
        String str2;
        String strC;
        String str3;
        if (jsonObject == null || (urlModelE = e(jsonObject, c(jsonObject, "file_id"))) == null) {
            return null;
        }
        int iA = a(a(jsonObject, "bitrate"), a(jsonObject, "real_bitrate"));
        String strC2 = c(jsonObject, "file_id");
        String str4 = (strC2 == null || StringsKt.isBlank(strC2)) ? null : strC2;
        String strC3 = c(jsonObject, (z ? "codec_type" : "codec"));
        if (strC3 == null) {
            strC = c(jsonObject, "codec_type");
            if (strC != null || StringsKt.isBlank(strC)) {
                str3 = null;
            } else {
                str3 = strC;
            }
        } else {
            if (StringsKt.isBlank(strC3)) {
                strC3 = null;
            }
            if (strC3 == null) {
                strC = c(jsonObject, "codec_type");
                if (strC != null) {
                    str3 = null;
                } else {
                    str3 = null;
                }
            } else {
                str3 = strC3;
            }
        }
        String strC4 = c(jsonObject, "format");
        return new a3(urlModelE, str4, str3, (strC4 == null || StringsKt.isBlank(strC4)) ? null : strC4, iA);
    }

    public static UrlModel a(Object obj) {
        Object objB = dd.b(obj, "getUrlList");
        if (objB == null) {
            return null;
        }
        int i = 0;
        List listListOf = CollectionsKt.listOf(new String[]{"getMainUrl", "getBackupUrl", "getFallbackUrl"});
        ArrayList arrayList = new ArrayList();
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            String strC = c(objB, (String) it.next());
            if (strC != null) {
                arrayList.add(strC);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            if (a((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        List listDistinct = CollectionsKt.distinct(arrayList2);
        if (listDistinct.isEmpty()) {
            return null;
        }
        UrlModel urlModel = new UrlModel();
        urlModel.urlList = new ArrayList(listDistinct);
        urlModel.uri = c(obj, "getFileId");
        urlModel.urlKey = c(obj, "getFileId");
        urlModel.size = b(obj, "getSize");
        urlModel.width = (int) RangesKt.coerceAtMost(b(obj, "getWidth"), 2147483647L);
        urlModel.height = (int) RangesKt.coerceAtMost(b(obj, "getHeight"), 2147483647L);
        return urlModel;
    }

    public final b3 a(Video video, UrlModel urlModel, String str, d4 d4Var, sg sgVar, lb lbVar, int i, String str2) {
        return a(this, video, urlModel, str, d4Var, sgVar, lbVar, jg.a, 0, 0, f(urlModel), e(urlModel), null, c(urlModel), null, i, str2, null, null, 458752);
    }

    public final List a(ArrayList arrayList) {
        String str;
        String str2;
        a3 a3Var;
        Set set = SequencesKt.toSet(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(arrayList), new Function1() {
            public final Object invoke(Object obj) {
                return Boolean.valueOf(g4.b((b3) obj));
            }
        }), new Function1() {
            public final Object invoke(Object obj) {
                return g4.c((b3) obj);
            }
        }));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            b3 b3Var = (b3) obj;
            String strA = a(b3Var.a);
            if (!b3Var.d() && (b3Var.b() || !set.contains(strA))) {
                if (!b3Var.b() && b3Var.l <= 0) {
                    a(b3Var.b, b3Var.a, "missing_resolution");
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append((b3Var.b() ? "audio:" : "video:"));
                    sb.append(strA);
                    if (b3Var.c()) {
                        StringBuilder sbAppend = sb.append(':');
                        z2 z2Var = b3Var.t;
                        sbAppend.append(a((z2Var == null || (a3Var = z2Var.b) == null) ? null : a3Var.a));
                    }
                    String string = sb.toString();
                    b3 b3Var2 = (b3) linkedHashMap.get(string);
                    if (b3Var2 == null || a(b3Var, b3Var2) > 0) {
                        linkedHashMap.put(string, b3Var);
                    }
                }
            } else {
                AtomicLong atomicLong = c4.a;
                c4.a(b3Var.b, strA);
            }
        }
        Collection collectionValues = linkedHashMap.values();
        final Function2 function2 = new Function2() {
            public final Object invoke(Object obj2, Object obj3) {
                return Integer.valueOf(g4.b((b3) obj2, (b3) obj3));
            }
        };
        List mutableList = CollectionsKt.toMutableList(CollectionsKt.sortedWith(collectionValues, new Comparator() {
            @Override
            public final int compare(Object obj2, Object obj3) {
                return g4.a(function2, obj2, obj3);
            }
        }));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : mutableList) {
            if (((b3) obj2).b()) {
                arrayList2.add(obj2);
            }
        }
        final f4 f4Var = new f4(this);
        b3 b3Var3 = (b3) CollectionsKt.maxWithOrNull(arrayList2, new Comparator() {
            @Override
            public final int compare(Object obj3, Object obj4) {
                return g4.b(f4Var, obj3, obj4);
            }
        });
        CollectionsKt.removeAll(mutableList, new PropertyReference1Impl((Class) null, "", "", 0) {
            {
            }

            public final Object get(Object obj3) {
                return Boolean.valueOf(((b3) obj3).b());
            }
        });
        if (b3Var3 != null) {
            mutableList.add(b3Var3);
        }
        return mutableList;
    }

    public static final int a(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public static int a(b3 b3Var, b3 b3Var2) throws NoWhenBranchMatchedException {
        int i;
        int i2;
        int i3 = 1;
        if (b3Var.b() != b3Var2.b()) {
            return b3Var.b() ? -1 : 1;
        }
        int i4 = b3Var.l;
        int i5 = b3Var2.l;
        if (i4 != i5) {
            return Intrinsics.compare(i4, i5);
        }
        int i6 = b3Var.h;
        int i7 = b3Var2.h;
        if (i6 != i7) {
            return Intrinsics.compare(i6, i7);
        }
        long j = b3Var.g;
        int i8 = 0;
        boolean z = 1 <= j && j < 524288;
        long j2 = b3Var2.g;
        if (z != (1 <= j2 && j2 < 524288)) {
            return z ? -1 : 1;
        }
        int i9 = b3Var.m;
        int i10 = b3Var2.m;
        if (i9 != i10) {
            return Intrinsics.compare(i9, i10);
        }
        if (j != j2) {
            return Intrinsics.compare(j, j2);
        }
        switch (b3Var.d.ordinal()) {
            case 0:
                i = 4;
                break;
            case 1:
                i = 0;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        switch (b3Var2.d.ordinal()) {
            case 0:
                i8 = 4;
                break;
            case 1:
                break;
            case 2:
                i8 = 2;
                break;
            case 3:
                i8 = 3;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        int iCompare = Intrinsics.compare(i, i8);
        if (iCompare != 0) {
            return iCompare;
        }
        switch (b3Var.e.ordinal()) {
            case 0:
                i2 = 4;
                break;
            case 1:
                i2 = 3;
                break;
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 2;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        switch (b3Var2.e.ordinal()) {
            case 0:
                i3 = 4;
                break;
            case 1:
                i3 = 3;
                break;
            case 2:
                break;
            case 3:
                i3 = 2;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        int iCompare2 = Intrinsics.compare(i2, i3);
        return iCompare2 != 0 ? iCompare2 : Intrinsics.compare(b3Var.n, b3Var2.n);
    }

    public static void a(JsonElement jsonElement, List list) throws NoWhenBranchMatchedException {
        if (jsonElement == null || Intrinsics.areEqual(jsonElement, JsonNull.INSTANCE)) {
            return;
        }
        if (jsonElement instanceof JsonArray) {
            Iterator it = ((Iterable) jsonElement).iterator();
            while (it.hasNext()) {
                a((JsonElement) it.next(), list);
            }
            return;
        }
        if (jsonElement instanceof JsonObject) {
            Iterator it2 = CollectionsKt.listOf(new String[]{"main_url", "backup_url", "backup_url_1", "backup_url_2", "backup_url_3", "fallback_url", "url", "download_url", "play_url"}).iterator();
            while (it2.hasNext()) {
                a((JsonElement) ((JsonObject) jsonElement).get((String) it2.next()), list);
            }
            Iterator it3 = CollectionsKt.listOf(new String[]{"url_list", "url_list_dash", "backup_url_list"}).iterator();
            while (it3.hasNext()) {
                a((JsonElement) ((JsonObject) jsonElement).get((String) it3.next()), list);
            }
            return;
        }
        if (jsonElement instanceof JsonPrimitive) {
            String contentOrNull = JsonElementKt.getContentOrNull((JsonPrimitive) jsonElement);
            String string = contentOrNull != null ? StringsKt.trim(contentOrNull).toString() : null;
            if (string == null) {
                string = "";
            }
            if (!StringsKt.startsWith$default(string, "{", false, 2, (Object) null) && !StringsKt.startsWith$default(string, "[", false, 2, (Object) null)) {
                if (a(string)) {
                    list.add(string);
                    return;
                }
                return;
            } else {
                JsonElement jsonElementB = f6.b(string);
                if (jsonElementB != null) {
                    a(jsonElementB, list);
                    return;
                }
                return;
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    public static boolean a(JsonObject jsonObject) {
        List listListOf = CollectionsKt.listOf(new String[]{"url_list", "main_url", "download_url", "play_url", "uri", "url_key"});
        if ((listListOf instanceof Collection) && listListOf.isEmpty()) {
            return false;
        }
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            if (jsonObject.containsKey((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static b3 a(g4 g4Var, Video video, UrlModel urlModel, String str, d4 d4Var, sg sgVar, lb lbVar, jg jgVar, int i, int i2, int i3, int i4, String str2, String str3, String str4, int i5, String str5, String str6, z2 z2Var, int i6) {
        Object obj;
        String strC;
        sg sgVar2;
        int iMax;
        int iIntValue;
        Object obj2 = null;
        String str7 = (i6 & 32768) != 0 ? null : str5;
        String str8 = (i6 & 65536) != 0 ? null : str6;
        z2 z2Var2 = (i6 & 131072) != 0 ? null : z2Var;
        boolean z = true;
        boolean z2 = (i6 & 262144) == 0;
        if (urlModel == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = RCompat.m6constructorimpl(urlModel.urlList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        List listEmptyList = (List) obj;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (!(listEmptyList instanceof Collection) || !listEmptyList.isEmpty()) {
            Iterator it = listEmptyList.iterator();
            while (it.hasNext()) {
                if (a((String) it.next())) {
                    if (!z2 && d(urlModel)) {
                        break;
                    }
                    if (!z2 && d(urlModel)) {
                        return null;
                    }
                    if (str3 != null) {
                        strC = str3;
                    } else {
                        strC = c(urlModel);
                    }
                    if (!z2 && StringsKt.equals(strC, "bytevc2", true)) {
                        a(str, urlModel, "unsupported_bytevc2");
                        return null;
                    }
                    if (jgVar != jg.b) {
                        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{strC, str4}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                        Locale locale = Locale.US;
                        String lowerCase = strJoinToString$default.toLowerCase(locale);
                        if (!StringsKt.contains$default(lowerCase, "aac", false, 2, (Object) null) && !StringsKt.contains$default(lowerCase, "mp4a", false, 2, (Object) null)) {
                            z = false;
                        } else {
                            String str9 = urlModel.urlKey;
                            if (str9 == null || StringsKt.isBlank(str9)) {
                                str9 = null;
                            }
                            String str10 = urlModel.uri;
                            if (str10 == null || StringsKt.isBlank(str10)) {
                                str10 = null;
                            }
                            String strB = String.valueOf(b(str9, str10));
                            if (strB != null) {
                                String lowerCase2 = strB.toLowerCase(locale);
                                if (lowerCase2 == null) {
                                    z = false;
                                } else {
                                    if ((str9 != null || str10 == null || !StringsKt.startsWith(str10, "v", true) || str10.length() < 12) && (!StringsKt.startsWith$default(lowerCase2, "v", false, 2, (Object) null) || lowerCase2.length() < 12 || (!StringsKt.contains$default(lowerCase2, "0000gc", false, 2, (Object) null) && !StringsKt.contains$default(lowerCase2, "gc000", false, 2, (Object) null)))) {
                                        z = false;
                                    }
                                    if (z) {
                                        AtomicLong atomicLong = c4.a;
                                        c4.a(StringsKt.take(lowerCase2, 32));
                                    }
                                }
                            } else {
                                z = false;
                            }
                        }
                        if (z) {
                            sgVar2 = sg.b;
                        } else {
                            sgVar2 = sgVar;
                        }
                    } else {
                        sgVar2 = sgVar;
                    }
                    int iA = a(i3, f(urlModel), a(video, "getWidth"));
                    int iA2 = a(i4, e(urlModel), a(video, "getHeight"));
                    if (iA > 0 && iA2 > 0) {
                        iMax = Math.min(iA, iA2);
                    } else {
                        iMax = Math.max(iA, iA2);
                    }
                    if (iMax <= 0) {
                        iIntValue = 0;
                    } else {
                        int[] iArr = {144, 240, 360, 480, 540, 576, 720, 1080, 1440, 2160, 4320};
                        ArrayList arrayList = new ArrayList();
                        for (int i7 = 0; i7 < 11; i7++) {
                            int i8 = iArr[i7];
                            if (i8 <= iMax) {
                                arrayList.add(Integer.valueOf(i8));
                            }
                        }
                        Integer num = CollectionsKt.maxOrNull((java.lang.Iterable<Integer>) arrayList);
                        if (num != null) {
                            iIntValue = num.intValue();
                        } else {
                            iIntValue = 0;
                        }
                    }
                    int iCoerceIn = (i / 10000) + RangesKt.coerceIn(i2, 0, 999) + (iIntValue * 1000);
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj2 = RCompat.m6constructorimpl(Long.valueOf(urlModel.size));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (RCompat.m12isFailureimpl(obj2)) {
                        obj2 = 0L;
                    }
                    b3 b3Var = new b3(urlModel, str, d4Var, sgVar2, lbVar, jgVar, ((Number) obj2).longValue(), i, i2, iA, iA2, iIntValue, iCoerceIn, i5, str2, strC, str4, str7, str8, z2Var2);
                    a(str, urlModel, "accepted:" + b3Var.d + ":" + b3Var.e + ":" + b3Var.f);
                    return b3Var;
                }
            }
        }
        a(str, urlModel, "unusable_url");
        return null;
    }

    public static sg a(String... strArr) {
        String lowerCase = CollectionsKt.joinToString$default(ArraysKt.filterNotNull(strArr), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null).toLowerCase(Locale.US);
        if (lowerCase.length() == 0) {
            return sg.c;
        }
        List listListOf = CollectionsKt.listOf(new String[]{"no_watermark", "nowatermark", "no_water", "without_watermark", "no_logo", "nologo"});
        if (!(listListOf instanceof Collection) || !listListOf.isEmpty()) {
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default(lowerCase, (CharSequence) it.next(), false, 2, (Object) null)) {
                    return sg.a;
                }
            }
        }
        List listListOf2 = CollectionsKt.listOf(new String[]{"watermark", "with_logo", "logo_watermark"});
        if (!(listListOf2 instanceof Collection) || !listListOf2.isEmpty()) {
            Iterator it2 = listListOf2.iterator();
            while (it2.hasNext()) {
                if (StringsKt.contains$default(lowerCase, (CharSequence) it2.next(), false, 2, (Object) null)) {
                    return sg.b;
                }
            }
        }
        return sg.c;
    }

    public static boolean a(String str, String str2, String str3) {
        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.filterNotNull(CollectionsKt.listOf(new String[]{str2, str3})), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        Locale locale = Locale.US;
        String lowerCase = strJoinToString$default.toLowerCase(locale);
        String lowerCase2 = null;
        if (!StringsKt.contains$default(lowerCase, "origin", false, 2, (Object) null) && !StringsKt.contains$default(lowerCase, "original", false, 2, (Object) null)) {
            if (str != null) {
                lowerCase2 = str.toLowerCase(locale);
            }
            if (lowerCase2 == null) {
                lowerCase2 = "";
            }
            if (!Intrinsics.areEqual(lowerCase2, "original") && !Intrinsics.areEqual(lowerCase2, "origin")) {
                return false;
            }
        }
        return true;
    }

    public static String a(UrlModel urlModel) {
        Object obj;
        Object obj2 = null;
        if (urlModel == null) {
            return "null";
        }
        String strB = String.valueOf(b(urlModel.urlKey, urlModel.uri));
        if (strB != null) {
            return strB;
        }
        try {
            Result.Companion companion = Result.Companion;
            List list = urlModel.urlList;
            obj = RCompat.m6constructorimpl((String) CollectionsKt.firstOrNull(list));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null) {
            return "object:" + System.identityHashCode(urlModel);
        }
        try {
            Result.Companion companion3 = Result.Companion;
            Uri uri = Uri.parse(str);
            obj2 = RCompat.m6constructorimpl(uri.getScheme() + "://" + uri.getHost() + uri.getPath());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th2));
        }
        String strSubstringBefore$default = StringsKt.substringBefore$default(str, '?', (String) null, 2, (Object) null);
        if (RCompat.m12isFailureimpl(obj2)) {
            obj2 = strSubstringBefore$default;
        }
        return (String) obj2;
    }

    public static void a(String str, UrlModel urlModel, String str2) {
        Object obj;
        AtomicLong atomicLong = c4.a;
        String strB = b(urlModel);
        try {
            Result.Companion companion = Result.Companion;
            obj = RCompat.m6constructorimpl(Long.valueOf(urlModel != null ? urlModel.size : 0L));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        c4.a(str, str2, strB, RCompat.m12isFailureimpl(obj) ? 0L : obj, Integer.valueOf(f(urlModel)), Integer.valueOf(e(urlModel)));
    }

    public static int a(Object obj, String str) {
        Object objB = dd.b(obj, str);
        Number number = objB instanceof Number ? (Number) objB : null;
        if (number != null) {
            return number.intValue();
        }
        return 0;
    }

    public static int a(JsonObject jsonObject, String str) {
        Object obj = jsonObject.get(str);
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        if (jsonPrimitive == null) {
            return 0;
        }
        Integer intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        Long longOrNull = JsonElementKt.getLongOrNull(jsonPrimitive);
        Integer numValueOf = longOrNull != null ? Integer.valueOf((int) RangesKt.coerceIn(longOrNull.longValue(), -2147483648L, 2147483647L)) : null;
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        Double doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive);
        Integer numValueOf2 = doubleOrNull != null ? Integer.valueOf((int) doubleOrNull.doubleValue()) : null;
        if (numValueOf2 != null) {
            return numValueOf2.intValue();
        }
        return 0;
    }

    public static boolean a(String str) {
        return StringsKt.startsWith$default(str, "https://", false, 2, (Object) null) || StringsKt.startsWith$default(str, "http://", false, 2, (Object) null);
    }

    public static String a(long j) {
        if (j >= 1048576) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(j / 1048576.0f)}, 1));
            return str;
        }
        if (j >= 1024) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format(Locale.US, "%.1f KB", Arrays.copyOf(new Object[]{Float.valueOf(j / 1024.0f)}, 1));
            return str2;
        }
        return j + " B";
    }

    public static void a(String str, List list) {
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            b3 b3Var = (b3) obj;
            AtomicLong atomicLong = c4.a;
            c4.a(str, Integer.valueOf(i), b3Var.b, Integer.valueOf(b3Var.l), Integer.valueOf(b3Var.h), b3Var.d, b3Var.e, b3Var.f, b3Var.p, a(b3Var.a));
            i = i2;
        }
    }

    public static int a(int... iArr) {
        Integer numValueOf;
        for (int i : iArr) {
            if (i > 0) {
                numValueOf = Integer.valueOf(i);
                if (numValueOf != null) {
                    return numValueOf.intValue();
                }
                return 0;
            }
        }
        numValueOf = null;
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }
}
