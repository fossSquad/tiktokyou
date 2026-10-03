package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import Z.EdgeSpeedupHooks;

class gc extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String aid;
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Aweme) {
            Aweme aweme = (Aweme) obj;
            String str = a9.d.c[0];
            if (EdgeSpeedupHooks.a(aweme)) {
                EdgeSpeedupHooks.b(aweme);
                String str2 = EdgeSpeedupHooks.h;
                try {
                    aid = aweme.getAid();
                } catch (Throwable th) {
                    aid = null;
                }
                EdgeSpeedupHooks.b((str2 == null || !str2.equals(aid)) ? EdgeSpeedupHooks.f : EdgeSpeedupHooks.i);
            }
        }
    }
}
