package ni.shikatu.kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.TypeIntrinsics;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.sequences.SequencesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a6\u0010\u0000\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0087\u0088\bb\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0006\u001a7\u0010\t\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000bH\u0087\u0088\bb\u0002\b\u0007b\u0002\b\b\u001a7\u0010\f\u001a\u00020\u0001\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000bH\u0087\u0088\bb\u0002\b\u0007b\u0002\b\b\u001a-\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0087\u008a\u0004b\u0002\b\u0007¢\u0006\u0002\u0010\u000f\u001a.\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u0007\u001a3\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0007¢\u0006\u0002\u0010\u0012\u001a.\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0007\u001a-\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u0087\u008a\u0004b\u0002\b\u0007¢\u0006\u0002\u0010\u000f\u001a.\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u0007\u001a3\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0087\u008a\u0004b\u0002\b\u0007¢\u0006\u0002\u0010\u0012\u001a.\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0007\u001a.\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0087\u0080\bb\u0002\b\b\u001a.\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0087\u0080\bb\u0002\b\b\u001a5\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0011H\u0087\u0080\bb\u0002\b\b¢\u0006\u0002\u0010\u0016\u001a \u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0080\u0080\u0004\u001a.\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0087\u0080\bb\u0002\b\b\u001a.\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0087\u0080\bb\u0002\b\b\u001a5\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0011H\u0087\u0080\bb\u0002\b\b¢\u0006\u0002\u0010\u0016\u001a.\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010H\u0087\u0080\bb\u0002\b\b\u001a5\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0011H\u0087\u0080\bb\u0002\b\b¢\u0006\u0002\u0010\u0016\u001a.\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0087\u0080\bb\u0002\b\b\u001a\u001b\u0010\u0018\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0004H\u0083\u0080\bb\u0002\b\b¢\u0006\u0002\b\u0019\u001a2\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\u0080\bb\u0002\b\b\u001a2\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\u0080\bb\u0002\b\b\u001a;\u0010\u001d\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u001f\u001ac\u0010\u0000\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 2\u0006\u0010!\u001a\u00020\"H\u0087\u0088\u0004b6\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u001c\b'\u0012\u0018\b\u000bB\u0014\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0006\b+\u0012\u0002\b\f\u0012\n\b,\u0012\u0006\b\n0-8.b\u0002\b\u0007¢\u0006\u0002\u0010#\u001a1\u0010/\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 H\u0087\u0080\bb\f\b1\u0012\b\b2\u0012\u0004\b\b(3b\u0002\b\b¢\u0006\u0002\u00100\u001a3\u00104\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 H\u0087\u0080\bb\f\b1\u0012\b\b2\u0012\u0004\b\b(3b\u0002\b\b¢\u0006\u0002\u00100\u001a1\u00105\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 H\u0087\u0080\bb\f\b1\u0012\b\b2\u0012\u0004\b\b(3b\u0002\b\b¢\u0006\u0002\u00100\u001a3\u00106\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 H\u0087\u0080\bb\f\b1\u0012\b\b2\u0012\u0004\b\b(3b\u0002\b\b¢\u0006\u0002\u00100\u001a2\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\u0080\bb\u0002\b\b\u001a2\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001cH\u0087\u0080\bb\u0002\b\b\u001a;\u0010\u001d\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u001f¨\u00067"}, d2 = {"remove", _UrlKt.FRAGMENT_ENCODE_SET, "T", "Lni/shikatu/kotlin/internal/OnlyInputTypes;", _UrlKt.FRAGMENT_ENCODE_SET, "element", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "removeAll", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "retainAll", "plusAssign", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/Collection;Ljava/lang/Object;)V", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/Collection;[Ljava/lang/Object;)V", "Lni/shikatu/kotlin/sequences/Sequence;", "minusAssign", "addAll", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "convertToListIfNotCollection", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", _UrlKt.FRAGMENT_ENCODE_SET, "predicate", "Lni/shikatu/kotlin/Function1;", "filterInPlace", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", _UrlKt.FRAGMENT_ENCODE_SET, "index", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/List;I)Ljava/lang/Object;", "Lni/shikatu/kotlin/Deprecated;", "message", "Use removeAt(index) instead.", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "removeAt(index)", "imports", "level", "Lni/shikatu/kotlin/DeprecationLevel;", "ERROR", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.4", "removeFirstOrNull", "removeLast", "removeLastOrNull", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/CollectionsKt")
public class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    @IgnorableReturnValue
    private static final <T> boolean remove(Collection<? extends T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return TypeIntrinsics.asMutableCollection(collection).remove(t);
    }

    @IgnorableReturnValue
    private static final <T> boolean removeAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(collection2, "elements");
        return TypeIntrinsics.asMutableCollection(collection).removeAll(collection2);
    }

    @IgnorableReturnValue
    private static final <T> boolean retainAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(collection2, "elements");
        return TypeIntrinsics.asMutableCollection(collection).retainAll(collection2);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        collection.add(t);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        CollectionsKt.addAll(collection, iterable);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        CollectionsKt.addAll(collection, tArr);
    }

    private static final <T> void plusAssign(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        CollectionsKt.addAll(collection, sequence);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        collection.remove(t);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        CollectionsKt.removeAll(collection, iterable);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        CollectionsKt.removeAll(collection, tArr);
    }

    private static final <T> void minusAssign(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        CollectionsKt.removeAll(collection, sequence);
    }

    @IgnorableReturnValue
    public static final <T> boolean addAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean result = false;
        for (Object item : iterable) {
            if (collection.add(item)) {
                result = true;
            }
        }
        return result;
    }

    @IgnorableReturnValue
    public static final <T> boolean addAll(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        boolean result = false;
        for (Object item : sequence) {
            if (collection.add(item)) {
                result = true;
            }
        }
        return result;
    }

    @IgnorableReturnValue
    public static final <T> boolean addAll(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return collection.addAll(ArraysKt.asList(tArr));
    }

    public static final <T> Collection<T> convertToListIfNotCollection(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : CollectionsKt.toList(iterable);
    }

    @IgnorableReturnValue
    public static final <T> boolean removeAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        return collection.removeAll(CollectionsKt.convertToListIfNotCollection(iterable));
    }

    @IgnorableReturnValue
    public static final <T> boolean removeAll(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        List list = SequencesKt.toList(sequence);
        return !list.isEmpty() && collection.removeAll(list);
    }

    @IgnorableReturnValue
    public static final <T> boolean removeAll(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return !(tArr.length == 0) && collection.removeAll(ArraysKt.asList(tArr));
    }

    @IgnorableReturnValue
    public static final <T> boolean retainAll(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(iterable, "elements");
        return collection.retainAll(CollectionsKt.convertToListIfNotCollection(iterable));
    }

    @IgnorableReturnValue
    public static final <T> boolean retainAll(Collection<? super T> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (!(tArr.length == 0)) {
            return collection.retainAll(ArraysKt.asList(tArr));
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(collection);
    }

    @IgnorableReturnValue
    public static final <T> boolean retainAll(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(sequence, "elements");
        List list = SequencesKt.toList(sequence);
        if (!list.isEmpty()) {
            return collection.retainAll(list);
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(collection);
    }

    @IgnorableReturnValue
    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(Collection<?> collection) {
        boolean result = !collection.isEmpty();
        collection.clear();
        return result;
    }

    @IgnorableReturnValue
    public static final <T> boolean removeAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) iterable, (Function1) function1, true);
    }

    @IgnorableReturnValue
    public static final <T> boolean retainAll(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) iterable, (Function1) function1, false);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        boolean z2 = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    private static final <T> T remove(List<T> list, int index) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.remove(index);
    }

    @IgnorableReturnValue
    public static final <T> T removeFirst(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    @IgnorableReturnValue
    public static final <T> T removeFirstOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @IgnorableReturnValue
    public static final <T> T removeLast(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(CollectionsKt.getLastIndex(list));
    }

    @IgnorableReturnValue
    public static final <T> T removeLastOrNull(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(CollectionsKt.getLastIndex(list));
    }

    @IgnorableReturnValue
    public static final <T> boolean removeAll(List<T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) list, (Function1) function1, true);
    }

    @IgnorableReturnValue
    public static final <T> boolean retainAll(List<T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) list, (Function1) function1, false);
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List<T> list, Function1<? super T, Boolean> function1, boolean predicateResultToRemove) {
        if (!(list instanceof RandomAccess)) {
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(list), function1, predicateResultToRemove);
        }
        int writeIndex = 0;
        int readIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(list);
        if (0 <= lastIndex) {
            while (true) {
                T t = list.get(readIndex);
                if (function1.invoke(t).booleanValue() != predicateResultToRemove) {
                    if (writeIndex != readIndex) {
                        list.set(writeIndex, t);
                    }
                    writeIndex++;
                }
                if (readIndex == lastIndex) {
                    break;
                }
                readIndex++;
            }
        }
        int readIndex2 = list.size();
        if (writeIndex < readIndex2) {
            int removeIndex = CollectionsKt.getLastIndex(list);
            if (writeIndex > removeIndex) {
                return true;
            }
            while (true) {
                list.remove(removeIndex);
                if (removeIndex == writeIndex) {
                    return true;
                }
                removeIndex--;
            }
        } else {
            return false;
        }
    }
}
