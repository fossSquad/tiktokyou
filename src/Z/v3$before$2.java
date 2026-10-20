package Z;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Member;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class v3$before$2 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            if (((Boolean) v3.a.get()).booleanValue()) {
                return;
            }
            Object[] objArr = hookMethodParam.args;
            Object objSingleOrNull = ArraysKt.singleOrNull(objArr);
            if (objSingleOrNull != null) {
                Class cls = v3.c;
                if (cls == null) {
                    cls = null;
                }
                if (!cls.isInstance(objSingleOrNull)) {
                    objSingleOrNull = null;
                }
                if (objSingleOrNull != null) {
                    ThreadLocal threadLocal = v3.a;
                    Member member = hookMethodParam.method;
                    if (v3.a(objSingleOrNull, member, (Object[]) hookMethodParam.args.clone())) {
                        hookMethodParam.setResult((Object) null);
                    }
                }
            }
        } catch (Throwable th) {
            g7.a(6, g7.a("Unhandled hook exception on " + hookMethodParam.method.getName(), new Object[0]), th);
        }
    }
}
