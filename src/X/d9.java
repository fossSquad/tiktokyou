package X;

import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.windukk.hook.HookMethod;

class d9 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d7.a().d) {
            SearchMixFeed searchMixFeed = (SearchMixFeed) hookMethodParam.thisObject;
            g.a(searchMixFeed);
            if (g.b(searchMixFeed)) {
                hookMethodParam.setResult(Boolean.FALSE);
            }
        }
    }
}
