package X;

import android.telephony.TelephonyManager;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class h1 {
    public static void a() {
        try {
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimCountryIso", null), new z0());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkCountryIso", null), new a1());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperator", null), new b1());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperatorName", null), new c1());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperatorName", null), new d1());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperator", null), new e1());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getAllCellInfo", null), new f1());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimState", null), new g1());
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = q0.a;
        }
    }
}
