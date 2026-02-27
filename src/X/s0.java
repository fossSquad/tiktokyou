package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class s0 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = w0.a;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        try {
            try {
                threadLocal.set(Boolean.TRUE);
                PhotoModeImageUrlModel photoModeImageUrlModel = (PhotoModeImageUrlModel) methodHookParam.thisObject;
                w0.a(photoModeImageUrlModel);
                UrlModel urlModelB = w0.b(photoModeImageUrlModel);
                if (urlModelB != null) {
                    methodHookParam.setResult(urlModelB);
                }
                threadLocal.set(Boolean.FALSE);
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList = q0.a;
                w0.a.set(Boolean.FALSE);
            }
        } catch (Throwable th) {
            w0.a.set(Boolean.FALSE);
            throw th;
        }
    }
}
