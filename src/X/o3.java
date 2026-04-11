package X;

import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import de.robv.android.xposed.XC_MethodHook;

class o3 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (r2.a().d) {
            SearchMixFeed searchMixFeed = (SearchMixFeed) methodHookParam.thisObject;
            if (searchMixFeed.preciseAd != null) {
                searchMixFeed.preciseAd = null;
                methodHookParam.setResult((Object) null);
            }
        }
    }
}
