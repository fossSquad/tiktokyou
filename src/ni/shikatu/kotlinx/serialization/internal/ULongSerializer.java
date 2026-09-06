package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ULongSerializer;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlin/ULong;", "<init>", "()V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "serialize-2TYgG_w", "(Lkotlinx/serialization/encoding/Encoder;J)V", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "deserialize-I7RO_PI", "(Lkotlinx/serialization/encoding/Decoder;)J", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ULongSerializer implements KSerializer<ULong> {
    public static final ULongSerializer INSTANCE = new ULongSerializer();
    private static final SerialDescriptor descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("ni.shikatu.kotlin.ULong", BuiltinSerializersKt.serializer(LongCompanionObject.INSTANCE));

    private ULongSerializer() {
    }

    @Override
    public /* bridge */  Object deserialize(Decoder decoder) {
        return ULong.m174boximpl(m1569deserializeI7RO_PI(decoder));
    }

    @Override
    public /* bridge */  void serialize(Encoder encoder, Object value) {
        m1570serialize2TYgG_w(encoder, ((ULong) value).m232unboximpl());
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void m1570serialize2TYgG_w(Encoder encoder, long value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeInline(getDescriptor()).encodeLong(value);
    }

    public long m1569deserializeI7RO_PI(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return ULong.m180constructorimpl(decoder.decodeInline(getDescriptor()).decodeLong());
    }
}
