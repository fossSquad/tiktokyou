package X;

import com.windukk.hook.HookMethod;

class mc extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Integer num;
        int iA;
        if (!l8.a().d() || (num = (Integer) hookMethodParam.getResult()) == null || (iA = hd.a(num.intValue())) == num.intValue()) {
            return;
        }
        hookMethodParam.setResult(Integer.valueOf(iA));
    }
}
