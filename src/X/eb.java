package X;

import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.windukk.hook.HookMethod;

class eb extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (l8.a().c) {
            SearchMixFeed searchMixFeed = (SearchMixFeed) hookMethodParam.thisObject;
            g.a(searchMixFeed);
            if (g.b(searchMixFeed)) {
                hookMethodParam.setResult(Boolean.FALSE);
            }
        }
    }
}
