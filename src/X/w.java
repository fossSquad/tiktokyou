package X;

import android.content.ContentResolver;
import com.ss.android.ugc.aweme.feed.model.Video;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public abstract class w {
    public static final Set a = ConcurrentHashMap.newKeySet();
    public static final ThreadLocal b = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return Boolean.FALSE;
        }
    });

    public static void a() {
        try {
            r rVar = new r();
            XposedBridge.hookAllMethods(Video.class, "getDownloadAddr", rVar);
            XposedBridge.hookAllMethods(Video.class, "getNewDownloadAddr", rVar);
            XposedBridge.hookAllMethods(Video.class, "getDownloadNoWatermarkAddr", rVar);
            XposedBridge.hookAllMethods(Video.class, "getPlayAddrH264", rVar);
            try {
                XposedBridge.hookAllConstructors(Class.forName("com.ss.android.ugc.trill.download.protocol.download.AwemeVideoDownloadAbilityProtocol"), new s(Class.forName("X.0wO2"), Class.forName("X.0wPR"), Class.forName("X.0wO3")));
                ArrayList arrayList = q0.a;
            } catch (Exception e) {
                e.getMessage();
                ArrayList arrayList2 = q0.a;
            }
            try {
                XposedBridge.hookAllMethods(ContentResolver.class, "insert", new t());
            } catch (Exception e2) {
                e2.getMessage();
                ArrayList arrayList3 = q0.a;
            }
            try {
                XposedBridge.hookAllMethods(ContentResolver.class, "openOutputStream", new u());
            } catch (Exception e3) {
                e3.getMessage();
                ArrayList arrayList4 = q0.a;
            }
        } catch (Exception e4) {
            e4.getMessage();
            ArrayList arrayList5 = q0.a;
        }
    }
}
