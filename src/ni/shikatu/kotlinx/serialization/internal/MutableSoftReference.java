package ni.shikatu.kotlinx.serialization.internal;

import java.lang.ref.SoftReference;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0007\u001a\u00028\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\u0080\u0004¢\u0006\u0002\u0010\nR\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006@\u0006X\u0087\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/MutableSoftReference;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "reference", "Ljava/lang/ref/SoftReference;", "getOrSetWithLock", "factory", "Lni/shikatu/kotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class MutableSoftReference<T> {
    public volatile SoftReference<T> reference = new SoftReference<>(null);

    public final synchronized T getOrSetWithLock(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        T t = this.reference.get();
        if (t != null) {
            return t;
        }
        T tInvoke = function0.invoke();
        this.reference = new SoftReference<>(tInvoke);
        return tInvoke;
    }
}
