package Z;

import android.content.Context;
import com.ss.android.ugc.profile.business.ur.platform.business.BioUserWebSiteComponent;
import com.windukk.hook.HookMethod;
import com.windukk.mod.Main;
import java.util.concurrent.ConcurrentHashMap;

class f2 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Context contextA = null;
        String str = null;
        Object objInvoke;
        BioUserWebSiteComponent bioUserWebSiteComponent = (BioUserWebSiteComponent) hookMethodParam.thisObject;
        ConcurrentHashMap concurrentHashMap = h2.a;
        try {
            Object objInvoke2 = se.a(bioUserWebSiteComponent.getClass(), "getContext", new Class[0]).invoke(bioUserWebSiteComponent, null);
            contextA = objInvoke2 instanceof Context ? (Context) objInvoke2 : Main.getApplicationContext();
        } catch (Throwable th) {
        }
        try {
            Object obj = t7.b.a(bioUserWebSiteComponent.getClass()).get(bioUserWebSiteComponent);
            if (obj != null) {
                Object objInvoke3 = se.a(obj.getClass(), "getBioUrl", new Class[0]).invoke(obj, null);
                if (objInvoke3 instanceof String) {
                    str = (String) objInvoke3;
                    if (h2.a(str, false) == null) {
                        objInvoke = se.a(obj.getClass(), "getBioSecureUrl", new Class[0]).invoke(obj, null);
                        if (objInvoke instanceof String) {
                            str = (String) objInvoke;
                        }
                    }
                } else {
                    objInvoke = se.a(obj.getClass(), "getBioSecureUrl", new Class[0]).invoke(obj, null);
                    if (objInvoke instanceof String) {
                        str = (String) objInvoke;
                    }
                }
                if (h2.a(contextA, str, false)) {
                    hookMethodParam.setResult((Object) null);
                }
            }
            str = null;
        } catch (Throwable th2) {
            String strDecrypt = "Failed to resolve profile bio url";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th2);
            str = null;
        }
        if (h2.a(contextA, str, false)) {
            hookMethodParam.setResult((Object) null);
        }
    }
}
