package X;

import com.windukk.hook.HookMethod;

class h7 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                String str = (String) obj;
                CharSequence charSequenceB = a1.b((CharSequence) str);
                String string = charSequenceB != null ? charSequenceB.toString() : null;
                if (string == null || string.equals(str)) {
                    return;
                }
                hookMethodParam.args[0] = string;
                hookMethodParam.method.getName();
                int i = p4.a;
            }
        }
    }
}
