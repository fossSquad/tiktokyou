package com.windukk.mod.hooks;
import Z.*;


import com.windukk.hook.HookMethod;
import java.util.function.Supplier;

public class StoryEngagementHooks extends HookMethod {
    final  Supplier a;

    public StoryEngagementHooks(Supplier supplier) {
        this.a = supplier;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ac.a().getClass();
        ac.e();
        hookMethodParam.setResult(this.a.get());
    }
}
