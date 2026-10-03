package ni.shikatu.kotlin.collections;
import java.util.Map.Entry;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.builders.MapBuilder;
import ni.shikatu.kotlin.internal.ConstantsKt;
import ni.shikatu.kotlin.internal.PlatformImplementationsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a6\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004\u001a`\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032#\u0010\u0007\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\u0088\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fb\u0002\b\u0010ø\u0001\u0000\u001ah\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0011\u001a\u00020\u00122#\u0010\u0007\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0081\u0088\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fb\u0002\b\u0010ø\u0001\u0000\u001a4\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001a<\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001aH\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\tH\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u001ag\u0010\u0016\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00172\u0006\u0010\u0018\u001a\u0002H\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\u0088\u0004b\u0002\b\u001cb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001db\u0002\b\u0010ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u001b\u001aD\u0010\u001e\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00172\u0006\u0010\u0018\u001a\u0002H\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00030\u001aH\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001ai\u0010\u001f\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00172\u0006\u0010\u0018\u001a\u0002H\u00022\u000e\b\u0004\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\u0088\u0004b\u0002\b\u001cb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001db\u0002\b\u0010ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u001b\u001ai\u0010 \u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00172\u0006\u0010\u0018\u001a\u0002H\u00022\u000e\b\u0004\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\u0088\u0004b\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001db\u0002\b\u0010b\u0002\b\u001cø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010\u001b\u001aS\u0010!\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010\u0018\u001a\u0002H\u00022\u0006\u0010\"\u001a\u0002H\u0003H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001db\u0002\b\u001c¢\u0006\u0002\u0010#\u001aQ\u0010$\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00172\u0006\u0010\u0018\u001a\u0002H\u00022\u0006\u0010%\u001a\u0002H\u0003H\u0081\u0080\u0004b\u0002\b\fb\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001db\u0002\b\u001c¢\u0006\u0002\u0010&\u001a>\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030(\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020)\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0086\u0080\u0004\u001aD\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030(\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000e\u0010*\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00020+H\u0086\u0080\u0004\u001a]\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030(\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020)\"\u0004\b\u0001\u0010\u00032*\u0010-\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050.\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004¢\u0006\u0002\u0010/\u001aq\u0010,\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030(\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010*\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00020+2*\u0010-\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050.\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0087\u0080\u0004b\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(1¢\u0006\u0002\u00100\u001a\u001e\u00102\u001a\u000203*\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002040\u0001H\u0087\u0088\u0004b\u0002\b\u0010\u001a6\u00105\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0081\u0088\u0004b\u0002\b\u0010\u001a4\u00106\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0080\u0080\u0004\u001a\u0016\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u0012H\u0081\u0080\u0004b\u0002\b\f\"\u000f\u00109\u001a\u00020\u0012X\u0082Ô\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006:"}, d2 = {"mapOf", _UrlKt.FRAGMENT_ENCODE_SET, "K", "V", "pair", "Lni/shikatu/kotlin/Pair;", "buildMapInternal", "builderAction", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ExtensionFunctionType;", "Lni/shikatu/kotlin/PublishedApi;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/internal/InlineOnly;", "capacity", _UrlKt.FRAGMENT_ENCODE_SET, "createMapBuilder", "build", "builder", "getOrElseIfMissing", "Ljava/util/concurrent/ConcurrentMap;", "key", "defaultValue", "Lni/shikatu/kotlin/Function0;", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "2.4", "getOrPut", "getOrPutIfNull", "getOrPutIfMissing", "getOrDefaultImpl", "default", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrPutIfNullImpl", "newValue", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "toSortedMap", "Ljava/util/SortedMap;", _UrlKt.FRAGMENT_ENCODE_SET, "comparator", "Ljava/util/Comparator;", "sortedMapOf", "pairs", _UrlKt.FRAGMENT_ENCODE_SET, "([Lkotlin/Pair;)Ljava/util/SortedMap;", "(Ljava/util/Comparator;[Lkotlin/Pair;)Ljava/util/SortedMap;", "1.4", "toProperties", "Ljava/util/Properties;", _UrlKt.FRAGMENT_ENCODE_SET, "toSingletonMapOrSelf", "toSingletonMap", "mapCapacity", "expectedSize", "INT_MAX_POWER_OF_TWO", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/MapsKt")
public class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    private static final int INT_MAX_POWER_OF_TWO = 1073741824;

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    private static final <K, V> Map<K, V> buildMapInternal(Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        ((Function1) function1).invoke(mapCreateMapBuilder);
        return MapsKt.build(mapCreateMapBuilder);
    }

    private static final <K, V> Map<K, V> buildMapInternal(int capacity, Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder(capacity);
        ((Function1) function1).invoke(mapCreateMapBuilder);
        return MapsKt.build(mapCreateMapBuilder);
    }

    public static final <K, V> Map<K, V> createMapBuilder() {
        return new MapBuilder();
    }

    public static final <K, V> Map<K, V> createMapBuilder(int capacity) {
        return new MapBuilder(capacity);
    }

    public static final <K, V> Map<K, V> build(Map<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "builder");
        return ((MapBuilder) map).build();
    }

    private static final <K, V> V getOrElseIfMissing(ConcurrentMap<K, V> concurrentMap, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(concurrentMap, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = (V) MapsKt.getOrDefaultImpl(concurrentMap, k, ConstantsKt.MISSING_VALUE);
        if (v != ConstantsKt.MISSING_VALUE) {
            return v;
        }
        return function0.invoke();
    }

    public static final <K, V> V getOrPut(ConcurrentMap<K, V> concurrentMap, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(concurrentMap, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = concurrentMap.get(k);
        if (v != null) {
            return v;
        }
        V vInvoke = function0.invoke();
        V vPutIfAbsent = concurrentMap.putIfAbsent(k, vInvoke);
        return vPutIfAbsent == null ? vInvoke : vPutIfAbsent;
    }

    private static final <K, V> V getOrPutIfNull(ConcurrentMap<K, V> concurrentMap, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(concurrentMap, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = concurrentMap.get(k);
        return v == null ? (V) MapsKt.getOrPutIfNullImpl(concurrentMap, k, function0.invoke()) : v;
    }

    private static final <K, V> V getOrPutIfMissing(ConcurrentMap<K, V> concurrentMap, K k, Function0<? extends V> function0) {
        V v;
        Intrinsics.checkNotNullParameter(concurrentMap, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v2 = (V) MapsKt.getOrDefaultImpl(concurrentMap, k, ConstantsKt.MISSING_VALUE);
        if (v2 != ConstantsKt.MISSING_VALUE) {
            return v2;
        }
        V vInvoke = function0.invoke();
        do {
            V vPutIfAbsent = concurrentMap.putIfAbsent(k, vInvoke);
            if (vPutIfAbsent != null) {
                return vPutIfAbsent;
            }
            v = (V) MapsKt.getOrDefaultImpl(concurrentMap, k, ConstantsKt.MISSING_VALUE);
        } while (v == ConstantsKt.MISSING_VALUE);
        return v;
    }

    public static final <K, V> V getOrDefaultImpl(Map<K, ? extends V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return (V) PlatformImplementationsKt.IMPLEMENTATIONS.getOrDefault(map, k, v);
    }

    public static final <K, V> V getOrPutIfNullImpl(ConcurrentMap<K, V> concurrentMap, K k, V v) {
        Intrinsics.checkNotNullParameter(concurrentMap, "<this>");
        if (v != null) {
            return (V) PlatformImplementationsKt.IMPLEMENTATIONS.computeIfAbsent(concurrentMap, k, v);
        }
        return concurrentMap.putIfAbsent(k, v);
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new TreeMap(map);
    }

    public static final <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        TreeMap $this$toSortedMap_u24lambda_u240 = new TreeMap(comparator);
        $this$toSortedMap_u24lambda_u240.putAll(map);
        return $this$toSortedMap_u24lambda_u240;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        TreeMap $this$sortedMapOf_u24lambda_u240 = new TreeMap();
        MapsKt.putAll($this$sortedMapOf_u24lambda_u240, pairArr);
        return $this$sortedMapOf_u24lambda_u240;
    }

    public static final <K, V> SortedMap<K, V> sortedMapOf(Comparator<? super K> comparator, Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        TreeMap $this$sortedMapOf_u24lambda_u241 = new TreeMap(comparator);
        MapsKt.putAll($this$sortedMapOf_u24lambda_u241, pairArr);
        return $this$sortedMapOf_u24lambda_u241;
    }

    private static final Properties toProperties(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Properties $this$toProperties_u24lambda_u240 = new Properties();
        $this$toProperties_u24lambda_u240.putAll(map);
        return $this$toProperties_u24lambda_u240;
    }

    private static final <K, V> Map<K, V> toSingletonMapOrSelf(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return MapsKt.toSingletonMap(map);
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }

    public static final int mapCapacity(int expectedSize) {
        if (expectedSize < 0) {
            return expectedSize;
        }
        if (expectedSize < 3) {
            return expectedSize + 1;
        }
        return expectedSize < INT_MAX_POWER_OF_TWO ? (int) ((expectedSize / 0.75f) + 1.0f) : IntCompanionObject.MAX_VALUE;
    }
}
