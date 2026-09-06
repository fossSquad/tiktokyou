package ni.shikatu.kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 **\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001*B\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0002\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000eH\u0080\u0080\u0004¢\u0006\u0002\b\u000fJ\u0014\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0082\u0004J\u0019\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0014J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010 \u001a\u00020!H\u0096\u0080\u0004J\u001e\u0010 \u001a\u00020!2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000eH\u0082\u0080\u0004J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0082\u0080\u0004J%\u0010(\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0082\u0080\u0004¢\u0006\u0002\u0010)R\u0015\u0010\u0018\u001a\u00020\u00168VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010$8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010$X\u0082\u008e\b¢\u0006\u0002\n\u0000Ê\u0001\f\b,\u0012\b\b-\u0012\u0004\b\b(.¨\u0006+"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractMap;", "K", "V", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "containsKey", _UrlKt.FRAGMENT_ENCODE_SET, "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "containsEntry", "entry", _UrlKt.FRAGMENT_ENCODE_SET, "containsEntry$kotlin_stdlib", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "isEmpty", "size", "getSize", "()I", "keys", _UrlKt.FRAGMENT_ENCODE_SET, "getKeys", "()Ljava/util/Set;", "_keys", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "o", "values", _UrlKt.FRAGMENT_ENCODE_SET, "getValues", "()Ljava/util/Collection;", "_values", "implFindEntry", "(Ljava/lang/Object;)Ljava/util/Map$Entry;", "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private volatile Set<? extends K> _keys;
    private volatile Collection<? extends V> _values;

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract Set<Map.Entry<K, V>> getEntries();

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

    protected AbstractMap() {
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

    @Override
    public boolean containsKey(Object obj) {
        return implFindEntry(obj) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        Iterable $this$any$iv = entrySet();
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            Map.Entry it = (Map.Entry) element$iv;
            if (Intrinsics.areEqual(it.getValue(), value)) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        AbstractMap<K, V> abstractMap = this;
        Intrinsics.checkNotNull(abstractMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Object ourValue = abstractMap.get(key);
        if (!Intrinsics.areEqual(value, ourValue)) {
            return false;
        }
        if (ourValue != null) {
            return true;
        }
        AbstractMap<K, V> abstractMap2 = this;
        Intrinsics.checkNotNull(abstractMap2, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        if (!abstractMap2.containsKey(key)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Map) || size() != ((Map) other).size()) {
            return false;
        }
        Iterable $this$all$iv = ((Map) other).entrySet();
        if (($this$all$iv instanceof Collection) && ((Collection) $this$all$iv).isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!containsEntry$kotlin_stdlib((Map.Entry) element$iv)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public V get(Object obj) {
        Map.Entry<K, V> entryImplFindEntry = implFindEntry(obj);
        if (entryImplFindEntry != null) {
            return entryImplFindEntry.getValue();
        }
        return null;
    }

    @Override
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int getSize() {
        return entrySet().size();
    }

    public Set<K> getKeys() {
        if (this._keys == null) {
            this._keys = new AbstractSet<K>(this) {
                final  AbstractMap<K, V> this$0;

                {
                    this.this$0 = this;
                }

                @Override
                public boolean contains(Object element) {
                    return this.this$0.containsKey(element);
                }

                @Override
                public Iterator<K> iterator() {
                    Iterator entryIterator = this.this$0.entrySet().iterator();
                    return new AbstractMap$keys$1$iterator$1(entryIterator);
                }

                @Override
                public int getSize() {
                    return this.this$0.size();
                }
            };
        }
        Set<? extends K> set = this._keys;
        Intrinsics.checkNotNull(set);
        return set;
    }

    public static final CharSequence toString$lambda$0(AbstractMap this$0, Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.toString(it);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(entrySet(), ", ", "{", "}", 0, null, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return AbstractMap.toString$lambda$0(this.f$0, (Map.Entry) obj);
            }
        }, 24, null);
    }

    private final String toString(Map.Entry<? extends K, ? extends V> entry) {
        return toString(entry.getKey()) + '=' + toString(entry.getValue());
    }

    private final String toString(Object o) {
        return o == this ? "(this Map)" : String.valueOf(o);
    }

    public Collection<V> getValues() {
        if (this._values == null) {
            this._values = new AbstractCollection<V>(this) {
                final  AbstractMap<K, V> this$0;

                {
                    this.this$0 = this;
                }

                @Override
                public boolean contains(Object element) {
                    return this.this$0.containsValue(element);
                }

                @Override
                public Iterator<V> iterator() {
                    return new AbstractMap$values$1$iterator$1(this.this$0.entrySet().iterator());
                }

                @Override
                public int getSize() {
                    return this.this$0.size();
                }
            };
        }
        Collection<? extends V> collection = this._values;
        Intrinsics.checkNotNull(collection);
        return collection;
    }

    private final Map.Entry<K, V> implFindEntry(K k) {
        Object element$iv;
        Iterable $this$firstOrNull$iv = entrySet();
        Iterator it = $this$firstOrNull$iv.iterator();
        while (it.hasNext()) {
            element$iv = it.next();
            Map.Entry it2 = (Map.Entry) element$iv;
            if (Intrinsics.areEqual(it2.getKey(), k)) {
                return (Map.Entry) element$iv;
            }
        }
        element$iv = null;
        return (Map.Entry) element$iv;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\bJ\u001f\u0010\t\u001a\u00020\n2\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\u000bJ)\u0010\f\u001a\u00020\r2\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0080\u0080\u0004¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractMap$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "entryHashCode", _UrlKt.FRAGMENT_ENCODE_SET, "e", _UrlKt.FRAGMENT_ENCODE_SET, "entryHashCode$kotlin_stdlib", "entryToString", _UrlKt.FRAGMENT_ENCODE_SET, "entryToString$kotlin_stdlib", "entryEquals", _UrlKt.FRAGMENT_ENCODE_SET, "other", "entryEquals$kotlin_stdlib", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int entryHashCode$kotlin_stdlib(Map.Entry<?, ?> entry) {
            Intrinsics.checkNotNullParameter(entry, "e");
            Object key = entry.getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = entry.getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        public final String entryToString$kotlin_stdlib(Map.Entry<?, ?> entry) {
            Intrinsics.checkNotNullParameter(entry, "e");
            return new StringBuilder().append(entry.getKey()).append('=').append(entry.getValue()).toString();
        }

        public final boolean entryEquals$kotlin_stdlib(Map.Entry<?, ?> entry, Object other) {
            Intrinsics.checkNotNullParameter(entry, "e");
            return (other instanceof Map.Entry) && Intrinsics.areEqual(entry.getKey(), ((Map.Entry) other).getKey()) && Intrinsics.areEqual(entry.getValue(), ((Map.Entry) other).getValue());
        }
    }
}
