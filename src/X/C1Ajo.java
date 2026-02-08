package X;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.i18n.location.api.LocationData;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public final class C1Ajo implements LocationListener {
    public final 07Un<LocationData> LIZ;
    public final Handler LIZIZ;
    public final int LIZJ;
    public final AtomicBoolean LIZLLL = new AtomicBoolean(false);
    public final Function0<Unit> LJ;
    public final  C00111Akc LJFF;

    public C1Ajo(C00111Akc c00111Akc, 07Un r5, Handler handler, int i) {
        this.LJFF = c00111Akc;
        this.LIZ = r5;
        this.LIZIZ = handler;
        this.LIZJ = i;
        final Function0<Unit> function0 = new Function0() {
            public final Object invoke() {
                C1Ajo c1Ajo = this.LL;
                if (!c1Ajo.LIZLLL.getAndSet(true)) {
                    0bn7 r0 = 0bn7.LIZ;
                    0bn7.LIZLLL(C00111Akc.LIZLLL, "getLocation timeout");
                    c1Ajo.LIZ.accept(LocationData.LJIIIIZZ.getValue());
                }
                return Unit.LIZ;
            }
        };
        this.LJ = function0;
        0Vx6.LJJLIIIJJIZ(handler, new Runnable() {
            @Override
            public final void run() {
                Function0 function1 = function0;
                0zxW.LIZ("SystemLocationProvider$TimeoutLocationListener@7896.<init>$1L");
                function1.invoke();
                0zxW.LIZIZ("SystemLocationProvider$TimeoutLocationListener@7896.<init>$1L");
            }
        }, 30000L);
    }

    @Override
    public final void onFlushComplete(int i) {
    }

    @Override
    public final void onLocationChanged(Location location) {
        if (!this.LIZLLL.getAndSet(true)) {
            0bn7 r0 = 0bn7.LIZ;
            0bn7.LIZLLL(C00111Akc.LIZLLL, "onLocationChanged");
            this.LIZ.accept(0xI2.LIZ(location, this.LIZJ));
            Handler handler = this.LIZIZ;
            final Function0<Unit> function0 = this.LJ;
            handler.removeCallbacks(new Runnable() {
                @Override
                public final void run() {
                    Function0 function1 = function0;
                    0zxW.LIZ("SystemLocationProvider$TimeoutLocationListener@7896.onLocationChanged$1L");
                    function1.invoke();
                    0zxW.LIZIZ("SystemLocationProvider$TimeoutLocationListener@7896.onLocationChanged$1L");
                }
            });
        }
        this.LJFF.LIZJ.removeUpdates(this);
    }

    @Override
    public final void onProviderDisabled(String str) {
    }

    @Override
    public final void onProviderEnabled(String str) {
    }

    @Override
    @089T
    public final void onStatusChanged(String str, int i, Bundle bundle) {
        0bn7 r0 = 0bn7.LIZ;
        String str2 = C00111Akc.LIZLLL;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("onStatusChanged: ");
        sbLIZ.append(str);
        sbLIZ.append(' ');
        sbLIZ.append(i);
        0bn7.LIZLLL(str2, 0wS0.LIZIZ(sbLIZ));
    }
}
