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

public abstract class i0 {
    public static final Set a = ConcurrentHashMap.newKeySet();
    public static final ThreadLocal b = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });

    public static void a() {
        try {
            c0 c0Var = new c0();
            XposedBridge.hookAllMethods(Video.class, "getDownloadAddr", c0Var);
            XposedBridge.hookAllMethods(Video.class, "getNewDownloadAddr", c0Var);
            XposedBridge.hookAllMethods(Video.class, "getDownloadNoWatermarkAddr", c0Var);
            XposedBridge.hookAllMethods(Video.class, "getPlayAddrH264", c0Var);
            try {
                XposedBridge.hookAllConstructors(AwemeVideoDownloadAbilityProtocol.class, new d0(Class.forName("X.0tj4"), Class.forName("X.0u05"), Class.forName("X.0tj5")));
                ArrayList arrayList = r1.a;
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList2 = r1.a;
            }
            try {
                XposedBridge.hookAllMethods(ContentResolver.class, "insert", new e0());
            } catch (Exception e2) {
                e2.getMessage();
                ArrayList arrayList3 = r1.a;
            }
            try {
                XposedBridge.hookAllMethods(ContentResolver.class, "openOutputStream", new f0());
            } catch (Exception e3) {
                e3.getMessage();
                ArrayList arrayList4 = r1.a;
            }
        } catch (Exception e4) {
            e4.getMessage();
            ArrayList arrayList5 = r1.a;
        }
    }

    public static g0 a(Video video, UrlModel urlModel, String str) {
        UrlModel urlModel2;
        if (video == null) {
            return null;
        }
        if ("getPlayAddrH264".equals(str)) {
            g0 g0VarA = a(video, a(video), "h264PlayAddr", 300);
            if (g0VarA != null) {
                return g0VarA;
            }
            g0 g0VarA2 = a(video, urlModel, "original", 200);
            return g0VarA2 != null ? g0VarA2 : a(video, video.getPlayAddr(), "playAddr", 100);
        }
        try {
            Field field = video.getClass().getField("downloadNoWatermarkAddr");
            field.setAccessible(true);
            Object obj = field.get(video);
            urlModel2 = obj instanceof UrlModel ? (UrlModel) obj : null;
        } catch (Throwable th) {
        }
        g0 g0VarA3 = a(a(a(null, a(video, urlModel2, "downloadNoWatermarkAddr", 400)), a(video, video.getPlayAddr(), "playAddr", 300)), a(video, a(video), "h264PlayAddr", 200));
        if ("getDownloadNoWatermarkAddr".equals(str)) {
            return a(g0VarA3, a(video, urlModel, "original", 350));
        }
        return "protocol".equals(str) ? a(g0VarA3, a(video, urlModel, "protocolOriginal", 250)) : g0VarA3;
    }

    public static g0 a(g0 g0Var, g0 g0Var2) {
        if (g0Var2 == null) {
            return g0Var;
        }
        if (g0Var != null) {
            long j = g0Var2.b;
            long j2 = g0Var.b;
            if (j == j2 ? g0Var2.c <= g0Var.c : j <= j2) {
                return g0Var;
            }
        }
        return g0Var2;
    }

    public static g0 a(Video video, UrlModel urlModel, String str, int i) {
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
            return new g0(urlModel, str, urlModel != null ? urlModel.getSize() : 0L, i);
        }
        return null;
    }

    public static UrlModel a(Video video) {
        Object objInvoke;
        if (video == null) {
            objInvoke = null;
        } else {
            try {
                Method method = video.getClass().getMethod("getH264PlayAddr", null);
                method.setAccessible(true);
                objInvoke = method.invoke(video, null);
            } catch (Throwable th) {
                objInvoke = null;
            }
        }
        if (objInvoke instanceof UrlModel) {
            return (UrlModel) objInvoke;
        }
        return null;
    }
}
