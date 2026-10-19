package Z;

import com.ss.android.ugc.aweme.im.common.model.BaseContact;
import com.windukk.hook.HookMethod;

class z0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(v1.a(((BaseContact) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
