package Z;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;
import Z.BadgeHooks;

class f1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        if (result instanceof User) {
            User user = (User) result;
            String uid = user.getUid();
            if (TextUtils.isEmpty(uid)) {
                return;
            }
            BadgeHooks.w = uid;
            BadgeHooks.x = BadgeHooks.a((CharSequence) user.getNickname());
        }
    }
}
