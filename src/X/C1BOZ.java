package X;

import android.content.Context;
import com.oplus.ocs.base.utils.ServiceCheck;

public final class C1BOZ {
    public static C1BOk LIZ(Context context) {
        synchronized (C1BOk.class) {
            C1BOk c1BOk = C1BOk.LIZJ;
            if (c1BOk != null) {
                c1BOk.addThis2Cache();
                return C1BOk.LIZJ;
            }
            C1BOk c1BOk2 = new C1BOk(context, ServiceCheck.check(context, "com.oplus.cosa") ? new C1BOo() : new C1BOm());
            C1BOk.LIZJ = c1BOk2;
            return c1BOk2;
        }
    }
}
