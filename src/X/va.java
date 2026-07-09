package X;

import android.telephony.TelephonyManager;
import com.windukk.hook.HookBridge;
import java.util.function.Supplier;

public abstract class va {
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
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkType", null), new ma());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getDataNetworkType", null), new na());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("hasIccCard", null), new oa());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimCountryIso", null), new pa());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkCountryIso", null), new qa());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperator", null), new ra());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperator", null), new sa());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperatorName", null), new ta());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperatorName", null), new ua());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimState", null), new la());
        } catch (Exception e) {
            e.getMessage();
            int i = g5.a;
        }
    }
}
