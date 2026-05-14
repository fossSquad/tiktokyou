package X;

import com.windukk.hook.HookMethod;

class w1 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        y3 y3VarA;
        Object obj = hookMethodParam.args[1];
        if ((obj instanceof String) && "android_id".equals((String) obj) && (y3VarA = y3.a()) != null) {
            String str = hookMethodParam.getResult() instanceof String ? (String) hookMethodParam.getResult() : null;
            String strA = h2.a(y3VarA, str);
            if (strA == null || strA.equals(str)) {
                return;
            }
            hookMethodParam.setResult(strA);
        }
    }
}
