package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\bB¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\t*\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u0005*\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0094\u0080\u0004J)\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\tH\u0094\u0080\u0004¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/UByteArraySerializer;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlin/UByteArray;", "Lni/shikatu/kotlinx/serialization/internal/PrimitiveArraySerializer;", "Lni/shikatu/kotlin/UByte;", "Lni/shikatu/kotlinx/serialization/internal/UByteArrayBuilder;", "<init>", "()V", "collectionSize", _UrlKt.FRAGMENT_ENCODE_SET, "collectionSize-GBYM_sE", "([B)I", "toBuilder", "toBuilder-GBYM_sE", "([B)Lkotlinx/serialization/internal/UByteArrayBuilder;", "empty", "empty-TcUX1vc", "()[B", "readElement", _UrlKt.FRAGMENT_ENCODE_SET, "decoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "checkIndex", _UrlKt.FRAGMENT_ENCODE_SET, "writeContent", "encoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "writeContent-Coi6ktg", "(Lkotlinx/serialization/encoding/CompositeEncoder;[BI)V", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public final class UByteArraySerializer extends PrimitiveArraySerializer<UByte, UByteArray, UByteArrayBuilder> implements KSerializer<UByteArray> {
    public static final UByteArraySerializer INSTANCE = new UByteArraySerializer();

    private UByteArraySerializer() {
        super(BuiltinSerializersKt.serializer(UByte.Companion));
    }

    @Override
    public /* bridge */  int collectionSize(Object $this$collectionSize) {
        return m1549collectionSizeGBYM_sE(((UByteArray) $this$collectionSize).m91unboximpl());
    }

    @Override
    public /* bridge */  UByteArray empty() {
        return UByteArray.m75boximpl(m1550emptyTcUX1vc());
    }

    @Override
    public /* bridge */  Object toBuilder(Object $this$toBuilder) {
        return m1551toBuilderGBYM_sE(((UByteArray) $this$toBuilder).m91unboximpl());
    }

    @Override
    public /* bridge */  void writeContent(CompositeEncoder encoder, UByteArray uByteArray, int size) {
        m1552writeContentCoi6ktg(encoder, uByteArray.m91unboximpl(), size);
    }

    protected int m1549collectionSizeGBYM_sE(byte[] $this$collectionSize_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$collectionSize_u2dGBYM_sE, "$this$collectionSize");
        return UByteArray.m83getSizeimpl($this$collectionSize_u2dGBYM_sE);
    }

    protected UByteArrayBuilder m1551toBuilderGBYM_sE(byte[] $this$toBuilder_u2dGBYM_sE) {
        Intrinsics.checkNotNullParameter($this$toBuilder_u2dGBYM_sE, "$this$toBuilder");
        return new UByteArrayBuilder($this$toBuilder_u2dGBYM_sE, null);
    }

    protected byte[] m1550emptyTcUX1vc() {
        return UByteArray.m76constructorimpl(0);
    }

    @Override
    public void readElement(CompositeDecoder decoder, int index, UByteArrayBuilder builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.m1547append7apg3OU$kotlinx_serialization_core(UByte.m24constructorimpl(decoder.decodeInlineElement(getDescriptor(), index).decodeByte()));
    }

    protected void m1552writeContentCoi6ktg(CompositeEncoder encoder, byte[] content, int size) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i = 0; i < size; i++) {
            encoder.encodeInlineElement(getDescriptor(), i).encodeByte(UByteArray.m82getw2LRezQ(content, i));
        }
    }
}
