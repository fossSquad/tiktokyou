package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Utf8;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H¦\u0080\u0004J\n\u0010\u0006\u001a\u00020\u0007H¦\u0080\u0004J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0086\u0080\u0004R\u0013\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonReaderCodePointImpl;", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonReader;", "<init>", "()V", "exhausted", _UrlKt.FRAGMENT_ENCODE_SET, "nextCodePoint", _UrlKt.FRAGMENT_ENCODE_SET, "bufferedChar", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/lang/Character;", "read", "buffer", _UrlKt.FRAGMENT_ENCODE_SET, "bufferOffset", "count", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@JsonFriendModuleApi
public abstract class InternalJsonReaderCodePointImpl implements InternalJsonReader {
    private Character bufferedChar;

    public abstract boolean exhausted();

    public abstract int nextCodePoint();

    @Override
    public final int read(char[] buffer, int bufferOffset, int count) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = 0;
        if (this.bufferedChar != null) {
            Character ch = this.bufferedChar;
            Intrinsics.checkNotNull(ch);
            buffer[bufferOffset + 0] = ch.charValue();
            i = 0 + 1;
            this.bufferedChar = null;
        }
        while (i < count && !exhausted()) {
            int codePoint = nextCodePoint();
            if (codePoint <= 65535) {
                buffer[bufferOffset + i] = (char) codePoint;
                i++;
            } else {
                char upChar = (char) ((codePoint >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                char lowChar = (char) ((codePoint & 1023) + Utf8.LOG_SURROGATE_HEADER);
                buffer[bufferOffset + i] = upChar;
                i++;
                if (i < count) {
                    buffer[bufferOffset + i] = lowChar;
                    i++;
                } else {
                    this.bufferedChar = Character.valueOf(lowChar);
                }
            }
        }
        if (i > 0) {
            return i;
        }
        return -1;
    }
}
