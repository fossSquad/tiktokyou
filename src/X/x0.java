package X;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;

class x0 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        if (result instanceof User) {
            User user = (User) result;
            String uid = user.getUid();
            if (TextUtils.isEmpty(uid)) {
                return;
            }
            d1.v = uid;
            d1.a((CharSequence) user.getNickname());
            ConcurrentHashMap concurrentHashMap = d1.a;
        }
    }
}
