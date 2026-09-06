package ni.shikatu.kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NotImplementedError;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001ar\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0005j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0006H\u0087\u0088\u0004b6\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u001c\b\n\u0012\u0018\b\u000bB\u0014\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0006\b\u000e\u0012\u0002\b\f\u0012\n\b\u000f\u0012\u0006\b\n0\u00108\u0011b\u0002\b\u0012\u001as\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00150\u0014H\u0087\u0088\u0004b6\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0016\u0012\u001c\b\n\u0012\u0018\b\u000bB\u0014\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0017\u0012\u0006\b\u000e\u0012\u0002\b\f\u0012\n\b\u000f\u0012\u0006\b\n0\u00108\u0011b\u0002\b\u0012ø\u0001\u0000\u001a$\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0018*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0080\u0004\u001a6\u0010\u0019\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0005j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0006H\u0086\u0080\u0004\u001a9\u0010\u001a\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001b\u001a\u0002H\u0002H\u0087\u0088\u0004b\u0002\b\u0012b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f¢\u0006\u0002\u0010\u001c\u001a,\u0010 \u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0012b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u001a4\u0010 \u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0087\u0088\u0004b\u0002\b\u0012b\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"sort", _UrlKt.FRAGMENT_ENCODE_SET, "T", _UrlKt.FRAGMENT_ENCODE_SET, "comparator", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "Lni/shikatu/kotlin/Deprecated;", "message", "Use sortWith(comparator) instead.", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "this.sortWith(comparator)", "imports", "level", "Lni/shikatu/kotlin/DeprecationLevel;", "ERROR", "Lni/shikatu/kotlin/internal/InlineOnly;", "comparison", "Lni/shikatu/kotlin/Function2;", _UrlKt.FRAGMENT_ENCODE_SET, "Use sortWith(Comparator(comparison)) instead.", "this.sortWith(Comparator(comparison))", _UrlKt.FRAGMENT_ENCODE_SET, "sortWith", "fill", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.2", "shuffle", "random", "Ljava/util/Random;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/CollectionsKt")
public class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(comparator)", imports = {}))
    private static final <T> void sort(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    private static final <T> void sort(List<T> list, Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function2, "comparison");
        throw new NotImplementedError(null, 1, null);
    }

    public static final <T extends Comparable<? super T>> void sort(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    private static final <T> void fill(List<T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.fill(list, t);
    }

    private static final <T> void shuffle(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.shuffle(list);
    }

    private static final <T> void shuffle(List<T> list, Random random) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        Collections.shuffle(list, random);
    }
}
