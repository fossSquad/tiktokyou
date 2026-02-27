package ni.shikatu.kotlin.comparisons;

import java.util.Comparator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J'\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lni/shikatu/kotlin/comparisons/NaturalOrderComparator;", "Ljava/util/Comparator;", "", "", "Lni/shikatu/kotlin/Comparator;", "<init>", "()V", "compare", "", "a", "b", "reversed", "()Ljava/util/Comparator;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class NaturalOrderComparator implements Comparator<Comparable<? super Object>> {
    public static final NaturalOrderComparator INSTANCE = new NaturalOrderComparator();

    private NaturalOrderComparator() {
    }

    @Override
    public /* bridge */  int compare(Comparable<? super Object> comparable, Comparable<? super Object> comparable2) {
        return compare2((Comparable<Object>) comparable, (Comparable<Object>) comparable2);
    }

    public int compare2(Comparable<Object> comparable, Comparable<Object> comparable2) {
        Intrinsics.checkNotNullParameter(comparable, "a");
        Intrinsics.checkNotNullParameter(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    @Override
    public final Comparator<Comparable<? super Object>> reversed() {
        return ReverseOrderComparator.INSTANCE;
    }
}
