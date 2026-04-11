package X;

import android.content.ContentResolver;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Video;
import com.ss.android.ugc.trill.download.protocol.download.AwemeVideoDownloadAbilityProtocol;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public abstract class h1 {
    public static final Set a = ConcurrentHashMap.newKeySet();
    public static final ThreadLocal b = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });

    public static void a() {
        try {
            b1 b1Var = new b1();
            XposedBridge.hookAllMethods(Video.class, "getDownloadAddr", b1Var);
            XposedBridge.hookAllMethods(Video.class, "getNewDownloadAddr", b1Var);
            XposedBridge.hookAllMethods(Video.class, "getDownloadNoWatermarkAddr", b1Var);
            try {
                XposedBridge.hookAllConstructors(AwemeVideoDownloadAbilityProtocol.class, new c1(Class.forName("X.0ooi"), Class.forName("X.0p4L"), Class.forName("X.0ooj")));
                ArrayList arrayList = p2.a;
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList2 = p2.a;
            }
            try {
                XposedBridge.hookAllMethods(ContentResolver.class, "insert", new d1());
            } catch (Exception e2) {
                e2.getMessage();
                ArrayList arrayList3 = p2.a;
            }
            try {
                XposedBridge.hookAllMethods(ContentResolver.class, "openOutputStream", new e1());
            } catch (Exception e3) {
                e3.getMessage();
                ArrayList arrayList4 = p2.a;
            }
        } catch (Exception e4) {
            e4.getMessage();
            ArrayList arrayList5 = p2.a;
        }
    }

    public static f1 a(Video video, UrlModel urlModel, String str) {
        UrlModel urlModel2;
        Object objInvoke;
        if (video == null) {
            return null;
        }
        try {
            Field field = video.getClass().getField("downloadNoWatermarkAddr");
            field.setAccessible(true);
            Object obj = field.get(video);
            urlModel2 = obj instanceof UrlModel ? (UrlModel) obj : null;
        } catch (Throwable th) {
        }
        f1 f1VarA = a(a(null, a(video, urlModel2, "downloadNoWatermarkAddr", 400)), a(video, video.getPlayAddr(), "playAddr", 300));
        try {
            Method method = video.getClass().getMethod("getH264PlayAddr", null);
            method.setAccessible(true);
            objInvoke = method.invoke(video, null);
        } catch (Throwable th2) {
            objInvoke = null;
        }
        f1 f1VarA2 = a(f1VarA, a(video, objInvoke instanceof UrlModel ? (UrlModel) objInvoke : null, "h264PlayAddr", 200));
        if ("getDownloadNoWatermarkAddr".equals(str)) {
            return a(f1VarA2, a(video, urlModel, "original", 350));
        }
        return "protocol".equals(str) ? a(f1VarA2, a(video, urlModel, "protocolOriginal", 250)) : f1VarA2;
    }

    public static f1 a(f1 f1Var, f1 f1Var2) {
        if (f1Var2 == null) {
            return f1Var;
        }
        if (f1Var != null) {
            long j = f1Var2.b;
            long j2 = f1Var.b;
            if (j == j2 ? f1Var2.c <= f1Var.c : j <= j2) {
                return f1Var;
            }
        }
        return f1Var2;
    }

    public static f1 a(Video video, UrlModel urlModel, String str, int i) {
        boolean zCheckVideo;
        if (video == null || urlModel == null) {
            zCheckVideo = false;
        } else {
            try {
                zCheckVideo = video.checkVideo(urlModel);
            } catch (Throwable th) {
                List urlList = urlModel.getUrlList();
                if (urlList == null || urlList.isEmpty()) {
                    zCheckVideo = false;
                } else {
                    zCheckVideo = true;
                }
            }
        }
        if (zCheckVideo) {
            return new f1(urlModel, str, urlModel != null ? urlModel.getSize() : 0L, i);
        }
        return null;
    }
}
