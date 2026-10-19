package Z;
import com.windukk.hook.HookMethod;
import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$2", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class mi$before$2 extends HookMethod {
    final  ClassLoader a;

    public mi$before$2(ClassLoader classLoader) {
        this.a = classLoader;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            mi miVar = mi.a;
            if (mi.a(miVar, hookMethodParam.thisObject)) {
                try {
                    ClassLoader classLoader = this.a;
                    Object obj = mi.c;
                    if (obj == null) {
                        synchronized (miVar) {
                            obj = mi.c;
                            if (obj == null) {
                                Object objA = mi.a(classLoader);
                                mi.c = objA;
                                obj = objA;
                            }
                        }
                    }
                    hookMethodParam.setResult(obj);
                    if (mi.f) {
                        return;
                    }
                    mi.f = true;
                } catch (Throwable th) {
                    mi.a.getClass();
                    mi.a(th);
                }
            }
        } catch (Throwable th2) {
            g7.a(6, g7.a(di.a("v6tsfHMsIhGYrzYCCyb7vE32IbW2SNZMjbQ1Lp5j5WqOOqlK+2VFAP3d23V+E7Of", "2MxCKPQGJuA2ppnG", "aes", new StringBuilder(), hookMethodParam.method.getName()), new Object[0]), th2);
        }
    }
}
