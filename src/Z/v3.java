package Z;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.Video;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Triple;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonObject;

public final class v3 {
    public static final ThreadLocal a = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return v3.e();
        }
    });
    public static final Lazy b = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return v3.f();
        }
    });
    public static Class c;
    public static Class d;
    public static Field e;
    public static Field f;
    public static Field g;
    public static Field h;
    public static Field i;
    public static Field j;
    public static Field k;
    public static Field l;

    public static final List a(List list) {
        return list;
    }

    public static void b(final p4 p4Var) {
        ((Handler) b.getValue()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                v3.c(p4Var);
            }
        }, 300000L);
    }

    public static void c() throws ClassNotFoundException {
        v9 v9Var = s7.a;
        Class<?> cls = Class.forName("com.ss.android.ugc.trill.download.configuration.AwemeVideoDownloadConfiguration", false, v3.class.getClassLoader());
        String str = s7.a.c[0];
        HookBridge.hookAllMethods(cls, str, new v3$before$1());
        g7.a(4, g7.a("Hooked session-scoped AwemeVideo WaterMarkAbility", new Object[0]), (Throwable) null);
    }

    public static final void d() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        try {
            Result.Companion companion = Result.Companion;
            g();
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Download model mappings unavailable", new Object[0]), th2);
            return;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            b();
            obj2 = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
        }
        Throwable th4 = Result.exceptionOrNull-impl(obj2);
        if (th4 != null) {
            g7.a(6, g7.a("Download factory quality picker unavailable", new Object[0]), th4);
        }
        try {
            Result.Companion companion5 = Result.Companion;
            c();
            obj3 = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion6 = Result.Companion;
            obj3 = Result.constructor-impl(ResultKt.createFailure(th5));
        }
        Throwable th6 = Result.exceptionOrNull-impl(obj3);
        if (th6 != null) {
            g7.a(6, g7.a("Session watermark bypass unavailable", new Object[0]), th6);
        }
        try {
            Result.Companion companion7 = Result.Companion;
            a();
            obj4 = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th7) {
            Result.Companion companion8 = Result.Companion;
            obj4 = Result.constructor-impl(ResultKt.createFailure(th7));
        }
        Throwable th8 = Result.exceptionOrNull-impl(obj4);
        if (th8 != null) {
            g7.a(6, g7.a("Download ability compatibility monitor unavailable", new Object[0]), th8);
        }
        try {
            Result.Companion companion9 = Result.Companion;
            AtomicBoolean atomicBoolean = d4.a;
            d4.c();
            obj5 = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th9) {
            Result.Companion companion10 = Result.Companion;
            obj5 = Result.constructor-impl(ResultKt.createFailure(th9));
        }
        Throwable th10 = Result.exceptionOrNull-impl(obj5);
        if (th10 != null) {
            g7.a(6, g7.a("Download MediaStore hook unavailable", new Object[0]), th10);
        }
    }

    public static final Boolean e() {
        return Boolean.FALSE;
    }

    public static final Handler f() {
        return new Handler(Looper.getMainLooper());
    }

    public static void g() throws NoSuchFieldException, ClassNotFoundException {
        Object obj;
        e9 e9Var = r8.a;
        Class<?> cls = Class.forName("X.17gL");
        c = cls;
        e9 e9Var2 = q7.a;
        Class<?> cls2 = Class.forName("com.ss.android.ugc.trill.download.protocol.download.AwemeVideoDownloadAbilityProtocol");
        d = cls2;
        e9 e9Var3 = u8.a;
        Class<?> cls3 = Class.forName("X.17e3");
        e9 e9Var4 = q8.a;
        Class<?> cls4 = Class.forName("X.1IG0");
        e9 e9Var5 = r8.a;
        Class cls5 = c;
        if (cls5 == null) {
            cls5 = null;
        }
        Field fieldA = e9Var5.a(cls5);
        e = fieldA;
        e9 e9Var6 = r8.d;
        Class cls6 = c;
        if (cls6 == null) {
            cls6 = null;
        }
        Field fieldA2 = e9Var6.a(cls6);
        f = fieldA2;
        Field fieldA3 = q8.a.a(cls4);
        g = fieldA3;
        Field fieldA4 = u8.a.a(cls3);
        h = fieldA4;
        Field fieldA5 = u8.b.a(cls3);
        i = fieldA5;
        e9 e9Var7 = r8.c;
        Class cls7 = c;
        if (cls7 == null) {
            cls7 = null;
        }
        Field fieldA6 = e9Var7.a(cls7);
        j = fieldA6;
        e9 e9Var8 = r8.b;
        Class cls8 = c;
        if (cls8 == null) {
            cls8 = null;
        }
        Field fieldA7 = e9Var8.a(cls8);
        k = fieldA7;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(u8.c.a(cls3));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        l = (Field) (Result.isFailure-impl(obj) ? null : obj);
    }

    public static boolean a(p4 p4Var, o3 o3Var) throws IllegalAccessException {
        String str;
        Object obj;
        String strA;
        String str2;
        String str3;
        UrlModel urlModel = o3Var.a;
        List list = urlModel.urlList;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Object obj2 = p4Var.b;
        Field field = f;
        String strDecrypt = null;
        if (field == null) {
            field = null;
        }
        Object obj3 = field.get(obj2);
        if (obj3 == null) {
            return false;
        }
        String str4 = urlModel.uri;
        String str5 = urlModel.urlKey;
        List list2 = urlModel.urlList;
        String[] strArr = {str4, str5, list2 != null ? (String) CollectionsKt.firstOrNull(list2) : null};
        int i2 = 0;
        while (true) {
            if (i2 < 3) {
                str = strArr[i2];
                if (str != null && !StringsKt.isBlank(str) && !StringsKt.equals(str, "null", true)) {
                    break;
                }
                i2++;
            } else {
                str = null;
                break;
            }
        }
        if (str == null) {
            strA = null;
        } else {
            try {
                Result.Companion companion = Result.Companion;
                v9 v9Var = s8.a;
                Object objInvoke = s8.a.a(Class.forName("X.0E1k", false, v3.class.getClassLoader()), String.class).invoke(null, str);
                String str6 = objInvoke instanceof String ? (String) objInvoke : null;
                if (str6 == null || StringsKt.isBlank(str6)) {
                    str6 = null;
                }
                obj = Result.constructor-impl(str6);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            strA = (String) obj;
            if (strA == null) {
                strA = a(str);
            }
        }
        if (strA == null) {
            return false;
        }
        Field field2 = h;
        if (field2 == null) {
            field2 = null;
        }
        field2.set(obj3, urlModel);
        Field field3 = i;
        if (field3 == null) {
            field3 = null;
        }
        field3.set(obj3, strA);
        Field field4 = j;
        if (field4 == null) {
            field4 = null;
        }
        field4.set(obj2, strA);
        if (o3Var.b()) {
            Field field5 = k;
            if (field5 == null) {
                field5 = null;
            }
            field5.set(obj2, o3Var.a());
        }
        AtomicLong atomicLong = r4.a;
        p4Var.g = o3Var;
        p4Var.h = strA;
        ConcurrentHashMap concurrentHashMap = r4.d;
        long j2 = p4Var.a;
        boolean zB = o3Var.b();
        o3 o3Var2 = o3Var.b() ? o3Var : null;
        String strA2 = o3Var2 != null ? o3Var2.a() : null;
        o3 o3Var3 = o3Var.b() ? o3Var : null;
        if (o3Var3 != null) {
            strDecrypt = (Intrinsics.areEqual(o3Var3.a(), ".mp3") ? "audio/mpeg" : "audio/mp4");
        }
        concurrentHashMap.put(strA, new q4(j2, strA, zB, strA2, strDecrypt));
        r4.a(Long.valueOf(p4Var.a), o3Var.b, o3Var.d, o3Var.e, o3Var.f, strA);
        UrlModel urlModel2 = p4Var.d;
        UrlModel urlModel3 = o3Var.a;
        if (urlModel3 != null && urlModel2 != null) {
            Intrinsics.areEqual(v4.a(urlModel3), v4.a(urlModel2));
        }
        v4.b(o3Var.a);
        return true;
    }

    public static void b() throws ClassNotFoundException {
        v9 v9Var = p8.a;
        Class<?> cls = Class.forName("X.1Qso");
        String str = p8.a.c[0];
        HookBridge.hookAllMethods(cls, str, new v3$before$2());
        g7.a(4, g7.a("Hooked download factory quality picker (session scoped)", new Object[0]), (Throwable) null);
    }

    public static final void c(p4 p4Var) {
        r4.a(p4Var);
    }

    public static boolean a(Object obj, final Member member, final Object[] objArr) throws IllegalAccessException {
        Video video;
        UrlModel urlModel;
        String str;
        Object obj2;
        boolean zAreEqual;
        char c2;
        Object obj3;
        boolean z;
        Throwable th;
        List listEmptyList;
        List listEmptyList2;
        boolean z2;
        List listEmptyList3;
        String string;
        ?? r35;
        v4 v4Var;
        ArrayList arrayList;
        char c3;
        v4 v4Var2;
        ArrayList arrayList2;
        List listEmptyList4;
        Iterator it;
        Iterator it2;
        o3 o3VarA;
        final List<o3> listA;
        Object objB;
        Object objB2;
        Object obj4;
        Object obj5;
        List listA2;
        Iterator it3;
        Object objB3;
        UrlModel urlModelA;
        Iterator it4;
        Iterator it5;
        o3 o3VarA2;
        Object objB4;
        UrlModel urlModelA2;
        o3 o3VarA3;
        o3 o3VarA4;
        AtomicBoolean atomicBoolean;
        Map map = r4.b;
        p4 p4Var = (p4) map.get(obj);
        boolean z3 = true;
        if (p4Var != null && (atomicBoolean = p4Var.f) != null && atomicBoolean.get()) {
            return false;
        }
        Field field = g;
        if (field == null) {
            field = null;
        }
        Object obj6 = field.get(obj);
        Aweme aweme = obj6 instanceof Aweme ? (Aweme) obj6 : null;
        if (aweme == null || (video = aweme.getVideo()) == null) {
            return false;
        }
        Field field2 = f;
        if (field2 == null) {
            field2 = null;
        }
        Object obj7 = field2.get(obj);
        if (obj7 == null) {
            urlModel = null;
        } else {
            Field field3 = h;
            if (field3 == null) {
                field3 = null;
            }
            Object obj8 = field3.get(obj7);
            if (obj8 instanceof UrlModel) {
                urlModel = (UrlModel) obj8;
            } else {
                urlModel = null;
            }
        }
        if (obj7 == null) {
            str = null;
        } else {
            Field field4 = l;
            Object obj9 = field4 != null ? field4.get(obj7) : null;
            if (obj9 instanceof String) {
                str = (String) obj9;
            } else {
                str = null;
            }
        }
        Aweme aweme2 = aweme;
        UrlModel urlModel2 = urlModel;
        final p4 p4Var2 = new p4(r4.a.getAndIncrement(), obj, aweme2, urlModel2, str);
        map.put(obj, p4Var2);
        Long lValueOf = Long.valueOf(p4Var2.a);
        try {
            Result.Companion companion = Result.Companion;
            String strDecrypt = aweme2.aid;
            if (strDecrypt == null) {
                strDecrypt = "unknown";
            }
            obj2 = Result.constructor-impl(strDecrypt);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        String strDecrypt2 = "unknown";
        if (Result.isFailure-impl(obj2)) {
            obj2 = strDecrypt2;
        }
        r4.a(lValueOf, (String) obj2, str, v4.b(urlModel2));
        if (!p4Var2.f.compareAndSet(false, true)) {
            return false;
        }
        ArrayList arrayList3 = new ArrayList();
        v4 v4Var3 = v4.a;
        UrlModel urlModelD = v4.d(video, "getDownloadNoWatermarkAddr");
        String strDecrypt3 = "official.selected";
        s4 s4Var = s4.a;
        if (urlModel2 == null || urlModelD == null) {
            zAreEqual = urlModel2 == urlModelD;
        } else {
            zAreEqual = Intrinsics.areEqual(v4.a(urlModel2), v4.a(urlModelD));
        }
        dk dkVar = zAreEqual ? dk.a : dk.c;
        zc zcVar = zc.b;
        o3 o3VarA5 = v4Var3.a(video, urlModel2, strDecrypt3, s4Var, dkVar, zcVar, 930, null);
        if (o3VarA5 != null) {
            arrayList3.add(o3VarA5);
        }
        o3 o3VarA6 = v4Var3.a(video, urlModelD, "video.downloadNoWatermarkAddr", s4.b, dk.a, zcVar, 920, null);
        if (o3VarA6 != null) {
            arrayList3.add(o3VarA6);
        }
        o3 o3VarA7 = v4Var3.a(video, v4.d(video, "getDownloadAddr"), "video.downloadAddr", s4.c, dk.b, zcVar, 900, null);
        if (o3VarA7 != null) {
            arrayList3.add(o3VarA7);
        }
        o3 o3VarA8 = v4Var3.a(video, v4.d(video, "getNewDownloadAddr"), "video.newDownloadAddr", s4.d, dk.c, zcVar, 890, null);
        if (o3VarA8 != null) {
            arrayList3.add(o3VarA8);
        }
        String strC = v4.c(video, "getMiscDownloadAddrs");
        String string2 = strC != null ? StringsKt.trim(strC).toString() : null;
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            listEmptyList2 = CollectionsKt.emptyList();
            c2 = 0;
            r35 = 1;
        } else {
            try {
                Result.Companion companion3 = Result.Companion;
                JsonObject jsonObjectB = e7.b(string2);
                JsonObject jsonObject = jsonObjectB instanceof JsonObject ? jsonObjectB : null;
                if (jsonObject == null) {
                    listEmptyList3 = CollectionsKt.emptyList();
                    c2 = 0;
                    z3 = true;
                } else {
                    LinkedHashSet linkedHashSetLinkedSetOf = SetsKt.linkedSetOf(new String[]{"suffix_scene"});
                    if (str == null || (string = StringsKt.trim(str).toString()) == null) {
                        c2 = 0;
                    } else {
                        String lowerCase = string.toLowerCase(Locale.US);
                        c2 = 0;
                        try {
                            if (lowerCase != null) {
                                if (lowerCase.length() <= 0) {
                                    lowerCase = null;
                                }
                                if (lowerCase != null) {
                                    linkedHashSetLinkedSetOf.add(lowerCase);
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            z3 = true;
                            Result.Companion companion4 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            z = z3;
                        }
                    }
                    ArrayList arrayList4 = new ArrayList();
                    if (v4.a(jsonObject) && str == null) {
                        o3 o3VarA9 = v4Var3.a(video, (JsonElement) jsonObject, (String) null);
                        if (o3VarA9 != null) {
                            arrayList4.add(o3VarA9);
                        }
                        z2 = true;
                    } else {
                        Iterator it6 = jsonObject.entrySet().iterator();
                        while (it6.hasNext()) {
                            Map.Entry entry = (Map.Entry) it6.next();
                            String str2 = (String) entry.getKey();
                            JsonElement jsonElement = (JsonElement) entry.getValue();
                            z3 = z3;
                            try {
                                String lowerCase2 = str2.toLowerCase(Locale.US);
                                it6 = it6;
                                if (!linkedHashSetLinkedSetOf.contains(lowerCase2)) {
                                    AtomicLong atomicLong = r4.a;
                                    r4.a(str2);
                                } else {
                                    o3 o3VarA10 = v4Var3.a(video, jsonElement, str2);
                                    if (o3VarA10 != null) {
                                        arrayList4.add(o3VarA10);
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                Result.Companion companion5 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                z = z3;
                                th = Result.exceptionOrNull-impl(obj3);
                                if (th != null) {
                                    AtomicLong atomicLong2 = r4.a;
                                    r4.a(th.getClass().getSimpleName());
                                }
                                listEmptyList = CollectionsKt.emptyList();
                                if (Result.isFailure-impl(obj3)) {
                                    obj3 = listEmptyList;
                                }
                                listEmptyList2 = (List) obj3;
                                r35 = z;
                                CollectionsKt.addAll(arrayList3, listEmptyList2);
                                v4Var = v4.a;
                                CollectionsKt.addAll(arrayList3, v4Var.b(video));
                                arrayList = new ArrayList();
                                Triple triple = new Triple("getPlayAddrH264", "video.playAddrH264", 360);
                                Triple triple2 = new Triple("getPlayAddr", "video.playAddr", 340);
                                Triple triple3 = new Triple("getH264PlayAddr", "video.h264PlayAddrLegacy", 320);
                                Triple triple4 = new Triple("getPlayAddrBytevc1", "video.playAddrBytevc1", 300);
                                Triple[] tripleArr = new Triple[4];
                                tripleArr[c2] = triple;
                                tripleArr[r35] = triple2;
                                c3 = 2;
                                tripleArr[2] = triple3;
                                tripleArr[3] = triple4;
                                for (Triple triple5 : CollectionsKt.listOf(tripleArr)) {
                                    o3VarA4 = v4Var.a(video, v4.d(video, (String) triple5.component1()), (String) triple5.component2(), s4.h, dk.c, zc.c, ((Number) triple5.component3()).intValue(), null);
                                    if (o3VarA4 != null) {
                                        arrayList.add(o3VarA4);
                                    }
                                }
                                CollectionsKt.addAll(arrayList3, arrayList);
                                v4Var2 = v4.a;
                                arrayList2 = new ArrayList();
                                listEmptyList4 = (List) se.a(List.class, video, "bitRateAudio");
                                String strDecrypt4 = "video.bitRateAudio";
                                if (listEmptyList4 == null) {
                                    listEmptyList4 = CollectionsKt.emptyList();
                                }
                                it = listEmptyList4.iterator();
                                while (it.hasNext()) {
                                    c3 = c3;
                                    objB4 = se.b(it.next(), "getAudioMeta");
                                    if (objB4 != null) {
                                        arrayList2.add(o3VarA3);
                                    }
                                }
                                char c4 = c3;
                                UrlModel urlModelD2 = v4.d(video, "getPlayAddr");
                                UrlModel urlModelD3 = v4.d(video, "getPlayAddrH264");
                                UrlModel urlModelD4 = v4.d(video, "getPlayAddrBytevc1");
                                UrlModel[] urlModelArr = new UrlModel[3];
                                urlModelArr[c2] = urlModelD2;
                                urlModelArr[r35] = urlModelD3;
                                urlModelArr[c4] = urlModelD4;
                                it2 = CollectionsKt.listOf(urlModelArr).iterator();
                                while (it2.hasNext()) {
                                    listA2 = se.a((UrlModel) it2.next(), "getAudioBitrate");
                                    if (listA2 == null) {
                                        it3 = listA2.iterator();
                                        while (it3.hasNext()) {
                                            objB3 = se.b(it3.next(), "getAudioMeta");
                                            if (objB3 != null) {
                                                it4 = it2;
                                                it5 = it3;
                                                o3VarA2 = v4.a(v4Var2, video, urlModelA, "video.audioBitrate", s4.j, dk.a, zc.d, ci.b, (int) RangesKt.coerceAtMost(v4.b(objB3, "getBitrate"), 2147483647L), 0, 0, 0, v4.c(objB3, "getQuality"), v4.c(objB3, "getCodecType"), v4.c(objB3, "getFormat"), 100, null, null, null, 229376);
                                                if (o3VarA2 != null) {
                                                    it2 = it4;
                                                    it3 = it5;
                                                } else {
                                                    arrayList2.add(o3VarA2);
                                                    it2 = it4;
                                                    it3 = it5;
                                                }
                                            }
                                        }
                                    }
                                }
                                UrlModel urlModelD5 = v4.d(se.b(aweme2, "getMusic"), "getPlayUrl");
                                o3VarA = v4.a(v4Var2, video, urlModelD5, "aweme.music.playUrl", s4.j, dk.a, zc.d, ci.b, 0, 0, 0, 0, "music", v4.c(urlModelD5), null, 20, null, null, null, 229376);
                                if (o3VarA != null) {
                                    arrayList2.add(o3VarA);
                                }
                                CollectionsKt.addAll(arrayList3, arrayList2);
                                v4 v4Var4 = v4.a;
                                CollectionsKt.addAll(arrayList3, v4Var4.a(video));
                                listA = v4Var4.a(arrayList3);
                                objB = se.b(aweme2, "getDownloadWithoutWatermark");
                                if (objB == null) {
                                    objB2 = se.b(aweme2, "isDownloadWithoutWatermark");
                                } else {
                                    objB2 = objB;
                                }
                                AtomicLong atomicLong3 = r4.a;
                                Result.Companion companion6 = Result.Companion;
                                obj4 = Result.constructor-impl(aweme2.aid);
                                if (Result.isFailure-impl(obj4)) {
                                    obj5 = null;
                                } else {
                                    obj5 = obj4;
                                }
                                r4.a(obj5, str, objB2, Integer.valueOf(listA.size()));
                                v4.a("final", listA);
                                if (!listA.isEmpty()) {
                                    for (o3 o3Var : listA) {
                                        if (o3Var.b()) {
                                        }
                                    }
                                }
                                if (!y5.a().z) {
                                    a(p4Var2, aweme2, video, listA, member, objArr);
                                    return r35;
                                }
                                o4 o4Var = o4.a;
                                Function1 function1 = new Function1() {
                                    public final Object invoke(Object obj10) {
                                        return v3.a(listA, p4Var2, member, objArr, (List) obj10);
                                    }
                                };
                                o4Var.getClass();
                                o4.a(aweme2, video, function1);
                                return r35;
                            }
                        }
                        z2 = z3;
                    }
                    listEmptyList3 = arrayList4;
                    z3 = z2;
                }
                obj3 = Result.constructor-impl(listEmptyList3);
                z = z3;
            } catch (Throwable th5) {
                th = th5;
                c2 = 0;
            }
            th = Result.exceptionOrNull-impl(obj3);
            if (th != null) {
                AtomicLong atomicLong4 = r4.a;
                r4.a(th.getClass().getSimpleName());
            }
            listEmptyList = CollectionsKt.emptyList();
            if (Result.isFailure-impl(obj3)) {
                obj3 = listEmptyList;
            }
            listEmptyList2 = (List) obj3;
            r35 = z;
        }
        CollectionsKt.addAll(arrayList3, listEmptyList2);
        v4Var = v4.a;
        CollectionsKt.addAll(arrayList3, v4Var.b(video));
        arrayList = new ArrayList();
        Triple triple6 = new Triple("getPlayAddrH264", "video.playAddrH264", 360);
        Triple triple7 = new Triple("getPlayAddr", "video.playAddr", 340);
        Triple triple8 = new Triple("getH264PlayAddr", "video.h264PlayAddrLegacy", 320);
        Triple triple9 = new Triple("getPlayAddrBytevc1", "video.playAddrBytevc1", 300);
        Triple[] tripleArr2 = new Triple[4];
        tripleArr2[c2] = triple6;
        tripleArr2[r35] = triple7;
        c3 = 2;
        tripleArr2[2] = triple8;
        tripleArr2[3] = triple9;
        while (r4.hasNext()) {
            o3VarA4 = v4Var.a(video, v4.d(video, (String) triple5.component1()), (String) triple5.component2(), s4.h, dk.c, zc.c, ((Number) triple5.component3()).intValue(), null);
            if (o3VarA4 != null) {
                arrayList.add(o3VarA4);
            }
        }
        CollectionsKt.addAll(arrayList3, arrayList);
        v4Var2 = v4.a;
        arrayList2 = new ArrayList();
        listEmptyList4 = (List) se.a(List.class, video, "bitRateAudio");
        String strDecrypt5 = "video.bitRateAudio";
        if (listEmptyList4 == null) {
            listEmptyList4 = CollectionsKt.emptyList();
        }
        it = listEmptyList4.iterator();
        while (it.hasNext()) {
            c3 = c3;
            objB4 = se.b(it.next(), "getAudioMeta");
            if (objB4 != null && (urlModelA2 = v4.a(objB4)) != null && (o3VarA3 = v4.a((v4Var2 = v4Var2), (video = video), urlModelA2, strDecrypt5, s4.j, dk.a, zc.d, ci.b, (int) RangesKt.coerceAtMost(v4.b(objB4, "getBitrate"), 2147483647L), 0, 0, 0, v4.c(objB4, "getQuality"), v4.c(objB4, "getCodecType"), v4.c(objB4, "getFormat"), 150, null, null, null, 229376)) != null) {
                arrayList2.add(o3VarA3);
            }
        }
        char c5 = c3;
        UrlModel urlModelD6 = v4.d(video, "getPlayAddr");
        UrlModel urlModelD7 = v4.d(video, "getPlayAddrH264");
        UrlModel urlModelD8 = v4.d(video, "getPlayAddrBytevc1");
        UrlModel[] urlModelArr2 = new UrlModel[3];
        urlModelArr2[c2] = urlModelD6;
        urlModelArr2[r35] = urlModelD7;
        urlModelArr2[c5] = urlModelD8;
        it2 = CollectionsKt.listOf(urlModelArr2).iterator();
        while (it2.hasNext()) {
            listA2 = se.a((UrlModel) it2.next(), "getAudioBitrate");
            if (listA2 == null) {
                it3 = listA2.iterator();
                while (it3.hasNext()) {
                    objB3 = se.b(it3.next(), "getAudioMeta");
                    if (objB3 != null && (urlModelA = v4.a(objB3)) != null) {
                        it4 = it2;
                        it5 = it3;
                        o3VarA2 = v4.a(v4Var2, video, urlModelA, "video.audioBitrate", s4.j, dk.a, zc.d, ci.b, (int) RangesKt.coerceAtMost(v4.b(objB3, "getBitrate"), 2147483647L), 0, 0, 0, v4.c(objB3, "getQuality"), v4.c(objB3, "getCodecType"), v4.c(objB3, "getFormat"), 100, null, null, null, 229376);
                        if (o3VarA2 != null) {
                            it2 = it4;
                            it3 = it5;
                        } else {
                            arrayList2.add(o3VarA2);
                            it2 = it4;
                            it3 = it5;
                        }
                    }
                }
            }
        }
        UrlModel urlModelD9 = v4.d(se.b(aweme2, "getMusic"), "getPlayUrl");
        o3VarA = v4.a(v4Var2, video, urlModelD9, "aweme.music.playUrl", s4.j, dk.a, zc.d, ci.b, 0, 0, 0, 0, "music", v4.c(urlModelD9), null, 20, null, null, null, 229376);
        if (o3VarA != null) {
            arrayList2.add(o3VarA);
        }
        CollectionsKt.addAll(arrayList3, arrayList2);
        v4 v4Var5 = v4.a;
        CollectionsKt.addAll(arrayList3, v4Var5.a(video));
        listA = v4Var5.a(arrayList3);
        objB = se.b(aweme2, "getDownloadWithoutWatermark");
        if (objB == null) {
            objB2 = se.b(aweme2, "isDownloadWithoutWatermark");
        } else {
            objB2 = objB;
        }
        AtomicLong atomicLong5 = r4.a;
        try {
            Result.Companion companion7 = Result.Companion;
            obj4 = Result.constructor-impl(aweme2.aid);
        } catch (Throwable th6) {
            Result.Companion companion8 = Result.Companion;
            obj4 = Result.constructor-impl(ResultKt.createFailure(th6));
        }
        if (Result.isFailure-impl(obj4)) {
            obj5 = null;
        } else {
            obj5 = obj4;
        }
        r4.a(obj5, str, objB2, Integer.valueOf(listA.size()));
        v4.a("final", listA);
        if (!listA.isEmpty()) {
            while (r0.hasNext()) {
                if (o3Var.b() && o3Var.l >= 1080) {
                    a(p4Var2, listA, member, objArr);
                    return r35;
                }
            }
        }
        if (!y5.a().z) {
            a(p4Var2, aweme2, video, listA, member, objArr);
            return r35;
        }
        o4 o4Var2 = o4.a;
        Function1 function2 = new Function1() {
            public final Object invoke(Object obj10) {
                return v3.a(listA, p4Var2, member, objArr, (List) obj10);
            }
        };
        o4Var2.getClass();
        o4.a(aweme2, video, function2);
        return r35;
    }

    public static void a(p4 p4Var, o3 o3Var, List list, Member member, Object[] objArr) {
        Object obj = null;
        if (o3Var.c == s4.g) {
            AtomicLong atomicLong = r4.a;
            r4.a(Long.valueOf(p4Var.a), o3Var.b);
            for (Object obj2 : list) {
                o3 o3Var2 = (o3) obj2;
                if (o3Var2.c != s4.g && !o3Var2.c() && !o3Var2.b()) {
                    obj = obj2;
                    break;
                }
            }
            o3 o3Var3 = (o3) obj;
            ExecutorService executorService = ie.a;
            ie.a(p4Var, o3Var, o3Var3 != null, new t3(o3Var3, p4Var, member, objArr));
            return;
        }
        if (o3Var.c()) {
            AtomicLong atomicLong2 = r4.a;
            r4.a(Long.valueOf(p4Var.a));
            for (Object obj3 : list) {
                o3 o3Var4 = (o3) obj3;
                if (o3Var4.c != s4.g && !o3Var4.c() && !o3Var4.b()) {
                    obj = obj3;
                    break;
                }
            }
            o3 o3Var5 = (o3) obj;
            ExecutorService executorService2 = k3.a;
            k3.a(p4Var, o3Var, o3Var5 != null, new u3(o3Var5, p4Var, member, objArr));
            return;
        }
        a(o3Var, p4Var, member, objArr);
    }

    public static final Unit a(List list, p4 p4Var, Member member, Object[] objArr, List list2) {
        List[] listArr = {list, list2};
        v4 v4Var = v4.a;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            CollectionsKt.addAll(arrayList, listArr[i2]);
        }
        List listA = v4Var.a(arrayList);
        v4.a("merged", listA);
        a(p4Var, listA, member, objArr);
        return Unit.INSTANCE;
    }

    public static void a(p4 p4Var, final List list, Member member, Object[] objArr) {
        if (list.isEmpty()) {
            AtomicLong atomicLong = r4.a;
            r4.a(Long.valueOf(p4Var.a));
            a((o3) null, p4Var, member, objArr);
            return;
        }
        if (y5.a().z) {
            a(p4Var, (o3) CollectionsKt.first(list), list, member, objArr);
            return;
        }
        m4 m4Var = m4.a;
        Context contextA = a(p4Var);
        p3 p3Var = new p3(new AtomicBoolean(false), p4Var, new Function0() {
            public final Object invoke() {
                return v3.a(list);
            }
        }, member, objArr);
        m4Var.a(contextA, new i4(list), p3Var);
    }

    public static void a(p4 p4Var, final Aweme aweme, final Video video, final List list, Member member, Object[] objArr) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = list;
        p3 p3Var = new p3(new AtomicBoolean(false), p4Var, new Function0() {
            public final Object invoke() {
                return v3.a(objectRef);
            }
        }, member, objArr);
        m4 m4Var = m4.a;
        Context contextA = a(p4Var);
        g4 g4Var = new g4() {
            @Override
            public final void a(f4 f4Var) {
                v3.a(aweme, video, objectRef, list, f4Var);
            }
        };
        m4Var.a(contextA, new h4(g4Var), p3Var);
    }

    public static final List a(Ref.ObjectRef objectRef) {
        return (List) objectRef.element;
    }

    public static final void a(Aweme aweme, Video video, final Ref.ObjectRef objectRef, final List list, final f4 f4Var) {
        o4 o4Var = o4.a;
        Function1 function1 = new Function1() {
            public final Object invoke(Object obj) {
                return v3.a(objectRef, list, f4Var, (List) obj);
            }
        };
        o4Var.getClass();
        o4.a(aweme, video, function1);
    }

    public static final Unit a(Ref.ObjectRef objectRef, List list, f4 f4Var, List list2) {
        List[] listArr = {list, list2};
        v4 v4Var = v4.a;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            CollectionsKt.addAll(arrayList, listArr[i2]);
        }
        List listA = v4Var.a(arrayList);
        v4.a("merged", listA);
        objectRef.element = listA;
        f4Var.a(listA);
        return Unit.INSTANCE;
    }

    public static Context a(p4 p4Var) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Field field = e;
            if (field == null) {
                field = null;
            }
            Object obj2 = field.get(p4Var.b);
            obj = Result.constructor-impl(obj2 instanceof Context ? (Context) obj2 : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Context) (Result.isFailure-impl(obj) ? null : obj);
    }

    public static void a(o3 o3Var, p4 p4Var, final Member member, final Object[] objArr) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            if (o3Var != null && !a(p4Var, o3Var)) {
                g7.a(4, g7.a("Download selection rejected; restoring official flow", new Object[0]), (Throwable) null);
            }
            AtomicLong atomicLong = r4.a;
            obj = Result.constructor-impl(r4.a(p4Var, new Function0() {
                public final Object invoke() {
                    return v3.a(member, objArr);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Selected download start failed", new Object[0]), th2);
            r4.a(p4Var);
        }
        if (Result.isSuccess-impl(obj)) {
            b(p4Var);
        }
    }

    public static final Object a(Member member, Object[] objArr) {
        a.set(Boolean.TRUE);
        try {
            return HookBridge.invokeOriginalMethod(member, (Object) null, Arrays.copyOf(objArr, objArr.length));
        } finally {
            a.remove();
        }
    }

    public static void a() throws NoSuchFieldException, ClassNotFoundException {
        e9 e9Var = o8.a;
        Class<?> cls = Class.forName("X.1Qt6");
        Field fieldA = o8.a.a(cls);
        e9 e9Var2 = q7.a;
        Class cls2 = d;
        if (cls2 == null) {
            cls2 = null;
        }
        Field fieldA2 = e9Var2.a(cls2);
        String str = o8.b.c[0];
        HookBridge.hookAllMethods(cls, str, new v3$before$3(fieldA, fieldA2));
    }

    public static String a(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            Charset charset = StandardCharsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            byte[] bArrDigest = messageDigest.digest(bytes);
            obj = Result.constructor-impl(ArraysKt.joinToString$default(bArrDigest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() {
                public final Object invoke(Object obj2) {
                    return v3.a(((Byte) obj2).byteValue());
                }
            }, 30, (Object) null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    public static final CharSequence a(byte b2) {
        String str = String.format(Locale.US, "%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b2 & 255)}, 1));
        return str;
    }
}
