package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.windukk.hook.HookMethod;

class y4 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().d) {
            SearchMixFeed searchMixFeed = (SearchMixFeed) hookMethodParam.thisObject;
            Aweme aweme = (Aweme) hookMethodParam.getResult();
            g.a(searchMixFeed);
            if (g.a(aweme)) {
                hookMethodParam.setResult((Object) null);
            }
        }
    }
}
