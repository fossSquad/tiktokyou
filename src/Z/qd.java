package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.windukk.hook.HookMethod;

class qd extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (d5.a().d) {
            SearchMixFeed searchMixFeed = (SearchMixFeed) hookMethodParam.thisObject;
            Aweme aweme = (Aweme) hookMethodParam.getResult();
            a.a(searchMixFeed);
            if (a.a(aweme)) {
                hookMethodParam.setResult((Object) null);
            }
        }
    }
}
