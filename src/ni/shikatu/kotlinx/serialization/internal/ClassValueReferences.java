package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\t\bF¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0014J.\u0010\t\u001a\u00028\u00002\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b2\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\bH\u0086\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ClassValueReferences;", "T", "Ljava/lang/ClassValue;", "Lni/shikatu/kotlinx/serialization/internal/MutableSoftReference;", "<init>", "()V", "computeValue", "type", "Ljava/lang/Class;", "getOrSet", "key", "factory", "Lni/shikatu/kotlin/Function0;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isStored", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class ClassValueReferences<T> extends ClassValue<MutableSoftReference<T>> {
    @Override
    public /* bridge */  Object computeValue(Class p0) {
        return computeValue((Class<?>) p0);
    }

    @Override
    protected MutableSoftReference<T> computeValue(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "type");
        return new MutableSoftReference<>();
    }

    public final T getOrSet(Class<?> cls, final Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(cls, "key");
        Intrinsics.checkNotNullParameter(function0, "factory");
        T t = get(cls);
        Intrinsics.checkNotNullExpressionValue(t, "get(...)");
        MutableSoftReference mutableSoftReference = (MutableSoftReference) t;
        T t2 = mutableSoftReference.reference.get();
        if (t2 != null) {
            return t2;
        }
        return (T) mutableSoftReference.getOrSetWithLock(new Function0<T>() {
            @Override
            public final T invoke() {
                return function0.invoke();
            }
        });
    }

    public final boolean isStored(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "key");
        return ((MutableSoftReference) get(cls)).reference.get() != null;
    }
}
