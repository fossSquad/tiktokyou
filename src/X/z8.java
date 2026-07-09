package X;

import com.windukk.hook.HookBridge;
import com.windukk.hook.callbacks.HookCallback;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class z8 {
    public static final LinkedHashMap a;
    public static Method b;
    public static Method c;
    public static Method d;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a = linkedHashMap;
        linkedHashMap.put("DOWNLOAD_50_VIDEOS", new y8(200, 120, 600));
        linkedHashMap.put("DOWNLOAD_60_VIDEOS", new y8(500, 300, 1500));
        linkedHashMap.put("DOWNLOAD_100_VIDEOS", new y8(1000, 600, 3000));
        linkedHashMap.put("DOWNLOAD_120_VIDEOS", new y8(2000, 1200, 6000));
        linkedHashMap.put("DOWNLOAD_150_VIDEOS", new y8(3000, 1800, 9000));
        linkedHashMap.put("DOWNLOAD_200_VIDEOS", new y8(5000, 3000, 15000));
        linkedHashMap.put("DOWNLOAD_240_VIDEOS", new y8(HookCallback.PRIORITY_HIGHEST, 6000, 30000));
        linkedHashMap.put("DOWNLOAD_480_VIDEOS", new y8(100000, 60000, 300000));
    }

    public static void a() {
        try {
            Method methodA = w6.b.a(w6.a.a(), new Class[0]);
            if (!List.class.isAssignableFrom(methodA.getReturnType())) {
                throw new NoSuchMethodException("Unexpected offline count-options return type: " + methodA);
            }
            HookBridge.hookMethod(methodA, new t8());
            methodA.getName();
            int i = g5.a;
            try {
                Class clsA = v6.a.a();
                Method methodA2 = v6.b.a(clsA, new Class[0]);
                Method methodA3 = v6.c.a(clsA, new Class[0]);
                Method methodA4 = v6.d.a(clsA, new Class[0]);
                HookBridge.hookMethod(methodA2, new u8());
                HookBridge.hookMethod(methodA3, new v8());
                HookBridge.hookMethod(methodA4, new w8());
            } catch (Throwable th) {
                th.toString();
                int i2 = g5.a;
            }
            try {
                Class clsA2 = u6.a.a();
                Method methodA5 = u6.b.a(clsA2, new Class[0]);
                b = u6.c.a(clsA2, new Class[0]);
                d = w6.c.a(w6.a.a(), new Class[0]);
                HookBridge.hookMethod(methodA5, new r8());
                methodA5.getName();
            } catch (Throwable th2) {
                th2.toString();
                int i3 = g5.a;
            }
            try {
                Method methodA6 = x6.b.a(x6.a.a(), Boolean.TYPE);
                HookBridge.hookMethod(methodA6, new s8());
                methodA6.getName();
            } catch (Throwable th3) {
                th3.toString();
                int i4 = g5.a;
            }
        } catch (Throwable th4) {
            th4.toString();
            int i5 = g5.a;
        }
    }
}
