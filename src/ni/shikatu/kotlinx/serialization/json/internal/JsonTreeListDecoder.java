package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0094\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0094\u0080\u0004J\u0012\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004R\u0015\u0010\u0004\u001a\u00020\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000f\u0010\n\u001a\u00020\u000bX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\f\u001a\u00020\u000bX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonTreeListDecoder;", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "value", "Lni/shikatu/kotlinx/serialization/json/JsonArray;", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonArray;)V", "getValue", "()Lkotlinx/serialization/json/JsonArray;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "currentIndex", "elementName", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "index", "currentElement", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "tag", "decodeElementIndex", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class JsonTreeListDecoder extends AbstractJsonTreeDecoder {
    private int currentIndex;
    private final int size;
    private final JsonArray value;

    public JsonTreeListDecoder(Json json, JsonArray value) {
        super(json, value, null, 4, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.size = getValue().size();
        this.currentIndex = -1;
    }

    @Override
    public JsonArray getValue() {
        return this.value;
    }

    @Override
    protected String elementName(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return String.valueOf(index);
    }

    @Override
    public JsonElement currentElement(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return getValue().get(Integer.parseInt(tag));
    }

    @Override
    public int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.currentIndex < this.size - 1) {
            this.currentIndex++;
            return this.currentIndex;
        }
        return -1;
    }
}
