package Z;
import com.windukk.hook.HookMethod;

class nc extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object result = hookMethodParam.getResult();
        if (result instanceof String) {
            String str = (String) result;
            CharSequence charSequenceB = v1.b((CharSequence) str);
            String string = charSequenceB != null ? charSequenceB.toString() : null;
            if (string == null || string.equals(str)) {
                return;
            }
            hookMethodParam.setResult(string);
            hookMethodParam.method.getName();
        }
    }
}
