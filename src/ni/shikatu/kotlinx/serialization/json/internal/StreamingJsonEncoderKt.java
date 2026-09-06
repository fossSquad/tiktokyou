package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.json.JsonElementKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u0019\u0010\u0003\u001a\u00020\u0004*\u00020\u00028@X\u0080\u0084\b¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\"\u0019\u0010\u0006\u001a\u00020\u0004*\u00020\u00028@X\u0080\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"unsignedNumberDescriptors", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "isUnsignedNumber", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "isUnquotedLiteral", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StreamingJsonEncoderKt {
    private static final Set<SerialDescriptor> unsignedNumberDescriptors = SetsKt.setOf((Object[]) new SerialDescriptor[]{BuiltinSerializersKt.serializer(UInt.Companion).getDescriptor(), BuiltinSerializersKt.serializer(ULong.Companion).getDescriptor(), BuiltinSerializersKt.serializer(UByte.Companion).getDescriptor(), BuiltinSerializersKt.serializer(UShort.Companion).getDescriptor()});

    public static final boolean isUnsignedNumber(SerialDescriptor $this$isUnsignedNumber) {
        Intrinsics.checkNotNullParameter($this$isUnsignedNumber, "<this>");
        return $this$isUnsignedNumber.isInline() && unsignedNumberDescriptors.contains($this$isUnsignedNumber);
    }

    public static final boolean isUnquotedLiteral(SerialDescriptor $this$isUnquotedLiteral) {
        Intrinsics.checkNotNullParameter($this$isUnquotedLiteral, "<this>");
        return $this$isUnquotedLiteral.isInline() && Intrinsics.areEqual($this$isUnquotedLiteral, JsonElementKt.getJsonUnquotedLiteralDescriptor());
    }
}
