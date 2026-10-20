package Z;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Field;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class qd$before$2 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object[] objArr = hookMethodParam.args;
            Object orNull = ArraysKt.getOrNull(objArr, 0);
            String str = orNull instanceof String ? (String) orNull : null;
            Object[] objArr2 = hookMethodParam.args;
            Object orNull2 = ArraysKt.getOrNull(objArr2, 1);
            String str2 = orNull2 instanceof String ? (String) orNull2 : null;
            Field field = qd.n;
            if (field == null) {
                field = null;
            }
            Object obj = field.get(hookMethodParam.thisObject);
            if (obj != null) {
                if (str != null && str.length() != 0) {
                    Field field2 = qd.o;
                    if (field2 == null) {
                        field2 = null;
                    }
                    field2.set(obj, str);
                }
                if (str2 != null && str2.length() != 0) {
                    Field field3 = qd.p;
                    if (field3 == null) {
                        field3 = null;
                    }
                    field3.set(obj, str2);
                }
                if (qd.a(obj, str, str2)) {
                    hookMethodParam.setResult((Object) null);
                    return;
                }
            }
            if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
                qd qdVar = qd.a;
                if (qd.a(str, str2)) {
                    hookMethodParam.setResult((Object) null);
                }
            }
        } catch (Throwable th) {
            g7.a(6, g7.a("Unhandled hook exception on " + hookMethodParam.method.getName(), new Object[0]), th);
        }
    }
}
