package X;

import android.content.Context;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.Video;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class z2 {
    public static final Map a = Collections.synchronizedMap(new WeakHashMap());
    public static final ThreadLocal b = new ThreadLocal();
    public static Class c;
    public static Field d;
    public static Field e;
    public static Field f;
    public static Field g;
    public static Field h;
    public static Field i;
    public static Field j;
    public static Field k;
    public static Field l;
    public static Field m;
    public static Field n;
    public static Field o;
    public static Field p;
    public static Field q;
    public static Method r;
    public static Class s;

    public static void a() {
        try {
            p5 p5Var = j5.a;
            Class<?> cls = Class.forName("X.19N8");
            p5 p5Var2 = s4.a;
            c = Class.forName("com.ss.android.ugc.trill.download.protocol.download.AwemeVideoDownloadAbilityProtocol");
            p5 p5Var3 = m5.a;
            s = Class.forName("X.10Fc");
            p5 p5Var4 = n5.a;
            Class<?> cls2 = Class.forName("X.0yku");
            p5 p5Var5 = l5.a;
            Class<?> cls3 = Class.forName("X.0Whj");
            d = j5.a.a(cls);
            e = j5.b.a(cls);
            f = s4.a.a(c);
            g = s4.b.a(c);
            h = m5.a.a(s);
            i = m5.d.a(s);
            j = l5.a.a(cls3);
            k = n5.a.a(cls2);
            l = n5.b.a(cls2);
            m = m5.c.a(s);
            n = m5.b.a(s);
            o = j5.d.a(cls);
            p = j5.c.a(cls);
            q = j5.e.a(cls);
            r = m5.e.a(s, new Class[0]);
            try {
                x5 x5Var = k5.a;
                HookBridge.hookAllMethods(Class.forName("X.19N5"), k5.a.c[0], new y2());
                int i2 = p4.a;
            } catch (Throwable th) {
                th.getMessage();
                int i3 = p4.a;
            }
            HookBridge.hookAllMethods(cls, j5.f.c[0], new x2());
        } catch (Exception e2) {
            e2.getMessage();
            int i4 = p4.a;
        }
    }

    public static void b() {
        try {
            w2 w2Var = new w2();
            HookBridge.hookAllMethods(Video.class, "getDownloadAddr", w2Var);
            HookBridge.hookAllMethods(Video.class, "getNewDownloadAddr", w2Var);
            HookBridge.hookAllMethods(Video.class, "getDownloadNoWatermarkAddr", w2Var);
            a();
            d3.a();
        } catch (Exception e2) {
            e2.getMessage();
            int i2 = p4.a;
        }
    }

    public static String b(UrlModel urlModel) {
        String str;
        String urlKey = urlModel != null ? urlModel.getUrlKey() : null;
        String uri = urlModel != null ? urlModel.getUri() : null;
        List urlList = urlModel != null ? urlModel.getUrlList() : null;
        String[] strArr = {urlKey, uri, (urlList == null || urlList.isEmpty()) ? null : (String) urlList.get(0)};
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                str = null;
                break;
            }
            str = strArr[i2];
            if (b(str)) {
                break;
            }
            i2++;
        }
        if (str == null) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8));
            char[] cArr = new char[bArrDigest.length * 2];
            char[] charArray = "0123456789abcdef".toCharArray();
            for (int i3 = 0; i3 < bArrDigest.length; i3++) {
                byte b2 = bArrDigest[i3];
                int i4 = i3 * 2;
                cArr[i4] = charArray[(b2 & 255) >>> 4];
                cArr[i4 + 1] = charArray[b2 & 15];
            }
            return new String(cArr);
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean b(String str) {
        return (str == null || str.isEmpty() || "null".equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean a(final Member member, final Object obj, Object[] objArr) throws IllegalAccessException {
        Aweme aweme;
        final Video video;
        UrlModel urlModel;
        if (Boolean.TRUE.equals(b.get())) {
            return false;
        }
        Object obj2 = j.get(obj);
        if (!(obj2 instanceof Aweme) || (video = (aweme = (Aweme) obj2).getVideo()) == null) {
            return false;
        }
        a.remove(video);
        Object obj3 = i.get(obj);
        if (obj3 == null) {
            urlModel = null;
        } else {
            Object obj4 = k.get(obj3);
            urlModel = obj4 instanceof UrlModel ? (UrlModel) obj4 : null;
        }
        List listA = h3.a(aweme, video, urlModel, "qualityPicker.factory");
        if (listA.isEmpty()) {
            UrlModel urlModelA = a(obj, urlModel);
            a(obj);
            a((Object) null, obj, obj3);
            a(urlModelA);
            int i2 = p4.a;
            return true;
        }
        listA.size();
        int i3 = p4.a;
        Context context = (Context) h.get(obj);
        final Object[] objArr2 = objArr != null ? (Object[]) objArr.clone() : new Object[]{obj};
        if (!f3.a(context, listA, new e3() {
            @Override
            public final void a(g3 g3Var) {
                z2.a(obj, video, member, objArr2, g3Var);
            }
        })) {
            UrlModel urlModelA2 = a(obj, urlModel);
            a(obj);
            a((Object) null, obj, obj3);
            a(urlModelA2);
        }
        return true;
    }

    public static  void a(Object obj, Video video, Member member, Object[] objArr, g3 g3Var) {
        try {
            if (!a(obj, video, g3Var)) {
                int i2 = p4.a;
                return;
            }
            b.set(Boolean.TRUE);
            try {
                HookBridge.invokeOriginalMethod(member, (Object) null, objArr);
            } finally {
                b.remove();
            }
        } catch (Throwable th) {
            th.getMessage();
            int i3 = p4.a;
        }
    }

    public static boolean a(final Object obj, final Member member) throws IllegalAccessException {
        final Object obj2;
        Aweme aweme;
        final Video video;
        UrlModel urlModel;
        if (obj == null || Boolean.TRUE.equals(b.get())) {
            return false;
        }
        final Object obj3 = d.get(obj);
        if (!c.isInstance(obj3) || (obj2 = f.get(obj3)) == null) {
            return false;
        }
        Object obj4 = j.get(obj2);
        if (!(obj4 instanceof Aweme) || (video = (aweme = (Aweme) obj4).getVideo()) == null) {
            return false;
        }
        a.remove(video);
        Object obj5 = i.get(obj2);
        if (obj5 == null) {
            urlModel = null;
        } else {
            Object obj6 = k.get(obj5);
            urlModel = obj6 instanceof UrlModel ? (UrlModel) obj6 : null;
        }
        UrlModel urlModelA = a(obj2, urlModel);
        if (a(a(o, obj)) || a(a(p, obj)) || a(a(q, obj)) || a(a(m, obj2)) || a(a(l, obj5))) {
            String strB = b(urlModelA);
            if (!b(strB)) {
                a(obj, obj2, obj5);
                a(urlModelA);
                int i2 = p4.a;
            } else if (a(obj, obj2, obj5, strB, (String) null)) {
                a(urlModelA);
                int i3 = p4.a;
            }
        }
        List listA = h3.a(aweme, video, urlModel, "qualityPicker");
        if (listA.isEmpty()) {
            a(obj, obj2, obj5);
            a(urlModelA);
            int i4 = p4.a;
            return true;
        }
        listA.size();
        int i5 = p4.a;
        if (!f3.a((Context) h.get(obj2), listA, new e3() {
            @Override
            public final void a(g3 g3Var) {
                z2.a(obj, obj3, obj2, video, member, g3Var);
            }
        })) {
            a(obj, obj2, obj5);
            a(urlModelA);
        }
        return true;
    }

    public static  void a(Object obj, Object obj2, Object obj3, Video video, Member member, g3 g3Var) {
        try {
            if (!a(obj, obj2, obj3, video, g3Var)) {
                int i2 = p4.a;
            } else {
                HookBridge.invokeOriginalMethod(member, obj, new Object[0]);
            }
        } catch (Throwable th) {
            th.getMessage();
            int i3 = p4.a;
        }
    }

    public static boolean a(Object obj, Object obj2, Object obj3, Video video, g3 g3Var) throws IllegalAccessException {
        UrlModel urlModel;
        UrlModel urlModel2;
        if (g3Var != null && (urlModel = g3Var.a) != null) {
            String strB = b(urlModel);
            if (!b(strB)) {
                int i2 = p4.a;
                return false;
            }
            Object obj4 = i.get(obj3);
            String str = null;
            if (obj4 == null) {
                urlModel2 = null;
            } else {
                Object obj5 = k.get(obj4);
                urlModel2 = obj5 instanceof UrlModel ? (UrlModel) obj5 : null;
                k.set(obj4, g3Var.a);
            }
            List urlList = g3Var.a.getUrlList();
            if (urlList != null && !urlList.isEmpty()) {
                Object obj6 = g.get(obj2);
                if (obj6 instanceof List) {
                    List list = (List) obj6;
                    list.clear();
                    list.addAll(urlList);
                } else {
                    g.set(obj2, new ArrayList(urlList));
                }
                if (g3Var.g) {
                    str = ".mp3";
                } else {
                    Object obj7 = n.get(obj3);
                    if (obj7 instanceof String) {
                        String str2 = (String) obj7;
                        if (!str2.isEmpty()) {
                            str = str2;
                        }
                    }
                }
                if (!a(obj, obj3, obj4, strB, str)) {
                    int i3 = p4.a;
                    return false;
                }
                e.setInt(obj, 0);
                if (video != null) {
                    a.put(video, g3Var);
                }
                h3.a(g3Var, urlModel2);
                return true;
            }
            int i4 = p4.a;
        }
        return false;
    }

    public static boolean a(Object obj, Video video, g3 g3Var) throws IllegalAccessException {
        UrlModel urlModel;
        if (g3Var == null || (urlModel = g3Var.a) == null) {
            return false;
        }
        String strB = b(urlModel);
        if (!b(strB)) {
            int i2 = p4.a;
            return false;
        }
        Object obj2 = i.get(obj);
        UrlModel urlModel2 = null;
        if (obj2 != null) {
            Object obj3 = k.get(obj2);
            urlModel2 = obj3 instanceof UrlModel ? (UrlModel) obj3 : null;
            k.set(obj2, g3Var.a);
            l.set(obj2, strB);
        }
        if (g3Var.g) {
            n.set(obj, ".mp3");
        }
        m.set(obj, strB);
        if (video != null) {
            a.put(video, g3Var);
        }
        h3.a(g3Var, urlModel2);
        return true;
    }

    public static UrlModel a(Object obj, UrlModel urlModel) {
        Video video;
        if (!b(b(urlModel))) {
            try {
                Object obj2 = j.get(obj);
                if ((obj2 instanceof Aweme) && (video = ((Aweme) obj2).getVideo()) != null) {
                    UrlModel[] urlModelArr = {(UrlModel) g8.c(video, "getDownloadNoWatermarkAddr"), (UrlModel) g8.c(video, "getDownloadAddr"), (UrlModel) g8.c(video, "getNewDownloadAddr"), (UrlModel) g8.c(video, "getPlayAddr"), (UrlModel) g8.c(video, "getH264PlayAddr"), (UrlModel) g8.c(video, "getPlayAddrBytevc1")};
                    for (int i2 = 0; i2 < 6; i2++) {
                        UrlModel urlModel2 = urlModelArr[i2];
                        if (b(b(urlModel2))) {
                            return urlModel2;
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        return urlModel;
    }

    public static void a(Object obj) {
        if (obj != null) {
            try {
                if (a(a(m, obj))) {
                    Object obj2 = i.get(obj);
                    UrlModel urlModel = null;
                    if (obj2 != null) {
                        Object obj3 = k.get(obj2);
                        if (obj3 instanceof UrlModel) {
                            urlModel = (UrlModel) obj3;
                        }
                    }
                    UrlModel urlModelA = a(obj, urlModel);
                    String strB = b(urlModelA);
                    if (!b(strB)) {
                        m.get(obj);
                        a(urlModelA);
                        int i2 = p4.a;
                    } else {
                        if (obj2 != null) {
                            l.set(obj2, strB);
                        }
                        m.set(obj, strB);
                        a(urlModelA);
                        int i3 = p4.a;
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
                int i4 = p4.a;
            }
        }
    }

    public static void a(Object obj, Object obj2, Object obj3) {
        a(o, obj);
        a(m, obj2);
        a(l, obj3);
    }

    public static String a(Field field, Object obj) {
        if (field != null && obj != null) {
            try {
                Object obj2 = field.get(obj);
                if (obj2 instanceof String) {
                    return (String) obj2;
                }
                return null;
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public static boolean a(String str) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (!"null".equals(lowerCase) && !lowerCase.startsWith("null.") && !lowerCase.startsWith("null_") && !lowerCase.endsWith("/null") && !lowerCase.contains("/null.") && !lowerCase.contains("/null_")) {
                return false;
            }
        }
        return true;
    }

    public static void a(UrlModel urlModel) {
        if (urlModel == null) {
            return;
        }
        urlModel.getUrlKey();
        urlModel.getUri();
        List urlList = urlModel.getUrlList();
        if (urlList != null) {
            urlList.size();
        }
    }

    public static boolean a(Object obj, Object obj2, Object obj3, String str, String str2) {
        String str3;
        String str4;
        if (obj3 != null) {
            try {
                l.set(obj3, str);
            } catch (Throwable th) {
                th.getMessage();
                int i2 = p4.a;
                return false;
            }
        }
        m.set(obj2, str);
        if (str2 != null) {
            n.set(obj2, str2);
        }
        Object obj4 = o.get(obj);
        if (obj4 instanceof String) {
            str3 = (String) obj4;
            if (str3.isEmpty()) {
                str3 = null;
            }
        } else {
            str3 = null;
        }
        String str5 = (str3 == null || !str3.endsWith("_download")) ? str : str + "_download";
        o.set(obj, str5);
        Object objInvoke = r.invoke(obj2, null);
        if (objInvoke instanceof String) {
            str4 = (String) objInvoke;
            if (str4.isEmpty()) {
                str4 = null;
            }
        } else {
            str4 = null;
        }
        if (str2 == null) {
            Object obj5 = n.get(obj2);
            if (obj5 instanceof String) {
                str2 = (String) obj5;
                if (str2.isEmpty()) {
                    str2 = null;
                }
            } else {
                str2 = null;
            }
        }
        if (str4 == null) {
            str4 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        p.set(obj, str4 + str + str2);
        q.set(obj, str4 + str5 + str2);
        return true;
    }
}
