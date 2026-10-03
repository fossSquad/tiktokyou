package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import Z.FeedHooks;

class yg extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Aweme aweme;
        Object[] objArr = hookMethodParam.args;
        int i = zg.a;
        if (objArr.length >= 2) {
            Object obj = objArr[1];
            if (obj instanceof Aweme) {
                aweme = (Aweme) obj;
            } else {
                aweme = null;
            }
        } else {
            aweme = null;
        }
        if (aweme == null || !FeedHooks.a(aweme)) {
            return;
        }
        hookMethodParam.setResult((Object) null);
    }
}
