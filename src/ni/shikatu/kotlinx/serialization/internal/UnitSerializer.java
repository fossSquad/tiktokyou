package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0081\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0081\u0004¢\u0006\u0002\u0010\fR\u0013\u0010\r\u001a\u00020\u000eX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/UnitSerializer;", "Lni/shikatu/kotlinx/serialization/KSerializer;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "serialize", "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Lkotlin/Unit;)V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnitSerializer implements KSerializer<Unit> {
    public static final UnitSerializer INSTANCE = new UnitSerializer();
    private final  ObjectSerializer<Unit> $$delegate_0 = new ObjectSerializer<>("ni.shikatu.kotlin.Unit", Unit.INSTANCE);

    public void m1579deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        this.$$delegate_0.deserialize(decoder);
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return this.$$delegate_0.getDescriptor();
    }

    @Override
    public void serialize(Encoder encoder, Unit unit) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(unit, "value");
        this.$$delegate_0.serialize(encoder, unit);
    }

    private UnitSerializer() {
    }

    @Override
    public /* bridge */  Object deserialize(Decoder decoder) {
        m1579deserialize(decoder);
        return Unit.INSTANCE;
    }
}
