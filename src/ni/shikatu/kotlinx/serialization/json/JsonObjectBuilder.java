package ni.shikatu.kotlinx.serialization.json;

import java.util.LinkedHashMap;
import java.util.Map;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@JsonDslMarker
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\bA¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0007H\u0087\u0080\bJ\n\u0010\u000b\u001a\u00020\fH\u0081\u0080\u0004R\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonObjectBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "content", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "put", "key", "element", "build", "Lni/shikatu/kotlinx/serialization/json/JsonObject;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonObjectBuilder {
    private final Map<String, JsonElement> content = new LinkedHashMap();

    @IgnorableReturnValue
    public final JsonElement put(String key, JsonElement element) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(element, "element");
        return this.content.put(key, element);
    }

    public final JsonObject build() {
        return new JsonObject(this.content);
    }
}
