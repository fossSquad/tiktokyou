package ni.shikatu.kotlinx.serialization.internal;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004B\u0017\bD\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\n*\u00028\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H¤\u0080\u0004¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0017J/\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u00022\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0084\u0080\u0004¢\u0006\u0002\u0010\u001eJ/\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00028\u00022\u0006\u0010 \u001a\u00020!H\u0094\u0080\u0004¢\u0006\u0002\u0010\"R\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u00020\u0010X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0082\u0001\u0003#$%¨\u0006&"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/CollectionLikeSerializer;", "Element", "Collection", "Builder", "Lni/shikatu/kotlinx/serialization/internal/AbstractCollectionSerializer;", "elementSerializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "insert", _UrlKt.FRAGMENT_ENCODE_SET, "index", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Ljava/lang/Object;ILjava/lang/Object;)V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "readAll", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "checkIndex", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "Lni/shikatu/kotlinx/serialization/internal/CollectionSerializer;", "Lni/shikatu/kotlinx/serialization/internal/PrimitiveArraySerializer;", "Lni/shikatu/kotlinx/serialization/internal/ReferenceArraySerializer;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class CollectionLikeSerializer<Element, Collection, Builder> extends AbstractCollectionSerializer<Element, Collection, Builder> {
    private final KSerializer<Element> elementSerializer;

    public  CollectionLikeSerializer(KSerializer kSerializer, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer);
    }

    @Override
    public abstract SerialDescriptor getDescriptor();

    protected abstract void insert(Builder builder, int i, Element element);

    private CollectionLikeSerializer(KSerializer<Element> kSerializer) {
        super(null);
        this.elementSerializer = kSerializer;
    }

    @Override
    public void serialize(Encoder encoder, Collection collection) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int size = collectionSize(collection);
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginCollection(descriptor$iv, size);
        Iterator<Element> itCollectionIterator = collectionIterator(collection);
        for (int index = 0; index < size; index++) {
            composite$iv.encodeSerializableElement(getDescriptor(), index, this.elementSerializer, itCollectionIterator.next());
        }
        composite$iv.endStructure(descriptor$iv);
    }

    @Override
    protected final void readAll(CompositeDecoder decoder, Builder builder, int startIndex, int size) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (!(size >= 0)) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
        for (int index = 0; index < size; index++) {
            readElement(decoder, startIndex + index, builder, false);
        }
    }

    @Override
    protected void readElement(CompositeDecoder decoder, int index, Builder builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        insert(builder, index, CompositeDecoder.decodeSerializableElement$default(decoder, getDescriptor(), index, this.elementSerializer, null, 8, null));
    }
}
