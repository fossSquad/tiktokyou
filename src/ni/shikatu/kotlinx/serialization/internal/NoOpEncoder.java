package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.AbstractEncoder;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.kotlinx.serialization.modules.SerializersModuleBuildersKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\f\u001a\u00020\tH\u0096\u0080\u0004J\u0012\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0096\u0080\u0004J\u0012\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0096\u0080\u0004J\u0012\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0012H\u0096\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0014H\u0096\u0080\u0004J\u0012\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0016H\u0096\u0080\u0004J\u0012\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0018H\u0096\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001aH\u0096\u0080\u0004J\u0012\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001cH\u0096\u0080\u0004J\u0012\u0010\u001d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001eH\u0096\u0080\u0004J\u001a\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0096\u0080\u0004R\u0015\u0010\u0004\u001a\u00020\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006#"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/NoOpEncoder;", "Lni/shikatu/kotlinx/serialization/encoding/AbstractEncoder;", "<init>", "()V", "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeValue", _UrlKt.FRAGMENT_ENCODE_SET, "value", _UrlKt.FRAGMENT_ENCODE_SET, "encodeNull", "encodeBoolean", _UrlKt.FRAGMENT_ENCODE_SET, "encodeByte", _UrlKt.FRAGMENT_ENCODE_SET, "encodeShort", _UrlKt.FRAGMENT_ENCODE_SET, "encodeInt", _UrlKt.FRAGMENT_ENCODE_SET, "encodeLong", _UrlKt.FRAGMENT_ENCODE_SET, "encodeFloat", _UrlKt.FRAGMENT_ENCODE_SET, "encodeDouble", _UrlKt.FRAGMENT_ENCODE_SET, "encodeChar", _UrlKt.FRAGMENT_ENCODE_SET, "encodeString", _UrlKt.FRAGMENT_ENCODE_SET, "encodeEnum", "enumDescriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "index", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NoOpEncoder extends AbstractEncoder {
    public static final NoOpEncoder INSTANCE = new NoOpEncoder();
    private static final SerializersModule serializersModule = SerializersModuleBuildersKt.EmptySerializersModule();

    private NoOpEncoder() {
    }

    @Override
    public SerializersModule getSerializersModule() {
        return serializersModule;
    }

    @Override
    public void encodeValue(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override
    public void encodeNull() {
    }

    @Override
    public void encodeBoolean(boolean value) {
    }

    @Override
    public void encodeByte(byte value) {
    }

    @Override
    public void encodeShort(short value) {
    }

    @Override
    public void encodeInt(int value) {
    }

    @Override
    public void encodeLong(long value) {
    }

    @Override
    public void encodeFloat(float value) {
    }

    @Override
    public void encodeDouble(double value) {
    }

    @Override
    public void encodeChar(char value) {
    }

    @Override
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override
    public void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
    }
}
