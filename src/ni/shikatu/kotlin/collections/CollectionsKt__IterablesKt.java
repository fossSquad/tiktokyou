package ni.shikatu.kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001¢\u0006\u0002\u0010\b\u001a \u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\n\u001a\u00020\u0007H\u0001\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a@\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\f0\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u000e0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Iterable", "", "T", "iterator", "Lni/shikatu/kotlin/Function0;", "", "collectionSizeOrNull", "", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "collectionSizeOrDefault", "default", "flatten", "", "unzip", "Lni/shikatu/kotlin/Pair;", "R", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/CollectionsKt")
public class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004"}, d2 = {"ni/shikatu/kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 176)
    public static final class AnonymousClass1<T> implements Iterable<T>, KMappedMarker {
        final  Function0<Iterator<T>> $iterator;

        public AnonymousClass1(Function0<? extends Iterator<? extends T>> function0) {
            this.$iterator = function0;
        }

        @Override
        public Iterator<T> iterator() {
            return this.$iterator.invoke();
        }
    }

    private static final <T> Iterable<T> Iterable(Function0<? extends Iterator<? extends T>> function0) {
        Intrinsics.checkNotNullParameter(function0, "iterator");
        return new AnonymousClass1(function0);
    }

    public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    public static final <T> int collectionSizeOrDefault(Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }

    public static final <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList result = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(result, it.next());
        }
        return result;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Iterable<? extends Pair<? extends T, ? extends R>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int expectedSize = CollectionsKt.collectionSizeOrDefault(iterable, 10);
        ArrayList listT = new ArrayList(expectedSize);
        ArrayList listR = new ArrayList(expectedSize);
        for (Pair<? extends T, ? extends R> pair : iterable) {
            listT.add(pair.getFirst());
            listR.add(pair.getSecond());
        }
        return TuplesKt.to(listT, listR);
    }
}
