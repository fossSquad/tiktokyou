package com.windukk.mod.hooks;
import Z.*;


import com.windukk.hook.HookMethod;
import com.windukk.hook.ReplaceMethod;

public class FeedHooks extends ReplaceMethod {
    public Object replaceHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        return 2;
    }
}
