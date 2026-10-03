package ni.shikatu.okio;

import java.util.concurrent.locks.ReentrantLock;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000\u001a\f\u0010\b\u001a\u00060\u0007j\u0002`\tH\u0000\u001a:\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u00060\u0007j\u0002`\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e*\n\u0010\u0004\"\u00020\u00052\u00020\u0005*\n\u0010\u0006\"\u00020\u00072\u00020\u0007*\n\u0010\u000f\"\u00020\u00102\u00020\u0010*\n\u0010\u0011\"\u00020\u00122\u00020\u0012*\n\u0010\u0013\"\u00020\u00142\u00020\u0014*\n\u0010\u0015\"\u00020\u00162\u00020\u0016*\n\u0010\u0017\"\u00020\u00182\u00020\u0018*\n\u0010\u0019\"\u00020\u001a2\u00020\u001a*\n\u0010\u001b\"\u00020\u001c2\u00020\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"toUtf8String", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "asUtf8ToByteArray", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "Lock", "Ljava/util/concurrent/locks/ReentrantLock;", "newLock", "Lni/shikatu/okio/Lock;", "withLock", "T", "action", "Lni/shikatu/kotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "IOException", "Ljava/io/IOException;", "ProtocolException", "Ljava/net/ProtocolException;", "EOFException", "Ljava/io/EOFException;", "FileNotFoundException", "Ljava/io/FileNotFoundException;", "Closeable", "Ljava/io/Closeable;", "Deflater", "Ljava/util/zip/Deflater;", "Inflater", "Ljava/util/zip/Inflater;", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class _JvmPlatformKt {
    public static final String toUtf8String(byte[] $this$toUtf8String) {
        Intrinsics.checkNotNullParameter($this$toUtf8String, "<this>");
        return new String($this$toUtf8String, Charsets.UTF_8);
    }

    public static final byte[] asUtf8ToByteArray(String $this$asUtf8ToByteArray) {
        Intrinsics.checkNotNullParameter($this$asUtf8ToByteArray, "<this>");
        byte[] bytes = $this$asUtf8ToByteArray.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public static final ReentrantLock newLock() {
        return new ReentrantLock();
    }

    public static final <T> T withLock(ReentrantLock $this$withLock, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter($this$withLock, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        ReentrantLock reentrantLock = $this$withLock;
        reentrantLock.lock();
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            reentrantLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }
}
