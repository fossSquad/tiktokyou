package X;

import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import com.windukk.hook.HookMethod;
import java.util.List;

class k9 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        n9.b(hookMethodParam.thisObject);
        Object result = hookMethodParam.getResult();
        if (result instanceof PhotoModeImageUrlModel) {
            n9.c((PhotoModeImageUrlModel) result);
            return;
        }
        if (!(result instanceof List)) {
            n9.b(result);
            return;
        }
        List list = (List) result;
        if (list.isEmpty()) {
            return;
        }
        for (Object obj : list) {
            if (obj instanceof PhotoModeImageUrlModel) {
                n9.c((PhotoModeImageUrlModel) obj);
            }
        }
    }
}
