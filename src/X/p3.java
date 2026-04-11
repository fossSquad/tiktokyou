package X;

import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import de.robv.android.xposed.XC_MethodHook;

class p3 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().d) {
            SearchMixFeed searchMixFeed = (SearchMixFeed) methodHookParam.thisObject;
            g.a(searchMixFeed);
            if (g.b(searchMixFeed)) {
                methodHookParam.setResult(Boolean.FALSE);
            }
        }
    }
}
