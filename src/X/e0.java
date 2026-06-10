package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import com.windukk.hook.HookMethod;

class e0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(a1.a(((IMUser) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
