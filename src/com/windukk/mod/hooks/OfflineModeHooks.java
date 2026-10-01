package Z;

import Z.cb;
import Z.db;
import Z.eb;
import Z.fb;
import Z.gb;
import Z.h6;
import Z.hb;
import Z.jb;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class OfflineModeHooks {
    public static final LinkedHashMap a;
    public static Method b;
    public static Method c;
    public static Method d;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a = linkedHashMap;
        linkedHashMap.put("DOWNLOAD_50_VIDEOS", new jb(200, 120, 600));
        linkedHashMap.put("DOWNLOAD_60_VIDEOS", new jb(400, 240, 1200));
        linkedHashMap.put("DOWNLOAD_100_VIDEOS", new jb(600, 360, 1800));
        linkedHashMap.put("DOWNLOAD_120_VIDEOS", new jb(800, 480, 2400));
        linkedHashMap.put("DOWNLOAD_150_VIDEOS", new jb(1000, 600, 3000));
        linkedHashMap.put("DOWNLOAD_200_VIDEOS", new jb(1200, 720, 3600));
        linkedHashMap.put("DOWNLOAD_240_VIDEOS", new jb(1600, 960, 4800));
        linkedHashMap.put("DOWNLOAD_480_VIDEOS", new jb(2000, 1200, 6000));
    }

    public static void a() {
        try {
            Method methodA = t8.b.a(t8.a.a(), new Class[0]);
            if (!List.class.isAssignableFrom(methodA.getReturnType())) {
                throw new NoSuchMethodException("Unexpected offline count-options return type: " + methodA);
            }
            HookBridge.hookMethod(methodA, new eb());
            methodA.getName();
            try {
                Class clsA = s8.a.a();
                Method methodA2 = s8.b.a(clsA, new Class[0]);
                Method methodA3 = s8.c.a(clsA, new Class[0]);
                Method methodA4 = s8.d.a(clsA, new Class[0]);
                HookBridge.hookMethod(methodA2, new fb());
                HookBridge.hookMethod(methodA3, new gb());
                HookBridge.hookMethod(methodA4, new hb());
            } catch (Throwable th) {
                String strDecrypt = "Count-metadata error";
                Object obj = h6.a;
                h6.a(6, String.valueOf(strDecrypt), th);
            }
            try {
                Class clsA2 = r8.a.a();
                Method methodA5 = r8.b.a(clsA2, new Class[0]);
                b = r8.c.a(clsA2, new Class[0]);
                d = t8.c.a(t8.a.a(), new Class[0]);
                HookBridge.hookMethod(methodA5, new cb());
                methodA5.getName();
            } catch (Throwable th2) {
                String strDecrypt2 = "Cache-count restore error: ";
                Object obj2 = h6.a;
                h6.a(6, String.valueOf(strDecrypt2), th2);
            }
            try {
                Method methodA6 = u8.b.a(u8.a.a(), Boolean.TYPE);
                HookBridge.hookMethod(methodA6, new db());
                methodA6.getName();
            } catch (Throwable th3) {
                String strDecrypt3 = "Cleanup-disable error";
                Object obj3 = h6.a;
                h6.a(6, String.valueOf(strDecrypt3), th3);
            }
        } catch (Throwable th4) {
            String strDecrypt4 = "Count-options error";
            Object obj4 = h6.a;
            h6.a(6, String.valueOf(strDecrypt4), th4);
        }
    }
}
