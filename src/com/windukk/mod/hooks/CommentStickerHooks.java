package com.windukk.mod.hooks;
import Z.*;


import com.windukk.hook.HookMethod;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;

public class CommentStickerHooks extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        if (result == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(l8.a.c[0], -1);
        Class<?>[] interfaces = result.getClass().getInterfaces();
        if (interfaces.length != 0) {
            result = Proxy.newProxyInstance(result.getClass().getClassLoader(), interfaces, new r2(linkedHashMap, result));
        }
        hookMethodParam.setResult(result);
    }
}
