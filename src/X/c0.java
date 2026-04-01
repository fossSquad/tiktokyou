package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Video;
import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class c0 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Video video = (Video) methodHookParam.thisObject;
        String name = methodHookParam.method.getName();
        UrlModel urlModel = (UrlModel) methodHookParam.getResult();
        g0 g0VarA = i0.a(video, urlModel, name);
        if (g0VarA != null) {
            methodHookParam.setResult(g0VarA.a);
            String urlKey = urlModel != null ? urlModel.getUrlKey() : null;
            UrlModel urlModel2 = g0VarA.a;
            String urlKey2 = urlModel2 != null ? urlModel2.getUrlKey() : null;
            if (urlKey2 != null) {
                if (urlKey2.equals(urlKey)) {
                    return;
                }
            } else if (g0VarA.a == urlModel) {
                return;
            }
            ArrayList arrayList = r1.a;
        }
    }
}
