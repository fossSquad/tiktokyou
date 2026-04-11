package X;

import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeedList;
import de.robv.android.xposed.XC_MethodHook;

class r3 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().d) {
            SearchMixFeedList searchMixFeedList = (SearchMixFeedList) methodHookParam.thisObject;
            searchMixFeedList.mItems = g.b(searchMixFeedList.mItems);
            Object result = methodHookParam.getResult();
            if (result instanceof SearchMixFeedList) {
                SearchMixFeedList searchMixFeedList2 = (SearchMixFeedList) result;
                searchMixFeedList2.mItems = g.b(searchMixFeedList2.mItems);
                methodHookParam.setResult(searchMixFeedList2);
            }
        }
    }
}
