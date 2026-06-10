package X;

import com.windukk.hook.HookMethod;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;

class o1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        if (result == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(h5.a.c[0], Boolean.TRUE);
        Class<?>[] interfaces = result.getClass().getInterfaces();
        if (interfaces.length != 0) {
            result = Proxy.newProxyInstance(result.getClass().getClassLoader(), interfaces, new s1(linkedHashMap, result));
        }
        hookMethodParam.setResult(result);
    }
}
