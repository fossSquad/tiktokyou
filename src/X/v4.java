package X;

import android.app.Activity;
import android.graphics.Bitmap;
import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;
import kotlin.jvm.functions.Function1;

class v4 extends ReplaceMethod {
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Bitmap bitmap = (Bitmap) hookMethodParam.args[0];
        Object obj = hookMethodParam.thisObject;
        Object objA = w4.a(Function1.class, obj);
        Activity activity = (Activity) w4.a(Activity.class, obj);
        if (bitmap == null || activity == null) {
            w4.a(objA, false);
            return null;
        }
        w4.a(objA, w4.a(activity, bitmap));
        int i = v3.a;
        return null;
    }
}
