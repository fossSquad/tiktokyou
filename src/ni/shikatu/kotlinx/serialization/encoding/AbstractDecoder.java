package ni.shikatu.kotlinx.serialization.encoding;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\b'\u0018\u00002\u00020\u00012\u00020\u0002B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0005\u001a\u00020\u0006H\u0096\u0080\u0004J\n\u0010\u0007\u001a\u00020\bH\u0096\u0080\u0004J\f\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0080\u0004J\n\u0010\u000b\u001a\u00020\bH\u0096\u0080\u0004J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004J\n\u0010\u0018\u001a\u00020\u0019H\u0096\u0080\u0004J\n\u0010\u001a\u001a\u00020\u001bH\u0096\u0080\u0004J\u0012\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0080\u0004J\u0012\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u001eH\u0096\u0080\u0004J5\u0010!\u001a\u0002H\"\"\n\b\u0000\u0010\"*\u0004\u0018\u00010\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$2\n\b\u0002\u0010%\u001a\u0004\u0018\u0001H\"H\u0096\u0080\u0004¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001eH\u0096\u0080\u0004J\u0012\u0010(\u001a\u00020)2\u0006\u0010 \u001a\u00020\u001eH\u0096\u0080\u0004J\u001a\u0010*\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0086\u0080\u0004J\u001a\u0010,\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0086\u0080\u0004J\u001a\u0010-\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0086\u0080\u0004J\u001a\u0010.\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0086\u0080\u0004J\u001a\u0010/\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0086\u0080\u0004J\u001a\u00100\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0086\u0080\u0004J\u001a\u00101\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0086\u0080\u0004J\u001a\u00102\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0086\u0080\u0004J\u001a\u00103\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0086\u0080\u0004J\u001a\u00104\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0011H\u0096\u0080\u0004J=\u00105\u001a\u0002H\"\"\u0004\b\u0000\u0010\"2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00112\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$2\b\u0010%\u001a\u0004\u0018\u0001H\"H\u0096\u0080\u0004¢\u0006\u0002\u00106JE\u00107\u001a\u0004\u0018\u0001H\"\"\b\b\u0000\u0010\"*\u00020\u00062\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u00112\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\"0$2\b\u0010%\u001a\u0004\u0018\u0001H\"H\u0086\u0080\u0004¢\u0006\u0002\u00106¨\u00068"}, d2 = {"Lni/shikatu/kotlinx/serialization/encoding/AbstractDecoder;", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "<init>", "()V", "decodeValue", _UrlKt.FRAGMENT_ENCODE_SET, "decodeNotNullMark", _UrlKt.FRAGMENT_ENCODE_SET, "decodeNull", _UrlKt.FRAGMENT_ENCODE_SET, "decodeBoolean", "decodeByte", _UrlKt.FRAGMENT_ENCODE_SET, "decodeShort", _UrlKt.FRAGMENT_ENCODE_SET, "decodeInt", _UrlKt.FRAGMENT_ENCODE_SET, "decodeLong", _UrlKt.FRAGMENT_ENCODE_SET, "decodeFloat", _UrlKt.FRAGMENT_ENCODE_SET, "decodeDouble", _UrlKt.FRAGMENT_ENCODE_SET, "decodeChar", _UrlKt.FRAGMENT_ENCODE_SET, "decodeString", _UrlKt.FRAGMENT_ENCODE_SET, "decodeEnum", "enumDescriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "decodeInline", "descriptor", "decodeSerializableValue", "T", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "beginStructure", "endStructure", _UrlKt.FRAGMENT_ENCODE_SET, "decodeBooleanElement", "index", "decodeByteElement", "decodeShortElement", "decodeIntElement", "decodeLongElement", "decodeFloatElement", "decodeDoubleElement", "decodeCharElement", "decodeStringElement", "decodeInlineElement", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public abstract class AbstractDecoder implements Decoder, CompositeDecoder {

    public Object decodeValue() {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    @Override
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override
    public Void decodeNull() {
        return null;
    }

    @Override
    public boolean decodeBoolean() {
        Object objDecodeValue = decodeValue();
        Intrinsics.checkNotNull(objDecodeValue, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objDecodeValue).booleanValue();
    }

    @Override
    public byte decodeByte() {
        Object objDecodeValue = decodeValue();
        Intrinsics.checkNotNull(objDecodeValue, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) objDecodeValue).byteValue();
    }

    @Override
    public short decodeShort() {
        Object objDecodeValue = decodeValue();
        Intrinsics.checkNotNull(objDecodeValue, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) objDecodeValue).shortValue();
    }

    @Override
    public int decodeInt() {
        Object objDecodeValue = decodeValue();
        Intrinsics.checkNotNull(objDecodeValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objDecodeValue).intValue();
    }

    @Override
    public long decodeLong() {
        Object objDecodeValue = decodeValue();
        Intrinsics.checkNotNull(objDecodeValue, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) objDecodeValue).longValue();
    }

    @Override
    public float decodeFloat() {
        Object objDecodeValue = decodeValue();
        Intrinsics.checkNotNull(objDecodeValue, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objDecodeValue).floatValue();
    }

    @Override
    public double decodeDouble() {
        Object objDecodeValue = decodeValue();
        Intrinsics.checkNotNull(objDecodeValue, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objDecodeValue).doubleValue();
    }

    @Override
    public char decodeChar() {
        Object objDecodeValue = decodeValue();
        Intrinsics.checkNotNull(objDecodeValue, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objDecodeValue).charValue();
    }

    @Override
    public String decodeString() {
        Object objDecodeValue = decodeValue();
        Intrinsics.checkNotNull(objDecodeValue, "null cannot be cast to non-null type kotlin.String");
        return (String) objDecodeValue;
    }

    @Override
    public int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        Object objDecodeValue = decodeValue();
        Intrinsics.checkNotNull(objDecodeValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objDecodeValue).intValue();
    }

    @Override
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    public static  Object decodeSerializableValue$default(AbstractDecoder abstractDecoder, DeserializationStrategy deserializationStrategy, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableValue");
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        return abstractDecoder.decodeSerializableValue(deserializationStrategy, obj);
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return (T) decodeSerializableValue(deserializationStrategy);
    }

    @Override
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override
    public final boolean decodeBooleanElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeBoolean();
    }

    @Override
    public final byte decodeByteElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeByte();
    }

    @Override
    public final short decodeShortElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeShort();
    }

    @Override
    public final int decodeIntElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeInt();
    }

    @Override
    public final long decodeLongElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeLong();
    }

    @Override
    public final float decodeFloatElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeFloat();
    }

    @Override
    public final double decodeDoubleElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeDouble();
    }

    @Override
    public final char decodeCharElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeChar();
    }

    @Override
    public final String decodeStringElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeString();
    }

    @Override
    public Decoder decodeInlineElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return decodeInline(descriptor.getElementDescriptor(index));
    }

    @Override
    public <T> T decodeSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy<? extends T> deserializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return (T) decodeSerializableValue(deserializationStrategy, t);
    }

    @Override
    public final <T> T decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy<? extends T> deserializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        AbstractDecoder abstractDecoder = this;
        return (deserializationStrategy.getDescriptor().isNullable() || abstractDecoder.decodeNotNullMark()) ? (T) decodeSerializableValue(deserializationStrategy, t) : (T) abstractDecoder.decodeNull();
    }
}
