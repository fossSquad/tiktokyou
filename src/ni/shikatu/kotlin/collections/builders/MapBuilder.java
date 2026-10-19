package ni.shikatu.kotlin.collections.builders;

import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMutableIterator;
import ni.shikatu.kotlin.jvm.internal.markers.KMutableMap;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u0085\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005:\f\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001BG\bB\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\t\bV¢\u0006\u0004\b\u000f\u0010\u0011B\u0011\bV\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0013J\u0016\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&H\u0086\u0080\u0004J\n\u0010'\u001a\u00020(H\u0082\u0080\u0004J\u0012\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0082\u0080\u0004J\n\u0010-\u001a\u00020!H\u0096\u0080\u0004J\u0017\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u00100J\u0017\u00101\u001a\u00020!2\u0006\u0010\u0017\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u00100J\u0019\u00102\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u00103J!\u00104\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0001H\u0096\u0080\b¢\u0006\u0002\u00105J \u00106\u001a\u00020*2\u0014\u00107\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&H\u0096\u0080\u0004J\u0019\u00108\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u00103J\n\u00109\u001a\u00020*H\u0096\u0080\u0004J\u0014\u0010E\u001a\u00020!2\b\u0010F\u001a\u0004\u0018\u00010(H\u0096\u0082\u0004J\n\u0010G\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010H\u001a\u00020IH\u0096\u0080\u0004J\n\u0010N\u001a\u00020*H\u0082\u0080\u0004J\u000f\u0010O\u001a\u00020*H\u0080\u0080\u0004¢\u0006\u0002\bPJ\u0012\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u00020\rH\u0082\u0080\u0004J\u0012\u0010S\u001a\u00020!2\u0006\u0010T\u001a\u00020\rH\u0082\u0080\u0004J\u0012\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020\rH\u0082\u0080\u0004J\u0015\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0082\u0080\u0004¢\u0006\u0002\u0010XJ\u0017\u0010Y\u001a\u00020\r2\u0006\u0010/\u001a\u00028\u0000H\u0082\u0080\u0004¢\u0006\u0002\u0010ZJ\u0012\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020!H\u0082\u0080\u0004J\u0012\u0010]\u001a\u00020*2\u0006\u0010^\u001a\u00020\rH\u0082\u0080\u0004J\u0012\u0010_\u001a\u00020!2\u0006\u0010`\u001a\u00020\rH\u0082\u0080\u0004J\u0017\u0010a\u001a\u00020\r2\u0006\u0010/\u001a\u00028\u0000H\u0082\u0080\u0004¢\u0006\u0002\u0010ZJ\u0017\u0010b\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00028\u0001H\u0082\u0080\u0004¢\u0006\u0002\u0010ZJ\u0019\u0010c\u001a\u00020\r2\u0006\u0010/\u001a\u00028\u0000H\u0080\u0080\u0004¢\u0006\u0004\bd\u0010ZJ\u0019\u0010e\u001a\u00020!2\u0006\u0010/\u001a\u00028\u0000H\u0080\u0080\u0004¢\u0006\u0004\bf\u00100J\u0012\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020\rH\u0082\u0080\u0004J\u0012\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\rH\u0082\u0080\u0004J#\u0010k\u001a\u00020!2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010mH\u0080\u0080\u0004¢\u0006\u0002\bnJ\u001a\u0010o\u001a\u00020!2\u000e\u0010F\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030&H\u0082\u0080\u0004J\u001b\u0010p\u001a\u00020!2\n\u0010q\u001a\u0006\u0012\u0002\b\u00030rH\u0080\u0080\u0004¢\u0006\u0002\bsJ\u001e\u0010t\u001a\u00020!2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010mH\u0082\u0080\u0004J(\u0010u\u001a\u00020!2\u0018\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010m0rH\u0083\u0080\bb\u0002\bvJ#\u0010w\u001a\u00020!2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010mH\u0080\u0080\u0004¢\u0006\u0002\bxJ\u0019\u0010y\u001a\u00020!2\u0006\u0010z\u001a\u00028\u0001H\u0080\u0080\u0004¢\u0006\u0004\b{\u00100J\u001b\u0010|\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010}H\u0080\u0080\u0004¢\u0006\u0002\b~J\u001d\u0010\u007f\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0080\u0001H\u0080\u0080\u0004¢\u0006\u0003\b\u0081\u0001J\u001e\u0010\u0082\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0083\u0001H\u0080\u0080\u0004¢\u0006\u0003\b\u0084\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\u0014R\u000f\u0010\t\u001a\u00020\nX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000b\u001a\u00020\nX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\f\u001a\u00020\rX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000e\u001a\u00020\rX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0015\u001a\u00020\rX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0016\u001a\u00020\rX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001f\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r@RX\u0096\u008e\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001eX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010 X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020!@BX\u0080\u008e\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001b\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001b\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00010?8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b@\u0010AR'\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0;8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\bD\u0010=R\u0015\u0010J\u001a\u00020\r8@X\u0080\u0084\b¢\u0006\u0006\u001a\u0004\bK\u0010\u001aR\u0015\u0010L\u001a\u00020\r8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\bM\u0010\u001a¨\u0006\u008b\u0001"}, d2 = {"Lni/shikatu/kotlin/collections/builders/MapBuilder;", "K", "V", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "keysArray", _UrlKt.FRAGMENT_ENCODE_SET, "valuesArray", "presenceArray", _UrlKt.FRAGMENT_ENCODE_SET, "hashArray", "maxProbeDistance", _UrlKt.FRAGMENT_ENCODE_SET, "length", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "()V", "initialCapacity", "(I)V", "[Ljava/lang/Object;", "hashShift", "modCount", "value", "size", "getSize", "()I", "keysView", "Lni/shikatu/kotlin/collections/builders/MapBuilderKeys;", "valuesView", "Lni/shikatu/kotlin/collections/builders/MapBuilderValues;", "entriesView", "Lni/shikatu/kotlin/collections/builders/MapBuilderEntries;", _UrlKt.FRAGMENT_ENCODE_SET, "isReadOnly", "isReadOnly$kotlin_stdlib", "()Z", "build", _UrlKt.FRAGMENT_ENCODE_SET, "writeReplace", _UrlKt.FRAGMENT_ENCODE_SET, "readObject", _UrlKt.FRAGMENT_ENCODE_SET, "input", "Ljava/io/ObjectInputStream;", "isEmpty", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "clear", "keys", _UrlKt.FRAGMENT_ENCODE_SET, "getKeys", "()Ljava/util/Set;", "values", _UrlKt.FRAGMENT_ENCODE_SET, "getValues", "()Ljava/util/Collection;", "entries", _UrlKt.FRAGMENT_ENCODE_SET, "getEntries", "equals", "other", "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "capacity", "getCapacity$kotlin_stdlib", "hashSize", "getHashSize", "registerModification", "checkIsMutable", "checkIsMutable$kotlin_stdlib", "ensureExtraCapacity", "n", "shouldCompact", "extraCapacity", "ensureCapacity", "minCapacity", "allocateValuesArray", "()[Ljava/lang/Object;", "hash", "(Ljava/lang/Object;)I", "compact", "updateHashArray", "rehash", "newHashSize", "putRehash", "i", "findKey", "findValue", "addKey", "addKey$kotlin_stdlib", "removeKey", "removeKey$kotlin_stdlib", "removeEntryAt", "index", "removeHashAt", "removedHash", "containsEntry", "entry", _UrlKt.FRAGMENT_ENCODE_SET, "containsEntry$kotlin_stdlib", "contentEquals", "containsAllEntries", "m", _UrlKt.FRAGMENT_ENCODE_SET, "containsAllEntries$kotlin_stdlib", "putEntry", "putAllEntries", "Lni/shikatu/kotlin/IgnorableReturnValue;", "removeEntry", "removeEntry$kotlin_stdlib", "removeValue", "element", "removeValue$kotlin_stdlib", "keysIterator", "Lni/shikatu/kotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "valuesIterator", "Lni/shikatu/kotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "entriesIterator", "Lni/shikatu/kotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "Companion", "Itr", "KeysItr", "ValuesItr", "EntriesItr", "EntryRef", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    public static final Companion Companion = new Companion(null);
    private static final MapBuilder Empty;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;
    private MapBuilderEntries<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private MapBuilderKeys<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private MapBuilderValues<V> valuesView;

    private MapBuilder(K[] kArr, V[] vArr, int[] presenceArray, int[] hashArray, int maxProbeDistance, int length) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = presenceArray;
        this.hashArray = hashArray;
        this.maxProbeDistance = maxProbeDistance;
        this.length = length;
        this.hashShift = Companion.computeShift(getHashSize());
    }

    @Override
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public int getSize() {
        return this.size;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int initialCapacity) {
        this(ListBuilderKt.arrayOfUninitializedElements(initialCapacity), null, new int[initialCapacity], new int[Companion.computeHashSize(initialCapacity)], 2, 0);
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = Empty;
        Intrinsics.checkNotNull(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    @Override
    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    @Override
    public V get(Object obj) {
        int index = findKey(obj);
        if (index < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return vArr[index];
    }

    @Override
    public V put(K k, V v) {
        checkIsMutable$kotlin_stdlib();
        int index = addKey$kotlin_stdlib(k);
        V[] vArrAllocateValuesArray = allocateValuesArray();
        if (index < 0) {
            V v2 = vArrAllocateValuesArray[(-index) - 1];
            vArrAllocateValuesArray[(-index) - 1] = v;
            return v2;
        }
        vArrAllocateValuesArray[index] = v;
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(map.entrySet());
    }

    @Override
    public V remove(Object obj) {
        checkIsMutable$kotlin_stdlib();
        int index = findKey(obj);
        if (index < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        V v = vArr[index];
        removeEntryAt(index);
        return v;
    }

    @Override
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i = 0;
        int i2 = this.length - 1;
        if (0 <= i2) {
            while (true) {
                int hash = this.presenceArray[i];
                if (hash >= 0) {
                    this.hashArray[hash] = 0;
                    this.presenceArray[i] = -1;
                }
                if (i == i2) {
                    break;
                } else {
                    i++;
                }
            }
        }
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        registerModification();
    }

    public Set<K> getKeys() {
        MapBuilderKeys<K> mapBuilderKeys = this.keysView;
        if (mapBuilderKeys == null) {
            MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
            this.keysView = mapBuilderKeys2;
            return mapBuilderKeys2;
        }
        return mapBuilderKeys;
    }

    public Collection<V> getValues() {
        MapBuilderValues<V> mapBuilderValues = this.valuesView;
        if (mapBuilderValues == null) {
            MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
            this.valuesView = mapBuilderValues2;
            return mapBuilderValues2;
        }
        return mapBuilderValues;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.entriesView;
        if (mapBuilderEntries == null) {
            MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
            this.entriesView = mapBuilderEntries2;
            return mapBuilderEntries2;
        }
        return mapBuilderEntries;
    }

    @Override
    public boolean equals(Object other) {
        return other == this || ((other instanceof Map) && contentEquals((Map) other));
    }

    @Override
    public int hashCode() {
        int result = 0;
        EntriesItr<K, V> entriesItrEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        while (entriesItrEntriesIterator$kotlin_stdlib.hasNext()) {
            result += entriesItrEntriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        int i = 0;
        EntriesItr<K, V> entriesItrEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        while (entriesItrEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            entriesItrEntriesIterator$kotlin_stdlib.nextAppendString(sb);
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final void registerModification() {
        this.modCount++;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final void ensureExtraCapacity(int n) {
        if (shouldCompact(n)) {
            compact(true);
        } else {
            ensureCapacity(this.length + n);
        }
    }

    private final boolean shouldCompact(int extraCapacity) {
        int spareCapacity = getCapacity$kotlin_stdlib() - this.length;
        int gaps = this.length - size();
        return spareCapacity < extraCapacity && gaps + spareCapacity >= extraCapacity && gaps >= getCapacity$kotlin_stdlib() / 4;
    }

    private final void ensureCapacity(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        if (i > getCapacity$kotlin_stdlib()) {
            int iNewCapacity$kotlin_stdlib = AbstractList.Companion.newCapacity$kotlin_stdlib(getCapacity$kotlin_stdlib(), i);
            this.keysArray = (K[]) ListBuilderKt.copyOfUninitializedElements(this.keysArray, iNewCapacity$kotlin_stdlib);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) ListBuilderKt.copyOfUninitializedElements(vArr, iNewCapacity$kotlin_stdlib) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.presenceArray, iNewCapacity$kotlin_stdlib);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.presenceArray = iArrCopyOf;
            int iComputeHashSize = Companion.computeHashSize(iNewCapacity$kotlin_stdlib);
            if (iComputeHashSize > getHashSize()) {
                rehash(iComputeHashSize);
            }
        }
    }

    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) ListBuilderKt.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final int hash(K k) {
        return ((k != null ? k.hashCode() : 0) * MAGIC) >>> this.hashShift;
    }

    private final void compact(boolean updateHashArray) {
        int j = 0;
        Object[] valuesArray = this.valuesArray;
        for (int i = 0; i < this.length; i++) {
            int hash = this.presenceArray[i];
            if (hash >= 0) {
                this.keysArray[j] = this.keysArray[i];
                if (valuesArray != null) {
                    valuesArray[j] = valuesArray[i];
                }
                if (updateHashArray) {
                    this.presenceArray[j] = hash;
                    this.hashArray[hash] = j + 1;
                }
                j++;
            }
        }
        ListBuilderKt.resetRange(this.keysArray, j, this.length);
        if (valuesArray != null) {
            ListBuilderKt.resetRange(valuesArray, j, this.length);
        }
        this.length = j;
    }

    private final void rehash(int newHashSize) {
        registerModification();
        if (this.length > size()) {
            compact(false);
        }
        this.hashArray = new int[newHashSize];
        this.hashShift = Companion.computeShift(newHashSize);
        int i = 0;
        while (i < this.length) {
            int i2 = i + 1;
            if (!putRehash(i)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i = i2;
        }
    }

    private final boolean putRehash(int i) {
        int hash = hash(this.keysArray[i]);
        int probesLeft = this.maxProbeDistance;
        while (index != 0) {
            probesLeft--;
            if (probesLeft < 0) {
                return false;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
        this.hashArray[hash] = i + 1;
        this.presenceArray[i] = hash;
        return true;
    }

    private final int findKey(K k) {
        int hash = hash(k);
        int probesLeft = this.maxProbeDistance;
        while (true) {
            int index = this.hashArray[hash];
            if (index == 0) {
                return -1;
            }
            if (Intrinsics.areEqual(this.keysArray[index - 1], k)) {
                return index - 1;
            }
            probesLeft--;
            if (probesLeft < 0) {
                return -1;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final int findValue(V v) {
        int i = this.length;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.presenceArray[i] >= 0) {
                V[] vArr = this.valuesArray;
                Intrinsics.checkNotNull(vArr);
                if (Intrinsics.areEqual(vArr[i], v)) {
                    return i;
                }
            }
        }
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k);
            int tentativeMaxProbeDistance = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
            int probeDistance = 0;
            while (true) {
                int index = this.hashArray[hash];
                if (index == 0) {
                    if (this.length >= getCapacity$kotlin_stdlib()) {
                        ensureExtraCapacity(1);
                        break;
                    }
                    int putIndex = this.length;
                    this.length = putIndex + 1;
                    this.keysArray[putIndex] = k;
                    this.presenceArray[putIndex] = hash;
                    this.hashArray[hash] = putIndex + 1;
                    this.size = size() + 1;
                    registerModification();
                    if (probeDistance > this.maxProbeDistance) {
                        this.maxProbeDistance = probeDistance;
                    }
                    return putIndex;
                }
                if (Intrinsics.areEqual(this.keysArray[index - 1], k)) {
                    return -index;
                }
                probeDistance++;
                if (probeDistance <= tentativeMaxProbeDistance) {
                    hash = hash == 0 ? getHashSize() - 1 : hash - 1;
                } else {
                    rehash(getHashSize() * 2);
                    break;
                }
            }
        }
    }

    public final boolean removeKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        int index = findKey(k);
        if (index < 0) {
            return false;
        }
        removeEntryAt(index);
        return true;
    }

    public final void removeEntryAt(int index) {
        ListBuilderKt.resetAt(this.keysArray, index);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            ListBuilderKt.resetAt(vArr, index);
        }
        removeHashAt(this.presenceArray[index]);
        this.presenceArray[index] = -1;
        this.size = size() - 1;
        registerModification();
    }

    private final void removeHashAt(int removedHash) {
        int hash = removedHash;
        int hole = removedHash;
        int probeDistance = 0;
        while (true) {
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
            int index = this.hashArray[hash];
            probeDistance++;
            if (probeDistance > this.maxProbeDistance) {
                this.hashArray[hole] = 0;
                return;
            }
            if (index == 0) {
                this.hashArray[hole] = 0;
                return;
            }
            int otherHash = hash(this.keysArray[index - 1]);
            if (((otherHash - hash) & (getHashSize() - 1)) >= probeDistance) {
                this.hashArray[hole] = index;
                this.presenceArray[index - 1] = hole;
                hole = hash;
                probeDistance = 0;
            }
        }
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int index = findKey(entry.getKey());
        if (index < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return Intrinsics.areEqual(vArr[index], entry.getValue());
    }

    private final boolean contentEquals(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "m");
        for (Object entry : collection) {
            if (entry != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) entry)) {
                    }
                } catch (ClassCastException e) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int index = addKey$kotlin_stdlib(entry.getKey());
        Object[] valuesArray = allocateValuesArray();
        if (index < 0) {
            Object oldValue = valuesArray[(-index) - 1];
            if (!Intrinsics.areEqual(entry.getValue(), oldValue)) {
                valuesArray[(-index) - 1] = entry.getValue();
                return true;
            }
            return false;
        }
        valuesArray[index] = entry.getValue();
        return true;
    }

    @IgnorableReturnValue
    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = collection.iterator();
        boolean updated = false;
        while (it.hasNext()) {
            if (putEntry(it.next())) {
                updated = true;
            }
        }
        return updated;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int index = findKey(entry.getKey());
        if (index < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        if (!Intrinsics.areEqual(vArr[index], entry.getValue())) {
            return false;
        }
        removeEntryAt(index);
        return true;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int index = findValue(v);
        if (index < 0) {
            return false;
        }
        removeEntryAt(index);
        return true;
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr<>(this);
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr<>(this);
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr<>(this);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0082\u0080\u0004J\u0012\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0082\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R!\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlin/collections/builders/MapBuilder$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "MAGIC", _UrlKt.FRAGMENT_ENCODE_SET, "INITIAL_CAPACITY", "INITIAL_MAX_PROBE_DISTANCE", "TOMBSTONE", "Empty", "Lni/shikatu/kotlin/collections/builders/MapBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "getEmpty$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "computeHashSize", "capacity", "computeShift", "hashSize", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MapBuilder getEmpty$kotlin_stdlib() {
            return MapBuilder.Empty;
        }

        public final int computeHashSize(int capacity) {
            return Integer.highestOneBit(RangesKt.coerceAtLeast(capacity, 1) * 3);
        }

        public final int computeShift(int hashSize) {
            return Integer.numberOfLeadingZeros(hashSize) + 1;
        }
    }

    static {
        MapBuilder it = new MapBuilder(0);
        it.isReadOnly = true;
        Empty = it;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001d\bF\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0015H\u0080\u0080\u0004¢\u0006\u0002\b\u0016J\n\u0010\u0017\u001a\u00020\u0018H\u0086\u0080\u0004J\n\u0010\u0019\u001a\u00020\u0015H\u0086\u0080\u0004J\u000f\u0010\u001a\u001a\u00020\u0015H\u0080\u0080\u0004¢\u0006\u0002\b\u001bR!\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000bX\u0080\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u000bX\u0080\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000f\u0010\u0013\u001a\u00020\u000bX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lni/shikatu/kotlin/collections/builders/MapBuilder$Itr;", "K", "V", _UrlKt.FRAGMENT_ENCODE_SET, "map", "Lni/shikatu/kotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "expectedModCount", "initNext", _UrlKt.FRAGMENT_ENCODE_SET, "initNext$kotlin_stdlib", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "remove", "checkForComodification", "checkForComodification$kotlin_stdlib", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static class Itr<K, V> {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final MapBuilder<K, V> map;

        public Itr(MapBuilder<K, V> mapBuilder) {
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
            this.map = mapBuilder;
            this.lastIndex = -1;
            this.expectedModCount = ((MapBuilder) this.map).modCount;
            initNext$kotlin_stdlib();
        }

        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }

        public final void setIndex$kotlin_stdlib(int i) {
            this.index = i;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }

        public final void setLastIndex$kotlin_stdlib(int i) {
            this.lastIndex = i;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.index < ((MapBuilder) this.map).length && ((MapBuilder) this.map).presenceArray[this.index] < 0) {
                this.index++;
            }
        }

        public final boolean hasNext() {
            return this.index < ((MapBuilder) this.map).length;
        }

        public final void remove() {
            checkForComodification$kotlin_stdlib();
            if (!(this.lastIndex != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.map.checkIsMutable$kotlin_stdlib();
            this.map.removeEntryAt(this.lastIndex);
            this.lastIndex = -1;
            this.expectedModCount = ((MapBuilder) this.map).modCount;
        }

        public final void checkForComodification$kotlin_stdlib() {
            if (((MapBuilder) this.map).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u001d\bF\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00028\u0002H\u0096\u0082\u0004¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lni/shikatu/kotlin/collections/builders/MapBuilder$Itr;", _UrlKt.FRAGMENT_ENCODE_SET, "map", "Lni/shikatu/kotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {

        public KeysItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
        }

        @Override
        public K next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            K k = (K) ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return k;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u001d\bF\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00028\u0003H\u0096\u0082\u0004¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lni/shikatu/kotlin/collections/builders/MapBuilder$Itr;", _UrlKt.FRAGMENT_ENCODE_SET, "map", "Lni/shikatu/kotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {

        public ValuesItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
        }

        @Override
        public V next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
            Intrinsics.checkNotNull(objArr);
            V v = (V) objArr[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return v;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u001d\bF\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000bH\u0096\u0082\u0004J\u000f\u0010\f\u001a\u00020\rH\u0080\u0080\u0004¢\u0006\u0002\b\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013H\u0086\u0080\u0004¨\u0006\u0014"}, d2 = {"Lni/shikatu/kotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lni/shikatu/kotlin/collections/builders/MapBuilder$Itr;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "map", "Lni/shikatu/kotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lni/shikatu/kotlin/collections/builders/MapBuilder$EntryRef;", "nextHashCode", _UrlKt.FRAGMENT_ENCODE_SET, "nextHashCode$kotlin_stdlib", "nextAppendString", _UrlKt.FRAGMENT_ENCODE_SET, "sb", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {

        public EntriesItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
        }

        @Override
        public EntryRef<K, V> next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            EntryRef<K, V> entryRef = new EntryRef<>(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
            initNext$kotlin_stdlib();
            return entryRef;
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object obj = ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex$kotlin_stdlib()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
            Intrinsics.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
            int result = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            initNext$kotlin_stdlib();
            return result;
        }

        public final void nextAppendString(StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            if (getIndex$kotlin_stdlib() >= ((MapBuilder) getMap$kotlin_stdlib()).length) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object key = ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex$kotlin_stdlib()];
            if (key == getMap$kotlin_stdlib()) {
                sb.append("(this Map)");
            } else {
                sb.append(key);
            }
            sb.append('=');
            Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
            Intrinsics.checkNotNull(objArr);
            Object value = objArr[getLastIndex$kotlin_stdlib()];
            if (value == getMap$kotlin_stdlib()) {
                sb.append("(this Map)");
            } else {
                sb.append(value);
            }
            initNext$kotlin_stdlib();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B%\bF\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0010\u001a\u00028\u00032\u0006\u0010\u0011\u001a\u00028\u0003H\u0096\u0080\b¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0018\u001a\u00020\u0019H\u0096\u0080\u0004J\n\u0010\u001a\u001a\u00020\u001bH\u0082\u0080\u0004R\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000b\u001a\u00028\u00028VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u00028\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lni/shikatu/kotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", _UrlKt.FRAGMENT_ENCODE_SET, "map", "Lni/shikatu/kotlin/collections/builders/MapBuilder;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V", "expectedModCount", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "checkForComodification", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final int expectedModCount;
        private final int index;
        private final MapBuilder<K, V> map;

        public EntryRef(MapBuilder<K, V> mapBuilder, int index) {
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
            this.map = mapBuilder;
            this.index = index;
            this.expectedModCount = ((MapBuilder) this.map).modCount;
        }

        @Override
        public K getKey() {
            checkForComodification();
            return (K) ((MapBuilder) this.map).keysArray[this.index];
        }

        @Override
        public V getValue() {
            checkForComodification();
            Object[] objArr = ((MapBuilder) this.map).valuesArray;
            Intrinsics.checkNotNull(objArr);
            return (V) objArr[this.index];
        }

        @Override
        public V setValue(V v) {
            checkForComodification();
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] objArrAllocateValuesArray = this.map.allocateValuesArray();
            V v2 = (V) objArrAllocateValuesArray[this.index];
            objArrAllocateValuesArray[this.index] = v;
            return v2;
        }

        @Override
        public boolean equals(Object other) {
            return (other instanceof Map.Entry) && Intrinsics.areEqual(((Map.Entry) other).getKey(), getKey()) && Intrinsics.areEqual(((Map.Entry) other).getValue(), getValue());
        }

        @Override
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        public String toString() {
            return new StringBuilder().append(getKey()).append('=').append(getValue()).toString();
        }

        private final void checkForComodification() {
            if (((MapBuilder) this.map).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }
    }
}
