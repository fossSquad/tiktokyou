package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.Serializable;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fR\u0015\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0015\u0010\u0007\u001a\u00020\bX\u0096Ä\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonNull;", "Lni/shikatu/kotlinx/serialization/json/JsonPrimitive;", "<init>", "()V", "isString", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "content", _UrlKt.FRAGMENT_ENCODE_SET, "getContent", "()Ljava/lang/String;", "serializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = JsonNullSerializer.class)
public final class JsonNull extends JsonPrimitive {
    public static final JsonNull INSTANCE = new JsonNull();
    private static final String content = AbstractJsonLexerKt.NULL;

    private JsonNull() {
        super(null);
    }

    public final KSerializer<JsonNull> serializer() {
        return JsonNullSerializer.INSTANCE;
    }

    @Override
    public boolean isString() {
        return false;
    }

    @Override
    public String getContent() {
        return content;
    }
}
