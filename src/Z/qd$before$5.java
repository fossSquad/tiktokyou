package Z;
import com.windukk.hook.HookMethod;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class qd$before$5 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str;
        try {
            Object[] objArr = hookMethodParam.args;
            Object orNull = ArraysKt.getOrNull(objArr, 0);
            String str2 = orNull instanceof String ? (String) orNull : null;
            Object[] objArr2 = hookMethodParam.args;
            Object orNull2 = ArraysKt.getOrNull(objArr2, 1);
            String str3 = orNull2 instanceof String ? (String) orNull2 : null;
            if (str2 != null && str2.length() != 0) {
                if (str3 == null) {
                    str = str2;
                } else {
                    str = str3.length() > 0 ? str3 : null;
                    if (str == null) {
                        str = str2;
                    }
                }
                qd qdVar = qd.a;
                if (qd.a(str2, str)) {
                    hookMethodParam.setResult(str);
                }
            }
        } catch (Throwable th) {
            g7.a(6, g7.a("Unhandled hook exception on " + hookMethodParam.method.getName(), new Object[0]), th);
        }
    }
}
