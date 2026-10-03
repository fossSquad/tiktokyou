package Z;
import com.windukk.hook.HookMethod;
import Z.BadgeHooks;

class pa extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        BadgeHooks.i();
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (BadgeHooks.z.getAndIncrement() == 0) {
        }
    }
}
