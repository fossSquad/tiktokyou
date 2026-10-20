package Z;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.Video;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonNull;
import ni.shikatu.kotlinx.serialization.json.JsonObject;

public final class o4 {
    public static final o4 a;
    public static final ExecutorService b;
    public static final Handler c;
    public static final ConcurrentHashMap d;

    static {
        a = new o4();
        b = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public final Thread newThread(Runnable runnable) {
                return o4.a(runnable);
            }
        });
        c = new Handler(Looper.getMainLooper());
        d = new ConcurrentHashMap();
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "TikTokYou-DownloadWeb");
        thread.setDaemon(true);
        return thread;
    }

    public static void a(Aweme aweme, final Video video, final Function1 function1) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = ResultCompat.constructor(aweme.aid);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        String str = null;
        if (ResultCompat.isFailure(obj)) {
            obj = null;
        }
        String str2 = (String) obj;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            str = str2;
        }
        if (str == null) {
            function1.invoke(CollectionsKt.emptyList());
            return;
        }
        ConcurrentHashMap concurrentHashMap = d;
        n4 n4Var = (n4) concurrentHashMap.get(str);
        if (n4Var != null) {
            if (SystemClock.elapsedRealtime() - n4Var.b <= (!n4Var.a.isEmpty() ? 600000L : 60000L)) {
                function1.invoke(n4Var.a);
                return;
            }
            concurrentHashMap.remove(str, n4Var);
        }
        final String strF = str;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Function1 function2 = new Function1() {
            public final Object invoke(Object obj2) {
                return o4.a(atomicBoolean, function1, (List) obj2);
            }
        };
        c.postDelayed(new Runnable() {
            @Override
            public final void run() {
                o4.a(atomicBoolean, strF, function1);
            }
        }, 2500L);
        b.execute(new Runnable() {
            @Override
            public final void run() {
                o4.a(strF, function2, video);
            }
        });
    }

    public static final Unit a(AtomicBoolean atomicBoolean, final Function1 function1, final List list) {
        if (atomicBoolean.compareAndSet(false, true)) {
            c.post(new Runnable() {
                @Override
                public final void run() {
                    o4.a(function1, list);
                }
            });
        }
        return Unit.INSTANCE;
    }

    public static final void a(Function1 function1, List list) {
        function1.invoke(list);
    }

    public static final void a(AtomicBoolean atomicBoolean, String str, Function1 function1) {
        if (atomicBoolean.compareAndSet(false, true)) {
            AtomicLong atomicLong = r4.a;
            r4.a(str, 2500L);
            function1.invoke(CollectionsKt.emptyList());
        }
    }

    public static final void a(String str, Function1 function1, Video video) {
        Object obj;
        Integer num;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        o4 o4Var = a;
        try {
            Result.Companion companion = Result.Companion;
            o4Var.getClass();
            obj = ResultCompat.constructor(a(str, video));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj);
        if (th2 != null) {
            AtomicLong atomicLong = r4.a;
            r4.a(str, th2.toString());
        }
        List listEmptyList = CollectionsKt.emptyList();
        if (ResultCompat.isFailure(obj)) {
            obj = listEmptyList;
        }
        List list = (List) obj;
        d.put(str, new n4(list, SystemClock.elapsedRealtime()));
        AtomicLong atomicLong2 = r4.a;
        Boolean boolValueOf = Boolean.valueOf(!list.isEmpty());
        Long lValueOf = Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime);
        Integer numValueOf = Integer.valueOf(list.size());
        Iterator it = list.iterator();
        if (it.hasNext()) {
            Integer numValueOf2 = Integer.valueOf(((o3) it.next()).l);
            while (it.hasNext()) {
                Integer numValueOf3 = Integer.valueOf(((o3) it.next()).l);
                if (numValueOf2.compareTo(numValueOf3) < 0) {
                    numValueOf2 = numValueOf3;
                }
            }
            num = numValueOf2;
        } else {
            num = null;
        }
        r4.a(str, boolValueOf, lValueOf, numValueOf, Integer.valueOf(num != null ? num.intValue() : 0));
        function1.invoke(list);
    }

    public static List a(String str, Video video) throws NoWhenBranchMatchedException {
        JsonArray jsonArray;
        JsonObject jsonObject;
        int i;
        JsonElement jsonNull;
        Long lValueOf;
        String strB;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!Character.isDigit(str.charAt(i3))) {
                throw new IllegalArgumentException("Unexpected aweme id".toString());
            }
        }
        String strA = "https://www.tiktok.com/@_/video/" + str;
        String strDecrypt = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36";
        AtomicBoolean atomicBoolean = t.a;
        String strA2 = t.a(strA, strDecrypt, 2097152, MapsKt.emptyMap(), (String) null).a();
        if (strA2 != null) {
            int iIndexOf$default = StringsKt.indexOf$default(strA2, "__UNIVERSAL_DATA_FOR_REHYDRATION__", 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                int iIndexOf$default2 = StringsKt.indexOf$default(strA2, '>', iIndexOf$default, false, 4, (Object) null);
                if (iIndexOf$default2 >= 0) {
                    int iIndexOf = StringsKt.indexOf(strA2, "</script>", iIndexOf$default2, true);
                    if (iIndexOf >= 0) {
                        String strSubstring = strA2.substring(iIndexOf$default2 + 1, iIndexOf);
                        String string = StringsKt.trim(strSubstring).toString();
                        if (string.length() <= 0) {
                            string = null;
                        }
                        if (string != null) {
                            JsonElement jsonObjectB = e7.b(string);
                            JsonObject jsonObject2 = jsonObjectB instanceof JsonObject ? (JsonObject) jsonObjectB : null;
                            if (jsonObject2 != null) {
                                Object obj = jsonObject2.get("__DEFAULT_SCOPE__");
                                JsonObject jsonObject3 = obj instanceof JsonObject ? (JsonObject) obj : null;
                                if (jsonObject3 != null) {
                                    Object obj2 = jsonObject3.get("webapp.video-detail");
                                    JsonObject jsonObject4 = obj2 instanceof JsonObject ? (JsonObject) obj2 : null;
                                    if (jsonObject4 == null) {
                                        Object obj3 = jsonObject3.get("webapp.reflow.video.detail");
                                        jsonObject4 = obj3 instanceof JsonObject ? (JsonObject) obj3 : null;
                                        if (jsonObject4 == null) {
                                            throw new IllegalStateException("TikTok video detail missing".toString());
                                        }
                                    }
                                    Object obj4 = jsonObject4.get("itemInfo");
                                    JsonObject jsonObject5 = obj4 instanceof JsonObject ? (JsonObject) obj4 : null;
                                    JsonElement jsonElement = jsonObject5 != null ? (JsonElement) jsonObject5.get("itemStruct") : null;
                                    JsonObject jsonObject6 = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
                                    if (jsonObject6 != null) {
                                        Object obj5 = jsonObject6.get("video");
                                        JsonObject jsonObject7 = obj5 instanceof JsonObject ? (JsonObject) obj5 : null;
                                        if (jsonObject7 != null) {
                                            String[] strArr = {"bitrateInfo", "bit_rate"};
                                            int i4 = 0;
                                            while (true) {
                                                if (i4 >= 2) {
                                                    jsonArray = null;
                                                    break;
                                                }
                                                Object obj6 = jsonObject7.get(strArr[i4]);
                                                jsonArray = obj6 instanceof JsonArray ? (JsonArray) obj6 : null;
                                                if (jsonArray != null) {
                                                    break;
                                                }
                                                i4++;
                                            }
                                            if (jsonArray == null) {
                                                return CollectionsKt.emptyList();
                                            }
                                            AtomicLong atomicLong = r4.a;
                                            r4.a(Integer.valueOf(jsonArray.size()));
                                            ArrayList arrayList = new ArrayList();
                                            int size = jsonArray.size();
                                            int i5 = 0;
                                            while (i5 < size) {
                                                JsonElement jsonElement8 = jsonArray.get(i5);
                                                JsonObject jsonObject9 = jsonElement8 instanceof JsonObject ? (JsonObject) jsonElement8 : null;
                                                if (jsonObject9 == null) {
                                                    i = i2;
                                                } else {
                                                    String strDecrypt2 = "PlayAddr";
                                                    String strDecrypt3 = "playAddr";
                                                    String strDecrypt4 = "play_addr";
                                                    String[] strArr2 = new String[3];
                                                    strArr2[i2] = strDecrypt2;
                                                    strArr2[1] = strDecrypt3;
                                                    strArr2[2] = strDecrypt4;
                                                    int i6 = i2;
                                                    while (true) {
                                                        if (i6 >= 3) {
                                                            jsonObject = null;
                                                            break;
                                                        }
                                                        Object obj7 = jsonObject9.get(strArr2[i6]);
                                                        jsonObject = obj7 instanceof JsonObject ? (JsonObject) obj7 : null;
                                                        if (jsonObject != null) {
                                                            break;
                                                        }
                                                        i6++;
                                                    }
                                                    if (jsonObject == null) {
                                                        i = i2;
                                                    } else {
                                                        ArrayList arrayList2 = new ArrayList();
                                                        String strDecrypt5 = "UrlList";
                                                        String strDecrypt6 = "urlList";
                                                        i = i2;
                                                        String strDecrypt7 = "url_list";
                                                        String[] strArr3 = new String[3];
                                                        strArr3[i] = strDecrypt5;
                                                        strArr3[1] = strDecrypt6;
                                                        strArr3[2] = strDecrypt7;
                                                        int i7 = i;
                                                        while (true) {
                                                            if (i7 >= 3) {
                                                                jsonNull = null;
                                                                break;
                                                            }
                                                            jsonNull = (JsonElement) jsonObject.get(strArr3[i7]);
                                                            if (jsonNull == null || jsonNull == JsonNull.INSTANCE) {
                                                                jsonNull = null;
                                                            }
                                                            if (jsonNull != null) {
                                                                break;
                                                            }
                                                            i7++;
                                                        }
                                                        v4.a((JsonElement) jsonNull, (List) arrayList2);
                                                        v4 v4Var = v4.a;
                                                        String strC = v4.c(jsonObject, "UrlKey");
                                                        String strC2 = v4.c(jsonObject, "urlKey");
                                                        String strC3 = v4.c(jsonObject, "url_key");
                                                        String[] strArr4 = new String[3];
                                                        strArr4[i] = strC;
                                                        strArr4[1] = strC2;
                                                        strArr4[2] = strC3;
                                                        String strB2 = v4.b(strArr4);
                                                        UrlModel urlModelB = v4.b(strB2, arrayList2);
                                                        if (urlModelB != null) {
                                                            String strC4 = v4.c(jsonObject, "Uri");
                                                            String strC5 = v4.c(jsonObject, "uri");
                                                            String[] strArr5 = new String[3];
                                                            strArr5[i] = strC4;
                                                            strArr5[1] = strC5;
                                                            strArr5[2] = strB2;
                                                            urlModelB.uri = v4.b(strArr5);
                                                            long jB = v4.b(jsonObject, "DataSize");
                                                            long jB2 = v4.b(jsonObject, "dataSize");
                                                            long jB3 = v4.b(jsonObject, "data_size");
                                                            long[] jArr = new long[3];
                                                            jArr[i] = jB;
                                                            jArr[1] = jB2;
                                                            jArr[2] = jB3;
                                                            int i8 = i;
                                                            while (true) {
                                                                if (i8 >= 3) {
                                                                    lValueOf = null;
                                                                    break;
                                                                }
                                                                long j = jArr[i8];
                                                                if (j > 0) {
                                                                    lValueOf = Long.valueOf(j);
                                                                    break;
                                                                }
                                                                i8++;
                                                            }
                                                            urlModelB.size = lValueOf != null ? lValueOf.longValue() : 0L;
                                                            urlModelB.width = v4.a(v4.a(jsonObject, "Width"), v4.a(jsonObject, "width"));
                                                            urlModelB.height = v4.a(v4.a(jsonObject, "Height"), v4.a(jsonObject, "height"));
                                                            String strC6 = v4.c(jsonObject9, "GearName");
                                                            String strC7 = v4.c(jsonObject9, "gearName");
                                                            String strC8 = v4.c(jsonObject9, "gear_name");
                                                            String[] strArr6 = new String[3];
                                                            strArr6[i] = strC6;
                                                            strArr6[1] = strC7;
                                                            strArr6[2] = strC8;
                                                            String strB3 = v4.b(strArr6);
                                                            String strC9 = v4.c(urlModelB);
                                                            if (strC9 != null) {
                                                                strB = strC9;
                                                            } else {
                                                                String strC10 = v4.c(jsonObject9, "CodecType");
                                                                String strC11 = v4.c(jsonObject9, "codecType");
                                                                String strC12 = v4.c(jsonObject9, "codec_type");
                                                                String[] strArr7 = new String[3];
                                                                strArr7[i] = strC10;
                                                                strArr7[1] = strC11;
                                                                strArr7[2] = strC12;
                                                                strB = v4.b(strArr7);
                                                            }
                                                            String string2 = (new StringBuilder()).append("web.bitrateInfo[").append(strB3).append("]").toString();
                                                            s4 s4Var = s4.WEB_PROGRESSIVE;
                                                            dk dkVar = dk.CONFIRMED_CLEAN;
                                                            zc zcVar = zc.TRANSCODED_PLAYBACK;
                                                            ci ciVar = ci.MUXED;
                                                            int iA = v4.a(v4.a(jsonObject9, "Bitrate"), v4.a(jsonObject9, "bitrate"), v4.a(jsonObject9, "bit_rate"));
                                                            int iA2 = v4.a(v4.a(jsonObject9, "QualityType"), v4.a(jsonObject9, "qualityType"), v4.a(jsonObject9, "quality_type"));
                                                            int i9 = urlModelB.width;
                                                            int i10 = urlModelB.height;
                                                            String strC13 = v4.c(jsonObject9, "Format");
                                                            String strC14 = v4.c(jsonObject9, "format");
                                                            String[] strArr8 = new String[2];
                                                            strArr8[i] = strC13;
                                                            strArr8[1] = strC14;
                                                            o3 o3VarA = v4.a(v4Var, video, urlModelB, string2, s4Var, dkVar, zcVar, ciVar, iA, iA2, i9, i10, strB3, strB, v4.b(strArr8), 760, null, null, null, 491520);
                                                            if (o3VarA != null && !o3VarA.d()) {
                                                                arrayList.add(o3VarA);
                                                            }
                                                        }
                                                    }
                                                }
                                                i5++;
                                                i2 = i;
                                            }
                                            return v4.a.a(arrayList);
                                        }
                                        throw new IllegalStateException("TikTok video JSON missing".toString());
                                    }
                                    throw new IllegalStateException("TikTok itemStruct missing".toString());
                                }
                                throw new IllegalStateException("TikTok web scope missing".toString());
                            }
                            throw new IllegalStateException("TikTok universal data malformed".toString());
                        }
                        throw new IllegalStateException("TikTok universal data is empty".toString());
                    }
                    throw new IllegalStateException("TikTok universal data closing tag missing".toString());
                }
                throw new IllegalStateException("TikTok universal data tag malformed".toString());
            }
            throw new IllegalStateException("TikTok universal data marker missing".toString());
        }
        throw new IllegalStateException("Empty TikTok webpage".toString());
    }
}
