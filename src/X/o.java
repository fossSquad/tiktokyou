package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import com.windukk.hook.HookMethod;

class o extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(t0.a(((IMUser) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
