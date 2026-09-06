package Z;

import android.app.Activity;
import android.graphics.Bitmap;
import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;
import com.windukk.mod.hooks.SavePhotoHooks;
import ni.shikatu.kotlin.jvm.functions.Function1;

class nd extends ReplaceMethod {
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) throws Throwable {
        String str;
        String str2;
        Bitmap bitmap = (Bitmap) hookMethodParam.args[0];
        Object obj = hookMethodParam.thisObject;
        Object objA = SavePhotoHooks.a(Function1.class, obj);
        Activity activity = (Activity) SavePhotoHooks.a(Activity.class, obj);
        if (bitmap == null || activity == null) {
            SavePhotoHooks.a(objA, false);
            return null;
        }
        boolean zA = SavePhotoHooks.a(activity, bitmap);
        SavePhotoHooks.a(objA, zA);
        (zA ? "without" : "failed,");
        if (!zA) {
        }
        return null;
    }
}
