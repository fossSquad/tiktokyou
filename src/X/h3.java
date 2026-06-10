package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.Video;
import com.ss.android.ugc.aweme.feed.model.VideoUrlModel;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class h3 {
    public static Object a;
    public static Method b;

    public static List a(Aweme aweme, Video video, UrlModel urlModel, String str) {
        List list;
        String str2;
        List list2;
        List urlList;
        ArrayList arrayList = new ArrayList();
        g3 g3VarA = a(video, urlModel, str.concat(".currentDownloadUrl"), 930);
        if (g3VarA != null) {
            arrayList.add(g3VarA);
        }
        g3 g3VarA2 = a(video, (UrlModel) g8.c(video, "getDownloadNoWatermarkAddr"), str.concat(".downloadNoWatermarkAddr"), 910);
        if (g3VarA2 != null) {
            arrayList.add(g3VarA2);
        }
        g3 g3VarA3 = a(video, (UrlModel) g8.c(video, "getDownloadAddr"), str.concat(".downloadAddr"), 900);
        if (g3VarA3 != null) {
            arrayList.add(g3VarA3);
        }
        g3 g3VarA4 = a(video, (UrlModel) g8.c(video, "getNewDownloadAddr"), str.concat(".newDownloadAddr"), 890);
        if (g3VarA4 != null) {
            arrayList.add(g3VarA4);
        }
        String strConcat = str.concat(".miscDownloadAddrs");
        String strB = b(g8.b(video, "getMiscDownloadAddrs"));
        if (strB == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList2 = new ArrayList();
            try {
                String strTrim = strB.trim();
                if (strTrim.startsWith("[")) {
                    g3 g3VarA5 = a(video, new JSONArray(strTrim), (String) null, strConcat);
                    if (g3VarA5 != null) {
                        arrayList2.add(g3VarA5);
                    }
                } else {
                    JSONObject jSONObject = new JSONObject(strTrim);
                    if (a(jSONObject)) {
                        g3 g3VarA6 = a(video, jSONObject, (String) null, strConcat);
                        if (g3VarA6 != null) {
                            arrayList2.add(g3VarA6);
                        }
                    } else {
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            g3 g3VarA7 = a(video, jSONObject.opt(next), next, strConcat);
                            if (g3VarA7 != null) {
                                arrayList2.add(g3VarA7);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
            list = arrayList2;
        }
        a(arrayList, list);
        a(arrayList, a(video, g8.a(video, "getRawBitRate"), str.concat(".rawBitRate"), 700, null));
        a(arrayList, a(video, g8.a(video, "getBitRate"), str.concat(".bitRate"), 650, null));
        a(arrayList, a(video, g8.a(video.getPlayAddr(), "getRawBitRate"), str.concat(".playAddr.rawBitRate"), 600, null));
        a(arrayList, a(video, g8.a(video.getPlayAddr(), "getBitRate"), str.concat(".playAddr.bitRate"), 550, null));
        String str3 = "getPlayAddrBytevc1";
        UrlModel urlModel2 = (UrlModel) g8.c(video, "getPlayAddrBytevc1");
        UrlModel urlModel3 = (UrlModel) g8.c(video, "getH264PlayAddr");
        String strConcat2 = str.concat(".videoModel");
        String strB2 = b(g8.b(video, "getVideoModelStr"));
        if (strB2 == null) {
            list2 = Collections.EMPTY_LIST;
            str3 = "getPlayAddrBytevc1";
            str2 = "getH264PlayAddr";
        } else {
            ArrayList arrayList3 = new ArrayList();
            str2 = "getH264PlayAddr";
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strB2).optJSONObject("dynamic_video");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONArray("dynamic_video_list") : null;
                try {
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                        list2 = Collections.EMPTY_LIST;
                    } else {
                        int i = 0;
                        while (true) {
                            str3 = str3;
                            if (i >= jSONArrayOptJSONArray.length()) {
                                break;
                            }
                            g3 g3VarA8 = a(video, jSONArrayOptJSONArray.optJSONObject(i), strConcat2);
                            if (g3VarA8 != null) {
                                arrayList3.add(g3VarA8);
                            }
                            i++;
                            str3 = str3;
                        }
                        list2 = arrayList3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    th.getMessage();
                }
            } catch (Throwable th3) {
                th = th3;
                str3 = "getPlayAddrBytevc1";
            }
        }
        a(arrayList, list2);
        a(arrayList, a(video, g8.a(urlModel2, "getRawBitRate"), str.concat(".bytevc1.rawBitRate"), 590, null));
        a(arrayList, a(video, g8.a(urlModel3, "getRawBitRate"), str.concat(".h264.rawBitRate"), 540, null));
        g3 g3VarA9 = a(video, urlModel2, str.concat(".playAddrBytevc1"), 320);
        if (g3VarA9 != null) {
            arrayList.add(g3VarA9);
        }
        g3 g3VarA10 = a(video, (UrlModel) video.getPlayAddr(), str.concat(".playAddr"), 300);
        if (g3VarA10 != null) {
            arrayList.add(g3VarA10);
        }
        g3 g3VarA11 = a(video, urlModel3, str.concat(".h264PlayAddr"), 250);
        if (g3VarA11 != null) {
            arrayList.add(g3VarA11);
        }
        String strConcat3 = str.concat(".audio");
        ArrayList arrayList4 = new ArrayList();
        a(arrayList4, a(g8.a(video, "getRawBitRate"), strConcat3 + ".rawBitRate", 90));
        a(arrayList4, a(g8.a(video, "getBitRate"), strConcat3 + ".bitRate", 80));
        a(arrayList4, a(g8.a(video.getPlayAddr(), "getRawBitRate"), strConcat3 + ".playAddr.rawBitRate", 70));
        a(arrayList4, a(g8.a(video.getPlayAddr(), "getBitRate"), strConcat3 + ".playAddr.bitRate", 60));
        UrlModel urlModel4 = (UrlModel) g8.c(video, str3);
        UrlModel urlModel5 = (UrlModel) g8.c(video, str2);
        a(arrayList4, a(g8.a(urlModel4, "getRawBitRate"), strConcat3 + ".bytevc1.rawBitRate", 50));
        a(arrayList4, a(g8.a(urlModel5, "getRawBitRate"), strConcat3 + ".h264.rawBitRate", 40));
        UrlModel urlModel6 = (UrlModel) g8.c(g8.b(aweme, "getMusic"), "getPlayUrl");
        g3 g3Var = (urlModel6 == null || (urlList = urlModel6.getUrlList()) == null || urlList.isEmpty()) ? null : new g3(urlModel6, strConcat3 + ".music.playUrl", urlModel6.getSize(), 0, 0, false, false, true, 0, Math.max(1, 30), 30);
        if (g3Var != null) {
            arrayList4.add(g3Var);
        }
        a(arrayList, (List) arrayList4);
        return a(arrayList);
    }

    public static String b(g3 g3Var) {
        if (g3Var == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList(4);
        int i = g3Var.d;
        if (i > 0) {
            arrayList.add(i >= 1000000 ? String.format(Locale.US, "%.1f Mbps", Float.valueOf(i / 1000000.0f)) : Math.max(1, i / 1000) + " Kbps");
        }
        long j = g3Var.c;
        if (j > 0) {
            arrayList.add(j >= 1048576 ? String.format(Locale.US, "%.1f MB", Float.valueOf(j / 1048576.0f)) : j >= 1024 ? String.format(Locale.US, "%.1f KB", Float.valueOf(j / 1024.0f)) : j + " B");
        }
        UrlModel urlModel = g3Var.a;
        String strA = urlModel != null ? a(urlModel.getUrlKey(), g3Var.a.getUri()) : null;
        String str = g3Var.b;
        String strG = str != null ? g(str) : null;
        if (strG != null) {
            arrayList.add(strG);
        } else if (strA != null) {
            arrayList.add(strA);
        }
        if (arrayList.isEmpty()) {
            return g3Var.b;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 > 0) {
                sb.append(" • ");
            }
            sb.append((String) arrayList.get(i2));
        }
        return sb.toString();
    }

    public static String c(g3 g3Var) {
        if (g3Var == null) {
            return "";
        }
        o4 o4VarA = o4.a();
        StringBuilder sb = new StringBuilder();
        if (g3Var.g) {
            sb.append(o4VarA.a("download_quality_audio_only", "Только звук"));
        } else {
            int i = g3Var.h;
            if (i > 0) {
                sb.append(i).append('p');
            } else {
                sb.append(o4VarA.a("download_quality_unknown", "Неизвестно"));
            }
        }
        if (g3Var.e) {
            sb.append(" • ").append(o4VarA.a("download_quality_original", "оригинал"));
        }
        String strA = a(g3Var);
        if (strA != null) {
            sb.append(" • ").append(strA);
        }
        if (!g3Var.f && !g3Var.g) {
            sb.append(" • ").append(o4VarA.a("download_quality_no_audio", "без звука"));
        }
        return sb.toString();
    }

    public static boolean d(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("original") || lowerCase.startsWith("origin_") || lowerCase.contains("_origin_");
    }

    public static boolean e(String str) {
        char cCharAt;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("v") && (lowerCase.contains("0000") || lowerCase.contains("gc000"))) {
            int i = 0;
            for (int i2 = 1; i2 < lowerCase.length() && (((cCharAt = lowerCase.charAt(i2)) >= '0' && cCharAt <= '9') || (cCharAt >= 'a' && cCharAt <= 'z')); i2++) {
                i++;
            }
            if (i >= 12) {
                return true;
            }
        }
        return false;
    }

    public static UrlModel f(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                if (b == null) {
                    b = Class.forName("com.google.gson.Gson").getMethod("fromJson", String.class, Class.class);
                }
                Method method = b;
                if (a == null) {
                    a = Class.forName("com.google.gson.Gson").getDeclaredConstructor(null).newInstance(null);
                }
                Object objInvoke = method.invoke(a, str, VideoUrlModel.class);
                if (objInvoke instanceof UrlModel) {
                    return (UrlModel) objInvoke;
                }
                return null;
            } catch (Throwable th) {
                try {
                    if (b == null) {
                        b = Class.forName("com.google.gson.Gson").getMethod("fromJson", String.class, Class.class);
                    }
                    Method method2 = b;
                    if (a == null) {
                        a = Class.forName("com.google.gson.Gson").getDeclaredConstructor(null).newInstance(null);
                    }
                    Object objInvoke2 = method2.invoke(a, str, UrlModel.class);
                    if (objInvoke2 instanceof UrlModel) {
                        return (UrlModel) objInvoke2;
                    }
                    return null;
                } catch (Throwable th2) {
                }
            }
        }
        return null;
    }

    public static String g(String str) {
        int i;
        String strSubstring;
        int i2;
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(93);
        int iLastIndexOf2 = str.lastIndexOf(44, iLastIndexOf >= 0 ? iLastIndexOf : str.length());
        if (iLastIndexOf2 >= 0 && iLastIndexOf > (i2 = iLastIndexOf2 + 1)) {
            String strSubstring2 = str.substring(i2, iLastIndexOf);
            if (strSubstring2.indexOf(61) >= 0) {
                return null;
            }
            return strSubstring2;
        }
        int iLastIndexOf3 = str.lastIndexOf(91, iLastIndexOf >= 0 ? iLastIndexOf : str.length());
        if (iLastIndexOf3 < 0 || iLastIndexOf <= (i = iLastIndexOf3 + 1) || (strSubstring = str.substring(i, iLastIndexOf)) == null || strSubstring.indexOf(61) >= 0 || strSubstring.indexOf(44) >= 0 || strSubstring.endsWith("bps")) {
            return null;
        }
        return strSubstring;
    }

    public static boolean d(g3 g3Var) {
        if (g3Var == null || g3Var.g) {
            return false;
        }
        long j = g3Var.c;
        return j > 0 && j < 524288;
    }

    public static boolean c(String str) {
        int iLastIndexOf = str.lastIndexOf(95);
        if (iLastIndexOf >= 0 && iLastIndexOf != str.length() - 1) {
            int i = 0;
            for (int i2 = iLastIndexOf + 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt < '0' || cCharAt > '9') {
                    return false;
                }
                i = (i * 10) + (cCharAt - '0');
            }
            if (i >= 2) {
                return true;
            }
        }
        return false;
    }

    public static long c(JSONObject jSONObject, String str) {
        Object objOpt = jSONObject.opt(str);
        if (objOpt instanceof Number) {
            return ((Number) objOpt).longValue();
        }
        if (!(objOpt instanceof String)) {
            return 0L;
        }
        try {
            return Long.parseLong((String) objOpt);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    public static int b(g3 g3Var, g3 g3Var2) {
        int i;
        if (g3Var == g3Var2) {
            return 0;
        }
        if (g3Var == null) {
            return -1;
        }
        if (g3Var2 == null) {
            return 1;
        }
        boolean z = g3Var.g;
        if (z != g3Var2.g) {
            return z ? -1 : 1;
        }
        boolean z2 = g3Var.f;
        if (z2 != g3Var2.f) {
            return z2 ? 1 : -1;
        }
        int i2 = g3Var.h;
        if (i2 > 0 && (i = g3Var2.h) > 0 && i2 != i) {
            return Integer.compare(i2, i);
        }
        if (d(g3Var) != d(g3Var2)) {
            return d(g3Var) ? -1 : 1;
        }
        int i3 = g3Var.i;
        int i4 = g3Var2.i;
        if (i3 != i4) {
            return Integer.compare(i3, i4);
        }
        boolean z3 = g3Var.e;
        if (z3 != g3Var2.e) {
            return z3 ? 1 : -1;
        }
        long j = g3Var.c;
        long j2 = g3Var2.c;
        if (j != j2) {
            return Long.compare(j, j2);
        }
        int i5 = g3Var.d;
        int i6 = g3Var2.d;
        if (i5 != i6) {
            return Integer.compare(i5, i6);
        }
        return Integer.compare(g3Var.j, g3Var2.j);
    }

    public static int b(String str) {
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase();
        int i = 0;
        int iA = 0;
        for (int i2 = 0; i2 < lowerCase.length(); i2++) {
            char cCharAt = lowerCase.charAt(i2);
            if (cCharAt < '0' || cCharAt > '9') {
                int i3 = 0;
                if (i > 0) {
                    int i4 = i;
                    while (i4 > 0) {
                        i4 /= 10;
                        i3++;
                    }
                }
                int i5 = i2 - i3;
                iA = a(iA, i, (i5 <= 0 || i5 > lowerCase.length()) ? (char) 0 : lowerCase.charAt(i5 - 1), cCharAt);
                i = 0;
            } else {
                i = (cCharAt - '0') + (i * 10);
            }
        }
        int length = lowerCase.length();
        int i6 = 0;
        if (i > 0) {
            int i7 = i;
            while (i7 > 0) {
                i7 /= 10;
                i6++;
            }
        }
        int i8 = length - i6;
        return a(iA, i, (i8 <= 0 || i8 > lowerCase.length()) ? (char) 0 : lowerCase.charAt(i8 - 1), (char) 0);
    }

    public static int b(int i) {
        if (a(i)) {
            return i;
        }
        int[] iArr = {144, 240, 360, 480, 540, 576, 720, 1080, 1440, 2160, 4320};
        int i2 = 0;
        for (int i3 = 0; i3 < 11; i3++) {
            int i4 = iArr[i3];
            if (i >= i4) {
                i2 = i4;
            }
        }
        return i2;
    }

    public static void b(Video video, UrlModel urlModel) {
        boolean z;
        if (urlModel != null) {
            urlModel.getSize();
        }
        if (urlModel != null) {
            urlModel.getUrlKey();
        }
        if (urlModel != null) {
            urlModel.getUri();
        }
        List urlList = urlModel != null ? urlModel.getUrlList() : null;
        if (urlList != null) {
            urlList.size();
        }
        a(urlModel);
        if (urlModel != null) {
            try {
                if (video.checkVideo(urlModel)) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                "throw:".concat(th.getClass().getSimpleName());
                return;
            }
        } else {
            z = false;
        }
        String.valueOf(z);
    }

    public static int b(JSONObject jSONObject, String str) {
        Object objOpt = jSONObject.opt(str);
        if (objOpt instanceof Number) {
            return ((Number) objOpt).intValue();
        }
        if (!(objOpt instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) objOpt);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String b(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static void a(g3 g3Var, UrlModel urlModel) {
        if (g3Var == null) {
            return;
        }
        String urlKey = urlModel != null ? urlModel.getUrlKey() : null;
        UrlModel urlModel2 = g3Var.a;
        String urlKey2 = urlModel2 != null ? urlModel2.getUrlKey() : null;
        if (urlKey2 != null) {
            urlKey2.equals(urlKey);
        }
        UrlModel urlModel3 = g3Var.a;
        List urlList = urlModel3 != null ? urlModel3.getUrlList() : null;
        if (urlList != null) {
            urlList.size();
        }
        int i = p4.a;
    }

    public static g3 a(g3 g3Var, g3 g3Var2) {
        if (g3Var2 == null) {
            return g3Var;
        }
        return (g3Var != null && b(g3Var2, g3Var) <= 0) ? g3Var : g3Var2;
    }

    public static g3 a(Video video, UrlModel urlModel, String str, int i) {
        int iB;
        int iB2;
        int i2;
        if (!a(video, urlModel)) {
            return null;
        }
        String strG = g(str);
        String strA = a(strG, urlModel.getUrlKey(), urlModel.getUri(), str);
        int iB3 = b(strG);
        int iB4 = b(urlModel.getUrlKey());
        int iB5 = b(urlModel.getUri());
        int iB6 = b(str);
        int iA = a(g8.b(urlModel, "getWidth"));
        int iA2 = a(g8.b(urlModel, "getHeight"));
        if (iA > 0 && iA2 > 0) {
            iB = b(Math.min(iA, iA2));
        } else {
            iB = b(Math.max(iA, iA2));
        }
        int iA3 = a(g8.b(video, "getWidth"));
        int iA4 = a(g8.b(video, "getHeight"));
        if (iA3 > 0 && iA4 > 0) {
            iB2 = b(Math.min(iA3, iA4));
        } else {
            iB2 = b(Math.max(iA3, iA4));
        }
        int[] iArr = {iB3, iB4, iB5, iB6, iB, iB2};
        for (int i3 = 0; i3 < 6; i3++) {
            int i4 = iArr[i3];
            if (i4 > 0) {
                i2 = i4;
                return new g3(urlModel, str, urlModel.getSize(), 0, 0, d(strA), true, false, i2, a(strA, 0, i2), i);
            }
        }
        i2 = 0;
        return new g3(urlModel, str, urlModel.getSize(), 0, 0, d(strA), true, false, i2, a(strA, 0, i2), i);
    }

    public static List a(Video video, List list, String str, int i, Boolean bool) {
        boolean zBooleanValue;
        boolean zC;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj != null) {
                    UrlModel urlModel = (UrlModel) g8.c(obj, "getPlayAddr");
                    if (urlModel == null) {
                        g8.b(obj, "getPlayAddr");
                    } else {
                        int iA = a(g8.b(obj, "getBitRate"));
                        int iA2 = a(g8.b(obj, "getQualityType"));
                        String strB = b(g8.b(obj, "getGearName"));
                        boolean zD = d(strB);
                        if (bool != null) {
                            zBooleanValue = bool.booleanValue();
                        } else {
                            Object objB = g8.b(obj, "isDash");
                            zBooleanValue = ((objB instanceof Boolean) && ((Boolean) objB).booleanValue()) ? false : true;
                        }
                        int iB = b(strB);
                        int iA3 = a(strB, iA2, iB);
                        String str2 = str + "[" + iA + "bps" + (iA2 != 0 ? ",q=" + iA2 : "") + (iB != 0 ? ",r=" + iB : "") + (iA3 != 0 ? ",score=" + iA3 : "") + (!zBooleanValue ? ",video_only" : "") + (strB != null ? ",".concat(strB) : "") + "]";
                        if (a(urlModel)) {
                            zC = true;
                        } else {
                            zC = strB == null ? false : c(strB.toLowerCase());
                        }
                        if (zC) {
                            if (!a(urlModel) && strB != null) {
                                c(strB.toLowerCase());
                            }
                            urlModel.getSize();
                            urlModel.getUrlKey();
                            urlModel.getUri();
                            List urlList = urlModel.getUrlList();
                            if (urlList != null) {
                                urlList.size();
                            }
                        } else {
                            g3 g3Var = !a(video, urlModel) ? null : new g3(urlModel, str2, urlModel.getSize(), iA, iA2, zD, zBooleanValue, false, iB, iA3, i);
                            if (g3Var == null) {
                                b(video, urlModel);
                            }
                            if (g3Var != null) {
                                arrayList.add(g3Var);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return Collections.EMPTY_LIST;
    }

    public static List a(List list, String str, int i) {
        UrlModel urlModel;
        g3 g3Var;
        int i2;
        int iMax;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj != null && (urlModel = (UrlModel) g8.c(obj, "getPlayAddr")) != null) {
                    int iA = a(g8.b(obj, "getBitRate"));
                    int iA2 = a(g8.b(obj, "getQualityType"));
                    String strB = b(g8.b(obj, "getGearName"));
                    if (a(urlModel) || a(strB) || (strB != null && c(strB.toLowerCase()))) {
                        int iB = b(strB);
                        int iA3 = a(strB, iA2, iB);
                        String str2 = str + "[" + iA + "bps" + (iA2 != 0 ? ",q=" + iA2 : "") + (iB != 0 ? ",r=" + iB : "") + (iA3 != 0 ? ",score=" + iA3 : "") + ",audio_only" + (strB != null ? ",".concat(strB) : "") + "]";
                        boolean zD = d(strB);
                        List urlList = urlModel.getUrlList();
                        if (urlList == null || urlList.isEmpty()) {
                            g3Var = null;
                        } else {
                            if (iA > 0) {
                                i2 = i;
                                iMax = iA;
                            } else {
                                i2 = i;
                                iMax = Math.max(1, i2);
                            }
                            g3Var = new g3(urlModel, str2, urlModel.getSize(), iA, iA2, zD, false, true, 0, iMax, i2);
                        }
                        if (g3Var != null) {
                            arrayList.add(g3Var);
                        }
                    }
                }
            }
            return arrayList;
        }
        return Collections.EMPTY_LIST;
    }

    public static g3 a(Video video, JSONObject jSONObject, String str) {
        int iIntValue;
        UrlModel urlModel;
        UrlModel urlModel2;
        ?? g3Var;
        ?? r0;
        Collection urlList;
        if (jSONObject == null) {
            return null;
        }
        String strB = b((Object) jSONObject.optString("gear_name", null));
        boolean zC = false;
        int iOptInt = jSONObject.optInt("bitrate", jSONObject.optInt("real_bitrate", 0));
        Object objOpt = jSONObject.opt("quality");
        if (objOpt instanceof Number) {
            iIntValue = ((Number) objOpt).intValue();
        } else if (objOpt instanceof String) {
            try {
                iIntValue = Integer.parseInt((String) objOpt);
            } catch (NumberFormatException e) {
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        int iB = b(a(strB, jSONObject.optString("file_id", null)));
        int iA = a(strB, iIntValue, iB);
        ArrayList arrayList = new ArrayList(4);
        a(arrayList, jSONObject.opt("main_url"));
        a(arrayList, jSONObject.opt("backup_url_1"));
        a(arrayList, jSONObject.opt("backup_url_2"));
        a(arrayList, jSONObject.opt("backup_url_3"));
        if (arrayList.isEmpty()) {
            urlModel = null;
        } else {
            urlModel = new UrlModel();
            String strB2 = b((Object) jSONObject.optString("file_id", null));
            urlModel.setUri(strB2);
            urlModel.setUrlKey(a(strB2, strB));
            urlModel.setUrlList(arrayList);
            long jOptLong = jSONObject.optLong("size", 0L);
            if (jOptLong > 0) {
                urlModel.setSize(jOptLong);
            }
            int iOptInt2 = jSONObject.optInt("vwidth", 0);
            int iOptInt3 = jSONObject.optInt("vheight", 0);
            if (iOptInt2 > 0) {
                urlModel.setWidth(iOptInt2);
            }
            if (iOptInt3 > 0) {
                urlModel.setHeight(iOptInt3);
            }
        }
        String str2 = str + "[" + (iOptInt != 0 ? iOptInt + "bps," : "") + (iIntValue != 0 ? "q=" + iIntValue + "," : "") + (iB != 0 ? "r=" + iB + "," : "") + "score=" + iA + (strB != null ? ",".concat(strB) : "") + "]";
        if (urlModel == null || a(urlModel)) {
            zC = true;
        } else if (strB != null) {
            zC = c(strB.toLowerCase());
        }
        if (zC) {
            if (urlModel != null && !a(urlModel) && strB != null) {
                c(strB.toLowerCase());
            }
            if (urlModel != null) {
                urlModel.getSize();
            }
            if (urlModel != null) {
                urlModel.getUrlKey();
            }
            if (urlModel != null) {
                urlModel.getUri();
            }
            if (urlModel != null) {
                urlList = urlModel.getUrlList();
            } else {
                r0 = r3;
            }
            if (r0 != 0) {
                r0 = urlList;
                r0.size();
            }
            r0 = urlList;
            return 0;
        }
        boolean zD = d(strB);
        if (a(video, urlModel)) {
            urlModel2 = urlModel;
            g3Var = new g3(urlModel2, str2, urlModel != null ? urlModel.getSize() : 0L, iOptInt, iIntValue, zD, false, false, iB, iA, 620);
        } else {
            urlModel2 = urlModel;
        }
        if (g3Var == 0) {
            g3Var = r3;
            b(video, urlModel2);
        }
        g3Var = r3;
        return g3Var;
    }

    public static g3 a(Video video, Object obj, String str, String str2) {
        Object obj2;
        UrlModel urlModel;
        g3 g3VarA;
        UrlModel urlModel2;
        g3 g3VarA2 = null;
        if (obj == null || obj == (obj2 = JSONObject.NULL)) {
            return null;
        }
        if (obj == obj2) {
            urlModel = null;
        } else if (obj instanceof JSONObject) {
            urlModel = a((JSONObject) obj, str);
            a(urlModel, str);
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList(jSONArray.length());
            a(arrayList, jSONArray);
            if (arrayList.isEmpty()) {
                urlModel = null;
            } else {
                urlModel = new UrlModel();
                urlModel.setUrlList(new ArrayList(arrayList));
                a(urlModel, str);
            }
            a(urlModel, str);
        } else {
            String strTrim = (obj instanceof String ? (String) obj : String.valueOf(obj)).trim();
            if (strTrim.isEmpty() || "null".equalsIgnoreCase(strTrim)) {
                urlModel = null;
            } else {
                try {
                    if (strTrim.startsWith("{")) {
                        UrlModel urlModelA = a(new JSONObject(strTrim), str);
                        a(urlModelA, str);
                        urlModel = urlModelA;
                    } else if (strTrim.startsWith("[")) {
                        JSONArray jSONArray2 = new JSONArray(strTrim);
                        ArrayList arrayList2 = new ArrayList(jSONArray2.length());
                        a(arrayList2, jSONArray2);
                        if (arrayList2.isEmpty()) {
                            urlModel2 = null;
                        } else {
                            urlModel2 = new UrlModel();
                            urlModel2.setUrlList(new ArrayList(arrayList2));
                            a(urlModel2, str);
                        }
                        a(urlModel2, str);
                        urlModel = urlModel2;
                    } else {
                        UrlModel urlModelF = f(strTrim);
                        if (urlModelF != null) {
                            a(urlModelF, str);
                            urlModel = urlModelF;
                        } else {
                            String lowerCase = strTrim.trim().toLowerCase();
                            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.startsWith("//")) {
                                urlModel = null;
                            } else {
                                List listSingletonList = Collections.singletonList(strTrim);
                                if (listSingletonList == null || listSingletonList.isEmpty()) {
                                    urlModel = null;
                                } else {
                                    UrlModel urlModel3 = new UrlModel();
                                    urlModel3.setUrlList(new ArrayList(listSingletonList));
                                    a(urlModel3, str);
                                    urlModel = urlModel3;
                                }
                                a(urlModel, str);
                            }
                        }
                    }
                } catch (Throwable th) {
                }
            }
        }
        if (str != null) {
            str2 = str2 + "[" + str + "]";
        }
        List listA = a(video, g8.a(urlModel, "getRawBitRate"), str2 + ".rawBitRate", 870, Boolean.TRUE);
        if (listA == null) {
            g3VarA = null;
        } else {
            Iterator it = listA.iterator();
            g3VarA = null;
            while (it.hasNext()) {
                g3VarA = a(g3VarA, (g3) it.next());
            }
        }
        g3 g3VarA3 = a((g3) null, g3VarA);
        List listA2 = a(video, g8.a(urlModel, "getBitRate"), str2 + ".bitRate", 860, Boolean.TRUE);
        if (listA2 != null) {
            Iterator it2 = listA2.iterator();
            while (it2.hasNext()) {
                g3VarA2 = a(g3VarA2, (g3) it2.next());
            }
        }
        g3 g3VarA4 = a(a(g3VarA3, g3VarA2), a(video, urlModel, str2 + ".urlModel", 850));
        if (g3VarA4 == null && urlModel != null) {
            b(video, urlModel);
        }
        return g3VarA4;
    }

    public static void a(ArrayList arrayList, List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            g3 g3Var = (g3) it.next();
            if (g3Var != null) {
                arrayList.add(g3Var);
            }
        }
    }

    public static List a(ArrayList arrayList) {
        g3 g3VarA;
        UrlModel urlModel;
        UrlModel urlModel2;
        String str;
        String strG;
        UrlModel urlModel3;
        String str2;
        String strG2;
        boolean zC;
        String urlKey;
        String uri;
        UrlModel urlModel4;
        List urlList;
        String str3;
        String str4;
        UrlModel urlModel5;
        String str5;
        String urlKey2;
        String uri2;
        String strA;
        String strG3;
        List urlList2;
        if (arrayList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            g3VarA = null;
            if (i2 >= size) {
                break;
            }
            Object obj = arrayList.get(i2);
            i2++;
            g3 g3Var = (g3) obj;
            if (g3Var != null && (urlModel2 = g3Var.a) != null) {
                boolean z = g3Var.g;
                if (z) {
                    List urlList3 = urlModel2.getUrlList();
                    if (urlList3 != null && !urlList3.isEmpty()) {
                        String urlKey3 = g3Var.a.getUrlKey();
                        String uri3 = g3Var.a.getUri();
                        UrlModel urlModel6 = g3Var.a;
                        List urlList4 = urlModel6 != null ? urlModel6.getUrlList() : null;
                        if (a(urlKey3, uri3, (urlList4 == null || urlList4.isEmpty()) ? null : (String) urlList4.get(0)) != null) {
                            urlModel5 = g3Var.a;
                            if (urlModel5 != null || (urlList2 = urlModel5.getUrlList()) == null || urlList2.isEmpty()) {
                                str5 = null;
                            } else {
                                str5 = (String) urlList2.get(0);
                            }
                            if (urlModel5 != null) {
                                urlKey2 = urlModel5.getUrlKey();
                            } else {
                                urlKey2 = null;
                            }
                            if (urlModel5 != null) {
                                uri2 = urlModel5.getUri();
                            } else {
                                uri2 = null;
                            }
                            strA = a(urlKey2, uri2, str5, g3Var.b);
                            if (!g3Var.g) {
                                String str6 = g3Var.b;
                                strG3 = str6 != null ? g(str6) : null;
                                if (strG3 != null) {
                                    strA = "video:" + strG3 + ":" + strA;
                                } else if (strA == null) {
                                    strA = String.valueOf(System.identityHashCode(g3Var));
                                }
                            } else if (strA == null) {
                                strA = String.valueOf(System.identityHashCode(g3Var));
                            }
                            linkedHashMap.put(strA, a((g3) linkedHashMap.get(strA), g3Var));
                        }
                    }
                } else if (g3Var.h > 0 && g3Var.f) {
                    if (!z && (str4 = g3Var.b) != null && str4.indexOf(91) < 0) {
                        String str7 = g3Var.b;
                        if ((!str7.endsWith(".playAddr") && !str7.endsWith(".h264PlayAddr") && !str7.endsWith(".playAddrBytevc1")) || g3Var.b.endsWith(".playAddr") || (!e(g3Var.a.getUrlKey()) && !e(g3Var.a.getUri()))) {
                            str = g3Var.b;
                            if (str == null) {
                                strG = null;
                            } else {
                                strG = g(str);
                            }
                            if (str != null) {
                                urlModel3 = g3Var.a;
                                str2 = g3Var.b;
                                if (str2 == null) {
                                    strG2 = null;
                                } else {
                                    strG2 = g(str2);
                                }
                                if (urlModel3 != null) {
                                    zC = true;
                                } else if (strG2 == null) {
                                    zC = false;
                                } else {
                                    zC = c(strG2.toLowerCase());
                                }
                                if (zC) {
                                    urlKey = g3Var.a.getUrlKey();
                                    uri = g3Var.a.getUri();
                                    urlModel4 = g3Var.a;
                                    if (urlModel4 != null) {
                                        urlList = urlModel4.getUrlList();
                                    } else {
                                        urlList = null;
                                    }
                                    if (urlList != null) {
                                        str3 = null;
                                    } else {
                                        str3 = null;
                                    }
                                    if (a(urlKey, uri, str3) != null) {
                                        urlModel5 = g3Var.a;
                                        if (urlModel5 != null) {
                                            str5 = null;
                                        } else {
                                            str5 = null;
                                        }
                                        if (urlModel5 != null) {
                                            urlKey2 = urlModel5.getUrlKey();
                                        } else {
                                            urlKey2 = null;
                                        }
                                        if (urlModel5 != null) {
                                            uri2 = urlModel5.getUri();
                                        } else {
                                            uri2 = null;
                                        }
                                        strA = a(urlKey2, uri2, str5, g3Var.b);
                                        if (!g3Var.g) {
                                            String str8 = g3Var.b;
                                            if (str8 != null) {
                                            }
                                            if (strG3 != null) {
                                                strA = "video:" + strG3 + ":" + strA;
                                            } else if (strA == null) {
                                                strA = String.valueOf(System.identityHashCode(g3Var));
                                            }
                                        } else if (strA == null) {
                                            strA = String.valueOf(System.identityHashCode(g3Var));
                                        }
                                        linkedHashMap.put(strA, a((g3) linkedHashMap.get(strA), g3Var));
                                    }
                                }
                            }
                        }
                    } else {
                        str = g3Var.b;
                        if (str == null) {
                            strG = null;
                        } else {
                            strG = g(str);
                        }
                        if (str != null && !str.contains(".originalFallback") && !str.contains(".uiAlikeDownloadAddr") && ((!str.contains(".videoModel") || strG != null) && (g3Var.g || g3Var.a == null || a(g3Var) != null || (!e(g3Var.a.getUrlKey()) && !e(g3Var.a.getUri()))))) {
                            urlModel3 = g3Var.a;
                            str2 = g3Var.b;
                            if (str2 == null) {
                                strG2 = null;
                            } else {
                                strG2 = g(str2);
                            }
                            if (urlModel3 != null || a(urlModel3)) {
                                zC = true;
                            } else if (strG2 == null) {
                                zC = false;
                            } else {
                                zC = c(strG2.toLowerCase());
                            }
                            if (zC) {
                                urlKey = g3Var.a.getUrlKey();
                                uri = g3Var.a.getUri();
                                urlModel4 = g3Var.a;
                                if (urlModel4 != null) {
                                    urlList = urlModel4.getUrlList();
                                } else {
                                    urlList = null;
                                }
                                if (urlList != null || urlList.isEmpty()) {
                                    str3 = null;
                                } else {
                                    str3 = (String) urlList.get(0);
                                }
                                if (a(urlKey, uri, str3) != null) {
                                    urlModel5 = g3Var.a;
                                    if (urlModel5 != null) {
                                        str5 = null;
                                    } else {
                                        str5 = null;
                                    }
                                    if (urlModel5 != null) {
                                        urlKey2 = urlModel5.getUrlKey();
                                    } else {
                                        urlKey2 = null;
                                    }
                                    if (urlModel5 != null) {
                                        uri2 = urlModel5.getUri();
                                    } else {
                                        uri2 = null;
                                    }
                                    strA = a(urlKey2, uri2, str5, g3Var.b);
                                    if (!g3Var.g) {
                                        String str9 = g3Var.b;
                                        if (str9 != null) {
                                        }
                                        if (strG3 != null) {
                                            strA = "video:" + strG3 + ":" + strA;
                                        } else if (strA == null) {
                                            strA = String.valueOf(System.identityHashCode(g3Var));
                                        }
                                    } else if (strA == null) {
                                        strA = String.valueOf(System.identityHashCode(g3Var));
                                    }
                                    linkedHashMap.put(strA, a((g3) linkedHashMap.get(strA), g3Var));
                                }
                            }
                        }
                    }
                }
            }
            if (g3Var != null) {
                boolean z2 = g3Var.f;
            }
            if (g3Var != null && (urlModel = g3Var.a) != null) {
                urlModel.getUrlKey();
            }
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.values());
        arrayList2.sort(new Comparator() {
            @Override
            public final int compare(Object obj2, Object obj3) {
                return h3.b((g3) obj3, (g3) obj2);
            }
        });
        if (arrayList2.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj2 = arrayList2.get(i);
            i++;
            g3 g3Var2 = (g3) obj2;
            if (g3Var2 != null && g3Var2.g) {
                g3VarA = a(g3VarA, g3Var2);
            } else {
                arrayList3.add(g3Var2);
            }
        }
        if (g3VarA != null) {
            arrayList3.add(g3VarA);
        }
        return arrayList3;
    }

    public static String a(g3 g3Var) {
        StringBuilder sb = new StringBuilder();
        if (g3Var != null) {
            UrlModel urlModel = g3Var.a;
            String strA = urlModel != null ? a(urlModel.getUrlKey(), g3Var.a.getUri()) : null;
            sb.append(g3Var.b);
            if (strA != null) {
                sb.append(' ').append(strA);
            }
            UrlModel urlModel2 = g3Var.a;
            List urlList = urlModel2 != null ? urlModel2.getUrlList() : null;
            if (urlList != null) {
                for (int i = 0; i < urlList.size() && i < 3; i++) {
                    sb.append(' ').append((String) urlList.get(i));
                }
            }
        }
        String lowerCase = sb.toString().toLowerCase();
        if (!lowerCase.contains("h264") && !lowerCase.contains("avc")) {
            if (!lowerCase.contains("audio_mpeg") && !lowerCase.contains("mp3")) {
                if (!lowerCase.contains("audio_mp4") && !lowerCase.contains("m4a") && !lowerCase.contains("aac")) {
                    if (!lowerCase.contains("bytevc2") && !lowerCase.contains("bvc2")) {
                        if (lowerCase.contains("bytevc1") || lowerCase.contains("h265") || lowerCase.contains("hevc")) {
                            return "HEVC";
                        }
                        return null;
                    }
                    return "BVC2";
                }
                return "AAC";
            }
            return "MP3";
        }
        return "H.264";
    }

    public static UrlModel a(JSONObject jSONObject, String str) {
        UrlModel urlModel;
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        long j;
        int i;
        List urlList;
        List listA;
        List listA2;
        UrlModel urlModelF = f(jSONObject.toString());
        if (urlModelF != null && (((urlList = urlModelF.getUrlList()) != null && !urlList.isEmpty()) || (((listA = g8.a(urlModelF, "getRawBitRate")) != null && !listA.isEmpty()) || ((listA2 = g8.a(urlModelF, "getBitRate")) != null && !listA2.isEmpty())))) {
            a(urlModelF, str);
            return urlModelF;
        }
        ArrayList arrayList = new ArrayList(4);
        a(arrayList, jSONObject.opt("main_url"));
        a(arrayList, jSONObject.opt("backup_url"));
        a(arrayList, jSONObject.opt("backup_url_1"));
        a(arrayList, jSONObject.opt("backup_url_2"));
        a(arrayList, jSONObject.opt("backup_url_3"));
        a(arrayList, jSONObject.opt("url"));
        a(arrayList, jSONObject.opt("download_url"));
        a(arrayList, jSONObject.opt("play_url"));
        a(arrayList, jSONObject.opt("play_url_h264"));
        a(arrayList, jSONObject.opt("url_list"));
        a(arrayList, jSONObject.opt("url_list_dash"));
        a(arrayList, jSONObject.opt("backup_url_list"));
        a(arrayList, jSONObject.opt("play_addr"));
        a(arrayList, jSONObject.opt("download_addr"));
        a(arrayList, jSONObject.opt("url_model"));
        UrlModel urlModelValueOf = null;
        if (!arrayList.isEmpty()) {
            if (arrayList.isEmpty()) {
                urlModel = null;
            } else {
                urlModel = new UrlModel();
                urlModel.setUrlList(new ArrayList(arrayList));
                a(urlModel, str);
            }
            Object objOpt = jSONObject.opt("uri");
            if (objOpt instanceof String) {
                strValueOf = b(objOpt);
            } else {
                strValueOf = objOpt instanceof Number ? String.valueOf(objOpt) : null;
            }
            Object objOpt2 = jSONObject.opt("file_id");
            if (objOpt2 instanceof String) {
                strValueOf2 = b(objOpt2);
            } else {
                strValueOf2 = objOpt2 instanceof Number ? String.valueOf(objOpt2) : null;
            }
            Object objOpt3 = jSONObject.opt("vid");
            if (objOpt3 instanceof String) {
                strValueOf3 = b(objOpt3);
            } else {
                strValueOf3 = objOpt3 instanceof Number ? String.valueOf(objOpt3) : null;
            }
            int i2 = 0;
            String strA = a(strValueOf, strValueOf2, strValueOf3, str);
            Object objOpt4 = jSONObject.opt("url_key");
            if (objOpt4 instanceof String) {
                urlModelValueOf = b(objOpt4);
            } else if (objOpt4 instanceof Number) {
                urlModelValueOf = String.valueOf(objOpt4);
            }
            String strA2 = a(urlModelValueOf, strA, str);
            if (strA != null) {
                urlModel.setUri(strA);
            }
            if (strA2 != null) {
                urlModel.setUrlKey(strA2);
            }
            long[] jArr = {c(jSONObject, "data_size"), c(jSONObject, "size"), c(jSONObject, "file_size")};
            int i3 = 0;
            while (true) {
                if (i3 >= 3) {
                    j = 0;
                    break;
                }
                j = jArr[i3];
                if (j > 0) {
                    break;
                }
                i3++;
            }
            if (j > 0) {
                urlModel.setSize(j);
            }
            int[] iArr = {b(jSONObject, "width"), b(jSONObject, "vwidth"), b(jSONObject, "video_width")};
            int i4 = 0;
            while (true) {
                if (i4 >= 3) {
                    i = 0;
                    break;
                }
                i = iArr[i4];
                if (i > 0) {
                    break;
                }
                i4++;
            }
            int[] iArr2 = {b(jSONObject, "height"), b(jSONObject, "vheight"), b(jSONObject, "video_height")};
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = iArr2[i5];
                if (i6 > 0) {
                    i2 = i6;
                    break;
                }
            }
            if (i > 0) {
                urlModel.setWidth(i);
            }
            if (i2 > 0) {
                urlModel.setHeight(i2);
            }
            urlModelValueOf = urlModel;
        }
        return urlModelValueOf != null ? urlModelValueOf : urlModelF;
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject.has("url_list") || jSONObject.has("url_list_dash") || jSONObject.has("main_url") || jSONObject.has("backup_url") || jSONObject.has("url") || jSONObject.has("download_url") || jSONObject.has("play_url") || jSONObject.has("uri") || jSONObject.has("url_key") || jSONObject.has("bit_rate") || jSONObject.has("bitrate") || jSONObject.has("gear_name") || jSONObject.has("play_addr") || jSONObject.has("dynamic_video");
    }

    public static void a(UrlModel urlModel, String str) {
        if (urlModel == null) {
            return;
        }
        String strA = a(str);
        String strA2 = a(urlModel.getUri(), strA);
        String strA3 = a(urlModel.getUrlKey(), strA2, strA);
        if (strA2 != null && a(urlModel.getUri()) == null) {
            urlModel.setUri(strA2);
        }
        if (strA3 == null || a(urlModel.getUrlKey()) != null) {
            return;
        }
        urlModel.setUrlKey(strA3);
    }

    public static void a(ArrayList arrayList, Object obj) {
        if (obj == null || obj == JSONObject.NULL) {
            return;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i = 0; i < jSONArray.length(); i++) {
                a(arrayList, jSONArray.opt(i));
            }
            return;
        }
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            a(arrayList, jSONObject.opt("main_url"));
            a(arrayList, jSONObject.opt("backup_url"));
            a(arrayList, jSONObject.opt("backup_url_1"));
            a(arrayList, jSONObject.opt("backup_url_2"));
            a(arrayList, jSONObject.opt("backup_url_3"));
            a(arrayList, jSONObject.opt("url"));
            a(arrayList, jSONObject.opt("download_url"));
            a(arrayList, jSONObject.opt("play_url"));
            a(arrayList, jSONObject.opt("play_url_h264"));
            a(arrayList, jSONObject.opt("url_list"));
            a(arrayList, jSONObject.opt("url_list_dash"));
            a(arrayList, jSONObject.opt("backup_url_list"));
            return;
        }
        if (obj instanceof String) {
            String strTrim = ((String) obj).trim();
            if (strTrim.startsWith("{")) {
                try {
                    a(arrayList, new JSONObject(strTrim));
                    return;
                } catch (Throwable th) {
                }
            }
            if (strTrim.startsWith("[")) {
                try {
                    a(arrayList, new JSONArray(strTrim));
                    return;
                } catch (Throwable th2) {
                }
            }
            String strB = b((Object) strTrim.trim());
            if (strB != null) {
                String lowerCase = strB.trim().toLowerCase();
                if ((lowerCase.startsWith("http://") || lowerCase.startsWith("https://") || lowerCase.startsWith("//")) && !arrayList.contains(strB)) {
                    arrayList.add(strB);
                }
            }
        }
    }

    public static int a(String str, int i, int i2) {
        int i3;
        if (str == null) {
            i3 = 0;
        } else {
            String lowerCase = str.toLowerCase();
            if (d(lowerCase)) {
                i3 = 900;
            } else if (lowerCase.contains("uhd") || lowerCase.contains("highest")) {
                i3 = 800;
            } else if (lowerCase.contains("higher")) {
                i3 = 700;
            } else if (lowerCase.contains("high")) {
                i3 = 600;
            } else if (lowerCase.contains("normal") || lowerCase.contains("default") || lowerCase.contains("main")) {
                i3 = 500;
            } else if (lowerCase.contains("medium")) {
                i3 = 400;
            } else if (lowerCase.contains("lower")) {
                i3 = 250;
            } else {
                i3 = (lowerCase.contains("lowest") || lowerCase.contains("low")) ? 100 : 300;
            }
        }
        return (i2 * 1000) + i3 + (i < 10000 ? Math.max(0, Math.min(i, 99)) : 99);
    }

    public static int a(int i, int i2, char c, char c2) {
        if (i2 < 144 || i2 > 4320 || i2 <= i || !a(i2)) {
            return i;
        }
        if (c2 == 'p') {
            return i2;
        }
        return ((c == 0 || c == '_' || c == '-' || c == '.') && (c2 == 0 || c2 == '_' || c2 == '-' || c2 == '.')) ? i2 : i;
    }

    public static boolean a(int i) {
        return i == 144 || i == 240 || i == 360 || i == 480 || i == 540 || i == 576 || i == 720 || i == 1080 || i == 1440 || i == 2160 || i == 4320;
    }

    public static boolean a(Video video, UrlModel urlModel) {
        if (urlModel == null || a(urlModel)) {
            return false;
        }
        try {
            if (video.checkVideo(urlModel)) {
                return true;
            }
        } catch (Throwable th) {
        }
        List urlList = urlModel.getUrlList();
        return (urlList == null || urlList.isEmpty()) ? false : true;
    }

    public static boolean a(UrlModel urlModel) {
        if (urlModel == null) {
            return false;
        }
        String urlKey = urlModel.getUrlKey();
        String uri = urlModel.getUri();
        if (a(urlKey) || a(uri)) {
            return true;
        }
        List urlList = urlModel.getUrlList();
        if (urlList == null) {
            return false;
        }
        Iterator it = urlList.iterator();
        while (it.hasNext()) {
            if (a((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("mime_type=audio") || lowerCase.contains("mime_type%3daudio") || lowerCase.contains("audio_mpeg") || lowerCase.contains("audio_mp4") || lowerCase.contains("/audio/") || lowerCase.contains("audio/tos");
    }

    public static int a(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return 0;
    }

    public static String a(String... strArr) {
        for (String str : strArr) {
            if (str != null && !str.isEmpty() && !"null".equalsIgnoreCase(str)) {
                return str;
            }
        }
        return null;
    }
}
