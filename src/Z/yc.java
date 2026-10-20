package Z;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class yc {
    public static final LinkedHashMap a;
    public static Method b;
    public static Method c;
    public static Method d;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a = linkedHashMap;
        linkedHashMap.put("DOWNLOAD_50_VIDEOS", new xc(200, 120, 600));
        linkedHashMap.put("DOWNLOAD_60_VIDEOS", new xc(400, 240, 1200));
        linkedHashMap.put("DOWNLOAD_100_VIDEOS", new xc(600, 360, 1800));
        linkedHashMap.put("DOWNLOAD_120_VIDEOS", new xc(800, 480, 2400));
        linkedHashMap.put("DOWNLOAD_150_VIDEOS", new xc(1000, 600, 3000));
        linkedHashMap.put("DOWNLOAD_200_VIDEOS", new xc(1200, 720, 3600));
        linkedHashMap.put("DOWNLOAD_240_VIDEOS", new xc(1600, 960, 4800));
        linkedHashMap.put("DOWNLOAD_480_VIDEOS", new xc(2000, 1200, 6000));
    }

    public static void a() {
        try {
            Method methodA = z9.b.a(z9.a.a(), new Class[0]);
            if (!List.class.isAssignableFrom(methodA.getReturnType())) {
                throw new NoSuchMethodException("Unexpected offline count-options return type: " + methodA);
            }
            HookBridge.hookMethod(methodA, new sc());
            methodA.getName();
            try {
                Class clsA = y9.a.a();
                Method methodA2 = y9.b.a(clsA, new Class[0]);
                Method methodA3 = y9.c.a(clsA, new Class[0]);
                Method methodA4 = y9.d.a(clsA, new Class[0]);
                HookBridge.hookMethod(methodA2, new tc());
                HookBridge.hookMethod(methodA3, new uc());
                HookBridge.hookMethod(methodA4, new vc());
            } catch (Throwable th) {
                String strDecrypt = "Count-metadata error";
                Object obj = g7.a;
                g7.a(6, String.valueOf(strDecrypt), th);
            }
            try {
                Class clsA2 = x9.a.a();
                Method methodA5 = x9.b.a(clsA2, new Class[0]);
                b = x9.c.a(clsA2, new Class[0]);
                d = z9.c.a(z9.a.a(), new Class[0]);
                HookBridge.hookMethod(methodA5, new qc());
                methodA5.getName();
            } catch (Throwable th2) {
                String strDecrypt2 = "Cache-count restore error: ";
                Object obj2 = g7.a;
                g7.a(6, String.valueOf(strDecrypt2), th2);
            }
            try {
                Method methodA6 = aa.b.a(aa.a.a(), Boolean.TYPE);
                HookBridge.hookMethod(methodA6, new rc());
                methodA6.getName();
            } catch (Throwable th3) {
                String strDecrypt3 = "Cleanup-disable error";
                Object obj3 = g7.a;
                g7.a(6, String.valueOf(strDecrypt3), th3);
            }
        } catch (Throwable th4) {
            String strDecrypt4 = "Count-options error";
            Object obj4 = g7.a;
            g7.a(6, String.valueOf(strDecrypt4), th4);
        }
    }
}
