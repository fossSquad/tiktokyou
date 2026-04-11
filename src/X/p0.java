package X;

import de.robv.android.xposed.XC_MethodHook;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;

class p0 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Object result = methodHookParam.getResult();
        if (result == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("LJFF", -1);
        Class<?>[] interfaces = result.getClass().getInterfaces();
        if (interfaces.length != 0) {
            result = Proxy.newProxyInstance(result.getClass().getClassLoader(), interfaces, new s0(linkedHashMap, result));
        }
        methodHookParam.setResult(result);
    }
}
