package Z;

import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.windukk.hook.HookMethod;

class hf extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y5.a().d) {
            SearchMixFeed searchMixFeed = (SearchMixFeed) hookMethodParam.thisObject;
            a.a(searchMixFeed);
            if (a.b(searchMixFeed)) {
                hookMethodParam.setResult(Boolean.FALSE);
            }
        }
    }
}
