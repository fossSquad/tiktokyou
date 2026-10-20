package Z;
import com.windukk.hook.HookMethod;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class qd$before$7 extends HookMethod {
    final  int a;
    final  int b;
    final  v9 c;

    public qd$before$7(int i, int i2, v9 v9Var) {
        this.a = i;
        this.b = i2;
        this.c = v9Var;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object[] objArr = hookMethodParam.args;
            Object orNull = ArraysKt.getOrNull(objArr, this.a);
            String str = orNull instanceof String ? (String) orNull : null;
            Object[] objArr2 = hookMethodParam.args;
            Object orNull2 = ArraysKt.getOrNull(objArr2, this.b);
            String str2 = orNull2 instanceof String ? (String) orNull2 : null;
            if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
                qd qdVar = qd.a;
                if (qd.a(str, str2)) {
                    String str3 = this.c.c[0];
                    hookMethodParam.setResult((Object) null);
                }
            }
        } catch (Throwable th) {
            g7.a(6, g7.a("Unhandled hook exception on " + hookMethodParam.method.getName(), new Object[0]), th);
        }
    }
}
