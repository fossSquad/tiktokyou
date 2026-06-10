package X;

import android.content.Context;
import android.view.View;
import com.ss.android.ugc.aweme.comment.model.Comment;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Method;

class n1 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String text;
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length < 2) {
            return;
        }
        try {
            Object obj = objArr[0];
            if ((obj instanceof Comment) && (text = ((Comment) obj).getText()) != null) {
                Method methodA = v1.a((Class) Class.forName("X.13RH"));
                Object objInvoke = methodA != null ? methodA.invoke(null, null) : null;
                if (objInvoke instanceof Context) {
                    Context context = (Context) objInvoke;
                    Object obj2 = hookMethodParam.thisObject;
                    Object obj3 = g8.a((Class) obj2.getClass(), "itemView").get(obj2);
                    View view = obj3 instanceof View ? (View) obj3 : null;
                    v1.a(context, text);
                    if (view != null) {
                        v1.a(view, context);
                    }
                    hookMethodParam.setResult((Object) null);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            int i = p4.a;
        }
    }
}
