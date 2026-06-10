package X;

import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;

class p0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(a1.a(((User) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
