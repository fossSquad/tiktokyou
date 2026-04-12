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

public abstract class i1 {
    public static final Set a = ConcurrentHashMap.newKeySet();
    public static final ThreadLocal b = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });

    public static void a() {
        try {
            c1 c1Var = new c1();
            XposedBridge.hookAllMethods(Video.class, "getDownloadAddr", c1Var);
            XposedBridge.hookAllMethods(Video.class, "getNewDownloadAddr", c1Var);
            XposedBridge.hookAllMethods(Video.class, "getDownloadNoWatermarkAddr", c1Var);
            try {
                XposedBridge.hookAllConstructors(AwemeVideoDownloadAbilityProtocol.class, new d1(Class.forName("X.0ooi"), Class.forName("X.0p4L"), Class.forName("X.0ooj")));
                ArrayList arrayList = q2.a;
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList2 = q2.a;
            }
            try {
                XposedBridge.hookAllMethods(ContentResolver.class, "insert", new e1());
            } catch (Exception e2) {
                e2.getMessage();
                ArrayList arrayList3 = q2.a;
            }
            try {
                XposedBridge.hookAllMethods(ContentResolver.class, "openOutputStream", new f1());
            } catch (Exception e3) {
                e3.getMessage();
                ArrayList arrayList4 = q2.a;
            }
        } catch (Exception e4) {
            e4.getMessage();
            ArrayList arrayList5 = q2.a;
        }
    }

    public static g1 a(Video video, UrlModel urlModel, String str) {
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
        g1 g1VarA = a(a(null, a(video, urlModel2, "downloadNoWatermarkAddr", 400)), a(video, video.getPlayAddr(), "playAddr", 300));
        try {
            Method method = video.getClass().getMethod("getH264PlayAddr", null);
            method.setAccessible(true);
            objInvoke = method.invoke(video, null);
        } catch (Throwable th2) {
            objInvoke = null;
        }
        g1 g1VarA2 = a(g1VarA, a(video, objInvoke instanceof UrlModel ? (UrlModel) objInvoke : null, "h264PlayAddr", 200));
        if ("getDownloadNoWatermarkAddr".equals(str)) {
            return a(g1VarA2, a(video, urlModel, "original", 350));
        }
        return "protocol".equals(str) ? a(g1VarA2, a(video, urlModel, "protocolOriginal", 250)) : g1VarA2;
    }

    public static g1 a(g1 g1Var, g1 g1Var2) {
        if (g1Var2 == null) {
            return g1Var;
        }
        if (g1Var != null) {
            long j = g1Var2.b;
            long j2 = g1Var.b;
            if (j == j2 ? g1Var2.c <= g1Var.c : j <= j2) {
                return g1Var;
            }
        }
        return g1Var2;
    }

    public static g1 a(Video video, UrlModel urlModel, String str, int i) {
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
            return new g1(urlModel, str, urlModel != null ? urlModel.getSize() : 0L, i);
        }
        return null;
    }
}
