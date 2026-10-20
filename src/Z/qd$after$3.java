package Z;

import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import com.windukk.hook.HookMethod;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$after$2", "Lcom/windukk/hook/HookMethod;", "afterHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class qd$after$3 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            if (Intrinsics.areEqual(qd.b.get(), Boolean.TRUE)) {
                return;
            }
            qd qdVar = qd.a;
            qd.b(hookMethodParam.thisObject);
            Object result = hookMethodParam.getResult();
            if (result instanceof PhotoModeImageUrlModel) {
                qd.b((PhotoModeImageUrlModel) result);
                return;
            }
            if (!(result instanceof List)) {
                qd.b(result);
                return;
            }
            List list = (List) result;
            if (list.isEmpty()) {
                return;
            }
            for (Object obj : list) {
                if (obj instanceof PhotoModeImageUrlModel) {
                    qd.b((PhotoModeImageUrlModel) obj);
                }
            }
        } catch (Throwable th) {
            g7.a(6, g7.a("Unhandled hook exception on " + hookMethodParam.method.getName(), new Object[0]), th);
        }
    }
}
