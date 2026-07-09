package X;

import com.windukk.hook.HookMethod;

class u2 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        l8 l8VarA;
        String strB;
        String str = hookMethodParam.getResult() instanceof String ? (String) hookMethodParam.getResult() : null;
        if (!d3.b(str) || (l8VarA = l8.a()) == null || (strB = d3.b(l8VarA, str)) == null || strB.equals(str)) {
            return;
        }
        hookMethodParam.setResult(strB);
    }
}
