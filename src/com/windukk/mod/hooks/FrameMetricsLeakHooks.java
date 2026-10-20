package com.windukk.mod.hooks;
import Z.*;


import com.windukk.hook.HookMethod;

public class FrameMetricsLeakHooks extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int iIntValue;
        int iA;
        if (ac.a().g()) {
            Object[] objArr = hookMethodParam.args;
            if (objArr.length > 0) {
                Object obj = objArr[0];
                if (!(obj instanceof Integer) || (iA = zh.a((iIntValue = ((Integer) obj).intValue()))) == iIntValue) {
                    return;
                }
                hookMethodParam.args[0] = Integer.valueOf(iA);
            }
        }
    }
}
