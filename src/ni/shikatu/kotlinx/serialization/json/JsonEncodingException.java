package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.json.internal.JsonExceptionsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B)\b@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u00020\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonEncodingException;", "Lni/shikatu/kotlinx/serialization/json/JsonException;", "shortMessage", _UrlKt.FRAGMENT_ENCODE_SET, "classSerialName", "hint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getShortMessage", "()Ljava/lang/String;", "getClassSerialName", "getHint", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public final class JsonEncodingException extends JsonException {
    private final String classSerialName;
    private final String hint;
    private final String shortMessage;

    public JsonEncodingException(String shortMessage, String classSerialName, String hint) {
        super(JsonExceptionsKt.formatEncodingException(shortMessage, hint), null);
        Intrinsics.checkNotNullParameter(shortMessage, "shortMessage");
        this.shortMessage = shortMessage;
        this.classSerialName = classSerialName;
        this.hint = hint;
    }

    public  JsonEncodingException(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @Override
    public String getShortMessage() {
        return this.shortMessage;
    }

    public final String getClassSerialName() {
        return this.classSerialName;
    }

    @Override
    public String getHint() {
        return this.hint;
    }
}
