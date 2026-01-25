package fake.b;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class a implements ListIterator {
    public static final a a = new a();

    @Override
    public final /* bridge */  void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean hasNext() {
        return false;
    }

    @Override
    public final boolean hasPrevious() {
        return false;
    }

    @Override
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public final int nextIndex() {
        return 0;
    }

    @Override
    public final Object previous() {
        throw new NoSuchElementException();
    }

    @Override
    public final int previousIndex() {
        return -1;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final /* bridge */  void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
