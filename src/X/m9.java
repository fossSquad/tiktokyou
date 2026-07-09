package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import java.util.List;

class m9 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object objA;
        try {
            Object[] objArr = hookMethodParam.args;
            if (objArr == null || objArr.length != 2) {
                return;
            }
            boolean z = false;
            if ((objArr[0] instanceof String) && (objArr[1] instanceof String)) {
                Object obj = hookMethodParam.thisObject;
                ThreadLocal threadLocal = n9.a;
                Aweme aweme = (Aweme) ha.a(obj, r7.a.c[0], Aweme.class);
                if (aweme != null) {
                    List listA = ha.a(ha.b(aweme, "getPhotoModeImageInfo"), "getImageList");
                    if (listA != null && listA.size() == 1) {
                        z = true;
                    }
                    if (z && (objA = ha.a(hookMethodParam.thisObject, "LJIIIIZZ", Object.class)) != null && n9.a(objA)) {
                        hookMethodParam.setResult(null);
                        int i = g5.a;
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
    }
}
