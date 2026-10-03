package ni.shikatu.kotlinx.serialization.internal;
import java.util.Map.Entry;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.JvmClassMappingKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B)\bF\u0012\u001e\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ \u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0096\u0080\u0004J\u0016\u0010\u0010\u001a\u00020\u00112\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0080\u0004R'\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R%\u0010\t\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\nX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ConcurrentHashMapCache;", "T", "Lni/shikatu/kotlinx/serialization/internal/SerializerCache;", "compute", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/reflect/KClass;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lni/shikatu/kotlinx/serialization/internal/CacheEntry;", "get", "key", _UrlKt.FRAGMENT_ENCODE_SET, "isStored", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class ConcurrentHashMapCache<T> implements SerializerCache<T> {
    private final ConcurrentHashMap<Class<?>, CacheEntry<T>> cache;
    private final Function1<KClass<?>, KSerializer<T>> compute;

    public ConcurrentHashMapCache(Function1<? super KClass<?>, ? extends KSerializer<T>> function1) {
        Intrinsics.checkNotNullParameter(function1, "compute");
        this.compute = function1;
        this.cache = new ConcurrentHashMap<>();
    }

    @Override
    public KSerializer<T> get(KClass<Object> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "key");
        ConcurrentMap $this$getOrPut$iv = this.cache;
        Class<?> javaClass = JvmClassMappingKt.getJavaClass((KClass) kClass);
        CacheEntry<T> cacheEntry = $this$getOrPut$iv.get(javaClass);
        if (cacheEntry == null) {
            CacheEntry<T> cacheEntry2 = new CacheEntry<>(this.compute.invoke(kClass));
            CacheEntry<T> cacheEntryPutIfAbsent = $this$getOrPut$iv.putIfAbsent(javaClass, cacheEntry2);
            cacheEntry = cacheEntryPutIfAbsent == null ? cacheEntry2 : cacheEntryPutIfAbsent;
        }
        return cacheEntry.serializer;
    }

    @Override
    public boolean isStored(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "key");
        return this.cache.containsKey(JvmClassMappingKt.getJavaClass((KClass) kClass));
    }
}
