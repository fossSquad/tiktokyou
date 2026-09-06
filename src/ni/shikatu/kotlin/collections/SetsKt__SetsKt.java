package ni.shikatu.kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0086\u0080\u0004\u001a/\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0006\u001a\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\u0002\b\u0007\u001a(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0007\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0006\u001a7\u0010\r\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u000ej\b\u0012\u0004\u0012\u0002H\u0002`\u000f\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0007¢\u0006\u0002\u0010\u0010\u001a9\u0010\r\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u000ej\b\u0012\u0004\u0012\u0002H\u0002`\u000f\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0011\u001a7\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0013j\b\u0012\u0004\u0012\u0002H\u0002`\u0014\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0007¢\u0006\u0002\u0010\u0015\u001a9\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0013j\b\u0012\u0004\u0012\u0002H\u0002`\u0014\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0016\u001a7\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u0001H\u0002H\u0087\u0080\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b¢\u0006\u0002\u0010\u001a\u001aE\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00182\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00020\u0005\"\u0004\u0018\u0001H\u0002H\u0087\u0080\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b¢\u0006\u0002\u0010\u0006\u001a]\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0001\"\u0004\b\u0000\u0010\u001d2#\b\u0001\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001d0\t\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\b!:\u0002\b\"H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(#b\u0002\b\u0007ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001ae\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0001\"\u0004\b\u0000\u0010\u001d2\u0006\u0010$\u001a\u00020%2#\b\u0001\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001d0\t\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\b!:\u0002\b\"H\u0087\u0088\u0004b\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(#b\u0002\b\u0007ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a&\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0088\u0004b\u0002\b\u0007\u001a \u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0080\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"emptySet", _UrlKt.FRAGMENT_ENCODE_SET, "T", "setOf", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/util/Set;", "Lni/shikatu/kotlin/internal/InlineOnly;", "mutableSetOf", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "hashSetOf", "Ljava/util/HashSet;", "Lni/shikatu/kotlin/collections/HashSet;", "()Ljava/util/HashSet;", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lni/shikatu/kotlin/collections/LinkedHashSet;", "()Ljava/util/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "setOfNotNull", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Ljava/lang/Object;)Ljava/util/Set;", "1.4", "buildSet", "E", "builderAction", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ExtensionFunctionType;", "Lni/shikatu/kotlin/BuilderInference;", "1.6", "capacity", _UrlKt.FRAGMENT_ENCODE_SET, "orEmpty", "optimizeReadOnlySet", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/SetsKt")
public class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public static final <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    public static final <T> Set<T> setOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return ArraysKt.toSet(tArr);
    }

    private static final <T> Set<T> setOf() {
        return SetsKt.emptySet();
    }

    private static final <T> Set<T> mutableSetOf() {
        return new LinkedHashSet();
    }

    public static final <T> Set<T> mutableSetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return (Set) ArraysKt.toCollection(tArr, new LinkedHashSet(MapsKt.mapCapacity(tArr.length)));
    }

    private static final <T> HashSet<T> hashSetOf() {
        return new HashSet<>();
    }

    public static final <T> HashSet<T> hashSetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return (HashSet) ArraysKt.toCollection(tArr, new HashSet(MapsKt.mapCapacity(tArr.length)));
    }

    private static final <T> LinkedHashSet<T> linkedSetOf() {
        return new LinkedHashSet<>();
    }

    public static final <T> LinkedHashSet<T> linkedSetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return (LinkedHashSet) ArraysKt.toCollection(tArr, new LinkedHashSet(MapsKt.mapCapacity(tArr.length)));
    }

    public static final <T> Set<T> setOfNotNull(T t) {
        return t != null ? SetsKt.setOf(t) : SetsKt.emptySet();
    }

    public static final <T> Set<T> setOfNotNull(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return (Set) ArraysKt.filterNotNullTo(tArr, new LinkedHashSet());
    }

    private static final <E> Set<E> buildSet(Function1<? super Set<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        function1.invoke(setCreateSetBuilder);
        return SetsKt.build(setCreateSetBuilder);
    }

    private static final <E> Set<E> buildSet(int capacity, Function1<? super Set<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        Set setCreateSetBuilder = SetsKt.createSetBuilder(capacity);
        function1.invoke(setCreateSetBuilder);
        return SetsKt.build(setCreateSetBuilder);
    }

    private static final <T> Set<T> orEmpty(Set<? extends T> set) {
        return set == 0 ? SetsKt.emptySet() : set;
    }

    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        switch (set.size()) {
            case 0:
                return SetsKt.emptySet();
            case 1:
                return SetsKt.setOf(set.iterator().next());
            default:
                return set;
        }
    }
}
