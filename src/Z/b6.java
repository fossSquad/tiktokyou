package Z;

import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$replace$2", "Lcom/windukk/hook/ReplaceMethod;", "replaceHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 176)
public final class b6 extends ReplaceMethod {
    final  Function1<HookMethod.HookMethodParam, Object> a;

    public b6(Function1<? super HookMethod.HookMethodParam, ? extends Object> function1) {
        this.a = function1;
    }

    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            return this.a.invoke(hookMethodParam);
        } catch (Throwable th) {
            h6.a(6, h6.a("Unhandled hook exception on " + hookMethodParam.method.getName(), new Object[0]), th);
            return null;
        }
    }
}
