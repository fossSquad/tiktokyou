package X;

import de.robv.android.xposed.XC_MethodHook;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

class d2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Enumeration enumeration;
        if (i1.a().a && (enumeration = (Enumeration) methodHookParam.getResult()) != null) {
            ArrayList arrayList = new ArrayList();
            while (enumeration.hasMoreElements()) {
                InetAddress inetAddress = (InetAddress) enumeration.nextElement();
                if (inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isSiteLocalAddress()) {
                    arrayList.add(inetAddress);
                }
            }
            methodHookParam.setResult(Collections.enumeration(arrayList));
        }
    }
}
