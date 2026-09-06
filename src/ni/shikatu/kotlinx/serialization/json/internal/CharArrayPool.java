package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H\u0086\u0080\u0004J\u0012\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0086\u0080\u0004¨\u0006\t"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/CharArrayPool;", "Lni/shikatu/kotlinx/serialization/json/internal/CharArrayPoolBase;", "<init>", "()V", "take", _UrlKt.FRAGMENT_ENCODE_SET, "release", _UrlKt.FRAGMENT_ENCODE_SET, "array", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CharArrayPool extends CharArrayPoolBase {
    public static final CharArrayPool INSTANCE = new CharArrayPool();

    private CharArrayPool() {
    }

    public final char[] take() {
        return super.take(128);
    }

    public final void release(char[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        releaseImpl(array);
    }
}
