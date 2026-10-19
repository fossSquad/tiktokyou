package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.JvmClassMappingKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B)\bF\u0012\u001e\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0096\u0080\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0080\u0004R-\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0004X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\fX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ClassValueCache;", "T", "Lni/shikatu/kotlinx/serialization/internal/SerializerCache;", "compute", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/reflect/KClass;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getCompute", "()Lkotlin/jvm/functions/Function1;", "classValue", "Lni/shikatu/kotlinx/serialization/internal/ClassValueReferences;", "Lni/shikatu/kotlinx/serialization/internal/CacheEntry;", "get", "key", _UrlKt.FRAGMENT_ENCODE_SET, "isStored", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class ClassValueCache<T> implements SerializerCache<T> {
    private final ClassValueReferences<CacheEntry<T>> classValue;
    private final Function1<KClass<?>, KSerializer<T>> compute;

    public ClassValueCache(Function1<? super KClass<?>, ? extends KSerializer<T>> function1) {
        Intrinsics.checkNotNullParameter(function1, "compute");
        this.compute = function1;
        this.classValue = new ClassValueReferences<>();
    }

    public final Function1<KClass<?>, KSerializer<T>> getCompute() {
        return this.compute;
    }

    @Override
    public KSerializer<T> get(final KClass<Object> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "key");
        CacheEntry<T> cacheEntry = this.classValue.get(JvmClassMappingKt.getJavaClass((KClass) kClass));
        Intrinsics.checkNotNullExpressionValue(cacheEntry, "get(...)");
        MutableSoftReference mutableSoftReference = (MutableSoftReference) cacheEntry;
        T t = mutableSoftReference.reference.get();
        if (t == null) {
            t = (T) mutableSoftReference.getOrSetWithLock(new Function0<T>() {
                @Override
                public final T invoke() {
                    return (T) new CacheEntry(this.this$0.getCompute().invoke(kClass));
                }
            });
        }
        return t.serializer;
    }

    @Override
    public boolean isStored(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "key");
        return this.classValue.isStored(JvmClassMappingKt.getJavaClass((KClass) kClass));
    }
}
