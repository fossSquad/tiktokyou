package X;

import com.ss.android.ugc.aweme.search.common.model.ContinuousLoadingAwemeList;
import com.windukk.hook.HookMethod;
import java.util.List;

class a9 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d7.a().d) {
            ContinuousLoadingAwemeList continuousLoadingAwemeList = (ContinuousLoadingAwemeList) hookMethodParam.thisObject;
            continuousLoadingAwemeList.awemeList = g.a(continuousLoadingAwemeList.awemeList);
            Object result = hookMethodParam.getResult();
            if (result instanceof List) {
                try {
                    hookMethodParam.setResult(g.a((List) result));
                } catch (Throwable th) {
                }
            }
        }
    }
}
