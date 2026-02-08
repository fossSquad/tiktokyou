package com.oplus.ocs.base.common.api;

import android.content.Context;
import com.oplus.ocs.base.IAuthenticationListener;
import com.oplus.ocs.base.utils.ServiceCheck;

public class b {
    public static volatile b a;

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public static e a(Context context, InternalClient internalClient, IAuthenticationListener iAuthenticationListener) {
        if (ServiceCheck.check(context, "com.oplus.ocs")) {
            return new h(context, internalClient, iAuthenticationListener);
        }
        if (ServiceCheck.check(context, "com.coloros.ocs.opencapabilityservice")) {
            return new f(context, internalClient, iAuthenticationListener);
        }
        return null;
    }

    public static e a(Context context, String str, c cVar, k kVar) {
        if (ServiceCheck.check(context, "com.oplus.ocs")) {
            return new g(context, str, cVar, kVar);
        }
        if (ServiceCheck.check(context, "com.coloros.ocs.opencapabilityservice")) {
            return new a(context, str, cVar, kVar);
        }
        return null;
    }
}
