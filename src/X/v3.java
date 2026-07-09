package X;

import com.windukk.hook.HookMethod;

class v3 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if ("panel_download_bar".equals(hookMethodParam.args[0])) {
            hookMethodParam.setResult(Boolean.TRUE);
        }
    }
}
