package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class s2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ThreadLocal threadLocal = w2.a;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        try {
            try {
                threadLocal.set(Boolean.TRUE);
                PhotoModeImageUrlModel photoModeImageUrlModel = (PhotoModeImageUrlModel) methodHookParam.thisObject;
                w2.a(photoModeImageUrlModel);
                UrlModel urlModelB = w2.b(photoModeImageUrlModel);
                if (urlModelB != null) {
                    methodHookParam.setResult(urlModelB);
                }
                threadLocal.set(Boolean.FALSE);
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList = p2.a;
                w2.a.set(Boolean.FALSE);
            }
        } catch (Throwable th) {
            w2.a.set(Boolean.FALSE);
            throw th;
        }
    }
}
