package Z;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.IntIterator;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.ranges.IntRange;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonBuilder;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonElementKt;
import ni.shikatu.kotlinx.serialization.json.JsonKt;
import ni.shikatu.kotlinx.serialization.json.JsonNull;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;

public abstract class f6 {
    public static final Json a = JsonKt.Json$default((Json) null, new Function1() {
        public final Object invoke(Object obj) {
            return f6.a((JsonBuilder) obj);
        }
    }, 1, (Object) null);

    public static final Unit a(JsonBuilder jsonBuilder) {
        jsonBuilder.setIgnoreUnknownKeys(true);
        jsonBuilder.setLenient(true);
        jsonBuilder.setAllowSpecialFloatingPointValues(true);
        return Unit.INSTANCE;
    }

    public static final JsonElement b(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = RCompat.m6constructorimpl(a.parseToJsonElement(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        return (JsonElement) obj;
    }

    public static final JsonElement a(Object obj) {
        Pair pair;
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        if (obj instanceof JsonElement) {
            return (JsonElement) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            String string = StringsKt.trim(str).toString();
            if (!StringsKt.startsWith$default(string, '{', false, 2, (Object) null) && !StringsKt.startsWith$default(string, '[', false, 2, (Object) null)) {
                return JsonElementKt.JsonPrimitive(str);
            }
            return b(string);
        }
        if (obj instanceof Boolean) {
            return JsonElementKt.JsonPrimitive((Boolean) obj);
        }
        if (obj instanceof Number) {
            return JsonElementKt.JsonPrimitive((Number) obj);
        }
        if (obj instanceof Map) {
            Set<Map.Entry> setEntrySet = ((Map) obj).entrySet();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : setEntrySet) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                String str2 = key instanceof String ? (String) key : null;
                if (str2 != null) {
                    JsonNull jsonNullA = (JsonNull) a(value);
                    if (jsonNullA == null) {
                        jsonNullA = JsonNull.INSTANCE;
                    }
                    pair = TuplesKt.to(str2, jsonNullA);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            return new JsonObject(MapsKt.toMap(arrayList, new LinkedHashMap()));
        }
        if (obj instanceof Iterable) {
            Iterable iterable = (Iterable) obj;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                JsonNull jsonNullA2 = (JsonNull) a(it.next());
                if (jsonNullA2 == null) {
                    jsonNullA2 = JsonNull.INSTANCE;
                }
                arrayList2.add(jsonNullA2);
            }
            return new JsonArray(arrayList2);
        }
        if (obj.getClass().isArray()) {
            IntRange intRangeUntil = RangesKt.until(0, Array.getLength(obj));
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            IntIterator it2 = intRangeUntil.iterator();
            while (it2.hasNext()) {
                JsonNull jsonNullA3 = (JsonNull) a(Array.get(obj, it2.nextInt()));
                if (jsonNullA3 == null) {
                    jsonNullA3 = JsonNull.INSTANCE;
                }
                arrayList3.add(jsonNullA3);
            }
            return new JsonArray(arrayList3);
        }
        String string2 = StringsKt.trim(obj.toString()).toString();
        if (!StringsKt.startsWith$default(string2, '{', false, 2, (Object) null) && !StringsKt.startsWith$default(string2, '[', false, 2, (Object) null)) {
            string2 = null;
        }
        if (string2 != null) {
            return b(string2);
        }
        return null;
    }

    public static final LinkedHashMap a(String str) {
        Object doubleOrNull;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JsonElement jsonElementB = str != null ? b(str) : null;
        JsonObject jsonObject = jsonElementB instanceof JsonObject ? (JsonObject) jsonElementB : null;
        if (jsonObject != null) {
            for (Map.Entry entry : jsonObject.entrySet()) {
                String str2 = (String) entry.getKey();
                JsonPrimitive jsonPrimitive = (JsonPrimitive) entry.getValue();
                JsonPrimitive jsonPrimitive2 = jsonPrimitive instanceof JsonPrimitive ? jsonPrimitive : null;
                if (jsonPrimitive2 == null || jsonPrimitive2 == JsonNull.INSTANCE) {
                    doubleOrNull = null;
                } else if (jsonPrimitive2.isString()) {
                    doubleOrNull = jsonPrimitive2.getContent();
                } else {
                    Object booleanOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive2);
                    if (booleanOrNull != null) {
                        doubleOrNull = booleanOrNull;
                    } else {
                        Long longOrNull = JsonElementKt.getLongOrNull(jsonPrimitive2);
                        if (longOrNull != null) {
                            long jLongValue = longOrNull.longValue();
                            doubleOrNull = (-2147483648L > jLongValue || jLongValue > 2147483647L) ? Long.valueOf(jLongValue) : Integer.valueOf((int) jLongValue);
                        } else {
                            doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive2);
                        }
                    }
                }
                if (doubleOrNull != null) {
                    linkedHashMap.put(str2, doubleOrNull);
                }
            }
        }
        return linkedHashMap;
    }
}
