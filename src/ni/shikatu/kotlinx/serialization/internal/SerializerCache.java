package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J \u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H¦\u0080\u0004J\u0016\u0010\u0007\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0096\u0080\u0004¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/SerializerCache;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "get", "Lni/shikatu/kotlinx/serialization/KSerializer;", "key", "Lni/shikatu/kotlin/reflect/KClass;", "isStored", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface SerializerCache<T> {
    KSerializer<T> get(KClass<Object> kClass);

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> boolean isStored(SerializerCache<T> serializerCache, KClass<?> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "key");
            return $this.isStored(kClass);
        }
    }

    default boolean isStored(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "key");
        return false;
    }
}
