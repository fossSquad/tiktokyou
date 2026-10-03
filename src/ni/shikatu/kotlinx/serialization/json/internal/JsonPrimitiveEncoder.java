package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B%\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0006H\u0096\u0080\u0004R\u0011\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonPrimitiveEncoder;", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "nodeConsumer", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "content", "putElement", "key", _UrlKt.FRAGMENT_ENCODE_SET, "element", "getCurrent", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class JsonPrimitiveEncoder extends AbstractJsonTreeEncoder {
    private JsonElement content;

    public JsonPrimitiveEncoder(Json json, Function1<? super JsonElement, Unit> function1) {
        super(json, function1, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(function1, "nodeConsumer");
        pushTag(TreeJsonEncoderKt.PRIMITIVE_TAG);
    }

    @Override
    public void putElement(String key, JsonElement element) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(element, "element");
        if (!(key == TreeJsonEncoderKt.PRIMITIVE_TAG)) {
            throw new IllegalArgumentException("This output can only consume primitives with 'primitive' tag".toString());
        }
        if (!(this.content == null)) {
            throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?".toString());
        }
        this.content = element;
        getNodeConsumer().invoke(element);
    }

    @Override
    public JsonElement getCurrent() {
        JsonElement jsonElement = this.content;
        if (jsonElement != null) {
            return jsonElement;
        }
        throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?".toString());
    }
}
