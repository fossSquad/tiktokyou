package X;

import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;

class q0 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(d1.a(((User) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
