package X;

import android.content.Context;
import android.view.View;
import com.ss.android.ugc.aweme.comment.model.Comment;
import de.robv.android.xposed.XC_MethodHook;
import java.lang.reflect.Method;
import java.util.ArrayList;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LX/p;", "Lde/robv/android/xposed/XC_MethodHook;", "Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;", "param", "", "beforeHookedMethod", "(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V", "mod_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        String text;
        Intrinsics.checkNotNullParameter(methodHookParam, "param");
        Object[] objArr = methodHookParam.args;
        if (objArr.length < 2) {
            return;
        }
        try {
            Object obj = objArr[0];
            Comment comment = obj instanceof Comment ? (Comment) obj : null;
            if (comment != null && (text = comment.getText()) != null) {
                Method declaredMethod = Class.forName("X.13n7").getDeclaredMethod("LIZIZ", null);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, null);
                Context context = objInvoke instanceof Context ? (Context) objInvoke : null;
                if (context == null) {
                    return;
                }
                Object obj2 = methodHookParam.thisObject.getClass().getField("itemView").get(methodHookParam.thisObject);
                View view = obj2 instanceof View ? (View) obj2 : null;
                q.a(context, text);
                if (view != null) {
                    q.a(view, context);
                }
                methodHookParam.setResult((Object) null);
            }
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = g1.a;
        }
    }
}
