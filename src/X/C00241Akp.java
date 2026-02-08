package X;

import android.content.Context;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.i18n.location.api.LocationData;
import com.bytedance.i18n.location.core.LocationClientImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public final class C00241Akp implements C1Ajj {
    public final 054i LIZ;
    public final C1AjX LIZIZ;
    public final Function0<0xI3> LIZJ;
    public final Function0<Boolean> LIZLLL;
    public final String LJ = C00241Akp.class.getSimpleName();

    public C00241Akp(054i r2, C1AjX c1AjX, Function0<? extends 0xI3> function0, Function0<Boolean> function1) {
        this.LIZ = r2;
        this.LIZIZ = c1AjX;
        this.LIZJ = function0;
        this.LIZLLL = function1;
    }

    @Override
    public final C1AjZ LIZ(final C1Ajl c1Ajl) {
        int iLJII;
        LocationData locationData;
        054k r0;
        LocationClientImpl locationClientImpl = this.LIZIZ.LIZLLL;
        Cert cert = null;
        if (locationClientImpl.LIZIZ.get()) {
            Context context = locationClientImpl.LJII;
            if (context == null) {
                context = null;
            }
            iLJII = locationClientImpl.LJII(context);
        } else {
            iLJII = 0;
        }
        C1AkP c1AkP = this.LIZIZ.LIZJ;
        ?? r1 = new Function1() {
            public final Object invoke(Object obj) {
                C00241Akp c00241Akp = this.LL;
                C1Ajl c1Ajl2 = c1Ajl;
                LocationData locationData2 = (LocationData) obj;
                0bn7 r2 = 0bn7.LIZ;
                String str = c00241Akp.LJ;
                StringBuilder sbLIZ = 0wS0.LIZ();
                sbLIZ.append("process: getCache=");
                sbLIZ.append(locationData2);
                0bn7.LIZIZ(str, 0wS0.LIZIZ(sbLIZ));
                return c00241Akp.LIZLLL(locationData2, c1Ajl2.LIZIZ);
            }
        };
        if (iLJII == 1) {
            locationData = (LocationData) r1.invoke(c1AkP.LJ);
        } else if (iLJII != 2) {
            c1AkP.getClass();
            locationData = (LocationData) r1.invoke(null);
        } else {
            locationData = (LocationData) r1.invoke(c1AkP.LIZLLL);
        }
        0bn7 r2 = 0bn7.LIZ;
        String str = this.LJ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("process: takeCache=");
        sbLIZ.append(locationData);
        0bn7.LIZIZ(str, 0wS0.LIZIZ(sbLIZ));
        if (locationData != null) {
            c1Ajl.LIZ = locationData;
        } else {
            0xI3 r3 = (0xI3) this.LIZJ.invoke();
            054j r4 = c1Ajl.LIZIZ;
            if (r4 != null && (r0 = r4.LIZ) != null) {
                cert = r0.LIZIZ;
            }
            LocationData locationDataLIZIZ = r3.LIZIZ(cert);
            String str2 = this.LJ;
            StringBuilder sbLIZ2 = 0wS0.LIZ();
            sbLIZ2.append("process: getLastLocation: ");
            sbLIZ2.append(locationDataLIZIZ);
            0bn7.LIZIZ(str2, 0wS0.LIZIZ(sbLIZ2));
            LocationData locationDataLIZLLL = LIZLLL(locationDataLIZIZ, c1Ajl.LIZIZ);
            if (locationDataLIZLLL != null) {
                c1Ajl.LIZ = locationDataLIZLLL;
            }
        }
        return C1AjY.LIZ(c1Ajl);
    }

    @Override
    public final boolean LIZIZ(C1Ajl c1Ajl) {
        return !((Boolean) this.LIZLLL.invoke()).booleanValue();
    }

    @Override
    public final int LIZJ() {
        return 0;
    }

    public final LocationData LIZLLL(LocationData locationData, 054j r9) {
        long j;
        0bn7 r0 = 0bn7.LIZ;
        String str = this.LJ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("checkCacheByTime: ");
        sbLIZ.append(locationData);
        0bn7.LIZIZ(str, 0wS0.LIZIZ(sbLIZ));
        if (locationData == null) {
            return null;
        }
        if (this.LIZ.LIZ) {
            j = this.LIZIZ.LIZJ.LJI;
        } else {
            j = r9 != null ? r9.LIZJ : 0L;
        }
        if (!locationData.LIZIZ()) {
            return null;
        }
        boolean z = System.currentTimeMillis() - locationData.timestamp <= j;
        String str2 = this.LJ;
        StringBuilder sbLIZ2 = 0wS0.LIZ();
        sbLIZ2.append("checkCacheByTime: is still valid=");
        sbLIZ2.append(z);
        0bn7.LIZLLL(str2, 0wS0.LIZIZ(sbLIZ2));
        String str3 = this.LJ;
        StringBuilder sbLIZ3 = 0wS0.LIZ();
        sbLIZ3.append(System.currentTimeMillis());
        sbLIZ3.append('-');
        sbLIZ3.append(locationData.timestamp);
        sbLIZ3.append(' ');
        sbLIZ3.append(z ? "<=" : ">");
        sbLIZ3.append(' ');
        sbLIZ3.append(j);
        0bn7.LIZLLL(str3, 0wS0.LIZIZ(sbLIZ3));
        if (z) {
            return locationData;
        }
        return null;
    }

    @Override
    public final String name() {
        return "time_cache";
    }
}
