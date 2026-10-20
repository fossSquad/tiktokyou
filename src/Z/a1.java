package Z;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import com.windukk.hook.HookMethod;

class a1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        hookMethodParam.setResult(v1.a(((IMUser) hookMethodParam.thisObject).getUid(), (String) hookMethodParam.getResult()));
    }
}
