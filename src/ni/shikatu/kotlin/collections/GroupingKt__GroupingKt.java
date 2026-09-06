package ni.shikatu.kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.functions.Function4;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u00ad\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011ø\u0001\u0000\u001aÆ\u0001\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0013*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0014*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0015\u001a\u0002H\u00132b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aÎ\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u000526\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011ø\u0001\u0000\u001aç\u0001\u0010\u001b\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0013*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0014*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0015\u001a\u0002H\u001326\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u008e\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u001d\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a¢\u0001\u0010\u001b\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0013*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0014*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0015\u001a\u0002H\u00132\u0006\u0010\u001d\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a\u009a\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0001\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011ø\u0001\u0000\u001a³\u0001\u0010\"\u001a\u0002H\u0013\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0013*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0014*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0015\u001a\u0002H\u00132K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\u0087\u0088\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011ø\u0001\u0000¢\u0006\u0002\u0010#\u001aY\u0010$\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0016\b\u0002\u0010\u0013*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u00020%0\u0014*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0015\u001a\u0002H\u0013H\u0087\u0080\u0004b\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011¢\u0006\u0002\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"aggregate", _UrlKt.FRAGMENT_ENCODE_SET, "K", "R", "T", "Lni/shikatu/kotlin/collections/Grouping;", "operation", "Lni/shikatu/kotlin/Function4;", "Lni/shikatu/kotlin/ParameterName;", "name", "key", "accumulator", "element", _UrlKt.FRAGMENT_ENCODE_SET, "first", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "aggregateTo", "M", _UrlKt.FRAGMENT_ENCODE_SET, "destination", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "fold", "initialValueSelector", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/Function3;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "reduce", "S", "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "eachCountTo", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/GroupingKt")
class GroupingKt__GroupingKt extends GroupingKt__GroupingJVMKt {
    public static final <T, K, R> Map<K, R> aggregate(Grouping<T, ? extends K> grouping, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(function4, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            Object key$iv = grouping.keyOf(next);
            Object accumulator$iv = linkedHashMap.get(key$iv);
            linkedHashMap.put(key$iv, function4.invoke(key$iv, accumulator$iv, next, Boolean.valueOf(accumulator$iv == null && !linkedHashMap.containsKey(key$iv))));
        }
        return linkedHashMap;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M aggregateTo(Grouping<T, ? extends K> grouping, M m, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function4, "operation");
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            Object key = grouping.keyOf(next);
            Object accumulator = m.get(key);
            m.put(key, function4.invoke(key, accumulator, next, Boolean.valueOf(accumulator == null && !m.containsKey(key))));
        }
        return m;
    }

    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> grouping, Function2<? super K, ? super T, ? extends R> function2, Function3<? super K, ? super R, ? super T, ? extends R> function3) {
        Object key;
        Object objInvoke;
        Function2<? super K, ? super T, ? extends R> function4 = function2;
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(function4, "initialValueSelector");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int $i$f$fold = 0;
        Map destination$iv$iv = new LinkedHashMap();
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            K kKeyOf = grouping.keyOf(next);
            Object accumulator$iv$iv = destination$iv$iv.get(kKeyOf);
            boolean first = accumulator$iv$iv == null && !destination$iv$iv.containsKey(kKeyOf);
            if (first) {
                key = kKeyOf;
                objInvoke = function4.invoke(key, next);
            } else {
                key = kKeyOf;
                objInvoke = accumulator$iv$iv;
            }
            destination$iv$iv.put(kKeyOf, function3.invoke(key, objInvoke, next));
            function4 = function2;
            $i$f$fold = $i$f$fold;
        }
        return destination$iv$iv;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> grouping, M m, Function2<? super K, ? super T, ? extends R> function2, Function3<? super K, ? super R, ? super T, ? extends R> function3) {
        Function2<? super K, ? super T, ? extends R> function4 = function2;
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function4, "initialValueSelector");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            Object key$iv = grouping.keyOf(next);
            Object accumulator$iv = m.get(key$iv);
            boolean first = accumulator$iv == null && !m.containsKey(key$iv);
            m.put(key$iv, function3.invoke(key$iv, first ? function4.invoke(key$iv, next) : accumulator$iv, next));
            function4 = function2;
        }
        return m;
    }

    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> grouping, R r, Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int $i$f$fold = 0;
        Map destination$iv$iv = new LinkedHashMap();
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            K kKeyOf = grouping.keyOf(next);
            Object accumulator$iv$iv = destination$iv$iv.get(kKeyOf);
            boolean first = accumulator$iv$iv == null && !destination$iv$iv.containsKey(kKeyOf);
            int $i$f$fold2 = $i$f$fold;
            destination$iv$iv.put(kKeyOf, function2.invoke(first ? r : accumulator$iv$iv, next));
            $i$f$fold = $i$f$fold2;
        }
        return destination$iv$iv;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> grouping, M m, R r, Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            K kKeyOf = grouping.keyOf(next);
            Object accumulator$iv = m.get(kKeyOf);
            boolean first = accumulator$iv == null && !m.containsKey(kKeyOf);
            m.put(kKeyOf, function2.invoke(first ? r : accumulator$iv, next));
        }
        return m;
    }

    public static final <S, T extends S, K> Map<K, S> reduce(Grouping<T, ? extends K> grouping, Function3<? super K, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(function3, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            Object key$iv$iv = grouping.keyOf(next);
            Object accumulator$iv$iv = linkedHashMap.get(key$iv$iv);
            boolean first = accumulator$iv$iv == null && !linkedHashMap.containsKey(key$iv$iv);
            Object e = next;
            if (!first) {
                e = function3.invoke(key$iv$iv, accumulator$iv$iv, e);
            }
            linkedHashMap.put(key$iv$iv, e);
        }
        return linkedHashMap;
    }

    public static final <S, T extends S, K, M extends Map<? super K, S>> M reduceTo(Grouping<T, ? extends K> grouping, M m, Function3<? super K, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            T next = itSourceIterator.next();
            Object key$iv = grouping.keyOf(next);
            Object accumulator$iv = m.get(key$iv);
            boolean first = accumulator$iv == null && !m.containsKey(key$iv);
            Object e = next;
            if (!first) {
                e = function3.invoke(key$iv, accumulator$iv, e);
            }
            m.put(key$iv, e);
        }
        return m;
    }

    public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(Grouping<T, ? extends K> grouping, M m) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Intrinsics.checkNotNullParameter(m, "destination");
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            K kKeyOf = grouping.keyOf(itSourceIterator.next());
            Object accumulator$iv$iv = m.get(kKeyOf);
            boolean first$iv = accumulator$iv$iv == null && !m.containsKey(kKeyOf);
            int acc = ((Number) (first$iv ? 0 : accumulator$iv$iv)).intValue();
            m.put(kKeyOf, Integer.valueOf(acc + 1));
        }
        return m;
    }
}
