package X;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.comment.model.Comment;
import de.robv.android.xposed.XC_MethodHook;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LX/o;", "Lde/robv/android/xposed/XC_MethodHook;", "Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;", "param", "", "beforeHookedMethod", "(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V", "mod_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Context context;
        String text;
        Intrinsics.checkNotNullParameter(methodHookParam, "param");
        try {
            Object obj = methodHookParam.thisObject;
            Field declaredField = obj.getClass().getDeclaredField("LIZ");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.lang.ref.WeakReference<*>");
            Object obj3 = ((WeakReference) obj2).get();
            Fragment fragment = obj3 instanceof Fragment ? (Fragment) obj3 : null;
            if (fragment != null && (context = fragment.getContext()) != null) {
                Field declaredField2 = obj.getClass().getDeclaredField("LIZJ");
                declaredField2.setAccessible(true);
                Object obj4 = declaredField2.get(obj);
                if (obj4 == null) {
                    return;
                }
                Object objInvoke = obj4.getClass().getMethod("LIZ", null).invoke(obj4, null);
                Comment comment = objInvoke instanceof Comment ? (Comment) objInvoke : null;
                if (comment == null || (text = comment.getText()) == null) {
                    return;
                }
                q.a(context, text);
                q.a(fragment, context);
                methodHookParam.setResult((Object) null);
            }
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = g1.a;
        }
    }
}
