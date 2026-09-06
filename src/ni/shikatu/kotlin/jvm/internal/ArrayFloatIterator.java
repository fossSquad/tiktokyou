package ni.shikatu.kotlin.jvm.internal;

import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.FloatIterator;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\tH\u0096\u0082\u0004J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/ArrayFloatIterator;", "Lni/shikatu/kotlin/collections/FloatIterator;", "array", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([F)V", "index", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "nextFloat", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class ArrayFloatIterator extends FloatIterator {
    private final float[] array;
    private int index;

    public ArrayFloatIterator(float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.array.length;
    }

    @Override
    public float nextFloat() {
        try {
            float[] fArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return fArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
