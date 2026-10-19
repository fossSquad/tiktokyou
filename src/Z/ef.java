package Z;

import com.ss.android.ugc.aweme.search.common.model.ContinuousLoadingAwemeList;
import com.windukk.hook.HookMethod;
import java.util.List;

class ef extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y5.a().d) {
            ContinuousLoadingAwemeList continuousLoadingAwemeList = (ContinuousLoadingAwemeList) hookMethodParam.thisObject;
            continuousLoadingAwemeList.awemeList = a.a(continuousLoadingAwemeList.awemeList);
            Object result = hookMethodParam.getResult();
            if (result instanceof List) {
                try {
                    hookMethodParam.setResult(a.a((List) result));
                } catch (Throwable th) {
                }
            }
        }
    }
}
