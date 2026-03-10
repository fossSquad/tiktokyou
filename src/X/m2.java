package X;

import android.telephony.TelephonyManager;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;
import java.util.function.Supplier;

public abstract class m2 {
    public static final  int a = 0;

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
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimCountryIso", null), new a2());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkCountryIso", null), new e2());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperator", null), new f2());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperator", null), new g2());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperatorName", null), new h2());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperatorName", null), new i2());
            XposedBridge.hookMethod(TelephonyManager.class.getMethod("getSimState", null), new j2());
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList = g1.a;
        }
    }
}
