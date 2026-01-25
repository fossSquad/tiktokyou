package fake.b;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class d implements Set, Serializable {
    public static final d a = new d();

    @Override
    public final /* bridge */  boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        fake.d.c.b(obj, "element");
        return false;
    }

    @Override
    public final boolean containsAll(Collection collection) {
        fake.d.c.b(collection, "elements");
        return collection.isEmpty();
    }

    @Override
    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override
    public final int hashCode() {
        return 0;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final Iterator iterator() {
        return a.a;
    }

    @Override
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final /* bridge */ int size() {
        return 0;
    }

    @Override
    public final Object[] toArray() {
        return fake.d.a.a(this);
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        fake.d.c.b(objArr, "array");
        return fake.d.a.a(this, objArr);
    }

    public final String toString() {
        return "[]";
    }
}
