package X;

import com.windukk.hook.HookMethod;
import java.lang.reflect.Field;
import java.util.List;

class w2 extends HookMethod {
    final  Field a;
    final  boolean b;

    public w2(Field field, boolean z) {
        this.a = field;
        this.b = z;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj;
        if (g3.a() && (obj = hookMethodParam.thisObject) != null) {
            try {
                Object obj2 = this.a.get(obj);
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    if (list.isEmpty()) {
                        return;
                    }
                    List listB = this.b ? g3.b(list) : g3.a(list);
                    if (listB != obj2) {
                        this.a.set(obj, listB);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}
