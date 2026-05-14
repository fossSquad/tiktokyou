package X;

import android.telephony.TelephonyManager;
import com.windukk.hook.HookBridge;
import java.util.function.Supplier;

public abstract class s4 {
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
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkType", null), new j4());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getDataNetworkType", null), new k4());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("hasIccCard", null), new l4());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimCountryIso", null), new m4());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkCountryIso", null), new n4());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperator", null), new o4());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperator", null), new p4());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperatorName", null), new q4());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperatorName", null), new r4());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimState", null), new i4());
        } catch (Exception e) {
            e.getMessage();
            int i = v3.a;
        }
    }
}
