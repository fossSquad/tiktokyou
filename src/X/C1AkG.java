package X;

import android.content.Context;
import android.location.LocationManager;
import android.util.LruCache;
import com.bytedance.i18n.location.api.LocationClient;
import java.util.Locale;

public final class C1AkG {
    public static C1AkH LIZ(Context context, Locale locale) {
        String strLIZIZ = 0VSt.LIZIZ(context);
        String strLIZ = 0VSt.LIZ(context);
        LocationClient locationClient = 06vM.LIZ;
        Locale locale2 = locale == null ? Locale.getDefault() : locale;
        LruCache lruCache = 0KBy.LIZ;
        String strLIZIZ2 = 0xHP.LIZIZ(locale2);
        String strLLLLZLL = 0Vx6.LLLLZLL(locale == null ? Locale.getDefault() : locale);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String string = locale.toString();
        int i = 1;
        int i2 = locationClient.isLocationPermissionGranted(context) ? 1 : 71;
        if (locationClient.LJIJI(context)) {
            i = 0;
            if (locationClient.isLocationPermissionGranted(context)) {
                LocationManager locationManager = (LocationManager) 0Vx6.LLZIL(context, "location");
                i = locationManager.isProviderEnabled("gps") ? 2 : 0;
                if (locationManager.isProviderEnabled("network")) {
                    i |= 4;
                }
                if (locationManager.isProviderEnabled("passive")) {
                    i |= 8;
                }
                if (locationClient.LJIIJJI(context) && !locationClient.LJIIL(context)) {
                    i |= 32;
                }
            }
        }
        return new C1AkH(strLIZIZ, strLLLLZLL, string, i, strLIZ, strLIZIZ, i2, strLIZIZ2, new C1AkD(locationClient.LJIIIZ(), locationClient.LJII(context), locationClient.LJIILL(context), locationClient.LJIJI(context) ? 1 : 0));
    }
}
