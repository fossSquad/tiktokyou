package X;

import com.windukk.hook.HookMethod;
import java.lang.reflect.Field;
import java.util.List;

class y3 extends HookMethod {
    final  Field a;
    final  boolean b;

    public y3(Field field, boolean z) {
        this.a = field;
        this.b = z;
    }

    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj;
        if (i4.a() && (obj = hookMethodParam.thisObject) != null) {
            try {
                Object obj2 = this.a.get(obj);
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    if (list.isEmpty()) {
                        return;
                    }
                    List listB = this.b ? i4.b(list) : i4.a(list);
                    if (listB != obj2) {
                        this.a.set(obj, listB);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}
