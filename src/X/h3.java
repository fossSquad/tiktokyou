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

public abstract class h3 {
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
            k6 k6Var = e6.a;
            Class<?> cls = Class.forName("X.16Mr");
            k6 k6Var2 = j5.a;
            c = Class.forName("com.ss.android.ugc.trill.download.protocol.download.AwemeVideoDownloadAbilityProtocol");
            k6 k6Var3 = h6.a;
            s = Class.forName("X.0nKr");
            k6 k6Var4 = i6.a;
            Class<?> cls2 = Class.forName("X.0nJn");
            k6 k6Var5 = g6.a;
            Class<?> cls3 = Class.forName("X.0nTo");
            d = e6.a.a(cls);
            e = e6.b.a(cls);
            f = j5.a.a(c);
            g = j5.b.a(c);
            h = h6.a.a(s);
            i = h6.d.a(s);
            j = g6.a.a(cls3);
            k = i6.a.a(cls2);
            l = i6.b.a(cls2);
            m = h6.c.a(s);
            n = h6.b.a(s);
            o = e6.d.a(cls);
            p = e6.c.a(cls);
            q = e6.e.a(cls);
            r = h6.e.a(s, new Class[0]);
            try {
                t6 t6Var = f6.a;
                HookBridge.hookAllMethods(Class.forName("X.16Mn"), f6.a.c[0], new g3());
                int i2 = g5.a;
            } catch (Throwable th) {
                th.getMessage();
                int i3 = g5.a;
            }
            HookBridge.hookAllMethods(cls, e6.f.c[0], new f3());
        } catch (Exception e2) {
            e2.getMessage();
            int i4 = g5.a;
        }
    }

    public static void b() {
        try {
            e3 e3Var = new e3();
            HookBridge.hookAllMethods(Video.class, "getDownloadAddr", e3Var);
            HookBridge.hookAllMethods(Video.class, "getNewDownloadAddr", e3Var);
            HookBridge.hookAllMethods(Video.class, "getDownloadNoWatermarkAddr", e3Var);
            a();
            l3.a();
        } catch (Exception e2) {
            e2.getMessage();
            int i2 = g5.a;
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
        Boolean bool = Boolean.TRUE;
        ThreadLocal threadLocal = b;
        if (bool.equals(threadLocal.get())) {
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
        List listA = p3.a(aweme, video, urlModel, "qualityPicker.factory");
        if (listA.isEmpty()) {
            UrlModel urlModelA = a(obj, urlModel);
            a(obj);
            a((Object) null, obj, obj3);
            a(urlModelA);
            int i2 = g5.a;
            return true;
        }
        listA.size();
        int i3 = g5.a;
        final Object[] objArr2 = objArr != null ? (Object[]) objArr.clone() : new Object[]{obj};
        if (l8.a().t) {
            if (!a(obj, video, (o3) listA.get(0))) {
                return true;
            }
            threadLocal.set(bool);
            try {
                HookBridge.invokeOriginalMethod(member, null, objArr2);
                return true;
            } finally {
                b.remove();
            }
        }
        if (!n3.a((Context) h.get(obj), listA, new m3() {
            @Override
            public final void a(o3 o3Var) {
                h3.a(obj, video, member, objArr2, o3Var);
            }
        })) {
            UrlModel urlModelA2 = a(obj, urlModel);
            a(obj);
            a((Object) null, obj, obj3);
            a(urlModelA2);
        }
        return true;
    }

    public static  void a(Object obj, Video video, Member member, Object[] objArr, o3 o3Var) {
        try {
            if (!a(obj, video, o3Var)) {
                int i2 = g5.a;
                return;
            }
            b.set(Boolean.TRUE);
            try {
                HookBridge.invokeOriginalMethod(member, null, objArr);
            } finally {
                b.remove();
            }
        } catch (Throwable th) {
            th.getMessage();
            int i3 = g5.a;
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
                int i2 = g5.a;
            } else if (a(obj, obj2, obj5, strB, (String) null)) {
                a(urlModelA);
                int i3 = g5.a;
            }
        }
        List listA = p3.a(aweme, video, urlModel, "qualityPicker");
        if (listA.isEmpty()) {
            a(obj, obj2, obj5);
            a(urlModelA);
            int i4 = g5.a;
            return true;
        }
        listA.size();
        int i5 = g5.a;
        if (l8.a().t) {
            if (!a(obj, obj3, obj2, video, (o3) listA.get(0))) {
                return true;
            }
            HookBridge.invokeOriginalMethod(member, obj, new Object[0]);
            return true;
        }
        if (!n3.a((Context) h.get(obj2), listA, new m3() {
            @Override
            public final void a(o3 o3Var) {
                h3.a(obj, obj3, obj2, video, member, o3Var);
            }
        })) {
            a(obj, obj2, obj5);
            a(urlModelA);
        }
        return true;
    }

    public static  void a(Object obj, Object obj2, Object obj3, Video video, Member member, o3 o3Var) {
        try {
            if (!a(obj, obj2, obj3, video, o3Var)) {
                int i2 = g5.a;
            } else {
                HookBridge.invokeOriginalMethod(member, obj, new Object[0]);
            }
        } catch (Throwable th) {
            th.getMessage();
            int i3 = g5.a;
        }
    }

    public static boolean a(Object obj, Object obj2, Object obj3, Video video, o3 o3Var) throws IllegalAccessException {
        UrlModel urlModel;
        UrlModel urlModel2;
        if (o3Var != null && (urlModel = o3Var.a) != null) {
            String strB = b(urlModel);
            if (!b(strB)) {
                int i2 = g5.a;
                return false;
            }
            Object obj4 = i.get(obj3);
            String str = null;
            if (obj4 == null) {
                urlModel2 = null;
            } else {
                Object obj5 = k.get(obj4);
                urlModel2 = obj5 instanceof UrlModel ? (UrlModel) obj5 : null;
                k.set(obj4, o3Var.a);
            }
            List urlList = o3Var.a.getUrlList();
            if (urlList != null && !urlList.isEmpty()) {
                Object obj6 = g.get(obj2);
                if (obj6 instanceof List) {
                    List list = (List) obj6;
                    list.clear();
                    list.addAll(urlList);
                } else {
                    g.set(obj2, new ArrayList(urlList));
                }
                if (o3Var.g) {
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
                    int i3 = g5.a;
                    return false;
                }
                e.setInt(obj, 0);
                if (video != null) {
                    a.put(video, o3Var);
                }
                p3.a(o3Var, urlModel2);
                return true;
            }
            int i4 = g5.a;
        }
        return false;
    }

    public static boolean a(Object obj, Video video, o3 o3Var) throws IllegalAccessException {
        UrlModel urlModel;
        if (o3Var == null || (urlModel = o3Var.a) == null) {
            return false;
        }
        String strB = b(urlModel);
        if (!b(strB)) {
            int i2 = g5.a;
            return false;
        }
        Object obj2 = i.get(obj);
        UrlModel urlModel2 = null;
        if (obj2 != null) {
            Object obj3 = k.get(obj2);
            urlModel2 = obj3 instanceof UrlModel ? (UrlModel) obj3 : null;
            k.set(obj2, o3Var.a);
            l.set(obj2, strB);
        }
        if (o3Var.g) {
            n.set(obj, ".mp3");
        }
        m.set(obj, strB);
        if (video != null) {
            a.put(video, o3Var);
        }
        p3.a(o3Var, urlModel2);
        return true;
    }

    public static UrlModel a(Object obj, UrlModel urlModel) {
        Video video;
        if (!b(b(urlModel))) {
            try {
                Object obj2 = j.get(obj);
                if ((obj2 instanceof Aweme) && (video = ((Aweme) obj2).getVideo()) != null) {
                    UrlModel[] urlModelArr = {(UrlModel) ha.c(video, "getDownloadNoWatermarkAddr"), (UrlModel) ha.c(video, "getDownloadAddr"), (UrlModel) ha.c(video, "getNewDownloadAddr"), (UrlModel) ha.c(video, "getPlayAddr"), (UrlModel) ha.c(video, "getH264PlayAddr"), (UrlModel) ha.c(video, "getPlayAddrBytevc1")};
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
                        int i2 = g5.a;
                    } else {
                        if (obj2 != null) {
                            l.set(obj2, strB);
                        }
                        m.set(obj, strB);
                        a(urlModelA);
                        int i3 = g5.a;
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
                int i4 = g5.a;
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
                int i2 = g5.a;
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
