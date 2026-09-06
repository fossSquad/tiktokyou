package com.windukk.mod.hooks;
import com.windukk.hook.HookMethod;
import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SettingsHooks$before$2 extends HookMethod {
    final  ClassLoader a;

    public SettingsHooks$before$2(ClassLoader classLoader) {
        this.a = classLoader;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            SettingsHooks ogVar = SettingsHooks.a;
            if (SettingsHooks.a(ogVar, hookMethodParam.thisObject)) {
                try {
                    ClassLoader classLoader = this.a;
                    Object obj = SettingsHooks.c;
                    if (obj == null) {
                        synchronized (ogVar) {
                            obj = SettingsHooks.c;
                            if (obj == null) {
                                Object objA = SettingsHooks.a(classLoader);
                                SettingsHooks.c = objA;
                                obj = objA;
                            }
                        }
                    }
                    hookMethodParam.setResult(obj);
                    if (SettingsHooks.f) {
                        return;
                    }
                    SettingsHooks.f = true;
                } catch (Throwable th) {
                    SettingsHooks.a.getClass();
                    SettingsHooks.a(th);
                }
            }
        } catch (Throwable th2) {
            h6.a(6, h6.a(new StringBuilder().append("Unhandled hook exception on ").append(hookMethodParam.method.getName()).toString(), new Object[0]), th2);
        }
    }
}
