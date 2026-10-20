package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;

class c1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof Aweme) {
                Aweme aweme = (Aweme) obj;
                User author = aweme != null ? aweme.getAuthor() : null;
                hookMethodParam.setResult(v1.a(author != null ? author.getUid() : null, (String) hookMethodParam.getResult()));
            }
        }
    }
}
