package ni.shikatu.kotlin.experimental;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\t\u001a\u00020\u0001*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\u0007\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a(\u0010\b\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\u008c\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\t\u001a\u00020\n*\u00020\nH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006¨\u0006\u000b"}, d2 = {"and", _UrlKt.FRAGMENT_ENCODE_SET, "other", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "Lni/shikatu/kotlin/internal/InlineOnly;", "or", "xor", "inv", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class BitwiseOperationsKt {
    private static final byte and(byte $this$and, byte other) {
        return (byte) ($this$and & other);
    }

    private static final byte or(byte $this$or, byte other) {
        return (byte) ($this$or | other);
    }

    private static final byte xor(byte $this$xor, byte other) {
        return (byte) ($this$xor ^ other);
    }

    private static final byte inv(byte $this$inv) {
        return (byte) (~$this$inv);
    }

    private static final short and(short $this$and, short other) {
        return (short) ($this$and & other);
    }

    private static final short or(short $this$or, short other) {
        return (short) ($this$or | other);
    }

    private static final short xor(short $this$xor, short other) {
        return (short) ($this$xor ^ other);
    }

    private static final short inv(short $this$inv) {
        return (short) (~$this$inv);
    }
}
