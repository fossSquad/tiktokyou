package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class u1 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = y1.a;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        try {
            try {
                threadLocal.set(Boolean.TRUE);
                PhotoModeImageUrlModel photoModeImageUrlModel = (PhotoModeImageUrlModel) methodHookParam.thisObject;
                y1.a(photoModeImageUrlModel);
                UrlModel urlModelB = y1.b(photoModeImageUrlModel);
                if (urlModelB != null) {
                    methodHookParam.setResult(urlModelB);
                }
                threadLocal.set(Boolean.FALSE);
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList = r1.a;
                y1.a.set(Boolean.FALSE);
            }
        } catch (Throwable th) {
            y1.a.set(Boolean.FALSE);
            throw th;
        }
    }
}
