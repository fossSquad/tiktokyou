package Z;

import android.os.Handler;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.EdgeSpeedupHooks;

class ic extends HookMethod {
    final  String a;

    public ic(String str) {
        this.a = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj = hookMethodParam.thisObject;
        String str = this.a;
        float f = EdgeSpeedupHooks.f;
        if (obj == null || EdgeSpeedupHooks.a(f) || EdgeSpeedupHooks.h != null) {
            return;
        }
        long j = EdgeSpeedupHooks.j;
        if ((j <= 0 || System.currentTimeMillis() - j >= 1200) && !Boolean.TRUE.equals(EdgeSpeedupHooks.l.get())) {
            EdgeSpeedupHooks.a(obj, f);
            Handler handler = EdgeSpeedupHooks.k;
            handler.postDelayed(new jc(obj, f, new StringBuilder().append(str).append("+80ms").toString()), 80L);
            handler.postDelayed(new jc(obj, f, new StringBuilder().append(str).append("+250ms").toString()), 250L);
            handler.postDelayed(new jc(obj, f, new StringBuilder().append(str).append("+600ms").toString()), 600L);
        }
    }
}
