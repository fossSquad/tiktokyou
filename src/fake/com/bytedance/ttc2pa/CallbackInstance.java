package fake.com.bytedance.ttc2pa;

import com.bytedance.tt.reliability.monitor.catchchecker.TryCatchGuardChecker;
import fake.d.c;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class CallbackInstance {
    public static final CallbackInstance INSTANCE = new CallbackInstance();
    public static final AtomicLong currentInstanceId = new AtomicLong(100);
    public static final Map idToInstance = new LinkedHashMap();

    public final MoltenFFICallback getInstance(long j) {
        MoltenFFICallback moltenFFICallback;
        synchronized (this) {
            try {
                moltenFFICallback = (MoltenFFICallback) idToInstance.get(Long.valueOf(j));
            } catch (Throwable th) {
                TryCatchGuardChecker.doCheck(th);
                throw th;
            }
        }
        return moltenFFICallback;
    }

    public final long registerInstance(MoltenFFICallback moltenFFICallback) {
        long jIncrementAndGet;
        c.b(moltenFFICallback, "cb");
        synchronized (this) {
            try {
                jIncrementAndGet = currentInstanceId.incrementAndGet();
                idToInstance.put(Long.valueOf(jIncrementAndGet), moltenFFICallback);
            } catch (Throwable th) {
                TryCatchGuardChecker.doCheck(th);
                throw th;
            }
        }
        return jIncrementAndGet;
    }

    public final void unregisterInstance(long j) {
        synchronized (this) {
            try {
                Map map = idToInstance;
                if (((MoltenFFICallback) map.get(Long.valueOf(j))) == null) {
                    return;
                }
            } catch (Throwable th) {
                TryCatchGuardChecker.doCheck(th);
                throw th;
            }
        }
    }
}
