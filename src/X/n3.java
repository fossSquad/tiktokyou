package X;

import com.ss.android.ugc.aweme.search.common.model.ContinuousLoadingAwemeList;
import de.robv.android.xposed.XC_MethodHook;
import java.util.List;

class n3 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (s2.a().d) {
            ContinuousLoadingAwemeList continuousLoadingAwemeList = (ContinuousLoadingAwemeList) methodHookParam.thisObject;
            continuousLoadingAwemeList.awemeList = g.a(continuousLoadingAwemeList.awemeList);
            Object result = methodHookParam.getResult();
            if (result instanceof List) {
                try {
                    methodHookParam.setResult(g.a((List) result));
                } catch (Throwable th) {
                }
            }
        }
    }
}
