package fake.com.bytedance.ttc2pa;

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
            moltenFFICallback = (MoltenFFICallback) idToInstance.get(Long.valueOf(j));
        }
        return moltenFFICallback;
    }

    public final long registerInstance(MoltenFFICallback moltenFFICallback) {
        long jIncrementAndGet;
        c.b(moltenFFICallback, "cb");
        synchronized (this) {
            jIncrementAndGet = currentInstanceId.incrementAndGet();
            idToInstance.put(Long.valueOf(jIncrementAndGet), moltenFFICallback);
        }
        return jIncrementAndGet;
    }

    public final void unregisterInstance(long j) {
        synchronized (this) {
            Map map = idToInstance;
            if (((MoltenFFICallback) map.get(Long.valueOf(j))) == null) {
                return;
            }
        }
    }
}
