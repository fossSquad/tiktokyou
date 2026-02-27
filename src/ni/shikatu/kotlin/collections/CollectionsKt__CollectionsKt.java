package ni.shikatu.kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.comparisons.ComparisonsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.random.Random;
import ni.shikatu.kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002¢\u0006\u0002\u0010\t\u001a\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002H\u0087\b\u001a\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002H\u0087\b\u001a$\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\rj\b\u0012\u0004\u0012\u0002H\u0002`\u000e\"\u0004\b\u0000\u0010\u0002H\u0087\b¢\u0006\u0002\u0010\u000f\u001a+\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002¢\u0006\u0002\u0010\t\u001a5\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\rj\b\u0012\u0004\u0012\u0002H\u0002`\u000e\"\u0004\b\u0000\u0010\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0014\u001a3\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020\u00122\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00020\u0003\"\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\t\u001aC\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0016\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u00020\u0019H\u0087\bø\u0001\u0000\u001aC\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0016\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u00020\u0019H\u0087\bø\u0001\u0000\u001aF\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0006\"\u0004\b\u0000\u0010\u001f2\u001f\b\u0001\u0010 \u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001f0\u000b\u0012\u0004\u0012\u00020!0\u0019¢\u0006\u0002\b\"H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aN\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0006\"\u0004\b\u0000\u0010\u001f2\u0006\u0010#\u001a\u00020\u00172\u001f\b\u0001\u0010 \u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001f0\u000b\u0012\u0004\u0012\u00020!0\u0019¢\u0006\u0002\b\"H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u0019\u0010+\u001a\u00020,\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\b\u001a,\u0010-\u001a\u00020,\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a!\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a!\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0006H\u0087\b\u001aH\u0010/\u001a\u0002H0\"\u0010\b\u0000\u00101*\u0006\u0012\u0002\b\u00030\u0001*\u0002H0\"\u0004\b\u0001\u00100*\u0002H12\f\u00102\u001a\b\u0012\u0004\u0012\u0002H003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u00104\u001a,\u00105\u001a\u00020,\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b6*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\b\u001a&\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u0002082\u0006\u00109\u001a\u00020:H\u0007\u001a\u001e\u0010;\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000\u001aE\u0010<\u001a\u00020\u0017\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020=*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\b\b\u0002\u0010>\u001a\u00020\u00172\b\b\u0002\u0010?\u001a\u00020\u0017¢\u0006\u0002\u0010@\u001aS\u0010<\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0013\u001a\u0002H\u00022\u001a\u0010A\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020Bj\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`C2\b\b\u0002\u0010>\u001a\u00020\u00172\b\b\u0002\u0010?\u001a\u00020\u0017¢\u0006\u0002\u0010D\u001ag\u0010E\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010F*\b\u0012\u0004\u0012\u0002HF0=*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\u0010G\u001a\u0004\u0018\u0001HF2\b\b\u0002\u0010>\u001a\u00020\u00172\b\b\u0002\u0010?\u001a\u00020\u00172\u0016\b\u0004\u0010H\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001HF0\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010I\u001a>\u0010<\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010>\u001a\u00020\u00172\b\b\u0002\u0010?\u001a\u00020\u00172\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00170\u0019\u001a%\u0010K\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u0017H\u0002¢\u0006\u0002\bL\u001a\b\u0010M\u001a\u00020!H\u0001\u001a\b\u0010N\u001a\u00020!H\u0001\u001a!\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00032\n\u0010P\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0002\u0010Q\u001a3\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\n\u0010P\u001a\u0006\u0012\u0002\b\u00030\u00012\f\u0010R\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000¢\u0006\u0002\u0010S\"\u0019\u0010$\u001a\u00020%*\u0006\u0012\u0002\b\u00030\u00018F¢\u0006\u0006\u001a\u0004\b&\u0010'\"!\u0010(\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00068F¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006T"}, d2 = {"asCollection", "", "T", "", "([Ljava/lang/Object;)Ljava/util/Collection;", "emptyList", "", "listOf", "elements", "([Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "", "arrayListOf", "Ljava/util/ArrayList;", "Lni/shikatu/kotlin/collections/ArrayList;", "()Ljava/util/ArrayList;", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "List", "size", "", "init", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ParameterName;", "name", "index", "MutableList", "buildList", "E", "builderAction", "", "Lni/shikatu/kotlin/ExtensionFunctionType;", "capacity", "indices", "Lni/shikatu/kotlin/ranges/IntRange;", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "(Ljava/util/List;)I", "isNotEmpty", "", "isNullOrEmpty", "orEmpty", "ifEmpty", "R", "C", "defaultValue", "Lni/shikatu/kotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "containsAll", "Lni/shikatu/kotlin/internal/OnlyInputTypes;", "shuffled", "", "random", "Lni/shikatu/kotlin/random/Random;", "optimizeReadOnlyList", "binarySearch", "", "fromIndex", "toIndex", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "comparator", "Ljava/util/Comparator;", "Lni/shikatu/kotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "comparison", "rangeCheck", "rangeCheck$CollectionsKt__CollectionsKt", "throwIndexOverflow", "throwCountOverflow", "collectionToArrayCommonImpl", "collection", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/CollectionsKt")
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static final <T> Collection<T> asCollection(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayAsCollection(tArr, false);
    }

    public static final <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static final <T> List<T> listOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return tArr.length > 0 ? ArraysKt.asList(tArr) : CollectionsKt.emptyList();
    }

    private static final <T> List<T> listOf() {
        return CollectionsKt.emptyList();
    }

    private static final <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList<>();
    }

    public static final <T> List<T> mutableListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(tArr, true));
    }

    public static final <T> ArrayList<T> arrayListOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new ArrayAsCollection(tArr, true));
    }

    public static final <T> List<T> listOfNotNull(T t) {
        return t != null ? CollectionsKt.listOf(t) : CollectionsKt.emptyList();
    }

    public static final <T> List<T> listOfNotNull(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return ArraysKt.filterNotNull(tArr);
    }

    private static final <T> List<T> List(int size, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(function1.invoke(Integer.valueOf(i)));
        }
        return arrayList;
    }

    private static final <T> List<T> MutableList(int size, Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        ArrayList list = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            int index = i;
            list.add(function1.invoke(Integer.valueOf(index)));
        }
        return list;
    }

    private static final <E> List<E> buildList(Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        function1.invoke(listCreateListBuilder);
        return CollectionsKt.build(listCreateListBuilder);
    }

    private static final <E> List<E> buildList(int capacity, Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        List listCreateListBuilder = CollectionsKt.createListBuilder(capacity);
        function1.invoke(listCreateListBuilder);
        return CollectionsKt.build(listCreateListBuilder);
    }

    public static final IntRange getIndices(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static final <T> int getLastIndex(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    private static final <T> boolean isNotEmpty(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return !collection.isEmpty();
    }

    private static final <T> boolean isNullOrEmpty(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    private static final <T> Collection<T> orEmpty(Collection<? extends T> collection) {
        return collection == 0 ? CollectionsKt.emptyList() : collection;
    }

    private static final <T> List<T> orEmpty(List<? extends T> list) {
        return list == 0 ? CollectionsKt.emptyList() : list;
    }

    private static final Object ifEmpty(Collection $this$ifEmpty, Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return $this$ifEmpty.isEmpty() ? defaultValue.invoke() : $this$ifEmpty;
    }

    private static final <T> boolean containsAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(collection2, "elements");
        return collection.containsAll(collection2);
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        CollectionsKt.shuffle(mutableList, random);
        return mutableList;
    }

    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        switch (list.size()) {
            case 0:
                return CollectionsKt.emptyList();
            case 1:
                return CollectionsKt.listOf(list.get(0));
            default:
                return list;
        }
    }

    public static  int binarySearch$default(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch((List<? extends Comparable>) list, comparable, i, i2);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T t, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable midVal = list.get(mid);
            int cmp = ComparisonsKt.compareValues(midVal, t);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static  int binarySearch$default(List list, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch(list, obj, comparator, i, i2);
    }

    public static final <T> int binarySearch(List<? extends T> list, T t, Comparator<? super T> comparator, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Object midVal = list.get(mid);
            int cmp = comparator.compare(midVal, t);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static  int binarySearchBy$default(List $this$binarySearchBy_u24default, Comparable key, int fromIndex, int toIndex, Function1 selector, int i, Object obj) {
        if ((i & 2) != 0) {
            fromIndex = 0;
        }
        if ((i & 4) != 0) {
            toIndex = $this$binarySearchBy_u24default.size();
        }
        Intrinsics.checkNotNullParameter($this$binarySearchBy_u24default, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return CollectionsKt.binarySearch($this$binarySearchBy_u24default, fromIndex, toIndex, new AnonymousClass1(selector, key));
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    public static final class AnonymousClass1<T> implements Function1<T, Integer> {

        final  Comparable $key;
        final  Function1<T, K> $selector;

        public AnonymousClass1(Function1 function1, Comparable comparable) {
            this.$selector = function1;
            this.$key = comparable;
        }

        @Override
        public final Integer invoke(T t) {
            return Integer.valueOf(ComparisonsKt.compareValues((Comparable) this.$selector.invoke(t), this.$key));
        }
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> list, K k, int fromIndex, int toIndex, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return CollectionsKt.binarySearch(list, fromIndex, toIndex, new AnonymousClass1(function1, k));
    }

    public static  int binarySearch$default(List list, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = list.size();
        }
        return CollectionsKt.binarySearch(list, i, i2, function1);
    }

    public static final <T> int binarySearch(List<? extends T> list, int fromIndex, int toIndex, Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), fromIndex, toIndex);
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Object midVal = list.get(mid);
            int cmp = function1.invoke(midVal).intValue();
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int size, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex (" + fromIndex + ") is greater than toIndex (" + toIndex + ").");
        }
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + fromIndex + ") is less than zero.");
        }
        if (toIndex > size) {
            throw new IndexOutOfBoundsException("toIndex (" + toIndex + ") is greater than size (" + size + ").");
        }
    }

    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static final Object[] collectionToArrayCommonImpl(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (collection.isEmpty()) {
            return new Object[0];
        }
        Object[] destination = new Object[collection.size()];
        Iterator<?> it = collection.iterator();
        int index = 0;
        while (it.hasNext()) {
            destination[index] = it.next();
            index++;
        }
        return destination;
    }

    public static final <T> T[] collectionToArrayCommonImpl(Collection<?> collection, T[] tArr) {
        Object[] objArrArrayOfNulls;
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(tArr, "array");
        if (collection.isEmpty()) {
            return (T[]) CollectionsKt.terminateCollectionToArray(0, tArr);
        }
        if (tArr.length < collection.size()) {
            objArrArrayOfNulls = ArraysKt.arrayOfNulls(tArr, collection.size());
        } else {
            objArrArrayOfNulls = tArr;
        }
        Iterator<?> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArrArrayOfNulls[i] = it.next();
            i++;
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(collection.size(), objArrArrayOfNulls);
    }
}
