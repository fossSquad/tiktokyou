package X;

import android.content.Context;
import android.view.View;
import com.ss.android.ugc.aweme.comment.model.Comment;
import de.robv.android.xposed.XC_MethodHook;
import java.lang.reflect.Method;
import java.util.ArrayList;

class q extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        String text;
        Object[] objArr = methodHookParam.args;
        if (objArr == null || objArr.length < 2) {
            return;
        }
        try {
            Object obj = objArr[0];
            if ((obj instanceof Comment) && (text = ((Comment) obj).getText()) != null) {
                Method methodA = y.a((Class) Class.forName("X.0ZOL"));
                Object objInvoke = methodA != null ? methodA.invoke(null, null) : null;
                if (objInvoke instanceof Context) {
                    Context context = (Context) objInvoke;
                    Object obj2 = methodHookParam.thisObject.getClass().getField("itemView").get(methodHookParam.thisObject);
                    View view = obj2 instanceof View ? (View) obj2 : null;
                    y.a(context, text);
                    if (view != null) {
                        y.a(view, context);
                    }
                    methodHookParam.setResult((Object) null);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = r1.a;
        }
    }
}
