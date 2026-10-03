package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.UShortArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\bB¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\t*\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u0005*\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0002H\u0094\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0094\u0080\u0004J)\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\tH\u0094\u0080\u0004¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/UShortArraySerializer;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlin/UShortArray;", "Lni/shikatu/kotlinx/serialization/internal/PrimitiveArraySerializer;", "Lni/shikatu/kotlin/UShort;", "Lni/shikatu/kotlinx/serialization/internal/UShortArrayBuilder;", "<init>", "()V", "collectionSize", _UrlKt.FRAGMENT_ENCODE_SET, "collectionSize-rL5Bavg", "([S)I", "toBuilder", "toBuilder-rL5Bavg", "([S)Lkotlinx/serialization/internal/UShortArrayBuilder;", "empty", "empty-amswpOA", "()[S", "readElement", _UrlKt.FRAGMENT_ENCODE_SET, "decoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "checkIndex", _UrlKt.FRAGMENT_ENCODE_SET, "writeContent", "encoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "writeContent-eny0XGE", "(Lkotlinx/serialization/encoding/CompositeEncoder;[SI)V", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public final class UShortArraySerializer extends PrimitiveArraySerializer<UShort, UShortArray, UShortArrayBuilder> implements KSerializer<UShortArray> {
    public static final UShortArraySerializer INSTANCE = new UShortArraySerializer();

    private UShortArraySerializer() {
        super(BuiltinSerializersKt.serializer(UShort.Companion));
    }

    @Override
    public /* bridge */  int collectionSize(Object $this$collectionSize) {
        return m1573collectionSizerL5Bavg(((UShortArray) $this$collectionSize).m354unboximpl());
    }

    @Override
    public /* bridge */  UShortArray empty() {
        return UShortArray.m338boximpl(m1574emptyamswpOA());
    }

    @Override
    public /* bridge */  Object toBuilder(Object $this$toBuilder) {
        return m1575toBuilderrL5Bavg(((UShortArray) $this$toBuilder).m354unboximpl());
    }

    @Override
    public /* bridge */  void writeContent(CompositeEncoder encoder, UShortArray uShortArray, int size) {
        m1576writeContenteny0XGE(encoder, uShortArray.m354unboximpl(), size);
    }

    protected int m1573collectionSizerL5Bavg(short[] $this$collectionSize_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$collectionSize_u2drL5Bavg, "$this$collectionSize");
        return UShortArray.m346getSizeimpl($this$collectionSize_u2drL5Bavg);
    }

    protected UShortArrayBuilder m1575toBuilderrL5Bavg(short[] $this$toBuilder_u2drL5Bavg) {
        Intrinsics.checkNotNullParameter($this$toBuilder_u2drL5Bavg, "$this$toBuilder");
        return new UShortArrayBuilder($this$toBuilder_u2drL5Bavg, null);
    }

    protected short[] m1574emptyamswpOA() {
        return UShortArray.m339constructorimpl(0);
    }

    @Override
    public void readElement(CompositeDecoder decoder, int index, UShortArrayBuilder builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.m1571appendxj2QHRw$kotlinx_serialization_core(UShort.m287constructorimpl(decoder.decodeInlineElement(getDescriptor(), index).decodeShort()));
    }

    protected void m1576writeContenteny0XGE(CompositeEncoder encoder, short[] content, int size) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i = 0; i < size; i++) {
            encoder.encodeInlineElement(getDescriptor(), i).encodeShort(UShortArray.m345getMh2AYeg(content, i));
        }
    }
}
