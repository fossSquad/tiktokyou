package X;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.comment.model.Comment;
import com.windukk.hook.HookMethod;
import java.lang.ref.WeakReference;

class y0 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Context context;
        Object obj;
        String text;
        try {
            Object obj2 = hookMethodParam.thisObject;
            WeakReference weakReference = (WeakReference) e4.a(obj2.getClass(), "LIZ").get(obj2);
            Fragment fragment = weakReference != null ? (Fragment) weakReference.get() : null;
            if (fragment != null && (context = fragment.getContext()) != null && (obj = e4.a(obj2.getClass(), "LIZJ").get(obj2)) != null) {
                Object objInvoke = e4.a(obj.getClass(), "LIZ", new Class[0]).invoke(obj, null);
                if ((objInvoke instanceof Comment) && (text = ((Comment) objInvoke).getText()) != null) {
                    h1.a(context, text);
                    h1.a(fragment, context);
                    hookMethodParam.setResult((Object) null);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            int i = v3.a;
        }
    }
}
