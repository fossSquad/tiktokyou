package X;

import android.graphics.Bitmap;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageInfo;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import com.windukk.hook.HookBridge;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public abstract class n9 {
    public static final ThreadLocal a = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });
    public static final ThreadLocal b = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });
    public static final ThreadLocal c = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });
    public static final Set d = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    public static final AtomicInteger e = new AtomicInteger(0);

    public static void a() {
        try {
            k9 k9Var = new k9();
            HookBridge.hookAllMethods(Aweme.class, "getPhotoModeImageInfo", new l9());
            HookBridge.hookAllMethods(PhotoModeImageInfo.class, "getImageList", k9Var);
            HookBridge.hookAllMethods(PhotoModeImageInfo.class, "getImagePostCover", k9Var);
            int i = g5.a;
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
    }

    public static void b() {
        try {
            k6 k6Var = r7.a;
            Class<?> cls = Class.forName("X.0nTy");
            HookBridge.hookAllMethods(cls, r7.b.c[0], new i9());
            int i = g5.a;
            try {
                HookBridge.hookAllMethods(cls, r7.c.c[0], new m9());
            } catch (Throwable th) {
                th.getMessage();
                int i2 = g5.a;
            }
        } catch (Throwable th2) {
            th2.getMessage();
            int i3 = g5.a;
        }
        try {
            t6 t6Var = f8.a;
            Class<?> cls2 = Class.forName("com.ss.android.ugc.aweme.watermark.WaterMarkServiceImpl");
            try {
                HookBridge.hookAllMethods(cls2, f8.a.c[0], new b9());
            } catch (Throwable th3) {
                th3.getMessage();
                int i4 = g5.a;
            }
            a(cls2, "addWaterMarkToImage", 1, 2);
            a(cls2, "addAIPortraitWatermarkToImage", 0, 1);
            a(cls2, "addAITextImageWaterMarkToImage", 0, 1);
            a(cls2, "addAiChatWaterMarkToImage", 0, 1);
            try {
                HookBridge.hookAllMethods(cls2, "createWaterMarkFile", new d9());
            } catch (Throwable th4) {
                th4.getMessage();
                int i5 = g5.a;
            }
        } catch (Throwable th5) {
            th5.getMessage();
            int i6 = g5.a;
        }
        try {
            t6 t6Var2 = j6.a;
            HookBridge.hookAllMethods(Class.forName("X.0X1F"), j6.a.c[0], new a9());
        } catch (Throwable th6) {
            th6.getMessage();
            int i7 = g5.a;
        }
    }

    public static void c() {
        try {
            e9 e9Var = new e9();
            HookBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getOwnerWatermarkImage", e9Var);
            HookBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getUserWatermarkImage", e9Var);
            HookBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getDisplayImageNoWatermark", e9Var);
            int i = g5.a;
            a();
            try {
                t6 t6Var = y6.a;
                HookBridge.hookAllMethods(Class.forName("X.0nJR"), y6.a.c[0], new j9());
            } catch (Throwable th) {
                th.getMessage();
                int i2 = g5.a;
            }
            b();
            try {
                HookBridge.hookAllMethods(DownloadInfo.class, "setUrl", new f9());
            } catch (Exception e2) {
                e2.getMessage();
                int i3 = g5.a;
            }
            try {
                HookBridge.hookAllMethods(DownloadTask.class, "url", new g9());
            } catch (Exception e3) {
                e3.getMessage();
                int i4 = g5.a;
            }
            try {
                HookBridge.hookAllMethods(UrlModel.class, "getUrlList", new h9());
            } catch (Exception e4) {
                e4.getMessage();
                int i5 = g5.a;
            }
        } catch (Exception e5) {
            e5.getMessage();
            int i6 = g5.a;
        }
    }

    public static void a(Class cls, String str, int i, int i2) {
        try {
            HookBridge.hookAllMethods(cls, str, new c9(i, i2, str));
            int i3 = g5.a;
        } catch (Throwable th) {
            th.getMessage();
            int i4 = g5.a;
        }
    }

    public static boolean a(Object obj) {
        String str;
        String str2;
        try {
            Object obj2 = ha.a((Class) obj.getClass(), e8.a.c[0]).get(obj);
            str = obj2 instanceof String ? (String) obj2 : null;
        } catch (Throwable th) {
        }
        try {
            Object obj3 = ha.a((Class) obj.getClass(), e8.b.c[0]).get(obj);
            str2 = obj3 instanceof String ? (String) obj3 : null;
        } catch (Throwable th2) {
        }
        Object objA = ha.a(obj, e8.c.c[0], Object.class);
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty() && objA != null) {
            try {
                a(str, str2);
                ha.a(objA.getClass(), "onStart", new Class[0]).invoke(objA, null);
                ha.a(objA.getClass(), "onProgress", Integer.TYPE).invoke(objA, 100);
                ha.a(objA.getClass(), "onSuccess", String.class).invoke(objA, str2);
                return true;
            } catch (Throwable th3) {
                th3.getMessage();
                int i = g5.a;
            }
        }
        return false;
    }

    public static boolean a(Object[] objArr, int i, int i2) throws IOException {
        if (objArr != null && objArr.length > i && objArr.length > i2) {
            Object obj = objArr[i];
            if (obj instanceof String) {
                Object obj2 = objArr[i2];
                if (obj2 instanceof String) {
                    String str = (String) obj;
                    String str2 = (String) obj2;
                    if (!str.isEmpty() && !str2.isEmpty()) {
                        a(str, str2);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void a(String str, String str2) throws IOException {
        File file = new File(str);
        File file2 = new File(str2);
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IllegalStateException("failed to create " + parentFile);
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
            try {
                byte[] bArr = new byte[65536];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return;
                    }
                    try {
                        fileInputStream.close();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            fileInputStream.close();
            throw th4;
        }
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.contains("nowatermark") || lowerCase.contains("no_watermark") || lowerCase.contains("without_watermark") || lowerCase.contains("watermark=0") || lowerCase.contains("watermark%3d0") || lowerCase.contains("water_mark=0") || lowerCase.contains("water_mark%3d0")) {
            return false;
        }
        return lowerCase.contains("watermark") || lowerCase.contains("water_mark");
    }

    public static String a(Aweme aweme, int i) {
        Object objB;
        PhotoModeImageUrlModel photoModeImageUrlModel;
        Object objB2 = ha.b(aweme, "getPhotoModeImageInfo");
        List listA = ha.a(objB2, "getImageList");
        if (listA != null && i >= 0 && i < listA.size()) {
            Object obj = listA.get(i);
            if (obj instanceof PhotoModeImageUrlModel) {
                photoModeImageUrlModel = (PhotoModeImageUrlModel) obj;
            } else {
                objB = ha.b(objB2, "getImagePostCover");
                if (objB instanceof PhotoModeImageUrlModel) {
                    photoModeImageUrlModel = (PhotoModeImageUrlModel) objB;
                } else {
                    photoModeImageUrlModel = null;
                }
            }
        } else {
            objB = ha.b(objB2, "getImagePostCover");
            if (objB instanceof PhotoModeImageUrlModel) {
                photoModeImageUrlModel = (PhotoModeImageUrlModel) objB;
            } else {
                photoModeImageUrlModel = null;
            }
        }
        UrlModel urlModelB = b(photoModeImageUrlModel);
        List<String> urlList = urlModelB != null ? urlModelB.getUrlList() : null;
        if (urlList == null || urlList.isEmpty()) {
            return null;
        }
        for (String str : urlList) {
            if (str != null && !str.startsWith("file")) {
                return str;
            }
        }
        return (String) urlList.get(0);
    }

    public static void b(String str) {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.isDirectory() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IllegalStateException("failed to create " + parentFile);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            try {
                bitmapCreateBitmap.eraseColor(0);
                if (bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                    fileOutputStream.close();
                    bitmapCreateBitmap.recycle();
                    return;
                }
                throw new IllegalStateException("failed to write transparent watermark");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            bitmapCreateBitmap.recycle();
            throw th3;
        }
        bitmapCreateBitmap.recycle();
        throw th3;
    }

    public static void a(PhotoModeImageUrlModel photoModeImageUrlModel) {
        if (e.getAndIncrement() >= 20) {
            return;
        }
        try {
            List list = (List) ha.a((Class) photoModeImageUrlModel.getClass(), "bitrateImages").get(photoModeImageUrlModel);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Object obj = list.get(i);
                    Method methodA = ha.a(obj.getClass(), "getName", new Class[0]);
                    Method methodA2 = ha.a(obj.getClass(), "getImage", new Class[0]);
                }
            }
        } catch (Exception e2) {
        }
    }

    public static void c(PhotoModeImageUrlModel photoModeImageUrlModel) {
        UrlModel urlModelB;
        if (photoModeImageUrlModel != null) {
            Set set = d;
            if (set.contains(photoModeImageUrlModel) || (urlModelB = b(photoModeImageUrlModel)) == null || urlModelB.getUrlList() == null || urlModelB.getUrlList().isEmpty()) {
                return;
            }
            try {
                Object obj = ha.a((Class) photoModeImageUrlModel.getClass(), "ownerWatermarkImage").get(photoModeImageUrlModel);
                Object obj2 = ha.a((Class) photoModeImageUrlModel.getClass(), "userWatermarkImage").get(photoModeImageUrlModel);
                if (obj != urlModelB) {
                    ha.a((Class) photoModeImageUrlModel.getClass(), "ownerWatermarkImage").set(photoModeImageUrlModel, urlModelB);
                }
                if (obj2 != urlModelB) {
                    ha.a((Class) photoModeImageUrlModel.getClass(), "userWatermarkImage").set(photoModeImageUrlModel, urlModelB);
                }
                set.add(photoModeImageUrlModel);
            } catch (Throwable th) {
                th.getMessage();
                int i = g5.a;
            }
        }
    }

    public static void b(Object obj) {
        if (obj instanceof PhotoModeImageInfo) {
            Boolean bool = Boolean.TRUE;
            ThreadLocal threadLocal = c;
            if (bool.equals(threadLocal.get())) {
                return;
            }
            try {
                threadLocal.set(bool);
                PhotoModeImageInfo photoModeImageInfo = (PhotoModeImageInfo) obj;
                List imageList = photoModeImageInfo.getImageList();
                if (imageList != null && !imageList.isEmpty()) {
                    for (Object obj2 : imageList) {
                        if (obj2 instanceof PhotoModeImageUrlModel) {
                            c((PhotoModeImageUrlModel) obj2);
                        }
                    }
                }
                c(photoModeImageInfo.getImagePostCover());
                threadLocal.set(Boolean.FALSE);
            } catch (Throwable th) {
                try {
                    th.getMessage();
                    int i = g5.a;
                } finally {
                    c.set(Boolean.FALSE);
                }
            }
        }
    }

    public static UrlModel b(PhotoModeImageUrlModel photoModeImageUrlModel) {
        try {
            UrlModel urlModel = (UrlModel) ha.a((Class) photoModeImageUrlModel.getClass(), "displayImageNoWatermark").get(photoModeImageUrlModel);
            if ((urlModel == null || urlModel.getUrlList() == null || urlModel.getUrlList().isEmpty()) ? false : true) {
                return urlModel;
            }
            List list = (List) ha.a((Class) photoModeImageUrlModel.getClass(), "bitrateImages").get(photoModeImageUrlModel);
            if (list != null && !list.isEmpty()) {
                for (Object obj : list) {
                    UrlModel urlModel2 = (UrlModel) ha.a(obj.getClass(), "getImage", new Class[0]).invoke(obj, null);
                    if ((urlModel2 == null || urlModel2.getUrlList() == null || urlModel2.getUrlList().isEmpty()) ? false : true) {
                        int i = g5.a;
                        return urlModel2;
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
            int i2 = g5.a;
        }
        return null;
    }
}
