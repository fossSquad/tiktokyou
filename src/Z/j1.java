package Z;

import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;

class j1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(v1.a(((User) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
