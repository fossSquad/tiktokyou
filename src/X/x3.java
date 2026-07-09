package X;

import com.windukk.hook.HookMethod;
import java.lang.reflect.Field;
import java.util.List;

class x3 extends HookMethod {
    final  Class a;
    final  Field b;
    final  boolean c;

    public x3(Class cls, Field field, boolean z) {
        this.a = cls;
        this.b = field;
        this.c = z;
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr;
        if (i4.a() && (objArr = hookMethodParam.args) != null) {
            for (Object obj : objArr) {
                if (this.a.isInstance(obj)) {
                    Field field = this.b;
                    boolean z = this.c;
                    if (obj != null) {
                        try {
                            Object obj2 = field.get(obj);
                            if (obj2 instanceof List) {
                                List list = (List) obj2;
                                if (!list.isEmpty()) {
                                    List listB = z ? i4.b(list) : i4.a(list);
                                    if (listB != obj2) {
                                        field.set(obj, listB);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                        }
                    }
                }
            }
        }
    }
}
