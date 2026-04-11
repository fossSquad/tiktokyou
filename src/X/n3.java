package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import de.robv.android.xposed.XC_MethodHook;

class n3 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().d) {
            SearchMixFeed searchMixFeed = (SearchMixFeed) methodHookParam.thisObject;
            Aweme aweme = (Aweme) methodHookParam.getResult();
            g.a(searchMixFeed);
            if (g.a(aweme)) {
                methodHookParam.setResult((Object) null);
            }
        }
    }
}
