package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.ULongArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\bB¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\t*\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u0005*\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0094\u0080\u0004J)\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\tH\u0094\u0080\u0004¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ULongArraySerializer;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlin/ULongArray;", "Lni/shikatu/kotlinx/serialization/internal/PrimitiveArraySerializer;", "Lni/shikatu/kotlin/ULong;", "Lni/shikatu/kotlinx/serialization/internal/ULongArrayBuilder;", "<init>", "()V", "collectionSize", _UrlKt.FRAGMENT_ENCODE_SET, "collectionSize-QwZRm1k", "([J)I", "toBuilder", "toBuilder-QwZRm1k", "([J)Lkotlinx/serialization/internal/ULongArrayBuilder;", "empty", "empty-Y2RjT0g", "()[J", "readElement", _UrlKt.FRAGMENT_ENCODE_SET, "decoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "checkIndex", _UrlKt.FRAGMENT_ENCODE_SET, "writeContent", "encoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "writeContent-0q3Fkuo", "(Lkotlinx/serialization/encoding/CompositeEncoder;[JI)V", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public final class ULongArraySerializer extends PrimitiveArraySerializer<ULong, ULongArray, ULongArrayBuilder> implements KSerializer<ULongArray> {
    public static final ULongArraySerializer INSTANCE = new ULongArraySerializer();

    private ULongArraySerializer() {
        super(BuiltinSerializersKt.serializer(ULong.Companion));
    }

    @Override
    public /* bridge */  int collectionSize(Object $this$collectionSize) {
        return m1565collectionSizeQwZRm1k(((ULongArray) $this$collectionSize).m249unboximpl());
    }

    @Override
    public /* bridge */  ULongArray empty() {
        return ULongArray.m233boximpl(m1566emptyY2RjT0g());
    }

    @Override
    public /* bridge */  Object toBuilder(Object $this$toBuilder) {
        return m1567toBuilderQwZRm1k(((ULongArray) $this$toBuilder).m249unboximpl());
    }

    @Override
    public /* bridge */  void writeContent(CompositeEncoder encoder, ULongArray uLongArray, int size) {
        m1568writeContent0q3Fkuo(encoder, uLongArray.m249unboximpl(), size);
    }

    protected int m1565collectionSizeQwZRm1k(long[] $this$collectionSize_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$collectionSize_u2dQwZRm1k, "$this$collectionSize");
        return ULongArray.m241getSizeimpl($this$collectionSize_u2dQwZRm1k);
    }

    protected ULongArrayBuilder m1567toBuilderQwZRm1k(long[] $this$toBuilder_u2dQwZRm1k) {
        Intrinsics.checkNotNullParameter($this$toBuilder_u2dQwZRm1k, "$this$toBuilder");
        return new ULongArrayBuilder($this$toBuilder_u2dQwZRm1k, null);
    }

    protected long[] m1566emptyY2RjT0g() {
        return ULongArray.m234constructorimpl(0);
    }

    @Override
    public void readElement(CompositeDecoder decoder, int index, ULongArrayBuilder builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.m1563appendVKZWuLQ$kotlinx_serialization_core(ULong.m180constructorimpl(decoder.decodeInlineElement(getDescriptor(), index).decodeLong()));
    }

    protected void m1568writeContent0q3Fkuo(CompositeEncoder encoder, long[] content, int size) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i = 0; i < size; i++) {
            encoder.encodeInlineElement(getDescriptor(), i).encodeLong(ULongArray.m240getsVKNKU(content, i));
        }
    }
}
