package ni.shikatu.kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \f*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\fB\t\bD¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0082\u0004J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004Ê\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractSet;", "E", "Lni/shikatu/kotlin/collections/AbstractCollection;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E>, KMappedMarker {
    public static final Companion Companion = new Companion(null);

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected AbstractSet() {
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof Set) {
            return Companion.setEquals$kotlin_stdlib(this, (Set) other);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Companion.unorderedHashCode$kotlin_stdlib(this);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0080\u0080\u0004¢\u0006\u0002\b\bJ'\u0010\t\u001a\u00020\n2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0080\u0080\u0004¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/collections/AbstractSet$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "unorderedHashCode", _UrlKt.FRAGMENT_ENCODE_SET, "c", _UrlKt.FRAGMENT_ENCODE_SET, "unorderedHashCode$kotlin_stdlib", "setEquals", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "other", "setEquals$kotlin_stdlib", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int unorderedHashCode$kotlin_stdlib(Collection<?> collection) {
            Intrinsics.checkNotNullParameter(collection, "c");
            int hashCode = 0;
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                Object element = it.next();
                hashCode += element != null ? element.hashCode() : 0;
            }
            return hashCode;
        }

        public final boolean setEquals$kotlin_stdlib(Set<?> set, Set<?> set2) {
            Intrinsics.checkNotNullParameter(set, "c");
            Intrinsics.checkNotNullParameter(set2, "other");
            if (set.size() != set2.size()) {
                return false;
            }
            return set.containsAll(set2);
        }
    }
}
