package X;

import com.windukk.hook.HookMethod;

class s2 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        l8 l8VarA;
        Object obj = hookMethodParam.args[1];
        if ((obj instanceof String) && "android_id".equals((String) obj) && (l8VarA = l8.a()) != null) {
            String str = hookMethodParam.getResult() instanceof String ? (String) hookMethodParam.getResult() : null;
            String strA = d3.a(l8VarA, str);
            if (strA == null || strA.equals(str)) {
                return;
            }
            hookMethodParam.setResult(strA);
        }
    }
}
