package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.SearchHooks;

public class td extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        String aid;
        if (Boolean.TRUE.equals(SearchHooks.l.get())) {
            return;
        }
        Object result = hookMethodParam.getResult();
        if (!(result instanceof Number) || (objArr = hookMethodParam.args) == null || objArr.length == 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof Aweme) {
            Aweme aweme = (Aweme) obj;
            SearchHooks.b(aweme);
            String str = SearchHooks.h;
            try {
                aid = aweme.getAid();
            } catch (Throwable th) {
                aid = null;
            }
            if (str == null || !str.equals(aid)) {
                float fFloatValue = ((Number) result).floatValue();
                float f = SearchHooks.f;
                if (!SearchHooks.a(f) && SearchHooks.a(fFloatValue) && SearchHooks.a(aweme)) {
                    hookMethodParam.setResult(Float.valueOf(f));
                }
            }
        }
    }
}
