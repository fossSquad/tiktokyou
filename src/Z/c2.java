package Z;

import com.windukk.hook.HookMethod;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;

class c2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        if (result == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(k7.a.c[0], Boolean.TRUE);
        Class<?>[] interfaces = result.getClass().getInterfaces();
        if (interfaces.length != 0) {
            result = Proxy.newProxyInstance(result.getClass().getClassLoader(), interfaces, new g2(linkedHashMap, result));
        }
        hookMethodParam.setResult(result);
    }
}
