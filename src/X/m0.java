package X;

import com.windukk.mod.hooks.CleanModeHooks;
import de.robv.android.xposed.XC_MethodHook;

class m0 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Object obj;
        Object[] objArr = methodHookParam.args;
        if (objArr.length == 0 || (obj = objArr[0]) == null) {
            return;
        }
        CleanModeHooks.handleClearModeEvent(obj);
    }
}
