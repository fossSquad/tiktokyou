package X;

import android.app.Activity;
import android.graphics.Bitmap;
import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;
import kotlin.jvm.functions.Function1;

class y8 extends ReplaceMethod {
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Bitmap bitmap = (Bitmap) hookMethodParam.args[0];
        Object obj = hookMethodParam.thisObject;
        Object objA = z8.a(Function1.class, obj);
        Activity activity = (Activity) z8.a(Activity.class, obj);
        if (bitmap == null || activity == null) {
            z8.a(objA, false);
            return null;
        }
        z8.a(objA, z8.a(activity, bitmap));
        int i = p4.a;
        return null;
    }
}
