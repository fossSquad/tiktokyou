package X;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import com.windukk.hook.HookBridge;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public abstract class q7 {
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
    public static final AtomicInteger c = new AtomicInteger(0);

    public static void a() {
        try {
            p5 p5Var = o6.a;
            HookBridge.hookAllMethods(Class.forName("X.0WgF"), o6.b.c[0], new n7());
            int i = p4.a;
        } catch (Throwable th) {
            th.getMessage();
            int i2 = p4.a;
        }
        try {
            x5 x5Var = b7.a;
            HookBridge.hookAllMethods(Class.forName("com.ss.android.ugc.aweme.watermark.WaterMarkServiceImpl"), b7.a.c[0], new p7());
        } catch (Throwable th2) {
            th2.getMessage();
            int i3 = p4.a;
        }
        try {
            x5 x5Var2 = o5.a;
            HookBridge.hookAllMethods(Class.forName("X.0W1d"), o5.a.c[0], new o7());
        } catch (Throwable th3) {
            th3.getMessage();
            int i4 = p4.a;
        }
    }

    public static void b() {
        try {
            j7 j7Var = new j7();
            HookBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getOwnerWatermarkImage", j7Var);
            HookBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getUserWatermarkImage", j7Var);
            HookBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getDisplayImageNoWatermark", j7Var);
            int i = p4.a;
            a();
            try {
                HookBridge.hookAllMethods(DownloadInfo.class, "setUrl", new k7());
            } catch (Exception e) {
                e.getMessage();
                int i2 = p4.a;
            }
            try {
                HookBridge.hookAllMethods(DownloadTask.class, "url", new l7());
            } catch (Exception e2) {
                e2.getMessage();
                int i3 = p4.a;
            }
            try {
                HookBridge.hookAllMethods(UrlModel.class, "getUrlList", new m7());
            } catch (Exception e3) {
                e3.getMessage();
                int i4 = p4.a;
            }
        } catch (Exception e4) {
            e4.getMessage();
            int i5 = p4.a;
        }
    }

    public static boolean a(Object obj) {
        String str;
        String str2;
        try {
            Object obj2 = g8.a((Class) obj.getClass(), a7.a.c[0]).get(obj);
            str = obj2 instanceof String ? (String) obj2 : null;
        } catch (Throwable th) {
        }
        try {
            Object obj3 = g8.a((Class) obj.getClass(), a7.b.c[0]).get(obj);
            str2 = obj3 instanceof String ? (String) obj3 : null;
        } catch (Throwable th2) {
        }
        Object objA = g8.a(obj, a7.c.c[0], Object.class);
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty() && objA != null) {
            try {
                a(str, str2);
                g8.a(objA.getClass(), "onStart", new Class[0]).invoke(objA, null);
                g8.a(objA.getClass(), "onProgress", Integer.TYPE).invoke(objA, 100);
                g8.a(objA.getClass(), "onSuccess", String.class).invoke(objA, str2);
                return true;
            } catch (Throwable th3) {
                th3.getMessage();
                int i = p4.a;
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

    public static UrlModel b(PhotoModeImageUrlModel photoModeImageUrlModel) {
        try {
            UrlModel urlModel = (UrlModel) g8.a((Class) photoModeImageUrlModel.getClass(), "displayImageNoWatermark").get(photoModeImageUrlModel);
            if ((urlModel == null || urlModel.getUrlList() == null || urlModel.getUrlList().isEmpty()) ? false : true) {
                return urlModel;
            }
            List list = (List) g8.a((Class) photoModeImageUrlModel.getClass(), "bitrateImages").get(photoModeImageUrlModel);
            if (list != null && !list.isEmpty()) {
                for (Object obj : list) {
                    UrlModel urlModel2 = (UrlModel) g8.a(obj.getClass(), "getImage", new Class[0]).invoke(obj, null);
                    if ((urlModel2 == null || urlModel2.getUrlList() == null || urlModel2.getUrlList().isEmpty()) ? false : true) {
                        int i = p4.a;
                        return urlModel2;
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
            int i2 = p4.a;
        }
        return null;
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

    public static void a(PhotoModeImageUrlModel photoModeImageUrlModel) {
        if (c.getAndIncrement() >= 20) {
            return;
        }
        try {
            List list = (List) g8.a((Class) photoModeImageUrlModel.getClass(), "bitrateImages").get(photoModeImageUrlModel);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Object obj = list.get(i);
                    Method methodA = g8.a(obj.getClass(), "getName", new Class[0]);
                    Method methodA2 = g8.a(obj.getClass(), "getImage", new Class[0]);
                }
            }
        } catch (Exception e) {
        }
    }
}
