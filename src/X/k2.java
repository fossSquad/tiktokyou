package X;

import com.windukk.hook.HookMethod;

class k2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        d7 d7VarA;
        Object obj = hookMethodParam.args[1];
        if ((obj instanceof String) && "android_id".equals((String) obj) && (d7VarA = d7.a()) != null) {
            String str = hookMethodParam.getResult() instanceof String ? (String) hookMethodParam.getResult() : null;
            String strA = v2.a(d7VarA, str);
            if (strA == null || strA.equals(str)) {
                return;
            }
            hookMethodParam.setResult(strA);
        }
    }
}
