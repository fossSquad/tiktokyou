package X;

import android.telephony.TelephonyManager;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;
import java.util.function.Supplier;

public abstract class i3 {
    static {
        ThreadLocal.withInitial(new Supplier() {
            @Override
            public final Object get() {
                return Boolean.FALSE;
            }
        });
        ThreadLocal.withInitial(new Supplier() {
            @Override
            public final Object get() {
                return Boolean.FALSE;
            }
        });
    }

    public static void a() {
        try {
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimCountryIso", null), new b3());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkCountryIso", null), new c3());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperator", null), new d3());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperator", null), new e3());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperatorName", null), new f3());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperatorName", null), new g3());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimState", null), new h3());
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = q2.a;
        }
    }
}
