package Z;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BadgeHooks;

class za extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        if (result instanceof String) {
            String str = (String) result;
            CharSequence charSequenceB = BadgeHooks.b((CharSequence) str);
            String string = charSequenceB != null ? charSequenceB.toString() : null;
            if (string == null || string.equals(str)) {
                return;
            }
            hookMethodParam.setResult(string);
            hookMethodParam.method.getName();
        }
    }
}
