package ni.shikatu.kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00060\u0004j\u0002`\u0005B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010%\u001a\u00020\u0002H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u001a\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lni/shikatu/kotlin/collections/EmptyMap;", "", "", "", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "equals", "", "other", "hashCode", "", "toString", "", "size", "getSize", "()I", "isEmpty", "containsKey", "key", "containsValue", "value", "get", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "readResolve", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class EmptyMap implements Map, Serializable, KMappedMarker {
    public static final EmptyMap INSTANCE = new EmptyMap();
    private static final long serialVersionUID = 8246714829545688274L;

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void put(Object obj, Void r4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private EmptyMap() {
    }

    @Override
    public final /* bridge */ boolean containsValue(Object value) {
        if (value instanceof Void) {
            return containsValue((Void) value);
        }
        return false;
    }

    @Override
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return getEntries();
    }

    @Override
    public final /* bridge */ Set<Object> keySet() {
        return getKeys();
    }

    @Override
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override
    public final /* bridge */ Collection values() {
        return getValues();
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Map) && ((Map) other).isEmpty();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "{}";
    }

    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Void value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return false;
    }

    @Override
    public Void get(Object key) {
        return null;
    }

    public Set<Map.Entry> getEntries() {
        return EmptySet.INSTANCE;
    }

    public Set<Object> getKeys() {
        return EmptySet.INSTANCE;
    }

    public Collection getValues() {
        return EmptyList.INSTANCE;
    }

    private final Object readResolve() {
        return INSTANCE;
    }
}
