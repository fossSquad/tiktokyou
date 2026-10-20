package com.windukk.mod.hooks;
import Z.*;


import android.content.res.ColorStateList;
import com.windukk.hook.HookMethod;

public class SimpleModeHooks extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ColorStateList colorStateList;
        ColorStateList colorStateListA;
        if (ac.a().g()) {
            Object[] objArr = hookMethodParam.args;
            if (objArr.length >= 2) {
                Object obj = objArr[1];
                if (!(obj instanceof ColorStateList) || (colorStateListA = zh.a((colorStateList = (ColorStateList) obj))) == colorStateList) {
                    return;
                }
                hookMethodParam.args[1] = colorStateListA;
            }
        }
    }
}
