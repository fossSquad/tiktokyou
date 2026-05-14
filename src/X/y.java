package X;

import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;

class y extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(t0.a(((User) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
