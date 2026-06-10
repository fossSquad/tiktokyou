package X;

import android.telephony.TelephonyManager;
import com.windukk.hook.HookBridge;
import java.util.function.Supplier;

public abstract class u8 {
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
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkType", null), new l8());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getDataNetworkType", null), new m8());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("hasIccCard", null), new n8());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimCountryIso", null), new o8());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkCountryIso", null), new p8());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperator", null), new q8());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperator", null), new r8());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimOperatorName", null), new s8());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getNetworkOperatorName", null), new t8());
            HookBridge.hookMethod(TelephonyManager.class.getMethod("getSimState", null), new k8());
        } catch (Exception e) {
            e.getMessage();
            int i = p4.a;
        }
    }
}
