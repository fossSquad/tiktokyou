package X;

import com.windukk.hook.HookMethod;

class v2 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if ("android_id".equals(hookMethodParam.args[1])) {
            hookMethodParam.setResult(d3.b);
        }
    }
}
