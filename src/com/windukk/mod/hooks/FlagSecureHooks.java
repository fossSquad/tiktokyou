package com.windukk.mod.hooks;
import Z.*;


import com.windukk.hook.HookMethod;

public class FlagSecureHooks extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y5.a().d) {
            hookMethodParam.setResult(0);
        }
    }
}
