package Z;
import com.windukk.hook.HookMethod;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class i3$before$1 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        a4 a4Var;
        try {
            Object[] objArr = hookMethodParam.args;
            Object objFirstOrNull = ArraysKt.firstOrNull(objArr);
            ThreadLocal threadLocal = c4.c;
            a4 a4Var2 = (a4) threadLocal.get();
            if (a4Var2 == null) {
                if (objFirstOrNull != null) {
                    Map map = c4.b;
                    a4Var2 = (a4) map.get(objFirstOrNull);
                } else {
                    a4Var2 = null;
                }
                if (a4Var2 == null) {
                    return;
                }
            }
            b3 b3Var = a4Var2.g;
            if (b3Var == null || b3Var.d == sg.b) {
                return;
            }
            if (objFirstOrNull != null) {
                Map map2 = c4.b;
                a4Var = (a4) map2.get(objFirstOrNull);
            } else {
                a4Var = null;
            }
            if (a4Var == null) {
                a4Var = (a4) threadLocal.get();
            }
            c4.a(a4Var != null ? Long.valueOf(a4Var.a) : null);
            hookMethodParam.setResult((Object) null);
        } catch (Throwable th) {
            h6.a(6, h6.a(new StringBuilder().append("Unhandled hook exception on ").append(hookMethodParam.method.getName()).toString(), new Object[0]), th);
        }
    }
}
