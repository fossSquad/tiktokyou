package fake.b;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class b implements List, Serializable, RandomAccess {
    public static final b a = new b();

    @Override
    public final /* bridge */  void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final /* bridge */  boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean addAll(int i, Collection collection) {
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
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override
    public final Object get(int i) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i + '.');
    }

    @Override
    public final int hashCode() {
        return 1;
    }

    @Override
    public final int indexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        fake.d.c.b(obj, "element");
        return -1;
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
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        fake.d.c.b(obj, "element");
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return a.a;
    }

    @Override
    public final ListIterator listIterator(int i) {
        if (i == 0) {
            return a.a;
        }
        throw new IndexOutOfBoundsException("Index: " + i);
    }

    @Override
    public final /* bridge */  Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
    public final /* bridge */  Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final /* bridge */ int size() {
        return 0;
    }

    @Override
    public final List subList(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2);
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
