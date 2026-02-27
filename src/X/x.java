package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.List;

class x extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        List list = (List) methodHookParam.getResult();
        if (list == null || list.isEmpty()) {
            return;
        }
        list.removeIf(new a0$$ExternalSyntheticLambda0());
    }
}
