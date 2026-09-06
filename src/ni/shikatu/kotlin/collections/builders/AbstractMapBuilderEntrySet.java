package ni.shikatu.kotlin.collections.builders;

import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.AbstractMutableSet;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b \u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0002*\u0004\b\u0001\u0010\u0003*\u0004\b\u0002\u0010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\t\bF¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0082\u0004¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0002H¦\u0080\u0004¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/collections/builders/AbstractMapBuilderEntrySet;", "E", _UrlKt.FRAGMENT_ENCODE_SET, "K", "V", "Lni/shikatu/kotlin/collections/AbstractMutableSet;", "<init>", "()V", "contains", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Ljava/util/Map$Entry;)Z", "containsEntry", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class AbstractMapBuilderEntrySet<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    public abstract boolean containsEntry(Map.Entry<? extends K, ? extends V> entry);

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof Map.Entry) {
            return contains((Map.Entry) element);
        }
        return false;
    }

    @Override
    public final /* bridge */ boolean remove(Object element) {
        if (element instanceof Map.Entry) {
            return remove((Map.Entry<?, ?>) element);
        }
        return false;
    }

    public /* bridge */ boolean remove(Map.Entry<?, ?> entry) {
        return super.remove((Object) entry);
    }

    public final boolean contains(E e) {
        Intrinsics.checkNotNullParameter(e, "element");
        return containsEntry(e);
    }
}
