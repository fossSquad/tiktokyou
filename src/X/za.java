package X;

import android.app.Activity;
import android.graphics.Bitmap;
import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;
import kotlin.jvm.functions.Function1;

class za extends ReplaceMethod {
    @Override
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Bitmap bitmap = (Bitmap) hookMethodParam.args[0];
        Object obj = hookMethodParam.thisObject;
        Object objA = ab.a(Function1.class, obj);
        Activity activity = (Activity) ab.a(Activity.class, obj);
        if (bitmap == null || activity == null) {
            ab.a(objA, false);
            return null;
        }
        ab.a(objA, ab.a(activity, bitmap));
        int i = g5.a;
        return null;
    }
}
