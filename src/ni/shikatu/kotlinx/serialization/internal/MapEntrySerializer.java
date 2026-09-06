package ni.shikatu.kotlinx.serialization.internal;

import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorsKt;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003:\u0001\u0015B%\bF\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0014R\u0015\u0010\n\u001a\u00020\u000bX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR%\u0010\u000e\u001a\u00028\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0011\u001a\u00028\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0084\b¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0016"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/MapEntrySerializer;", "K", "V", "Lni/shikatu/kotlinx/serialization/internal/KeyValueSerializer;", _UrlKt.FRAGMENT_ENCODE_SET, "keySerializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "key", "getKey", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "MapEntry", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MapEntrySerializer<K, V> extends KeyValueSerializer<K, V, Map.Entry<? extends K, ? extends V>> {
    private final SerialDescriptor descriptor;

    public MapEntrySerializer(final KSerializer<K> kSerializer, final KSerializer<V> kSerializer2) {
        super(kSerializer, kSerializer2, null);
        Intrinsics.checkNotNullParameter(kSerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "valueSerializer");
        this.descriptor = SerialDescriptorsKt.buildSerialDescriptor("ni.shikatu.kotlin.collections.Map.Entry", StructureKind.MAP.INSTANCE, new SerialDescriptor[0], new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return MapEntrySerializer.descriptor$lambda$0(kSerializer, kSerializer2, (ClassSerialDescriptorBuilder) obj);
            }
        });
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0019\bF\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\u00028\u0002HÆ\u0083\u0004¢\u0006\u0002\u0010\tJ\u000f\u0010\r\u001a\u00028\u0003HÆ\u0083\u0004¢\u0006\u0002\u0010\tJ/\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00022\b\b\u0002\u0010\u0005\u001a\u00028\u0003HÆ\u0081\u0004¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0017\u0010\u0004\u001a\u00028\u0002X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\u00028\u0003X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "K", "V", _UrlKt.FRAGMENT_ENCODE_SET, "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class MapEntry<K, V> implements Map.Entry<K, V>, KMappedMarker {
        private final K key;
        private final V value;

        public static  MapEntry copy$default(MapEntry mapEntry, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                obj = mapEntry.key;
            }
            if ((i & 2) != 0) {
                obj2 = mapEntry.value;
            }
            return mapEntry.copy(obj, obj2);
        }

        public final K component1() {
            return this.key;
        }

        public final V component2() {
            return this.value;
        }

        public final MapEntry<K, V> copy(K k, V v) {
            return new MapEntry<>(k, v);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MapEntry)) {
                return false;
            }
            MapEntry mapEntry = (MapEntry) obj;
            return Intrinsics.areEqual(this.key, mapEntry.key) && Intrinsics.areEqual(this.value, mapEntry.value);
        }

        @Override
        public int hashCode() {
            return ((this.key == null ? 0 : this.key.hashCode()) * 31) + (this.value != null ? this.value.hashCode() : 0);
        }

        @Override
        public V setValue(V v) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public String toString() {
            return "MapEntry(key=" + this.key + ", value=" + this.value + ')';
        }

        public MapEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public static final Unit descriptor$lambda$0(KSerializer $keySerializer, KSerializer $valueSerializer, ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "key", $keySerializer.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "value", $valueSerializer.getDescriptor(), null, false, 12, null);
        return Unit.INSTANCE;
    }

    @Override
    public K getKey(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getKey();
    }

    @Override
    public V getValue(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "<this>");
        return entry.getValue();
    }

    @Override
    public Map.Entry<K, V> toResult(K k, V v) {
        return new MapEntry(k, v);
    }
}
