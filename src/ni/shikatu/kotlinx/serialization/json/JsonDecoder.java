package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0007\u001a\u00020\bH¦\u0080\u0004R\u0013\u0010\u0003\u001a\u00020\u0004X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonDecoder;", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "decodeJsonElement", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface JsonDecoder extends Decoder, CompositeDecoder {
    JsonElement decodeJsonElement();

    Json getJson();

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static int decodeCollectionSize(JsonDecoder $this, SerialDescriptor descriptor) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return $this.decodeCollectionSize(descriptor);
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static <T> T decodeNullableSerializableValue(JsonDecoder $this, DeserializationStrategy<? extends T> deserializationStrategy) {
            Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
            return (T) $this.decodeNullableSerializableValue(deserializationStrategy);
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static boolean decodeSequentially(JsonDecoder $this) {
            return $this.decodeSequentially();
        }

        @Deprecated
        public static <T> T decodeSerializableValue(JsonDecoder $this, DeserializationStrategy<? extends T> deserializationStrategy) {
            Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
            return (T) $this.decodeSerializableValue(deserializationStrategy);
        }
    }
}
