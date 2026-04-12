package X;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public abstract class x2 {
    public static final ThreadLocal a = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });
    public static final AtomicInteger b = new AtomicInteger(0);

    public static void a() {
        try {
            t2 t2Var = new t2();
            XposedBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getOwnerWatermarkImage", t2Var);
            XposedBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getUserWatermarkImage", t2Var);
            XposedBridge.hookAllMethods(PhotoModeImageUrlModel.class, "getDisplayImageNoWatermark", t2Var);
            ArrayList arrayList = q2.a;
            try {
                XposedBridge.hookAllMethods(DownloadInfo.class, "setUrl", new u2());
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList2 = q2.a;
            }
            try {
                XposedBridge.hookAllMethods(DownloadTask.class, "url", new v2());
            } catch (Exception e2) {
                e2.getMessage();
                ArrayList arrayList3 = q2.a;
            }
            try {
                XposedBridge.hookAllMethods(UrlModel.class, "getUrlList", new w2());
            } catch (Exception e3) {
                e3.getMessage();
                ArrayList arrayList4 = q2.a;
            }
        } catch (Exception e4) {
            e4.getMessage();
            ArrayList arrayList5 = q2.a;
        }
    }

    public static UrlModel b(PhotoModeImageUrlModel photoModeImageUrlModel) {
        try {
            Field declaredField = PhotoModeImageUrlModel.class.getDeclaredField("displayImageNoWatermark");
            declaredField.setAccessible(true);
            UrlModel urlModel = (UrlModel) declaredField.get(photoModeImageUrlModel);
            if ((urlModel == null || urlModel.getUrlList() == null || urlModel.getUrlList().isEmpty()) ? false : true) {
                return urlModel;
            }
            Field declaredField2 = PhotoModeImageUrlModel.class.getDeclaredField("bitrateImages");
            declaredField2.setAccessible(true);
            List list = (List) declaredField2.get(photoModeImageUrlModel);
            if (list != null && !list.isEmpty()) {
                for (Object obj : list) {
                    UrlModel urlModel2 = (UrlModel) obj.getClass().getMethod("getImage", null).invoke(obj, null);
                    if ((urlModel2 == null || urlModel2.getUrlList() == null || urlModel2.getUrlList().isEmpty()) ? false : true) {
                        ArrayList arrayList = q2.a;
                        return urlModel2;
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList2 = q2.a;
        }
        return null;
    }

    public static void a(PhotoModeImageUrlModel photoModeImageUrlModel) {
        if (b.getAndIncrement() >= 20) {
            return;
        }
        try {
            Field declaredField = PhotoModeImageUrlModel.class.getDeclaredField("bitrateImages");
            declaredField.setAccessible(true);
            List list = (List) declaredField.get(photoModeImageUrlModel);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Object obj = list.get(i);
                    Method method = obj.getClass().getMethod("getName", null);
                    Method method2 = obj.getClass().getMethod("getImage", null);
                }
            }
        } catch (Exception e) {
        }
    }
}
