package Z;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Field;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class v3$before$3 extends HookMethod {
    final  Field a;
    final  Field b;

    public v3$before$3(Field field, Field field2) {
        this.a = field;
        this.b = field2;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj;
        try {
            Object obj2 = this.a.get(hookMethodParam.thisObject);
            if (obj2 != null) {
                Class cls = v3.d;
                if (cls == null) {
                    cls = null;
                }
                if (!cls.isInstance(obj2)) {
                    obj2 = null;
                }
                if (obj2 != null && (obj = this.b.get(obj2)) != null) {
                    Map map = r4.b;
                    p4 p4Var = (p4) map.get(obj);
                    if (p4Var == null) {
                        r4.a(new Object[0]);
                    } else {
                        r4.a(Long.valueOf(p4Var.a));
                    }
                }
            }
        } catch (Throwable th) {
            g7.a(6, g7.a(di.a("Y+PpRoDNzi0VrTN9e9UvFgWPrmbnd4cU9jRcsStPerJZEOwk4ie3Z2nA8JuflSQT", "J2qItzK9SHzPmNs4", "aes", new StringBuilder(), hookMethodParam.method.getName()), new Object[0]), th);
        }
    }
}
