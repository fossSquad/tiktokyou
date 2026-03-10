package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.function.Consumer;

class b2 extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        if (i1.a().a) {
            Consumer consumer = (Consumer) methodHookParam.args[3];
            if (consumer != null) {
                consumer.accept(null);
            }
            methodHookParam.setResult((Object) null);
        }
    }
}
