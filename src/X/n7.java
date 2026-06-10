package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import java.util.List;

class n7 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        q7.b.set(Boolean.FALSE);
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            boolean z = false;
            Aweme aweme = (Aweme) g8.a(hookMethodParam.thisObject, o6.a.c[0], Aweme.class);
            if (aweme != null) {
                ThreadLocal threadLocal = q7.a;
                List listA = g8.a(g8.b(aweme, "getPhotoModeImageInfo"), "getImageList");
                if (listA != null && listA.size() == 1) {
                    z = true;
                }
            }
            q7.b.set(Boolean.valueOf(z));
            if (z) {
                int i = p4.a;
            }
        } catch (Throwable th) {
            q7.b.set(Boolean.FALSE);
            th.getMessage();
            int i2 = p4.a;
        }
    }
}
