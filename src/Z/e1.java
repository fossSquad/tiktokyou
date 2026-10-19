package Z;
import com.windukk.hook.HookMethod;

class e1 extends HookMethod {
    final  i2 a;

    public e1(i2 i2Var) {
        this.a = i2Var;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (hookMethodParam.getResult() instanceof String) {
            try {
                hookMethodParam.setResult(v1.a(this.a.a(hookMethodParam.thisObject), (String) hookMethodParam.getResult()));
            } catch (Exception e) {
                String strDecrypt = "Failed to resolve uid for ChatListNameModel#getName";
                Object obj = g7.a;
                g7.a(6, String.valueOf(strDecrypt), e);
            }
        }
    }
}
