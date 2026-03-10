package X;

import de.robv.android.xposed.XC_MethodHook;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

class c2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Enumeration enumeration;
        if (i1.a().a && (enumeration = (Enumeration) methodHookParam.getResult()) != null) {
            ArrayList arrayList = new ArrayList();
            while (enumeration.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) enumeration.nextElement();
                String name = networkInterface.getName();
                if (!name.startsWith("tun") && !name.startsWith("ppp")) {
                    arrayList.add(networkInterface);
                }
            }
            methodHookParam.setResult(Collections.enumeration(arrayList));
        }
    }
}
