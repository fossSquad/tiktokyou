package Z;

import android.os.Handler;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.SearchHooks;

public class wd extends HookMethod {
    final  String a;

    public wd(String str) {
        this.a = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj = hookMethodParam.thisObject;
        String str = this.a;
        float f = SearchHooks.f;
        if (obj == null || SearchHooks.a(f) || SearchHooks.h != null) {
            return;
        }
        long j = SearchHooks.j;
        if ((j <= 0 || System.currentTimeMillis() - j >= 1200) && !Boolean.TRUE.equals(SearchHooks.l.get())) {
            SearchHooks.a(obj, f);
            Handler handler = SearchHooks.k;
            handler.postDelayed(new xd(obj, f, (new StringBuilder().append(str)).append("+80ms").toString()), 80L);
            handler.postDelayed(new xd(obj, f, (new StringBuilder().append(str)).append("+250ms").toString()), 250L);
            handler.postDelayed(new xd(obj, f, (new StringBuilder().append(str)).append("+600ms").toString()), 600L);
        }
    }
}
