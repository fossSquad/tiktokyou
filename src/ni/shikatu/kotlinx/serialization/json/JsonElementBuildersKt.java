package ni.shikatu.kotlinx.serialization.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a3\u0010\u0007\u001a\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a1\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\u0080\b\u001a1\u0010\u000e\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\u0080\b\u001a'\u0010\u000f\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0087\u0080\b¢\u0006\u0002\u0010\u0012\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0087\u0080\b\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0087\u0080\b\u001a\"\u0010\u000f\u001a\u0004\u0018\u00010\u000b*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014H\u0087\u0080\b\u001a\u001d\u0010\u0015\u001a\u00020\u0011*\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0087\u0080\b¢\u0006\u0002\u0010\u0016\u001a\u0018\u0010\u0015\u001a\u00020\u0011*\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0013H\u0087\u0080\b\u001a\u0018\u0010\u0015\u001a\u00020\u0011*\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0087\u0080\b\u001a\u0018\u0010\u0015\u001a\u00020\u0011*\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0014H\u0087\u0080\b\u001a'\u0010\u0017\u001a\u00020\u0011*\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\u0080\b\u001a'\u0010\u0018\u001a\u00020\u0011*\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\u0080\b\u001a#\u0010\u0019\u001a\u00020\u0011*\u00020\t2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001bH\u0087\u0080\b¢\u0006\u0002\b\u001c\u001a#\u0010\u0019\u001a\u00020\u0011*\u00020\t2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001bH\u0087\u0080\b¢\u0006\u0002\b\u001d\u001a#\u0010\u0019\u001a\u00020\u0011*\u00020\t2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001bH\u0087\u0080\b¢\u0006\u0002\b\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"buildJsonObject", "Lni/shikatu/kotlinx/serialization/json/JsonObject;", "builderAction", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlinx/serialization/json/JsonObjectBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ExtensionFunctionType;", "buildJsonArray", "Lni/shikatu/kotlinx/serialization/json/JsonArray;", "Lni/shikatu/kotlinx/serialization/json/JsonArrayBuilder;", "putJsonObject", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "key", _UrlKt.FRAGMENT_ENCODE_SET, "putJsonArray", "put", "value", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/json/JsonObjectBuilder;Ljava/lang/String;Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonElement;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "add", "(Lkotlinx/serialization/json/JsonArrayBuilder;Ljava/lang/Boolean;)Z", "addJsonObject", "addJsonArray", "addAll", "values", _UrlKt.FRAGMENT_ENCODE_SET, "addAllStrings", "addAllBooleans", "addAllNumbers", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonElementBuildersKt {
    public static final JsonObject buildJsonObject(Function1<? super JsonObjectBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonObjectBuilder builder = new JsonObjectBuilder();
        function1.invoke(builder);
        return builder.build();
    }

    public static final JsonArray buildJsonArray(Function1<? super JsonArrayBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonArrayBuilder builder = new JsonArrayBuilder();
        function1.invoke(builder);
        return builder.build();
    }

    @IgnorableReturnValue
    public static final JsonElement putJsonObject(JsonObjectBuilder $this$putJsonObject, String key, Function1<? super JsonObjectBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$putJsonObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        function1.invoke(builder$iv);
        return $this$putJsonObject.put(key, builder$iv.build());
    }

    @IgnorableReturnValue
    public static final JsonElement putJsonArray(JsonObjectBuilder $this$putJsonArray, String key, Function1<? super JsonArrayBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$putJsonArray, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonArrayBuilder builder$iv = new JsonArrayBuilder();
        function1.invoke(builder$iv);
        return $this$putJsonArray.put(key, builder$iv.build());
    }

    @IgnorableReturnValue
    public static final JsonElement put(JsonObjectBuilder $this$put, String key, Boolean value) {
        Intrinsics.checkNotNullParameter($this$put, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return $this$put.put(key, JsonElementKt.JsonPrimitive(value));
    }

    @IgnorableReturnValue
    public static final JsonElement put(JsonObjectBuilder $this$put, String key, Number value) {
        Intrinsics.checkNotNullParameter($this$put, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return $this$put.put(key, JsonElementKt.JsonPrimitive(value));
    }

    @IgnorableReturnValue
    public static final JsonElement put(JsonObjectBuilder $this$put, String key, String value) {
        Intrinsics.checkNotNullParameter($this$put, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return $this$put.put(key, JsonElementKt.JsonPrimitive(value));
    }

    @IgnorableReturnValue
    public static final JsonElement put(JsonObjectBuilder $this$put, String key, Void value) {
        Intrinsics.checkNotNullParameter($this$put, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return $this$put.put(key, JsonNull.INSTANCE);
    }

    @IgnorableReturnValue
    public static final boolean add(JsonArrayBuilder $this$add, Boolean value) {
        Intrinsics.checkNotNullParameter($this$add, "<this>");
        return $this$add.add(JsonElementKt.JsonPrimitive(value));
    }

    @IgnorableReturnValue
    public static final boolean add(JsonArrayBuilder $this$add, Number value) {
        Intrinsics.checkNotNullParameter($this$add, "<this>");
        return $this$add.add(JsonElementKt.JsonPrimitive(value));
    }

    @IgnorableReturnValue
    public static final boolean add(JsonArrayBuilder $this$add, String value) {
        Intrinsics.checkNotNullParameter($this$add, "<this>");
        return $this$add.add(JsonElementKt.JsonPrimitive(value));
    }

    @IgnorableReturnValue
    public static final boolean add(JsonArrayBuilder $this$add, Void value) {
        Intrinsics.checkNotNullParameter($this$add, "<this>");
        return $this$add.add(JsonNull.INSTANCE);
    }

    @IgnorableReturnValue
    public static final boolean addJsonObject(JsonArrayBuilder $this$addJsonObject, Function1<? super JsonObjectBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$addJsonObject, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        function1.invoke(builder$iv);
        return $this$addJsonObject.add(builder$iv.build());
    }

    @IgnorableReturnValue
    public static final boolean addJsonArray(JsonArrayBuilder $this$addJsonArray, Function1<? super JsonArrayBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$addJsonArray, "<this>");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        JsonArrayBuilder builder$iv = new JsonArrayBuilder();
        function1.invoke(builder$iv);
        return $this$addJsonArray.add(builder$iv.build());
    }

    @IgnorableReturnValue
    @ExperimentalSerializationApi
    public static final boolean addAllStrings(JsonArrayBuilder $this$addAll, Collection<String> collection) {
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(collection, "values");
        Collection<String> $this$map$iv = collection;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String p0 = (String) item$iv$iv;
            destination$iv$iv.add(JsonElementKt.JsonPrimitive(p0));
        }
        return $this$addAll.addAll((List) destination$iv$iv);
    }

    @IgnorableReturnValue
    @ExperimentalSerializationApi
    public static final boolean addAllBooleans(JsonArrayBuilder $this$addAll, Collection<Boolean> collection) {
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(collection, "values");
        Collection<Boolean> $this$map$iv = collection;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Boolean p0 = (Boolean) item$iv$iv;
            destination$iv$iv.add(JsonElementKt.JsonPrimitive(p0));
        }
        return $this$addAll.addAll((List) destination$iv$iv);
    }

    @IgnorableReturnValue
    @ExperimentalSerializationApi
    public static final boolean addAllNumbers(JsonArrayBuilder $this$addAll, Collection<? extends Number> collection) {
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(collection, "values");
        Collection<? extends Number> $this$map$iv = collection;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Number p0 = (Number) item$iv$iv;
            destination$iv$iv.add(JsonElementKt.JsonPrimitive(p0));
        }
        return $this$addAll.addAll((List) destination$iv$iv);
    }
}
