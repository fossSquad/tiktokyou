package X;

import android.app.Activity;
import com.windukk.hook.HookMethod;

class u9 extends HookMethod {
    final  String a;

    public u9(String str) {
        this.a = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            ((Activity) hookMethodParam.thisObject).finish();
            int i = p4.a;
        } catch (Exception e) {
            e.getMessage();
            int i2 = p4.a;
        }
    }
}
