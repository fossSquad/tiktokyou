package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.FontHooks;
import java.util.Map;

public class r5 extends HookMethod {
    final  boolean a;

    public r5(boolean z) {
        this.a = z;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Aweme aweme;
        Object obj;
        Boolean bool;
        Object[] objArr = hookMethodParam.args;
        Map map = FontHooks.a;
        boolean z = true;
        if (objArr.length >= 2) {
            Object obj2 = objArr[1];
            if (obj2 instanceof Aweme) {
                aweme = (Aweme) obj2;
            } else {
                aweme = null;
            }
        } else {
            aweme = null;
        }
        if (!this.a && ((obj = hookMethodParam.thisObject) == null || (bool = (Boolean) FontHooks.a.get(obj)) == null || !bool.booleanValue())) {
            z = false;
        }
        if (aweme == null || !m5.a(aweme, z)) {
            return;
        }
        hookMethodParam.setResult((Object) null);
    }
}
