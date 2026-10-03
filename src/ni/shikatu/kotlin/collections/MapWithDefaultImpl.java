package ni.shikatu.kotlin.collections;
import java.util.Map.Entry;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B@\bF\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0082\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u001a\u001a\u00020\u0010H\u0096\u0080\u0004J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\u001cJ\u0019\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010 J\u0017\u0010,\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010 R!\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0017\u001a\u00020\u00148VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010&8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b'\u0010(R'\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*0\"8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b+\u0010$¨\u0006-"}, d2 = {"Lni/shikatu/kotlin/collections/MapWithDefaultImpl;", "K", "V", "Lni/shikatu/kotlin/collections/MapWithDefault;", "map", _UrlKt.FRAGMENT_ENCODE_SET, "default", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ParameterName;", "name", "key", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "getMap", "()Ljava/util/Map;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "size", "getSize", "()I", "isEmpty", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "keys", _UrlKt.FRAGMENT_ENCODE_SET, "getKeys", "()Ljava/util/Set;", "values", _UrlKt.FRAGMENT_ENCODE_SET, "getValues", "()Ljava/util/Collection;", "entries", _UrlKt.FRAGMENT_ENCODE_SET, "getEntries", "getOrImplicitDefault", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class MapWithDefaultImpl<K, V> implements MapWithDefault<K, V> {

    private final Function1<K, V> f1default;
    private final Map<K, V> map;

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public MapWithDefaultImpl(Map<K, ? extends V> map, Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(function1, "default");
        this.map = (Map<K,V>) (map);
        this.f1default = (Function1<K,V>) (function1);
    }

    @Override
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override
    public Map<K, V> getMap() {
        return this.map;
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

    @Override
    public boolean equals(Object other) {
        return getMap().equals(other);
    }

    @Override
    public int hashCode() {
        return getMap().hashCode();
    }

    public String toString() {
        return getMap().toString();
    }

    public int getSize() {
        return getMap().size();
    }

    @Override
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return getMap().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return getMap().containsValue(value);
    }

    @Override
    public V get(Object key) {
        return getMap().get(key);
    }

    public Set<K> getKeys() {
        return getMap().keySet();
    }

    public Collection<V> getValues() {
        return getMap().values();
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return getMap().entrySet();
    }

    @Override
    public V getOrImplicitDefault(K k) {
        Map<K, V> map = getMap();
        V v = map.get(k);
        return (v != null || map.containsKey(k)) ? v : this.f1default.invoke(k);
    }
}
