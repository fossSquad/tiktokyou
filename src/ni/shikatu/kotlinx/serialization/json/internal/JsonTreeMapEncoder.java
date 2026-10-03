package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonArraySerializer;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonObjectSerializer;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B%\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0006H\u0096\u0080\u0004R\u000f\u0010\n\u001a\u00020\u000bX\u0082®\b¢\u0006\u0002\n\u0000R\u000f\u0010\f\u001a\u00020\rX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonTreeMapEncoder;", "Lni/shikatu/kotlinx/serialization/json/internal/JsonTreeEncoder;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "nodeConsumer", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "tag", _UrlKt.FRAGMENT_ENCODE_SET, "isKey", _UrlKt.FRAGMENT_ENCODE_SET, "putElement", "key", "element", "getCurrent", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class JsonTreeMapEncoder extends JsonTreeEncoder {
    private boolean isKey;
    private String tag;

    public JsonTreeMapEncoder(Json json, Function1<? super JsonElement, Unit> function1) {
        super(json, function1);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(function1, "nodeConsumer");
        this.isKey = true;
    }

    @Override
    public void putElement(String key, JsonElement element) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(element, "element");
        if (this.isKey) {
            if (element instanceof JsonPrimitive) {
                this.tag = ((JsonPrimitive) element).getContent();
                this.isKey = false;
                return;
            } else {
                if (element instanceof JsonObject) {
                    throw JsonExceptionsKt.InvalidKeyKindException(JsonObjectSerializer.INSTANCE.getDescriptor());
                }
                if (!(element instanceof JsonArray)) {
                    throw new NoWhenBranchMatchedException();
                }
                throw JsonExceptionsKt.InvalidKeyKindException(JsonArraySerializer.INSTANCE.getDescriptor());
            }
        }
        Map<String, JsonElement> content = getContent();
        String str = this.tag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tag");
            str = null;
        }
        content.put(str, element);
        this.isKey = true;
    }

    @Override
    public JsonElement getCurrent() {
        return new JsonObject(getContent());
    }
}
