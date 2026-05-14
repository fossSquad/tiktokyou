package X;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Video;
import com.windukk.hook.HookMethod;
import java.lang.reflect.InvocationTargetException;

class i2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Video video = (Video) hookMethodParam.thisObject;
        String name = hookMethodParam.method.getName();
        UrlModel urlModel = (UrlModel) hookMethodParam.getResult();
        m2 m2VarA = o2.a(video, urlModel, name);
        if (m2VarA != null) {
            hookMethodParam.setResult(m2VarA.a);
            String urlKey = urlModel != null ? urlModel.getUrlKey() : null;
            UrlModel urlModel2 = m2VarA.a;
            String urlKey2 = urlModel2 != null ? urlModel2.getUrlKey() : null;
            if (urlKey2 != null) {
                if (urlKey2.equals(urlKey)) {
                    return;
                }
            } else if (m2VarA.a == urlModel) {
                return;
            }
            int i = v3.a;
        }
    }
}
