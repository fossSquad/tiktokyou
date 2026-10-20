package Z;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageInfo;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import com.windukk.hook.HookBridge;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.io.FilesKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

public final class qd {
    public static final qd a = new qd();
    public static final ThreadLocal b = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return qd.h();
        }
    });
    public static final ThreadLocal c = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return qd.j();
        }
    });
    public static final Set d;
    public static Field e;
    public static Field f;
    public static Field g;
    public static Field h;
    public static Field i;
    public static Field j;
    public static Field k;
    public static Method l;
    public static Method m;
    public static Field n;
    public static Field o;
    public static Field p;
    public static Field q;
    public static Method r;
    public static Method s;
    public static Method t;
    public static Object u;
    public static final Set v;

    static {
        Set setSynchronizedSet = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        d = setSynchronizedSet;
        v = SetsKt.setOf(new String[]{"vvic", "heic", "heix", "hevc", "hevx", "mif1", "msf1"});
    }

    public static UrlModel a(PhotoModeImageUrlModel photoModeImageUrlModel) throws IllegalAccessException {
        Field field = e;
        if (field == null) {
            field = null;
        }
        Object obj = field.get(photoModeImageUrlModel);
        UrlModel urlModel = obj instanceof UrlModel ? (UrlModel) obj : null;
        if (!a(urlModel).isEmpty()) {
            return urlModel;
        }
        Field field2 = h;
        if (field2 == null) {
            field2 = null;
        }
        Object obj2 = field2.get(photoModeImageUrlModel);
        List list = obj2 instanceof List ? (List) obj2 : null;
        if (list != null && !list.isEmpty()) {
            for (Object obj3 : list) {
                if (obj3 != null) {
                    Field field3 = j;
                    if (field3 == null) {
                        field3 = null;
                    }
                    Object obj4 = field3.get(obj3);
                    UrlModel urlModel2 = obj4 instanceof UrlModel ? (UrlModel) obj4 : null;
                    if (!a(urlModel2).isEmpty()) {
                        return urlModel2;
                    }
                }
            }
        }
        return null;
    }

    public static void b() throws ClassNotFoundException {
        v9 v9Var = v8.a;
        Class<?> cls = Class.forName("X.1Hu0");
        String str = v8.a.c[0];
        HookBridge.hookAllMethods(cls, str, new qd$after$1());
    }

    public static void c() throws ClassNotFoundException {
        v9 v9Var = ba.a;
        Class<?> cls = Class.forName("X.0W3Y");
        String str = ba.a.c[0];
        HookBridge.hookAllMethods(cls, str, new qd$before$1());
    }

    public static void d() throws ClassNotFoundException {
        v9 v9Var = ca.a;
        Class<?> cls = Class.forName("X.0W4G");
        String str = ca.a.c[0];
        HookBridge.hookAllMethods(cls, str, new qd$after$2());
    }

    public static void e() {
        String str = ea.a.c[0];
        HookBridge.hookAllMethods(PhotoModeImageInfo.class, str, new qd$after$3());
        String str2 = ea.b.c[0];
        HookBridge.hookAllMethods(PhotoModeImageInfo.class, str2, new qd$after$4());
        String str3 = r7.a.c[0];
        HookBridge.hookAllMethods(Aweme.class, str3, new qd$after$5());
    }

    public static void f() throws ClassNotFoundException {
        e9 e9Var = eb.a;
        Class<?> cls = Class.forName("X.1IFX");
        String str = eb.b.c[0];
        HookBridge.hookAllMethods(cls, str, new qd$before$2());
    }

    public static void g() throws ClassNotFoundException {
        v9 v9Var = vb.a;
        Class<?> cls = Class.forName("com.ss.android.ugc.aweme.watermark.WaterMarkServiceImpl");
        String str = vb.a.c[0];
        HookBridge.hookAllMethods(cls, str, new qd$before$3());
        String str2 = vb.b.c[0];
        HookBridge.hookAllMethods(cls, str2, new qd$before$4());
        v9 v9Var2 = vb.c;
        a(cls, v9Var2, 1, 2);
        v9 v9Var3 = vb.d;
        a(cls, v9Var3, 0, 1);
        v9 v9Var4 = vb.e;
        a(cls, v9Var4, 0, 1);
        v9 v9Var5 = vb.f;
        a(cls, v9Var5, 0, 1);
        String str3 = vb.h.c[0];
        HookBridge.hookAllMethods(cls, str3, new qd$before$5());
        String str4 = vb.g.c[0];
        HookBridge.hookAllMethods(cls, str4, new qd$before$6());
    }

    public static final Boolean h() {
        return Boolean.FALSE;
    }

    public static final void i() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        try {
            Result.Companion companion = Result.Companion;
            l();
            e();
            d();
            obj = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Photo URL hooks unavailable", new Object[0]), th2);
        }
        try {
            Result.Companion companion3 = Result.Companion;
            k();
            c();
            obj2 = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = ResultCompat.constructor(ResultKt.createFailure(th3));
        }
        Throwable th4 = ResultCompat.exceptionOrNull(obj2);
        if (th4 != null) {
            g7.a(6, g7.a("Photo VVIC conversion hook unavailable", new Object[0]), th4);
        }
        try {
            Result.Companion companion5 = Result.Companion;
            m();
            f();
            g();
            obj3 = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion6 = Result.Companion;
            obj3 = ResultCompat.constructor(ResultKt.createFailure(th5));
        }
        Throwable th6 = ResultCompat.exceptionOrNull(obj3);
        if (th6 != null) {
            g7.a(6, g7.a("Photo watermark hooks unavailable", new Object[0]), th6);
        }
        try {
            Result.Companion companion7 = Result.Companion;
            b();
            obj4 = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th7) {
            Result.Companion companion8 = Result.Companion;
            obj4 = ResultCompat.constructor(ResultKt.createFailure(th7));
        }
        Throwable th8 = ResultCompat.exceptionOrNull(obj4);
        if (th8 != null) {
            g7.a(6, g7.a("Edit-save watermark gate hook unavailable", new Object[0]), th8);
        }
        try {
            Result.Companion companion9 = Result.Companion;
            AtomicBoolean atomicBoolean = d4.a;
            d4.c();
            obj5 = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th9) {
            Result.Companion companion10 = Result.Companion;
            obj5 = ResultCompat.constructor(ResultKt.createFailure(th9));
        }
        Throwable th10 = ResultCompat.exceptionOrNull(obj5);
        if (th10 != null) {
            g7.a(6, g7.a("Photo MediaStore path hook unavailable", new Object[0]), th10);
        }
    }

    public static final Boolean j() {
        return Boolean.FALSE;
    }

    public static void k() throws NoSuchMethodException, ClassNotFoundException {
        v9 v9Var = fb.a;
        Class<?> cls = Class.forName("com.ss.android.socialbase.downloader.model.DownloadInfo");
        Method methodA = fb.a.a(cls, new Class[0]);
        r = methodA;
        Method methodA2 = fb.b.a(cls, new Class[0]);
        s = methodA2;
    }

    public static void l() throws NoSuchFieldException, NoSuchMethodException, ClassNotFoundException {
        e9 e9Var = fa.a;
        Class<?> cls = Class.forName("com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel");
        Field fieldA = fa.a.a(cls);
        e = fieldA;
        Field fieldA2 = fa.b.a(cls);
        f = fieldA2;
        Field fieldA3 = fa.c.a(cls);
        g = fieldA3;
        Field fieldA4 = fa.d.a(cls);
        h = fieldA4;
        Field fieldA5 = fa.e.a(cls);
        i = fieldA5;
        e9 e9Var2 = w9.a;
        Field fieldA6 = w9.a.a(Class.forName("com.ss.android.ugc.aweme.feed.model.MultiImageUrlInfo"));
        j = fieldA6;
        e9 e9Var3 = q9.a;
        Field fieldA7 = q9.a.a(Class.forName("com.ss.android.ugc.aweme.feed.model.LivePhotoStruct"));
        k = fieldA7;
        v9 v9Var = ga.a;
        Class<?> cls2 = Class.forName("com.ss.android.ugc.aweme.feed.model.Video");
        Method methodA = ga.a.a(cls2, new Class[0]);
        l = methodA;
        Method methodA2 = ga.b.a(cls2, new Class[0]);
        m = methodA2;
    }

    public static void m() throws NoSuchFieldException, ClassNotFoundException {
        e9 e9Var = eb.a;
        Field fieldA = eb.a.a(Class.forName("X.1IFX"));
        n = fieldA;
        e9 e9Var2 = tb.a;
        Class<?> cls = Class.forName("com.ss.android.ugc.aweme.services.watermark.WaterMarkBuilder");
        Field fieldA2 = tb.a.a(cls);
        o = fieldA2;
        Field fieldA3 = tb.b.a(cls);
        p = fieldA3;
        Field fieldA4 = tb.c.a(cls);
        q = fieldA4;
    }

    public static UrlModel a(PhotoModeImageUrlModel photoModeImageUrlModel, boolean z) throws IllegalAccessException, InvocationTargetException {
        Method method;
        String str;
        String str2;
        Field field = i;
        if (field == null) {
            field = null;
        }
        Object obj = field.get(photoModeImageUrlModel);
        if (obj == null) {
            return null;
        }
        Field field2 = k;
        if (field2 == null) {
            field2 = null;
        }
        Object obj2 = field2.get(obj);
        if (obj2 == null) {
            return null;
        }
        if (z) {
            method = m;
            if (method == null) {
                method = null;
            }
        } else {
            method = l;
            if (method == null) {
                method = null;
            }
        }
        Object objInvoke = method.invoke(obj2, null);
        if (objInvoke instanceof UrlModel) {
            return (UrlModel) objInvoke;
        }
        return null;
    }

    public static void b(Object obj) {
        if (obj instanceof PhotoModeImageInfo) {
            ThreadLocal threadLocal = c;
            Object obj2 = threadLocal.get();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(obj2, bool)) {
                return;
            }
            try {
                threadLocal.set(bool);
                ThreadLocal threadLocal2 = b;
                threadLocal2.set(bool);
                List list = ((PhotoModeImageInfo) obj).imageList;
                if (list != null && !list.isEmpty()) {
                    for (Object obj3 : list) {
                        if (obj3 instanceof PhotoModeImageUrlModel) {
                            b((PhotoModeImageUrlModel) obj3);
                        }
                    }
                }
                b(((PhotoModeImageInfo) obj).imagePostCover);
                Boolean bool2 = Boolean.FALSE;
                threadLocal2.set(bool2);
                threadLocal.set(bool2);
            } catch (Throwable th) {
                try {
                    g7.a(6, g7.a("Photo image info normalize failed", new Object[0]), th);
                } finally {
                    ThreadLocal threadLocal3 = b;
                    Boolean bool3 = Boolean.FALSE;
                    threadLocal3.set(bool3);
                    c.set(bool3);
                }
            }
        }
    }

    public static boolean c(String str) {
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        return StringsKt.contains$default(lowerCase, "vvic", false, 2, (Object) null) || StringsKt.contains$default(lowerCase, "heic", false, 2, (Object) null);
    }

    public static final String a(Aweme aweme, int i2, boolean z) throws IllegalAccessException, InvocationTargetException {
        PhotoModeImageUrlModel photoModeImageUrlModel;
        String str;
        UrlModel urlModelA;
        UrlModel urlModelA2;
        PhotoModeImageInfo photoModeImageInfo = aweme.photoModeImageInfo;
        List list = photoModeImageInfo != null ? photoModeImageInfo.imageList : null;
        if (list != null && i2 >= 0 && i2 < list.size()) {
            photoModeImageUrlModel = (PhotoModeImageUrlModel) list.get(i2);
        } else {
            photoModeImageUrlModel = photoModeImageInfo != null ? photoModeImageInfo.imagePostCover : null;
        }
        if (photoModeImageUrlModel == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(4);
        if (z && (urlModelA2 = a(photoModeImageUrlModel, true)) != null) {
            arrayList.add(urlModelA2);
        }
        UrlModel urlModelA3 = a(photoModeImageUrlModel);
        if (urlModelA3 != null) {
            arrayList.add(urlModelA3);
        }
        if (z && (urlModelA = a(photoModeImageUrlModel, false)) != null) {
            arrayList.add(urlModelA);
        }
        int size = arrayList.size();
        int i3 = 0;
        loop0: while (true) {
            if (i3 >= size) {
                str = null;
                break;
            }
            Object obj = arrayList.get(i3);
            i3++;
            ArrayList arrayListA = a((UrlModel) obj);
            int size2 = arrayListA.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayListA.get(i4);
                i4++;
                str = (String) obj2;
                if (!c(str)) {
                    break loop0;
                }
            }
        }
        if (str != null) {
            return str;
        }
        int size3 = arrayList.size();
        int i5 = 0;
        while (i5 < size3) {
            Object obj3 = arrayList.get(i5);
            i5++;
            ArrayList arrayListA2 = a((UrlModel) obj3);
            if (arrayListA2.size() > 0) {
                return (String) arrayListA2.get(0);
            }
        }
        return null;
    }

    public static void b(PhotoModeImageUrlModel photoModeImageUrlModel) throws IllegalAccessException {
        if (photoModeImageUrlModel == null || d.contains(photoModeImageUrlModel)) {
            return;
        }
        UrlModel urlModelA = a(photoModeImageUrlModel);
        Field field = null;
        if (urlModelA == null) {
            urlModelA = null;
        } else {
            ArrayList arrayListA = a(urlModelA);
            ArrayList arrayList = new ArrayList();
            int size = arrayListA.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayListA.get(i2);
                i2++;
                if (!c((String) obj)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                urlModelA = null;
            } else if (!Intrinsics.areEqual(arrayList, urlModelA.urlList)) {
                UrlModel urlModel = new UrlModel();
                urlModel.urlList = new ArrayList(arrayList);
                urlModel.uri = urlModelA.uri;
                urlModel.urlKey = urlModelA.urlKey;
                urlModel.width = urlModelA.width;
                urlModel.height = urlModelA.height;
                urlModel.size = urlModelA.size;
                urlModelA = urlModel;
            }
        }
        if (urlModelA == null) {
            return;
        }
        try {
            Field field2 = f;
            if (field2 == null) {
                field2 = null;
            }
            if (field2.get(photoModeImageUrlModel) != urlModelA) {
                Field field3 = f;
                if (field3 == null) {
                    field3 = null;
                }
                field3.set(photoModeImageUrlModel, urlModelA);
            }
            Field field4 = g;
            if (field4 == null) {
                field4 = null;
            }
            if (field4.get(photoModeImageUrlModel) != urlModelA) {
                Field field5 = g;
                if (field5 == null) {
                } else {
                    field = field5;
                }
                field.set(photoModeImageUrlModel, urlModelA);
            }
            d.add(photoModeImageUrlModel);
        } catch (Throwable th) {
            g7.a(6, g7.a("Watermark field normalize failed", new Object[0]), th);
        }
    }

    public static ArrayList a(UrlModel urlModel) {
        List listEmptyList = urlModel != null ? urlModel.urlList : null;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listEmptyList) {
            String str = (String) obj;
            if (str != null && !StringsKt.isBlank(str) && !StringsKt.startsWith$default(str, "file", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static String a(Object obj) throws IllegalAccessException, InvocationTargetException {
        Method method = r;
        if (method == null) {
            method = null;
        }
        Object objInvoke = method.invoke(obj, null);
        String str = objInvoke instanceof String ? (String) objInvoke : null;
        if (str == null) {
            return null;
        }
        Method method2 = s;
        if (method2 == null) {
            method2 = null;
        }
        Object objInvoke2 = method2.invoke(obj, null);
        String str2 = objInvoke2 instanceof String ? (String) objInvoke2 : null;
        if (str2 == null || str.length() == 0 || str2.length() == 0) {
            return null;
        }
        return (StringsKt.endsWith$default(str, "/", false, 2, (Object) null) ? new StringBuilder().append(str) : new StringBuilder().append(str).append("/")).append(str2).toString();
    }

    public static final boolean a(String str) throws FileNotFoundException, IOException {
        Throwable th5U = null;
        boolean zContains;
        Object obj;
        Bitmap bitmap = null;
        qd qdVar = a;
        File file = new File(str);
        if (!file.isFile() || file.length() < 12) {
            return false;
        }
        byte[] bArr = new byte[16];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            if (fileInputStream.read(bArr) < 12) {
                CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                return false;
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileInputStream, (Throwable) null);
            if (Arrays.equals(ArraysKt.copyOfRange(bArr, 4, 8), new byte[]{102, 116, 121, 112})) {
                Charset charset = StandardCharsets.US_ASCII;
                String str2 = new String(bArr, 8, 4, charset);
                Locale locale = Locale.ROOT;
                String lowerCase = str2.toLowerCase(locale);
                zContains = v.contains(lowerCase);
            } else {
                zContains = false;
            }
            if (!zContains) {
                return false;
            }
            byte[] bytes = FilesKt.readBytes(file);
            try {
                Result.Companion companion = Result.Companion;
                qdVar.a();
                Object obj2 = u;
                if (obj2 == null) {
                    bitmap = null;
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    Method method = t;
                    if (method == null) {
                        method = null;
                    }
                    Object objInvoke = method.invoke(obj2, bytes, 0, Integer.valueOf(bytes.length), options);
                    obj = ResultCompat.constructor(objInvoke instanceof Bitmap ? (Bitmap) objInvoke : null);
                    Throwable th = ResultCompat.exceptionOrNull(obj);
                    if (th != null) {
                        g7.a(6, g7.a("HeifBitmapFactory decode failed", new Object[0]), th);
                    }
                    if (ResultCompat.isFailure(obj)) {
                        obj = null;
                    }
                    bitmap = (Bitmap) obj;
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = ResultCompat.constructor(ResultKt.createFailure(th2));
            }
            if (bitmap == null) {
                return false;
            }
            File file2 = new File(file.getParentFile(), d3.a("XG8C/8X4J6nxP3t6AG9NoZqAg/xcjVgaZnQfdOxk5hs=", "mG6EAuQm5Hb7Z69q", "aes", new StringBuilder().append(file.getName())));
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream)) {
                        CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                        bitmap.recycle();
                        return false;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                    if (!file2.renameTo(file)) {
                        FilesKt.copyTo$default(file2, file, true, 0, 4, (Object) null);
                        file2.delete();
                    }
                    bitmap.recycle();
                    return true;
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(fileOutputStream, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                g7.a(6, g7.a("VVIC conversion failed for " + file.getName(), new Object[0]), th5);
                if (bitmap != null) {
                    bitmap.recycle();
                }
                file2.delete();
                return false;
            }
        } catch (Throwable th6) {
            try {
                throw th6;
            } catch (Throwable th7) {
                CloseableKt.closeFinally(fileInputStream, th6);
                throw th7;
            }
        }
    }

    public final synchronized void a() throws ClassNotFoundException, InstantiationException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (u != null) {
            return;
        }
        Class.forName("com.bytedance.fresco.nativeheif.Heif");
        v9 v9Var = i9.a;
        Class<?> cls = Class.forName("com.bytedance.fresco.heif.HeifBitmapFactoryImpl");
        v9 v9Var2 = i9.a;
        Class cls2 = Integer.TYPE;
        Method methodA = v9Var2.a(cls, byte[].class, cls2, cls2, BitmapFactory.Options.class);
        t = methodA;
        u = cls.getDeclaredConstructor(null).newInstance(null);
    }

    public static final boolean a(Object obj, String str, String str2) throws IllegalAccessException {
        Field field = o;
        Field field2 = null;
        if (field == null) {
            field = null;
        }
        Object obj2 = field.get(obj);
        String str3 = obj2 instanceof String ? (String) obj2 : null;
        if (str3 != null) {
            if (str3.length() <= 0) {
                str3 = null;
            }
            if (str3 != null) {
                str = str3;
            }
        }
        Field field3 = p;
        if (field3 == null) {
            field3 = null;
        }
        Object obj3 = field3.get(obj);
        String str4 = obj3 instanceof String ? (String) obj3 : null;
        if (str4 != null) {
            if (str4.length() <= 0) {
                str4 = null;
            }
            if (str4 != null) {
                str2 = str4;
            }
        }
        Field field4 = q;
        if (field4 == null) {
        } else {
            field2 = field4;
        }
        Object obj4 = field2.get(obj);
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0 && obj4 != null) {
            try {
                if (!a(str, str2)) {
                    return false;
                }
                v9 v9Var = ub.a;
                a(obj4, v9Var, new Object[0]);
                v9 v9Var2 = ub.b;
                a(obj4, v9Var2, 100);
                v9 v9Var3 = ub.c;
                a(obj4, v9Var3, str2);
                return true;
            } catch (Throwable th) {
                g7.a(6, g7.a("Watermark bypass failed", new Object[0]), th);
            }
        }
        return false;
    }

    public static void a(Object obj, v9 v9Var, Object... objArr) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<?> cls;
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i2 = 0; i2 < length; i2++) {
            Object obj2 = objArr[i2];
            if (obj2 instanceof Integer) {
                cls = Integer.TYPE;
            } else {
                cls = obj2 != null ? obj2.getClass() : String.class;
            }
            clsArr[i2] = cls;
        }
        v9Var.a(obj.getClass(), (Class[]) Arrays.copyOf(clsArr, length)).invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public static boolean a(String str, String str2) throws IOException {
        File file = new File(str);
        File file2 = new File(str2);
        if (!file.isFile()) {
            return false;
        }
        if (Intrinsics.areEqual(file.getCanonicalPath(), file2.getCanonicalPath())) {
            return true;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            return false;
        }
        try {
            FilesKt.copyTo$default(file, file2, true, 0, 4, (Object) null);
            return true;
        } catch (Throwable th) {
            g7.a(6, g7.a(di.a("rOMWWGw1d7OlFSa0XLGmX2exRza6rJYZVpBW8x/MrLo=", "RlPBmBBgM4RLlEj7", "aes", ve.a("7GBCQt1fFjcp5aBoDeTN27N+3Q6IzXUg8YXyx3VHEeM=", "Epd4uCYsCr2EZag0", "aes", new StringBuilder(), str), str2), new Object[0]), th);
            return false;
        }
    }

    public static final boolean b(String str) {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            return false;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmapCreateBitmap.eraseColor(0);
                boolean zCompress = bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                bitmapCreateBitmap.recycle();
                return zCompress;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                g7.a(6, g7.a("Failed to write transparent watermark", new Object[0]), th3);
                return false;
            } finally {
                bitmapCreateBitmap.recycle();
            }
        }
    }

    public static void a(Class cls, v9 v9Var, int i2, int i3) {
        String str = v9Var.c[0];
        HookBridge.hookAllMethods(cls, str, new qd$before$7(i2, i3, v9Var));
    }
}
