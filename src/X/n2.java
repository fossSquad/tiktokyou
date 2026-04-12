package X;

import android.content.res.Configuration;
import de.robv.android.xposed.XC_MethodHook;

class n2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Configuration configuration = (Configuration) methodHookParam.getResult();
        if (configuration == null) {
            return;
        }
        configuration.setLocale(o2.a);
        methodHookParam.setResult(configuration);
    }
}
