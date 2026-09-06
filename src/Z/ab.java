package Z;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BadgeHooks;

class ab extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                String str = (String) obj;
                CharSequence charSequenceB = BadgeHooks.b((CharSequence) str);
                String string = charSequenceB != null ? charSequenceB.toString() : null;
                if (string == null || string.equals(str)) {
                    return;
                }
                hookMethodParam.args[0] = string;
                hookMethodParam.method.getName();
            }
        }
    }
}
