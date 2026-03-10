package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class j1 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = n1.a;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        try {
            try {
                threadLocal.set(Boolean.TRUE);
                PhotoModeImageUrlModel photoModeImageUrlModel = (PhotoModeImageUrlModel) methodHookParam.thisObject;
                n1.a(photoModeImageUrlModel);
                UrlModel urlModelB = n1.b(photoModeImageUrlModel);
                if (urlModelB != null) {
                    methodHookParam.setResult(urlModelB);
                }
                threadLocal.set(Boolean.FALSE);
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList = g1.a;
                n1.a.set(Boolean.FALSE);
            }
        } catch (Throwable th) {
            n1.a.set(Boolean.FALSE);
            throw th;
        }
    }
}
