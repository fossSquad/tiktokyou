package X;

import android.content.Context;
import com.ss.android.ugc.profile.business.ur.platform.business.BioUserWebSiteComponent;
import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;

class i1 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Context contextC;
        String str;
        Object objInvoke;
        BioUserWebSiteComponent bioUserWebSiteComponent = (BioUserWebSiteComponent) hookMethodParam.thisObject;
        ConcurrentHashMap concurrentHashMap = k1.a;
        try {
            Object objInvoke2 = g8.a(bioUserWebSiteComponent.getClass(), "getContext", new Class[0]).invoke(bioUserWebSiteComponent, null);
            contextC = objInvoke2 instanceof Context ? (Context) objInvoke2 : p4.c();
        } catch (Throwable th) {
        }
        try {
            Object obj = t4.b.a(bioUserWebSiteComponent.getClass()).get(bioUserWebSiteComponent);
            if (obj != null) {
                Object objInvoke3 = g8.a(obj.getClass(), "getBioUrl", new Class[0]).invoke(obj, null);
                if (objInvoke3 instanceof String) {
                    str = (String) objInvoke3;
                    if (k1.a(str, false) == null) {
                        objInvoke = g8.a(obj.getClass(), "getBioSecureUrl", new Class[0]).invoke(obj, null);
                        if (objInvoke instanceof String) {
                            str = (String) objInvoke;
                        }
                    }
                } else {
                    objInvoke = g8.a(obj.getClass(), "getBioSecureUrl", new Class[0]).invoke(obj, null);
                    if (objInvoke instanceof String) {
                        str = (String) objInvoke;
                    }
                }
                if (k1.a(contextC, str, false)) {
                    hookMethodParam.setResult((Object) null);
                }
            }
            str = null;
        } catch (Throwable th2) {
            th2.getMessage();
            int i = p4.a;
            str = null;
        }
        if (k1.a(contextC, str, false)) {
            hookMethodParam.setResult((Object) null);
        }
    }
}
