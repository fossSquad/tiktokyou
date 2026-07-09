package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import com.windukk.hook.HookMethod;

class e9 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ThreadLocal threadLocal = n9.a;
        if (((Boolean) threadLocal.get()).booleanValue()) {
            return;
        }
        try {
            try {
                threadLocal.set(Boolean.TRUE);
                PhotoModeImageUrlModel photoModeImageUrlModel = (PhotoModeImageUrlModel) hookMethodParam.thisObject;
                n9.a(photoModeImageUrlModel);
                UrlModel urlModelB = n9.b(photoModeImageUrlModel);
                if (urlModelB != null) {
                    hookMethodParam.setResult(urlModelB);
                }
                threadLocal.set(Boolean.FALSE);
            } catch (Exception e) {
                e.getMessage();
                int i = g5.a;
                n9.a.set(Boolean.FALSE);
            }
        } catch (Throwable th) {
            n9.a.set(Boolean.FALSE);
            throw th;
        }
    }
}
