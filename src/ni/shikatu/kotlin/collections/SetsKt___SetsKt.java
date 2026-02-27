package ni.shikatu.kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, d2 = {"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lni/shikatu/kotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/SetsKt")
class SetsKt___SetsKt extends SetsKt__SetsKt {
    public static final <T> Set<T> minus(Set<? extends T> set, T t) {
        boolean z;
        Intrinsics.checkNotNullParameter(set, "<this>");
        Iterable result = new LinkedHashSet(MapsKt.mapCapacity(set.size()));
        boolean removed = false;
        Set<? extends T> $this$filterTo$iv = set;
        for (T t2 : $this$filterTo$iv) {
            if (removed || !Intrinsics.areEqual(t2, t)) {
                z = true;
            } else {
                removed = true;
                z = false;
            }
            if (z) {
                ((Collection) result).add(t2);
            }
        }
        Iterable $this$filterTo$iv2 = (Collection) result;
        return (Set) $this$filterTo$iv2;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, T[] tArr) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        LinkedHashSet result = new LinkedHashSet(set);
        CollectionsKt.removeAll(result, tArr);
        return result;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        Collection<?> collectionConvertToListIfNotCollection = CollectionsKt.convertToListIfNotCollection(iterable);
        if (collectionConvertToListIfNotCollection.isEmpty()) {
            return CollectionsKt.toSet(set);
        }
        if (collectionConvertToListIfNotCollection instanceof Set) {
            Set<? extends T> $this$filterNotTo$iv = set;
            Collection destination$iv = new LinkedHashSet();
            for (T t : $this$filterNotTo$iv) {
                if (!((Set) collectionConvertToListIfNotCollection).contains(t)) {
                    destination$iv.add(t);
                }
            }
            return (Set) destination$iv;
        }
        LinkedHashSet result = new LinkedHashSet(set);
        result.removeAll(collectionConvertToListIfNotCollection);
        return result;
    }

    public static final <T> Set<T> minus(Set<? extends T> set, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        LinkedHashSet result = new LinkedHashSet(set);
        CollectionsKt.removeAll(result, sequence);
        return result;
    }

    private static final <T> Set<T> minusElement(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        return SetsKt.minus(set, t);
    }

    public static final <T> Set<T> plus(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        LinkedHashSet result = new LinkedHashSet(MapsKt.mapCapacity(set.size() + 1));
        result.addAll(set);
        result.add(t);
        return result;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, T[] tArr) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        LinkedHashSet result = new LinkedHashSet(MapsKt.mapCapacity(set.size() + tArr.length));
        result.addAll(set);
        CollectionsKt.addAll(result, tArr);
        return result;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, Iterable<? extends T> iterable) {
        int size;
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        Integer numCollectionSizeOrNull = CollectionsKt.collectionSizeOrNull(iterable);
        if (numCollectionSizeOrNull != null) {
            int it = numCollectionSizeOrNull.intValue();
            size = set.size() + it;
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet result = new LinkedHashSet(MapsKt.mapCapacity(size));
        result.addAll(set);
        CollectionsKt.addAll(result, iterable);
        return result;
    }

    public static final <T> Set<T> plus(Set<? extends T> set, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        LinkedHashSet result = new LinkedHashSet(MapsKt.mapCapacity(set.size() * 2));
        result.addAll(set);
        CollectionsKt.addAll(result, sequence);
        return result;
    }

    private static final <T> Set<T> plusElement(Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        return SetsKt.plus(set, t);
    }
}
