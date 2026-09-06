package ni.shikatu.kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\bF\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0096\u0080\u0004J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0096\u0080\u0004J\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0082\u0004R\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0005\u001a\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/kotlin/sequences/TakeSequence;", "T", "Lni/shikatu/kotlin/sequences/Sequence;", "Lni/shikatu/kotlin/sequences/DropTakeSequence;", "sequence", "count", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "take", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class TakeSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    private final int count;
    private final Sequence<T> sequence;

    public TakeSequence(Sequence<? extends T> sequence, int count) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
        this.count = count;
        if (this.count >= 0) {
        } else {
            throw new IllegalArgumentException(("count must be non-negative, but was " + this.count + '.').toString());
        }
    }

    @Override
    public Sequence<T> drop(int n) {
        return n >= this.count ? SequencesKt.emptySequence() : new SubSequence(this.sequence, n, this.count);
    }

    @Override
    public Sequence<T> take(int n) {
        return n >= this.count ? this : new TakeSequence(this.sequence, n);
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u000b\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u00020\u000eH\u0096\u0082\u0004R\u001b\u0010\u0002\u001a\u00020\u0003X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"ni/shikatu/kotlin/sequences/TakeSequence$iterator$1", _UrlKt.FRAGMENT_ENCODE_SET, "left", _UrlKt.FRAGMENT_ENCODE_SET, "getLeft", "()I", "setLeft", "(I)V", "iterator", "getIterator", "()Ljava/util/Iterator;", "next", "()Ljava/lang/Object;", "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private final Iterator<T> iterator;
        private int left;

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1(TakeSequence<T> takeSequence) {
            this.left = ((TakeSequence) takeSequence).count;
            this.iterator = ((TakeSequence) takeSequence).sequence.iterator();
        }

        public final int getLeft() {
            return this.left;
        }

        public final void setLeft(int i) {
            this.left = i;
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        @Override
        public T next() {
            if (this.left == 0) {
                throw new NoSuchElementException();
            }
            this.left--;
            return this.iterator.next();
        }

        @Override
        public boolean hasNext() {
            return this.left > 0 && this.iterator.hasNext();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }
}
