package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"emptyArray", _UrlKt.FRAGMENT_ENCODE_SET, "T", "()[Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ArrayIntrinsicsKt {
    public static final  <T> T[] emptyArray() {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) new Object[0];
    }
}
