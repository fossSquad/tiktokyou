package X;

import com.ss.android.ugc.aweme.im.common.model.BaseContact;
import com.windukk.hook.HookMethod;

class f0 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(d1.a(((BaseContact) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
