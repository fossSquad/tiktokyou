package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.profile.model.User;
import de.robv.android.xposed.XC_MethodHook;

class w extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Object[] objArr = methodHookParam.args;
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof Aweme) {
                Aweme aweme = (Aweme) obj;
                User author = aweme != null ? aweme.getAuthor() : null;
                methodHookParam.setResult(k0.a(author != null ? author.getUid() : null, (String) methodHookParam.getResult()));
            }
        }
    }
}
