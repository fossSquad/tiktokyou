package Z;

import android.content.Context;
import com.ss.android.ugc.profile.business.ur.platform.business.BioUserWebSiteComponent;
import com.windukk.hook.HookMethod;
import com.windukk.mod.Main;
import Z.BrowserHooks;
import java.util.concurrent.ConcurrentHashMap;

class w1 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Context contextA = null;
        String str = null;
        Object objInvoke;
        BioUserWebSiteComponent bioUserWebSiteComponent = (BioUserWebSiteComponent) hookMethodParam.thisObject;
        ConcurrentHashMap concurrentHashMap = BrowserHooks.a;
        try {
            Object objInvoke2 = dd.a(bioUserWebSiteComponent.getClass(), "getContext", new Class[0]).invoke(bioUserWebSiteComponent, null);
            contextA = objInvoke2 instanceof Context ? (Context) objInvoke2 : Main.getApplicationContext();
        } catch (Throwable th) {
        }
        try {
            Object obj = s6.b.a(bioUserWebSiteComponent.getClass()).get(bioUserWebSiteComponent);
            if (obj != null) {
                Object objInvoke3 = dd.a(obj.getClass(), "getBioUrl", new Class[0]).invoke(obj, null);
                if (objInvoke3 instanceof String) {
                    str = (String) objInvoke3;
                    if (BrowserHooks.a(str, false) == null) {
                        objInvoke = dd.a(obj.getClass(), "getBioSecureUrl", new Class[0]).invoke(obj, null);
                        if (objInvoke instanceof String) {
                            str = (String) objInvoke;
                        }
                    }
                } else {
                    objInvoke = dd.a(obj.getClass(), "getBioSecureUrl", new Class[0]).invoke(obj, null);
                    if (objInvoke instanceof String) {
                        str = (String) objInvoke;
                    }
                }
                if (BrowserHooks.a(contextA, str, false)) {
                    hookMethodParam.setResult((Object) null);
                }
            }
            str = null;
        } catch (Throwable th2) {
            String strDecrypt = "Failed to resolve profile bio url";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th2);
            str = null;
        }
        if (BrowserHooks.a(contextA, str, false)) {
            hookMethodParam.setResult((Object) null);
        }
    }
}
