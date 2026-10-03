package ni.shikatu.kotlinx.serialization.encoding;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0006\u001a\u00020\u0007H\u0097\u0080\u0004J\n\u0010\b\u001a\u00020\u0007H§\u0080\u0004J\u0012\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH¦\u0080\u0004J\u0012\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\rH¦\u0080\u0004J\u0012\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000fH¦\u0080\u0004J\u0012\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0011H¦\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0013H¦\u0080\u0004J\u0012\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0015H¦\u0080\u0004J\u0012\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0017H¦\u0080\u0004J\u0012\u0010\u0018\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0019H¦\u0080\u0004J\u0012\u0010\u001a\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u001bH¦\u0080\u0004J\u001a\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013H¦\u0080\u0004J\u0012\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u001eH¦\u0080\u0004J\u0012\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u001eH¦\u0080\u0004J\u001a\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0013H\u0096\u0080\u0004J1\u0010&\u001a\u00020\u0007\"\n\b\u0000\u0010'*\u0004\u0018\u00010\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010\n\u001a\u0002H'H\u0096\u0080\u0004¢\u0006\u0002\u0010*J1\u0010+\u001a\u00020\u0007\"\b\b\u0000\u0010'*\u00020\u00012\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\b\u0010\n\u001a\u0004\u0018\u0001H'H\u0097\u0080\u0004¢\u0006\u0002\u0010*R\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006,À\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/encoding/Encoder;", _UrlKt.FRAGMENT_ENCODE_SET, "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeNotNullMark", _UrlKt.FRAGMENT_ENCODE_SET, "encodeNull", "encodeBoolean", "value", _UrlKt.FRAGMENT_ENCODE_SET, "encodeByte", _UrlKt.FRAGMENT_ENCODE_SET, "encodeShort", _UrlKt.FRAGMENT_ENCODE_SET, "encodeChar", _UrlKt.FRAGMENT_ENCODE_SET, "encodeInt", _UrlKt.FRAGMENT_ENCODE_SET, "encodeLong", _UrlKt.FRAGMENT_ENCODE_SET, "encodeFloat", _UrlKt.FRAGMENT_ENCODE_SET, "encodeDouble", _UrlKt.FRAGMENT_ENCODE_SET, "encodeString", _UrlKt.FRAGMENT_ENCODE_SET, "encodeEnum", "enumDescriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "index", "encodeInline", "descriptor", "beginStructure", "Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", "beginCollection", "collectionSize", "encodeSerializableValue", "T", "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableValue", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface Encoder {
    CompositeEncoder beginStructure(SerialDescriptor serialDescriptor);

    void encodeBoolean(boolean z);

    void encodeByte(byte b);

    void encodeChar(char c);

    void encodeDouble(double d);

    void encodeEnum(SerialDescriptor serialDescriptor, int i);

    void encodeFloat(float f);

    Encoder encodeInline(SerialDescriptor serialDescriptor);

    void encodeInt(int i);

    void encodeLong(long j);

    @ExperimentalSerializationApi
    void encodeNull();

    void encodeShort(short s);

    void encodeString(String str);

    SerializersModule getSerializersModule();

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        @Deprecated
        public static void encodeNotNullMark(Encoder $this) {
            $this.encodeNotNullMark();
        }

        @Deprecated
        public static CompositeEncoder beginCollection(Encoder $this, SerialDescriptor descriptor, int collectionSize) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return $this.beginCollection(descriptor, collectionSize);
        }

        @Deprecated
        public static <T> void encodeSerializableValue(Encoder $this, SerializationStrategy<? super T> serializationStrategy, T t) {
            Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
            $this.encodeSerializableValue(serializationStrategy, t);
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static <T> void encodeNullableSerializableValue(Encoder $this, SerializationStrategy<? super T> serializationStrategy, T t) {
            Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
            $this.encodeNullableSerializableValue(serializationStrategy, t);
        }
    }

    @ExperimentalSerializationApi
    default void encodeNotNullMark() {
    }

    default CompositeEncoder beginCollection(SerialDescriptor descriptor, int collectionSize) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return beginStructure(descriptor);
    }

    default <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        serializationStrategy.serialize(this, t);
    }

    @ExperimentalSerializationApi
    default <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        boolean isNullabilitySupported = serializationStrategy.getDescriptor().isNullable();
        if (isNullabilitySupported) {
            encodeSerializableValue(serializationStrategy, t);
        } else if (t == null) {
            encodeNull();
        } else {
            encodeNotNullMark();
            encodeSerializableValue(serializationStrategy, t);
        }
    }
}
