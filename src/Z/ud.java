package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.SearchHooks;

public class ud extends HookMethod {
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
            if (SearchHooks.a(aweme)) {
                SearchHooks.b(aweme);
                String str2 = SearchHooks.h;
                try {
                    aid = aweme.getAid();
                } catch (Throwable th) {
                    aid = null;
                }
                SearchHooks.b((str2 == null || !str2.equals(aid)) ? SearchHooks.f : SearchHooks.i);
            }
        }
    }
}
