package ni.shikatu.kotlinx.serialization.internal;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.kotlinx.serialization.internal.PrimitiveArrayBuilder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B\u0017\b@\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000e\u001a\u00020\u000f*\u00028\u0002H\u0084\u0080\u0004¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00028\u0001*\u00028\u0002H\u0084\u0080\u0004¢\u0006\u0002\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u0014*\u00028\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0084\u0080\u0004¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018*\u00028\u0001H\u0084\u0080\u0004¢\u0006\u0002\u0010\u0019J#\u0010\u001a\u001a\u00020\u0014*\u00028\u00022\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0084\u0080\u0004¢\u0006\u0002\u0010\u001dJ\u000f\u0010\u001e\u001a\u00028\u0002H\u0084\u0080\u0004¢\u0006\u0002\u0010\u001fJ\u000f\u0010 \u001a\u00028\u0001H¤\u0080\u0004¢\u0006\u0002\u0010!J/\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00028\u00022\u0006\u0010%\u001a\u00020&H¤\u0080\u0004¢\u0006\u0002\u0010'J'\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00020\u000fH¤\u0080\u0004¢\u0006\u0002\u0010,J\u001f\u0010-\u001a\u00020\u00142\u0006\u0010)\u001a\u00020.2\u0006\u0010/\u001a\u00028\u0001H\u0086\u0080\u0004¢\u0006\u0002\u00100J\u0017\u00101\u001a\u00028\u00012\u0006\u0010#\u001a\u000202H\u0086\u0080\u0004¢\u0006\u0002\u00103R\u0015\u0010\n\u001a\u00020\u000bX\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u00064"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/PrimitiveArraySerializer;", "Element", "Array", "Builder", "Lni/shikatu/kotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lni/shikatu/kotlinx/serialization/internal/CollectionLikeSerializer;", "primitiveSerializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builderSize", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)I", "toResult", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)Ljava/lang/Object;", "checkCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "size", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;I)V", "collectionIterator", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)Ljava/util/Iterator;", "insert", "index", "element", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;ILjava/lang/Object;)V", "builder", "()Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "empty", "()Ljava/lang/Object;", "readElement", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "checkIndex", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/encoding/CompositeDecoder;ILkotlinx/serialization/internal/PrimitiveArrayBuilder;Z)V", "writeContent", "encoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", "content", "(Lkotlinx/serialization/encoding/CompositeEncoder;Ljava/lang/Object;I)V", "serialize", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PrimitiveArraySerializer<Element, Array, Builder extends PrimitiveArrayBuilder<Array>> extends CollectionLikeSerializer<Element, Array, Builder> {
    private final SerialDescriptor descriptor;

    protected abstract Array empty();

    protected abstract void readElement(CompositeDecoder compositeDecoder, int i, Builder builder, boolean z);

    protected abstract void writeContent(CompositeEncoder compositeEncoder, Array array, int i);

    public PrimitiveArraySerializer(KSerializer<Element> kSerializer) {
        super(kSerializer, null);
        Intrinsics.checkNotNullParameter(kSerializer, "primitiveSerializer");
        this.descriptor = new PrimitiveArrayDescriptor(kSerializer.getDescriptor());
    }

    @Override
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override
    public final int builderSize(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.getPosition$kotlinx_serialization_core();
    }

    @Override
    public final Array toResult(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return (Array) builder.build$kotlinx_serialization_core();
    }

    @Override
    public final void checkCapacity(Builder builder, int size) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.ensureCapacity$kotlinx_serialization_core(size);
    }

    @Override
    protected final Iterator<Element> collectionIterator(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    @Override
    public final void insert(Builder builder, int index, Element element) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    @Override
    public final Builder builder() {
        return toBuilder(empty());
    }

    @Override
    public final void serialize(Encoder encoder, Array array) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int size = collectionSize(array);
        SerialDescriptor descriptor$iv = this.descriptor;
        CompositeEncoder composite$iv = encoder.beginCollection(descriptor$iv, size);
        writeContent(composite$iv, array, size);
        composite$iv.endStructure(descriptor$iv);
    }

    @Override
    public final Array deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return merge(decoder, null);
    }
}
