package X;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public abstract class d4 {
    public static final ThreadLocal a = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });
    public static final AtomicInteger b = new AtomicInteger(0);

    public static void a() {
        try {
            z3 z3Var = new z3();
            HookBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getOwnerWatermarkImage", z3Var);
            HookBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getUserWatermarkImage", z3Var);
            HookBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getDisplayImageNoWatermark", z3Var);
            int i = v3.a;
            try {
                HookBridge.hookAllMethods(DownloadInfo.class, "setUrl", new a4());
            } catch (Exception e) {
                e.getMessage();
                int i2 = v3.a;
            }
            try {
                HookBridge.hookAllMethods(DownloadTask.class, "url", new b4());
            } catch (Exception e2) {
                e2.getMessage();
                int i3 = v3.a;
            }
            try {
                HookBridge.hookAllMethods(UrlModel.class, "getUrlList", new c4());
            } catch (Exception e3) {
                e3.getMessage();
                int i4 = v3.a;
            }
        } catch (Exception e4) {
            e4.getMessage();
            int i5 = v3.a;
        }
    }

    public static UrlModel b(PhotoModeImageUrlModel photoModeImageUrlModel) {
        try {
            UrlModel urlModel = (UrlModel) e4.a(photoModeImageUrlModel.getClass(), "displayImageNoWatermark").get(photoModeImageUrlModel);
            if ((urlModel == null || urlModel.getUrlList() == null || urlModel.getUrlList().isEmpty()) ? false : true) {
                return urlModel;
            }
            List list = (List) e4.a(photoModeImageUrlModel.getClass(), "bitrateImages").get(photoModeImageUrlModel);
            if (list != null && !list.isEmpty()) {
                for (Object obj : list) {
                    UrlModel urlModel2 = (UrlModel) e4.a(obj.getClass(), "getImage", new Class[0]).invoke(obj, null);
                    if ((urlModel2 == null || urlModel2.getUrlList() == null || urlModel2.getUrlList().isEmpty()) ? false : true) {
                        int i = v3.a;
                        return urlModel2;
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
            int i2 = v3.a;
        }
        return null;
    }

    public static void a(PhotoModeImageUrlModel photoModeImageUrlModel) {
        if (b.getAndIncrement() >= 20) {
            return;
        }
        try {
            List list = (List) e4.a(photoModeImageUrlModel.getClass(), "bitrateImages").get(photoModeImageUrlModel);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Object obj = list.get(i);
                    Method methodA = e4.a(obj.getClass(), "getName", new Class[0]);
                    Method methodA2 = e4.a(obj.getClass(), "getImage", new Class[0]);
                }
            }
        } catch (Exception e) {
        }
    }
}
