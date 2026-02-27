package X;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import java.util.ArrayList;
import java.util.Random;

class p extends XC_MethodReplacement {
    public Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        String str;
        synchronized (q.class) {
            if (q.a == null) {
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 15; i++) {
                    sb.append(random.nextInt(10));
                }
                q.a = sb.toString();
                ArrayList arrayList = q0.a;
            }
            str = q.a;
        }
        return str;
    }
}
