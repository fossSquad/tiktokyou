package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.BooleanCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\bB¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t*\u00020\u0002H\u0094\u0080\u0004J\u000e\u0010\n\u001a\u00020\u0005*\u00020\u0002H\u0094\u0080\u0004J\n\u0010\u000b\u001a\u00020\u0002H\u0094\u0080\u0004J*\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0004H\u0094\u0080\u0004J\"\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\tH\u0094\u0080\u0004¨\u0006\u0018"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/BooleanArraySerializer;", "Lni/shikatu/kotlinx/serialization/KSerializer;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/internal/PrimitiveArraySerializer;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/internal/BooleanArrayBuilder;", "<init>", "()V", "collectionSize", _UrlKt.FRAGMENT_ENCODE_SET, "toBuilder", "empty", "readElement", _UrlKt.FRAGMENT_ENCODE_SET, "decoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "index", "builder", "checkIndex", "writeContent", "encoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", "content", "size", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BooleanArraySerializer extends PrimitiveArraySerializer<Boolean, boolean[], BooleanArrayBuilder> implements KSerializer<boolean[]> {
    public static final BooleanArraySerializer INSTANCE = new BooleanArraySerializer();

    private BooleanArraySerializer() {
        super(BuiltinSerializersKt.serializer(BooleanCompanionObject.INSTANCE));
    }

    @Override
    public int collectionSize(boolean[] $this$collectionSize) {
        Intrinsics.checkNotNullParameter($this$collectionSize, "<this>");
        return $this$collectionSize.length;
    }

    @Override
    public BooleanArrayBuilder toBuilder(boolean[] $this$toBuilder) {
        Intrinsics.checkNotNullParameter($this$toBuilder, "<this>");
        return new BooleanArrayBuilder($this$toBuilder);
    }

    @Override
    public boolean[] empty() {
        return new boolean[0];
    }

    @Override
    public void readElement(CompositeDecoder decoder, int index, BooleanArrayBuilder builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.append$kotlinx_serialization_core(decoder.decodeBooleanElement(getDescriptor(), index));
    }

    @Override
    public void writeContent(CompositeEncoder encoder, boolean[] content, int size) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i = 0; i < size; i++) {
            encoder.encodeBooleanElement(getDescriptor(), i, content[i]);
        }
    }
}
