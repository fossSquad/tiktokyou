package ni.shikatu.okhttp3.internal.cache;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.internal.http.HttpMethod;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"requestForCache", "Lni/shikatu/okhttp3/Request;", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CacheInterceptorKt {

    public static final Request requestForCache(Request $this$requestForCache) {
        HttpUrl cacheUrlOverride = $this$requestForCache.cacheUrlOverride();
        if (cacheUrlOverride != null && (HttpMethod.INSTANCE.isCacheable($this$requestForCache.method()) || Intrinsics.areEqual($this$requestForCache.method(), "POST"))) {
            return $this$requestForCache.newBuilder().get().url(cacheUrlOverride).cacheUrlOverride(null).build();
        }
        return $this$requestForCache;
    }
}
