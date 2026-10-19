package ni.shikatu.kotlinx.serialization.encoding;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.internal.NoOpEncoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u00012\u00020\u0002B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0080\u0004J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0080\u0004J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\u0012\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\tH\u0096\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0014H\u0096\u0080\u0004J\u0012\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0016H\u0096\u0080\u0004J\u0012\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\rH\u0096\u0080\u0004J\u0012\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0019H\u0096\u0080\u0004J\u0012\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001bH\u0096\u0080\u0004J\u0012\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001dH\u0096\u0080\u0004J\u0012\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u001fH\u0096\u0080\u0004J\u0012\u0010 \u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020!H\u0096\u0080\u0004J\u001a\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\u0012\u0010$\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0080\u0004J\"\u0010%\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0086\u0080\u0004J\"\u0010&\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0014H\u0086\u0080\u0004J\"\u0010'\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0016H\u0086\u0080\u0004J\"\u0010(\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0086\u0080\u0004J\"\u0010)\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0019H\u0086\u0080\u0004J\"\u0010*\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001bH\u0086\u0080\u0004J\"\u0010+\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001dH\u0086\u0080\u0004J\"\u0010,\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001fH\u0086\u0080\u0004J\"\u0010-\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020!H\u0086\u0080\u0004J\u001a\u0010.\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0086\u0080\u0004JA\u0010/\u001a\u00020\t\"\n\b\u0000\u00100*\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H0022\u0006\u0010\u000f\u001a\u0002H0H\u0096\u0080\u0004¢\u0006\u0002\u00103JA\u00104\u001a\u00020\t\"\b\b\u0000\u00100*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H0022\b\u0010\u000f\u001a\u0004\u0018\u0001H0H\u0096\u0080\u0004¢\u0006\u0002\u00103¨\u00065"}, d2 = {"Lni/shikatu/kotlinx/serialization/encoding/AbstractEncoder;", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", "<init>", "()V", "beginStructure", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "endStructure", _UrlKt.FRAGMENT_ENCODE_SET, "encodeElement", _UrlKt.FRAGMENT_ENCODE_SET, "index", _UrlKt.FRAGMENT_ENCODE_SET, "encodeValue", "value", _UrlKt.FRAGMENT_ENCODE_SET, "encodeNull", "encodeBoolean", "encodeByte", _UrlKt.FRAGMENT_ENCODE_SET, "encodeShort", _UrlKt.FRAGMENT_ENCODE_SET, "encodeInt", "encodeLong", _UrlKt.FRAGMENT_ENCODE_SET, "encodeFloat", _UrlKt.FRAGMENT_ENCODE_SET, "encodeDouble", _UrlKt.FRAGMENT_ENCODE_SET, "encodeChar", _UrlKt.FRAGMENT_ENCODE_SET, "encodeString", _UrlKt.FRAGMENT_ENCODE_SET, "encodeEnum", "enumDescriptor", "encodeInline", "encodeBooleanElement", "encodeByteElement", "encodeShortElement", "encodeIntElement", "encodeLongElement", "encodeFloatElement", "encodeDoubleElement", "encodeCharElement", "encodeStringElement", "encodeInlineElement", "encodeSerializableElement", "T", "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public abstract class AbstractEncoder implements Encoder, CompositeEncoder {
    @Override
    public /* bridge */ CompositeEncoder beginCollection(SerialDescriptor descriptor, int collectionSize) {
        return super.beginCollection(descriptor, collectionSize);
    }

    @Override
    @ExperimentalSerializationApi
    public /* bridge */ void encodeNotNullMark() {
        super.encodeNotNullMark();
    }

    @Override
    @ExperimentalSerializationApi
    public /* bridge */ <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        super.encodeNullableSerializableValue(serializationStrategy, t);
    }

    @Override
    public /* bridge */ <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        super.encodeSerializableValue(serializationStrategy, t);
    }

    @Override
    @ExperimentalSerializationApi
    public /* bridge */ boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        return super.shouldEncodeElementDefault(descriptor, index);
    }

    @Override
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    public boolean encodeElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return true;
    }

    public void encodeValue(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(value.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    @Override
    public void encodeNull() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override
    public void encodeBoolean(boolean value) {
        encodeValue(Boolean.valueOf(value));
    }

    @Override
    public void encodeByte(byte value) {
        encodeValue(Byte.valueOf(value));
    }

    @Override
    public void encodeShort(short value) {
        encodeValue(Short.valueOf(value));
    }

    @Override
    public void encodeInt(int value) {
        encodeValue(Integer.valueOf(value));
    }

    @Override
    public void encodeLong(long value) {
        encodeValue(Long.valueOf(value));
    }

    @Override
    public void encodeFloat(float value) {
        encodeValue(Float.valueOf(value));
    }

    @Override
    public void encodeDouble(double value) {
        encodeValue(Double.valueOf(value));
    }

    @Override
    public void encodeChar(char value) {
        encodeValue(Character.valueOf(value));
    }

    @Override
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeValue(value);
    }

    @Override
    public void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeValue(Integer.valueOf(index));
    }

    @Override
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override
    public final void encodeBooleanElement(SerialDescriptor descriptor, int index, boolean value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeBoolean(value);
        }
    }

    @Override
    public final void encodeByteElement(SerialDescriptor descriptor, int index, byte value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeByte(value);
        }
    }

    @Override
    public final void encodeShortElement(SerialDescriptor descriptor, int index, short value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeShort(value);
        }
    }

    @Override
    public final void encodeIntElement(SerialDescriptor descriptor, int index, int value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeInt(value);
        }
    }

    @Override
    public final void encodeLongElement(SerialDescriptor descriptor, int index, long value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeLong(value);
        }
    }

    @Override
    public final void encodeFloatElement(SerialDescriptor descriptor, int index, float value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeFloat(value);
        }
    }

    @Override
    public final void encodeDoubleElement(SerialDescriptor descriptor, int index, double value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeDouble(value);
        }
    }

    @Override
    public final void encodeCharElement(SerialDescriptor descriptor, int index, char value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, index)) {
            encodeChar(value);
        }
    }

    @Override
    public final void encodeStringElement(SerialDescriptor descriptor, int index, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        if (encodeElement(descriptor, index)) {
            encodeString(value);
        }
    }

    @Override
    public final Encoder encodeInlineElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeElement(descriptor, index) ? encodeInline(descriptor.getElementDescriptor(index)) : NoOpEncoder.INSTANCE;
    }

    @Override
    public <T> void encodeSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (encodeElement(descriptor, index)) {
            encodeSerializableValue(serializationStrategy, t);
        }
    }

    @Override
    public <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (encodeElement(descriptor, index)) {
            encodeNullableSerializableValue(serializationStrategy, t);
        }
    }
}
