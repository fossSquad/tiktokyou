package X;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.comment.model.Comment;
import com.windukk.hook.HookMethod;
import java.lang.ref.WeakReference;

class m1 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Context context;
        Object obj;
        String text;
        try {
            Object obj2 = hookMethodParam.thisObject;
            WeakReference weakReference = (WeakReference) y4.a.a(obj2.getClass()).get(obj2);
            Fragment fragment = weakReference != null ? (Fragment) weakReference.get() : null;
            if (fragment != null && (context = fragment.getContext()) != null && (obj = y4.b.a(obj2.getClass()).get(obj2)) != null) {
                Object objInvoke = z4.a.a(obj.getClass(), new Class[0]).invoke(obj, null);
                if ((objInvoke instanceof Comment) && (text = ((Comment) objInvoke).getText()) != null) {
                    v1.a(context, text);
                    v1.a(fragment, context);
                    hookMethodParam.setResult((Object) null);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            int i = p4.a;
        }
    }
}
