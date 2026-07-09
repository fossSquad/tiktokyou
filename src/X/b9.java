package X;

import com.windukk.hook.HookMethod;

class b9 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr == null || objArr.length == 0) {
            return;
        }
        if (!Boolean.TRUE.equals(n9.b.get())) {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                String className = stackTraceElement.getClassName();
                if (!"X.0nTy".equals(className) && !"X.0nh5".equals(className)) {
                }
            }
            return;
        }
        if (n9.a(hookMethodParam.args[0])) {
            hookMethodParam.setResult(null);
            int i = g5.a;
        }
    }
}
