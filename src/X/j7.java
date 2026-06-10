package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import com.windukk.hook.HookMethod;

class j7 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = q7.a;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        try {
            try {
                threadLocal.set(Boolean.TRUE);
                PhotoModeImageUrlModel photoModeImageUrlModel = (PhotoModeImageUrlModel) hookMethodParam.thisObject;
                q7.a(photoModeImageUrlModel);
                UrlModel urlModelB = q7.b(photoModeImageUrlModel);
                if (urlModelB != null) {
                    hookMethodParam.setResult(urlModelB);
                }
                threadLocal.set(Boolean.FALSE);
            } catch (Exception e) {
                e.getMessage();
                int i = p4.a;
                q7.a.set(Boolean.FALSE);
            }
        } catch (Throwable th) {
            q7.a.set(Boolean.FALSE);
            throw th;
        }
    }
}
