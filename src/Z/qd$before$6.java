package Z;

import android.graphics.Point;
import android.util.Size;
import com.windukk.hook.HookMethod;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class qd$before$6 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Pair pair;
        try {
            Object[] objArr = hookMethodParam.args;
            Object orNull = ArraysKt.getOrNull(objArr, 3);
            String str = orNull instanceof String ? (String) orNull : null;
            if (str != null) {
                pair = (str.length() != 0 && qd.b(str)) ? new Pair(new Point(1, 1), new Size(1, 1)) : new Pair((Object) null, (Object) null);
            }
            hookMethodParam.setResult(pair);
        } catch (Throwable th) {
            g7.a(6, g7.a(di.a("eY9SMsLc4Z+qeeUFx5P3/jHiOPAbdVwYMptIWT4q9awt1eOHgaW9vAGMFVoKW8bm", "DePaEbfZfdlAb2XN", "aes", new StringBuilder(), hookMethodParam.method.getName()), new Object[0]), th);
        }
    }
}
