package X;

import android.os.Handler;
import com.windukk.hook.HookMethod;

class w7 extends HookMethod {
    final  String a;

    public w7(String str) {
        this.a = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj = hookMethodParam.thisObject;
        String str = this.a;
        float f = y7.f;
        if (obj == null || y7.a(f) || y7.h != null) {
            return;
        }
        long j = y7.j;
        if ((j <= 0 || System.currentTimeMillis() - j >= 1200) && !Boolean.TRUE.equals(y7.l.get())) {
            y7.a(obj, f);
            Handler handler = y7.k;
            handler.postDelayed(new x7(obj, f, str + "+80ms"), 80L);
            handler.postDelayed(new x7(obj, f, str + "+250ms"), 250L);
            handler.postDelayed(new x7(obj, f, str + "+600ms"), 600L);
        }
    }
}
