package Z;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BadgeHooks;

class pa extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        BadgeHooks.i();
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (BadgeHooks.z.getAndIncrement() == 0) {
        }
    }
}
