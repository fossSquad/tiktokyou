package ni.shikatu.kotlinx.serialization.encoding;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦\u0080\u0004J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0097\u0080\u0004J\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH¦\u0080\u0004J\"\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0011H¦\u0080\u0004J\"\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0013H¦\u0080\u0004J\"\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0015H¦\u0080\u0004J\"\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH¦\u0080\u0004J\"\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0018H¦\u0080\u0004J\"\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001aH¦\u0080\u0004J\"\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001cH¦\u0080\u0004J\"\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001eH¦\u0080\u0004J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH¦\u0080\u0004JA\u0010!\u001a\u00020\u0007\"\n\b\u0000\u0010\"*\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$2\u0006\u0010\u000f\u001a\u0002H\"H¦\u0080\u0004¢\u0006\u0002\u0010%JA\u0010&\u001a\u00020\u0007\"\b\b\u0000\u0010\"*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$2\b\u0010\u000f\u001a\u0004\u0018\u0001H\"H§\u0080\u0004¢\u0006\u0002\u0010%R\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006'À\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", _UrlKt.FRAGMENT_ENCODE_SET, "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "endStructure", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "shouldEncodeElementDefault", _UrlKt.FRAGMENT_ENCODE_SET, "index", _UrlKt.FRAGMENT_ENCODE_SET, "encodeBooleanElement", "value", "encodeByteElement", _UrlKt.FRAGMENT_ENCODE_SET, "encodeShortElement", _UrlKt.FRAGMENT_ENCODE_SET, "encodeCharElement", _UrlKt.FRAGMENT_ENCODE_SET, "encodeIntElement", "encodeLongElement", _UrlKt.FRAGMENT_ENCODE_SET, "encodeFloatElement", _UrlKt.FRAGMENT_ENCODE_SET, "encodeDoubleElement", _UrlKt.FRAGMENT_ENCODE_SET, "encodeStringElement", _UrlKt.FRAGMENT_ENCODE_SET, "encodeInlineElement", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "encodeSerializableElement", "T", "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface CompositeEncoder {
    void encodeBooleanElement(SerialDescriptor serialDescriptor, int i, boolean z);

    void encodeByteElement(SerialDescriptor serialDescriptor, int i, byte b);

    void encodeCharElement(SerialDescriptor serialDescriptor, int i, char c);

    void encodeDoubleElement(SerialDescriptor serialDescriptor, int i, double d);

    void encodeFloatElement(SerialDescriptor serialDescriptor, int i, float f);

    Encoder encodeInlineElement(SerialDescriptor serialDescriptor, int i);

    void encodeIntElement(SerialDescriptor serialDescriptor, int i, int i2);

    void encodeLongElement(SerialDescriptor serialDescriptor, int i, long j);

    @ExperimentalSerializationApi
    <T> void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy<? super T> serializationStrategy, T t);

    <T> void encodeSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy<? super T> serializationStrategy, T t);

    void encodeShortElement(SerialDescriptor serialDescriptor, int i, short s);

    void encodeStringElement(SerialDescriptor serialDescriptor, int i, String str);

    void endStructure(SerialDescriptor serialDescriptor);

    SerializersModule getSerializersModule();

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        @Deprecated
        public static boolean shouldEncodeElementDefault(CompositeEncoder $this, SerialDescriptor descriptor, int index) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return $this.shouldEncodeElementDefault(descriptor, index);
        }
    }

    @ExperimentalSerializationApi
    default boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return true;
    }
}
