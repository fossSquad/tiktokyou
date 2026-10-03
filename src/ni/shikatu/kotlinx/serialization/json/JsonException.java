package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0011\bD\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u00020\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonException;", "Lni/shikatu/kotlinx/serialization/SerializationException;", "message", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "shortMessage", "getShortMessage", "hint", "getHint", "Lni/shikatu/kotlinx/serialization/json/JsonDecodingException;", "Lni/shikatu/kotlinx/serialization/json/JsonEncodingException;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public abstract class JsonException extends SerializationException {
    private final String message;

    public  JsonException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public abstract String getHint();

    public abstract String getShortMessage();

    private JsonException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
