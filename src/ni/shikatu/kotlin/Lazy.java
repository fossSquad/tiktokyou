package ni.shikatu.kotlin;

import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\n\u0010\u0006\u001a\u00020\u0007H¦\u0080\u0004R\u0013\u0010\u0003\u001a\u00028\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/Lazy;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "value", "getValue", "()Ljava/lang/Object;", "isInitialized", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface Lazy<T> {
    T getValue();

    boolean isInitialized();
}
