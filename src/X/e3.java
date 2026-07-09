package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Video;
import com.windukk.hook.HookMethod;
import java.util.Map;

class e3 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        o3 o3Var;
        Video video = (Video) hookMethodParam.thisObject;
        hookMethodParam.method.getName();
        UrlModel urlModel = (UrlModel) hookMethodParam.getResult();
        if (video != null) {
            o3Var = (o3) h3.a.get(video);
        } else {
            Map map = h3.a;
            o3Var = null;
        }
        if (o3Var != null) {
            hookMethodParam.setResult(o3Var.a);
            p3.a(o3Var, urlModel);
        }
    }
}
