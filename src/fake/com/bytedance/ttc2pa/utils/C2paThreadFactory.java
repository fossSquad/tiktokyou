package fake.com.bytedance.ttc2pa.utils;

import android.os.Process;
import com.bytedance.bpea.transmit.delegate.BPEAThread;
import fake.com.bytedance.ttc2pa.utils.C2paThreadFactory;
import fake.d.b;
import fake.d.c;
import java.util.concurrent.ThreadFactory;

public final class C2paThreadFactory implements ThreadFactory {
    public static final Companion Companion = new Companion();
    public static final String TAG = "C2paThreadFactory";
    public final String mThreadName = "TTC2PA-IO";

    public static final class Companion {
        public Companion() {
        }

        public  Companion(b bVar) {
            this();
        }
    }

    public static final void newThread$lambda$0(Runnable runnable, C2paThreadFactory c2paThreadFactory) {
        c.b(runnable, "$r");
        c.b(c2paThreadFactory, "this$0");
        Process.setThreadPriority(10);
        try {
            runnable.run();
        } catch (Throwable th) {
            Logger.INSTANCE.e(TAG, "C2paThreadFactory error when running in thread " + c2paThreadFactory.mThreadName, th);
        }
    }

    @Override
    public Thread newThread(final Runnable runnable) {
        c.b(runnable, "r");
        return new BPEAThread(new Runnable() {
            @Override
            public final void run() {
                C2paThreadFactory.newThread$lambda$0(runnable, this);
            }
        }, this.mThreadName);
    }
}
