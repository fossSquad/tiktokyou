package com.windukk.mod.hooks;
import Z.*;


import com.windukk.hook.HookMethod;

public abstract class PublishTabHooks extends HookMethod {
    protected PublishTabHooks() {
    }

    public abstract int a(xc xcVar);

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        xc xcVar;
        Object obj = hookMethodParam.thisObject;
        if ((obj instanceof Enum) && (xcVar = (xc) yc.a.get(((Enum) obj).name())) != null) {
            hookMethodParam.setResult(Integer.valueOf(a(xcVar)));
        }
    }
}
