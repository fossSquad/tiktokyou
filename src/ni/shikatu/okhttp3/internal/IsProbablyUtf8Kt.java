package ni.shikatu.okhttp3.internal;

import java.io.EOFException;
import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSource;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"isProbablyUtf8", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/BufferedSource;", "codePointLimit", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IsProbablyUtf8Kt {
    public static  boolean isProbablyUtf8$default(BufferedSource bufferedSource, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = LongCompanionObject.MAX_VALUE;
        }
        return isProbablyUtf8(bufferedSource, j);
    }

    public static final boolean isProbablyUtf8(BufferedSource $this$isProbablyUtf8, long codePointLimit) throws IOException {
        Intrinsics.checkNotNullParameter($this$isProbablyUtf8, "<this>");
        try {
            BufferedSource peek = $this$isProbablyUtf8.peek();
            for (long i = 0; i < codePointLimit && !peek.exhausted(); i++) {
                int codePoint = peek.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false;
        }
    }
}
