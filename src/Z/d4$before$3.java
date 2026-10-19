package Z;

import android.content.ContentValues;
import android.net.Uri;
import com.windukk.hook.HookMethod;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class d4$before$3 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object[] objArr = hookMethodParam.args;
            Object orNull = ArraysKt.getOrNull(objArr, 1);
            ContentValues contentValues = orNull instanceof ContentValues ? (ContentValues) orNull : null;
            if (contentValues == null) {
                return;
            }
            Object[] objArr2 = hookMethodParam.args;
            Object orNull2 = ArraysKt.getOrNull(objArr2, 0);
            Uri uri = orNull2 instanceof Uri ? (Uri) orNull2 : null;
            q4 q4VarA = r4.a(contentValues);
            if (q4VarA != null) {
                d4.b.set(q4VarA);
                AtomicBoolean atomicBoolean = d4.a;
                d4.a(contentValues, q4VarA, uri);
            } else if (w3.a(contentValues.getAsString("relative_path"), contentValues.getAsString("_display_name"))) {
                w3.a(contentValues, uri, false);
            }
            d4.a(hookMethodParam, contentValues, uri);
        } catch (Throwable th) {
            g7.a(6, g7.a(di.a("OeUPYkbKTiU//BMfTdyopL35ufsZ1h4nTZh49hXmABz5INhyTHGfQacpT9sB3nXu", "d91kvL1QgConEYmB", "aes", new StringBuilder(), hookMethodParam.method.getName()), new Object[0]), th);
        }
    }
}
