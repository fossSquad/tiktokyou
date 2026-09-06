package Z;

import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.FeedHooks;
import java.lang.reflect.Field;
import java.util.List;

class q4 extends HookMethod {
    final  Field a;
    final  boolean b;

    public q4(Field field, boolean z) {
        this.a = field;
        this.b = z;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj;
        if (FeedHooks.a() && (obj = hookMethodParam.thisObject) != null) {
            try {
                Object obj2 = this.a.get(obj);
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    if (list.isEmpty()) {
                        return;
                    }
                    List listB = this.b ? FeedHooks.b(list) : FeedHooks.a(list);
                    if (listB != obj2) {
                        this.a.set(obj, listB);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}
