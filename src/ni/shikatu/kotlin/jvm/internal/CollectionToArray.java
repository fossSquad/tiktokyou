package ni.shikatu.kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aY\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0087\u0080\u0004b\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\rb\u0016\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\t¢\u0006\u0004\b\t\u0010\n\u001ak\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0087\u0080\u0004b\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\rb\u0016\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012b\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\t¢\u0006\u0004\b\t\u0010\u0016\u001a\u007f\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00192\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u001b2(\u0010\u001c\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u001dH\u0082\u0088\u0004¢\u0006\u0002\u0010\u001e\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0003\"\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"EMPTY", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/lang/Object;", "MAX_SIZE", _UrlKt.FRAGMENT_ENCODE_SET, "collectionToArray", "collection", _UrlKt.FRAGMENT_ENCODE_SET, "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "Lni/shikatu/kotlin/Deprecated;", "message", "This function will be made internal in a future release", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "1.9", "errorSince", "2.1", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lni/shikatu/kotlin/Function0;", "alloc", "Lni/shikatu/kotlin/Function1;", "trim", "Lni/shikatu/kotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class CollectionToArray {
    private static final Object[] EMPTY = new Object[0];
    private static final int MAX_SIZE = 2147483645;

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.9")
    public static final Object[] toArray(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        int size$iv = collection.size();
        if (size$iv == 0) {
            return EMPTY;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return EMPTY;
        }
        Object[] result$iv = new Object[size$iv];
        int i$iv = 0;
        while (true) {
            i$iv++;
            result$iv[i$iv] = it.next();
            if (i$iv >= result$iv.length) {
                if (!it.hasNext()) {
                    return result$iv;
                }
                int newSize$iv = ((i$iv * 3) + 1) >>> 1;
                if (newSize$iv <= i$iv) {
                    if (i$iv >= MAX_SIZE) {
                        throw new OutOfMemoryError();
                    }
                    newSize$iv = MAX_SIZE;
                }
                Object[] objArrCopyOf = Arrays.copyOf(result$iv, newSize$iv);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                result$iv = objArrCopyOf;
            } else if (!it.hasNext()) {
                Object[] result = result$iv;
                Object[] objArrCopyOf2 = Arrays.copyOf(result, i$iv);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
                return objArrCopyOf2;
            }
        }
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.9")
    public static final Object[] toArray(Collection<?> collection, Object[] a) {
        Object[] result$iv;
        Object[] objArrCopyOf;
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (a == null) {
            throw new NullPointerException();
        }
        int size$iv = collection.size();
        if (size$iv == 0) {
            if (a.length > 0) {
                a[0] = null;
            }
        } else {
            Iterator<?> it = collection.iterator();
            if (!it.hasNext()) {
                if (a.length > 0) {
                    a[0] = null;
                }
            } else {
                if (size$iv <= a.length) {
                    result$iv = a;
                } else {
                    Object objNewInstance = Array.newInstance(a.getClass().getComponentType(), size$iv);
                    Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    result$iv = (Object[]) objNewInstance;
                }
                int i$iv = 0;
                while (true) {
                    i$iv++;
                    result$iv[i$iv] = it.next();
                    if (i$iv >= result$iv.length) {
                        if (!it.hasNext()) {
                            return result$iv;
                        }
                        int newSize$iv = ((i$iv * 3) + 1) >>> 1;
                        if (newSize$iv <= i$iv) {
                            if (i$iv >= MAX_SIZE) {
                                throw new OutOfMemoryError();
                            }
                            newSize$iv = MAX_SIZE;
                        }
                        Object[] objArrCopyOf2 = Arrays.copyOf(result$iv, newSize$iv);
                        Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
                        result$iv = objArrCopyOf2;
                    } else if (!it.hasNext()) {
                        Object[] result = result$iv;
                        if (result == a) {
                            a[i$iv] = null;
                            objArrCopyOf = a;
                        } else {
                            objArrCopyOf = Arrays.copyOf(result, i$iv);
                            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                        }
                        Object[] result$iv2 = objArrCopyOf;
                        return result$iv2;
                    }
                }
            }
        }
        return a;
    }

    private static final Object[] toArrayImpl(Collection<?> collection, Function0<Object[]> function0, Function1<? super Integer, Object[]> function1, Function2<? super Object[], ? super Integer, Object[]> function2) {
        int size = collection.size();
        if (size == 0) {
            return function0.invoke();
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return function0.invoke();
        }
        Object[] objArrInvoke = function1.invoke(Integer.valueOf(size));
        int i = 0;
        while (true) {
            i++;
            objArrInvoke[i] = it.next();
            if (i >= objArrInvoke.length) {
                if (!it.hasNext()) {
                    return objArrInvoke;
                }
                int newSize = ((i * 3) + 1) >>> 1;
                if (newSize <= i) {
                    if (i >= MAX_SIZE) {
                        throw new OutOfMemoryError();
                    }
                    newSize = MAX_SIZE;
                }
                Object[] objArrCopyOf = Arrays.copyOf((Object[]) objArrInvoke, newSize);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                objArrInvoke = objArrCopyOf;
            } else if (!it.hasNext()) {
                return function2.invoke(objArrInvoke, Integer.valueOf(i));
            }
        }
    }
}
