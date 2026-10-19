package Z;
import com.windukk.hook.HookMethod;

class c5 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if ("panel_download_bar".equals(hookMethodParam.args[0])) {
            hookMethodParam.setResult(Boolean.TRUE);
        }
    }
}
