package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\t\u001a\u00020\n\"\b\b\u0000\u0010\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00072\u0006\u0010\u000e\u001a\u0002H\u000bH\u0086\u0082\u0004¢\u0006\u0002\u0010\u000fJ=\u0010\u0010\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0013J1\u0010\u0014\u001a\u0004\u0018\u0001H\u000b\"\b\b\u0000\u0010\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0007H\u0086\u0082\u0004¢\u0006\u0002\u0010\u0015R7\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0004\u0012\u00020\u00010\u0005j\b\u0012\u0004\u0012\u00020\u0001`\b0\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/DescriptorSchemaCache;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "map", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "Lni/shikatu/kotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "Lni/shikatu/kotlinx/serialization/json/internal/DescriptorData;", "set", _UrlKt.FRAGMENT_ENCODE_SET, "T", "descriptor", "key", "value", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;Ljava/lang/Object;)V", "getOrPut", "defaultValue", "Lni/shikatu/kotlin/Function0;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "get", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;)Ljava/lang/Object;", "Key", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DescriptorSchemaCache {
    private final Map<SerialDescriptor, Map<Key<Object>, Object>> map = CreateMapForCacheKt.createMapForCache(16);

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Key<T> {
    }

    public final <T> void set(SerialDescriptor descriptor, Key<T> key, T t) {
        Map<Key<Object>, Object> mapCreateMapForCache;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(t, "value");
        Map<SerialDescriptor, Map<Key<Object>, Object>> map = this.map;
        Map<Key<Object>, Object> map2 = map.get(descriptor);
        if (map2 == null) {
            mapCreateMapForCache = CreateMapForCacheKt.createMapForCache(2);
            map.put(descriptor, mapCreateMapForCache);
        } else {
            mapCreateMapForCache = map2;
        }
        mapCreateMapForCache.put((Key<Object>) (Key) key, t);
    }

    public final <T> T getOrPut(SerialDescriptor serialDescriptor, Key<T> key, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        T t = (T) get(serialDescriptor, key);
        if (t != null) {
            return t;
        }
        T tInvoke = function0.invoke();
        set(serialDescriptor, key, tInvoke);
        return tInvoke;
    }

    public final <T> T get(SerialDescriptor serialDescriptor, Key<T> key) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<Key<Object>, Object> map = this.map.get(serialDescriptor);
        Object obj = map != null ? map.get(key) : null;
        if (obj == null) {
            return null;
        }
        return (T) obj;
    }
}
