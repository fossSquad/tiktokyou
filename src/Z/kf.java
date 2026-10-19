package Z;

import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeedList;
import com.windukk.hook.HookMethod;

class kf extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y5.a().d) {
            SearchMixFeedList searchMixFeedList = (SearchMixFeedList) hookMethodParam.thisObject;
            searchMixFeedList.mItems = a.b(searchMixFeedList.mItems);
            Object result = hookMethodParam.getResult();
            if (result instanceof SearchMixFeedList) {
                SearchMixFeedList searchMixFeedList2 = (SearchMixFeedList) result;
                searchMixFeedList2.mItems = a.b(searchMixFeedList2.mItems);
                hookMethodParam.setResult(searchMixFeedList2);
            }
        }
    }
}
