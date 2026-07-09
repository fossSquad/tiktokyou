package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import java.util.List;

class i9 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        n9.b.set(Boolean.FALSE);
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            boolean z = false;
            Aweme aweme = (Aweme) ha.a(hookMethodParam.thisObject, r7.a.c[0], Aweme.class);
            if (aweme != null) {
                ThreadLocal threadLocal = n9.a;
                List listA = ha.a(ha.b(aweme, "getPhotoModeImageInfo"), "getImageList");
                if (listA != null && listA.size() == 1) {
                    z = true;
                }
            }
            n9.b.set(Boolean.valueOf(z));
            if (z) {
                int i = g5.a;
            }
        } catch (Throwable th) {
            n9.b.set(Boolean.FALSE);
            th.getMessage();
            int i2 = g5.a;
        }
    }
}
