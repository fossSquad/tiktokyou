package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArrayDeque;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0084\u0080\u0004J\u0012\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0084\u0080\u0004R\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\bX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/CharArrayPoolBase;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "arrays", "Lni/shikatu/kotlin/collections/ArrayDeque;", _UrlKt.FRAGMENT_ENCODE_SET, "charsTotal", _UrlKt.FRAGMENT_ENCODE_SET, "take", "size", "releaseImpl", _UrlKt.FRAGMENT_ENCODE_SET, "array", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class CharArrayPoolBase {
    private final ArrayDeque<char[]> arrays = new ArrayDeque<>();
    private int charsTotal;

    protected final char[] take(int size) {
        char[] candidate;
        synchronized (this) {
            candidate = this.arrays.removeLastOrNull();
            if (candidate != null) {
                this.charsTotal -= candidate.length;
            } else {
                candidate = null;
            }
        }
        return candidate == null ? new char[size] : candidate;
    }

    protected final void releaseImpl(char[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        synchronized (this) {
            if (this.charsTotal + array.length < ArrayPoolsKt.MAX_CHARS_IN_POOL) {
                this.charsTotal += array.length;
                this.arrays.addLast(array);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
