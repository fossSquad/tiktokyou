package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import com.windukk.hook.HookMethod;

class g0 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(d1.a(((IMUser) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
