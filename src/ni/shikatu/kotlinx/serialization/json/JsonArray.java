package ni.shikatu.kotlinx.serialization.json;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.CollectionToArray;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.Serializable;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b\u0007\u0018\u0000 \"2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001\"B\u0017\bF\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0082\u0004J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\u0012\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0096\u0083\u0004J\u0018\u0010\u0010\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012H\u0096\u0081\u0004J\u0012\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000bH\u0096\u0083\u0004J\u0012\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0096\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0007H\u0096\u0081\u0004J\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018H\u0096\u0083\u0004J\u0012\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0096\u0081\u0004J\u0010\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001bH\u0096\u0081\u0004J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0096\u0081\u0004J \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0096\u0081\u0004R\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u00020\u000bX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonArray;", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", _UrlKt.FRAGMENT_ENCODE_SET, "content", "<init>", "(Ljava/util/List;)V", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "contains", "element", "containsAll", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "get", "index", "indexOf", "isEmpty", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "lastIndexOf", "listIterator", _UrlKt.FRAGMENT_ENCODE_SET, "subList", "fromIndex", "toIndex", "size", "getSize", "()I", "Companion", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = JsonArraySerializer.class)
public final class JsonArray extends JsonElement implements List<JsonElement>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final List<JsonElement> content;

    @Override
    public /* bridge */  void add(int i, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add2(int i, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(int i, Collection<? extends JsonElement> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends JsonElement> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        return this.content.contains(jsonElement);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.content.containsAll(collection);
    }

    @Override
    public JsonElement get(int i) {
        return this.content.get(i);
    }

    public int getSize() {
        return this.content.size();
    }

    public int indexOf(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        return this.content.indexOf(jsonElement);
    }

    @Override
    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    @Override
    public Iterator<JsonElement> iterator() {
        return this.content.iterator();
    }

    public int lastIndexOf(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        return this.content.lastIndexOf(jsonElement);
    }

    @Override
    public ListIterator<JsonElement> listIterator() {
        return this.content.listIterator();
    }

    @Override
    public ListIterator<JsonElement> listIterator(int i) {
        return this.content.listIterator(i);
    }

    @Override
    public /* bridge */  JsonElement remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override

    public JsonElement remove2(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void replaceAll(UnaryOperator<JsonElement> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public /* bridge */  JsonElement set(int i, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public JsonElement set2(int i, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void sort(Comparator<? super JsonElement> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public List<JsonElement> subList(int i, int i2) {
        return this.content.subList(i, i2);
    }

    @Override
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonArray$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlinx/serialization/json/JsonArray;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<JsonArray> serializer() {
            return JsonArraySerializer.INSTANCE;
        }
    }

    public JsonArray(List<? extends JsonElement> list) {
        super(null);
        Intrinsics.checkNotNullParameter(list, "content");
        this.content = list;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element instanceof JsonElement) {
            return contains((JsonElement) element);
        }
        return false;
    }

    @Override
    public final /* bridge */ int indexOf(Object element) {
        if (element instanceof JsonElement) {
            return indexOf((JsonElement) element);
        }
        return -1;
    }

    @Override
    public final /* bridge */ int lastIndexOf(Object element) {
        if (element instanceof JsonElement) {
            return lastIndexOf((JsonElement) element);
        }
        return -1;
    }

    @Override
    public final /* bridge */ int size() {
        return getSize();
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
        return CollectionsKt.joinToString$default(this.content, ",", "[", "]", 0, null, null, 56, null);
    }
}
