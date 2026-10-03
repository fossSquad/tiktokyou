package ni.shikatu.kotlinx.serialization.internal;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.InternalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\t\bD¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b*\u00028\u0001H¤\u0080\u0004¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b*\u00028\u0001H¤\u0080\u0004¢\u0006\u0002\u0010\fJ\u000f\u0010\r\u001a\u00028\u0002H¤\u0080\u0004¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\b*\u00028\u0002H¤\u0080\u0004¢\u0006\u0002\u0010\tJ\u0013\u0010\u0010\u001a\u00028\u0001*\u00028\u0002H¤\u0080\u0004¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00028\u0002*\u00028\u0001H¤\u0080\u0004¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u0014*\u00028\u00022\u0006\u0010\u0015\u001a\u00020\bH¤\u0080\u0004¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0001H¦\u0080\u0004¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00018\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010 J\u0017\u0010!\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0080\u0004¢\u0006\u0002\u0010\"J\u001f\u0010#\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020$2\u0006\u0010\r\u001a\u00028\u0002H\u0082\u0080\u0004¢\u0006\u0002\u0010%J1\u0010&\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020$2\u0006\u0010'\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u00022\b\b\u0002\u0010(\u001a\u00020)H¤\u0080\u0004¢\u0006\u0002\u0010*J/\u0010+\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020$2\u0006\u0010\r\u001a\u00028\u00022\u0006\u0010,\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH¤\u0080\u0004¢\u0006\u0002\u0010-\u0082\u0001\u0002./¨\u00060"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/AbstractCollectionSerializer;", "Element", "Collection", "Builder", "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "()V", "collectionSize", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)I", "collectionIterator", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)Ljava/util/Iterator;", "builder", "()Ljava/lang/Object;", "builderSize", "toResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "toBuilder", "checkCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "size", "(Ljava/lang/Object;I)V", "serialize", "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "merge", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "previous", "(Lkotlinx/serialization/encoding/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "readSize", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;)I", "readElement", "index", "checkIndex", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "readAll", "startIndex", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "Lni/shikatu/kotlinx/serialization/internal/CollectionLikeSerializer;", "Lni/shikatu/kotlinx/serialization/internal/MapLikeSerializer;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@InternalSerializationApi
public abstract class AbstractCollectionSerializer<Element, Collection, Builder> implements KSerializer<Collection> {
    public  AbstractCollectionSerializer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    protected abstract Builder builder();

    protected abstract int builderSize(Builder builder);

    protected abstract void checkCapacity(Builder builder, int i);

    protected abstract Iterator<Element> collectionIterator(Collection collection);

    protected abstract int collectionSize(Collection collection);

    protected abstract void readAll(CompositeDecoder compositeDecoder, Builder builder, int i, int i2);

    protected abstract void readElement(CompositeDecoder compositeDecoder, int i, Builder builder, boolean z);

    @Override
    public abstract void serialize(Encoder encoder, Collection collection);

    protected abstract Builder toBuilder(Collection collection);

    protected abstract Collection toResult(Builder builder);

    private AbstractCollectionSerializer() {
    }

    @InternalSerializationApi
    public final Collection merge(Decoder decoder, Collection collection) {
        Builder builder;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (collection == null || (builder = toBuilder(collection)) == null) {
            builder = builder();
        }
        Builder builder2 = builder;
        int iBuilderSize = builderSize(builder2);
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(getDescriptor());
        if (!compositeDecoderBeginStructure.decodeSequentially()) {
            while (true) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(getDescriptor());
                if (iDecodeElementIndex == -1) {
                    break;
                }
                readElement$default(this, compositeDecoderBeginStructure, iBuilderSize + iDecodeElementIndex, builder2, false, 8, null);
            }
        } else {
            readAll(compositeDecoderBeginStructure, builder2, iBuilderSize, readSize(compositeDecoderBeginStructure, builder2));
        }
        compositeDecoderBeginStructure.endStructure(getDescriptor());
        return toResult(builder2);
    }

    @Override
    public Collection deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return merge(decoder, null);
    }

    private final int readSize(CompositeDecoder decoder, Builder builder) {
        int size = decoder.decodeCollectionSize(getDescriptor());
        checkCapacity(builder, size);
        return size;
    }

    public static  void readElement$default(AbstractCollectionSerializer abstractCollectionSerializer, CompositeDecoder compositeDecoder, int i, Object obj, boolean z, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        abstractCollectionSerializer.readElement(compositeDecoder, i, obj, z);
    }
}
