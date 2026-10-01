package Z;

import Z.h6;
import com.windukk.hook.HookMethod;
import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$after$2", "Lcom/windukk/hook/HookMethod;", "afterHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SettingsHooks$after$1 extends HookMethod {
    final  Class a;
    final  Class b;

    public SettingsHooks$after$1(Class cls, Class cls2) {
        this.a = cls;
        this.b = cls2;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object[] objArr = hookMethodParam.args;
            if (objArr.length < 2 || !this.a.isInstance(objArr[1])) {
                return;
            }
            try {
                SettingsHooks.a(SettingsHooks.a, hookMethodParam, this.b);
            } catch (Throwable th) {
                SettingsHooks.a.getClass();
                SettingsHooks.a(th);
            }
        } catch (Throwable th2) {
            h6.a(6, h6.a(new StringBuilder().append("Unhandled hook exception on ").append(hookMethodParam.method.getName()).toString(), new Object[0]), th2);
        }
    }
}
