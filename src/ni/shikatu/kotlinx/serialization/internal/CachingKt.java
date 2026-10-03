package ni.shikatu.kotlinx.serialization.internal;

import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u001e\u0010\u0005\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\b0\u0006H\u0080\u0080\u0004\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\n\"\u0004\b\u0000\u0010\u00042,\u0010\u0005\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\b0\u000bH\u0080\u0080\u0004\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"useClassValue", _UrlKt.FRAGMENT_ENCODE_SET, "createCache", "Lni/shikatu/kotlinx/serialization/internal/SerializerCache;", "T", "factory", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/reflect/KClass;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "createParametrizedCache", "Lni/shikatu/kotlinx/serialization/internal/ParametrizedSerializerCache;", "Lni/shikatu/kotlin/Function2;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KType;", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CachingKt {
    private static final boolean useClassValue;

    static {
        boolean z;
        try {
            Class.forName("java.lang.ClassValue");
            z = true;
        } catch (Throwable th) {
            z = false;
        }
        useClassValue = z;
    }

    public static final <T> SerializerCache<T> createCache(Function1<? super KClass<?>, ? extends KSerializer<T>> function1) {
        Intrinsics.checkNotNullParameter(function1, "factory");
        return useClassValue ? new ClassValueCache<>(function1) : new ConcurrentHashMapCache<>(function1);
    }

    public static final <T> ParametrizedSerializerCache<T> createParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> function2) {
        Intrinsics.checkNotNullParameter(function2, "factory");
        return useClassValue ? new ClassValueParametrizedCache<>(function2) : new ConcurrentHashMapParametrizedCache<>(function2);
    }
}
