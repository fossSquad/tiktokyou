package ni.shikatu.kotlinx.serialization.encoding;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0006\u001a\u00020\u0007H§\u0080\u0004J\f\u0010\b\u001a\u0004\u0018\u00010\tH§\u0080\u0004J\n\u0010\n\u001a\u00020\u0007H¦\u0080\u0004J\n\u0010\u000b\u001a\u00020\fH¦\u0080\u0004J\n\u0010\r\u001a\u00020\u000eH¦\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0010H¦\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0012H¦\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0014H¦\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H¦\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0018H¦\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH¦\u0080\u0004J\u0012\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH¦\u0080\u0004J\u0012\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001dH¦\u0080\u0004J\u0012\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001dH¦\u0080\u0004J)\u0010\"\u001a\u0002H#\"\n\b\u0000\u0010#*\u0004\u0018\u00010\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%H\u0096\u0080\u0004¢\u0006\u0002\u0010&J+\u0010'\u001a\u0004\u0018\u0001H#\"\b\b\u0000\u0010#*\u00020\u00012\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H#0%H\u0097\u0080\u0004¢\u0006\u0002\u0010&R\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006(À\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/encoding/Decoder;", _UrlKt.FRAGMENT_ENCODE_SET, "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeNotNullMark", _UrlKt.FRAGMENT_ENCODE_SET, "decodeNull", _UrlKt.FRAGMENT_ENCODE_SET, "decodeBoolean", "decodeByte", _UrlKt.FRAGMENT_ENCODE_SET, "decodeShort", _UrlKt.FRAGMENT_ENCODE_SET, "decodeChar", _UrlKt.FRAGMENT_ENCODE_SET, "decodeInt", _UrlKt.FRAGMENT_ENCODE_SET, "decodeLong", _UrlKt.FRAGMENT_ENCODE_SET, "decodeFloat", _UrlKt.FRAGMENT_ENCODE_SET, "decodeDouble", _UrlKt.FRAGMENT_ENCODE_SET, "decodeString", _UrlKt.FRAGMENT_ENCODE_SET, "decodeEnum", "enumDescriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "decodeInline", "descriptor", "beginStructure", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "decodeSerializableValue", "T", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeNullableSerializableValue", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface Decoder {
    CompositeDecoder beginStructure(SerialDescriptor serialDescriptor);

    boolean decodeBoolean();

    byte decodeByte();

    char decodeChar();

    double decodeDouble();

    int decodeEnum(SerialDescriptor serialDescriptor);

    float decodeFloat();

    Decoder decodeInline(SerialDescriptor serialDescriptor);

    int decodeInt();

    long decodeLong();

    @ExperimentalSerializationApi
    boolean decodeNotNullMark();

    @ExperimentalSerializationApi
    Void decodeNull();

    short decodeShort();

    String decodeString();

    SerializersModule getSerializersModule();

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> T decodeSerializableValue(Decoder decoder, DeserializationStrategy<? extends T> deserializationStrategy) {
            Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
            return (T) Decoder.super.decodeSerializableValue(deserializationStrategy);
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static <T> T decodeNullableSerializableValue(Decoder decoder, DeserializationStrategy<? extends T> deserializationStrategy) {
            Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
            return (T) Decoder.super.decodeNullableSerializableValue(deserializationStrategy);
        }
    }

    default <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return deserializationStrategy.deserialize(this);
    }

    @ExperimentalSerializationApi
    default <T> T decodeNullableSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return (deserializationStrategy.getDescriptor().isNullable() || decodeNotNullMark()) ? (T) decodeSerializableValue(deserializationStrategy) : (T) decodeNull();
    }
}
