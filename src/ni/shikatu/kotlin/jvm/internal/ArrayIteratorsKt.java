package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.BooleanIterator;
import ni.shikatu.kotlin.collections.ByteIterator;
import ni.shikatu.kotlin.collections.CharIterator;
import ni.shikatu.kotlin.collections.DoubleIterator;
import ni.shikatu.kotlin.collections.FloatIterator;
import ni.shikatu.kotlin.collections.IntIterator;
import ni.shikatu.kotlin.collections.LongIterator;
import ni.shikatu.kotlin.collections.ShortIterator;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0005H\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007H\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\tH\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\rH\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000fH\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0011H\u0086\u0080\u0004¨\u0006\u0012"}, d2 = {"iterator", "Lni/shikatu/kotlin/collections/ByteIterator;", "array", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/collections/CharIterator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/collections/ShortIterator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/collections/IntIterator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/collections/LongIterator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/collections/FloatIterator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/collections/DoubleIterator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/collections/BooleanIterator;", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ArrayIteratorsKt {
    public static final ByteIterator iterator(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayByteIterator(array);
    }

    public static final CharIterator iterator(char[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayCharIterator(array);
    }

    public static final ShortIterator iterator(short[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayShortIterator(array);
    }

    public static final IntIterator iterator(int[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIntIterator(array);
    }

    public static final LongIterator iterator(long[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayLongIterator(array);
    }

    public static final FloatIterator iterator(float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayFloatIterator(array);
    }

    public static final DoubleIterator iterator(double[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayDoubleIterator(array);
    }

    public static final BooleanIterator iterator(boolean[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayBooleanIterator(array);
    }
}
