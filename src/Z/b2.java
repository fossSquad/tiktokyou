package Z;

import android.content.Context;
import android.view.View;
import com.ss.android.ugc.aweme.comment.model.Comment;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Method;

class b2 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String text;
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length < 2) {
            return;
        }
        try {
            Object obj = objArr[0];
            if ((obj instanceof Comment) && (text = ((Comment) obj).getText()) != null) {
                z7 z7Var = o7.a;
                Method methodA = j2.a((Class) Class.forName("X.02r4"));
                Object objInvoke = methodA != null ? methodA.invoke(null, null) : null;
                if (objInvoke instanceof Context) {
                    Context context = (Context) objInvoke;
                    Object obj2 = hookMethodParam.thisObject;
                    Object obj3 = dd.a((Class) obj2.getClass(), "itemView").get(obj2);
                    View view = obj3 instanceof View ? (View) obj3 : null;
                    j2.a(context, text);
                    if (view != null) {
                        j2.a(view, context);
                    }
                    hookMethodParam.setResult((Object) null);
                }
            }
        } catch (Throwable th) {
            String strDecrypt = "Copy (Collect) error";
            Object obj4 = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
