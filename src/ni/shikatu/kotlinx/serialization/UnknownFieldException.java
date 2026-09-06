package ni.shikatu.kotlinx.serialization;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0013\b@\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\bV\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lni/shikatu/kotlinx/serialization/UnknownFieldException;", "Lni/shikatu/kotlinx/serialization/SerializationException;", "message", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;)V", "index", _UrlKt.FRAGMENT_ENCODE_SET, "(I)V", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnknownFieldException extends SerializationException {
    public UnknownFieldException(String message) {
        super(message);
    }

    public UnknownFieldException(int index) {
        this("An unknown field for index " + index);
    }
}
