package X;

import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import com.windukk.hook.HookMethod;

class z4 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().d) {
            SearchMixFeed searchMixFeed = (SearchMixFeed) hookMethodParam.thisObject;
            if (searchMixFeed.preciseAd != null) {
                searchMixFeed.preciseAd = null;
                hookMethodParam.setResult((Object) null);
            }
        }
    }
}
