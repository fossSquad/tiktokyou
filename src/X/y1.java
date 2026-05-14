package X;

import com.windukk.hook.HookMethod;

class y1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        y3 y3VarA;
        String strB;
        String str = hookMethodParam.getResult() instanceof String ? (String) hookMethodParam.getResult() : null;
        if (!h2.b(str) || (y3VarA = y3.a()) == null || (strB = h2.b(y3VarA, str)) == null || strB.equals(str)) {
            return;
        }
        hookMethodParam.setResult(strB);
    }
}
