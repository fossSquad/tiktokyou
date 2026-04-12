package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class t2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = x2.a;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        try {
            try {
                threadLocal.set(Boolean.TRUE);
                PhotoModeImageUrlModel photoModeImageUrlModel = (PhotoModeImageUrlModel) methodHookParam.thisObject;
                x2.a(photoModeImageUrlModel);
                UrlModel urlModelB = x2.b(photoModeImageUrlModel);
                if (urlModelB != null) {
                    methodHookParam.setResult(urlModelB);
                }
                threadLocal.set(Boolean.FALSE);
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList = q2.a;
                x2.a.set(Boolean.FALSE);
            }
        } catch (Throwable th) {
            x2.a.set(Boolean.FALSE);
            throw th;
        }
    }
}
