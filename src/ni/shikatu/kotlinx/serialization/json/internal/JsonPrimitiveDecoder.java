package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B%\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\u0012\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0094\u0080\u0004R\u0015\u0010\u0004\u001a\u00020\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "value", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "polymorphicDiscriminator", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)V", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "decodeElementIndex", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "currentElement", "tag", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class JsonPrimitiveDecoder extends AbstractJsonTreeDecoder {
    private final JsonElement value;

    public JsonPrimitiveDecoder(Json json, JsonElement value, String polymorphicDiscriminator) {
        super(json, value, polymorphicDiscriminator, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        pushTag(TreeJsonEncoderKt.PRIMITIVE_TAG);
    }

    public  JsonPrimitiveDecoder(Json json, JsonElement jsonElement, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonElement, (i & 4) != 0 ? null : str);
    }

    @Override
    public JsonElement getValue() {
        return this.value;
    }

    @Override
    public int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return 0;
    }

    @Override
    public JsonElement currentElement(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (tag == TreeJsonEncoderKt.PRIMITIVE_TAG) {
            return getValue();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
    }
}
