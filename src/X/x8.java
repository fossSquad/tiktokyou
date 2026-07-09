package X;

import com.windukk.hook.HookMethod;

abstract class x8 extends HookMethod {
    private x8() {
    }

    public abstract int a(y8 y8Var);

    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        y8 y8Var;
        Object obj = hookMethodParam.thisObject;
        if ((obj instanceof Enum) && (y8Var = (y8) z8.a.get(((Enum) obj).name())) != null) {
            hookMethodParam.setResult(Integer.valueOf(a(y8Var)));
        }
    }
}
