package fake.com.bytedance.ttc2pa;

import java.util.Map;

public interface TtC2paNetworkCaller {
    TtC2paNetworkResponse doPost(String str, Map map, byte[] bArr, long j, boolean z);

    TtC2paNetworkResponse onRemoteSign(byte[] bArr);
}
