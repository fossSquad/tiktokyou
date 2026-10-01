package Z;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.Video;
import com.windukk.hook.HookBridge;
import Z.DownloadMediaStoreHooks;
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

public abstract class i3 {
    public static final ThreadLocal a = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return i3.e();
        }
    });
    public static final Lazy b = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return i3.f();
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

    public static void b(final a4 a4Var) {
        ((Handler) b.getValue()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                i3.c(a4Var);
            }
        }, 300000L);
    }

    public static void c() throws ClassNotFoundException {
        p8 p8Var = r6.a;
        Class<?> cls = Class.forName("com.ss.android.ugc.trill.download.configuration.AwemeVideoDownloadConfiguration", false, i3.class.getClassLoader());
        String str = r6.a.c[0];
        HookBridge.hookAllMethods(cls, str, new i3$before$1());
        h6.a(4, h6.a("Hooked session-scoped AwemeVideo WaterMarkAbility", new Object[0]), (Throwable) null);
    }

    public static final void d() {
        Object obj;
        Object obj2;
        Object obj3 = null;
        Object obj4;
        Object obj5;
        try {
            Result.Companion companion = Result.Companion;
            g();
            obj = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Download model mappings unavailable", new Object[0]), th2);
            return;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            b();
            obj2 = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th3));
        }
        Throwable th4 = RCompat.m9exceptionOrNullimpl(obj2);
        if (th4 != null) {
            h6.a(6, h6.a("Download factory quality picker unavailable", new Object[0]), th4);
        }
        try {
            Result.Companion companion5 = Result.Companion;
            c();
            obj3 = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion6 = Result.Companion;
            obj3 = RCompat.m6constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable th6 = RCompat.m9exceptionOrNullimpl(obj3);
        if (th6 != null) {
            h6.a(6, h6.a("Session watermark bypass unavailable", new Object[0]), th6);
        }
        try {
            Result.Companion companion7 = Result.Companion;
            a();
            obj4 = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th7) {
            Result.Companion companion8 = Result.Companion;
            obj4 = RCompat.m6constructorimpl(ResultKt.createFailure(th7));
        }
        Throwable th8 = RCompat.m9exceptionOrNullimpl(obj4);
        if (th8 != null) {
            h6.a(6, h6.a("Download ability compatibility monitor unavailable", new Object[0]), th8);
        }
        try {
            Result.Companion companion9 = Result.Companion;
            AtomicBoolean atomicBoolean = DownloadMediaStoreHooks.c;
            DownloadMediaStoreHooks.a();
            obj5 = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th9) {
            Result.Companion companion10 = Result.Companion;
            obj5 = RCompat.m6constructorimpl(ResultKt.createFailure(th9));
        }
        Throwable th10 = RCompat.m9exceptionOrNullimpl(obj5);
        if (th10 != null) {
            h6.a(6, h6.a("Download MediaStore hook unavailable", new Object[0]), th10);
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
        z7 z7Var = s7.a;
        Class<?> cls = Class.forName("X.1644");
        c = cls;
        z7 z7Var2 = p6.a;
        Class<?> cls2 = Class.forName("com.ss.android.ugc.trill.download.protocol.download.AwemeVideoDownloadAbilityProtocol");
        d = cls2;
        z7 z7Var3 = v7.a;
        Class<?> cls3 = Class.forName("X.162B");
        z7 z7Var4 = r7.a;
        Class<?> cls4 = Class.forName("X.167M");
        z7 z7Var5 = s7.a;
        Class cls5 = c;
        if (cls5 == null) {
            cls5 = null;
        }
        Field fieldA = z7Var5.a(cls5);
        e = fieldA;
        z7 z7Var6 = s7.d;
        Class cls6 = c;
        if (cls6 == null) {
            cls6 = null;
        }
        Field fieldA2 = z7Var6.a(cls6);
        f = fieldA2;
        Field fieldA3 = r7.a.a(cls4);
        g = fieldA3;
        Field fieldA4 = v7.a.a(cls3);
        h = fieldA4;
        Field fieldA5 = v7.b.a(cls3);
        i = fieldA5;
        z7 z7Var7 = s7.c;
        Class cls7 = c;
        if (cls7 == null) {
            cls7 = null;
        }
        Field fieldA6 = z7Var7.a(cls7);
        j = fieldA6;
        z7 z7Var8 = s7.b;
        Class cls8 = c;
        if (cls8 == null) {
            cls8 = null;
        }
        Field fieldA7 = z7Var8.a(cls8);
        k = fieldA7;
        try {
            Result.Companion companion = Result.Companion;
            obj = RCompat.m6constructorimpl(v7.c.a(cls3));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        l = (Field) (RCompat.m12isFailureimpl(obj) ? null : obj);
    }

    public static boolean a(a4 a4Var, b3 b3Var) throws IllegalAccessException {
        String str;
        Object obj;
        String strA;
        String str2;
        String str3;
        UrlModel urlModel = b3Var.a;
        List list = urlModel.urlList;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Object obj2 = a4Var.b;
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
                p8 p8Var = u7.a;
                Object objInvoke = u7.a.a(Class.forName("X.0Dhi", false, i3.class.getClassLoader()), String.class).invoke(null, str);
                String str6 = objInvoke instanceof String ? (String) objInvoke : null;
                if (str6 == null || StringsKt.isBlank(str6)) {
                    str6 = null;
                }
                obj = RCompat.m6constructorimpl(str6);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
            }
            if (RCompat.m12isFailureimpl(obj)) {
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
        if (b3Var.b()) {
            Field field5 = k;
            if (field5 == null) {
                field5 = null;
            }
            field5.set(obj2, b3Var.a());
        }
        AtomicLong atomicLong = c4.a;
        a4Var.g = b3Var;
        a4Var.h = strA;
        ConcurrentHashMap concurrentHashMap = c4.d;
        long j2 = a4Var.a;
        boolean zB = b3Var.b();
        b3 b3Var2 = b3Var.b() ? b3Var : null;
        String strA2 = b3Var2 != null ? b3Var2.a() : null;
        b3 b3Var3 = b3Var.b() ? b3Var : null;
        if (b3Var3 != null) {
            strDecrypt = (Intrinsics.areEqual(b3Var3.a(), ".mp3") ? "audio/mpeg" : "audio/mp4");
        }
        concurrentHashMap.put(strA, new b4(j2, strA, zB, strA2, strDecrypt));
        Z.c4.a(Long.valueOf(a4Var.a), b3Var.b, b3Var.d, b3Var.e, b3Var.f, strA);
        UrlModel urlModel2 = a4Var.d;
        UrlModel urlModel3 = b3Var.a;
        if (urlModel3 != null && urlModel2 != null) {
            Intrinsics.areEqual(g4.a(urlModel3), g4.a(urlModel2));
        }
        g4.b(b3Var.a);
        return true;
    }

    public static void b() throws ClassNotFoundException {
        p8 p8Var = q7.a;
        Class<?> cls = Class.forName("X.1OdR");
        String str = q7.a.c[0];
        HookBridge.hookAllMethods(cls, str, new i3$before$2());
        h6.a(4, h6.a("Hooked download factory quality picker (session scoped)", new Object[0]), (Throwable) null);
    }

    public static final void c(a4 a4Var) {
        Z.c4.a(a4Var);
    }

    public static boolean a(Object obj, final Member member, final Object[] objArr) throws IllegalAccessException {
        Video video;
        UrlModel urlModel;
        String str;
        Object obj2;
        boolean zAreEqual;
        char c2;
        Object obj3 = null;
        boolean z = false;
        Throwable th;
        List listEmptyList;
        List listEmptyList2;
        boolean z2;
        List listEmptyList3;
        String string;
        boolean r35;
        g4 g4Var;
        ArrayList arrayList;
        char c3;
        g4 g4Var2;
        ArrayList arrayList2;
        List listEmptyList4;
        Iterator it;
        Iterator it2;
        b3 b3VarA;
        List<b3> listA;
        Object objB;
        Object objB2;
        Object obj4;
        Object obj5;
        List listA2;
        Iterator it3;
        Object objB3;
        UrlModel urlModelA = null;
        Iterator it4;
        Iterator it5;
        b3 b3VarA2;
        Object objB4;
        UrlModel urlModelA2;
        b3 b3VarA3 = null;
        b3 b3VarA4;
        AtomicBoolean atomicBoolean;
        Map map = c4.b;
        a4 a4Var = (a4) map.get(obj);
        boolean z3 = true;
        if (a4Var != null && (atomicBoolean = a4Var.f) != null && atomicBoolean.get()) {
            return false;
        }
        Field field = g;
        if (field == null) {
            field = null;
        }
        Object obj6 = field.get(obj);
        Aweme aweme = obj6 instanceof Aweme ? (Aweme) obj6 : null;
        if (aweme == null || (video = aweme.video) == null) {
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
        final a4 a4Var2 = new a4(c4.a.getAndIncrement(), obj, aweme2, urlModel2, str);
        map.put(obj, a4Var2);
        Long lValueOf = Long.valueOf(a4Var2.a);
        try {
            Result.Companion companion = Result.Companion;
            String strDecrypt = aweme2.aid;
            if (strDecrypt == null) {
                strDecrypt = "unknown";
            }
            obj2 = RCompat.m6constructorimpl(strDecrypt);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th2));
        }
        String strDecrypt2 = "unknown";
        if (RCompat.m12isFailureimpl(obj2)) {
            obj2 = strDecrypt2;
        }
        Z.c4.a(lValueOf, (String) obj2, str, g4.b(urlModel2));
        if (!a4Var2.f.compareAndSet(false, true)) {
            return false;
        }
        ArrayList arrayList3 = new ArrayList();
        g4 g4Var3 = g4.a;
        UrlModel urlModelD = g4.d(video, "getDownloadNoWatermarkAddr");
        String strDecrypt3 = "official.selected";
        d4 d4Var = d4.a;
        if (urlModel2 == null || urlModelD == null) {
            zAreEqual = urlModel2 == urlModelD;
        } else {
            zAreEqual = Intrinsics.areEqual(g4.a(urlModel2), g4.a(urlModelD));
        }
        sg sgVar = zAreEqual ? sg.a : sg.c;
        lb lbVar = lb.b;
        b3 b3VarA5 = g4Var3.a(video, urlModel2, strDecrypt3, d4Var, sgVar, lbVar, 930, null);
        if (b3VarA5 != null) {
            arrayList3.add(b3VarA5);
        }
        b3 b3VarA6 = g4Var3.a(video, urlModelD, "video.downloadNoWatermarkAddr", d4.b, sg.a, lbVar, 920, null);
        if (b3VarA6 != null) {
            arrayList3.add(b3VarA6);
        }
        b3 b3VarA7 = g4Var3.a(video, g4.d(video, "getDownloadAddr"), "video.downloadAddr", d4.c, sg.b, lbVar, 900, null);
        if (b3VarA7 != null) {
            arrayList3.add(b3VarA7);
        }
        b3 b3VarA8 = g4Var3.a(video, g4.d(video, "getNewDownloadAddr"), "video.newDownloadAddr", d4.d, sg.c, lbVar, 890, null);
        if (b3VarA8 != null) {
            arrayList3.add(b3VarA8);
        }
        String strC = g4.c(video, "getMiscDownloadAddrs");
        String string2 = strC != null ? StringsKt.trim(strC).toString() : null;
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() == 0) {
            listEmptyList2 = CollectionsKt.emptyList();
            c2 = 0;
            r35 = true;
        } else {
            try {
                Result.Companion companion3 = Result.Companion;
                JsonObject jsonObjectB = (JsonObject) f6.b(string2);
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
                            obj3 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
                            z = z3;
                        }
                    }
                    ArrayList arrayList4 = new ArrayList();
                    if (g4.a(jsonObject) && str == null) {
                        b3 b3VarA9 = g4Var3.a(video, (JsonElement) jsonObject, (String) null);
                        if (b3VarA9 != null) {
                            arrayList4.add(b3VarA9);
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
                                    AtomicLong atomicLong = c4.a;
                                    Z.c4.a(str2);
                                } else {
                                    b3 b3VarA10 = g4Var3.a(video, jsonElement, str2);
                                    if (b3VarA10 != null) {
                                        arrayList4.add(b3VarA10);
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                Result.Companion companion5 = Result.Companion;
                                obj3 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
                                z = z3;
                                th = RCompat.m9exceptionOrNullimpl(obj3);
                                if (th != null) {
                                    AtomicLong atomicLong2 = c4.a;
                                    Z.c4.a(th.getClass().getSimpleName());
                                }
                                listEmptyList = CollectionsKt.emptyList();
                                if (RCompat.m12isFailureimpl(obj3)) {
                                    obj3 = listEmptyList;
                                }
                                listEmptyList2 = (List) obj3;
                                r35 = z;
                                CollectionsKt.addAll(arrayList3, listEmptyList2);
                                g4Var = g4.a;
                                CollectionsKt.addAll(arrayList3, g4Var.b(video));
                                arrayList = new ArrayList();
                                Triple triple = new Triple("getPlayAddrH264", "video.playAddrH264", 360);
                                Triple triple2 = new Triple("getPlayAddr", "video.playAddr", 340);
                                Triple triple3 = new Triple("getH264PlayAddr", "video.h264PlayAddrLegacy", 320);
                                Triple triple4 = new Triple("getPlayAddrBytevc1", "video.playAddrBytevc1", 300);
                                Triple[] tripleArr = new Triple[4];
                                tripleArr[c2] = triple;
                                tripleArr[r35 ? 1 : 0] = triple2;
                                c3 = 2;
                                tripleArr[2] = triple3;
                                tripleArr[3] = triple4;
                                for (Triple triple5 : CollectionsKt.listOf(tripleArr)) {
                                    b3VarA4 = g4Var.a(video, g4.d(video, (String) triple5.component1()), (String) triple5.component2(), d4.h, sg.c, lb.c, ((Number) triple5.component3()).intValue(), null);
                                    if (b3VarA4 != null) {
                                        arrayList.add(b3VarA4);
                                    }
                                }
                                CollectionsKt.addAll(arrayList3, arrayList);
                                g4Var2 = g4.a;
                                arrayList2 = new ArrayList();
                                listEmptyList4 = (List) dd.a(video, "bitRateAudio", List.class);
                                String strDecrypt4 = "video.bitRateAudio";
                                if (listEmptyList4 == null) {
                                    listEmptyList4 = CollectionsKt.emptyList();
                                }
                                it = listEmptyList4.iterator();
                                while (it.hasNext()) {
                                    c3 = c3;
                                    objB4 = dd.b(it.next(), "getAudioMeta");
                                    if (objB4 != null) {
                                        arrayList2.add(b3VarA3);
                                    }
                                }
                                char c4 = c3;
                                UrlModel urlModelD2 = g4.d(video, "getPlayAddr");
                                UrlModel urlModelD3 = g4.d(video, "getPlayAddrH264");
                                UrlModel urlModelD4 = g4.d(video, "getPlayAddrBytevc1");
                                UrlModel[] urlModelArr = new UrlModel[3];
                                urlModelArr[c2] = urlModelD2;
                                urlModelArr[r35 ? 1 : 0] = urlModelD3;
                                urlModelArr[c4] = urlModelD4;
                                it2 = CollectionsKt.listOf(urlModelArr).iterator();
                                while (it2.hasNext()) {
                                    listA2 = dd.a((UrlModel) it2.next(), "getAudioBitrate");
                                    if (listA2 == null) {
                                        it3 = listA2.iterator();
                                        while (it3.hasNext()) {
                                            objB3 = dd.b(it3.next(), "getAudioMeta");
                                            if (objB3 != null) {
                                                it4 = it2;
                                                it5 = it3;
                                                b3VarA2 = g4.a(g4Var2, video, urlModelA, "video.audioBitrate", d4.j, sg.a, lb.d, jg.b, (int) RangesKt.coerceAtMost(g4.b(objB3, "getBitrate"), 2147483647L), 0, 0, 0, g4.c(objB3, "getQuality"), g4.c(objB3, "getCodecType"), g4.c(objB3, "getFormat"), 100, null, null, null, 229376);
                                                if (b3VarA2 != null) {
                                                    it2 = it4;
                                                    it3 = it5;
                                                } else {
                                                    arrayList2.add(b3VarA2);
                                                    it2 = it4;
                                                    it3 = it5;
                                                }
                                            }
                                        }
                                    }
                                }
                                UrlModel urlModelD5 = g4.d(dd.b(aweme2, "getMusic"), "getPlayUrl");
                                b3VarA = g4.a(g4Var2, video, urlModelD5, "aweme.music.playUrl", d4.j, sg.a, lb.d, jg.b, 0, 0, 0, 0, "music", g4.c(urlModelD5), null, 20, null, null, null, 229376);
                                if (b3VarA != null) {
                                    arrayList2.add(b3VarA);
                                }
                                CollectionsKt.addAll(arrayList3, arrayList2);
                                g4 g4Var4 = g4.a;
                                CollectionsKt.addAll(arrayList3, g4Var4.a(video));
                                listA = g4Var4.a(arrayList3);
                                objB = dd.b(aweme2, "getDownloadWithoutWatermark");
                                if (objB == null) {
                                    objB2 = dd.b(aweme2, "isDownloadWithoutWatermark");
                                } else {
                                    objB2 = objB;
                                }
                                AtomicLong atomicLong3 = Z.c4.a;
                                Result.Companion companion6 = Result.Companion;
                                obj4 = RCompat.m6constructorimpl(aweme2.aid);
                                if (RCompat.m12isFailureimpl(obj4)) {
                                    obj5 = null;
                                } else {
                                    obj5 = obj4;
                                }
                                Z.c4.a(obj5, str, objB2, Integer.valueOf(listA.size()));
                                g4.a("final", listA);
                                if (!listA.isEmpty()) {
                                    for (b3 b3Var : listA) {
                                        if (b3Var.b()) {
                                        }
                                    }
                                }
                                if (!d5.a().u) {
                                    a(a4Var2, aweme2, video, listA, member, objArr);
                                    return r35;
                                }
                                z3 z3Var = Z.z3.a;
                                final List listAF = listA;
                                Function1 function1 = new Function1() {
                                    public final Object invoke(Object obj10) {
                                        return i3.a(listAF, a4Var2, member, objArr, (List) obj10);
                                    }
                                };
                                z3Var.getClass();
                                Z.z3.a(aweme2, video, function1);
                                return r35;
                            }
                        }
                        z2 = z3;
                    }
                    listEmptyList3 = arrayList4;
                    z3 = z2;
                }
                obj3 = RCompat.m6constructorimpl(listEmptyList3);
                z = z3;
            } catch (Throwable th5) {
                th = th5;
                c2 = 0;
            }
            th = RCompat.m9exceptionOrNullimpl(obj3);
            if (th != null) {
                AtomicLong atomicLong4 = c4.a;
                Z.c4.a(th.getClass().getSimpleName());
            }
            listEmptyList = CollectionsKt.emptyList();
            if (RCompat.m12isFailureimpl(obj3)) {
                obj3 = listEmptyList;
            }
            listEmptyList2 = (List) obj3;
            r35 = z;
        }
        CollectionsKt.addAll(arrayList3, listEmptyList2);
        g4Var = g4.a;
        CollectionsKt.addAll(arrayList3, g4Var.b(video));
        arrayList = new ArrayList();
        Triple triple6 = new Triple("getPlayAddrH264", "video.playAddrH264", 360);
        Triple triple7 = new Triple("getPlayAddr", "video.playAddr", 340);
        Triple triple8 = new Triple("getH264PlayAddr", "video.h264PlayAddrLegacy", 320);
        Triple triple9 = new Triple("getPlayAddrBytevc1", "video.playAddrBytevc1", 300);
        Triple[] tripleArr2 = new Triple[4];
        tripleArr2[c2] = triple6;
        tripleArr2[r35 ? 1 : 0] = triple7;
        c3 = 2;
        tripleArr2[2] = triple8;
        tripleArr2[3] = triple9;
        for (Triple triple5 : CollectionsKt.listOf(tripleArr2)) {
            b3VarA4 = g4Var.a(video, g4.d(video, (String) triple5.component1()), (String) triple5.component2(), d4.h, sg.c, lb.c, ((Number) triple5.component3()).intValue(), null);
            if (b3VarA4 != null) {
                arrayList.add(b3VarA4);
            }
        }
        CollectionsKt.addAll(arrayList3, arrayList);
        g4Var2 = g4.a;
        arrayList2 = new ArrayList();
        listEmptyList4 = (List) dd.a(video, "bitRateAudio", List.class);
        String strDecrypt5 = "video.bitRateAudio";
        if (listEmptyList4 == null) {
            listEmptyList4 = CollectionsKt.emptyList();
        }
        it = listEmptyList4.iterator();
        while (it.hasNext()) {
            c3 = c3;
            objB4 = dd.b(it.next(), "getAudioMeta");
            if (objB4 != null && (urlModelA2 = g4.a(objB4)) != null && (b3VarA3 = g4.a((g4Var2 = g4Var2), (video = video), urlModelA2, strDecrypt5, d4.j, sg.a, lb.d, jg.b, (int) RangesKt.coerceAtMost(g4.b(objB4, "getBitrate"), 2147483647L), 0, 0, 0, g4.c(objB4, "getQuality"), g4.c(objB4, "getCodecType"), g4.c(objB4, "getFormat"), 150, null, null, null, 229376)) != null) {
                arrayList2.add(b3VarA3);
            }
        }
        char c5 = c3;
        UrlModel urlModelD6 = g4.d(video, "getPlayAddr");
        UrlModel urlModelD7 = g4.d(video, "getPlayAddrH264");
        UrlModel urlModelD8 = g4.d(video, "getPlayAddrBytevc1");
        UrlModel[] urlModelArr2 = new UrlModel[3];
        urlModelArr2[c2] = urlModelD6;
        urlModelArr2[r35 ? 1 : 0] = urlModelD7;
        urlModelArr2[c5] = urlModelD8;
        it2 = CollectionsKt.listOf(urlModelArr2).iterator();
        while (it2.hasNext()) {
            listA2 = dd.a((UrlModel) it2.next(), "getAudioBitrate");
            if (listA2 == null) {
                it3 = listA2.iterator();
                while (it3.hasNext()) {
                    objB3 = dd.b(it3.next(), "getAudioMeta");
                    if (objB3 != null && (urlModelA = g4.a(objB3)) != null) {
                        it4 = it2;
                        it5 = it3;
                        b3VarA2 = g4.a(g4Var2, video, urlModelA, "video.audioBitrate", d4.j, sg.a, lb.d, jg.b, (int) RangesKt.coerceAtMost(g4.b(objB3, "getBitrate"), 2147483647L), 0, 0, 0, g4.c(objB3, "getQuality"), g4.c(objB3, "getCodecType"), g4.c(objB3, "getFormat"), 100, null, null, null, 229376);
                        if (b3VarA2 != null) {
                            it2 = it4;
                            it3 = it5;
                        } else {
                            arrayList2.add(b3VarA2);
                            it2 = it4;
                            it3 = it5;
                        }
                    }
                }
            }
        }
        UrlModel urlModelD9 = g4.d(dd.b(aweme2, "getMusic"), "getPlayUrl");
        b3VarA = g4.a(g4Var2, video, urlModelD9, "aweme.music.playUrl", d4.j, sg.a, lb.d, jg.b, 0, 0, 0, 0, "music", g4.c(urlModelD9), null, 20, null, null, null, 229376);
        if (b3VarA != null) {
            arrayList2.add(b3VarA);
        }
        CollectionsKt.addAll(arrayList3, arrayList2);
        g4 g4Var5 = g4.a;
        CollectionsKt.addAll(arrayList3, g4Var5.a(video));
        listA = g4Var5.a(arrayList3);
        objB = dd.b(aweme2, "getDownloadWithoutWatermark");
        if (objB == null) {
            objB2 = dd.b(aweme2, "isDownloadWithoutWatermark");
        } else {
            objB2 = objB;
        }
        AtomicLong atomicLong5 = c4.a;
        try {
            Result.Companion companion7 = Result.Companion;
            obj4 = RCompat.m6constructorimpl(aweme2.aid);
        } catch (Throwable th6) {
            Result.Companion companion8 = Result.Companion;
            obj4 = RCompat.m6constructorimpl(ResultKt.createFailure(th6));
        }
        if (RCompat.m12isFailureimpl(obj4)) {
            obj5 = null;
        } else {
            obj5 = obj4;
        }
        Z.c4.a(obj5, str, objB2, Integer.valueOf(listA.size()));
        g4.a("final", listA);
        if (!listA.isEmpty()) {
            for (b3 b3Var : listA) {
                if (b3Var.b() && b3Var.l >= 1080) {
                    a(a4Var2, listA, member, objArr);
                    return r35;
                }
            }
        }
        if (!d5.a().u) {
            a(a4Var2, aweme2, video, listA, member, objArr);
            return r35;
        }
        z3 z3Var2 = Z.z3.a;
        final List listAF = listA;
        Function1 function2 = new Function1() {
            public final Object invoke(Object obj10) {
                return i3.a(listAF, a4Var2, member, objArr, (List) obj10);
            }
        };
        z3Var2.getClass();
        Z.z3.a(aweme2, video, function2);
        return r35;
    }

    public static void a(a4 a4Var, b3 b3Var, List list, Member member, Object[] objArr) {
        Object obj = null;
        if (b3Var.c == d4.g) {
            AtomicLong atomicLong = c4.a;
            Z.c4.a(Long.valueOf(a4Var.a), b3Var.b);
            for (Object obj2 : list) {
                b3 b3Var2 = (b3) obj2;
                if (b3Var2.c != d4.g && !b3Var2.c() && !b3Var2.b()) {
                    obj = obj2;
                    break;
                }
            }
            b3 b3Var3 = (b3) obj;
            ExecutorService executorService = tc.a;
            tc.a(a4Var, b3Var, b3Var3 != null, new g3(b3Var3, a4Var, member, objArr));
            return;
        }
        if (b3Var.c()) {
            AtomicLong atomicLong2 = c4.a;
            Z.c4.a(Long.valueOf(a4Var.a));
            for (Object obj3 : list) {
                b3 b3Var4 = (b3) obj3;
                if (b3Var4.c != d4.g && !b3Var4.c() && !b3Var4.b()) {
                    obj = obj3;
                    break;
                }
            }
            b3 b3Var5 = (b3) obj;
            ExecutorService executorService2 = y2.a;
            y2.a(a4Var, b3Var, b3Var5 != null, new h3(b3Var5, a4Var, member, objArr));
            return;
        }
        a(b3Var, a4Var, member, objArr);
    }

    public static final Unit a(List list, a4 a4Var, Member member, Object[] objArr, List list2) {
        List[] listArr = {list, list2};
        g4 g4Var = g4.a;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            CollectionsKt.addAll(arrayList, listArr[i2]);
        }
        List listA = g4Var.a(arrayList);
        g4.a("merged", listA);
        a(a4Var, listA, member, objArr);
        return Unit.INSTANCE;
    }

    public static void a(a4 a4Var, final List list, Member member, Object[] objArr) {
        if (list.isEmpty()) {
            AtomicLong atomicLong = c4.a;
            Z.c4.a(Long.valueOf(a4Var.a));
            a((b3) null, a4Var, member, objArr);
            return;
        }
        if (d5.a().u) {
            a(a4Var, (b3) CollectionsKt.first(list), list, member, objArr);
            return;
        }
        x3 x3Var = x3.a;
        Context contextA = a(a4Var);
        c3 c3Var = new c3(new AtomicBoolean(false), a4Var, new Function0() {
            public final Object invoke() {
                return i3.a(list);
            }
        }, member, objArr);
        x3Var.a(contextA, new r3(list), c3Var);
    }

    public static void a(a4 a4Var, final Aweme aweme, final Video video, final List list, Member member, Object[] objArr) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = list;
        c3 c3Var = new c3(new AtomicBoolean(false), a4Var, new Function0() {
            public final Object invoke() {
                return i3.a(objectRef);
            }
        }, member, objArr);
        x3 x3Var = x3.a;
        Context contextA = a(a4Var);
        p3 p3Var = new p3() {
            @Override
            public final void a(o3 o3Var) {
                i3.a(aweme, video, objectRef, list, o3Var);
            }
        };
        x3Var.a(contextA, new q3(p3Var), c3Var);
    }

    public static final List a(Ref.ObjectRef objectRef) {
        return (List) objectRef.element;
    }

    public static final void a(Aweme aweme, Video video, final Ref.ObjectRef objectRef, final List list, final o3 o3Var) {
        z3 z3Var = Z.z3.a;
        Function1 function1 = new Function1() {
            public final Object invoke(Object obj) {
                return i3.a(objectRef, list, o3Var, (List) obj);
            }
        };
        z3Var.getClass();
        z3.a(aweme, video, function1);
    }

    public static final Unit a(Ref.ObjectRef objectRef, List list, o3 o3Var, List list2) {
        List[] listArr = {list, list2};
        g4 g4Var = g4.a;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            CollectionsKt.addAll(arrayList, listArr[i2]);
        }
        List listA = g4Var.a(arrayList);
        g4.a("merged", listA);
        objectRef.element = listA;
        o3Var.a(listA);
        return Unit.INSTANCE;
    }

    public static Context a(a4 a4Var) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Field field = e;
            if (field == null) {
                field = null;
            }
            Object obj2 = field.get(a4Var.b);
            obj = RCompat.m6constructorimpl(obj2 instanceof Context ? (Context) obj2 : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        return (Context) (RCompat.m12isFailureimpl(obj) ? null : obj);
    }

    public static void a(b3 b3Var, a4 a4Var, final Member member, final Object[] objArr) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            if (b3Var != null && !a(a4Var, b3Var)) {
                h6.a(4, h6.a("Download selection rejected; restoring official flow", new Object[0]), (Throwable) null);
            }
            AtomicLong atomicLong = c4.a;
            obj = RCompat.m6constructorimpl(Z.c4.a(a4Var, new Function0() {
                public final Object invoke() {
                    return i3.a(member, objArr);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Selected download start failed", new Object[0]), th2);
            Z.c4.a(a4Var);
        }
        if (RCompat.m13isSuccessimpl(obj)) {
            b(a4Var);
        }
    }

    public static final Object a(Member member, Object[] objArr) {
        a.set(Boolean.TRUE);
        try {
            try {
                return HookBridge.invokeOriginalMethod(member, (Object) null, Arrays.copyOf(objArr, objArr.length));
            } catch (IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } finally {
            a.remove();
        }
    }

    public static void a() throws NoSuchFieldException, ClassNotFoundException {
        z7 z7Var = p7.a;
        Class<?> cls = Class.forName("X.1OdW");
        Field fieldA = p7.a.a(cls);
        z7 z7Var2 = p6.a;
        Class cls2 = d;
        if (cls2 == null) {
            cls2 = null;
        }
        Field fieldA2 = z7Var2.a(cls2);
        String str = p7.b.c[0];
        HookBridge.hookAllMethods(cls, str, new i3$before$3(fieldA, fieldA2));
    }

    public static String a(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            Charset charset = StandardCharsets.UTF_8;
            byte[] bytes = str.getBytes(charset);
            byte[] bArrDigest = messageDigest.digest(bytes);
            obj = RCompat.m6constructorimpl(ArraysKt.joinToString$default(bArrDigest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() {
                public final Object invoke(Object obj2) {
                    return i3.a(((Byte) obj2).byteValue());
                }
            }, 30, (Object) null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    public static final CharSequence a(byte b2) {
        String str = String.format(Locale.US, "%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b2 & 255)}, 1));
        return str;
    }
}
