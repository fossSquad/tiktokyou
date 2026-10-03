package ni.shikatu.kotlinx.serialization.internal;
import java.util.Map.Entry;

import java.util.Iterator;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.IntProgression;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlinx.serialization.InternalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.descriptors.PrimitiveKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0014\b\u0003\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00052 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006B%\bD\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0010\u001a\u00020\u0011*\u00028\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0001H¤\u0080\u0004¢\u0006\u0002\u0010\u0016J/\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u00032\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013H\u0084\u0080\u0004¢\u0006\u0002\u0010!J/\u0010\"\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00028\u00032\u0006\u0010#\u001a\u00020$H\u0084\u0080\u0004¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0015\u001a\u00028\u0002H\u0096\u0080\u0004¢\u0006\u0002\u0010)R\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0017\u001a\u00020\u0018X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0082\u0001\u0002*+¨\u0006,"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", "Builder", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/internal/AbstractCollectionSerializer;", _UrlKt.FRAGMENT_ENCODE_SET, "keySerializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "insertKeyValuePair", _UrlKt.FRAGMENT_ENCODE_SET, "index", _UrlKt.FRAGMENT_ENCODE_SET, "key", "value", "(Ljava/util/Map;ILjava/lang/Object;Ljava/lang/Object;)V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "readAll", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/util/Map;II)V", "readElement", "checkIndex", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/util/Map;Z)V", "serialize", "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lni/shikatu/kotlinx/serialization/internal/HashMapSerializer;", "Lni/shikatu/kotlinx/serialization/internal/LinkedHashMapSerializer;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@InternalSerializationApi
public abstract class MapLikeSerializer<Key, Value, Collection, Builder extends Map<Key, Value>> extends AbstractCollectionSerializer<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {
    private final KSerializer<Key> keySerializer;
    private final KSerializer<Value> valueSerializer;

    public  MapLikeSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    @Override
    public abstract SerialDescriptor getDescriptor();

    protected abstract void insertKeyValuePair(Builder builder, int i, Key key, Value value);

    private MapLikeSerializer(KSerializer<Key> kSerializer, KSerializer<Value> kSerializer2) {
        super(null);
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }

    public final KSerializer<Key> getKeySerializer() {
        return this.keySerializer;
    }

    public final KSerializer<Value> getValueSerializer() {
        return this.valueSerializer;
    }

    @Override
    public final void readAll(CompositeDecoder decoder, Builder builder, int startIndex, int size) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (!(size >= 0)) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, size * 2), 2);
        int index = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step <= 0 || index > last) && (step >= 0 || last > index)) {
            return;
        }
        while (true) {
            readElement(decoder, startIndex + index, (Map) builder, false);
            if (index == last) {
                return;
            } else {
                index += step;
            }
        }
    }

    @Override
    public final void readElement(CompositeDecoder decoder, int index, Builder builder, boolean checkIndex) {
        int it;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Object key = CompositeDecoder.decodeSerializableElement$default(decoder, getDescriptor(), index, this.keySerializer, null, 8, null);
        if (checkIndex) {
            int it2 = decoder.decodeElementIndex(getDescriptor());
            if (it2 == index + 1) {
                it = it2;
            } else {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + index + ", returned index for value: " + it2).toString());
            }
        } else {
            it = index + 1;
        }
        Object value = (!builder.containsKey(key) || (this.valueSerializer.getDescriptor().getKind() instanceof PrimitiveKind)) ? CompositeDecoder.decodeSerializableElement$default(decoder, getDescriptor(), it, this.valueSerializer, null, 8, null) : decoder.decodeSerializableElement(getDescriptor(), it, this.valueSerializer, MapsKt.getValue(builder, key));
        builder.put(key, value);
    }

    @Override
    public void serialize(Encoder encoder, Collection collection) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int size = collectionSize(collection);
        SerialDescriptor descriptor$iv = getDescriptor();
        int collectionSize$iv = size;
        CompositeEncoder composite$iv = encoder.beginCollection(descriptor$iv, collectionSize$iv);
        Iterator<Map.Entry<? extends Key, ? extends Value>> itCollectionIterator = collectionIterator(collection);
        int index = 0;
        while (itCollectionIterator.hasNext()) {
            Object element$iv = itCollectionIterator.next();
            Map.Entry<? extends Key, ? extends Value> entry = (Map.Entry) element$iv;
            Key key = entry.getKey();
            Value value = entry.getValue();
            int index2 = index + 1;
            composite$iv.encodeSerializableElement(getDescriptor(), index, getKeySerializer(), key);
            index = index2 + 1;
            composite$iv.encodeSerializableElement(getDescriptor(), index2, getValueSerializer(), value);
            size = size;
            collectionSize$iv = collectionSize$iv;
        }
        composite$iv.endStructure(descriptor$iv);
    }
}
