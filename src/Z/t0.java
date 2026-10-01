package Z;
import com.windukk.hook.HookMethod;
import Z.BadgeHooks;

class t0 extends HookMethod {
    final  z1 a;

    public t0(z1 z1Var) {
        this.a = z1Var;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (hookMethodParam.getResult() instanceof String) {
            try {
                hookMethodParam.setResult(BadgeHooks.a(this.a.b(hookMethodParam.thisObject), (String) hookMethodParam.getResult()));
            } catch (Exception e) {
                String strDecrypt = "Failed to resolve uid for ChatListNameModel#getName";
                Object obj = h6.a;
                h6.a(6, String.valueOf(strDecrypt), e);
            }
        }
    }
}
