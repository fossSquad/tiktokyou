package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080\u0080\u0004¨\u0006\u0006"}, d2 = {"createMapForCache", _UrlKt.FRAGMENT_ENCODE_SET, "K", "V", "initialCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CreateMapForCacheKt {
    public static final <K, V> Map<K, V> createMapForCache(int initialCapacity) {
        return new ConcurrentHashMap(initialCapacity);
    }
}
