package X;

import android.content.res.Configuration;
import de.robv.android.xposed.XC_MethodHook;

class o1 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Configuration configuration = (Configuration) methodHookParam.getResult();
        configuration.setLocale(p1.a);
        methodHookParam.setResult(configuration);
    }
}
