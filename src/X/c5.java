package X;

import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeedList;
import com.windukk.hook.HookMethod;

class c5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().d) {
            SearchMixFeedList searchMixFeedList = (SearchMixFeedList) hookMethodParam.thisObject;
            searchMixFeedList.mItems = g.b(searchMixFeedList.mItems);
            Object result = hookMethodParam.getResult();
            if (result instanceof SearchMixFeedList) {
                SearchMixFeedList searchMixFeedList2 = (SearchMixFeedList) result;
                searchMixFeedList2.mItems = g.b(searchMixFeedList2.mItems);
                hookMethodParam.setResult(searchMixFeedList2);
            }
        }
    }
}
