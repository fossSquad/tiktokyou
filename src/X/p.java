package X;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.comment.model.Comment;
import de.robv.android.xposed.XC_MethodHook;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;

class p extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Context context;
        String text;
        try {
            Object obj = methodHookParam.thisObject;
            Field declaredField = obj.getClass().getDeclaredField("LIZ");
            declaredField.setAccessible(true);
            WeakReference weakReference = (WeakReference) declaredField.get(obj);
            Fragment fragment = weakReference != null ? (Fragment) weakReference.get() : null;
            if (fragment != null && (context = fragment.getContext()) != null) {
                Field declaredField2 = obj.getClass().getDeclaredField("LIZJ");
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                if (obj2 == null) {
                    return;
                }
                Object objInvoke = obj2.getClass().getMethod("LIZ", null).invoke(obj2, null);
                if ((objInvoke instanceof Comment) && (text = ((Comment) objInvoke).getText()) != null) {
                    y.a(context, text);
                    y.a(fragment, context);
                    methodHookParam.setResult((Object) null);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = r1.a;
        }
    }
}
