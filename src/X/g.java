package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LX/g;", "Lde/robv/android/xposed/XC_MethodHook;", "Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;", "param", "", "afterHookedMethod", "(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V", "mod_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Intrinsics.checkNotNullParameter(methodHookParam, "param");
        try {
            Object obj = methodHookParam.thisObject;
            if (obj == null) {
                return;
            }
            try {
                obj.getClass().getMethod("ko", null).invoke(obj, null);
            } catch (Throwable th) {
            }
            q.a(obj);
            methodHookParam.method.getName();
            ArrayList arrayList = g1.a;
        } catch (Throwable th2) {
            th2.getMessage();
            ArrayList arrayList2 = g1.a;
        }
    }
}
