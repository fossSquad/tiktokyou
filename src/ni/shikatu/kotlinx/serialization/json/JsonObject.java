package ni.shikatu.kotlinx.serialization.json;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.Serializable;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.kotlinx.serialization.json.internal.StringOpsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0001\"B\u001d\bF\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0082\u0004J\n\u0010\u000b\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u0003H\u0096\u0080\u0004J\u0012\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0096\u0081\u0004J\u0012\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0096\u0081\u0004J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0003H\u0096\u0083\u0004J\n\u0010\u0013\u001a\u00020\bH\u0096\u0081\u0004R\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R%\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00160\u0015X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u001b\u001a\u00020\fX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001fX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonObject;", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "content", "<init>", "(Ljava/util/Map;)V", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", "containsKey", "key", "containsValue", "value", "get", "isEmpty", "entries", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "getSize", "()I", "values", _UrlKt.FRAGMENT_ENCODE_SET, "getValues", "()Ljava/util/Collection;", "Companion", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = JsonObjectSerializer.class)
public final class JsonObject extends JsonElement implements Map<String, JsonElement>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final Map<String, JsonElement> content;

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  JsonElement compute(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public JsonElement compute2(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  JsonElement computeIfAbsent(String str, Function<? super String, ? extends JsonElement> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public JsonElement computeIfAbsent2(String str, Function<? super String, ? extends JsonElement> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  JsonElement computeIfPresent(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public JsonElement computeIfPresent2(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.content.containsKey(str);
    }

    public boolean containsValue(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "value");
        return this.content.containsValue(jsonElement);
    }

    public JsonElement get(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.content.get(str);
    }

    public Set<Map.Entry<String, JsonElement>> getEntries() {
        return this.content.entrySet();
    }

    public Set<String> getKeys() {
        return this.content.keySet();
    }

    public int getSize() {
        return this.content.size();
    }

    public Collection<JsonElement> getValues() {
        return this.content.values();
    }

    @Override
    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    @Override
    public /* bridge */  JsonElement merge(String str, JsonElement jsonElement, BiFunction<? super JsonElement, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public JsonElement merge2(String str, JsonElement jsonElement, BiFunction<? super JsonElement, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  JsonElement put(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public JsonElement put2(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void putAll(Map<? extends String, ? extends JsonElement> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  JsonElement putIfAbsent(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public JsonElement putIfAbsent2(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public JsonElement remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  JsonElement replace(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public JsonElement replace2(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  boolean replace(String str, JsonElement jsonElement, JsonElement jsonElement2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean replace2(String str, JsonElement jsonElement, JsonElement jsonElement2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void replaceAll(BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonObject$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlinx/serialization/json/JsonObject;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<JsonObject> serializer() {
            return JsonObjectSerializer.INSTANCE;
        }
    }

    public JsonObject(Map<String, ? extends JsonElement> map) {
        super(null);
        Intrinsics.checkNotNullParameter(map, "content");
        this.content = map;
    }

    @Override
    public final /* bridge */ boolean containsKey(Object key) {
        if (key instanceof String) {
            return containsKey((String) key);
        }
        return false;
    }

    @Override
    public final /* bridge */ boolean containsValue(Object value) {
        if (value instanceof JsonElement) {
            return containsValue((JsonElement) value);
        }
        return false;
    }

    @Override
    public final /* bridge */ Set<Map.Entry<String, JsonElement>> entrySet() {
        return getEntries();
    }

    @Override
    public final /* bridge */  JsonElement get(Object key) {
        if (key instanceof String) {
            return get((String) key);
        }
        return null;
    }

    @Override

    public final /* bridge */ JsonElement get2(Object key) {
        if (key instanceof String) {
            return get((String) key);
        }
        return null;
    }

    @Override
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override
    public final /* bridge */ Collection<JsonElement> values() {
        return getValues();
    }

    @Override
    public boolean equals(Object other) {
        return Intrinsics.areEqual(this.content, other);
    }

    @Override
    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.content.entrySet(), ",", "{", "}", 0, null, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return JsonObject.toString$lambda$0((Map.Entry) obj);
            }
        }, 24, null);
    }

    public static final CharSequence toString$lambda$0(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "<destruct>");
        String k = (String) entry.getKey();
        JsonElement v = (JsonElement) entry.getValue();
        StringBuilder $this$toString_u24lambda_u240_u240 = new StringBuilder();
        StringOpsKt.printQuoted($this$toString_u24lambda_u240_u240, k);
        $this$toString_u24lambda_u240_u240.append(AbstractJsonLexerKt.COLON);
        $this$toString_u24lambda_u240_u240.append(v);
        return $this$toString_u24lambda_u240_u240.toString();
    }
}
