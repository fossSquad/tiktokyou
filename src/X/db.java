package X;

import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.windukk.hook.HookMethod;

class db extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (l8.a().c) {
            SearchMixFeed searchMixFeed = (SearchMixFeed) hookMethodParam.thisObject;
            if (searchMixFeed.preciseAd != null) {
                searchMixFeed.preciseAd = null;
                hookMethodParam.setResult(null);
            }
        }
    }
}
