package ni.shikatu.kotlinx.serialization.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@JsonDslMarker
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\bA¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0087\u0080\bJ\u0018\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0087\u0080\bJ\n\u0010\r\u001a\u00020\u000eH\u0081\u0080\u0004R\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonArrayBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "content", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "add", _UrlKt.FRAGMENT_ENCODE_SET, "element", "addAll", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "build", "Lni/shikatu/kotlinx/serialization/json/JsonArray;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonArrayBuilder {
    private final List<JsonElement> content = new ArrayList();

    @IgnorableReturnValue
    public final boolean add(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.content.add(element);
        return true;
    }

    @IgnorableReturnValue
    @ExperimentalSerializationApi
    public final boolean addAll(Collection<? extends JsonElement> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.content.addAll(collection);
    }

    public final JsonArray build() {
        return new JsonArray(this.content);
    }
}
