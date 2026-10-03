package ni.shikatu.kotlin.comparisons;

import java.util.Comparator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a]\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u000226\u0010\u0005\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\t\u001aI\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u00022 \u0010\u0005\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006H\u0082\u0080\u0004¢\u0006\u0004\b\u000b\u0010\t\u001aF\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u00022\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\r\u001ab\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f2\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u00022\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000f0\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u000f`\u00122\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a1\u0010\u0014\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\b2\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0015\u001a]\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u000226\u0010\u0005\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u00070\u0006\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0017\u001aH\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001ad\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000f0\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u000f`\u00122\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001aH\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001ad\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000f0\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u000f`\u00122\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\\\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001ax\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000f0\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u000f`\u00122\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\\\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001ax\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000f0\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u000f`\u00122\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u0007H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001az\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u001228\b\u0004\u0010\u001f\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00010 H\u0087\u0088\u0004b\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010#\u001aU\u0010$\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0012H\u0086\u0084\u0004¢\u0006\u0002\u0010%\u001aU\u0010&\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u00122\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0012H\u0086\u0084\u0004¢\u0006\u0002\u0010%\u001aI\u0010'\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0011j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0012\"\b\b\u0000\u0010\u0002*\u00020(2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0012H\u0086\u0080\u0004¢\u0006\u0002\u0010)\u001a7\u0010'\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0011j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0012\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\u0088\u0004b\u0002\b\u000e¢\u0006\u0002\u0010*\u001aI\u0010+\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0011j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0012\"\b\b\u0000\u0010\u0002*\u00020(2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0011j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0012H\u0086\u0080\u0004¢\u0006\u0002\u0010)\u001a7\u0010+\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0011j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0012\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\u0088\u0004b\u0002\b\u000e¢\u0006\u0002\u0010*\u001a/\u0010,\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0080\u0004¢\u0006\u0002\u0010*\u001a/\u0010-\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0080\u0004¢\u0006\u0002\u0010*\u001a9\u0010.\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0011j\b\u0012\u0004\u0012\u0002H\u0002`\u0012H\u0086\u0080\u0004¢\u0006\u0002\u0010)\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006/"}, d2 = {"compareValuesBy", _UrlKt.FRAGMENT_ENCODE_SET, "T", "a", "b", "selectors", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "selector", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "Lni/shikatu/kotlin/internal/InlineOnly;", "K", "comparator", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValues", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareBy", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "compareByDescending", "thenBy", "(Ljava/util/Comparator;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "thenByDescending", "thenComparator", "comparison", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ParameterName;", "name", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function2;)Ljava/util/Comparator;", "then", "(Ljava/util/Comparator;Ljava/util/Comparator;)Ljava/util/Comparator;", "thenDescending", "nullsFirst", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/Comparator;)Ljava/util/Comparator;", "()Ljava/util/Comparator;", "nullsLast", "naturalOrder", "reverseOrder", "reversed", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/comparisons/ComparisonsKt")
public class ComparisonsKt__ComparisonsKt {
    public static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkNotNullParameter(function1Arr, "selectors");
        if (!(function1Arr.length > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(t, t2, function1Arr);
    }

    private static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T t, T t2, Function1<? super T, ? extends Comparable<?>>[] function1Arr) {
        for (Function1<? super T, ? extends Comparable<?>> function1 : function1Arr) {
            int diff = ComparisonsKt.compareValues(function1.invoke(t), function1.invoke(t2));
            if (diff != 0) {
                return diff;
            }
        }
        return 0;
    }

