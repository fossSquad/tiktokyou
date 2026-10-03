package Z;

import Z.h6;

import com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel;
import com.windukk.hook.HookMethod;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$after$2", "Lcom/windukk/hook/HookMethod;", "afterHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PhotoHooks$after$4 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            if (Intrinsics.areEqual(PhotoHooks.b.get(), Boolean.TRUE)) {
                return;
            }
            PhotoHooks ccVar = PhotoHooks.a;
            PhotoHooks.b(hookMethodParam.thisObject);
            Object result = hookMethodParam.getResult();
            if (result instanceof PhotoModeImageUrlModel) {
                PhotoHooks.b((PhotoModeImageUrlModel) result);
                return;
            }
            if (!(result instanceof List)) {
                PhotoHooks.b(result);
                return;
            }
            List list = (List) result;
            if (list.isEmpty()) {
                return;
            }
            for (Object obj : list) {
                if (obj instanceof PhotoModeImageUrlModel) {
                    PhotoHooks.b((PhotoModeImageUrlModel) obj);
                }
            }
        } catch (Throwable th) {
            h6.a(6, h6.a(new StringBuilder().append("Unhandled hook exception on ").append(hookMethodParam.method.getName()).toString(), new Object[0]), th);
        }
    }
}
