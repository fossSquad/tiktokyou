package ni.shikatu.kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.CollectionToArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH¦\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0015\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0015¢\u0006\u0002\u0010\u0017J'\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0015\"\u0004\b\u0001\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0015H\u0014¢\u0006\u0002\u0010\u001aR\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractCollection;", "E", "", "<init>", "()V", "size", "", "getSize", "()I", "iterator", "", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "toString", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractCollection<E> implements Collection<E>, KMappedMarker {
    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract int getSize();

    @Override
    public abstract Iterator<E> iterator();

    @Override
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final /* bridge */ int size() {
        return getSize();
    }

    protected AbstractCollection() {
    }

    @Override
    public boolean contains(E e) {
        AbstractCollection<E> $this$any$iv = this;
        if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            if (Intrinsics.areEqual(element$iv, e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Collection<? extends Object> $this$all$iv = collection;
        if ($this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!contains(element$iv)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this, ", ", "[", "]", 0, null, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return AbstractCollection.toString$lambda$2(this.f$0, obj);
            }
        }, 24, null);
    }

    public static final CharSequence toString$lambda$2(AbstractCollection this$0, Object it) {
        return it == this$0 ? "(this Collection)" : String.valueOf(it);
    }

    @Override
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }
}