    private static final <T> int compareValuesBy(T t, T t2, Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, "selector");
        return ComparisonsKt.compareValues(function1.invoke(t), function1.invoke(t2));
    }

    private static final <T, K> int compareValuesBy(T t, T t2, Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return comparator.compare(function1.invoke(t), function1.invoke(t2));
    }

    public static final <T extends Comparable<?>> int compareValues(T t, T t2) {
        if (t == null) {
            return t2 == null ? 0 : -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static final <T> Comparator<T> compareBy(final Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.checkNotNullParameter(function1Arr, "selectors");
        if (!(function1Arr.length > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return new Comparator() {
            @Override
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.compareBy$lambda$0$ComparisonsKt__ComparisonsKt(function1Arr, obj, obj2);
            }
        };
    }

    public static final int compareBy$lambda$0$ComparisonsKt__ComparisonsKt(Function1[] $selectors, Object a, Object b) {
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(a, b, $selectors);
    }

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 176)
    public static final class AnonymousClass2<T> implements Comparator {
        final  Function1<T, Comparable<?>> $selector;

        public AnonymousClass2(Function1<? super T, ? extends Comparable<?>> function1) {
            this.$selector = function1;
        }

        @Override
        public final int compare(T t, T t2) {
            Function1<T, Comparable<?>> function1 = this.$selector;
            return ComparisonsKt.compareValues(function1.invoke(t), function1.invoke(t2));
        }
    }

    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new AnonymousClass2(function1);
    }

    private static final <T, K> Comparator<T> compareBy(final Comparator<? super K> comparator, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator() {

            @Override
            public final int compare(T t, T t2) {
                Comparator<? super K> comparator2 = comparator;
                Function1<T, K> function2 = function1;
                return comparator2.compare((Object) function2.invoke(t), (Object) function2.invoke(t2));
            }
        };
    }

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 176)
    public static final class AnonymousClass1<T> implements Comparator {
        final  Function1<T, Comparable<?>> $selector;

        public AnonymousClass1(Function1<? super T, ? extends Comparable<?>> function1) {
            this.$selector = function1;
        }

        @Override
        public final int compare(T t, T t2) {
            Function1<T, Comparable<?>> function1 = this.$selector;
            return ComparisonsKt.compareValues(function1.invoke(t2), function1.invoke(t));
        }
    }

    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new AnonymousClass1(function1);
    }

    private static final <T, K> Comparator<T> compareByDescending(final Comparator<? super K> comparator, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator() {

            @Override
            public final int compare(T t, T t2) {
                Comparator<? super K> comparator2 = comparator;
                Function1<T, K> function2 = function1;
                return comparator2.compare((Object) function2.invoke(t2), (Object) function2.invoke(t));
            }
        };
    }

    private static final <T> Comparator<T> thenBy(final Comparator<T> comparator, final Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator() {
            @Override
            public final int compare(T t, T t2) {
                int previousCompare = comparator.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                Function1<T, Comparable<?>> function2 = function1;
                return ComparisonsKt.compareValues(function2.invoke(t), function2.invoke(t2));
            }
        };
    }

    private static final <T, K> Comparator<T> thenBy(final Comparator<T> comparator, final Comparator<? super K> comparator2, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator() {

            @Override
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                Comparator<? super K> comparator3 = comparator2;
                Function1<T, K> function2 = function1;
                return comparator3.compare((Object) function2.invoke(t), (Object) function2.invoke(t2));
            }
        };
    }

    private static final <T> Comparator<T> thenByDescending(final Comparator<T> comparator, final Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator() {
            @Override
            public final int compare(T t, T t2) {
                int previousCompare = comparator.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                Function1<T, Comparable<?>> function2 = function1;
                return ComparisonsKt.compareValues(function2.invoke(t2), function2.invoke(t));
            }
        };
    }

    private static final <T, K> Comparator<T> thenByDescending(final Comparator<T> comparator, final Comparator<? super K> comparator2, final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return new Comparator() {

            @Override
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                Comparator<? super K> comparator3 = comparator2;
                Function1<T, K> function2 = function1;
                return comparator3.compare((Object) function2.invoke(t2), (Object) function2.invoke(t));
            }
        };
    }

    private static final <T> Comparator<T> thenComparator(final Comparator<T> comparator, final Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(function2, "comparison");
        return new Comparator() {
            @Override
            public final int compare(T t, T t2) {
                int previousCompare = comparator.compare(t, t2);
                return previousCompare != 0 ? previousCompare : function2.invoke(t, t2).intValue();
            }
        };
    }

    public static final <T> Comparator<T> then(final Comparator<T> comparator, final Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new Comparator() {
            @Override
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.then$lambda$0$ComparisonsKt__ComparisonsKt(comparator, comparator2, obj, obj2);
            }
        };
    }

    public static final int then$lambda$0$ComparisonsKt__ComparisonsKt(Comparator $this_then, Comparator $comparator, Object a, Object b) {
        int previousCompare = $this_then.compare(a, b);
        return previousCompare != 0 ? previousCompare : $comparator.compare(a, b);
    }

    public static final <T> Comparator<T> thenDescending(final Comparator<T> comparator, final Comparator<? super T> comparator2) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new Comparator() {
            @Override
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.thenDescending$lambda$0$ComparisonsKt__ComparisonsKt(comparator, comparator2, obj, obj2);
            }
        };
    }

    public static final int thenDescending$lambda$0$ComparisonsKt__ComparisonsKt(Comparator $this_thenDescending, Comparator $comparator, Object a, Object b) {
        int previousCompare = $this_thenDescending.compare(a, b);
        return previousCompare != 0 ? previousCompare : $comparator.compare(b, a);
    }

    public static final <T> Comparator<T> nullsFirst(final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new Comparator() {
            @Override
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.nullsFirst$lambda$0$ComparisonsKt__ComparisonsKt(comparator, obj, obj2);
            }
        };
    }

    public static final int nullsFirst$lambda$0$ComparisonsKt__ComparisonsKt(Comparator $comparator, Object a, Object b) {
        if (a == null) {
            return b == null ? 0 : -1;
        }
        if (b == null) {
            return 1;
        }
        return $comparator.compare(a, b);
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return ComparisonsKt.nullsFirst(ComparisonsKt.naturalOrder());
    }

    public static final <T> Comparator<T> nullsLast(final Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new Comparator() {
            @Override
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt__ComparisonsKt.nullsLast$lambda$0$ComparisonsKt__ComparisonsKt(comparator, obj, obj2);
            }
        };
    }

    public static final int nullsLast$lambda$0$ComparisonsKt__ComparisonsKt(Comparator $comparator, Object a, Object b) {
        if (a == null) {
            return b == null ? 0 : 1;
        }
        if (b == null) {
            return -1;
        }
        return $comparator.compare(a, b);
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(naturalOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>");
        return naturalOrderComparator;
    }

    public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(reverseOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>");
        return reverseOrderComparator;
    }

    public static final <T> Comparator<T> reversed(Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "<this>");
        if (comparator instanceof ReversedComparator) {
            return ((ReversedComparator) comparator).getComparator();
        }
        if (Intrinsics.areEqual(comparator, NaturalOrderComparator.INSTANCE)) {
            ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.INSTANCE;
            Intrinsics.checkNotNull(reverseOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>");
            return reverseOrderComparator;
        }
        if (!Intrinsics.areEqual(comparator, ReverseOrderComparator.INSTANCE)) {
            return new ReversedComparator(comparator);
        }
        NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(naturalOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>");
        return naturalOrderComparator;
    }
}
