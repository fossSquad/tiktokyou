package Z;

import Z.h6;

import android.widget.TextView;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$after$1", "Lcom/windukk/hook/HookMethod;", "afterHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PublishTabHooks$after$2 extends HookMethod {
    final  Method a;
    final  Field b;
    final  PublishTabHooks c;

    public PublishTabHooks$after$2(Method method, Field field, PublishTabHooks wcVar) {
        this.a = method;
        this.b = field;
        this.c = wcVar;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            this.a.invoke(hookMethodParam.thisObject, null);
            Object obj = this.b.get(hookMethodParam.thisObject);
            if (obj == null) {
                return;
            }
            Object objInvoke = j9.a.a(obj.getClass(), new Class[0]).invoke(obj, null);
            TextView textView = objInvoke instanceof TextView ? (TextView) objInvoke : null;
            if (textView != null) {
                PublishTabHooks.a(this.c, textView);
            }
        } catch (Throwable th) {
            h6.a(6, h6.a(new StringBuilder().append("Unhandled hook exception on ").append(hookMethodParam.method.getName()).toString(), new Object[0]), th);
        }
    }
}
