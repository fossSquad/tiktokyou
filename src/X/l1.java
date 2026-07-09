package X;

import android.content.Context;
import com.ss.android.ugc.profile.business.ur.platform.business.BioUserWebSiteComponent;
import com.windukk.hook.HookMethod;
import java.util.concurrent.ConcurrentHashMap;

class l1 extends HookMethod {

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Context contextC;
        String str;
        Object objInvoke;
        BioUserWebSiteComponent bioUserWebSiteComponent = (BioUserWebSiteComponent) hookMethodParam.thisObject;
        ConcurrentHashMap concurrentHashMap = n1.a;
        try {
            Object objInvoke2 = ha.a(bioUserWebSiteComponent.getClass(), "getContext", new Class[0]).invoke(bioUserWebSiteComponent, null);
            contextC = objInvoke2 instanceof Context ? (Context) objInvoke2 : g5.c();
        } catch (Throwable th) {
        }
        try {
            Object obj = k5.b.a(bioUserWebSiteComponent.getClass()).get(bioUserWebSiteComponent);
            if (obj != null) {
                Object objInvoke3 = ha.a(obj.getClass(), "getBioUrl", new Class[0]).invoke(obj, null);
                if (objInvoke3 instanceof String) {
                    str = (String) objInvoke3;
                    if (n1.a(str, false) == null) {
                        objInvoke = ha.a(obj.getClass(), "getBioSecureUrl", new Class[0]).invoke(obj, null);
                        if (objInvoke instanceof String) {
                            str = (String) objInvoke;
                        }
                    }
                } else {
                    objInvoke = ha.a(obj.getClass(), "getBioSecureUrl", new Class[0]).invoke(obj, null);
                    if (objInvoke instanceof String) {
                        str = (String) objInvoke;
                    }
                }
                if (n1.a(contextC, str, false)) {
                    hookMethodParam.setResult(null);
                }
            }
            str = null;
        } catch (Throwable th2) {
            th2.getMessage();
            int i = g5.a;
            str = null;
        }
        if (n1.a(contextC, str, false)) {
            hookMethodParam.setResult(null);
        }
    }
}
