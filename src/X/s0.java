package X;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

public final class s0 implements InvocationHandler {
    public final  LinkedHashMap a;
    public final  Object b;

    public s0(LinkedHashMap linkedHashMap, Object obj) {
        this.a = linkedHashMap;
        this.b = obj;
    }

    @Override
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (this.a.containsKey(method.getName())) {
            return this.a.get(method.getName());
        }
        Object obj2 = this.b;
        if (objArr == null) {
            objArr = new Object[0];
        }
        return method.invoke(obj2, objArr);
    }
}
