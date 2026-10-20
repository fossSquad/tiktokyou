package Z;
import com.windukk.hook.HookMethod;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class v3$before$1 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        p4 p4Var;
        try {
            Object[] objArr = hookMethodParam.args;
            Object objFirstOrNull = ArraysKt.firstOrNull(objArr);
            ThreadLocal threadLocal = r4.c;
            p4 p4Var2 = (p4) threadLocal.get();
            if (p4Var2 == null) {
                if (objFirstOrNull != null) {
                    Map map = r4.b;
                    p4Var2 = (p4) map.get(objFirstOrNull);
                } else {
                    p4Var2 = null;
                }
                if (p4Var2 == null) {
                    return;
                }
            }
            o3 o3Var = p4Var2.g;
            if (o3Var == null || o3Var.d == dk.KNOWN_WATERMARKED) {
                return;
            }
            if (objFirstOrNull != null) {
                Map map2 = r4.b;
                p4Var = (p4) map2.get(objFirstOrNull);
            } else {
                p4Var = null;
            }
            if (p4Var == null) {
                p4Var = (p4) threadLocal.get();
            }
            r4.a(p4Var != null ? Long.valueOf(p4Var.a) : null);
            hookMethodParam.setResult((Object) null);
        } catch (Throwable th) {
            g7.a(6, g7.a("Unhandled hook exception on " + hookMethodParam.method.getName(), new Object[0]), th);
        }
    }
}
