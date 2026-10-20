package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;

class ud extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String aid;
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Aweme) {
            Aweme aweme = (Aweme) obj;
            String str = ha.d.c[0];
            if (yd.a(aweme)) {
                yd.b(aweme);
                String str2 = yd.h;
                try {
                    aid = aweme.getAid();
                } catch (Throwable th) {
                    aid = null;
                }
                yd.b((str2 == null || !str2.equals(aid)) ? yd.f : yd.i);
            }
        }
    }
}
