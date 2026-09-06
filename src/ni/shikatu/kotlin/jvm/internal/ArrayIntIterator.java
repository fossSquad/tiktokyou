package ni.shikatu.kotlin.jvm.internal;

import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.IntIterator;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\tH\u0096\u0082\u0004J\n\u0010\n\u001a\u00020\u0007H\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/ArrayIntIterator;", "Lni/shikatu/kotlin/collections/IntIterator;", "array", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([I)V", "index", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "nextInt", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class ArrayIntIterator extends IntIterator {
    private final int[] array;
    private int index;

    public ArrayIntIterator(int[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.array.length;
    }

    @Override
    public int nextInt() {
        try {
            int[] iArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
