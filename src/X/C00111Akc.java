package X;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.i18n.location.api.LocationData;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AwS136S1100000_29;

public final class C00111Akc extends 0xI3 {
    public static final String LIZLLL = C00111Akc.class.getSimpleName();
    public final boolean LIZIZ;
    public final LocationManager LIZJ;

    public C00111Akc(Context context, Function0 function0) {
        super(function0);
        this.LIZIZ = false;
        this.LIZJ = (LocationManager) 0Vx6.LLZIL(0Vx6.Q(context), "location");
    }

    public final void LIZ(Cert cert, Handler handler, 07Un<LocationData> r9) {
        int iIntValue = ((Number) ((0xI3) this).LIZ.invoke()).intValue();
        0bn7 r0 = 0bn7.LIZ;
        String str = LIZLLL;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("getCurrentLocation: gmsAvailable=");
        sbLIZ.append(this.LIZIZ);
        sbLIZ.append(", permissionLevel=");
        sbLIZ.append(iIntValue);
        0bn7.LIZLLL(str, 0wS0.LIZIZ(sbLIZ));
        if (Build.VERSION.SDK_INT >= 31 && this.LIZIZ && LIZJ("fused")) {
            0bn7.LIZLLL(str, "getCurrentLocation through fused provider");
            0xHB.LIZIZ(this.LIZJ, "fused", new C1Ajo(this, r9, handler, iIntValue), handler.getLooper(), cert);
            return;
        }
        if (iIntValue != 2) {
            if (iIntValue == 1) {
                0bn7.LIZLLL(str, "getCurrentLocation through network provider");
                if (!LIZJ("network")) {
                    r9.accept(LocationData.LJIJ.getValue());
                    return;
                } else {
                    0xHB.LIZIZ(this.LIZJ, "network", new C1Ajo(this, r9, handler, iIntValue), handler.getLooper(), cert);
                    return;
                }
            }
            return;
        }
        0bn7.LIZLLL(str, "getCurrentLocation through network/gps provider");
        boolean zLIZJ = LIZJ("gps");
        boolean zLIZJ2 = LIZJ("network");
        if (!zLIZJ && !zLIZJ2) {
            r9.accept(LocationData.LJIJ.getValue());
            return;
        }
        C1Ajo c1Ajo = new C1Ajo(this, r9, handler, iIntValue);
        if (zLIZJ2) {
            0xHB.LIZIZ(this.LIZJ, "network", c1Ajo, handler.getLooper(), cert);
        }
        if (zLIZJ) {
            0xHB.LIZIZ(this.LIZJ, "gps", c1Ajo, handler.getLooper(), cert);
        }
    }

    public final LocationData LIZIZ(Cert cert) {
        String str;
        int iIntValue = ((Number) ((0xI3) this).LIZ.invoke()).intValue();
        0bn7 r0 = 0bn7.LIZ;
        String str2 = LIZLLL;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("getLastLocation permissionLevel=");
        sbLIZ.append(iIntValue);
        0bn7.LIZLLL(str2, 0wS0.LIZIZ(sbLIZ));
        if (Build.VERSION.SDK_INT >= 31 && this.LIZIZ) {
            str = "fused";
            if (!LIZJ("fused")) {
                if (iIntValue == 2) {
                    str = "gps";
                    if (!LIZJ("gps")) {
                        str = null;
                    }
                } else if (iIntValue == 1) {
                    str = "network";
                    if (!LIZJ("network")) {
                        str = null;
                    }
                } else {
                    str = null;
                }
            }
        } else if (iIntValue == 2) {
            str = "gps";
            if (!LIZJ("gps")) {
                str = null;
            }
        } else if (iIntValue == 1) {
            str = "network";
            if (!LIZJ("network")) {
                str = null;
            }
        } else {
            str = null;
        }
        StringBuilder sbLIZ2 = 0wS0.LIZ();
        sbLIZ2.append("getLastLocation: through ");
        sbLIZ2.append(str);
        0bn7.LIZLLL(str2, 0wS0.LIZIZ(sbLIZ2));
        if (str == null) {
            return (LocationData) LocationData.LJIJ.getValue();
        }
        LocationManager locationManager = this.LIZJ;
        0Uxb r3 = 0xHB.LIZ(100000, cert, "location_getLastKnownLocation");
        0UxP.LIZ(r3, "android/location/LocationManager", "getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;", 0osn.LIZJ(new Pair("provider", str)));
        return 0xI2.LIZ((Location) 0UxG.LIZ(r3, new AwS136S1100000_29(locationManager, str, 9)), iIntValue);
    }

    public final boolean LIZJ(String str) {
        return this.LIZJ.isProviderEnabled(str);
    }
}
