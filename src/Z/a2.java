package Z;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.comment.model.Comment;
import com.windukk.hook.HookMethod;
import java.lang.ref.WeakReference;

class a2 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Context context;
        Object obj;
        String text;
        try {
            Object obj2 = hookMethodParam.thisObject;
            WeakReference weakReference = (WeakReference) x6.a.a(obj2.getClass()).get(obj2);
            Fragment fragment = weakReference != null ? (Fragment) weakReference.get() : null;
            if (fragment != null && (context = fragment.getContext()) != null && (obj = x6.b.a(obj2.getClass()).get(obj2)) != null) {
                Object objInvoke = y6.a.a(obj.getClass(), new Class[0]).invoke(obj, null);
                if ((objInvoke instanceof Comment) && (text = ((Comment) objInvoke).getText()) != null) {
                    j2.a(context, text);
                    j2.a(fragment, context);
                    hookMethodParam.setResult((Object) null);
                }
            }
        } catch (Throwable th) {
            String strDecrypt = "CommentHooks copy (mGv) error";
            Object obj3 = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
