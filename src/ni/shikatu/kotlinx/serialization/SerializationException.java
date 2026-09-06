package ni.shikatu.kotlinx.serialization;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\bV¢\u0006\u0004\b\u0003\u0010\u0004B\u0013\bV\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0003\u0010\u0007B\u001d\bV\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0003\u0010\nB\u0013\bV\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0003\u0010\u000b¨\u0006\f"}, d2 = {"Lni/shikatu/kotlinx/serialization/SerializationException;", "Ljava/lang/IllegalArgumentException;", "Lni/shikatu/kotlin/IllegalArgumentException;", "<init>", "()V", "message", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)V", "cause", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class SerializationException extends IllegalArgumentException {
    public SerializationException() {
    }

    public SerializationException(String message) {
        super(message);
    }

    public SerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializationException(Throwable cause) {
        super(cause);
    }
}
