package fake.b;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class c implements Map, Serializable {
    public static final c a = new c();

    @Override
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean containsKey(Object obj) {
        return false;
    }

    @Override
    public final boolean containsValue(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        fake.d.c.b(obj, "value");
        return false;
    }

    @Override
    public final /* bridge */ Set entrySet() {
        return d.a;
    }

    @Override
    public final boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @Override
    public final /* bridge */  Object get(Object obj) {
        return null;
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
    public final /* bridge */ Set keySet() {
        return d.a;
    }

    @Override
    public final /* bridge */  Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final /* bridge */ int size() {
        return 0;
    }

    public final String toString() {
        return "{}";
    }

    @Override
    public final /* bridge */ Collection values() {
        return b.a;
    }
}
