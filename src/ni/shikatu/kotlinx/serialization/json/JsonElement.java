package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.Serializable;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\bD¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonElement;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "Companion", "Lni/shikatu/kotlinx/serialization/json/JsonArray;", "Lni/shikatu/kotlinx/serialization/json/JsonObject;", "Lni/shikatu/kotlinx/serialization/json/JsonPrimitive;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = JsonElementSerializer.class)
public abstract class JsonElement {
    public static final Companion Companion = new Companion(null);

    public  JsonElement(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonElement$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<JsonElement> serializer() {
            return JsonElementSerializer.INSTANCE;
        }
    }

    private JsonElement() {
    }
}
