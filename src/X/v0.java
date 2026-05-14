package X;

import android.content.Context;
import com.ss.android.ugc.profile.business.ur.platform.business.BioUserWebSiteComponent;
import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;

class v0 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Context contextC;
        String str;
        Object objInvoke;
        BioUserWebSiteComponent bioUserWebSiteComponent = (BioUserWebSiteComponent) hookMethodParam.thisObject;
        ConcurrentHashMap concurrentHashMap = x0.a;
        try {
            Object objInvoke2 = e4.a(bioUserWebSiteComponent.getClass(), "getContext", new Class[0]).invoke(bioUserWebSiteComponent, null);
            contextC = objInvoke2 instanceof Context ? (Context) objInvoke2 : v3.c();
        } catch (Throwable th) {
        }
        try {
            Object obj = e4.a(bioUserWebSiteComponent.getClass(), "LLJJL").get(bioUserWebSiteComponent);
            if (obj != null) {
                Object objInvoke3 = e4.a(obj.getClass(), "getBioUrl", new Class[0]).invoke(obj, null);
                if (objInvoke3 instanceof String) {
                    str = (String) objInvoke3;
                    if (x0.a(str, false) == null) {
                        objInvoke = e4.a(obj.getClass(), "getBioSecureUrl", new Class[0]).invoke(obj, null);
                        if (objInvoke instanceof String) {
                            str = (String) objInvoke;
                        }
                    }
                } else {
                    objInvoke = e4.a(obj.getClass(), "getBioSecureUrl", new Class[0]).invoke(obj, null);
                    if (objInvoke instanceof String) {
                        str = (String) objInvoke;
                    }
                }
                if (x0.a(contextC, str, false)) {
                    hookMethodParam.setResult((Object) null);
                }
            }
            str = null;
        } catch (Throwable th2) {
            th2.getMessage();
            int i = v3.a;
            str = null;
        }
        if (x0.a(contextC, str, false)) {
            hookMethodParam.setResult((Object) null);
        }
    }
}
