package ni.shikatu.kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.builders.ListBuilder;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.CollectionToArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001a5\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0006j\b\u0012\u0004\u0012\u0002H\u0002`\u0007\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\bH\u0081\u0088\u0004b\u0002\b\n¢\u0006\u0002\u0010\t\u001aN\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0004\b\u0000\u0010\f2\u001d\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0081\u0088\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nø\u0001\u0000\u001aV\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0016\u001a\u00020\u00172\u001d\u0010\r\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011H\u0081\u0088\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nø\u0001\u0000\u001a(\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\f0\u000f\"\u0004\b\u0000\u0010\fH\u0081\u0080\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u001a0\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\f0\u000f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0081\u0080\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u001a6\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\f0\u0001\"\u0004\b\u0000\u0010\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0081\u0080\u0004b\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u001a$\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001cH\u0087\u0088\u0004b\u0002\b\n\u001a.\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001eH\u0087\u0080\u0004b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001f\u001a6\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0087\u0080\u0004b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001f\u001a'\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\b2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%H\u0081\u0088\u0004b\u0002\b\n¢\u0006\u0002\u0010&\u001a9\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0081\u0088\u0004b\u0002\b\n¢\u0006\u0002\u0010(\u001a1\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010*\u001a\u00020\u00172\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0080\u0080\u0004¢\u0006\u0002\u0010+\u001a3\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010#0\b\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\b2\u0006\u0010-\u001a\u00020.H\u0080\u0080\u0004¢\u0006\u0002\u0010/\u001a,\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0017H\u0081\u0088\bb\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nb\u0002\b2\u001a,\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u0017H\u0081\u0088\bb\u0002\b\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015b\u0002\b\nb\u0002\b2\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"listOf", _UrlKt.FRAGMENT_ENCODE_SET, "T", "element", "(Ljava/lang/Object;)Ljava/util/List;", "asArrayList", "Ljava/util/ArrayList;", "Lni/shikatu/kotlin/collections/ArrayList;", _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/util/ArrayList;", "Lni/shikatu/kotlin/internal/InlineOnly;", "buildListInternal", "E", "builderAction", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ExtensionFunctionType;", "Lni/shikatu/kotlin/PublishedApi;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "capacity", _UrlKt.FRAGMENT_ENCODE_SET, "createListBuilder", "build", "builder", "toList", "Ljava/util/Enumeration;", "shuffled", _UrlKt.FRAGMENT_ENCODE_SET, "1.2", "random", "Ljava/util/Random;", "collectionToArray", _UrlKt.FRAGMENT_ENCODE_SET, "collection", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "terminateCollectionToArray", "collectionSize", "(I[Ljava/lang/Object;)[Ljava/lang/Object;", "copyToArrayOfAny", "isVarargs", _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "checkIndexOverflow", "index", "Lni/shikatu/kotlin/IgnorableReturnValue;", "checkCountOverflow", "count", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/CollectionsKt")
public class CollectionsKt__CollectionsJVMKt {
    public static final <T> List<T> listOf(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    private static final <T> ArrayList<T> asArrayList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayList<>(CollectionsKt.asCollection(tArr, true));
    }

    private static final <E> List<E> buildListInternal(Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        ((Function1) function1).invoke((E) listCreateListBuilder);
        return CollectionsKt.build(listCreateListBuilder);
    }

    private static final <E> List<E> buildListInternal(int capacity, Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        List listCreateListBuilder = CollectionsKt.createListBuilder(capacity);
        ((Function1) function1).invoke((E) listCreateListBuilder);
        return CollectionsKt.build(listCreateListBuilder);
    }

    public static final <E> List<E> createListBuilder() {
        return new ListBuilder(0, 1, null);
    }

    public static final <E> List<E> createListBuilder(int capacity) {
        return new ListBuilder(capacity);
    }

    public static final <E> List<E> build(List<E> list) {
        Intrinsics.checkNotNullParameter(list, "builder");
        return ((ListBuilder) list).build();
    }

    private static final <T> List<T> toList(Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        ArrayList list = Collections.list(enumeration);
        Intrinsics.checkNotNullExpressionValue(list, "list(...)");
        return list;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> iterable, Random random) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        List<T> mutableList = CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList, random);
        return mutableList;
    }

    private static final Object[] collectionToArray(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        return CollectionToArray.toArray(collection);
    }

    private static final <T> T[] collectionToArray(Collection<?> collection, T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(collection, tArr);
    }

    public static final <T> T[] terminateCollectionToArray(int collectionSize, T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        if (collectionSize < tArr.length) {
            tArr[collectionSize] = null;
        }
        return tArr;
    }

    public static final <T> Object[] copyToArrayOfAny(T[] tArr, boolean isVarargs) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (isVarargs && Intrinsics.areEqual(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    @IgnorableReturnValue
    private static final int checkIndexOverflow(int index) {
        if (index < 0) {
            CollectionsKt.throwIndexOverflow();
        }
        return index;
    }

    @IgnorableReturnValue
    private static final int checkCountOverflow(int count) {
        if (count < 0) {
            CollectionsKt.throwCountOverflow();
        }
        return count;
    }
}
