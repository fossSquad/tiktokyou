package X;

import android.content.ContentResolver;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Video;
import com.ss.android.ugc.trill.download.protocol.download.AwemeVideoDownloadAbilityProtocol;
import com.windukk.hook.HookBridge;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public abstract class o2 {
    public static final Set a = ConcurrentHashMap.newKeySet();
    public static final ThreadLocal b = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });

    public static void a() {
        try {
            i2 i2Var = new i2();
            HookBridge.hookAllMethods(Video.class, "getDownloadAddr", i2Var);
            HookBridge.hookAllMethods(Video.class, "getNewDownloadAddr", i2Var);
            HookBridge.hookAllMethods(Video.class, "getDownloadNoWatermarkAddr", i2Var);
            try {
                HookBridge.hookAllConstructors(AwemeVideoDownloadAbilityProtocol.class, new j2(Class.forName("X.0mwA"), Class.forName("X.0Wv2"), Class.forName("X.0mwC")));
                int i = v3.a;
            } catch (Exception e) {
                e.getMessage();
                int i2 = v3.a;
            }
            try {
                HookBridge.hookAllMethods(ContentResolver.class, "insert", new k2());
            } catch (Exception e2) {
                e2.getMessage();
                int i3 = v3.a;
            }
            try {
                HookBridge.hookAllMethods(ContentResolver.class, "openOutputStream", new l2());
            } catch (Exception e3) {
                e3.getMessage();
                int i4 = v3.a;
            }
        } catch (Exception e4) {
            e4.getMessage();
            int i5 = v3.a;
        }
    }

    public static m2 a(Video video, UrlModel urlModel, String str) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        UrlModel urlModel2;
        Object objInvoke;
        if (video == null) {
            return null;
        }
        try {
            Object obj = e4.a(video.getClass(), "downloadNoWatermarkAddr").get(video);
            urlModel2 = obj instanceof UrlModel ? (UrlModel) obj : null;
        } catch (Throwable th) {
        }
        m2 m2VarA = a(a(null, a(video, urlModel2, "downloadNoWatermarkAddr", 400)), a(video, video.getPlayAddr(), "playAddr", 300));
        try {
            objInvoke = e4.a(video.getClass(), "getH264PlayAddr", new Class[0]).invoke(video, null);
        } catch (Throwable th2) {
            objInvoke = null;
        }
        m2 m2VarA2 = a(m2VarA, a(video, objInvoke instanceof UrlModel ? (UrlModel) objInvoke : null, "h264PlayAddr", 200));
        if ("getDownloadNoWatermarkAddr".equals(str)) {
            return a(m2VarA2, a(video, urlModel, "original", 350));
        }
        return "protocol".equals(str) ? a(m2VarA2, a(video, urlModel, "protocolOriginal", 250)) : m2VarA2;
    }

    public static m2 a(m2 m2Var, m2 m2Var2) {
        if (m2Var2 == null) {
            return m2Var;
        }
        if (m2Var != null) {
            long j = m2Var2.b;
            long j2 = m2Var.b;
            if (j == j2 ? m2Var2.c <= m2Var.c : j <= j2) {
                return m2Var;
            }
        }
        return m2Var2;
    }

    public static m2 a(Video video, UrlModel urlModel, String str, int i) {
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
            return new m2(urlModel, str, urlModel != null ? urlModel.getSize() : 0L, i);
        }
        return null;
    }
}
