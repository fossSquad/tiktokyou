package ni.shikatu.kotlinx.serialization.encoding;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 )2\u00020\u0001:\u0001)J\u0012\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦\u0080\u0004J\n\u0010\n\u001a\u00020\u000bH\u0097\u0080\u0004J\u0012\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH¦\u0080\u0004J\u0012\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0096\u0080\u0004J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH¦\u0080\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH¦\u0080\u0004J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH¦\u0080\u0004J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH¦\u0080\u0004J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH¦\u0080\u0004J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH¦\u0080\u0004J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH¦\u0080\u0004J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH¦\u0080\u0004J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH¦\u0080\u0004J\u001a\u0010 \u001a\u00020!2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\rH¦\u0080\u0004JE\u0010\"\u001a\u0002H#\"\n\b\u0000\u0010#*\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%2\n\b\u0002\u0010&\u001a\u0004\u0018\u0001H#H¦\u0080\u0004¢\u0006\u0002\u0010'JG\u0010(\u001a\u0004\u0018\u0001H#\"\b\b\u0000\u0010#*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\r2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H#0%2\n\b\u0002\u0010&\u001a\u0004\u0018\u0001H#H§\u0080\u0004¢\u0006\u0002\u0010'R\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006*À\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", _UrlKt.FRAGMENT_ENCODE_SET, "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "endStructure", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "decodeSequentially", _UrlKt.FRAGMENT_ENCODE_SET, "decodeElementIndex", _UrlKt.FRAGMENT_ENCODE_SET, "decodeCollectionSize", "decodeBooleanElement", "index", "decodeByteElement", _UrlKt.FRAGMENT_ENCODE_SET, "decodeCharElement", _UrlKt.FRAGMENT_ENCODE_SET, "decodeShortElement", _UrlKt.FRAGMENT_ENCODE_SET, "decodeIntElement", "decodeLongElement", _UrlKt.FRAGMENT_ENCODE_SET, "decodeFloatElement", _UrlKt.FRAGMENT_ENCODE_SET, "decodeDoubleElement", _UrlKt.FRAGMENT_ENCODE_SET, "decodeStringElement", _UrlKt.FRAGMENT_ENCODE_SET, "decodeInlineElement", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "decodeSerializableElement", "T", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "Companion", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface CompositeDecoder {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DECODE_DONE = -1;
    public static final int UNKNOWN_NAME = -3;

    boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int i);

    byte decodeByteElement(SerialDescriptor serialDescriptor, int i);

    char decodeCharElement(SerialDescriptor serialDescriptor, int i);

    double decodeDoubleElement(SerialDescriptor serialDescriptor, int i);

    int decodeElementIndex(SerialDescriptor serialDescriptor);

    float decodeFloatElement(SerialDescriptor serialDescriptor, int i);

    Decoder decodeInlineElement(SerialDescriptor serialDescriptor, int i);

    int decodeIntElement(SerialDescriptor serialDescriptor, int i);

    long decodeLongElement(SerialDescriptor serialDescriptor, int i);

    @ExperimentalSerializationApi
    <T> T decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy<? extends T> deserializationStrategy, T t);

    <T> T decodeSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy<? extends T> deserializationStrategy, T t);

    short decodeShortElement(SerialDescriptor serialDescriptor, int i);

    String decodeStringElement(SerialDescriptor serialDescriptor, int i);

    void endStructure(SerialDescriptor serialDescriptor);

    SerializersModule getSerializersModule();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "DECODE_DONE", _UrlKt.FRAGMENT_ENCODE_SET, "UNKNOWN_NAME", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final  Companion $$INSTANCE = new Companion();
        public static final int DECODE_DONE = -1;
        public static final int UNKNOWN_NAME = -3;

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        @Deprecated
        public static boolean decodeSequentially(CompositeDecoder $this) {
            return CompositeDecoder.super.decodeSequentially();
        }

        @Deprecated
        public static int decodeCollectionSize(CompositeDecoder $this, SerialDescriptor descriptor) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return CompositeDecoder.super.decodeCollectionSize(descriptor);
        }
    }

    @ExperimentalSerializationApi
    default boolean decodeSequentially() {
        return false;
    }

    default int decodeCollectionSize(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return -1;
    }

    static  Object decodeSerializableElement$default(CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return compositeDecoder.decodeSerializableElement(serialDescriptor, i, deserializationStrategy, obj);
    }

    static  Object decodeNullableSerializableElement$default(CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeNullableSerializableElement");
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return compositeDecoder.decodeNullableSerializableElement(serialDescriptor, i, deserializationStrategy, obj);
    }
}
