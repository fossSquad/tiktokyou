package X;

import android.app.Activity;
import com.windukk.hook.HookMethod;

class zb extends HookMethod {
    final  String a;

    public zb(String str) {
        this.a = str;
    }

    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            ((Activity) hookMethodParam.thisObject).finish();
            int i = g5.a;
        } catch (Exception e) {
            e.getMessage();
            int i2 = g5.a;
        }
    }
}
