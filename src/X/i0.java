package X;

import com.ss.android.ugc.aweme.im.common.model.BaseContact;
import com.windukk.hook.HookMethod;

class i0 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(t0.a(((BaseContact) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
