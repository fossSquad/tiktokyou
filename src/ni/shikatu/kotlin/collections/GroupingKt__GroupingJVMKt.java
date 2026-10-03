package ni.shikatu.kotlin.collections;
import java.util.Map.Entry;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.jvm.internal.TypeIntrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u001ac\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\u000b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\f0\n2\u001e\u0010\r\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\f0\u000f\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0081\u0088\u0004b\u0002\b\u0010b\u0002\b\u0011ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"eachCount", _UrlKt.FRAGMENT_ENCODE_SET, "K", _UrlKt.FRAGMENT_ENCODE_SET, "T", "Lni/shikatu/kotlin/collections/Grouping;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "mapValuesInPlace", _UrlKt.FRAGMENT_ENCODE_SET, "R", "V", "f", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/PublishedApi;", "Lni/shikatu/kotlin/internal/InlineOnly;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/GroupingKt")
class GroupingKt__GroupingJVMKt {
    public static final <T, K> Map<K, Integer> eachCount(Grouping<T, ? extends K> grouping) {
        Intrinsics.checkNotNullParameter(grouping, "<this>");
        Map destination$iv = new LinkedHashMap();
        Iterator<T> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            K kKeyOf = grouping.keyOf(itSourceIterator.next());
            Object accumulator$iv$iv = destination$iv.get(kKeyOf);
            boolean first$iv = accumulator$iv$iv == null && !destination$iv.containsKey(kKeyOf);
            Ref.IntRef acc = (Ref.IntRef) (first$iv ? new Ref.IntRef() : accumulator$iv$iv);
            acc.element++;
            destination$iv.put(kKeyOf, acc);
            destination$iv = destination$iv;
        }
        for (Map.Entry it : destination$iv.entrySet()) {
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace>");
            TypeIntrinsics.asMutableMapEntry(it).setValue(Integer.valueOf(((Ref.IntRef) it.getValue()).element));
        }
        return TypeIntrinsics.asMutableMap(destination$iv);
    }

    private static final <K, V, R> Map<K, R> mapValuesInPlace(Map<K, V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "f");
        Iterable $this$forEach$iv = map.entrySet();
        for (Object element$iv : $this$forEach$iv) {
            Map.Entry it = (Map.Entry) element$iv;
            Intrinsics.checkNotNull(it, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace>");
            TypeIntrinsics.asMutableMapEntry(it).setValue(((Function1) function1).invoke(it));
        }
        return TypeIntrinsics.asMutableMap(map);
    }
}
