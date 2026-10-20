package Z;
import com.windukk.hook.HookMethod;

class xb extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        v1.k();
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (v1.A.getAndIncrement() == 0) {
        }
    }
}
