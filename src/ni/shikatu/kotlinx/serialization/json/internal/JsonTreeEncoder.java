package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B%\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0096\u0080\u0004JA\u0010\u0012\u001a\u00020\u0007\"\b\b\u0000\u0010\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00130\u001a2\b\u0010\u001b\u001a\u0004\u0018\u0001H\u0013H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001cJ\n\u0010\u001d\u001a\u00020\u0006H\u0096\u0080\u0004R!\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000bX\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonTreeEncoder;", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "nodeConsumer", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "content", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getContent", "()Ljava/util/Map;", "putElement", "key", "element", "encodeNullableSerializableElement", "T", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "getCurrent", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
class JsonTreeEncoder extends AbstractJsonTreeEncoder {
    private final Map<String, JsonElement> content;

    public JsonTreeEncoder(Json json, Function1<? super JsonElement, Unit> function1) {
        super(json, function1, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(function1, "nodeConsumer");
        this.content = new LinkedHashMap();
    }

    protected final Map<String, JsonElement> getContent() {
        return this.content;
    }

    @Override
    public void putElement(String key, JsonElement element) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(element, "element");
        this.content.put(key, element);
    }

    @Override
    public <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (t != null || this.configuration.getExplicitNulls()) {
            super.encodeNullableSerializableElement(descriptor, index, serializationStrategy, t);
        }
    }

    @Override
    public JsonElement getCurrent() {
        return new JsonObject(this.content);
    }
}
