package X;

import android.content.Context;
import com.bytedance.i18n.location.core.LocationClientImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public final class C1Aji {
    public static final  int LJ = 0;
    public final C1AjX LIZ;
    public final C1AkP LIZIZ;
    public int LIZJ;
    public int LIZLLL;

    public C1Aji(C1AjX c1AjX) {
        this.LIZ = c1AjX;
        C1AkP c1AkP = c1AjX.LIZJ;
        this.LIZIZ = c1AkP;
        this.LIZJ = c1AkP.LIZIZ().getInt("perm_level", 0);
        this.LIZLLL = c1AkP.LIZIZ().getInt("service_status", 0);
    }

    public final boolean LIZ(Function0<Unit> function0) {
        int iLJII;
        Context context = this.LIZ.LIZLLL.LJII;
        if (context == null) {
            context = null;
        }
        boolean zLIZJ = 0boR.LIZJ(context);
        if (this.LIZLLL != zLIZJ) {
            this.LIZLLL = zLIZJ ? 1 : 0;
            this.LIZIZ.LIZIZ().edit().putInt("service_status", zLIZJ ? 1 : 0).apply();
            if (function0 != null) {
                function0.invoke();
            }
        }
        if (zLIZJ) {
            LocationClientImpl locationClientImpl = this.LIZ.LIZLLL;
            if (locationClientImpl.LIZIZ.get()) {
                Context context2 = locationClientImpl.LJII;
                iLJII = locationClientImpl.LJII(context2 != null ? context2 : null);
            } else {
                iLJII = 0;
            }
            0bn7 r0 = 0bn7.LIZ;
            StringBuilder sbLIZ = 0wS0.LIZ();
            sbLIZ.append("checkPermissionAndSave: last=");
            sbLIZ.append(this.LIZJ);
            sbLIZ.append(" current=");
            sbLIZ.append(iLJII);
            0bn7.LIZLLL("PermissionChecker", 0wS0.LIZIZ(sbLIZ));
            if (this.LIZJ != iLJII) {
                this.LIZIZ.LIZ();
                this.LIZJ = iLJII;
                this.LIZIZ.LIZIZ().edit().putInt("perm_level", iLJII).apply();
                if (function0 != null) {
                    function0.invoke();
                }
            }
            if (iLJII != 0) {
                return true;
            }
        } else {
            this.LIZIZ.LIZ();
        }
        return false;
    }
}
