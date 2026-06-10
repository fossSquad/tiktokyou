package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;

class u7 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String aid;
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Aweme) {
            Aweme aweme = (Aweme) obj;
            String str = y5.d.c[0];
            if (y7.a(aweme)) {
                y7.b(aweme);
                String str2 = y7.h;
                try {
                    aid = aweme.getAid();
                } catch (Throwable th) {
                    aid = null;
                }
                y7.b((str2 == null || !str2.equals(aid)) ? y7.f : y7.i);
            }
        }
    }
}
