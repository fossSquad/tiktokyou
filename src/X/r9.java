package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;

class r9 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String aid;
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Aweme) {
            Aweme aweme = (Aweme) obj;
            String str = z6.d.c[0];
            if (v9.a(aweme)) {
                v9.b(aweme);
                String str2 = v9.h;
                try {
                    aid = aweme.getAid();
                } catch (Throwable th) {
                    aid = null;
                }
                v9.b((str2 == null || !str2.equals(aid)) ? v9.f : v9.i);
            }
        }
    }
}
