package X;

import android.content.ContentResolver;
import com.ss.android.ugc.aweme.feed.model.Video;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public abstract class y {
    public static final Set a = ConcurrentHashMap.newKeySet();
    public static final ThreadLocal b = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });

    public static void a() {
        try {
            t tVar = new t();
            XposedBridge.hookAllMethods(Video.class, "getDownloadAddr", tVar);
            XposedBridge.hookAllMethods(Video.class, "getNewDownloadAddr", tVar);
            XposedBridge.hookAllMethods(Video.class, "getDownloadNoWatermarkAddr", tVar);
            XposedBridge.hookAllMethods(Video.class, "getPlayAddrH264", tVar);
            try {
                XposedBridge.hookAllConstructors(Class.forName("com.ss.android.ugc.trill.download.protocol.download.AwemeVideoDownloadAbilityProtocol"), new u(Class.forName("X.0wO2"), Class.forName("X.0wPR"), Class.forName("X.0wO3")));
                ArrayList arrayList = g1.a;
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList2 = g1.a;
            }
            try {
                XposedBridge.hookAllMethods(ContentResolver.class, "insert", new v());
            } catch (Exception e2) {
                e2.getMessage();
                ArrayList arrayList3 = g1.a;
            }
            try {
                XposedBridge.hookAllMethods(ContentResolver.class, "openOutputStream", new w());
            } catch (Exception e3) {
                e3.getMessage();
                ArrayList arrayList4 = g1.a;
            }
        } catch (Exception e4) {
            e4.getMessage();
            ArrayList arrayList5 = g1.a;
        }
    }
}
