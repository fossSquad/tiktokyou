package X;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.comment.model.Comment;
import com.windukk.hook.HookMethod;
import java.lang.ref.WeakReference;

class p1 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Context context;
        Object obj;
        String text;
        try {
            Object obj2 = hookMethodParam.thisObject;
            WeakReference weakReference = (WeakReference) p5.a.a(obj2.getClass()).get(obj2);
            Fragment fragment = weakReference != null ? (Fragment) weakReference.get() : null;
            if (fragment != null && (context = fragment.getContext()) != null && (obj = p5.b.a(obj2.getClass()).get(obj2)) != null) {
                Object objInvoke = q5.a.a(obj.getClass(), new Class[0]).invoke(obj, null);
                if ((objInvoke instanceof Comment) && (text = ((Comment) objInvoke).getText()) != null) {
                    y1.a(context, text);
                    y1.a(fragment, context);
                    hookMethodParam.setResult(null);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            int i = g5.a;
        }
    }
}
