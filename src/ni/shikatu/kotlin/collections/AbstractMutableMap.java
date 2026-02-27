package ni.shikatu.kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractMutableMap;", "K", "V", "", "Ljava/util/AbstractMap;", "<init>", "()V", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractMutableMap<K, V> extends java.util.AbstractMap<K, V> implements Map<K, V>, KMutableMap {
    public abstract Set getEntries();

    @Override
    public abstract V put(K k, V v);

    @Override
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Object> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    @Override
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) getKeys();
    }

    @Override
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) getValues();
    }

    protected AbstractMutableMap() {
    }
}
