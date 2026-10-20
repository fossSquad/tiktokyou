package Z;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;

class p1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        if (result instanceof User) {
            User user = (User) result;
            String uid = user.getUid();
            if (TextUtils.isEmpty(uid)) {
                return;
            }
            v1.w = uid;
            v1.x = v1.a((CharSequence) user.getNickname());
        }
    }
}
