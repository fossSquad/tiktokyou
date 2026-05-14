package X;

import android.app.Activity;
import com.windukk.hook.HookMethod;

class o5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            ((Activity) hookMethodParam.thisObject).finish();
            int i = v3.a;
        } catch (Exception e) {
            new StringBuilder("Failed to finish splash activity: ").append(e.getMessage());
            int i2 = v3.a;
        }
    }
}
