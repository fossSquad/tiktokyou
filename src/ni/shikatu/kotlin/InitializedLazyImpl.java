package ni.shikatu.kotlin;

import java.io.Serializable;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0011\bF\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000b\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004R\u0017\u0010\u0005\u001a\u00028\u0000X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlin/InitializedLazyImpl;", "T", "Lni/shikatu/kotlin/Lazy;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isInitialized", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class InitializedLazyImpl<T> implements Lazy<T>, Serializable {
    private final T value;

    public InitializedLazyImpl(T t) {
        this.value = t;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
