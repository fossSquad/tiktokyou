package ni.shikatu.kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.builders.SetBuilder;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001aN\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\u0088\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fb\u0002\b\u0010ø\u0001\u0000\u001aV\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\u0088\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fb\u0002\b\u0010ø\u0001\u0000\u001a(\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\t\"\u0004\b\u0000\u0010\u0006H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001a0\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\t\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001a6\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001a/\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0019\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u001a\u001aK\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017\"\u0004\b\u0000\u0010\u00022\u001a\u0010\u001b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u001cj\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u001d2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0019\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"setOf", _UrlKt.FRAGMENT_ENCODE_SET, "T", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "buildSetInternal", "E", "builderAction", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ExtensionFunctionType;", "Lni/shikatu/kotlin/PublishedApi;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/internal/InlineOnly;", "capacity", _UrlKt.FRAGMENT_ENCODE_SET, "createSetBuilder", "build", "builder", "sortedSetOf", "Ljava/util/TreeSet;", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/util/TreeSet;", "comparator", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/SetsKt")
public class SetsKt__SetsJVMKt {
    public static final <T> Set<T> setOf(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        Intrinsics.checkNotNullExpressionValue(setSingleton, "singleton(...)");
        return setSingleton;
    }

    private static final <E> Set<E> buildSetInternal(Function1<? super Set<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        ((Function1) function1).invoke(setCreateSetBuilder);
        return SetsKt.build(setCreateSetBuilder);
    }

    private static final <E> Set<E> buildSetInternal(int capacity, Function1<? super Set<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        Set setCreateSetBuilder = SetsKt.createSetBuilder(capacity);
        ((Function1) function1).invoke(setCreateSetBuilder);
        return SetsKt.build(setCreateSetBuilder);
    }

    public static final <E> Set<E> createSetBuilder() {
        return new SetBuilder();
    }

    public static final <E> Set<E> createSetBuilder(int capacity) {
        return new SetBuilder(capacity);
    }

    public static final <E> Set<E> build(Set<E> set) {
        Intrinsics.checkNotNullParameter(set, "builder");
        return ((SetBuilder) set).build();
    }

    public static final <T> TreeSet<T> sortedSetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return (TreeSet) ArraysKt.toCollection(tArr, new TreeSet());
    }

    public static final <T> TreeSet<T> sortedSetOf(Comparator<? super T> comparator, T... tArr) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return (TreeSet) ArraysKt.toCollection(tArr, new TreeSet(comparator));
    }
}
