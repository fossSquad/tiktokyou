package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import com.windukk.hook.HookMethod;

class z3 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = d4.a;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        try {
            try {
                threadLocal.set(Boolean.TRUE);
                PhotoModeImageUrlModel photoModeImageUrlModel = (PhotoModeImageUrlModel) hookMethodParam.thisObject;
                d4.a(photoModeImageUrlModel);
                UrlModel urlModelB = d4.b(photoModeImageUrlModel);
                if (urlModelB != null) {
                    hookMethodParam.setResult(urlModelB);
                }
                threadLocal.set(Boolean.FALSE);
            } catch (Exception e) {
                e.getMessage();
                int i = v3.a;
                d4.a.set(Boolean.FALSE);
            }
        } catch (Throwable th) {
            d4.a.set(Boolean.FALSE);
            throw th;
        }
    }
}
