package com.ss.android.ugc.aweme.oppo.hyperboost;

import X.0Qcw;
import X.0Qne;
import X.C1BOY;
import X.C1BOZ;
import X.C1BOb;
import X.C1BOf;
import X.C1BOk;
import android.content.Context;
import android.os.Build;
import com.oplus.ocs.base.common.ConnectionResult;
import com.oplus.ocs.base.common.api.OnConnectionFailedListener;
import com.oplus.ocs.base.common.api.OnConnectionSucceedListener;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class HyperboostServiceImpl implements IHyperboostService {
    public static final Set<String> LJ = 0Qcw.LJ(new String[]{"com.ss.android.ugc.trill", "com.zhiliaoapp.musically"});
    public static final Set<String> LJFF = 0Qcw.LJ(new String[]{"oppo", "realme", "oneplus"});
    public final CopyOnWriteArrayList<0Qne> LIZ = new CopyOnWriteArrayList<>();
    public final AtomicInteger LIZIZ = new AtomicInteger(-1);
    public C1BOk LIZJ;
    public C1BOf LIZLLL;

    public final boolean LIZ(Context context) {
        if (this.LIZLLL != null) {
            return false;
        }
        this.LIZLLL = new C1BOY() {
            public final  109f LIZ = 109Y.LIZIZ;

            @Override
            public final void LIZ(String str) {
                this.LIZ.LIZ(str);
            }
        };
        C1BOk c1BOkLIZ = C1BOZ.LIZ(context);
        C1BOf c1BOf = this.LIZLLL;
        c1BOkLIZ.getClass();
        C1BOb c1BOb = C1BOk.LIZLLL;
        if (c1BOb != null) {
            return c1BOb.LIZLLL(c1BOf);
        }
        throw new RuntimeException("mHyperBoostUnitInterface has already destroyed, call it before destroy() ");
    }

    public final void LIZIZ(final Context context, 0Qne r5) {
        if (this.LIZIZ.get() >= 1) {
            r5.LIZ(this.LIZIZ.get() == 2);
            return;
        }
        this.LIZ.add(r5);
        if (this.LIZIZ.compareAndSet(-1, 0)) {
            try {
                if (!LJ.contains(context.getPackageName())) {
                    LIZLLL(false);
                    return;
                }
            } catch (Throwable unused) {
            }
            if (!LJFF.contains(Build.MANUFACTURER.toLowerCase(Locale.getDefault()))) {
                LIZLLL(false);
                return;
            }
            try {
                C1BOZ.LIZ(context).addOnConnectionSucceedListener(new OnConnectionSucceedListener() {
                    @Override
                    public final void onConnectionSucceed() {
                        C1BOZ.LIZ(context).getClass();
                        C1BOb c1BOb = C1BOk.LIZLLL;
                        if (c1BOb == null) {
                            throw new RuntimeException("mHyperBoostUnitInterface has already destroyed, call it before destroy() ");
                        }
                        c1BOb.registerClient();
                        this.LIZJ = C1BOZ.LIZ(context);
                        this.LIZLLL(true);
                    }
                });
                C1BOZ.LIZ(context).addOnConnectionFailedListener(new OnConnectionFailedListener() {
                    @Override
                    public final void onConnectionFailed(ConnectionResult connectionResult) {
                        this.LIZ.LIZLLL(false);
                    }
                });
            } catch (Throwable unused2) {
                LIZLLL(false);
            }
        }
    }

    public final boolean LIZJ(String str) {
        if (this.LIZJ == null) {
            return false;
        }
        C1BOb c1BOb = C1BOk.LIZLLL;
        if (c1BOb != null) {
            return c1BOb.LIZJ(str);
        }
        throw new RuntimeException("mHyperBoostUnitInterface has already destroyed, call it before destroy() ");
    }

    public final void LIZLLL(boolean z) {
        this.LIZIZ.set(z ? 2 : 1);
        Iterator<0Qne> it = this.LIZ.iterator();
        while (it.hasNext()) {
            it.next().LIZ(z);
        }
    }
}
