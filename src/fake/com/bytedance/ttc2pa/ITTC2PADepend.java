package fake.com.bytedance.ttc2pa;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public interface ITTC2PADepend {

    public static final class DefaultImpls {
        public static boolean enableDebug(ITTC2PADepend iTTC2PADepend) {
            return false;
        }

        public static long getCertFailRetryIntervalSeconds(ITTC2PADepend iTTC2PADepend) {
            return 300L;
        }

        public static ScheduledExecutorService getIoExecutor(ITTC2PADepend iTTC2PADepend) {
            return null;
        }
    }

    boolean enableDebug();

    long getCertFailRetryIntervalSeconds();

    Context getContext();

    ScheduledExecutorService getIoExecutor();

    String getRemoteCertDownloadURL();

    String getTimeStampRequestHost();

    void monitorLogSend(String str, String str2);

    TtC2paNetworkResponse onHttpGetRequest(String str, Map map, long j);

    TtC2paNetworkResponse onRemoteSign(byte[] bArr);
}
