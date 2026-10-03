package ni.shikatu.kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0082\u0004¨\u0006\u0004"}, d2 = {"iterator", _UrlKt.FRAGMENT_ENCODE_SET, "T", "Ljava/util/Enumeration;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/CollectionsKt")
public class CollectionsKt__IteratorsJVMKt extends CollectionsKt__IterablesKt {

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\n\u0010\u0002\u001a\u00020\u0003H\u0096\u0082\u0004J\u000f\u0010\u0004\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"ni/shikatu/kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "()Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class AnonymousClass1<T> implements Iterator<T>, KMappedMarker {
        final  Enumeration<T> $this_iterator;

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1(Enumeration<T> enumeration) {
            this.$this_iterator = enumeration;
        }

        @Override
        public boolean hasNext() {
            return this.$this_iterator.hasMoreElements();
        }

        @Override
        public T next() {
            return this.$this_iterator.nextElement();
        }
    }

    public static final <T> Iterator<T> iterator(Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        return new AnonymousClass1(enumeration);
    }
}
