package ni.shikatu.kotlin.collections;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0087\u0088\u0004b\u0002\b\t\u001a'\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u000bH\u0086\u0088\u0004¢\u0006\u0002\u0010\f\u001a1\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0011\u001a(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0081\u0080\u0004b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u001aE\u0010\u0018\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\u0081\u0080\u0004b\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017b\u0002\b\u001bb\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0019¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"orEmpty", _UrlKt.FRAGMENT_ENCODE_SET, "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "charset", "Ljava/nio/charset/Charset;", "Lni/shikatu/kotlin/internal/InlineOnly;", "toTypedArray", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/Collection;)[Ljava/lang/Object;", "arrayOfNulls", "reference", "size", _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRangeToIndexCheck", _UrlKt.FRAGMENT_ENCODE_SET, "toIndex", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "contentDeepHashCodeImpl", "contentDeepHashCode", "([Ljava/lang/Object;)I", "Lni/shikatu/kotlin/PublishedApi;", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/ArraysKt")
class ArraysKt__ArraysJVMKt {
    public static final  <T> T[] orEmpty(T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        Intrinsics.reifiedOperationMarker(0, "T");
        return (T[]) new Object[0];
    }

    private static final String toString(byte[] $this$toString, Charset charset) {
        Intrinsics.checkNotNullParameter($this$toString, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String($this$toString, charset);
    }

    public static final  <T> T[] toTypedArray(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) collection.toArray(new Object[0]);
    }

    public static final <T> T[] arrayOfNulls(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "reference");
        Object objNewInstance = Array.newInstance(tArr.getClass().getComponentType(), i);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) objNewInstance);
    }

    public static final void copyOfRangeToIndexCheck(int toIndex, int size) {
        if (toIndex > size) {
            throw new IndexOutOfBoundsException("toIndex (" + toIndex + ") is greater than size (" + size + ").");
        }
    }

    public static final <T> int contentDeepHashCode(T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }
}
