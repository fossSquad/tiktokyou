package Z;

import Z.b4;
import Z.c4;
import Z.h6;

import android.net.Uri;
import com.windukk.hook.HookMethod;
import java.util.concurrent.atomic.AtomicLong;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$after$2", "Lcom/windukk/hook/HookMethod;", "afterHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class DownloadMediaStoreHooks$after$2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        b4 b4Var;
        try {
            Object[] objArr = hookMethodParam.args;
            Object objFirstOrNull = ArraysKt.firstOrNull(objArr);
            Uri uri = objFirstOrNull instanceof Uri ? (Uri) objFirstOrNull : null;
            if (uri == null || (b4Var = (b4) DownloadMediaStoreHooks.b.remove(uri.toString())) == null) {
                return;
            }
            AtomicLong atomicLong = c4.a;
            c4.a(Long.valueOf(b4Var.a), uri);
        } catch (Throwable th) {
            h6.a(6, h6.a(new StringBuilder().append("Unhandled hook exception on ").append(hookMethodParam.method.getName()).toString(), new Object[0]), th);
        }
    }
}
