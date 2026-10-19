package Z;

import com.windukk.hook.HookMethod;

class eh extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Integer num;
        int iA;
        if (!ac.a().g() || (num = (Integer) hookMethodParam.getResult()) == null || (iA = zh.a(num.intValue())) == num.intValue()) {
            return;
        }
        hookMethodParam.setResult(Integer.valueOf(iA));
    }
}
