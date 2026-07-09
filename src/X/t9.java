package X;

import android.os.Handler;
import com.windukk.hook.HookMethod;

class t9 extends HookMethod {
    final  String a;

    public t9(String str) {
        this.a = str;
    }

    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj = hookMethodParam.thisObject;
        String str = this.a;
        float f = v9.f;
        if (obj == null || v9.a(f) || v9.h != null) {
            return;
        }
        long j = v9.j;
        if ((j <= 0 || System.currentTimeMillis() - j >= 1200) && !Boolean.TRUE.equals(v9.l.get())) {
            v9.a(obj, f);
            Handler handler = v9.k;
            handler.postDelayed(new u9(obj, f, str + "+80ms"), 80L);
            handler.postDelayed(new u9(obj, f, str + "+250ms"), 250L);
            handler.postDelayed(new u9(obj, f, str + "+600ms"), 600L);
        }
    }
}
