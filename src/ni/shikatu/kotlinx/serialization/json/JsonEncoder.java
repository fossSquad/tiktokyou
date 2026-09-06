package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦\u0080\u0004R\u0013\u0010\u0003\u001a\u00020\u0004X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonEncoder;", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "encodeJsonElement", _UrlKt.FRAGMENT_ENCODE_SET, "element", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface JsonEncoder extends Encoder, CompositeEncoder {
    void encodeJsonElement(JsonElement jsonElement);

    Json getJson();

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static CompositeEncoder beginCollection(JsonEncoder $this, SerialDescriptor descriptor, int collectionSize) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return JsonEncoder.super.beginCollection(descriptor, collectionSize);
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static void encodeNotNullMark(JsonEncoder $this) {
            JsonEncoder.super.encodeNotNullMark();
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static <T> void encodeNullableSerializableValue(JsonEncoder $this, SerializationStrategy<? super T> serializationStrategy, T t) {
            Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
            JsonEncoder.super.encodeNullableSerializableValue(serializationStrategy, t);
        }

        @Deprecated
        public static <T> void encodeSerializableValue(JsonEncoder $this, SerializationStrategy<? super T> serializationStrategy, T t) {
            Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
            JsonEncoder.super.encodeSerializableValue(serializationStrategy, t);
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static boolean shouldEncodeElementDefault(JsonEncoder $this, SerialDescriptor descriptor, int index) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return JsonEncoder.super.shouldEncodeElementDefault(descriptor, index);
        }
    }
}
