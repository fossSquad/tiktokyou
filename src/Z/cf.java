package Z;

import android.app.Activity;
import android.graphics.Bitmap;
import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;
import ni.shikatu.kotlin.jvm.functions.Function1;

class cf extends ReplaceMethod {
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str;
        String str2;
        Bitmap bitmap = (Bitmap) hookMethodParam.args[0];
        Object obj = hookMethodParam.thisObject;
        Object objA = df.a(Function1.class, obj);
        Activity activity = (Activity) df.a(Activity.class, obj);
        if (bitmap == null || activity == null) {
            df.a(objA, false);
            return null;
        }
        boolean zA = df.a(activity, bitmap);
        df.a(objA, zA);
        if (!zA) {
        }
        return null;
    }
}
