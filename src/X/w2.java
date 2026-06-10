package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Video;
import com.windukk.hook.HookMethod;
import java.util.Map;

class w2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        g3 g3Var;
        Video video = (Video) hookMethodParam.thisObject;
        hookMethodParam.method.getName();
        UrlModel urlModel = (UrlModel) hookMethodParam.getResult();
        if (video != null) {
            g3Var = (g3) z2.a.get(video);
        } else {
            Map map = z2.a;
            g3Var = null;
        }
        if (g3Var != null) {
            hookMethodParam.setResult(g3Var.a);
            h3.a(g3Var, urlModel);
        }
    }
}
