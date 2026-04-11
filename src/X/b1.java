package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Video;
import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;

class b1 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Video video = (Video) methodHookParam.thisObject;
        String name = methodHookParam.method.getName();
        UrlModel urlModel = (UrlModel) methodHookParam.getResult();
        f1 f1VarA = h1.a(video, urlModel, name);
        if (f1VarA != null) {
            methodHookParam.setResult(f1VarA.a);
            String urlKey = urlModel != null ? urlModel.getUrlKey() : null;
            UrlModel urlModel2 = f1VarA.a;
            String urlKey2 = urlModel2 != null ? urlModel2.getUrlKey() : null;
            if (urlKey2 != null) {
                if (urlKey2.equals(urlKey)) {
                    return;
                }
            } else if (f1VarA.a == urlModel) {
                return;
            }
            ArrayList arrayList = p2.a;
        }
    }
}
