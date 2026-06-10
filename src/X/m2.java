package X;

import com.windukk.hook.HookMethod;

class m2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        d7 d7VarA;
        String strB;
        String str = hookMethodParam.getResult() instanceof String ? (String) hookMethodParam.getResult() : null;
        if (!v2.b(str) || (d7VarA = d7.a()) == null || (strB = v2.b(d7VarA, str)) == null || strB.equals(str)) {
            return;
        }
        hookMethodParam.setResult(strB);
    }
}
