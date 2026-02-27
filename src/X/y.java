package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.List;

class y extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        List list = (List) methodHookParam.args[0];
        if (list == null || list.isEmpty()) {
            return;
        }
        list.removeIf(new a0$$ExternalSyntheticLambda0());
    }
}
