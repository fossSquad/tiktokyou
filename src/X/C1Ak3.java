package X;

import com.bytedance.i18n.location.api.LocationData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.uber.h3core.util.LatLng;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

public final class C1Ak3 {
    public static final 06vB LIZ = 02vO.LIZIZ(new Function0() {
        public final Object invoke() {
            return new C00091Aka();
        }
    });

    public static LocationData LIZ(LocationData locationData, 0Ir2 r14) {
        Pair pair;
        if (locationData.latitude == 0.0d) {
            return locationData;
        }
        if (locationData.longitude == 0.0d) {
            return locationData;
        }
        C00091Aka c00091Aka = (C00091Aka) LIZ.getValue();
        double d = locationData.latitude;
        double d2 = locationData.longitude;
        int i = r14.LIZLLL;
        int i2 = r14.LIZJ;
        c00091Aka.getClass();
        try {
            long jLIZ = ((C1AkY) c00091Aka.LIZ.getValue()).LIZ.LIZ(d, d2, i);
            0bn7 r5 = 0bn7.LIZ;
            StringBuilder sbLIZ = 0wS0.LIZ();
            sbLIZ.append("fuzz: (latitude=");
            sbLIZ.append(d);
            sbLIZ.append(", longitude=");
            sbLIZ.append(d2);
            sbLIZ.append(')');
            0bn7.LIZIZ("H3fuzz", 0wS0.LIZIZ(sbLIZ));
            List listLIZJ = ((C1AkY) c00091Aka.LIZ.getValue()).LIZ.LIZJ(i2, jLIZ);
            StringBuilder sbLIZ2 = 0wS0.LIZ();
            sbLIZ2.append("fuzz: regularizationLatLon kRingsResult size:");
            ArrayList arrayList = (ArrayList) listLIZJ;
            sbLIZ2.append(arrayList.size());
            0bn7.LIZIZ("H3fuzz", 0wS0.LIZIZ(sbLIZ2));
            if (arrayList.size() > 1) {
                int iNextInt = new Random().nextInt(arrayList.size() - 1) + 1;
                StringBuilder sbLIZ3 = 0wS0.LIZ();
                sbLIZ3.append("regularizationLatLon index:");
                sbLIZ3.append(iNextInt);
                0bn7.LIZLLL("H3fuzz", 0wS0.LIZIZ(sbLIZ3));
                LatLng latLngLIZIZ = ((C1AkY) c00091Aka.LIZ.getValue()).LIZ.LIZIZ(((Number) ListProtector.get(listLIZJ, iNextInt)).longValue());
                android.util.Pair pair2 = new android.util.Pair(Double.valueOf(latLngLIZIZ.lat), Double.valueOf(latLngLIZIZ.lng));
                StringBuilder sbLIZ4 = 0wS0.LIZ();
                sbLIZ4.append("fuzz result:");
                sbLIZ4.append(pair2);
                0bn7.LIZIZ("H3fuzz", 0wS0.LIZIZ(sbLIZ4));
                pair = new Pair(pair2.first, pair2.second);
            } else {
                pair = new Pair(Double.valueOf(d), Double.valueOf(d2));
            }
        } catch (Exception e) {
            0bn7 r0 = 0bn7.LIZ;
            StringBuilder sbLIZ5 = 0wS0.LIZ();
            sbLIZ5.append("fuzz geoCoord: ");
            sbLIZ5.append(e.getMessage());
            0bn7.LIZJ("H3fuzz", 0wS0.LIZIZ(sbLIZ5), (Throwable) null);
        }
        LocationData locationDataLIZ = LocationData.LIZ(locationData);
        locationDataLIZ.latitude = ((Number) pair.getFirst()).doubleValue();
        locationDataLIZ.longitude = ((Number) pair.getSecond()).doubleValue();
        locationDataLIZ.fuzzType = 2;
        return locationDataLIZ;
    }
}
