package X;

import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;

class u extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String uid;
        Object result = hookMethodParam.getResult();
        if (result instanceof String) {
            String str = (String) result;
            Object[] objArr = hookMethodParam.args;
            if (objArr.length == 0) {
                return;
            }
            Object obj = objArr[0];
            if (obj instanceof User) {
                uid = ((User) obj).getUid();
            } else if (obj instanceof IMUser) {
                uid = ((IMUser) obj).getUid();
            } else {
                uid = obj instanceof String ? (String) obj : null;
            }
            hookMethodParam.setResult(t0.a(uid, str));
        }
    }
}
